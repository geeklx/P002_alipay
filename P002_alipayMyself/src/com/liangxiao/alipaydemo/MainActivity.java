package com.liangxiao.alipaydemo;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.android.app.sdk.AliPay;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn_month;
	private Button btn_year;
	public static final String TAG = "流水账号";
	private static final int RQF_PAY = 1;
	private static final int RQF_LOGIN = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_month = (Button) findViewById(R.id.btn_month);
		btn_year = (Button) findViewById(R.id.btn_year);
		btn_month.setOnClickListener(this);
		btn_year.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btn_month) {
			StringBuilder sb = new StringBuilder();
			sb.append("partner=\"");
			sb.append(Keys.DEFAULT_PARTNER);
			sb.append("\"&out_trade_no=\"");
			// 合作者ID
			sb.append(getOutTradeNo());
			sb.append("\"&subject=\"");
			sb.append("月费会员");// 商品标题
			sb.append("\"&body=\"");
			sb.append("月费会员 30RMB/月");// 商品内容
			sb.append("\"&total_fee=\"");
			sb.append("0.01");// 多少钱
			sb.append("\"&notify_url=\"");

			// 网址需要做URL编码
			sb.append(URLEncoder
					.encode("http://notify.java.jpxx.org/index.jsp"));
			sb.append("\"&service=\"mobile.securitypay.pay");
			sb.append("\"&_input_charset=\"UTF-8");
			sb.append("\"&return_url=\"");
			sb.append(URLEncoder.encode("http://m.alipay.com"));
			sb.append("\"&payment_type=\"1");
			sb.append("\"&seller_id=\"");
			sb.append(Keys.DEFAULT_SELLER);

			// 如果show_url值为空，可不传
			// sb.append("\"&show_url=\"");
			sb.append("\"&it_b_pay=\"1m");
			sb.append("\"");

			String info = sb.toString();
			String sign = Rsa.sign(info, Keys.PRIVATE);

			sign = URLEncoder.encode(sign);
			info += "&sign=\"" + sign + "\"&" + getSignType();
			final String orderInfo = info;

			new Thread() {
				public void run() {
					AliPay aliPay = new AliPay(MainActivity.this, mHandler);
					String result = aliPay.pay(orderInfo);

					Log.i(TAG, "result = " + result);
					Message msg = new Message();
					msg.what = RQF_PAY;
					msg.obj = result;
					mHandler.sendMessage(msg);

				};
			}.start();

		} else if (v == btn_year) {

		}
	}

	private String getSignType() {
		return "sign_type=\"RSA\"";
	}

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Result result = new Result((String) msg.obj);

			switch (msg.what) {
			case RQF_PAY:
				
			case RQF_LOGIN: {
				Toast.makeText(MainActivity.this, result.getResult(),
						Toast.LENGTH_SHORT).show();

			}
				break;
			default:
				break;
			}
		};
	};

	/**
	 * 自动生成的唯一数字做为流水账号outTradeNo
	 * 
	 * @return
	 */
	private String getOutTradeNo() {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
		Date date = new Date();
		String key = format.format(date);

		java.util.Random r = new java.util.Random();
		key += r.nextInt();
		key = key.substring(0, 15);
		Log.d(TAG, "outTradeNo: " + key);
		return key;
	}

}

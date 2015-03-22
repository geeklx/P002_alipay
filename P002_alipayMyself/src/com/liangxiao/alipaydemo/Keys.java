/*
 * Copyright (C) 2010 The MobileSecurePay Project
 * All right reserved.
 * author: shiqun.shi@alipay.com
 * 
 *  提示：如何获取安全校验码和合作身份者id
 *  1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *  2.点击“商家服务”(https://b.alipay.com/order/myorder.htm)
 *  3.点击“查询合作者身份(pid)”、“查询安全校验码(key)”
 */

package com.liangxiao.alipaydemo;

//
// 请参考 Android平台安全支付服务(msp)应用开发接口(4.2 RSA算法签名)部分，并使用压缩包中的openssl RSA密钥生成工具，生成一套RSA公私钥。
// 这里签名时，只需要使用生成的RSA私钥。
// Note: 为安全起见，使用RSA私钥进行签名的操作过程，应该尽量放到商家服务器端去进行。
public final class Keys {

	// 合作身份者id，以2088开头的16位纯数字
	public static final String DEFAULT_PARTNER = "";

	// 收款支付宝账号
	public static final String DEFAULT_SELLER = "";

	// 商户私钥，自助生成
	public static final String PRIVATE = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJuRdV5yqABQlfp+rn4lGdBgF0uZ7pLw9LSbwBxBhCL/fliinnDm4vXdt2LCI+wrN6NYlsXmMfF0h74RmV0JdiLy41r3eCS4hxj6StN0cyANtdAX1xd0AI5jTkoRnrdNK32Mn6JK91LBpUZt3J4NCRBTYtzXwywiPkrRN+cy+DqPAgMBAAECgYAduy3wL/91l/Eh34Yfq52EWmj5VODoik5qGf4cKFVFjwipjeKz9xxXGtmKcUoGP7gxaqPeDIFtAPVUWO6zfjRqazKZXFBEpCutKK956YM8Ns3ZaGh3v7DrLFWqEZb6BlcMUo4C34riemlXhLifEDEKsncxy/5robfB/unCafIw8QJBAMl+TeeDzgcIAXO8tp8KKstksxrRFslEiVbSt14XH5AXr9ckHCucSozbrheFAfBeqE2p0Aw1xxXD3B73NF/Rh9cCQQDFpsWWp+WyaONmAMjJxvFVfMmM9VIyAeInbL8XAYUcsKkHYBC/7icFuEjZJlXjEOkqsw5S/3kd/JL7gvSamqwJAkBR5gKoTYyakwh0EIpyDmHiliWuiromSLNCFRfvKJrtqJMScVz55ObwZgJXEPr+xprGJnWn4Nvw3tFDzNr+7121AkAmHVjxCoOS+gMQAoq1znVvhNbhJdWp6w8Phzr6VsKym6ac03unZ2eDBNyXc3sQhIxSPaE/hCB5FeHKOqCsx7LxAkATi+HmuPirboMKa87ttjuTLdTNGIiRy5h09XtKAPL1mGLJODs1vke57xEM+hwEgKOgvFEBZJ1bU3EdtMtUR01Z";

	public static final String PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

}

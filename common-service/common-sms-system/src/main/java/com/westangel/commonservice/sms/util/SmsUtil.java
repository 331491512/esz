package com.westangel.commonservice.sms.util;

public final class SmsUtil {
	/**
	 * 产生随机六位数字（0-9）
	 */
	public static String getCaptchaNum(){
		String sRand = "";
        for (int i = 0; i < 6; i++){
        	String randChar = "";
	        randChar = String.valueOf(Math.round(Math.random() * 9));
	        sRand = sRand.concat(randChar); 
	    }
        return sRand;
	}
}

package com.westangel.common.util;

/**
 * 交易相关的公共方法
 * @author zhiyinglong
 *
 */
public class TradeUtil {

	public static int getSubscriptionFlag(int state){
		//根据状态得到subcriptionFlag
		switch(state){
		case 0:
			return -1;
		case 1:  //已支付
			return 0;
		case 2: //同意
		case 4: //服务中
			return 1;
		default:
			return -1;
		}
	}
}

package com.esuizhen.cloudservice.business.util;

import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;

public class BusinessUtil {
	public static boolean isSubscriptionWaitConfirm(int state) {
		// TODO Auto-generated method stub
		if(state==1)
			return true;
		
		return false;
	}

	public static boolean isSubscriptionValid(int state) {
		LogUtil.log.debug("------------------------------------update state============"+state);
		if(state==2 || state==4 || state==10)
			return true;
		
		return false;
	}

	public static boolean isVip(int productType) {
		// TODO Auto-generated method stub
		if(productType==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR)
			return true;
		
		return false;
	}
	
	public static boolean isVipSubscriptionFlag(int productType) {
		// TODO Auto-generated method stub
		switch (productType) {
		case Constant.Business.PRODUCT_TYPE_RICHTEXT:
		case Constant.Business.PRODUCT_TYPE_TEL:
		case Constant.Business.PRODUCT_TYPE_CLINIC:
		case Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR:
			return true;
		default:
			break;
		}
		return false;
	}
}

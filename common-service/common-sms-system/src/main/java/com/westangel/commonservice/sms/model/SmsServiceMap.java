package com.westangel.commonservice.sms.model;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.westangel.commonservice.sms.service.SmsInvoker;

@Component
public class SmsServiceMap extends HashMap<String, SmsInvoker>{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -3663291078580535473L;
}

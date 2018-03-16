package com.westangel.commonservice.sms.service;

import com.westangel.common.service.SmsInnerService;
/**
 * 
* @ClassName: SmsService 
* @Description: 短信服务 
* @author LIPENG
* @date 2015年12月21日 下午1:39:36 
*
 */
public interface SmsService extends SmsInnerService{
	boolean getSmsReport();
}

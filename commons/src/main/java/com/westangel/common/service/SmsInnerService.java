package com.westangel.common.service;

import com.westangel.common.bean.sms.CallTwoWayReq;
import com.westangel.common.bean.sms.SmsCaptchaCheckReq;
import com.westangel.common.bean.sms.SmsCaptchaGetReq;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.sms.SmsReceiptReq;
import com.westangel.common.bean.sms.SmsTemplateSendReq;

public interface SmsInnerService {
	/**
	 * 
	* @Title: sendCaptcha 
	* @Description: 发送验证码 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean sendCaptcha(SmsCaptchaGetReq req);
	
	/**
	 * 
	* @Title: checkCaptcha 
	* @Description: 校验验证码 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean checkCaptcha(SmsCaptchaCheckReq req);
	
	/**
	 * 
	* @Title: sendContent 
	* @Description: 给指定的手机号列表发送内容 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean sendContent(SmsContentSendReq req);
	
	/**
	 * 
	* @Title: sendTemplate 
	* @Description: 发送模版内容 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean sendTemplate(SmsTemplateSendReq req);
	
	/**
	 * 
	* @Title: callTwoWay 
	* @Description: 双向拨打电话 
	* @param @param req
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean callTwoWay(CallTwoWayReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getReceipt
	 * @Description:收取短信内容
	 * @return Object
	 * @date 2016年8月13日 下午2:11:03
	 */
	public Object getReceipt(SmsReceiptReq req);
}

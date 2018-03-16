package com.westangel.commonservice.sms.service;

import java.util.List;

import com.westangel.common.bean.ProductInfo;
import com.westangel.common.bean.sms.SmsReceiptReq;
import com.westangel.commonservice.sms.model.SmsTemplateMessageInfo;

/**
 * 
* @ClassName: SmsInvoker 
* @Description: 执行者接口 
* @author LIPENG
* @date 2015年12月22日 上午9:36:16 
*
 */
public interface SmsInvoker {
	/**
	 * 
	* @Title: sendCapatcha 
	* @Description: 发送验证码 
	* @param @param product
	* @param @param mobile
	* @param @param templateText    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean sendCapatcha(
			ProductInfo product, 
			String mobile, 
			String templateText);
	
	/**
	 * 
	* @Title: sendContent 
	* @Description: 群发短信 
	* @param @param mobiles
	* @param @param content
	* @param @param channel    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean sendContent(
			ProductInfo product, 
			List<String> moblies, 
			String content);

	/**
	 * 
	* @Title: sendTemplateMessage 
	* @Description: 发送模版短信 
	* @param @param mobile
	* @param @param templateMessageInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean sendTemplateMessage(
			ProductInfo product, 
			String mobile, 
			SmsTemplateMessageInfo templateMessageInfo);
	
	/**
	 * 
	* @Title: callTwoway 
	* @Description: 双向回拨 
	* @param @param product
	* @param @param from
	* @param @param to
	* @param @param serFrom
	* @param @param serTo
	* @param @param userData
	* @param @param maxCallTime
	* @param @param callbackUrl
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean callTwoway(
			ProductInfo product, 
			String from, 
			String to,
			String serFrom, 
			String serTo,
			String userData,
			String maxCallTime,
			String callbackUrl);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getReceipt
	 * @Description:接受内容获取
	 * @return Object
	 * @date 2016年8月13日 下午3:44:45
	 */
	public Object getReceipt(ProductInfo product);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getSmsSendReport
	 * @Description:发送报告获取
	 * @return void
	 * @date 2016年8月26日 上午8:52:01
	 */
	public Object getSmsSendReport(String channelName);
}

package com.westangel.commonservice.sms.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TBMsgResponse;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sms.CallTwoWayReq;
import com.westangel.common.bean.sms.SmsCaptchaCheckReq;
import com.westangel.common.bean.sms.SmsCaptchaGetReq;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.sms.SmsReceiptReq;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.excption.CommonErrorException;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.commonservice.sms.service.SmsService;

@Controller
public class SmsController {
	@Autowired
	SmsService smsService;
	
	@Autowired
	MessageSource messageSource;
	
	@Value("${to.ser.num}")
	private String toSerNum;
	
	@Value("${from.ser.num}")
	private String fromSerNum;
	
	/**
	 * 
	* @Title: SmsCaptchaGet 
	* @Description: 发送短信验证码 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/captcha/get", method=RequestMethod.GET)
	public TBMsgResponse getCaptcha(SmsCaptchaGetReq req)
	{
		TBMsgResponse msgResponse = new TBMsgResponse();
		
		try {
			smsService.sendCaptcha(req);
			msgResponse.setRespCode(ErrorMessage.SUCCESSSMSCAPTCHASEND.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESSSMSCAPTCHASEND.info, null, Locale.CHINA));
		} catch (Exception e) {
			if (e instanceof CommonErrorException) {
				CommonErrorException cex = (CommonErrorException)e;
				msgResponse.setRespCode(cex.getErrorCode());
				msgResponse.setRespMsg(cex.getMessage());
				msgResponse.setErrorDesc(cex.getErrorDescription());
			} else {
				msgResponse.setRespCode(ErrorMessage.E1600.code);
				msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.ERRORSMSCAPTCHACHECK.info, null, Locale.CHINA));
				msgResponse.setErrorDesc(e.toString());
			}
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: SmsCaptchaCheck 
	* @Description: 校验验证码 
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/captcha/check", method=RequestMethod.GET)
	public TBMsgResponse checkCaptcha(SmsCaptchaCheckReq req) {
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			smsService.checkCaptcha(req);
			msgResponse.setRespCode(ErrorMessage.SUCCESSSMSCAPTCHACHECK.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESSSMSCAPTCHACHECK.info, null, Locale.CHINA));
		} catch (Exception e) {
			if (e instanceof CommonErrorException) {
				CommonErrorException cex = (CommonErrorException)e;
				msgResponse.setRespCode(cex.getErrorCode());
				msgResponse.setRespMsg(cex.getMessage());
				msgResponse.setErrorDesc(cex.getErrorDescription());
			} else {
				msgResponse.setRespCode(ErrorMessage.E1602.code);
				msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1602.info, null, Locale.CHINA));
				msgResponse.setErrorDesc(e.toString());
			}
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: SmsContentSend 
	* @Description: 发送短信 
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/msg/content/send", method=RequestMethod.POST)
	public TBMsgResponse sendContent(@RequestBody SmsContentSendReq req)
	{
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			smsService.sendContent(req);
			msgResponse.setRespCode(ErrorMessage.SUCCESSSMSMSGSEND.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESSSMSMSGSEND.info, null, Locale.CHINA));			
		} catch (Exception e) {
			if (e instanceof CommonErrorException) {
				CommonErrorException cex = (CommonErrorException)e;
				msgResponse.setRespCode(cex.getErrorCode());
				msgResponse.setRespMsg(cex.getMessage());
				msgResponse.setErrorDesc(cex.getErrorDescription());
			} else {
				msgResponse.setRespCode(ErrorMessage.E1604.code);
				msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1604.info, null, Locale.CHINA));
				msgResponse.setErrorDesc(e.toString());
			}
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: sendTemplate 
	* @Description: 发送模版短信 
	* @param @param req
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/msg/template/send", method=RequestMethod.POST)
	public TBMsgResponse sendTemplate(@RequestBody SmsTemplateSendReq req)
	{
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			smsService.sendTemplate(req);
			msgResponse.setRespCode(ErrorMessage.SUCCESSSMSTEMPLATESEND.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESSSMSTEMPLATESEND.info, null, Locale.CHINA));			
		} catch (Exception e) {
			if (e instanceof CommonErrorException) {
				CommonErrorException cex = (CommonErrorException)e;
				msgResponse.setRespCode(cex.getErrorCode());
				msgResponse.setRespMsg(cex.getMessage());
				msgResponse.setErrorDesc(cex.getErrorDescription());
			} else {
				msgResponse.setRespCode(ErrorMessage.E1605.code);
				msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1605.info, null, Locale.CHINA));
				msgResponse.setErrorDesc(e.toString());
			}
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: callTwoway 
	* @Description: 双向回拨 
	* @param @param req
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/call/twoway", method=RequestMethod.POST)
	public TBMsgResponse callTwoway(@RequestBody CallTwoWayReq req)
	{
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			req.setToSerNum(toSerNum);
			req.setFromSerNum(fromSerNum);
			smsService.callTwoWay(req);
			msgResponse.setRespCode(ErrorMessage.SUCCESSCALL.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESSCALL.info, null, Locale.CHINA));			
		} catch (Exception e) {
			if (e instanceof CommonErrorException) {
				CommonErrorException cex = (CommonErrorException)e;
				msgResponse.setRespCode(cex.getErrorCode());
				msgResponse.setRespMsg(cex.getMessage());
				msgResponse.setErrorDesc(cex.getErrorDescription());
			} else {
				msgResponse.setRespCode(ErrorMessage.E1606.code);
				msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1606.info, null, Locale.CHINA));
				msgResponse.setErrorDesc(e.toString());
			}
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: SmsCaptchaGet 
	* @Description: 获取短信
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/receipt/content/get", method=RequestMethod.GET)
	public TMsgResponse<Object> getReceipt(SmsReceiptReq req,Locale locale)
	{
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = smsService.getReceipt(req);
		}catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getSendReport
	 * @Description:短信发送状态报告获取
	 * @return TMsgResponse<Object>
	 * @date 2016年8月29日 下午4:06:14
	 */
	@ResponseBody
	@RequestMapping(value="/send/report/get", method=RequestMethod.GET)
	public TMsgResponse<Object> getSendReport(SmsReceiptReq req,Locale locale)
	{
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = smsService.getSmsReport();
		}catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		}catch(Exception e){
			e.printStackTrace();
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
}

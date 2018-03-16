package com.esuizhen.cloudservice.followup.controller.followup;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.TWXFollowupMessageInfo;
import com.esuizhen.cloudservice.followup.bean.WXFollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.WXFollowupSendReq;
import com.esuizhen.cloudservice.followup.bean.WXFollowupTemplateReq;
import com.esuizhen.cloudservice.followup.service.followup.FollowupService;
import com.esuizhen.cloudservice.followup.service.followup.FollowupWXService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/**
 * 
* @ClassName: FollowupWXTemplateController 
* @Description: 微信模版相关接口调用
* @author lichenghao
* @date 2016年7月18日 下午5:36:03
 */
@Controller
public class FollowupWXController
{
	/**
	 * 随访接口
	 */
	@Autowired
	private FollowupService followupService; 
	@Autowired
	private FollowupWXService followupWXService; 
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateWXFollowupTemplate
	 * @Description:更新随访提醒模版
	 * @return TMsgResponse<String>
	 * @date 2016年7月19日 上午10:34:22
	 */
	@ResponseBody
	@RequestMapping(value="/wx/template/update" , method=RequestMethod.POST)
	public TMsgResponse<String> updateWXFollowupTemplate(@RequestBody WXFollowupTemplateReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//模版更新
			followupWXService.updateWXFollowupTemplate(req);
		}catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendWXFollowupMessage
	 * @Description:微信随访云端下发
	 * @return TMsgResponse<String>
	 * @date 2016年7月19日 上午10:34:57
	 */
	@ResponseBody
	@RequestMapping(value="/wx/template/message/send" , method=RequestMethod.POST)
	public TMsgResponse<String> sendWXFollowupMessage(@RequestBody WXFollowupSendReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//模版更新
			followupWXService.sendWXFollowupMessage(req);
		}catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getWXFollowupMessage
	 * @Description:微信随访消息基本信息获取
	 * @return TMsgResponse<TWXFollowupMessageInfo>
	 * @date 2016年7月19日 下午2:08:38
	 */
	@ResponseBody
	@RequestMapping(value="/wx/message/get" , method=RequestMethod.GET)
	public TMsgResponse<TWXFollowupMessageInfo> getWXFollowupMessage(WXFollowupSendReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TWXFollowupMessageInfo> msg = new TMsgResponse<TWXFollowupMessageInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//模版更新
			msg.result = followupWXService.getWXFollowupMessage(req);
		}catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :createWXFollowupResult
	 * @Description:微信随访结果提交
	 * @return TMsgResponse<String>
	 * @date 2016年7月19日 下午2:09:20
	 */
	@ResponseBody
	@RequestMapping(value="/wx/result/submit" , method=RequestMethod.POST)
	public TMsgResponse<String> createWXFollowupResult(@RequestBody WXFollowupResultReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//模版更新
			followupWXService.createWXFollowupResult(req);
		}catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	
}

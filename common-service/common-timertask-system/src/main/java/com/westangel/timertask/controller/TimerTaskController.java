package com.westangel.timertask.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.TimertaskService;

@Controller
public class TimerTaskController {
	
	@Autowired
	MessageSource messageSource;
	@Autowired
	TimertaskService timertaskService;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getCaptcha
	 * @Description:定时任务创建
	 * @return TMsgResponse<String>
	 * @date 2016年8月26日 下午3:30:20
	 */
	@ResponseBody
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public TMsgResponse<String> getCaptcha(@RequestBody Timertask timertask,Locale locale)
	{
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Integer code = timertaskService.createTimetask(timertask);
			if(code!=0)
				throw new Exception();
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/push/test", method=RequestMethod.GET)
	public TMsgResponse<String> testPush(Long pushRuleId,Locale locale)
	{
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try 
		{
			timertaskService.testPush(pushRuleId);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
}

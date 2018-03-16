package com.westangel.commonservice.push.controller;

import java.util.List;
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
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.push.model.EventInfoHistory;
import com.westangel.commonservice.push.service.EventInfoHistoryService;

@Controller
public class EventInfoHistoryController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private EventInfoHistoryService eventInfoHistoryService; 
	
	@ResponseBody
	@RequestMapping(value="/eventinfo/pull" , method=RequestMethod.GET)
	public TMsgResponse<List<EventInfoHistory>> eventinfoPull(Integer businessId , Integer productId , Long  userId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<EventInfoHistory>> msg = new TMsgResponse<List<EventInfoHistory>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			
			msg.result = eventInfoHistoryService.eventinfoPull(businessId,productId,userId);
			if(msg.result==null || msg.result.size()<1)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public TMsgResponse<String> create(@RequestBody EventInfoHistory eventInfoHistory , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			eventInfoHistoryService.insertEventInfoHistory(eventInfoHistory);
			
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


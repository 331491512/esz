package com.esuizhen.cloudservice.research.controller.crf;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.crf.CrfObservationLeafElementOptions;
import com.esuizhen.cloudservice.research.service.crf.CrfLeafElementOptionsService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
@RequestMapping("/")
public class CrfObservationLeafElementOptionsController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CrfLeafElementOptionsService crfObservationLeafElementOptionsService; 
	
	@ResponseBody
//	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public TMsgResponse<String> create(@RequestBody CrfObservationLeafElementOptions crfObservationLeafElementOptions , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfObservationLeafElementOptionsService.insertCrfObservationLeafElementOptions(crfObservationLeafElementOptions);
			
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
//	@RequestMapping(value="/query" , method=RequestMethod.GET)
	public TMsgResponse<CrfObservationLeafElementOptions> query(Long crfObservationLeafElementOptionsId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<CrfObservationLeafElementOptions> msg = new TMsgResponse<CrfObservationLeafElementOptions>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfObservationLeafElementOptionsService.queryCrfObservationLeafElementOptions(crfObservationLeafElementOptionsId);
			
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
//	@RequestMapping(value="/delete" , method=RequestMethod.GET)
	public TMsgResponse<String> delete(Long crfObservationLeafElementOptionsId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除
			crfObservationLeafElementOptionsService.deleteCrfObservationLeafElementOptions(crfObservationLeafElementOptionsId);
			
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
//	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public TMsgResponse<String> update(@RequestBody CrfObservationLeafElementOptions crfObservationLeafElementOptions , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改
			crfObservationLeafElementOptionsService.updateCrfObservationLeafElementOptions(crfObservationLeafElementOptions);
			
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


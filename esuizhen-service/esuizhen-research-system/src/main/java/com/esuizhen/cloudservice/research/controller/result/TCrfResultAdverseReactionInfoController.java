package com.esuizhen.cloudservice.research.controller.result;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.result.TCrfResultAdverseReactionInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultAdverseReactionInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfResultAdverseReactionInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfResultAdverseReactionInfoService crfResultAdverseReactionInfoService; 
	
	@ResponseBody
	@RequestMapping(value="/crf/result/adverse/reaction/query" , method=RequestMethod.GET)
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>> queryCrfResultAdverseReaction(String crfObserveId , Long patientId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>> msg = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfResultAdverseReactionInfoService.queryCrfResultAdverseReaction(crfObserveId,patientId);
			
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/crf/result/adverse/reaction/save" , method=RequestMethod.POST)
	public TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>>> saveCrfResultAdverseReaction(@RequestBody TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>> crfResultMainInfo , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>>> msg = new TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfResultAdverseReactionInfoService.saveCrfResultAdverseReaction(crfResultMainInfo);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/crf/result/adverse/reaction/record/query" , method=RequestMethod.GET)
	public TMsgResponse<Page<TCrfResultAdverseReactionInfo>> queryCrfResultAdverseReactionRecord(Locale locale, String projectId, Long patientId, Integer page, Integer num)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TCrfResultAdverseReactionInfo>> msg = new TMsgResponse<Page<TCrfResultAdverseReactionInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfResultAdverseReactionInfoService.queryCrfResultAdverseReactionRecord(projectId,patientId, page, num);
			
			if(msg.result==null || msg.getResult().getDataList() == null || msg.result.getDataList().size()<1)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}


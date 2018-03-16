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

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultQualityoflifeInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultQualityoflifeInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfResultQualityoflifeInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfResultQualityoflifeInfoService crfResultQualityoflifeService; 
	
	@ResponseBody
	@RequestMapping(value="/crf/result/qualityoflife/query" , method=RequestMethod.GET)
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>>> queryCrfResultQualityoflife(String crfObserveId , Long patientId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>>> msg = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfResultQualityoflifeService.queryCrfResultQualityoflife(crfObserveId,patientId);
			
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
	@RequestMapping(value="/crf/result/qualityoflife/save" , method=RequestMethod.POST)
	public TMsgResponse<Void> saveCrfResultQualityoflife (@RequestBody TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>> crfResultMainInfo, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Void> msg = new TMsgResponse<Void>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			crfResultQualityoflifeService.saveCrfResultQualityoflife(crfResultMainInfo);
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
	@RequestMapping(value="/crf/result/qualityoflife/record/query" , method=RequestMethod.GET)
	public TMsgResponse<Page<TCrfResultQualityoflifeInfo>> queryCrfResultQualityoflifeRecord(String projectId, Long patientId, Integer page, Integer num, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TCrfResultQualityoflifeInfo>> msg = new TMsgResponse<Page<TCrfResultQualityoflifeInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfResultQualityoflifeService.queryCrfResultQualityoflifeRecord(projectId,patientId, page, num);
			
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


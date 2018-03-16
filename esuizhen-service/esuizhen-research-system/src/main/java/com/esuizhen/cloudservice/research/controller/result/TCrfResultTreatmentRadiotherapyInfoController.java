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
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentRadiotherapyInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentRadiotherapyInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfResultTreatmentRadiotherapyInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfResultTreatmentRadiotherapyInfoService crfResultTreatmentRadiotherapyInfoService; 
	
	@ResponseBody
	@RequestMapping(value="/crf/result/treatment/radiotherapy/query" , method=RequestMethod.GET)
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>>> queryCrfResultTreatmentRadiotherapy (String crfObserveId , Long patientId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>>> msg = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfResultTreatmentRadiotherapyInfoService.queryCrfResultTreatmentRadiotherapy(crfObserveId,patientId);
			
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
	@RequestMapping(value="/crf/result/treatment/radiotherapy/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfResultTreatmentRadiotherapy (@RequestBody TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>> crfResultMainInfo  , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfResultTreatmentRadiotherapyInfoService.saveCrfResultTreatmentRadiotherapy(crfResultMainInfo);
			
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


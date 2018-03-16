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
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentOtherInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentOtherInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfResultTreatmentOtherInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfResultTreatmentOtherInfoService crfResultTreatmentOtherInfoService; 
	
	@ResponseBody
	@RequestMapping(value="/crf/result/treatment/other/query" , method=RequestMethod.GET)
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>> queryCrfResultTreatmentOther(String crfObserveId , Long patientId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>> msg = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfResultTreatmentOtherInfoService.queryCrfResultTreatmentOther(crfObserveId,patientId);
			
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
	@RequestMapping(value="/crf/result/treatment/other/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfResultTreatmentOther(@RequestBody TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>  crfResultMainInfo , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfResultTreatmentOtherInfoService.saveCrfResultTreatmentOther(crfResultMainInfo);
			
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
	@RequestMapping(value="/crf/result/treatment/medication/record/query" , method=RequestMethod.GET)
	public TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>>> queryCrfResultTreatmentMedicationRecord(String projectId, Long patientId, Integer page, Integer num, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>>> msg = new TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfResultTreatmentOtherInfoService.queryCrfResultTreatmentMedication(projectId,patientId, page, num);
			
			if(msg.result==null || msg.result.getDataList() == null || msg.result.getDataList().size()<1)
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


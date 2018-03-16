package com.esuizhen.cloudservice.research.controller.crf;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptom;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfSymptomInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: CrfObservationClinicSymptomOptionsController 
* @Description: 症状配置处理器
* @author wang_hw
* @date 2016年4月5日 下午8:28:27
 */
@Controller
public class TCrfSymptomInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfSymptomInfoService crfObservationClinicSymptomOptionsService; 
	
	@ResponseBody
	@RequestMapping(value="/crf/symptoms/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfSymptoms(@RequestBody TCrfSymptom crfSymptom , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfObservationClinicSymptomOptionsService.saveCrfSymptoms(crfSymptom);
			
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
	@RequestMapping(value="/crf/symptoms/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TCrfSymptomInfo>> queryCrfSymptoms(String crfObserveId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfSymptomInfo>> msg = new TMsgResponse<List<TCrfSymptomInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfObservationClinicSymptomOptionsService.queryCrfSymptoms(crfObserveId);
			
			if(msg.result==null || msg.result.size()<1)
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


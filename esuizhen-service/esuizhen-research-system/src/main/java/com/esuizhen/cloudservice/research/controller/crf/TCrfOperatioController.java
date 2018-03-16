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

import com.esuizhen.cloudservice.research.model.crf.TCrfOperation;
import com.esuizhen.cloudservice.research.model.crf.TCrfOperationInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfOperationService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: TCrfOperatioController 
* @Description: CRF观察项-手术处理器
* @author wang_hw
* @date 2016年4月20日 下午3:46:20
 */
@Controller
public class TCrfOperatioController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfOperationService crfOperationService; 
	
	/**
	 * @author wang_hw
	 * @title :queryCrfTreatmentOperation
	 * @Description:CRF观察项-手术查看
	 * @return TMsgResponse<List<TCrfOperationInfo>>
	 * @date 2016年4月20日 下午3:43:00
	 */
	@ResponseBody
	@RequestMapping(value="/crf/treatment/operation/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TCrfOperationInfo>> queryCrfTreatmentOperation(String crfObserveId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfOperationInfo>> msg = new TMsgResponse<List<TCrfOperationInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfOperationService.queryCrfTreatmentOperation(crfObserveId);
			
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
	
	/**
	 * @author wang_hw
	 * @title :saveCrfTreatmentOperation
	 * @Description:CRF观察项-手术设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月20日 下午3:43:06
	 */
	@ResponseBody
	@RequestMapping(value="/crf/treatment/operation/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfTreatmentOperation(@RequestBody TCrfOperation crfOperation , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfOperationService.saveCrfTreatmentOperation(crfOperation);
			
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


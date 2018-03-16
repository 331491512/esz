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

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcm;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcmInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfSymptomTcmService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: TCrfSymptomTcmController 
* @Description: 观察项-症状信息（中医）控制器
* @author wang_hw
* @date 2016年4月14日 下午3:31:50
 */
@Controller
public class TCrfSymptomTcmController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfSymptomTcmService crfSymptomTcmService; 
	
	/**
	 * @author wang_hw
	 * @title :saveCrfSymptomsTcm
	 * @Description:观察项-症状信息（中医）设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月14日 上午11:40:55
	 */
	@ResponseBody
	@RequestMapping(value="/crf/symptoms/tcm/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfSymptomsTcm(@RequestBody TCrfSymptomTcm crfSymptomTcm , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfSymptomTcmService.saveCrfSymptomsTcm(crfSymptomTcm);
			
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
	 * @title :queryCrfSymptomsTcm 
	 * @Description:观察项-症状信息（中医）查看
	 * @return TMsgResponse<TCrfSymptomTcmInfo>
	 * @date 2016年4月14日 上午11:43:07
	 */
	@ResponseBody
	@RequestMapping(value="/crf/symptoms/tcm/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TCrfSymptomTcmInfo>> queryCrfSymptomsTcm (String crfObserveId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfSymptomTcmInfo>> msg = new TMsgResponse<List<TCrfSymptomTcmInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfSymptomTcmService.queryCrfSymptomsTcm(crfObserveId);
			
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


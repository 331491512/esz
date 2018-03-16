package com.esuizhen.cloudservice.timertask.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.timertask.service.TimerTaskFactoryService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: TimertaskFactoryController 
* @Description: 定时任务工厂控制器
* @author wang_hw
* @date 2016年1月22日 下午3:23:35
 */
@Controller
public class TimertaskFactoryController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TimerTaskFactoryService timerTaskFactoryService; 
	
	/**
	 * @author wang_hw
	 * @title :createTelconsultTimer
	 * @Description:电话咨询监控任务工厂
	 * @return TMsgResponse<String>
	 * @date 2016年1月22日 下午3:24:23
	 */
	@ResponseBody
	@RequestMapping(value="/telconsult/timer/create" , method=RequestMethod.GET)
	public TMsgResponse<String> createTelconsultTimer(String productApplyId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建电话咨询任务
			timerTaskFactoryService.createTelconsultTimer(productApplyId);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :createGeneralserviceTimer
	 * @Description:一般业务超时监控任务工厂
	 * @return TMsgResponse<String>
	 * @date 2016年1月22日 下午3:24:56
	 */
	@ResponseBody
	@RequestMapping(value="/generalservice/timer/create" , method=RequestMethod.GET)
	public TMsgResponse<String> createGeneralserviceTimer(String productApplyId , Integer productType , String taskTag , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建一般业务数据工厂
			timerTaskFactoryService.createGeneralserviceTimer(productApplyId , productType , taskTag);
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


package com.esuizhen.cloudservice.ehr.controller.patientinfo;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.PatientInfoReq;
import com.esuizhen.cloudservice.ehr.service.patientinfo.TPatientInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TPatientInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TPatientInfoService patientInfoService; 
	
	@ResponseBody
	@RequestMapping(value="/patient/profile/query" , method=RequestMethod.GET)
	public TMsgResponse<Page> queryPatientProfile(String patientNo , String trueName , Integer page , Integer num , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			if(patientNo==null && trueName==null)
			{//如果入参都为空返回数据格式错误
				msg.respCode=ErrorMessage.E1410.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1410.info, null, locale);
			}else
			{//如果不为空执行查询操作
				
				msg.result = patientInfoService.queryPatientProfile(patientNo,trueName,page,num);
				
				//返回参数设置
				if(msg.result==null || msg.result.getCurrSize()==0)
				{
					msg.respCode=ErrorMessage.E1404.code;
					msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
				}
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
	 * 患者就诊信息列表查询
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/visit/info/query" , method=RequestMethod.POST)
	public TMsgResponse<Page<Map<String, Object>>> queryPatientVisitInfo(@RequestBody PatientInfoReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<Map<String, Object>>> msg = new TMsgResponse<Page<Map<String, Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = patientInfoService.queryPatientVisitInfo(req);
			//返回参数设置
			if(msg.result==null || msg.result.getCurrSize()==0)
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
	@RequestMapping(value="/patient/visit/info/lastest/query" , method=RequestMethod.POST)
	public TMsgResponse<TInhospitalDetailInfo> queryPatientVisitInfoLastest(@RequestBody CommonReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TInhospitalDetailInfo> msg = new TMsgResponse<TInhospitalDetailInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = patientInfoService.queryPatientVisitInfoLastest(req);
			
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
}


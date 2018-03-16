package com.esuizhen.cloudservice.ehr.controller.treatment;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;
import com.esuizhen.cloudservice.ehr.service.treatment.PatientSurgeryService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientSurgeryController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PatientSurgeryService patientSurgeryService; 
	
	@ResponseBody
	@RequestMapping(value="/patient/surgery/query" , method=RequestMethod.POST)
	public TMsgResponse<List<TPatientSurgeryInfo>> queryPatientSurgery(@RequestBody CommonReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TPatientSurgeryInfo>> msg = new TMsgResponse<List<TPatientSurgeryInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = patientSurgeryService.queryPatientSurgeryInfoByInHospitalId(req);
			
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
	@RequestMapping(value="/patient/surgery/save" , method=RequestMethod.POST)
	public TMsgResponse<String> savePatientSurgery(@RequestBody TInhospitallSurgeryMsg<TPatientSurgeryInfo> inhospitalSurgeryMsg, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			patientSurgeryService.savePatientSurgeryInfo(inhospitalSurgeryMsg);
			
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


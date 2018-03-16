package com.esuizhen.cloudservice.ehr.controller.surgeryintensivecare;

import java.util.List; 
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.service.surgeryintensivecare.PatientSurgeryIntensiveCareService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientSurgeryIntensiveCareController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PatientSurgeryIntensiveCareService patientSurgeryIntensiveCareService; 
	
	@ResponseBody
	@RequestMapping(value="/patient/surgery/intensive/care/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TPatientSurgeryIntensiveCareInfo>> queryPatientSurgeryIntensiveCare(String inhospitalId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TPatientSurgeryIntensiveCareInfo>> msg = new TMsgResponse<List<TPatientSurgeryIntensiveCareInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = patientSurgeryIntensiveCareService.queryPatientSurgeryIntensiveCareInfoByInHospitalId(inhospitalId);
			
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
	@RequestMapping(value="/patient/surgery/intensive/care/save" , method=RequestMethod.POST)
	public TMsgResponse<String> savePatientSurgeryIntensiveCare(@RequestBody TInhospitallSurgeryMsg<TPatientSurgeryIntensiveCareInfo> inhospitalSurgeryMsg, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			patientSurgeryIntensiveCareService.savePatientSurgeryIntensiveCareInfo(inhospitalSurgeryMsg);
			
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


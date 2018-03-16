package com.esuizhen.cloudservice.ehr.controller.symptom;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.esuizhen.cloudservice.ehr.service.symptom.SymptomService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class SymptomController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SymptomService symptomService;
	
	@ResponseBody
	@RequestMapping(value="/patient/symptom/list",method=RequestMethod.GET)
	public TMsgResponse<List<PatientSymptomInfo>> patientSymptomList(Long patientId,String inhospitalId,String clinicMedicalId,String symptomName,Locale locale){
		TMsgResponse<List<PatientSymptomInfo>> msg = new TMsgResponse<List<PatientSymptomInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			Map<String,Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("patientId", patientId);
			paramsMap.put("inhospitalId", inhospitalId);
			paramsMap.put("clinicMedicalId", clinicMedicalId);
			paramsMap.put("symptomName", symptomName);
			msg.result = symptomService.patientSymptomList(paramsMap);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/patient/symptom/save",method=RequestMethod.POST)
	public TMsgResponse<String> savePatientSymptom(@RequestBody List<PatientSymptomInfo> patientSymptom,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			symptomService.savePatientSymptom(patientSymptom);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
}

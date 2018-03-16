package com.esuizhen.cloudservice.ehr.controller.doctor;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.ConsultDoctorsOfPatientGetReq;
import com.esuizhen.cloudservice.ehr.bean.TConsultDoctorDetailResp;
import com.esuizhen.cloudservice.ehr.service.doctor.DoctorService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class DoctorController{

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private DoctorService doctorService;
	
	@ResponseBody
	@RequestMapping("/doctor/consult/ofpatient/get")
	public TMsgResponse<TConsultDoctorDetailResp> getConsultDoctorOfPatient(@RequestBody ConsultDoctorsOfPatientGetReq req,Locale locale) {
		//设置返回成功代码及提示消息
		TMsgResponse<TConsultDoctorDetailResp> msg = new TMsgResponse<TConsultDoctorDetailResp>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = this.doctorService.getConsultDoctorDetailOfPatient(req);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

}


package com.esuizhen.cloudservice.ehr.controller.posttreatment;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentReq;
import com.esuizhen.cloudservice.ehr.bean.TTreatmentInfo;
import com.esuizhen.cloudservice.ehr.service.posttreatment.impl.PastTreatmentServiceImpl;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class PastTreatmentController {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PastTreatmentServiceImpl pastTreatmentService;
	
	/**
	 * 获取患者既往治疗信息
	 * @author lichenghao
	 * @title :getPatientPastTreatmentList
	 * @Description:TODO
	 * @return TMsgResponse<Page<TTreatmentInfo>>
	 * @date 2016年5月24日 下午3:30:59
	 */
	@ResponseBody
	@RequestMapping(value="/patient/past/treatment/list",method=RequestMethod.GET)
	public TMsgResponse<Page<TTreatmentInfo>> getPatientPastTreatmentList (PatientPastTreatmentListReq req,Locale locale){
		TMsgResponse<Page<TTreatmentInfo>> msg = new TMsgResponse<Page<TTreatmentInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result = pastTreatmentService.getPatientPastTreatmentList(req);
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
	
	/**
	 * 新增既往治疗信息
	 * @author lichenghao
	 * @title :addPatientPastTreatment
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月24日 下午5:30:41
	 */
	@ResponseBody
	@RequestMapping(value="/patient/past/treatment/add",method=RequestMethod.POST)
	public TMsgResponse<String> addPatientPastTreatment (@RequestBody PatientPastTreatmentReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			pastTreatmentService.addPatientPastTreatment(req);
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
	
	/**
	 * 修改既往治疗
	 * @author lichenghao
	 * @title :modifyPatientPastTreatment
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月24日 下午5:57:39
	 */
	@ResponseBody
	@RequestMapping(value="/patient/past/treatment/modify",method=RequestMethod.POST)
	public TMsgResponse<String> modifyPatientPastTreatment (@RequestBody PatientPastTreatmentReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			pastTreatmentService.modifyPatientPastTreatment(req);
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
	@RequestMapping(value="/patient/past/treatment/delete",method=RequestMethod.POST)
	public TMsgResponse<String> delPatientBasicResultPastmedical(@RequestBody PatientPastTreatmentReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			pastTreatmentService.delPatientPastTreatment(req);
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

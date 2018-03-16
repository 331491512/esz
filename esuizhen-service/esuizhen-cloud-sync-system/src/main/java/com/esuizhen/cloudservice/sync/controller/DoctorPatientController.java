/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月8日-下午2:11:17<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.DoctorPatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: DoctorController 
* @Description: 医患关系相关业务控制类
* @author YYCHEN
* @date 2016年2月16日 下午2:11:17  
*/
@Controller
public class DoctorPatientController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private DoctorPatientService doctorPatientService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	/**
	   { 
		"patientUuid":"350000es34n6i3n790djjde33s",
		"doctorUuid":"350000es34n6i3n790djjdhy3s", 
		"hospitalId":15
		"source":3
	   }
	 * @param locale
	 * @param hospitalUuid
	 * @param doctorUuid
	 * @param patientUuid
	 * @param source
	 * @return
	 */
	@RequestMapping(value = "/tocloud/user/relation/patient/ofdoctor", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> syncPatientOfDoctorRelation(Locale locale, @RequestBody DoctorPatient doctorPatient) {
		LogUtil.log.info("syncPatientOfDoctorRelation()==========>>>>>>>>>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.doctorPatientService.syncPatientOfDoctorRelation(doctorPatient);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=doctorPatient==null?"calling method syncPatientOfDoctorRelation;paramater:doctorPatient is null":"云端未开启三通的医院Id:"+doctorPatient.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			//tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			//tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("syncPatientOfDoctorRelation()==========<<<<<<<<<<");
		return tMsgResponse;
	}

}

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

import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncReviewRecord;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.SurgeryNoteService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: DoctorController 
* @Description: 患者手术信息同步相关业务控制类
* @author YYCHEN
* @date 2016年2月18日 下午16:57:17  
*/
@Controller
public class SurgeryNoteController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private SurgeryNoteService surgeryNoteService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	/**
	 * 
	 * @param locale
	 * @param inhospitalInfo
	 * @return
	 */
	@RequestMapping(value = "/tocloud/emr/surgerynote", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<MedicalRecord> syncSurgery(Locale locale, @RequestBody TPatientSurgeryNoteDetailInfo surgeryInfo) {
		LogUtil.log.info("syncSurgery()==========>>>>>>>>>>");
		TMsgResponse<MedicalRecord> tMsgResponse = new TMsgResponse<MedicalRecord>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			MedicalRecord medicalRecord = this.surgeryNoteService.syncSurgery(surgeryInfo);
			tMsgResponse.setResult(medicalRecord);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=surgeryInfo==null?"calling method syncSurgery;surgeryInfo is null":"云端未开启三通的医院Id:"+surgeryInfo.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("syncSurgery()==========<<<<<<<<<<");
		return tMsgResponse;
	}

}

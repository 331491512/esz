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

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.ClinicMedicalNoteService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:ClinicMedicalController</p>
 * <p>Description:患者门诊信息业务控制类</p>
 * @author YYCHEN
 * @date 2016年9月7日 上午11:43:18
 */
@Controller
public class ClinicMedicalNoteController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private ClinicMedicalNoteService clinicMedicalService;
	/**
	 * <p>Title:syncClinicMedicalInfo</p>
	 * <p>Description:同步患者门诊信息</p>
	 * @author YYCHEN
	 * @date 2016年9月7日 上午11:45:17
	 * @param locale
	 * @param clinicMedicalInfo
	 * @return
	 */
	@RequestMapping(value = "/tocloud/emr/clinic/medical/sync", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<MedicalRecord> syncClinicMedicalInfo(Locale locale, @RequestBody TClinicMedicalNoteInfo clinicMedicalNoteInfo) {
		LogUtil.log.info("Synchronous clinic medical information, syncClinicMedicalInfo()==========>>>>>>>>>>");
		TMsgResponse<MedicalRecord> tMsgResponse = new TMsgResponse<MedicalRecord>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.clinicMedicalService.syncClinicMedicalInfo(clinicMedicalNoteInfo));
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=clinicMedicalNoteInfo==null?"calling Method:syncClinicMedicalInfo,parameter：clinicMedicalNoteInfo is null":"云端未开启三通的医院Id:"+clinicMedicalNoteInfo.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		}catch (RejectRequestExcption ex){
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
		LogUtil.log.info("Synchronous clinic medical information complete!, syncClinicMedicalInfo()==========<<<<<<<<<<");
		return tMsgResponse;
	}
}

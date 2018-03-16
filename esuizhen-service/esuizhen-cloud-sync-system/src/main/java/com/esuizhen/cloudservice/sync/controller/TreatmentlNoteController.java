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

import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.TreatmentNoteService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

/**
 * <p>TreatmentlNoteController</p>
 * <p>Description:同步治疗表</p>
 * @author fanpanwei
 * @date 2016年9月7日 上午11:43:18
 */
@Controller
public class TreatmentlNoteController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TreatmentNoteService treatmentNoteService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	/**
	 * <p>Title:syncOutHospitalInfo</p>
	 * <p>Description:同步出院小结表</p>
	 * @author fanpanwei 
	 * @date 2016年9月7日 上午11:45:17
	 * @param locale
	 * @param OutHospitalInfo
	 * @return
	 */
	@RequestMapping(value = "/tocloud/emr/treatment", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<?> syncInfo(Locale locale, @RequestBody EciTreatmentNote treatmentNoteInfo) {
		LogUtil.log.info("Synchronous  information, syncTreatmentNote()==========>>>>>>>>>>");
		TMsgResponse<?> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.treatmentNoteService.syncTreatmentNote(treatmentNoteInfo);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=treatmentNoteInfo==null?"calling method syncInfo;treatmentNoteInfo is null":"云端未开启三通的医院Id:"+treatmentNoteInfo.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (RejectRequestExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}catch (EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous  information complete!, syncOutHospitalInfo()==========<<<<<<<<<<");
		return tMsgResponse;
	}
}

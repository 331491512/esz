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

import java.util.List; 
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.bean.PacAndLisResp;
import com.esuizhen.cloudservice.sync.bean.TDetectionReportSync;
import com.esuizhen.cloudservice.sync.bean.TExamReportSync;
import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.DiagnosisInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: DoctorController 
* @Description: 患者诊断信息同步相关业务控制类
* @author YYCHEN
* @date 2016年2月18日 下午16:11:17  
*/
@Controller
public class DiagnosisInfoController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private DiagnosisInfoService diagnosisInfoService;
	
	/**
	 * 
	 * @param locale
	 * @param diagnosisNoteDetailInfo
	 * @return
	 */
	@RequestMapping(value = "/tocloud/emr/diagnosisnote", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<MedicalRecord> syncDiagnosisNote(Locale locale, @RequestBody TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo) {
		LogUtil.log.info("Synchronous disease diagnostic information, syncDiagnosis()==========>>>>>>>>>>");
		TMsgResponse<MedicalRecord> tMsgResponse = new TMsgResponse<MedicalRecord>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		if (diagnosisNoteDetailInfo == null) {
			LogUtil.log.info("Parameter is empty! syncDiagnosis()==========<<<<<<<<<<");
			return tMsgResponse;
		}
		try {
			tMsgResponse.setResult(this.diagnosisInfoService.syncDiagnosisInfo(diagnosisNoteDetailInfo));
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg="云端未开启三通的医院Id:"+diagnosisNoteDetailInfo.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous disease diagnostic information complete!, syncDiagnosis()==========<<<<<<<<<<");
		return tMsgResponse;
	}

	/**
	 * [{
			"examReportId	":"1",
			"patientId	":1,
			"patientName":	"张三",
			"patientNo":"123",
			"patientIdno":	"123",
			"patientAddress":"北京市海淀区",
			"patientMobile":"13600000000",
			"patientSex":1,
			"outPatientFlag	":1,
			"hospitalId":190234,
			"examTypeId":	2,
			"examChildTypeId":	2,
			"deptId":1,
			"deptName":"肿瘤科",
			"reportTitle":"影像检查",
			"scanningTechnique": "扫描技术",
			"examWay":1,
			"obtainWay":"标本获取",
			"organCode":"12",
			"organ":"0",
			"bodyPart	":"头",
			"nidusCode":"头部",
			"nidus":"头部",
			"nidusSourceFlag":1,
			"longestDiameter":	1.2,
			"shortestDiameter":	.6,
			"examFinding":"肿瘤物",
			"examConclusion":"早治疗",
			"picFileUrls":"http://image.esuizhen.com/1234.jpg",
			"imageFileFormat":"jpg",
			"applyDoctorId	":1
			"applyDoctorNo":"234",
			"applyDoctorName"	: "李大夫",
			"reportDoctorId":123,
			"reportDoctorNo":"123",
			"reportDoctorName"	: "张大夫",
			"state":,1
			"applyTime":"2016-04-29 12:12:34",
			"excuteTime":"2016-04-29 12:12:34",
			"reportTime":"2016-04-29 12:12:34",
			"createTime":"2016-04-29 12:12:34",
			"updateTime":"2016-04-29 12:12:34"
		}]
	 * @param locale
	 * @param examReportList
	 * @return
	 */
	@RequestMapping(value = "/tocloud/exam/report", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<Object>> examReportCoudSync(Locale locale, @RequestBody List<TExamReportSync> examReportList) {
		LogUtil.log.info("Check report synchronization!，examReportCoudSync()==========>>>>>>>>>>");
		TMsgResponse<List<Object>> tMsgResponse = new TMsgResponse<List<Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		if (examReportList == null || examReportList.isEmpty()) {
			LogUtil.log.info("Parameter is empty! syncDiagnosis()==========<<<<<<<<");
			return tMsgResponse;
		}
		try {
			PacAndLisResp pacAndLisResp = this.diagnosisInfoService.examReportCoudSync(examReportList);
			List<Object> fails = pacAndLisResp.getFaildList();
			if (fails != null && !fails.isEmpty()) {
				tMsgResponse.setResult(fails);
				if (pacAndLisResp.getCode() == null) {
					throw new RemoteCallExcption("Error occurred during processing!");
				} else if (pacAndLisResp.getCode() == 1404) {
					throw new RejectRequestExcption("The patient does not exist!");
				}
			}
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg="云端未开启三通的医院Id:"+examReportList.get(0).getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch(RejectRequestExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(RemoteCallExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1417.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
			//tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
		}
		LogUtil.log.info("Check the report to complete!，examReportCoudSync()==========<<<<<<<<");
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/tocloud/detection/report", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<Object>> detectionReportCloudSync(Locale locale, @RequestBody List<TDetectionReportSync> detectionReportSyncList) {
		LogUtil.log.info("Check list synchronization!, detectionReportCloudSync()==========>>>>>>>>>>");
		TMsgResponse<List<Object>> tMsgResponse = new TMsgResponse<List<Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		if (detectionReportSyncList == null || detectionReportSyncList.isEmpty()) {
			LogUtil.log.info("Parameter is empty! syncDiagnosis()==========<<<<<<<<");
			return tMsgResponse;
		}
		try {
			PacAndLisResp pacAndLisResp = this.diagnosisInfoService.detectionReportCloudSync(detectionReportSyncList);
			List<Object> fails = pacAndLisResp.getFaildList();
			if (fails != null && !fails.isEmpty()) {
				tMsgResponse.setResult(fails);
				if (pacAndLisResp.getCode() == null) {
					throw new RemoteCallExcption("Error occurred during processing!");
				} else if (pacAndLisResp.getCode() == 1404) {
					throw new RejectRequestExcption("The patient does not exist!");
				}
			}
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg="云端未开启三通的医院Id:"+detectionReportSyncList.get(0).getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch(RejectRequestExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		} catch(RemoteCallExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1417.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			//tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
		}
		LogUtil.log.info("Check list synchronization complete!, detectionReportCloudSync()==========<<<<<<<<");
		return tMsgResponse;
	}
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloud.syncclient.bean<br/>  
 * <b>文件名：</b>ClinicMedicalNoteReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月25日下午5:51:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.bean;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.TimeUtil;



/** 
* @ClassName: ClinicMedicalNoteReq
* @Description: 
* @author fanpanwei
* @date 2016年09月07日上午11:51:58 
*/
/*@JsonIgnoreProperties({
	"clinicMedicalId",
	"syncFlag"
})*/
public class TOutHospitalNoteInfo {
	
	private String outhospitalId;
	private String inhospitalId;
	private String inhospitalNo;
	private String emrId;
	private Long patientId;
	private String  patientUuid;
	private String patientNo;
	private Integer hospitalId;
	private Date inhospitalDate;
	private Date outhospitalDate;
	private Integer inhospitalDays;
	private String treatmentResult;
	private String symptomSummary;
	private String inhospitalDiagnosis;
	private String treatmentSummary;
	private String outhospitalDiagnosis;
	private String outhospitalSummary;
	private String outhospitalDoctorAdvice;
	private String summaryContent;
	private String rawContent;
	private Integer contentType;
	private Date createTime;
	private Date updateTime;
	private Integer syncFlag=1;
	//start by fanpanwei
	private String mainID;
	private String emrNo;
	private Integer inhospitalTimes;
	/*private String treatmentResult;
	private String outhospitalSummary;*/
	private Date rawCreateTime;
	private Integer emrType;
	private Integer emrSubType;
	private Date visitTime;
	//end by fanpanwei
	public String getOuthospitalId() {
		return outhospitalId;
	}
	public void setOuthospitalId(String outhospitalId) {
		this.outhospitalId = outhospitalId;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public String getInhospitalNo() {
		return inhospitalNo;
	}
	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Date getInhospitalDate() {
		return inhospitalDate;
	}
	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}
	public Date getOuthospitalDate() {
		return outhospitalDate;
	}
	public void setOuthospitalDate(Date outhospitalDate) {
		this.outhospitalDate = outhospitalDate;
	}
	public Integer getInhospitalDays() {
		return inhospitalDays;
	}
	public void setInhospitalDays(Integer inhospitalDays) {
		this.inhospitalDays = inhospitalDays;
	}
	public String getTreatmentResult() {
		return treatmentResult;
	}
	public void setTreatmentResult(String treatmentResult) {
		this.treatmentResult = treatmentResult;
	}
	public String getSymptomSummary() {
		return symptomSummary;
	}
	public void setSymptomSummary(String symptomSummary) {
		this.symptomSummary = symptomSummary;
	}
	public String getInhospitalDiagnosis() {
		return inhospitalDiagnosis;
	}
	public void setInhospitalDiagnosis(String inhospitalDiagnosis) {
		this.inhospitalDiagnosis = inhospitalDiagnosis;
	}
	public String getTreatmentSummary() {
		return treatmentSummary;
	}
	public void setTreatmentSummary(String treatmentSummary) {
		this.treatmentSummary = treatmentSummary;
	}
	public String getOuthospitalDiagnosis() {
		return outhospitalDiagnosis;
	}
	public void setOuthospitalDiagnosis(String outhospitalDiagnosis) {
		this.outhospitalDiagnosis = outhospitalDiagnosis;
	}
	public String getOuthospitalSummary() {
		return outhospitalSummary;
	}
	public void setOuthospitalSummary(String outhospitalSummary) {
		this.outhospitalSummary = outhospitalSummary;
	}
	public String getOuthospitalDoctorAdvice() {
		return outhospitalDoctorAdvice;
	}
	public void setOuthospitalDoctorAdvice(String outhospitalDoctorAdvice) {
		this.outhospitalDoctorAdvice = outhospitalDoctorAdvice;
	}
	public String getSummaryContent() {
		return summaryContent;
	}
	public void setSummaryContent(String summaryContent) {
		this.summaryContent = summaryContent;
	}
	public String getRawContent() {
		return rawContent;
	}
	public void setRawContent(String rawContent) {
		this.rawContent = rawContent;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public String getMainID() {
		return mainID;
	}
	public void setMainID(String mainID) {
		this.mainID = mainID;
	}
	public String getEmrNo() {
		return emrNo;
	}
	public void setEmrNo(String emrNo) {
		this.emrNo = emrNo;
	}
	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}
	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getEmrType() {
		return emrType;
	}
	public void setEmrType(Integer emrType) {
		this.emrType = emrType;
	}
	public Integer getEmrSubType() {
		return emrSubType;
	}
	public void setEmrSubType(Integer emrSubType) {
		this.emrSubType = emrSubType;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	
	public MedicalRecord createMedicalRecord(){
		MedicalRecord medicalRecord = new MedicalRecord();
		BeanUtils.copyProperties(this, medicalRecord);
		medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_OUTHOSPITAL);
		medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
		medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);
		if (medicalRecord.getVisitTime() == null) {
			if(this.getOuthospitalDate()==null){
				medicalRecord.setVisitTime(new Date());
			}else{
				medicalRecord.setVisitTime(this.getOuthospitalDate());
			}
		}
		medicalRecord.setSyncFlag(Constant.SYNC_OK);
		return medicalRecord;
	}
}

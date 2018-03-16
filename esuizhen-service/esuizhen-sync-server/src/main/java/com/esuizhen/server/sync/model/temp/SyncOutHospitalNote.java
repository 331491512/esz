package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 出院bean
 * @author LHY
 */
public class SyncOutHospitalNote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String outhospitalId;   
	private String mainID;  
	private Integer tempId;  
	private String inhospitalId;  
	private String inhospitalNo;   
	private Integer inhospitalTimes; 
	private String emrId;   
	private Long patientId;   
	private String patientUuid;   
	private String patientNo;   
	private String oldPatientNo;   
	private Integer oldInhospitalTimes;  
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
	private Integer handleFlag;   
	private Date rawCreateTime;   
	private Integer mergeFlag;   
	private Long mergeFrom;  
	private String mergeFromUuid;   
	private Long mergeTarget;   
	private String mergeTargetUuid;   
	private Date mergeTime;
	private String batchId;
	private Integer sourceFlag;
	
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getOuthospitalId() {
		return outhospitalId;
	}
	public void setOuthospitalId(String outhospitalId) {
		this.outhospitalId = outhospitalId;
	}
	public String getMainID() {
		return mainID;
	}
	public void setMainID(String mainID) {
		this.mainID = mainID;
	}
	public Integer getTempId() {
		return tempId;
	}
	public void setTempId(Integer tempId) {
		this.tempId = tempId;
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
	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}
	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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
	public String getOldPatientNo() {
		return oldPatientNo;
	}
	public void setOldPatientNo(String oldPatientNo) {
		this.oldPatientNo = oldPatientNo;
	}
	public Integer getOldInhospitalTimes() {
		return oldInhospitalTimes;
	}
	public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
		this.oldInhospitalTimes = oldInhospitalTimes;
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
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public Date getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}  
	
}
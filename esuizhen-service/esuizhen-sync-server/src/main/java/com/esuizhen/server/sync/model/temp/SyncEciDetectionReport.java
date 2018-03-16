package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 檢查bean
 * @author LHY
 */
public class SyncEciDetectionReport implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private String detectionReportId;  
	private String emrId;   
	private Long patientId;  
	private String patientUuid;   
	private String patientNo;   
	private String inhospitalTimes;  
	private String patientIdno;   
	private String patientAddress;  
	private String patientMobile;  
	private Integer patientSex;   
	private Integer patientAge;   
	private Date patientBirth;   
	private String patientName;   
	private String wardArea;  
	private String bedNo;   
	private Integer outPatientFlag;  
	private Integer hospitalId;   
	private Integer detectionTypeId;   
	private Integer detectionChildTypeId;  
	private String detectionTypeName;  
	private Integer deptId;   
	private String deptUuid;   
	private String deptName;   
	private String diagnosis;  
	private String sampleNo;   
	private String sampleName;   
	private String sampleType;   
	private Integer sampleState;   
	private String instrument;  
	private Long applyDoctorId;   
	private String applyDoctorUuid;   
	private String applyDoctorNo;   
	private String applyDoctorName;   
	private Long operateDoctorId;   
	private String operateDoctorUuid;   
	private String operateDoctorNo;   
	private String operateDoctorName;   
	private Long reportDoctorId;  
	private String reportDoctorUuid;   
	private String reportDoctorNo;  
	private String reportDoctorName;   
	private Long auditDoctorId;   
	private String auditDoctorUuid;   
	private String auditDoctorNo;   
	private String auditDoctorName;  
	private String remark;   
	private Integer readFlag;   
	private Date applyTime;   
	private Date sampleTime;  
	private Date acceptTime;   
	private Date reportTime;   
	private Integer state;   
	private Date createTime;   
	private Date updateTime;   
	private Integer rawDetectionTypeId;   
	private String rawDetectionChildTypeId;   
	private Long mainID;  
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
	public String getDetectionReportId() {
		return detectionReportId;
	}
	public void setDetectionReportId(String detectionReportId) {
		this.detectionReportId = detectionReportId;
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
	public String getInhospitalTimes() {
		return inhospitalTimes;
	}
	public void setInhospitalTimes(String inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}
	public String getPatientIdno() {
		return patientIdno;
	}
	public void setPatientIdno(String patientIdno) {
		this.patientIdno = patientIdno;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	public Integer getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(Integer patientSex) {
		this.patientSex = patientSex;
	}
	public Integer getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}
	public Date getPatientBirth() {
		return patientBirth;
	}
	public void setPatientBirth(Date patientBirth) {
		this.patientBirth = patientBirth;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getWardArea() {
		return wardArea;
	}
	public void setWardArea(String wardArea) {
		this.wardArea = wardArea;
	}
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}
	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getDetectionTypeId() {
		return detectionTypeId;
	}
	public void setDetectionTypeId(Integer detectionTypeId) {
		this.detectionTypeId = detectionTypeId;
	}
	public Integer getDetectionChildTypeId() {
		return detectionChildTypeId;
	}
	public void setDetectionChildTypeId(Integer detectionChildTypeId) {
		this.detectionChildTypeId = detectionChildTypeId;
	}
	public String getDetectionTypeName() {
		return detectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public Integer getSampleState() {
		return sampleState;
	}
	public void setSampleState(Integer sampleState) {
		this.sampleState = sampleState;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public Long getApplyDoctorId() {
		return applyDoctorId;
	}
	public void setApplyDoctorId(Long applyDoctorId) {
		this.applyDoctorId = applyDoctorId;
	}
	public String getApplyDoctorUuid() {
		return applyDoctorUuid;
	}
	public void setApplyDoctorUuid(String applyDoctorUuid) {
		this.applyDoctorUuid = applyDoctorUuid;
	}
	public String getApplyDoctorNo() {
		return applyDoctorNo;
	}
	public void setApplyDoctorNo(String applyDoctorNo) {
		this.applyDoctorNo = applyDoctorNo;
	}
	public String getApplyDoctorName() {
		return applyDoctorName;
	}
	public void setApplyDoctorName(String applyDoctorName) {
		this.applyDoctorName = applyDoctorName;
	}
	public Long getOperateDoctorId() {
		return operateDoctorId;
	}
	public void setOperateDoctorId(Long operateDoctorId) {
		this.operateDoctorId = operateDoctorId;
	}
	public String getOperateDoctorUuid() {
		return operateDoctorUuid;
	}
	public void setOperateDoctorUuid(String operateDoctorUuid) {
		this.operateDoctorUuid = operateDoctorUuid;
	}
	public String getOperateDoctorNo() {
		return operateDoctorNo;
	}
	public void setOperateDoctorNo(String operateDoctorNo) {
		this.operateDoctorNo = operateDoctorNo;
	}
	public String getOperateDoctorName() {
		return operateDoctorName;
	}
	public void setOperateDoctorName(String operateDoctorName) {
		this.operateDoctorName = operateDoctorName;
	}
	public Long getReportDoctorId() {
		return reportDoctorId;
	}
	public void setReportDoctorId(Long reportDoctorId) {
		this.reportDoctorId = reportDoctorId;
	}
	public String getReportDoctorUuid() {
		return reportDoctorUuid;
	}
	public void setReportDoctorUuid(String reportDoctorUuid) {
		this.reportDoctorUuid = reportDoctorUuid;
	}
	public String getReportDoctorNo() {
		return reportDoctorNo;
	}
	public void setReportDoctorNo(String reportDoctorNo) {
		this.reportDoctorNo = reportDoctorNo;
	}
	public String getReportDoctorName() {
		return reportDoctorName;
	}
	public void setReportDoctorName(String reportDoctorName) {
		this.reportDoctorName = reportDoctorName;
	}
	public Long getAuditDoctorId() {
		return auditDoctorId;
	}
	public void setAuditDoctorId(Long auditDoctorId) {
		this.auditDoctorId = auditDoctorId;
	}
	public String getAuditDoctorUuid() {
		return auditDoctorUuid;
	}
	public void setAuditDoctorUuid(String auditDoctorUuid) {
		this.auditDoctorUuid = auditDoctorUuid;
	}
	public String getAuditDoctorNo() {
		return auditDoctorNo;
	}
	public void setAuditDoctorNo(String auditDoctorNo) {
		this.auditDoctorNo = auditDoctorNo;
	}
	public String getAuditDoctorName() {
		return auditDoctorName;
	}
	public void setAuditDoctorName(String auditDoctorName) {
		this.auditDoctorName = auditDoctorName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(Date sampleTime) {
		this.sampleTime = sampleTime;
	}
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public Integer getRawDetectionTypeId() {
		return rawDetectionTypeId;
	}
	public void setRawDetectionTypeId(Integer rawDetectionTypeId) {
		this.rawDetectionTypeId = rawDetectionTypeId;
	}
	public String getRawDetectionChildTypeId() {
		return rawDetectionChildTypeId;
	}
	public void setRawDetectionChildTypeId(String rawDetectionChildTypeId) {
		this.rawDetectionChildTypeId = rawDetectionChildTypeId;
	}
	public Long getMainID() {
		return mainID;
	}
	public void setMainID(Long mainID) {
		this.mainID = mainID;
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
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}
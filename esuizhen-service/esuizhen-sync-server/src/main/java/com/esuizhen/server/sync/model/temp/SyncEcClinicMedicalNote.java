package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 門診bean
 * @author LHY
 */
public class SyncEcClinicMedicalNote implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private String clinicMedicalId;   
	private String emrId;  
	private Integer tempId; 
	private String clinicNo;  
	private Long patientId;   
	private String patientUuid;   
	private String patientNo;  
	private Integer hospitalId;  
	private String healthCardNo;   
	private String patientName;   
	private String patientIdno;   
	private String patientAddress;  
	private String patientMobile;  
	private Integer patientSex; 
	private Date patientBirth;  
	private String patientAge;   
	private Integer deptId; 
	private String deptUuid;
	private String deptName;  
	private Integer attendingDoctorId; 
	private String attendingDoctorUuid;  
	private String attendingDoctorNo;   
	private String attendingDoctorName;   
	private String symptomSummary;  
	private String diagnosis;   
	private String diseaseCode;  
	private String remark;   
	private Long clinicDoctor;   
	private String clinicDoctorUuid;   
	private Integer visitTimes;   
	private Date visitTime;   
	private Date createTime;   
	private Date updateTime;  
	private Date rawCreateTime;   
	private Integer handleFlag;  
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
	public String getClinicMedicalId() {
		return clinicMedicalId;
	}
	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public Integer getTempId() {
		return tempId;
	}
	public void setTempId(Integer tempId) {
		this.tempId = tempId;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
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
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHealthCardNo() {
		return healthCardNo;
	}
	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	public Date getPatientBirth() {
		return patientBirth;
	}
	public void setPatientBirth(Date patientBirth) {
		this.patientBirth = patientBirth;
	}
	public String getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
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
	public Integer getAttendingDoctorId() {
		return attendingDoctorId;
	}
	public void setAttendingDoctorId(Integer attendingDoctorId) {
		this.attendingDoctorId = attendingDoctorId;
	}
	public String getAttendingDoctorUuid() {
		return attendingDoctorUuid;
	}
	public void setAttendingDoctorUuid(String attendingDoctorUuid) {
		this.attendingDoctorUuid = attendingDoctorUuid;
	}
	public String getAttendingDoctorNo() {
		return attendingDoctorNo;
	}
	public void setAttendingDoctorNo(String attendingDoctorNo) {
		this.attendingDoctorNo = attendingDoctorNo;
	}
	public String getAttendingDoctorName() {
		return attendingDoctorName;
	}
	public void setAttendingDoctorName(String attendingDoctorName) {
		this.attendingDoctorName = attendingDoctorName;
	}
	public String getSymptomSummary() {
		return symptomSummary;
	}
	public void setSymptomSummary(String symptomSummary) {
		this.symptomSummary = symptomSummary;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getClinicDoctor() {
		return clinicDoctor;
	}
	public void setClinicDoctor(Long clinicDoctor) {
		this.clinicDoctor = clinicDoctor;
	}
	public String getClinicDoctorUuid() {
		return clinicDoctorUuid;
	}
	public void setClinicDoctorUuid(String clinicDoctorUuid) {
		this.clinicDoctorUuid = clinicDoctorUuid;
	}
	public Integer getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(Integer visitTimes) {
		this.visitTimes = visitTimes;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
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
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
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
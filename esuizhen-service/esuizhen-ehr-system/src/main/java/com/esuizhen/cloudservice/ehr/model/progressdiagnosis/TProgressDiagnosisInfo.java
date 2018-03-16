package com.esuizhen.cloudservice.ehr.model.progressdiagnosis;

import java.util.Date;

public class TProgressDiagnosisInfo {
	private String issuedId;
	private String diagnosisCardId;
	private Long patientId;
	private String patientNo;
	private Date issuedDate;
	private String diseaseCode;
	private String diagnosis;
	private Date createTime;
	private Date updateTime;
	public String getIssuedId() {
		return issuedId;
	}
	public String getDiagnosisCardId() {
		return diagnosisCardId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setIssuedId(String issuedId) {
		this.issuedId = issuedId;
	}
	public void setDiagnosisCardId(String diagnosisCardId) {
		this.diagnosisCardId = diagnosisCardId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}

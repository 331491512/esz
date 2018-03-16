package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;


public class TVarPatientMedical{
	/**
	 * 主键。自增
	 */
	private Long id;
	/**
	 * 患者ID。外键：u_patient.patientId
	 */
	private Long patientId;
	/**
	 * 最近门诊时间
	 */
	private Date latestClinicDate;
	/**
	 * 最近出院时间
	 */
	private Date latestOutHospitalDate;
	/**
	 * 最近病历更新时间。
	 */
	private Date latestMedicalRecordUploadTime;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间。 当患者信息更新，或者有病历上传时，此字段均更新为当前时间。
	 */
	private Date updateTime;

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setPatientId(Long value) {
		this.patientId = value;
	}
	
	public Long getPatientId() {
		return this.patientId;
	}
	public void setLatestClinicDate(Date value) {
		this.latestClinicDate = value;
	}
	
	public Date getLatestClinicDate() {
		return this.latestClinicDate;
	}
	public void setLatestOutHospitalDate(Date value) {
		this.latestOutHospitalDate = value;
	}
	
	public Date getLatestOutHospitalDate() {
		return this.latestOutHospitalDate;
	}
	public void setLatestMedicalRecordUploadTime(Date value) {
		this.latestMedicalRecordUploadTime = value;
	}
	
	public Date getLatestMedicalRecordUploadTime() {
		return this.latestMedicalRecordUploadTime;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}


}


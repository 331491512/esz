package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

public class PhysicalSigns {
	String physicalSignsResultId;
	Long patientId;
	String inhospitalId;
	String clinicMedicalId;
	String physicalSignsName;
	Integer physicalSignsId;
	Date checkDate;
	Integer signsStatus;
	String description;
	Integer isDelete;
	
	public String getClinicMedicalId() {
		return clinicMedicalId;
	}
	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
	public String getPhysicalSignsResultId() {
		return physicalSignsResultId;
	}
	public void setPhysicalSignsResultId(String physicalSignsResultId) {
		this.physicalSignsResultId = physicalSignsResultId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public String getPhysicalSignsName() {
		return physicalSignsName;
	}
	public void setPhysicalSignsName(String physicalSignsName) {
		this.physicalSignsName = physicalSignsName;
	}
	public Integer getPhysicalSignsId() {
		return physicalSignsId;
	}
	public void setPhysicalSignsId(Integer physicalSignsId) {
		this.physicalSignsId = physicalSignsId;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Integer getSignsStatus() {
		return signsStatus;
	}
	public void setSignsStatus(Integer signsStatus) {
		this.signsStatus = signsStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}

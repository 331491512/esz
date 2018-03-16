package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

public class QualityoflifeInfo {
	
	String qolId;
	String emrId;
	Long patientId;
	String patientNo;
	String inhospitalId;
	String clinicMedicalId;
	Integer kpsValue;
	Integer ecogValue;
	Integer otherValue;
	String remark;
	Date visitTime;
	Date deathDate;
	Integer isTumourDeath;
	Integer isDelete;
	
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getClinicMedicalId() {
		return clinicMedicalId;
	}
	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
	public Date getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}
	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}
	public String getQolId() {
		return qolId;
	}
	public void setQolId(String qolId) {
		this.qolId = qolId;
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
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public Integer getKpsValue() {
		return kpsValue;
	}
	public void setKpsValue(Integer kpsValue) {
		this.kpsValue = kpsValue;
	}
	public Integer getEcogValue() {
		return ecogValue;
	}
	public void setEcogValue(Integer ecogValue) {
		this.ecogValue = ecogValue;
	}
	public Integer getOtherValue() {
		return otherValue;
	}
	public void setOtherValue(Integer otherValue) {
		this.otherValue = otherValue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
}

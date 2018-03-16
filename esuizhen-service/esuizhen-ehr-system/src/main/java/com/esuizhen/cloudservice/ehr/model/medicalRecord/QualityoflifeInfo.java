package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

public class QualityoflifeInfo {
	// 生存质量记录ID
	String qolId;
	
	// 电子病历ID
	String emrId;
	
	// 患者ID
	Long patientId;
	
	// 病案号
	String patientNo;
	
	// 住院记录ID
	String inhospitalId;
	
	// 门诊病历记录ID
	String clinicMedicalId;
	
	// KPS评分
	Integer kpsValue;
	
	// ECOG评分
	Integer ecogValue;
	
	// 其他评分
	Integer otherValue;
	
	// 生产质量描述
	String remark;
	
	// 就诊时间
	Date visitTime;
	
	// 死亡日期
	Date deathDate;
	
	// 死亡原因
	Integer isTumourDeath;
	
	// 删除标识
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

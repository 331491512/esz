package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

public class AdverseReactionResultInfo {
	// 主键
	String adverseReactionRecordId;
	
	// 不良反应id
	Integer adverseReactionId;
	
	// 患者id
	Long patientId;
	
	// 住院id
	String inhospitalId;
	
	// 不良反应名称
	String adverseReactionName;
	
	// 程度等级
	Integer level;
	
	// 采取措施id
	Integer takeStepsId;
	
	// 采取措施
	String takeSteps;
	
	// 与治疗关系id
	Integer treatmentRelationsId;
	
	// 与治疗关系
	String researchRelationship;
	
	// 转归id
	Integer theOutcomeId;
	
	// 转归
	String theOutcome;
	
	// 开始时间
	Date beginTime;
	
	// 结束时间
	Date endTime;
	
	// 排序索引
	Integer sortNum;
	
	// 删除标识
	Integer isDelete;
	
	// 门诊病历记录ID
	String clinicMedicalId;
	
	public String getClinicMedicalId() {
		return clinicMedicalId;
	}
	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getAdverseReactionRecordId() {
		return adverseReactionRecordId;
	}
	public void setAdverseReactionRecordId(String adverseReactionRecordId) {
		this.adverseReactionRecordId = adverseReactionRecordId;
	}
	public Integer getAdverseReactionId() {
		return adverseReactionId;
	}
	public void setAdverseReactionId(Integer adverseReactionId) {
		this.adverseReactionId = adverseReactionId;
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
	public String getAdverseReactionName() {
		return adverseReactionName;
	}
	public void setAdverseReactionName(String adverseReactionName) {
		this.adverseReactionName = adverseReactionName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getTakeStepsId() {
		return takeStepsId;
	}
	public void setTakeStepsId(Integer takeStepsId) {
		this.takeStepsId = takeStepsId;
	}
	public String getTakeSteps() {
		return takeSteps;
	}
	public void setTakeSteps(String takeSteps) {
		this.takeSteps = takeSteps;
	}
	public Integer getTreatmentRelationsId() {
		return treatmentRelationsId;
	}
	public void setTreatmentRelationsId(Integer treatmentRelationsId) {
		this.treatmentRelationsId = treatmentRelationsId;
	}
	public String getResearchRelationship() {
		return researchRelationship;
	}
	public void setResearchRelationship(String researchRelationship) {
		this.researchRelationship = researchRelationship;
	}
	public Integer getTheOutcomeId() {
		return theOutcomeId;
	}
	public void setTheOutcomeId(Integer theOutcomeId) {
		this.theOutcomeId = theOutcomeId;
	}
	public String getTheOutcome() {
		return theOutcome;
	}
	public void setTheOutcome(String theOutcome) {
		this.theOutcome = theOutcome;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
}

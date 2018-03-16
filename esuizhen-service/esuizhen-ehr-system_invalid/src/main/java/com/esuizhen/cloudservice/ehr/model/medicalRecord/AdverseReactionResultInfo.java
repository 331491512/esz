package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

public class AdverseReactionResultInfo {
	String adverseReactionRecordId;
	Integer adverseReactionId;
	Long patientId;
	String inhospitalId;
	String adverseReactionName;
	Integer level;
	Integer takeStepsId;
	String takeSteps;
	Integer treatmentRelationsId;
	String researchRelationship;
	Integer theOutcomeId;
	String theOutcome;
	Date beginTime;
	Date endTime;
	Integer sortNum;
	Integer isDelete;
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

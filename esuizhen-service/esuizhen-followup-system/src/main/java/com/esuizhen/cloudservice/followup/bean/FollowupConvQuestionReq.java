package com.esuizhen.cloudservice.followup.bean;

import java.util.List;

public class FollowupConvQuestionReq {
	private Integer patientId;
	private Integer operatorId;
	private Long mainQuestionItemId;
	private Long followupConvQuestionId;
	private Integer questionType;
	private List<TreatmentTypeReq> treatmentType;
	private List<TreatmentDetailReq> treatmentDetail;
	private List<VerifiesReq> verifies;
	private List<SymptomsReq> symptoms;
	private List<FamilyHistoriesReq> familyHistories;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public Long getMainQuestionItemId() {
		return mainQuestionItemId;
	}
	public void setMainQuestionItemId(Long mainQuestionItemId) {
		this.mainQuestionItemId = mainQuestionItemId;
	}
	public Long getFollowupConvQuestionId() {
		return followupConvQuestionId;
	}
	public void setFollowupConvQuestionId(Long followupConvQuestionId) {
		this.followupConvQuestionId = followupConvQuestionId;
	}
	
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	public List<TreatmentTypeReq> getTreatmentType() {
		return treatmentType;
	}
	public void setTreatmentType(List<TreatmentTypeReq> treatmentType) {
		this.treatmentType = treatmentType;
	}
	public List<TreatmentDetailReq> getTreatmentDetail() {
		return treatmentDetail;
	}
	public void setTreatmentDetail(List<TreatmentDetailReq> treatmentDetail) {
		this.treatmentDetail = treatmentDetail;
	}
	public List<VerifiesReq> getVerifies() {
		return verifies;
	}
	public void setVerifies(List<VerifiesReq> verifies) {
		this.verifies = verifies;
	}
	public List<SymptomsReq> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<SymptomsReq> symptoms) {
		this.symptoms = symptoms;
	}
	public List<FamilyHistoriesReq> getFamilyHistories() {
		return familyHistories;
	}
	public void setFamilyHistories(List<FamilyHistoriesReq> familyHistories) {
		this.familyHistories = familyHistories;
	}
	
}

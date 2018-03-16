package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;
import java.util.List;

public class FamilyHistoriesReq {
	
	private Long mainQuestionItemId;
	private Long followupConvQuestionId;
	private Integer patientRelation;
	private String diseaseTypeIds;
	private Integer liveStatus;
	private Date deathDate;
	
	private Integer isDel;//0:不删除此条数据，1：删除此条数据 
	
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
	public Integer getPatientRelation() {
		return patientRelation;
	}
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}
	public String getDiseaseTypeIds() {
		return diseaseTypeIds;
	}
	public void setDiseaseTypeIds(String diseaseTypeIds) {
		this.diseaseTypeIds = diseaseTypeIds;
	}
	public Integer getLiveStatus() {
		return liveStatus;
	}
	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}
	public Date getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
}

package com.esuizhen.cloudservice.followup.bean;


public class TreatmentTypeReq {
	private Long mainQuestionItemId;
	private Long followupConvQuestionId;
	private Integer treatmentTypeId;
	private String treatmentTypeName;
	private Integer choseFlag;
	private Integer sortNum;
	
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
	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}
	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}
	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}
	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}
	public Integer getChoseFlag() {
		return choseFlag;
	}
	public void setChoseFlag(Integer choseFlag) {
		this.choseFlag = choseFlag;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
}

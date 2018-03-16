package com.esuizhen.cloudservice.followup.bean;


public class FollowupConvMainQuestionItemReq {
	private Long mainQuestionItemId;
	private Long followupConvQuestionId;
	private Integer questionType;
	
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
}

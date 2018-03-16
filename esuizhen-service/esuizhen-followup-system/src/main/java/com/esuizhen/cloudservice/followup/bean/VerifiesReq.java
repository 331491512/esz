package com.esuizhen.cloudservice.followup.bean;


public class VerifiesReq {
	private Long mainQuestionItemId;
	private Long followupConvQuestionId;
	private String itemName;
	private String verifyResult;
	
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getVerifyResult() {
		return verifyResult;
	}
	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
}

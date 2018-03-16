package com.esuizhen.cloudservice.followup.bean;

public class FollowupResultDeleteReq {
	private String followupResultId;
	private String followupResultBuffId;
	private Long updateOperator;
	private String updateOperatorName;

	public String getFollowupResultId() {
		return followupResultId;
	}

	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
	}

	public String getFollowupResultBuffId() {
		return followupResultBuffId;
	}

	public void setFollowupResultBuffId(String followupResultBuffId) {
		this.followupResultBuffId = followupResultBuffId;
	}

	public Long getUpdateOperator() {
		return updateOperator;
	}

	public void setUpdateOperator(Long updateOperator) {
		this.updateOperator = updateOperator;
	}

	public String getUpdateOperatorName() {
		return updateOperatorName;
	}

	public void setUpdateOperatorName(String updateOperatorName) {
		this.updateOperatorName = updateOperatorName;
	}
}

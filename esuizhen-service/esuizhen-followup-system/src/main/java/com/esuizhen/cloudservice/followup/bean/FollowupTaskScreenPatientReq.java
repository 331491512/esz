package com.esuizhen.cloudservice.followup.bean;

public class FollowupTaskScreenPatientReq {
	
	private Integer searchId;
	
	private Integer conditionId;
	
	private Integer needContactFlag;
	
	private Long operator;
	
	private Integer userRole;
	
	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public Integer getNeedContactFlag() {
		return needContactFlag;
	}

	public void setNeedContactFlag(Integer needContactFlag) {
		this.needContactFlag = needContactFlag;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
}

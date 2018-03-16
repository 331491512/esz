package com.esuizhen.cloudservice.followup.bean;


public class FollowupPhoneCallIncomingQueryReq {

	private String callTimeStart;
	private String callTimeEnd;
	private Integer userRole;
	private Long operator;
	private Integer resultProcessState;
	private Integer page;
	private Integer num;
	private String sql;
	private Integer hospitalId;
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getCallTimeStart() {
		return callTimeStart;
	}
	public void setCallTimeStart(String callTimeStart) {
		this.callTimeStart = callTimeStart;
	}
	public String getCallTimeEnd() {
		return callTimeEnd;
	}
	public void setCallTimeEnd(String callTimeEnd) {
		this.callTimeEnd = callTimeEnd;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public Integer getResultProcessState() {
		return resultProcessState;
	}
	public void setResultProcessState(Integer resultProcessState) {
		this.resultProcessState = resultProcessState;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	
}

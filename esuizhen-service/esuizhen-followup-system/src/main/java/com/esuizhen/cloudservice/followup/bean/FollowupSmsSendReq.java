package com.esuizhen.cloudservice.followup.bean;


public class FollowupSmsSendReq {

	private String replyTimeStart;
	private String replyTimeEnd;
	private Integer resultProcessState;
	private Integer userRole;
	private Long operator;
	private Long searchOperator;
	private Integer replyState;
	private Integer page;
	private Integer num;
	private String followupTaskId;
	private String followupTaskAssignId;
	private Long patientId;
	private String templateId;
	private Integer state;
	private String followupResultId;
	private String followupResultBuffId;
	private String sql; // 数据权限拼接的sql	
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
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	public String getFollowupTaskAssignId() {
		return followupTaskAssignId;
	}
	public void setFollowupTaskAssignId(String followupTaskAssignId) {
		this.followupTaskAssignId = followupTaskAssignId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getReplyState() {
		return replyState;
	}
	public void setReplyState(Integer replyState) {
		this.replyState = replyState;
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
	public String getReplyTimeStart() {
		return replyTimeStart;
	}
	public void setReplyTimeStart(String replyTimeStart) {
		this.replyTimeStart = replyTimeStart;
	}
	public String getReplyTimeEnd() {
		return replyTimeEnd;
	}
	public void setReplyTimeEnd(String replyTimeEnd) {
		this.replyTimeEnd = replyTimeEnd;
	}
	public Integer getResultProcessState() {
		return resultProcessState;
	}
	public void setResultProcessState(Integer resultProcessState) {
		this.resultProcessState = resultProcessState;
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
	public Long getSearchOperator() {
		return searchOperator;
	}
	public void setSearchOperator(Long searchOperator) {
		this.searchOperator = searchOperator;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
}

package com.esuizhen.cloudservice.followup.bean;


public class FollowupResultDetailQueryReq {

	private String	templateId;
	private String sendTime;
	private Integer followupWay;
	private Integer userRole;
	private Long operator;
	private String startSendTime;
	private String endSendTime;
	private Integer page;
	private Integer num;
	private String sql;
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Integer getFollowupWay() {
		return followupWay;
	}
	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
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
	public String getStartSendTime() {
		return startSendTime;
	}
	public void setStartSendTime(String startSendTime) {
		this.startSendTime = startSendTime;
	}
	public String getEndSendTime() {
		return endSendTime;
	}
	public void setEndSendTime(String endSendTime) {
		this.endSendTime = endSendTime;
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

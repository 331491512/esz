package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class FollowupResultStatisReq {

	private String templateId;
	private String sendTime;
	private String startSendTime;
	private String endSendTime;
	private Integer followupWay;
	private Integer userRole;
	private Long operator;
	private Integer replyState;
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
	public Integer getReplyState() {
		return replyState;
	}
	public void setReplyState(Integer replyState) {
		this.replyState = replyState;
	}


}

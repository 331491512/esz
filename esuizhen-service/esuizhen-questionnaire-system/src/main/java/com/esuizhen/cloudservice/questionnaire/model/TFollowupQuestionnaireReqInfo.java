package com.esuizhen.cloudservice.questionnaire.model;

import java.util.Date;

public class TFollowupQuestionnaireReqInfo {

	private Long reqId;
	private String templateId;
	private String followupTaskId;
	private String followupAssignId;
	private Integer hospitalId;
	private Long patientId;
	private String openId;
	private String mobile;
	private String messageId;
	private String trueName;
	private String signature;
	private String content;
	private Integer channel;
	private Integer state;
	private Date sendTime;
	private Integer replyState;
	private Date replyTime;
	private Integer resultProcessState;
	private Date createTime;
	private Date updateTime;
	private String questionnaireUrl;
	public Long getReqId() {
		return reqId;
	}
	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	public String getFollowupAssignId() {
		return followupAssignId;
	}
	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
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
	public Integer getResultProcessState() {
		return resultProcessState;
	}
	public void setResultProcessState(Integer resultProcessState) {
		this.resultProcessState = resultProcessState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getQuestionnaireUrl() {
		return questionnaireUrl;
	}
	public void setQuestionnaireUrl(String questionnaireUrl) {
		this.questionnaireUrl = questionnaireUrl;
	}
}

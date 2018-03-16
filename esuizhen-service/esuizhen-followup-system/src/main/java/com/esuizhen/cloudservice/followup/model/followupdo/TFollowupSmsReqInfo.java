package com.esuizhen.cloudservice.followup.model.followupdo;

import java.util.Date;

public class TFollowupSmsReqInfo {

	private Long reqId;
	private String templateId;
	private String templateName;
	private String followupTaskId;
	private String followupAssignId;
	private Integer hospitalId;
	private Long patientId;
	private String messageId;
	private Date sendTime;
	private String trueName;
	private String mobile;
	private Integer state;
	private String stateName;
	private Integer replyState;
	private String replyStateName;
	private String replyContent;
	private Date replyTime;
	private Integer resultProcessState;
	private String resultProcessStateName;
	private Integer resultType;
	private String resultTypeName;
	private String followupResultBuffId;
	private String followupResultId;
	private String followupResultValueName;
	private Date createTime;
	private Date updateTime;
	private String patientNo;
	private Integer needReply;
	private String signature;
	private String autoReplyContent;
	private Integer isEnable;

	public Integer getNeedReply() {
		return needReply;
	}

	public void setNeedReply(Integer needReply) {
		this.needReply = needReply;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAutoReplyContent() {
		return autoReplyContent;
	}

	public void setAutoReplyContent(String autoReplyContent) {
		this.autoReplyContent = autoReplyContent;
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Integer getResultProcessState() {
		return resultProcessState;
	}

	public void setResultProcessState(Integer resultProcessState) {
		this.resultProcessState = resultProcessState;
	}

	public Integer getResultType() {
		return resultType;
	}

	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}

	public String getFollowupResultBuffId() {
		return followupResultBuffId;
	}

	public void setFollowupResultBuffId(String followupResultBuffId) {
		this.followupResultBuffId = followupResultBuffId;
	}

	public String getFollowupResultId() {
		return followupResultId;
	}

	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
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

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getResultProcessStateName() {
		return resultProcessStateName;
	}

	public void setResultProcessStateName(String resultProcessStateName) {
		this.resultProcessStateName = resultProcessStateName;
	}

	public String getFollowupResultValueName() {
		return followupResultValueName;
	}

	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getReplyStateName() {
		return replyStateName;
	}

	public void setReplyStateName(String replyStateName) {
		this.replyStateName = replyStateName;
	}

	public String getResultTypeName() {
		return resultTypeName;
	}

	public void setResultTypeName(String resultTypeName) {
		this.resultTypeName = resultTypeName;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	
}

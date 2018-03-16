package com.westangel.common.bean.followup;

import java.util.Date;

public class TVarPatientFollowup {
	/**
	 * 主键。自增
	 */
	private Long id;
	/**
	 * 患者ID。外键：u_patient.patientId
	 */
	private Long patientId;
	/**
	 * 最近随访时间
	 */
	private Date latestFollowupTime;
	/**
	 * 当前随访计划执行到的天数。 缺省0。
	 */
	private Integer currFollowupPerformDays;
	/**
	 * followupFlag
	 */
	private Integer followupFlag;
	/**
	 * 随访状态。 0：待随访（(默认）；1：随访中；2：已结束。
	 */
	private Integer followupState;
	/**
	 * 专题随访状态 0：无；1：进行中；2：已结束
	 */
	private Integer projectFollowupState;
	/**
	 * 随访任务分配标识。 0：未分配；1：已分配。
	 */
	private Integer followupAssignFlag;
	/**
	 * 最新随访结果
	 */
	private Integer followupResultValue;

	/**
	 * 首次确认日期
	 */
	private String confirmedDate;
	/**
	 * 记录创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间。 当患者信息更新，或者有病历上传时，此字段均更新为当前时间。
	 */
	private Date updateTime;

	private Integer liveDay;

	private Float liveMonth;

	private Integer followupValidResultValue;

	private Date latestValidFollowupTime;

	private Date latestFollowupFeedbackTime;
	
	/**
	 * 末次有效随访人员doctorId
	 */
	private Long validFollowupOperator;
	
	/**
	 * 末次有效随访人员姓名
	 */
	private String validFollowupOperatorName;
	
	/**
	 * 末次有效随访方式
	 */
	private Integer validFollowupWay;
	
	/**
	 * 末次有效随访方式名称
	 */
	private String validFollowupWayName;

	private Long followupOperator;
	
	private String followupOperatorName;
	
	private Integer followupWay;
	
	private String followupWayName;
	
	private String relapseParts;
	
	private Date relapseDate;
	
	private String transferParts;
	
	private Date transferDate;
	
	private String followupRemark;
	
	private String followupTaskId;
	
	private String followupTaskName;
	
	/**
	 * 短信回复原始内容
	 */
	private Date smsSendTime;
	
	/**
	 * 短信回复原始内容
	 */
	private String smsReplyContent;
	
	private Integer followupResultState;

	public Integer getFollowupValidResultValue() {
		return followupValidResultValue;
	}

	public void setFollowupValidResultValue(Integer followupValidResultValue) {
		this.followupValidResultValue = followupValidResultValue;
	}

	public Date getLatestValidFollowupTime() {
		return latestValidFollowupTime;
	}

	public void setLatestValidFollowupTime(Date latestValidFollowupTime) {
		this.latestValidFollowupTime = latestValidFollowupTime;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public Long getId() {
		return this.id;
	}

	public void setPatientId(Long value) {
		this.patientId = value;
	}

	public Long getPatientId() {
		return this.patientId;
	}

	public void setLatestFollowupTime(Date value) {
		this.latestFollowupTime = value;
	}

	public Date getLatestFollowupTime() {
		return this.latestFollowupTime;
	}

	public void setCurrFollowupPerformDays(Integer value) {
		this.currFollowupPerformDays = value;
	}

	public Integer getCurrFollowupPerformDays() {
		return this.currFollowupPerformDays;
	}

	public void setFollowupFlag(Integer value) {
		this.followupFlag = value;
	}

	public Integer getFollowupFlag() {
		return this.followupFlag;
	}

	public void setFollowupState(Integer value) {
		this.followupState = value;
	}

	public Integer getFollowupState() {
		return this.followupState;
	}

	public void setProjectFollowupState(Integer value) {
		this.projectFollowupState = value;
	}

	public Integer getProjectFollowupState() {
		return this.projectFollowupState;
	}

	public void setFollowupAssignFlag(Integer value) {
		this.followupAssignFlag = value;
	}

	public Integer getFollowupAssignFlag() {
		return this.followupAssignFlag;
	}

	public void setFollowupResultValue(Integer value) {
		this.followupResultValue = value;
	}

	public Integer getFollowupResultValue() {
		return this.followupResultValue;
	}

	public void setCreateTime(Date value) {
		this.createTime = value;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public String getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(String confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public Integer getLiveDay() {
		return liveDay;
	}

	public void setLiveDay(Integer liveDay) {
		this.liveDay = liveDay;
	}

	public Float getLiveMonth() {
		return liveMonth;
	}

	public void setLiveMonth(Float liveMonth) {
		this.liveMonth = liveMonth;
	}

	public Date getLatestFollowupFeedbackTime() {
		return latestFollowupFeedbackTime;
	}

	public void setLatestFollowupFeedbackTime(Date latestFollowupFeedbackTime) {
		this.latestFollowupFeedbackTime = latestFollowupFeedbackTime;
	}

	public Long getFollowupOperator() {
		return followupOperator;
	}

	public void setFollowupOperator(Long followupOperator) {
		this.followupOperator = followupOperator;
	}

	public String getFollowupOperatorName() {
		return followupOperatorName;
	}

	public void setFollowupOperatorName(String followupOperatorName) {
		this.followupOperatorName = followupOperatorName;
	}

	public Integer getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}

	public String getFollowupWayName() {
		return followupWayName;
	}

	public void setFollowupWayName(String followupWayName) {
		this.followupWayName = followupWayName;
	}

	public String getRelapseParts() {
		return relapseParts;
	}

	public void setRelapseParts(String relapseParts) {
		this.relapseParts = relapseParts;
	}

	public Date getRelapseDate() {
		return relapseDate;
	}

	public void setRelapseDate(Date relapseDate) {
		this.relapseDate = relapseDate;
	}

	public String getTransferParts() {
		return transferParts;
	}

	public void setTransferParts(String transferParts) {
		this.transferParts = transferParts;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public String getFollowupRemark() {
		return followupRemark;
	}

	public void setFollowupRemark(String followupRemark) {
		this.followupRemark = followupRemark;
	}

	public String getFollowupTaskId() {
		return followupTaskId;
	}

	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}

	public String getFollowupTaskName() {
		return followupTaskName;
	}

	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}

	public Date getSmsSendTime() {
		return smsSendTime;
	}

	public void setSmsSendTime(Date smsSendTime) {
		this.smsSendTime = smsSendTime;
	}

	public String getSmsReplyContent() {
		return smsReplyContent;
	}

	public void setSmsReplyContent(String smsReplyContent) {
		this.smsReplyContent = smsReplyContent;
	}

	public Long getValidFollowupOperator() {
		return validFollowupOperator;
	}

	public void setValidFollowupOperator(Long validFollowupOperator) {
		this.validFollowupOperator = validFollowupOperator;
	}

	public String getValidFollowupOperatorName() {
		return validFollowupOperatorName;
	}

	public void setValidFollowupOperatorName(String validFollowupOperatorName) {
		this.validFollowupOperatorName = validFollowupOperatorName;
	}

	public Integer getValidFollowupWay() {
		return validFollowupWay;
	}

	public void setValidFollowupWay(Integer validFollowupWay) {
		this.validFollowupWay = validFollowupWay;
	}

	public String getValidFollowupWayName() {
		return validFollowupWayName;
	}

	public void setValidFollowupWayName(String validFollowupWayName) {
		this.validFollowupWayName = validFollowupWayName;
	}

	public Integer getFollowupResultState() {
		return followupResultState;
	}

	public void setFollowupResultState(Integer followupResultState) {
		this.followupResultState = followupResultState;
	}
}

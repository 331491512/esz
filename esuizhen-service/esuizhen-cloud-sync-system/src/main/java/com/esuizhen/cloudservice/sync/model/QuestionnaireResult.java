package com.esuizhen.cloudservice.sync.model;

import java.util.Date;
import java.util.List;


public class QuestionnaireResult{
	
	/**
	 * 调查问卷结果ID。主键。QRES YYYYMMDDHHMMSSnnnnnn
	 */
	private String questionnaireResultId;
	/**
	 * 问卷ID
	 */
	private String questionnaireId;
	
	/**
	 * 问卷模版Id
	 */
	private String contentTemplateId;
	/**
	 * 患者ID
	 */
	private String patientId;
	
	/**
	 * 创建人姓名
	 */
	private String creatorName;
	
	/**
	 * 随访计划itemId
	 */
	private String followupItemId;
	
	/**
	 * 问卷标题
	 */
	private String subject;
	
	/**
	 * 问卷描述
	 */
	private String description;
	/**
	 * 为题列表
	 */
	private List<QuestionnaireResultStem> stemList;
	
	/**
	 * creatorId
	 */
	private Long creatorId;
	/**
	 * 填写人角色。1：患者；2：医生
	 */
	private Integer creatorRole;
	/**
	 * questionnaireResultUrl
	 */
	private String questionnaireResultUrl;
	/**
	 * 记录创建时间（回答时间）。
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	/**
	 * 合并标记取值调整
	 */
	private Integer mergeFlag;
	/**
	 * 被合并患者patientId
	 */
	private Long mergeFrom;
	/**
	 * 目标患者goalPatientId
	 */
	private Long mergeTarget;
	/**
	 * 合并时间
	 */
	private Date mergeTime;
	/**
	 * 问卷下发来源，默认1-云端，3-医院
	 */
	private Integer sourceFlag;
	/**
	 * 云端和B端同步标志
	 */
	private Integer syncFlag;
	
	/**
	 * 患者uuid
	 */
	private String patientUuid;
	
	public void setQuestionnaireResultId(String value) {
		this.questionnaireResultId = value;
	}
	
	public String getQuestionnaireResultId() {
		return this.questionnaireResultId;
	}
	public void setQuestionnaireId(String value) {
		this.questionnaireId = value;
	}
	
	public String getQuestionnaireId() {
		return this.questionnaireId;
	}
	public void setCreatorId(Long value) {
		this.creatorId = value;
	}
	
	public Long getCreatorId() {
		return this.creatorId;
	}
	public void setCreatorRole(Integer value) {
		this.creatorRole = value;
	}
	
	public Integer getCreatorRole() {
		return this.creatorRole;
	}
	public void setQuestionnaireResultUrl(String value) {
		this.questionnaireResultUrl = value;
	}
	
	public String getQuestionnaireResultUrl() {
		return this.questionnaireResultUrl;
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

	public String getPatientId()
	{
		return patientId;
	}

	public void setPatientId(String patientId)
	{
		this.patientId = patientId;
	}

	public List<QuestionnaireResultStem> getStemList()
	{
		return stemList;
	}

	public void setStemList(List<QuestionnaireResultStem> stemList)
	{
		this.stemList = stemList;
	}

	public String getFollowupItemId()
	{
		return followupItemId;
	}

	public void setFollowupItemId(String followupItemId)
	{
		this.followupItemId = followupItemId;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCreatorName()
	{
		return creatorName;
	}

	public void setCreatorName(String creatorName)
	{
		this.creatorName = creatorName;
	}

	public String getContentTemplateId() {
		return contentTemplateId;
	}

	public void setContentTemplateId(String contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}

	public Integer getMergeFlag() {
		return mergeFlag;
	}

	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}

	public Long getMergeFrom() {
		return mergeFrom;
	}

	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}

	public Long getMergeTarget() {
		return mergeTarget;
	}

	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}

	public Date getMergeTime() {
		return mergeTime;
	}

	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public String getPatientUuid() {
		return patientUuid;
	}

	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
}


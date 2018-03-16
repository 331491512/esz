package com.westangel.timertask.model;

import java.util.Date;


public class OpPushResultQueue{
	
	/**
	 * ID唯一标识
	 */
	private Integer pushResultQueueId;
	/**
	 * 推送规则ID
	 */
	private Integer pushRuleId;
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 全部文章ID（JSON数组）
	 */
	private String allPushArticleIdJson;
	/**
	 * 已推送文章ID（JSON数组）
	 */
	private String pushAtricleIdJson;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	public void setPushResultQueueId(Integer pushResultQueueId) {
		this.pushResultQueueId = pushResultQueueId;
	}
	
	public Integer getPushResultQueueId() {
		return this.pushResultQueueId;
	}
	public void setPushRuleId(Integer pushRuleId) {
		this.pushRuleId = pushRuleId;
	}
	
	public Integer getPushRuleId() {
		return this.pushRuleId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	public Long getPatientId() {
		return this.patientId;
	}
	public void setAllPushArticleIdJson(String allPushArticleIdJson) {
		this.allPushArticleIdJson = allPushArticleIdJson;
	}
	
	public String getAllPushArticleIdJson() {
		return this.allPushArticleIdJson;
	}
	public void setPushAtricleIdJson(String pushAtricleIdJson) {
		this.pushAtricleIdJson = pushAtricleIdJson;
	}
	
	public String getPushAtricleIdJson() {
		return this.pushAtricleIdJson;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}


}


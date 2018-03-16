package com.westangel.timertask.model;

import java.util.Date;


public class OpPushResult{
	
	/**
	 * ID唯一标识
	 */
	private Integer pushResultId;
	/**
	 * 推送规则ID
	 */
	private Integer pushRuleId;
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 文章ID
	 */
	private Integer articleId;
	
	/**
	 * 推送次数
	 */
	private Integer pushTimes;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	public void setPushResultId(Integer pushResultId) {
		this.pushResultId = pushResultId;
	}
	
	public Integer getPushResultId() {
		return this.pushResultId;
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
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	public Integer getArticleId() {
		return this.articleId;
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

	public Integer getPushTimes()
	{
		return pushTimes;
	}

	public void setPushTimes(Integer pushTimes)
	{
		this.pushTimes = pushTimes;
	}


}


package com.westangel.timertask.model;

import java.util.Date;


public class RpushRuleTag{
	
	/**
	 * ID唯一标识
	 */
	private Integer id;
	/**
	 * 推送规则ID
	 */
	private Long pushRuleId;
	/**
	 * 文章标签ID
	 */
	private Integer articleTagId;
	/**
	 * 患者标签ID
	 */
	private Integer patientTagId;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setPushRuleId(Long pushRuleId) {
		this.pushRuleId = pushRuleId;
	}
	
	public Long getPushRuleId() {
		return this.pushRuleId;
	}
	public void setArticleTagId(Integer articleTagId) {
		this.articleTagId = articleTagId;
	}
	
	public Integer getArticleTagId() {
		return this.articleTagId;
	}
	public void setPatientTagId(Integer patientTagId) {
		this.patientTagId = patientTagId;
	}
	
	public Integer getPatientTagId() {
		return this.patientTagId;
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


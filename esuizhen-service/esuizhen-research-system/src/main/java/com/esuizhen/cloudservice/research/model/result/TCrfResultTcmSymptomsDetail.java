package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;


public class TCrfResultTcmSymptomsDetail{
	
	/**
	 * 症状记录ID
	 */
	private String crfSymptomResultDetailId;
	/**
	 * 症状结果ID
	 */
	private String crfSymptomResultId;
	/**
	 * 症候ID
	 */
	private Integer tcmSymptomId;
	/**
	 * 中医症候名称
	 */
	private String tcmSymptomName;
	/**
	 * 症状描述
	 */
	private String description;
	
	/**
	 * 中医类型
	 */
	private String tcmType;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	public void setCrfSymptomResultDetailId(String value) {
		this.crfSymptomResultDetailId = value;
	}
	
	public String getCrfSymptomResultDetailId() {
		return this.crfSymptomResultDetailId;
	}
	public void setCrfSymptomResultId(String value) {
		this.crfSymptomResultId = value;
	}
	
	public String getCrfSymptomResultId() {
		return this.crfSymptomResultId;
	}
	public void setTcmSymptomId(Integer value) {
		this.tcmSymptomId = value;
	}
	
	public Integer getTcmSymptomId() {
		return this.tcmSymptomId;
	}
	public void setTcmSymptomName(String value) {
		this.tcmSymptomName = value;
	}
	
	public String getTcmSymptomName() {
		return this.tcmSymptomName;
	}
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setBeginTime(Date value) {
		this.beginTime = value;
	}
	
	public Date getBeginTime() {
		return this.beginTime;
	}
	public void setEndTime(Date value) {
		this.endTime = value;
	}
	
	public Date getEndTime() {
		return this.endTime;
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

	public String getTcmType()
	{
		return tcmType;
	}

	public void setTcmType(String tcmType)
	{
		this.tcmType = tcmType;
	}


}


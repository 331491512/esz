package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;

public class TCrfResultClinicalSymptomsDetailInfo{
	
	/**
	 * 症状记录ID。
	 */
	private String crfSymptomResultDetailId;
	/**
	 * 症状结果ID
	 */
	private String crfSymptomResultId;
	/**
	 * 症状类型ID。
	 */
	private Integer symptomId;
	/**
	 * 症状名称。如疲乏。
	 */
	private String symptomName;
	/**
	 * 症状程度 0：无；1：轻；2：中；3：重
	 */
	private Integer symptomDegree;
	/**
	 * 症状描述
	 */
	private String description;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	
	/**
	 * 数据下标
	 */
	private Integer index;
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
	public void setSymptomId(Integer value) {
		this.symptomId = value;
	}
	
	public Integer getSymptomId() {
		return this.symptomId;
	}
	public void setSymptomName(String value) {
		this.symptomName = value;
	}
	
	public String getSymptomName() {
		return this.symptomName;
	}
	public void setSymptomDegree(Integer value) {
		this.symptomDegree = value;
	}
	
	public Integer getSymptomDegree() {
		return this.symptomDegree;
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

	public Integer getIndex()
	{
		return index;
	}

	public void setIndex(Integer index)
	{
		this.index = index;
	}


}


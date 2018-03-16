package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;


public class TCrfPhysicalSignsInfo{
	/**
	 * 明细ID。主键。
	 */
	private String crfObserveItemId;
	/**
	 * crfObserveId
	 */
	private String crfObserveId;
	/**
	 * subjectElementId
	 */
	private String subjectElementId;
	/**
	 * 体征ID 外键：ehr_db.meta_physical_signs. physicalSignsId
	 */
	private Integer physicalSignsId;
	
	/**
	 * 体征名称
	 */
	private String physicalSignsName;
	
	/**
	 * 创建医生
	 */
	private Integer creator;
	
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public void setCrfObserveItemId(String value) {
		this.crfObserveItemId = value;
	}
	
	public String getCrfObserveItemId() {
		return this.crfObserveItemId;
	}
	public void setCrfObserveId(String value) {
		this.crfObserveId = value;
	}
	
	public String getCrfObserveId() {
		return this.crfObserveId;
	}
	public void setSubjectElementId(String value) {
		this.subjectElementId = value;
	}
	
	public String getSubjectElementId() {
		return this.subjectElementId;
	}
	public void setPhysicalSignsId(Integer value) {
		this.physicalSignsId = value;
	}
	
	public Integer getPhysicalSignsId() {
		return this.physicalSignsId;
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

	public String getPhysicalSignsName()
	{
		return physicalSignsName;
	}

	public void setPhysicalSignsName(String physicalSignsName)
	{
		this.physicalSignsName = physicalSignsName;
	}

	public Integer getCreator()
	{
		return creator;
	}

	public void setCreator(Integer creator)
	{
		this.creator = creator;
	}

	

}


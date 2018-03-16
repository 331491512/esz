package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;


public class TCrfSymptomTcmInfo{
	/**
	 * crfObserveItemId
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
	 * 症候ID 外键：ehr_db.meta_e_tcm_symptom.tcmSymptomId
	 */
	private Integer tcmSymptomId;
	/**
	 * 中医症候名称
	 */
	private String tcmSymptomName;
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


}


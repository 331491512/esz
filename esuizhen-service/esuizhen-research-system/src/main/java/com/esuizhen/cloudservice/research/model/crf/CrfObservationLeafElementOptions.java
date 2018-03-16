package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;


public class CrfObservationLeafElementOptions{
	/**
	 * crfObserveLeafId
	 */
	private String crfObserveLeafId;
	/**
	 * 观察项ID。外键。
	 */
	private String crfObserveId;
	/**
	 * 观察项标题元素。外键。
	 */
	private String subjectElementId;
	/**
	 * 叶子元素。如联系人姓名。外键。
	 */
	private String leafElementId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public void setCrfObserveLeafId(String value) {
		this.crfObserveLeafId = value;
	}
	
	public String getCrfObserveLeafId() {
		return this.crfObserveLeafId;
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
	public void setLeafElementId(String value) {
		this.leafElementId = value;
	}
	
	public String getLeafElementId() {
		return this.leafElementId;
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


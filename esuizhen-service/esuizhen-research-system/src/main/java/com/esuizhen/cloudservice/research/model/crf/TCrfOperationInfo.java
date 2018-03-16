package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;


public class TCrfOperationInfo{
	/**
	 * 明细ID
	 */
	private String crfObserveItemId;
	/**
	 * 观察项ID
	 */
	private String crfObserveId;
	/**
	 * 观察项。三级标题
	 */
	private String subjectElementId;
	/**
	 * 手术性质
	 */
	private String operationProperty;
	/**
	 * 手术名称
	 */
	private String operationName;
	/**
	 * 标准手术编码（CM-3）
	 */
	private String operationCode;
	//排序索引
	private Integer index;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

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
	public void setOperationProperty(String value) {
		this.operationProperty = value;
	}
	
	public String getOperationProperty() {
		return this.operationProperty;
	}
	public void setOperationName(String value) {
		this.operationName = value;
	}
	
	public String getOperationName() {
		return this.operationName;
	}
	public void setOperationCode(String value) {
		this.operationCode = value;
	}
	
	public String getOperationCode() {
		return this.operationCode;
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


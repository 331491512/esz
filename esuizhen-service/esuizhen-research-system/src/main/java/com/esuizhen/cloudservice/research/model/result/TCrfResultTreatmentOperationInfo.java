package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;


public class TCrfResultTreatmentOperationInfo{
	
	/**
	 * 手术结果ID
	 */
	private String crfTreatmentOperationResultId;
	/**
	 * Crf结果ID
	 */
	private String crfResultId;
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
	/**
	 * 手术日期
	 */
	private Date operationTime;
	//排序索引
	private Integer index;
	/**
	 * 创建时间（单据上传时间）
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

	public void setCrfTreatmentOperationResultId(String crfTreatmentOperationResultId) {
		this.crfTreatmentOperationResultId = crfTreatmentOperationResultId;
	}
	
	public String getCrfTreatmentOperationResultId() {
		return this.crfTreatmentOperationResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	
	public String getCrfResultId() {
		return this.crfResultId;
	}
	public void setOperationProperty(String operationProperty) {
		this.operationProperty = operationProperty;
	}
	
	public String getOperationProperty() {
		return this.operationProperty;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
	public String getOperationName() {
		return this.operationName;
	}
	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	
	public Date getOperationTime() {
		return this.operationTime;
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


package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;

/**
 * NNIS手术切口清洁度
 * 
 * @author zhuguo
 * @date 2017-9-30 15:45:07
 */
public class NNISOperationIncisionClean implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;

	// 代码
	private String operationIncisionCleanCode;

	// 名称
	private String operationIncisionCleanName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperationIncisionCleanCode() {
		return operationIncisionCleanCode;
	}

	public void setOperationIncisionCleanCode(String operationIncisionCleanCode) {
		this.operationIncisionCleanCode = operationIncisionCleanCode;
	}

	public String getOperationIncisionCleanName() {
		return operationIncisionCleanName;
	}

	public void setOperationIncisionCleanName(String operationIncisionCleanName) {
		this.operationIncisionCleanName = operationIncisionCleanName;
	}

}

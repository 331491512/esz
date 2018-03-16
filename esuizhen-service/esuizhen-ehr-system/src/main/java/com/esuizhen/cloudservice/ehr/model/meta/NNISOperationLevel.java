package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;

/**
 * NNIS手术级别
 * 
 * @author zhuguo
 * @date 2017-9-30 15:45:07
 */
public class NNISOperationLevel implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;

	// 代码
	private String operationLevelCode;

	// 名称
	private String operationLevelName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperationLevelCode() {
		return operationLevelCode;
	}

	public void setOperationLevelCode(String operationLevelCode) {
		this.operationLevelCode = operationLevelCode;
	}

	public String getOperationLevelName() {
		return operationLevelName;
	}

	public void setOperationLevelName(String operationLevelName) {
		this.operationLevelName = operationLevelName;
	}

}

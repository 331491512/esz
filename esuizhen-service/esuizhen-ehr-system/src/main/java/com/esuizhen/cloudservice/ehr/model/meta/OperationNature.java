package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;

/**
 * 手术操作性质
 * 
 * @author zhuguo
 * @date 2017-9-30 15:45:07
 */
public class OperationNature implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;

	// 代码
	private String operationNatureCode;

	// 名称
	private String operationNatureName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperationNatureCode() {
		return operationNatureCode;
	}

	public void setOperationNatureCode(String operationNatureCode) {
		this.operationNatureCode = operationNatureCode;
	}

	public String getOperationNatureName() {
		return operationNatureName;
	}

	public void setOperationNatureName(String operationNatureName) {
		this.operationNatureName = operationNatureName;
	}
}

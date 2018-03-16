package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;

/**
 * NNIS手术持续时间
 * 
 * @author zhuguo
 * @date 2017-9-30 15:45:07
 */
public class NNISOperationContinuedTime implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;

	// 代码
	private String operationContinuedTimeCode;

	// 名称
	private String operationContinuedTimeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperationContinuedTimeCode() {
		return operationContinuedTimeCode;
	}

	public void setOperationContinuedTimeCode(String operationContinuedTimeCode) {
		this.operationContinuedTimeCode = operationContinuedTimeCode;
	}

	public String getOperationContinuedTimeName() {
		return operationContinuedTimeName;
	}

	public void setOperationContinuedTimeName(String operationContinuedTimeName) {
		this.operationContinuedTimeName = operationContinuedTimeName;
	}

}

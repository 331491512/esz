package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;


public class TMetaInfoRelatives implements Serializable {
	private static final long serialVersionUID = 1L;

	//ID
	private Integer relationId;
	//关系名称
	private String relationName;
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	
}

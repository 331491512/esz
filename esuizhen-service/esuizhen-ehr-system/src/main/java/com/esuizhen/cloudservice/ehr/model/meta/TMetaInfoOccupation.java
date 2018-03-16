package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;


public class TMetaInfoOccupation implements Serializable{
	
	/**
	 * 职业数据id
	 */
	private Integer occupationId;
	/**
	 * 职业代码
	 */
	private String occupationCode;
	/**
	 * 职业上级代码
	 */
	private String parentCode;
	/**
	 * 职业名称
	 */
	private String occupationName;
	/**
	 * 职业描述
	 */
	private String description;

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}
	
	public Integer getOccupationId() {
		return this.occupationId;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	
	public String getOccupationCode() {
		return this.occupationCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	public String getParentCode() {
		return this.parentCode;
	}
	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
	
	public String getOccupationName() {
		return this.occupationName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}


}


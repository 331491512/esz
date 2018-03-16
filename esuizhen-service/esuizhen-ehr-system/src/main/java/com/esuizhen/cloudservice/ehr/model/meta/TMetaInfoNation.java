package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;


public class TMetaInfoNation implements Serializable{
	
	/**
	 * nationId
	 */
	private Integer nationId;
	/**
	 * 民族代码
	 */
	private String nationCode;
	/**
	 * 民族名称
	 */
	private String nationName;
	/**
	 * 罗马字母拼写
	 */
	private String romeCode;
	/**
	 * 字母代码
	 */
	private String pyCode;

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}
	
	public Integer getNationId() {
		return this.nationId;
	}
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}
	
	public String getNationCode() {
		return this.nationCode;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	
	public String getNationName() {
		return this.nationName;
	}
	public void setRomeCode(String romeCode) {
		this.romeCode = romeCode;
	}
	
	public String getRomeCode() {
		return this.romeCode;
	}
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}
	
	public String getPyCode() {
		return this.pyCode;
	}


}


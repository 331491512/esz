package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;


public class TMetaInfoNationality implements Serializable{
	
	/**
	 * 主键
	 */
	private Integer nationalityId;
	/**
	 * 国籍代码
	 */
	private String nationalityCode;
	/**
	 * 国籍名称
	 */
	private String nationalityName;

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}
	
	public Integer getNationalityId() {
		return this.nationalityId;
	}
	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}
	
	public String getNationalityCode() {
		return this.nationalityCode;
	}
	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	
	public String getNationalityName() {
		return this.nationalityName;
	}


}


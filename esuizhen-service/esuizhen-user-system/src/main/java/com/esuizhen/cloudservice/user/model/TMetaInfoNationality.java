package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;

/**
 * <p>Title:TMetaInfoNationality</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年6月23日 上午10:52:21
 */
public class TMetaInfoNationality implements Serializable {
	private static final long serialVersionUID = 1L;

	//ID
	private Integer nationalityId;
	//国籍代码
	private String nationalityCode;
	//国籍名称
	private String nationalityName;
	public Integer getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}
	public String getNationalityCode() {
		return nationalityCode;
	}
	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}
	public String getNationalityName() {
		return nationalityName;
	}
	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
}

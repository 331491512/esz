package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;

/**
 * 
 * @author YYCHEN
 *
 */
public class DoctorHospitalSearchByKeywordReq implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cityCode;
	private String keyword;
	private Long userId;
	private Integer page;
	private Integer num;
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}

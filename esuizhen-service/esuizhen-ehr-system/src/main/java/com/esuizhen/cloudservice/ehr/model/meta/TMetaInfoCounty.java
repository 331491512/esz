package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;


public class TMetaInfoCounty implements Serializable{
	
	/**
	 * countyId
	 */
	private Integer countyId;
	/**
	 * 县级代码
	 */
	private String countyCode;
	/**
	 * 县级名称
	 */
	private String countyName;
	/**
	 * 市级代码
	 */
	private String cityCode;
	/**
	 * 市级名称
	 */
	private String cityName;
	/**
	 * 省份代码
	 */
	private String provinceCode;
	/**
	 * 省份名称
	 */
	private String provinceName;
	/**
	 * 区域ID
	 */
	private Integer areaId;
	/**
	 * 区域名
	 */
	private String areaName;

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}
	
	public Integer getCountyId() {
		return this.countyId;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	
	public String getCountyCode() {
		return this.countyCode;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	
	public String getCountyName() {
		return this.countyName;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getCityCode() {
		return this.cityCode;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCityName() {
		return this.cityName;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	public String getProvinceCode() {
		return this.provinceCode;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	public String getProvinceName() {
		return this.provinceName;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	public Integer getAreaId() {
		return this.areaId;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	public String getAreaName() {
		return this.areaName;
	}


}


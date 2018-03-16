package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;


public class TMetaInfoFaultType implements Serializable {
	private static final long serialVersionUID = 1L;

	//ID
	private Integer id;
	//缺失字段代码
	private String code;
	//缺失字段名称
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

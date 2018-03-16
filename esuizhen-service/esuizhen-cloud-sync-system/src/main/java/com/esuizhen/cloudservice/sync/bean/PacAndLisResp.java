package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.List;

public class PacAndLisResp implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer code;
	private List<Object> faildList;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<Object> getFaildList() {
		return faildList;
	}
	public void setFaildList(List<Object> faildList) {
		this.faildList = faildList;
	}
}

package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;

/**
 * <p>Title:TMetaInfoNation</p>
 * <p>Description:民族元数据bean</p>
 * @author YYCHEN
 * @date 2016年6月23日 上午11:06:14
 */
public class TMetaInfoNation implements Serializable {
	private static final long serialVersionUID = 1L;

	//ID
	private Integer nationId;
	//民族代码
	private String nationCode;
	//民族名称
	private String nationName;
	//罗马字母拼写
	private String romeCode;
	//字母代码
	private String pyCode;
	public Integer getNationId() {
		return nationId;
	}
	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}
	public String getNationCode() {
		return nationCode;
	}
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getRomeCode() {
		return romeCode;
	}
	public void setRomeCode(String romeCode) {
		this.romeCode = romeCode;
	}
	public String getPyCode() {
		return pyCode;
	}
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}
}

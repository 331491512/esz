package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;

/**
 * NNIS麻醉分级
 * 
 * @author zhuguo
 * @date 2017-9-30 15:45:07
 */
public class NNISAnaesthesiaLevel implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;

	// 代码
	private String anaesthesiaLevelCode;

	// 名称
	private String anaesthesiaLevelName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnaesthesiaLevelCode() {
		return anaesthesiaLevelCode;
	}

	public void setAnaesthesiaLevelCode(String anaesthesiaLevelCode) {
		this.anaesthesiaLevelCode = anaesthesiaLevelCode;
	}

	public String getAnaesthesiaLevelName() {
		return anaesthesiaLevelName;
	}

	public void setAnaesthesiaLevelName(String anaesthesiaLevelName) {
		this.anaesthesiaLevelName = anaesthesiaLevelName;
	}

}

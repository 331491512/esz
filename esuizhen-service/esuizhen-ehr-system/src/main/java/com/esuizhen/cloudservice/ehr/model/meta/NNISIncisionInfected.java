package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;

/**
 * NNIS切口感染
 * 
 * @author zhuguo
 * @date 2017-9-30 15:45:07
 */
public class NNISIncisionInfected implements Serializable {
	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;

	// 代码
	private String incisionInfectedCode;

	// 名称
	private String incisionInfectedName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIncisionInfectedCode() {
		return incisionInfectedCode;
	}

	public void setIncisionInfectedCode(String incisionInfectedCode) {
		this.incisionInfectedCode = incisionInfectedCode;
	}

	public String getIncisionInfectedName() {
		return incisionInfectedName;
	}

	public void setIncisionInfectedName(String incisionInfectedName) {
		this.incisionInfectedName = incisionInfectedName;
	}

}

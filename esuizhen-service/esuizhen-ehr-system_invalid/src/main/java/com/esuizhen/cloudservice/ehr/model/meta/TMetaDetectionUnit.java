package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;
import java.util.Date;

public class TMetaDetectionUnit implements Serializable {
	private static final long serialVersionUID = 1L;
	//ID
	private Integer id;
	//单位名称
	private String unit;
	//创建时间
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

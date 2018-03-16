package com.esuizhen.base.model;

import java.util.Date;

public class GreyTestPatient {

	private Integer greyTestPatientId;
	
	private Long patientId;
	
	private Integer enable;
	
	private Integer productType;
	
	private String remark;
	
	private Date createTime;

	public Integer getGreyTestPatientId() {
		return greyTestPatientId;
	}

	public void setGreyTestPatientId(Integer greyTestPatientId) {
		this.greyTestPatientId = greyTestPatientId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

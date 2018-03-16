package com.esuizhen.base.model;

import java.util.Date;

public class GreyTestControl {

	private Integer testControlId;
	
	private Integer productType;
	
	private Integer greyTestCtlFlag;
	
	private Date createTime ;

	public Integer getTestControlId() {
		return testControlId;
	}

	public void setTestControlId(Integer testControlId) {
		this.testControlId = testControlId;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getGreyTestCtlFlag() {
		return greyTestCtlFlag;
	}

	public void setGreyTestCtlFlag(Integer greyTestCtlFlag) {
		this.greyTestCtlFlag = greyTestCtlFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}

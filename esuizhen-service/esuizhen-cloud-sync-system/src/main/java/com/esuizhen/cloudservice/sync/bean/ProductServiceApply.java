package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:ProductServiceApply</p>
 * <p>Description:服务申请表（s_product_service_apply）的bean</p>
 * @author fanpanwei
 * @date 2016年10月19日 上午11:36:36
 */
public class ProductServiceApply implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String productApplyId;
	private String trueName;
	private Integer progressState;
	private String description;
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getProgressState() {
		return progressState;
	}
	public void setProgressState(Integer progressState) {
		this.progressState = progressState;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

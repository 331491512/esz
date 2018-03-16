package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

public class ThirdParty implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer businessId=1;
	
	private Integer productId=2;

	private Long userId;

	private String openId;

	private Integer thirdPartyType;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getThirdPartyType() {
		return thirdPartyType;
	}

	public void setThirdPartyType(Integer thirdPartyType) {
		this.thirdPartyType = thirdPartyType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** 
	* @return businessId 
	*/
	public Integer getBusinessId() {
		return businessId;
	}

	/** 
	* @param businessId 要设置的 businessId 
	*/
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	/** 
	* @return productId 
	*/
	public Integer getProductId() {
		return productId;
	}

	/** 
	* @param productId 要设置的 productId 
	*/
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
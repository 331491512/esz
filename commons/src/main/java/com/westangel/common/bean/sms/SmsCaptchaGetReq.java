package com.westangel.common.bean.sms;

public class SmsCaptchaGetReq implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -6844858896528456312L;
	private Integer businessId;
	private Integer productId;
	private String mobile;
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
	/** 
	* @return mobile 
	*/
	public String getMobile() {
		return mobile;
	}
	/** 
	* @param mobile 要设置的 mobile 
	*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}

package com.westangel.commonservice.sms.model.BJMobile;

public class BJMobileChannelInfo {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 业务线ID
	 */
	private Integer businessId;
	/**
	 * 产品ID
	 */
	private Integer productId;
	
	/**
	 * 短信接入号码
	 */
	private String accessNumber;
	/**
	 * 业务代码
	 */
	private String serviceId;
	/** 
	* @return id 
	*/
	public Integer getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Integer id) {
		this.id = id;
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
	/** 
	* @return accessNumber 
	*/
	public String getAccessNumber() {
		return accessNumber;
	}
	/** 
	* @param accessNumber 要设置的 accessNumber 
	*/
	public void setAccessNumber(String accessNumber) {
		this.accessNumber = accessNumber;
	}
	/** 
	* @return serviceId 
	*/
	public String getServiceId() {
		return serviceId;
	}
	/** 
	* @param serviceId 要设置的 serviceId 
	*/
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
}

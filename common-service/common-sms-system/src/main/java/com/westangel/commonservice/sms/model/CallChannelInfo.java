package com.westangel.commonservice.sms.model;

public class CallChannelInfo {
	/**
	 * 
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
	 * 使用的通道名称
	 */
	private String channelName;
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
	* @return channelName 
	*/
	public String getChannelName() {
		return channelName;
	}
	/** 
	* @param channelName 要设置的 channelName 
	*/
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

}

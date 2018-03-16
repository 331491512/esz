package com.westangel.commonservice.sms.model.yuntongxun;

public class YuntongxunCallChannelInfo {
	/**
	 * 数据库编号
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
	 * 子账号
	 */
	private String subAccountSid;
	/**
	 * 
	 */
	private String subToken;
	/**
	 * 
	 */
	private String voipAccount;
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
	* @return subAccountSid 
	*/
	public String getSubAccountSid() {
		return subAccountSid;
	}
	/** 
	* @param subAccountSid 要设置的 subAccountSid 
	*/
	public void setSubAccountSid(String subAccountSid) {
		this.subAccountSid = subAccountSid;
	}
	/** 
	* @return subToken 
	*/
	public String getSubToken() {
		return subToken;
	}
	/** 
	* @param subToken 要设置的 subToken 
	*/
	public void setSubToken(String subToken) {
		this.subToken = subToken;
	}
	/** 
	* @return voipAccount 
	*/
	public String getVoipAccount() {
		return voipAccount;
	}
	/** 
	* @param voipAccount 要设置的 voipAccount 
	*/
	public void setVoipAccount(String voipAccount) {
		this.voipAccount = voipAccount;
	}
}

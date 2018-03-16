package com.westangel.commonservice.sms.model.yuntongxun;

public class YuntongxunChannelInfo {
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
	 * 主账号
	 */
	private String accountSid;
	/**
	 * 主账号令牌
	 */
	private String authToken;
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
	 * appId
	 */
	private String appId;
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
	* @return accountSid 
	*/
	public String getAccountSid() {
		return accountSid;
	}
	/** 
	* @param accountSid 要设置的 accountSid 
	*/
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	/** 
	* @return authToken 
	*/
	public String getAuthToken() {
		return authToken;
	}
	/** 
	* @param authToken 要设置的 authToken 
	*/
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
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
	* @return appId 
	*/
	public String getAppId() {
		return appId;
	}
	/** 
	* @param appId 要设置的 appId 
	*/
	public void setAppId(String appId) {
		this.appId = appId;
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

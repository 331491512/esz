package com.westangel.common.bean.weixin;

public class WeixinUserGetReq implements java.io.Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 3287122338194726822L;

	private Integer businessId;
	private Integer productId;
	private String access_token;
	private String openId;
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
	* @return openId 
	*/
	public String getOpenId() {
		return openId;
	}
	/** 
	* @param openId 要设置的 openId 
	*/
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
}

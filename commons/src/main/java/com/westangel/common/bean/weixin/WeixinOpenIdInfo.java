package com.westangel.common.bean.weixin;

/**
 * 
* @ClassName: WeixinOpenIdInfo 
* @Description: 微信open id 
* @author LIPENG
* @date 2016年1月4日 上午11:13:57 
*
 */
public class WeixinOpenIdInfo implements java.io.Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 6175766952666904186L;
	private Integer businessId;
	private Integer productId;
	private String openId;
	private String access_token;
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

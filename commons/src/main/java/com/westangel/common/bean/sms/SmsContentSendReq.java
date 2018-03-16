package com.westangel.common.bean.sms;

import java.util.List;

public class SmsContentSendReq implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 5467516487542833957L;
	/**
	 * 
	 */
	private Integer businessId;
	/**
	 * 
	 */
	private Integer productId;
	/**
	 * 
	 */
	private List<String> mobiles;
	/**
	 * 
	 */
	private String content;
	
	
	private String sendBackUrl;
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
	* @return mobiles 
	*/
	public List<String> getMobiles() {
		return mobiles;
	}
	/** 
	* @param mobiles 要设置的 mobiles 
	*/
	public void setMobiles(List<String> mobiles) {
		this.mobiles = mobiles;
	}
	/** 
	* @return content 
	*/
	public String getContent() {
		return content;
	}
	/** 
	* @param content 要设置的 content 
	*/
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendBackUrl() {
		return sendBackUrl;
	}
	public void setSendBackUrl(String sendBackUrl) {
		this.sendBackUrl = sendBackUrl;
	}
}

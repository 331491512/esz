package com.westangel.common.bean.sms;

public class SmsCaptchaCheckReq implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 业务线ID
	 */
	private Integer businessId;
	/**
	 * 产品ID
	 */
	private Integer productId;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 验证码
	 */
	private String captcha;
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
	/** 
	* @return captcha 
	*/
	public String getCaptcha() {
		return captcha;
	}
	/** 
	* @param captcha 要设置的 captcha 
	*/
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}

package com.westangel.commonservice.sms.model;
/**
 * 
* @ClassName: SmsCaptchaRecordInfo 
* @Description: 验证码记录 
* @author LIPENG
* @date 2015年12月22日 上午11:41:19 
*
 */
public class SmsCaptchaRecordInfo {
	/**
	 * 编号
	 */
	private Long id;
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
	 * 产生时间
	 */
	private String occurTime;
	
	/** 
	* @return id 
	*/
	public Long getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Long id) {
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
	/** 
	* @return occurTime 
	*/
	public String getOccurTime() {
		return occurTime;
	}
	/** 
	* @param occurTime 要设置的 occurTime 
	*/
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
}

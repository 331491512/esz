package com.westangel.commonservice.sms.model;
/**
 * 
* @ClassName: SmsChannelInfo 
* @Description: 验证码模版 
* @author LIPENG
* @date 2015年12月21日 下午1:52:26 
*
 */
public class SmsChannelInfo {
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
	 * 接入类型 0:验证码 1:内容
	 */
	private Integer accessType;
	/**
	 * 使用的通道名称
	 */
	private String channelName;
	/**
	 * 模版文本
	 */
	private String templateText;
	/**
	 * 权重（短信通道使用优先级）
	 */
	private Integer weight;

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
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
	/** 
	* @return templateText 
	*/
	public String getTemplateText() {
		return templateText;
	}
	/** 
	* @param templateText 要设置的 templateText 
	*/
	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}
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
	* @return accessType 
	*/
	public Integer getAccessType() {
		return accessType;
	}
	/** 
	* @param accessType 要设置的 accessType 
	*/
	public void setAccessType(Integer accessType) {
		this.accessType = accessType;
	}	
}

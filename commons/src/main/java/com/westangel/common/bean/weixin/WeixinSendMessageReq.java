package com.westangel.common.bean.weixin;

/**
 * 
* @ClassName: WeixinSendMessageReq 
* @Description: 微信消息 
* @author LIPENG
* @date 2016年1月12日 下午4:27:47 
*
 */
public class WeixinSendMessageReq implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -5827659739326462452L;
	/**
	 * 业务线Id
	 */
	private Integer businessId;
	/**
	 * 产品Id
	 */
	private Integer productId;
	/**
	 * 消息类型，重用PushConstValue.NotifyType
	 */
	private Integer contentType;
	/**
	 * 内容，PushWeixinData和PushWeixinTemplate
	 */
	private String content;
	/**
	 * openId
	 */
	private String openId;
	/** 
	* @return contentType 
	*/
	public Integer getContentType() {
		return contentType;
	}
	/** 
	* @param contentType 要设置的 contentType 
	*/
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
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
	@Override
	public String toString()
	{
		return "WeixinSendMessageReq [businessId=" + businessId + ", productId=" + productId + ", contentType=" + contentType + ", content=" + content + ", openId=" + openId + "]";
	}
	
	
}

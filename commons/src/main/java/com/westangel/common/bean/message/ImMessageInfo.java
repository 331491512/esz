package com.westangel.common.bean.message;

import java.io.Serializable;

/**
 * 
* @ClassName: contentType 
* @Description: 一条消息 
* @author LIPENG
* @date 2015年12月9日 下午4:37:38 
*
 */
public class ImMessageInfo implements Serializable {
	private static final long serialVersionUID = 2055158173365834430L;
	/**
	 * 消息编号
	 */
	private Long msgId;
	/**
	 * 聊天编号
	 */
	private Long chatId;
	/**
	 * 聊天类型
	 */
	private Integer chatType;
	/**
	 * 发言者编号
	 */
	private Long speakerId;
	/**
	 * 发言者角色
	 */
	private Integer speakerRole;
	/**
	 * 收听者编号
	 */	
	private Long audienceId;
	/**
	 * 收听者角色
	 */		
	private Integer audienceRole;
	/**
	 * 收听者编号
	 */
	private Integer audienceProductId;
	/**
	 * 内容类型
	 */			
	private Integer contentType;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 产生时间
	 */
	private String occurTime;
	/**
	 * 缓存索引
	 */
	private Long cacheIndex;
	/**
	 * 业务线编号
	 */
	private Integer businessId;
	/**
	 * 产品编号
	 */
	private Integer productId;
	/**
	 * 服务编号
	 */
	private Integer serviceId;
	/**
	 * 唯一标识
	 */
	private String uniqueId="";	
	/**
	 * 聊天提示语
	 */
	private String tipText="";
	/**
	 * 推送类型
	 */
	private Integer pushType=0;
	/**
	 * 推送内容
	 */
	private String pushContent="";
	/**
	 * 推送提示语
	 */
	private String pushTipText="";
	/**
	 * 发言者结构
	 */
	private ImSpeaker speaker;
	/**
	 * 是否在聊天列表隐藏
	 */
	private Integer hideInChatList=0;
	/**
	 * 是否来自与系统，如果是则只展示给接收方
	 */
	private Integer fromSystem=0;
	
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public Long getMsgId() {
		return msgId;
	}
	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}
	public Long getChatId() {
		return chatId;
	}
	public void setChatType(Integer chatType) {
		this.chatType = chatType;
	}
	public Integer getChatType() {
		return chatType;
	}
	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}
	public Long getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerRole(Integer speakerRole) {
		this.speakerRole = speakerRole;
	}
	
	public Integer getSpeakerRole() {
		return speakerRole;
	}
	
	public void setAudienceId(Long audienceId) {
		this.audienceId = audienceId;
	}
	public Long getAudienceId() {
		return audienceId;
	}
	public void setAudienceRole(Integer audienceRole) {
		this.audienceRole = audienceRole;
	}
	public Integer getAudienceRole() {
		return audienceRole;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setCacheIndex(Long cacheIndex) {
		this.cacheIndex = cacheIndex;
	}
	public Long getCacheIndex() {
		return cacheIndex;
	}
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	public String getOccurTime() {
		return occurTime;
	}
	
	public void setSpeaker(ImSpeaker speaker) {
		this.speaker = speaker;
	}
	
	public ImSpeaker getSpeaker() {
		return speaker;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	/** 
	* @return uniqueId 
	*/
	public String getUniqueId() {
		return uniqueId;
	}
	/** 
	* @param uniqueId 要设置的 uniqueId 
	*/
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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
	* @return serviceId 
	*/
	public Integer getServiceId() {
		return serviceId;
	}
	/** 
	* @param serviceId 要设置的 serviceId 
	*/
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	/** 
	* @return tipText 
	*/
	public String getTipText() {
		return tipText;
	}
	/** 
	* @param tipText 要设置的 tipText 
	*/
	public void setTipText(String tipText) {
		this.tipText = tipText;
	}
	/** 
	* @return hideInChatList 
	*/
	public Integer getHideInChatList() {
		return hideInChatList;
	}
	/** 
	* @param hideInChatList 要设置的 hideInChatList 
	*/
	public void setHideInChatList(Integer hideInChatList) {
		this.hideInChatList = hideInChatList;
	}
	/** 
	* @return pushType 
	*/
	public Integer getPushType() {
		return pushType;
	}
	/** 
	* @param pushType 要设置的 pushType 
	*/
	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}
	/** 
	* @return pushContent 
	*/
	public String getPushContent() {
		return pushContent;
	}
	/** 
	* @param pushContent 要设置的 pushContent 
	*/
	public void setPushContent(String pushContent) {
		this.pushContent = pushContent;
	}
	/** 
	* @return pushTipText 
	*/
	public String getPushTipText() {
		return pushTipText;
	}
	/** 
	* @param pushTipText 要设置的 pushTipText 
	*/
	public void setPushTipText(String pushTipText) {
		this.pushTipText = pushTipText;
	}
	/** 
	* @return fromSystem 
	*/
	public Integer getFromSystem() {
		return fromSystem;
	}
	/** 
	* @param fromSystem 要设置的 fromSystem 
	*/
	public void setFromSystem(Integer fromSystem) {
		this.fromSystem = fromSystem;
	}
	public Integer getAudienceProductId() {
		return audienceProductId;
	}
	public void setAudienceProductId(Integer audienceProductId) {
		this.audienceProductId = audienceProductId;
	}
}

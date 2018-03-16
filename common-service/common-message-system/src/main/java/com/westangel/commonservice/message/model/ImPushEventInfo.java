package com.westangel.commonservice.message.model;

public class ImPushEventInfo {
	/**
	 * 聊天编号
	 */
	private Long chatId;
	/**
	 * 聊天类型
	 */
	private Integer chatType;
	/**
	 * 发言者Id
	 */
	private Long speakerId;
	/**
	 * 发言者角色
	 */
	private Integer speakerRole;
	/**
	 * 收听者Id
	 */
	private Long audienceId;
	/**
	 * 收听者角色
	 */
	private Integer audienceRole;
	/**
	 * 内容
	 */
	private String briefText;
	/** 
	* @return chatId 
	*/
	public Long getChatId() {
		return chatId;
	}
	/** 
	* @param chatId 要设置的 chatId 
	*/
	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}
	/** 
	* @return chatType 
	*/
	public Integer getChatType() {
		return chatType;
	}
	/** 
	* @param chatType 要设置的 chatType 
	*/
	public void setChatType(Integer chatType) {
		this.chatType = chatType;
	}
	/** 
	* @return speakerId 
	*/
	public Long getSpeakerId() {
		return speakerId;
	}
	/** 
	* @param speakerId 要设置的 speakerId 
	*/
	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}
	/** 
	* @return speakerRole 
	*/
	public Integer getSpeakerRole() {
		return speakerRole;
	}
	/** 
	* @param speakerRole 要设置的 speakerRole 
	*/
	public void setSpeakerRole(Integer speakerRole) {
		this.speakerRole = speakerRole;
	}
	/** 
	* @return audienceRole 
	*/
	public Integer getAudienceRole() {
		return audienceRole;
	}
	/** 
	* @param audienceRole 要设置的 audienceRole 
	*/
	public void setAudienceRole(Integer audienceRole) {
		this.audienceRole = audienceRole;
	}
	/** 
	* @return audienceId 
	*/
	public Long getAudienceId() {
		return audienceId;
	}
	/** 
	* @param audienceId 要设置的 audienceId 
	*/
	public void setAudienceId(Long audienceId) {
		this.audienceId = audienceId;
	}
	/** 
	* @return briefText 
	*/
	public String getBriefText() {
		return briefText;
	}
	/** 
	* @param briefText 要设置的 briefText 
	*/
	public void setBriefText(String briefText) {
		this.briefText = briefText;
	}
}

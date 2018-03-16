package com.westangel.commonservice.push.model;

import java.util.Date;


public class EventInfoHistory{
	
	/**
	 * ID。主键, 自增
	 */
	private Long id;
	/**
	 * 通知ID。一个32位UUID字符串，唯一标志一个通知。
	 */
	private String eventId;
	/**
	 * 通知类型。
	 */
	private Integer eventType;
	/**
	 * 通知信息内容。
	 */
	private String eventInfo;
	/**
	 * 信息提示语。用于在通知栏展示。
	 */
	private String eventTip;
	/**
	 * 接收方（如医生）的userId。
	 */
	private Long userId;
	/**
	 * 是否读取标识。
	 */
	private Integer readFlag;
	/**
	 * 消息所在业务线编号
	 */
	private Integer businessId;
	/**
	 * 消息来源产品编号
	 */
	private Integer productId;
	/**
	 * APP类型。
	 */
	private String appType;
	/**
	 * 通知时间
	 */
	private Date sendTime;
	/**
	 * 已读时间
	 */
	private Date readTime;

	public EventInfoHistory()
	{
		
	}
	
	public EventInfoHistory(Long id, String eventId, Integer eventType, String eventInfo, String eventTip, Long userId, Integer readFlag, Integer businessId, Integer productId, String appType,
			Date sendTime, Date readTime)
	{
		super();
		this.id = id;
		this.eventId = eventId;
		this.eventType = eventType;
		this.eventInfo = eventInfo;
		this.eventTip = eventTip;
		this.userId = userId;
		this.readFlag = readFlag;
		this.businessId = businessId;
		this.productId = productId;
		this.appType = appType;
		this.sendTime = sendTime;
		this.readTime = readTime;
	}

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setEventId(String value) {
		this.eventId = value;
	}
	
	public String getEventId() {
		return this.eventId;
	}
	public void setEventType(Integer value) {
		this.eventType = value;
	}
	
	public Integer getEventType() {
		return this.eventType;
	}
	public void setEventInfo(String value) {
		this.eventInfo = value;
	}
	
	public String getEventInfo() {
		return this.eventInfo;
	}
	public void setEventTip(String value) {
		this.eventTip = value;
	}
	
	public String getEventTip() {
		return this.eventTip;
	}
	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	public void setReadFlag(Integer value) {
		this.readFlag = value;
	}
	
	public Integer getReadFlag() {
		return this.readFlag;
	}
	public void setBusinessId(Integer value) {
		this.businessId = value;
	}
	
	public Integer getBusinessId() {
		return this.businessId;
	}
	public void setProductId(Integer value) {
		this.productId = value;
	}
	
	public Integer getProductId() {
		return this.productId;
	}
	public void setAppType(String value) {
		this.appType = value;
	}
	
	public String getAppType() {
		return this.appType;
	}
	public void setSendTime(Date value) {
		this.sendTime = value;
	}
	
	public Date getSendTime() {
		return this.sendTime;
	}
	public void setReadTime(Date value) {
		this.readTime = value;
	}
	
	public Date getReadTime() {
		return this.readTime;
	}


}


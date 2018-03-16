package com.westangel.commonservice.message.model;


/**
* @author 作者 :LIPENG
* @version 创建时间：2015年12月5日 下午12:10:49
* 类说明
*/
public class ImChatInfo {
	//聊天编号
	private Long chatId;
	//聊天类型
	private Integer chatType;
	//标题
	private String chatTitle;
	//icon URL地址
	private String chatIconUrl;
	//发言者编号
	private Long speakerId;
	//发言者角色
	private Integer speakerRole;
	//收听者编号
	private Long audienceId;
	//收听者角色	
	private Integer audienceRole;
	//发言时间	
	private String occurTime;
	//提示语	
	private String tipText;
	//业务线编号	
	private Integer businessId;
	//产品编号
	private Integer productId;
	//服务编号	
	private Integer serviceId;
	//缓存索引	
	private Long cacheIndex;
	//未读条数	
	private Integer unreadAmount;
	//是否是VIP
	private Integer vipFlag;
	//出院标识
	private Integer outPatientFlag;
	//在院标识
	private Integer inhospitalState;
	
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
	public String getChatTitle() {
		return chatTitle;
	}
	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}
	public String getChatIconUrl() {
		return chatIconUrl;
	}
	public void setChatIconUrl(String chatIconUrl) {
		this.chatIconUrl = chatIconUrl;
	}
	public Long getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}
	public Integer getSpeakerRole() {
		return speakerRole;
	}
	public void setSpeakerRole(Integer speakerRole) {
		this.speakerRole = speakerRole;
	}
	public Long getAudienceId() {
		return audienceId;
	}
	public void setAudienceId(Long audienceId) {
		this.audienceId = audienceId;
	}
	public Integer getAudienceRole() {
		return audienceRole;
	}
	public void setAudienceRole(Integer audienceRole) {
		this.audienceRole = audienceRole;
	}
	public String getOccurTime() {
		return occurTime;
	}
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	public String getTipText() {
		return tipText;
	}
	public void setTipText(String tipText) {
		this.tipText = tipText;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Long getCacheIndex() {
		return cacheIndex;
	}
	public void setCacheIndex(Long cacheIndex) {
		this.cacheIndex = cacheIndex;
	}
	public Integer getUnreadAmount() {
		return unreadAmount;
	}
	public void setUnreadAmount(Integer unreadAmount) {
		this.unreadAmount = unreadAmount;
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
	* @return vipFlag 
	*/
	public Integer getVipFlag() {
		return vipFlag;
	}
	/** 
	* @param vipFlag 要设置的 vipFlag 
	*/
	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}
	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}
	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}
	public Integer getInhospitalState() {
		return inhospitalState;
	}
	public void setInhospitalState(Integer inhospitalState) {
		this.inhospitalState = inhospitalState;
	}
}

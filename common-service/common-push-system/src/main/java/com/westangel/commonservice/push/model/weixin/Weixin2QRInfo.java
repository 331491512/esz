package com.westangel.commonservice.push.model.weixin;

public class Weixin2QRInfo {
	private Long id;
	private Long userId;
	private Integer userRole;
	private String targetId="";
	private String serviceName="";
	private Integer ticketId=0;
	private String ticket="";
	private String url="";
	private String qrUrl="";
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
	* @return userId 
	*/
	public Long getUserId() {
		return userId;
	}
	/** 
	* @param userId 要设置的 userId 
	*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/** 
	* @return serviceName 
	*/
	public String getServiceName() {
		return serviceName;
	}
	/** 
	* @param serviceName 要设置的 serviceName 
	*/
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/** 
	* @return userRole 
	*/
	public Integer getUserRole() {
		return userRole;
	}
	/** 
	* @param userRole 要设置的 userRole 
	*/
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	/** 
	* @return ticketId 
	*/
	public Integer getTicketId() {
		return ticketId;
	}
	/** 
	* @param ticketId 要设置的 ticketId 
	*/
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	/** 
	* @return ticket 
	*/
	public String getTicket() {
		return ticket;
	}
	/** 
	* @param ticket 要设置的 ticket 
	*/
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	/** 
	* @return url 
	*/
	public String getUrl() {
		return url;
	}
	/** 
	* @param url 要设置的 url 
	*/
	public void setUrl(String url) {
		this.url = url;
	}
	/** 
	* @return qrUrl 
	*/
	public String getQrUrl() {
		return qrUrl;
	}
	/** 
	* @param qrUrl 要设置的 qrUrl 
	*/
	public void setQrUrl(String qrUrl) {
		this.qrUrl = qrUrl;
	}
	/** 
	* @return targetId 
	*/
	public String getTargetId() {
		return targetId;
	}
	/** 
	* @param targetId 要设置的 targetId 
	*/
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
}

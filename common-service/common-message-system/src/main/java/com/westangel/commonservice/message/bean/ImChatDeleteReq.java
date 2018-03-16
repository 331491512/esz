package com.westangel.commonservice.message.bean;
/**
* @author 作者 :LIPENG
* 
* @version 创建时间：2015年12月5日 下午12:23:30
* 类说明
*/
public class ImChatDeleteReq {
	//请求的用户编号
	private Long userId;
	//请求的用户角色
	private Integer userRole;
	//删除的聊天编号
	private Long chatId;
	//删除的聊天类型
	private Integer chatType;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	
}

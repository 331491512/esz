package com.westangel.commonservice.message.bean;

import java.util.List;

import com.westangel.common.bean.message.ImChatMemberInfo;

/**
* @author 作者 :LIPENG
* @version 创建时间：2015年12月5日 下午12:11:29
* 类说明
*/
public class ImChatCreateReq {
	//聊天编号
	private Long chatId=0L;
	//聊天类型
	private Integer chatType;	
	//创建者编号
	private Long userId;
	//创建者角色
	private Integer userRole;
	//成员列表
	private List<ImChatMemberInfo> members;
	//业务线编号
	private Integer businessId;
	
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
	* @return members 
	*/
	public List<ImChatMemberInfo> getMembers() {
		return members;
	}
	/** 
	* @param members 要设置的 members 
	*/
	public void setMembers(List<ImChatMemberInfo> members) {
		this.members = members;
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
}

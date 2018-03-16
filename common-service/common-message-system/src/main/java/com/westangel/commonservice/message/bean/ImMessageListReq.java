package com.westangel.commonservice.message.bean;
/**
* @author 作者 :LIPENG
* @version 创建时间：2015年12月5日 下午12:24:50
* 类说明
*/
public class ImMessageListReq {
	/**
	 *  用户编号
	 */
	private Long userId;
	/**
	 * 用户角色
	 */
	private Integer userRole;
	/**
	 * 聊天编号
	 */
	private Long chatId;
	/**
	 * 聊天类型
	 */
	private Integer chatType;
	
	/**
	 * 服务编号
	 */
	private Integer serviceId;
	/**
	 * 索引
	 */
	private Long beginAt;
	/**
	 * 方向
	 */
	private Integer pos;
	
	/**
	 * 数量
	 */
	private Integer num;
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	
	public Integer getUserRole() {
		return userRole;
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
	
	public Long getBeginAt() {
		return beginAt;
	}

	public void setBeginAt(Long beginAt) {
		this.beginAt = beginAt;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}
	public Integer getPos() {
		return pos;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}

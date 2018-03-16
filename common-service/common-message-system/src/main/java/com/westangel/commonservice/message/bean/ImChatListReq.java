package com.westangel.commonservice.message.bean;
/**
* @author 作者 :LIPENG
* @version 创建时间：2015年12月5日 下午12:18:22
* 类说明
*/
public class ImChatListReq {
	//请求用户编号
	private Long userId;
	//请求用户
	private Long userRole;
	//缓存
	private Long beginAt;
	//方向
	private Integer pos;
	//业务线编号
	private Integer businessId;
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserRole(Long userRole) {
		this.userRole = userRole;
	}
	
	public Long getUserRole() {
		return userRole;
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
}

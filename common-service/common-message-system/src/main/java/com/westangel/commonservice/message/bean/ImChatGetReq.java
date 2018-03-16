package com.westangel.commonservice.message.bean;

import java.util.List;

import com.westangel.common.bean.message.ImChatMemberInfo;
/**
 * 
* @ClassName: ImChatGetReq 
* @Description: 根据用户列表获取chatID请求 
* @author LIPENG
* @date 2016年4月19日 下午2:35:56 
*
 */
public class ImChatGetReq {
	//成员列表
	private List<ImChatMemberInfo> members;
	//业务线编号
	private Integer businessId;
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

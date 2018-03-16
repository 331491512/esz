package com.westangel.common.service;

import java.util.List;

import com.westangel.common.bean.message.ImChatMemberInfo;
import com.westangel.common.bean.message.ImMessageInfo;

/**
 * 
* @ClassName: MessageInnerService 
* @Description: 系统间发送消息
* @author LIPENG
* @date 2015年12月22日 下午5:49:13 
*
 */
public interface MessageInnerService {
	/**
	 * 
	* @Title: sendInnerMessage 
	* @Description: 发送消息 
	* @param @param message    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean sendInnerMessage(ImMessageInfo message);
	
	/**
	 * 
	* @Title: deleteChatViaMembers 
	* @Description: 通过成员删除聊天，两个为私聊，三个及以上为群组
	* @param @param members
	* @param @param chatType
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean deleteChatViaMembers(Integer businessId, List<ImChatMemberInfo> members);
}

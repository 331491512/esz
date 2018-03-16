package com.westangel.commonservice.message.service;

import java.util.List;

import com.westangel.common.bean.message.ImChatMemberInfo;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.service.MessageInnerService;
import com.westangel.commonservice.message.bean.ImChatBriefInfo;
import com.westangel.commonservice.message.bean.ImChatCreateReq;
import com.westangel.commonservice.message.bean.ImChatDeleteReq;
import com.westangel.commonservice.message.bean.ImChatListReq;
import com.westangel.commonservice.message.bean.ImMessageListReq;
import com.westangel.commonservice.message.model.ImChatInfo;

/**
* @author 作者 :LIPENG
* @version 创建时间：2015年12月5日 上午11:38:27
* 类说明
*/
public interface MessageService extends MessageInnerService {
	/**
	 * 
	* @Title: createChat 
	* @Description: 创建聊天 
	* @param @param req
	* @param @return    设定文件 
	* @return ImChatBriefInfo    返回类型 
	* @throws
	 */
	public ImChatBriefInfo createChat(ImChatCreateReq req);
	/**
	 * 
	* @Title: getChatList 
	* @Description: 获取聊天列表 
	* @param @param req
	* @param @return    设定文件 
	* @return List<ImChatInfo>    返回类型 
	* @throws
	 */
	public List<ImChatInfo> getChatList(ImChatListReq req);

	/**
	 * 
	* @Title: deleteChat 
	* @Description: 删除聊天 
	* @param @param req    删除聊天请求
	* @return void    返回类型 
	* @throws
	 */
	public void deleteChat(ImChatDeleteReq req);
	
	/**
	 * 
	* @Title: sendMessage 
	* @Description: 发送消息 
	* @param @param message    要发送的消息 
	* @return void    返回类型 
	* @throws
	 */
	public void sendMessage(ImMessageInfo message);
	
	/**
	 * 
	* @Title: getMessageList 
	* @Description: 获取消息列表 
	* @param @param req
	* @param @return    设定文件 
	* @return List<ImMessageInfo>    返回类型 
	* @throws
	 */
	public List<ImMessageInfo> getMessageList(ImMessageListReq req);
	
	/**
	 * 
	* @Title: getChatViaMembers 
	* @Description: 获取聊天信息 
	* @param @param businessId
	* @param @param members
	* @param @return    设定文件 
	* @return ImChatBriefInfo    返回类型 
	* @throws
	 */
	public ImChatBriefInfo getChatViaMembers(Integer businessId, List<ImChatMemberInfo> members);
}

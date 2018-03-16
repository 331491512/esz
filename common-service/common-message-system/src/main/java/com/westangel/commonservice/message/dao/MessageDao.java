package com.westangel.commonservice.message.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.message.ImChatMemberInfo;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.commonservice.message.bean.ImChatBriefInfo;
import com.westangel.commonservice.message.bean.ImChatCreateReq;
import com.westangel.commonservice.message.bean.ImChatListReq;
import com.westangel.commonservice.message.bean.ImMessageListReq;
import com.westangel.commonservice.message.model.ImChatInfo;
import com.westangel.commonservice.message.model.ImChatTip;


public interface MessageDao {
	
	/**
	 * 
	* @Title: getChatTipText 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<ImChatTip>    返回类型 
	* @throws
	 */
	public List<ImChatTip> getChatTipText();
	
	/**
	 * 
	* @Title: getChat 
	* @Description: 获取聊天 
	* @param @param req
	* @param @return    设定文件 
	* @return ImChatBriefInfo    返回类型 
	* @throws
	 */
	public ImChatBriefInfo getChat(
			@Param("businessId") Integer businessId,
			@Param("chatType") Integer chatType,
			@Param("memberCount") Integer memberCount,
			@Param("members") List<ImChatMemberInfo> members);
	
	/**
	 * 
	* @Title: addPrivateChat 
	* @Description: 创建私聊聊天 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addPrivateChat(ImChatCreateReq req);
	
	/**
	 * 
	* @Title: setChatRemovedFlag 
	* @Description: 设置聊天为移除状态 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void setChatRemovedFlag(
			@Param("chatId") Long chatId, 
			@Param("chatType") Integer chatType,
			@Param("userId") Long userId,
			@Param("userRole") Integer userRole,
			@Param("removeFlag") Integer removeFlag);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :reloadChatProductId
	 * @Description:重置聊天成员productId
	 * @return void
	 * @date 2016年6月12日 下午7:25:47
	 */
	public void reloadChatProductId(Object param);
	
	/**
	 * 
	* @Title: addChatMember 
	* @Description: 向聊天添加成员 
	* @param @param chatId
	* @param @param chatType
	* @param @param members    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addChatMember(
			@Param("businessId") Integer businessId,
			@Param("chatId") Long chatId, 
			@Param("chatType") Integer chatType, 
			@Param("members") List<ImChatMemberInfo> members);
	
	/**
	 * 
	* @Title: getChatList 
	* @Description: 获取聊天列表 
	* @param @param req
	* @param @return     
	* @return List<ImChatInfo>    返回类型 
	* @throws
	 */
	public List<ImChatInfo> getChatList(ImChatListReq req);
	
	/**
	 * 
	* @Title: addChatInfo 
	* @Description: 添加一条聊天信息 
	* @param @param chat    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addChatInfo(ImChatInfo chat);
	
	/**
	 * 
	* @Title: deleteChatInfoViaChatId 
	* @Description: 通过chatId删除聊天信息 
	* @param @param chatId
	* @param @param chatType    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteChatInfoViaChatId(
			@Param("chatId") Long chatId,
			@Param("chatType") Integer chatType);
	
	/**
	 * 
	* @Title: increaseChatUnreadAmount 
	* @Description: 增加未读条数 
	* @param @param chatId
	* @param @param chatType
	* @param @param userId
	* @param @param userRole    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void increaseChatUnreadAmount(
			@Param("chatId") Long chatId,
			@Param("chatType") Integer chatType,
			@Param("userId") Long userId,
			@Param("userRole") Integer userRole);
	
	/**
	 * 
	* @Title: clearChatUnreadAmount 
	* @Description: 清除未读条数 
	* @param @param chatId
	* @param @param chatType
	* @param @param userId
	* @param @param userRole    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void clearChatUnreadAmount(
			@Param("chatId") Long chatId,
			@Param("chatType") Integer chatType,
			@Param("userId") Long userId,
			@Param("userRole") Integer userRole);	
	/**
	 * 
	* @Title: sendMessage 
	* @Description: 发送消息 
	* @param @param messageInfo    要发送的消息 
	* @return void    返回类型 
	* @throws
	 */
	public void addMessage(ImMessageInfo messageInfo);
	
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
	* @Title: deleteMessageViaUniqueId 
	* @Description: 删除消息记录 
	* @param @param businessId
	* @param @param uniqueId    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteMessageViaUniqueId(
			@Param("businessId") Integer businessId,
			@Param("uniqueId") String uniqueId);
	
	/**
	 * 查询成员productId
	 * @author lichenghao
	 * @title :queryWxMemberProductId
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年6月14日 下午6:04:39
	 */
	public Integer queryWxMemberProductId(@Param("chatId")Long chatId,@Param("memberId")Long memberId,@Param("memberRole")Integer memberRole);
}

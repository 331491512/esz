package com.westangel.commonservice.message.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.tags.MessageTag;

import com.westangel.common.bean.message.ImChatMemberInfo;
import com.westangel.common.bean.message.ImConstValue;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.push.PushClientEventInfo;
import com.westangel.common.bean.push.PushConstValue;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.push.PushWeixinData;
import com.westangel.common.bean.push.PushWeixinTemplate;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.commonservice.message.bean.ImChatBriefInfo;
import com.westangel.commonservice.message.bean.ImChatCreateReq;
import com.westangel.commonservice.message.bean.ImChatDeleteReq;
import com.westangel.commonservice.message.bean.ImChatListReq;
import com.westangel.commonservice.message.bean.ImMessageListReq;
import com.westangel.commonservice.message.dao.MessageDao;
import com.westangel.commonservice.message.dao.UserDao;
import com.westangel.commonservice.message.model.ImChatInfo;
import com.westangel.commonservice.message.model.ImChatTip;
import com.westangel.commonservice.message.model.ImChatTipMap;
import com.westangel.commonservice.message.model.ImPushEventInfo;
import com.westangel.commonservice.message.service.MessageService;

@Service(value="messageService")
public class MessageServiceImpl implements MessageService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${server.wx.url.root}")
	private String weixinHTML; 
	
	@Value("${url.api.business.to.text.consulting}")
	private String richTextUrl; 
	
	@Autowired
	ImChatTipMap contentType2TipMap;
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PushInnerService pushService;
	
	@Autowired
	private MessageSource messageSource;
	
	private Locale locale=Locale.getDefault();
	
	/**
	 * 
	* @Title: initConfig 
	* @Description: 初始化配置 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@PostConstruct
	public void initConfig()
	{
		//配置内容类型到TipText的映射关系
		List<ImChatTip> tips = messageDao.getChatTipText();
		if (null != tips) {
			for (ImChatTip tip : tips){
				contentType2TipMap.put(tip.getContentType(), tip.getTipText());
			}
		}
	}
	
	/**
	 * 创建聊天
	 */
	@Override
	@Transactional
	public ImChatBriefInfo createChat(ImChatCreateReq req) {
		ImChatBriefInfo info = messageDao.getChat(req.getBusinessId(), req.getChatType(), req.getMembers().size(), req.getMembers());
		
		//已经创建，则清除聊天删除标记
		if (null != info) {
			messageDao.setChatRemovedFlag(info.getChatId(),info.getChatType(), req.getUserId(), req.getUserRole(), 0);
			//如果是私有 且 productId都不为null 重置productId
			if(info.getChatType()==ImConstValue.chatType.ChatTypePrivate.ordinal()&&req.getMembers()!=null&&req.getMembers().get(0)!=null&req.getMembers().get(0).getProductId()!=null&req.getMembers().get(1)!=null&&req.getMembers().get(1).getProductId()!=null){
				req.setChatId(info.getChatId());
				req.setChatType(info.getChatType());
				messageDao.reloadChatProductId(req);
			}
		}
		//如果没有创建，则创建
		else {
			//私聊
			if (ImConstValue.chatType.ChatTypePrivate.ordinal() == req.getChatType()) {
				ImChatMemberInfo m1 = req.getMembers().get(0);
				ImChatMemberInfo m2 = req.getMembers().get(1);
				m1.setPeerId(m2.getId());
				m1.setPeerRole(m2.getRole());;
				m2.setPeerId(m1.getId());
				m2.setPeerRole(m1.getRole());
				//创建私聊
				messageDao.addPrivateChat(req);
				//添加私聊成员
				messageDao.addChatMember(req.getBusinessId(), req.getChatId(), req.getChatType(), req.getMembers());
			}

			info = new ImChatBriefInfo();
			info.setChatType(req.getChatType());
			info.setChatId(req.getChatId());
		}
		return info;
	}
	
	/**
	 * 获取聊天列表
	 */
	@Override
	public List<ImChatInfo> getChatList(ImChatListReq req) {
		return messageDao.getChatList(req);
	}

	/**
	 * 删除聊天
	 */
	@Override
	public void deleteChat(ImChatDeleteReq req) {
		messageDao.setChatRemovedFlag(req.getChatId(), req.getChatType(), req.getUserId(), req.getUserRole(), 1);
	}

	/**
	 * 发送消息
	 */
	@Override
	@Transactional
	public void sendMessage(ImMessageInfo message) {
		//更新业务自定义 唯一标识 其他消息删除
		if (StringUtils.isNotEmpty(message.getUniqueId())) {
			messageDao.deleteMessageViaUniqueId(message.getBusinessId(), message.getUniqueId());
		}
		messageDao.addMessage(message);
		logger.info("sendMessage" + JsonUtil.toJson(message));
		//如果不在聊天列表中隐藏
		if (0 == message.getHideInChatList()) {
			//更新最后一条聊天信息
			messageDao.deleteChatInfoViaChatId(message.getChatId(), message.getChatType());		
			messageDao.addChatInfo(chatInfo4Message(message));
			//对方未读条数＋1
			messageDao.increaseChatUnreadAmount(message.getChatId(), message.getChatType(),message.getAudienceId(), message.getAudienceRole());
			//在chat列表中显示
			messageDao.setChatRemovedFlag(message.getChatId(), message.getChatType(), message.getSpeakerId(), message.getSpeakerRole(), 0);
			messageDao.setChatRemovedFlag(message.getChatId(), message.getChatType(), message.getAudienceId(), message.getAudienceRole(), 0);
		}
		
		try {
			push2Audience(message);	
		} catch (Exception e) {
			logger.info("sendMessage"+e.toString());
		}
	}
	
	/**
	 * 
	* @Title: push2Audience 
	* @Description: 推送给收听者，和业务相关
	* @param @param message 
	* @return void    返回类型 
	* @throws
	 */
	private void push2Audience(ImMessageInfo message)
	{
		//如果是私聊
		if (ImConstValue.chatType.ChatTypePrivate.ordinal() == message.getChatType()) {
			//如果发言者是医生，收听者是患者
			if (Constant.User.ROLE_PATIENT == message.getAudienceRole()
					&& Constant.User.ROLE_DOCTOR == message.getSpeakerRole()&&message.getFromSystem()!=1) {
				push4Doctor2Patient(message);
			}
			//如果发言者是患者，收听者是医生
			else if (Constant.User.ROLE_DOCTOR == message.getAudienceRole()
					&& Constant.User.ROLE_PATIENT == message.getSpeakerRole()){
				//设置产品类型
				message.setAudienceProductId(1);
				push4Patient2Doctor(message);
			}
			//如果发言者是系统，收听者是医生
			else if (Constant.User.ROLE_DOCTOR == message.getAudienceRole()
					&& Constant.User.ROLE_SYSTEM == message.getSpeakerRole()){
				push4System2Doctor(message);
			} else {
				invokePush(
						message, 
						message.getPushType(), 
						message.getPushContent(), 
						message.getPushTipText()
						);
			}
		}
	}
	
	
	/**
	 * 
	* @Title: push4System2Doctor 
	* @Description: 系统到医生 
	* @param @param message    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void push4System2Doctor(ImMessageInfo message)
	{
		String ntip = message.getPushTipText();
		if (StringUtils.isEmpty(ntip)){
			ntip = "您收到一条"+message.getSpeaker().getName()+"发来的消息";
		}
		ImPushEventInfo imEvent = new ImPushEventInfo();
		imEvent.setChatId(message.getChatId());
		imEvent.setChatType(message.getChatType());
		imEvent.setSpeakerId(message.getSpeakerId());
		imEvent.setSpeakerRole(message.getSpeakerRole());
		imEvent.setAudienceId(message.getAudienceId());
		imEvent.setAudienceRole(message.getAudienceRole());
		imEvent.setBriefText(ntip);
		
		String pushContent;
		if(StringUtils.isEmpty(message.getPushContent())){
			PushClientEventInfo event;
			event = new PushClientEventInfo();
			event.setEventType(PushClientEventInfo.EventType.EventTypeMessage.ordinal());
			event.setEventInfo(JsonUtil.toJson(imEvent));
			event.setEventTip(ntip);
			pushContent = JsonUtil.toJson(event);
		}else{
			pushContent = message.getPushContent();
		}
		
		invokePush(
				message, 
				PushConstValue.NotifyType.NotifyTypeClient.ordinal(),
				pushContent,
				ntip
				);		
	}
	/**
	 * 
	* @Title: push4Patient2Doctor 
	* @Description: 患者发送给医生 
	* @param @param message    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void push4Patient2Doctor(ImMessageInfo message)
	{
		String ntip = message.getPushTipText();
		if (StringUtils.isEmpty(ntip)){
			if (null != message.getSpeaker()) {
				ntip = "您收到一条" + message.getSpeaker().getName() + "发来的消息";
			} else {
				ntip = "";
			}
		}
		ImPushEventInfo imEvent = new ImPushEventInfo();
		imEvent.setChatId(message.getChatId());
		imEvent.setChatType(message.getChatType());
		imEvent.setSpeakerId(message.getSpeakerId());
		imEvent.setSpeakerRole(message.getSpeakerRole());
		imEvent.setAudienceId(message.getAudienceId());
		imEvent.setAudienceRole(message.getAudienceRole());
		imEvent.setBriefText(ntip);
		
		PushClientEventInfo event = new PushClientEventInfo();
		event.setEventType(PushClientEventInfo.EventType.EventTypeMessage.ordinal());
		event.setEventInfo(JsonUtil.toJson(imEvent));
		event.setEventTip(ntip);
		
		invokePush(
				message, 
				PushConstValue.NotifyType.NotifyTypeClient.ordinal(),
				JsonUtil.toJson(event),
				ntip
				);
	}
	
	/**
	 * 
	* @Title: push4Doctor2Patient 
	* @Description: 从医生到患者 
	* @param @param message    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void push4Doctor2Patient(ImMessageInfo message) {
		StringBuffer url = new StringBuffer();
		try {

			url.append(weixinHTML).append(richTextUrl).append("?").append("chatId=").append(message.getChatId())
					.append("&chatType=").append(message.getChatType()).append("&duserId=")
					.append(message.getSpeakerId()).append("&puserId=").append(message.getAudienceId());
			//获取展示内容
			String content = tipText4Message(message);
			//微信模版
			PushWeixinTemplate weixinTemplate = new PushWeixinTemplate();
			//模版内容拼装
			List<String> values = new ArrayList<String>();
			if(message.getServiceId()==Constant.Business.PRODUCT_TYPE_RICHTEXT){//图文咨询
				// temple values
				values.add(pushService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.richtextconsult.result.notify.topatient",
								new Object[] { message.getSpeaker().getName() })));
				values.add(pushService.getMessage(PushContentUtil.getBusinessPushContent("text.richtextconsult.title")));
				values.add(content.length() < 100 ? content : (content.substring(0, 99) + "..."));
				values.add(message.getSpeaker().getName());
				values.add(pushService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.richtextconsult.result.notify.topatient.1")));
				weixinTemplate.setName("zixunhuifutixing");
			}else if(message.getServiceId()==Constant.Business.PRODUCT_TYPE_FOLLOWUP_MESSAGE){//随访消息
				values.add(pushService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.new.followup.message.notify.topatient",
								new Object[] { message.getSpeaker().getName() })));
				values.add(message.getSpeaker().getName());
				values.add(DateUtil.getDateStr(new Date()));
				values.add(content.length() < 100 ? content : (content.substring(0, 99) + "..."));
				values.add(pushService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.new.followup.message.notify.topatient.remark")));
				weixinTemplate.setName("suifangtixing");
				url.append("&isFollowup=1");
			}else{
				return;
			}
			weixinTemplate.setUrl(url.toString());
			weixinTemplate.setValues(values);
			//如果找不到业务接口发送空消息
			if (message.getAudienceProductId() == null) {
				message.setAudienceProductId(messageDao.queryWxMemberProductId(message.getChatId(),
						message.getAudienceId(), message.getAudienceRole()));
			}
			invokePush(message, PushConstValue.NotifyType.NotifyTypeWXTemplate.ordinal(),
					JsonUtil.toJson(weixinTemplate), "");
		} catch (Exception e) {
			LogUtil.logError.error("send to weixin error ------------------" + e.getMessage());
		}
	}
	/**
	 * 
	* @Title: invokePush 
	* @Description: 调用推送服务，推送 
	* @param @param message
	* @param @param pushType
	* @param @param pushContent
	* @param @param pushTip    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void invokePush(ImMessageInfo message, Integer pushType, String pushContent, String pushTip)
	{
		if ((pushType >= PushConstValue.NotifyType.NotifyTypeWXData.ordinal() 
				&& pushType <= PushConstValue.NotifyType.NotifyTypeClient.ordinal())
				&& !StringUtils.isEmpty(pushContent)){
			//推送
			PushNotifyInfo notify = new PushNotifyInfo();
			notify.setBusinessId(message.getBusinessId());
			//接收方的productId
			notify.setProductId(message.getAudienceProductId()!=null?message.getAudienceProductId():message.getProductId());
			notify.setUserId(message.getAudienceId());
			notify.setUserRole(message.getAudienceRole());
			notify.setPushType(pushType);
			notify.setContent(pushContent);
			notify.setTipText(null==pushTip?"":pushTip);
			pushService.push(notify);
		}
	}
	
	/**
	 * 获取消息列表
	 */
	@Override
	@Transactional
	public List<ImMessageInfo> getMessageList(ImMessageListReq req) {
		//清空未读条数
		messageDao.clearChatUnreadAmount(req.getChatId(), req.getChatType(), req.getUserId(),req.getUserRole());
		List<ImMessageInfo> list = messageDao.getMessageList(req);
		if (null!=list && 0 == req.getBeginAt()) {
			List<ImMessageInfo> sort = new ArrayList<ImMessageInfo>();
			for (ImMessageInfo msg : list){
				sort.add(0, msg);
			}
			list = sort;
		}
		return list;
	} 
	
	/**
	 * 
	* @Title: chatCreateReq4Message 
	* @Description: 为消息创建聊天
	* @param @param messageInfo
	* @param @return    设定文件 
	* @return ImChatCreateReq    返回类型 
	* @throws
	 */
	private ImChatCreateReq chatCreateReq4Message(ImMessageInfo messageInfo) {
		//先创建聊天
		ImChatCreateReq req = new ImChatCreateReq();
		req.setBusinessId(messageInfo.getBusinessId());
		req.setUserId(messageInfo.getSpeakerId());
		req.setUserRole(messageInfo.getSpeakerRole());
		req.setChatType(messageInfo.getChatType());
		
		List<ImChatMemberInfo> members = new ArrayList<ImChatMemberInfo>();
		ImChatMemberInfo m1 = new ImChatMemberInfo();
		ImChatMemberInfo m2 = new ImChatMemberInfo();
		m1.setId(messageInfo.getSpeakerId());
		m1.setRole(messageInfo.getSpeakerRole());
		m1.setProductId(messageInfo.getAudienceProductId());
		m2.setId(messageInfo.getAudienceId());
		m2.setRole(messageInfo.getAudienceRole());
		m2.setProductId(messageInfo.getProductId());
		members.add(m1);
		members.add(m2);
		req.setMembers(members);
		return req;
	}
	
	/**
	 * 
	* @Title: chatInfo4Message 
	* @Description:  message->chatInfo
	* @param @param messageInfo
	* @param @return    设定文件 
	* @return ImChatInfo    返回类型 
	* @throws
	 */
	private ImChatInfo chatInfo4Message(ImMessageInfo messageInfo)
	{
		ImChatInfo chatInfo = new ImChatInfo();
		chatInfo.setChatId(messageInfo.getChatId());
		chatInfo.setChatType(messageInfo.getChatType());
		chatInfo.setSpeakerId(messageInfo.getSpeakerId());
		chatInfo.setSpeakerRole(messageInfo.getSpeakerRole());
		chatInfo.setAudienceId(messageInfo.getAudienceId());
		chatInfo.setAudienceRole(messageInfo.getAudienceRole());
		chatInfo.setTipText(tipText4Message(messageInfo));
		chatInfo.setBusinessId(messageInfo.getBusinessId());
		chatInfo.setProductId(messageInfo.getProductId());
		chatInfo.setServiceId(messageInfo.getServiceId());
		return chatInfo;
	}
	
	/**
	 * 
	* @Title: tipText4ContentType 
	* @Description: 提示语 
	* @param @param messageInfo
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String tipText4Message(ImMessageInfo message)
	{
		String tipText = message.getTipText();
		if (StringUtils.isEmpty(tipText)){
			tipText = contentType2TipMap.get(message.getContentType());
			if (StringUtils.isEmpty(tipText)) {
				if (ImConstValue.contentType.ContentTypeText.ordinal() == message.getContentType()) {
					tipText = message.getContent();
				}
			}
		}
		
		if (StringUtils.isEmpty(tipText)) {
			tipText = "新消息!";	
		}
		return tipText;
	}

	/**
	 * 系统间调用
	 */
	@Override
	@Transactional
	public boolean sendInnerMessage(ImMessageInfo message) {
		boolean result = false;
		try {		
			//1、创建聊天
			ImChatBriefInfo brief = createChat(chatCreateReq4Message(message));
			//2、发送消息
			message.setChatId(brief.getChatId());
			message.setChatType(brief.getChatType());
			sendMessage(message);
			result = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}

	/**
	 * 通过成员列表删除chat
	 */
	@Override
	public boolean deleteChatViaMembers(Integer businessId, List<ImChatMemberInfo> members) {
		boolean result = false;
		try {
			if (2 == members.size()){
				ImChatBriefInfo info = messageDao.getChat(businessId, ImConstValue.chatType.ChatTypePrivate.ordinal(), members.size(), members);
				if (null != info) {
					ImChatMemberInfo m1 = members.get(0);
					ImChatMemberInfo m2 = members.get(1);
					messageDao.setChatRemovedFlag(info.getChatId(), info.getChatType(), m1.getId(), m1.getRole(), 1);
					messageDao.setChatRemovedFlag(info.getChatId(), info.getChatType(), m2.getId(), m2.getRole(), 1);
				}
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}	
	
	
	/**
	 * 通过成员列表获取聊天信息
	 */
	@Override
	public ImChatBriefInfo getChatViaMembers(Integer businessId, List<ImChatMemberInfo> members) {
		
		if (2 == members.size()){
			return messageDao.getChat(businessId, ImConstValue.chatType.ChatTypePrivate.ordinal(), members.size(), members);
		}
		return null;
	} 
	
}
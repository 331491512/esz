package com.westangel.common.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.ImSpeaker;
import com.westangel.common.bean.message.structuration.TPicTextMsg;
import com.westangel.common.bean.message.structuration.TRichTextMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.constant.Constant;

public class ImMessageUtil {

	//返回一个系统内部的Im消息的初始赋值对象
	public static ImMessageInfo getSysImMessageInfo(){
		ImMessageInfo  im = new ImMessageInfo();
		im.setChatId(0L);
		im.setChatType(1);   //私聊
		im.setBusinessId(1);
		im.setProductId(1); // 发出给app
		im.setSpeakerRole(1);//代表患者
		im.setFromSystem(1);//代表系统发出。患者端看不到此消息。
		im.setAudienceRole(2);
		im.setContentType(7);
		im.setHideInChatList(0); //默认显示tips
		
		return im;
	}
	
	/**
	 * 创建tips型的消息
	 * @param serviceId
	 * @param fromUser
	 * @param toUser
	 * @param content
	 * @return
	 */
	public static ImMessageInfo getSysImMessageTips(int serviceId,Long fromUser,Long toUser,String content){
		ImMessageInfo  im = getSysImMessageInfo();
		im.setSpeakerId(fromUser);
		im.setAudienceId(toUser);
		im.setContent(content);
		im.setServiceId(serviceId);
		im.setHideInChatList(1); //不显示tips
		
		LogUtil.log.info("send tips to app doctor: from patient's userId="+fromUser+
				",to doctor's userId="+toUser+",im="+JSON.toJSONString(im));

		return im;
		
		
	}
	
	
	/**
	 * 创建Button类的消息
	 * @param serviceId
	 * @param fromUser
	 * @param toUser
	 * @param content
	 * @param uniqueId
	 * @param tipText
	 * @return
	 */
	public static ImMessageInfo getSysImMessageButton(int serviceId,Long fromUser,Long toUser,
			String content,String uniqueId,String tipText){
		ImMessageInfo  im = getSysImMessageInfo();
		im.setSpeakerId(fromUser);
		im.setAudienceId(toUser);
		im.setContent(content);
		im.setServiceId(serviceId);
		im.setContentType(101);
		im.setUniqueId(uniqueId);
		im.setTipText(tipText);
		im.setHideInChatList(0); //默认显示tips

		LogUtil.log.info("send button msg to app doctor: from patient's userId="+fromUser+
				",to doctor's userId="+toUser+",content="+content+",uniqueId="+uniqueId+",im="+JSON.toJSONString(im));

		return im;
	}
	/**
	 * 
	* @Title: getImMessage 
	* @Description: 获取一条IM消息 
	* @param @param businessId
	* @param @param productId
	* @param @param serviceId
	* @param @param speakerId
	* @param @param speakerRole
	* @param @param speakerName
	* @param @param audienceId
	* @param @param audienceRole
	* @param @param contentType
	* @param @param content
	* @param @param tipText
	* @param @param uniqueId
	* @param @param pushType
	* @param @param pushTipText
	* @param @param pushContent
	* @param @return    设定文件 
	* @return ImMessageInfo    返回类型 
	* @throws
	 */
	private static ImMessageInfo getImMessage(
			Integer fromSystem,
			Integer hideInChatList,
			Integer chatType,
			Integer businessId,
			Integer productId, 
			Integer serviceId, 
			Long speakerId,
			Integer speakerRole,
			String speakerName,
			Long audienceId,
			Integer audienceRole,
			Integer contentType, 
			String content,
			String tipText,
			String uniqueId,
			Integer pushType,
			String pushTipText,
			String pushContent)
	{
		ImMessageInfo im = new ImMessageInfo();
		im.setFromSystem(fromSystem);
		im.setHideInChatList(hideInChatList);
		im.setChatType(chatType);
		im.setBusinessId(businessId);
		im.setProductId(productId);
		im.setServiceId(serviceId);
		im.setSpeakerId(speakerId);
		im.setSpeakerRole(speakerRole);
		im.setAudienceId(audienceId);
		im.setAudienceRole(audienceRole);
		im.setContentType(contentType);
		im.setContent(stringWithString(content));
		im.setTipText(tipText);
		im.setUniqueId(stringWithString(uniqueId));
		im.setPushType(pushType);
		im.setPushTipText(stringWithString(pushTipText));
		im.setPushContent(stringWithString(pushContent));
		
		ImSpeaker speaker = new ImSpeaker();
		speaker.setId(speakerId);
		speaker.setRole(speakerRole);
		speaker.setName(stringWithString(speakerName));
		im.setSpeaker(speaker);
		return im;
	}
	
	/**
	 * 
	* @Title: getPicTextMessage 
	* @Description: 生成一个pictext消息结构 
	* @param @param description
	* @param @param picUrl
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getPicTextMessage(String description, List<String> picUrl)
	{
		TPicTextMsg picTextMsg = new TPicTextMsg();
		picTextMsg.setDescription(stringWithString(description));
		picTextMsg.setPicUrl(picUrl);
		
		TStructuredMsg<TPicTextMsg> msg = new TStructuredMsg<TPicTextMsg>();
		msg.setMsgType("pictext");
		msg.setMsgBody(picTextMsg);
		return JsonUtil.toJson(msg);
	}
	
	/**
	 * 
	* @Title: getRichTextMessage 
	* @Description:  获取一个richtext消息结构 
	* @param @param title
	* @param @param description
	* @param @param picUrl
	* @param @param bottomText
	* @param @param linkUrl
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getRichTextMessage(String title, String description, String picUrl, String bottomText, String linkUrl)
	{
		TRichTextMsg richTextMsg = new TRichTextMsg();
		richTextMsg.setTitle(stringWithString(title));
		richTextMsg.setDescription(stringWithString(description));
		richTextMsg.setPicUrl(stringWithString(picUrl));
		richTextMsg.setBottomText(stringWithString(bottomText));
		richTextMsg.setLinkUrl(stringWithString(linkUrl));
		
		TStructuredMsg<TRichTextMsg> msg = new TStructuredMsg<TRichTextMsg>();
		msg.setMsgType("richtext");
		msg.setMsgBody(richTextMsg);
		return JsonUtil.toJson(msg);
	}

	/**
	 * 
	* @Title: getEDoctorAssistTextMessage 
	* @Description: 易随诊医生助手文本消息 
	* @param @param userId
	* @param @param content
	* @param @return    设定文件 
	* @return ImMessageInfo    返回类型 
	* @throws
	 */
	public static ImMessageInfo getEDoctorAssistTextMessage(Long userId, String content, String tipText)
	{
		return getImMessage(0, 0, 1, 1, 1, 1, Constant.User.SuizhenAssist, 0, "随诊助手", userId, 2, 1, content, tipText, "", 0, "", "");
	}
	
	/**
	 * 
	* @Title: getEDoctorAssistCustomMessage 
	* @Description: 易随诊医生助手自定义消息，可以是richtext或者pictext 
	* @param @param userId
	* @param @param content
	* @param @param tipText
	* @param @return    设定文件 
	* @return ImMessageInfo    返回类型 
	* @throws
	 */
	public static ImMessageInfo getEDoctorAssistCustomMessage(Long userId, String content, String tipText)
	{
		return getImMessage(0, 0, 1, 1, 1, 1, Constant.User.SuizhenAssist, 0, "随诊助手", userId, 2, 101, content, tipText, "", 0, "", "");
	}
		
	/**
	 * 创建随诊助手消息
	 * @param userId ：医生的userId
	 * @param content: 发送的内容
	 * @param linkUrl： 链接url。如果是事件，则以event://host:port/schema 表示。
	 *                 如：event://host:port/user/profile 表示进入个人资料修改页。
	 * @param linkText 链接的显示文本
	 * @param picUrlList：图片地址列表
	 * @return
	 */
	public static ImMessageInfo getSysImMessageSuizhenAssist(Long userId,String content,String tipText,String linkUrl,String linkText,List<String> picUrlList){
		ImMessageInfo  im = getSysImMessageInfo();
		im.setSpeakerId(Constant.User.SuizhenAssist);
		im.setSpeakerRole(0); //代表系统-随诊助手. 但以患者角色出现
		im.setContentType(101);//复杂类型消息
		im.setAudienceId(userId);
		im.setFromSystem(1);
		im.setHideInChatList(0); //显示tips
		
	
		//构造一个简单图文类型的结构化消息
		TStructuredMsg<TPicTextMsg>  struMsg = new TStructuredMsg<TPicTextMsg>();
		TPicTextMsg picTextMsg = new TPicTextMsg();
		struMsg.setMsgType("pictext");
		struMsg.setMsgBody(picTextMsg);
		String description = content;
		if(linkUrl!=null && !linkUrl.isEmpty() && linkText!=null && !linkText.isEmpty())
		{
			description+="\n<a heref='"+linkUrl+"'>"+linkText+"</a>";
		}
		picTextMsg.setDescription(description);
		if(picUrlList!=null && picUrlList.size()>0)
			picTextMsg.setPicUrl(picUrlList);
		//转成json格式
		content = JSON.toJSONString(struMsg);
		im.setContent(content);
		im.setTipText(tipText);
		im.setPushTipText(tipText);
		LogUtil.log.info("send pictext msg to app doctor: from system to doctor userId="+userId+",imMessageInfo="+JSON.toJSONString(im));

		return im;

	}
	
	private static String stringWithString(String string)
	{
		return StringUtils.isEmpty(string) ? "" : string;
	}
	
	  public static void main(String args[]) {
	  }
	
}

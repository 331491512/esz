package com.westangel.commonservice.message.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.TBMsgResponse;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.commonservice.message.bean.ImChatBriefInfo;
import com.westangel.commonservice.message.bean.ImChatCreateReq;
import com.westangel.commonservice.message.bean.ImChatDeleteReq;
import com.westangel.commonservice.message.bean.ImChatGetReq;
import com.westangel.commonservice.message.bean.ImChatListReq;
import com.westangel.commonservice.message.bean.ImMessageListReq;
import com.westangel.commonservice.message.model.ImChatInfo;
import com.westangel.commonservice.message.service.MessageService;

@Controller
public class MessageController {
	/**
	 * 消息服务
	 */
	@Autowired
	MessageService msgService;
	/**
	 * 
	* @Title: imChatCreate 
	* @Description: 创建聊天 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<ImChatBriefInfo>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/chat/create",method=RequestMethod.POST)
	public TMsgResponse<ImChatBriefInfo> imChatCreate(@RequestBody ImChatCreateReq req){
		TMsgResponse<ImChatBriefInfo> msgResponse = new TMsgResponse<ImChatBriefInfo>();		
		try {
			msgResponse.setResult(msgService.createChat(req));
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			e.printStackTrace();
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: imChatList 
	* @Description: 获取聊天列表 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<List<ImChatInfo>>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/chat/list",method=RequestMethod.GET)
	public TMsgResponse<List<ImChatInfo>> imChatList(ImChatListReq req)
	{
		TMsgResponse<List<ImChatInfo>> msgResponse = new TMsgResponse<List<ImChatInfo>>();
		try {
			msgResponse.setResult(msgService.getChatList(req));
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
			e.printStackTrace();			
		}
		return msgResponse;
	}
	/**
	 * 
	* @Title: imChatGet 
	* @Description: 根据聊天双方获取聊天信息 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<ImChatBriefInfo>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/chat/briefinfo",method=RequestMethod.POST)	
	public TMsgResponse<ImChatBriefInfo> imChatGet(@RequestBody ImChatGetReq req){
		TMsgResponse<ImChatBriefInfo> msgResponse=new TMsgResponse<ImChatBriefInfo>();
		try {
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
			ImChatBriefInfo briefInfo = msgService.getChatViaMembers(req.getBusinessId(), req.getMembers());
			if (null != briefInfo) {
				msgResponse.setResult(briefInfo);	
			}
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
			e.printStackTrace();			
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: imChatDelete 
	* @Description: 删除聊天 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/chat/delete", method=RequestMethod.POST)
	public TBMsgResponse imChatDelete(@RequestBody ImChatDeleteReq req)
	{
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			msgService.deleteChat(req);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: imMessageSend 
	* @Description: 发送消息 
	* @param @param msg
	* @param @return     
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/message/send", method=RequestMethod.POST)	
	public TBMsgResponse imMessageSend(@RequestBody ImMessageInfo message) {
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			msgService.sendMessage(message);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			e.printStackTrace();
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: imMessageList 
	* @Description: 获取消息列表 
	* @param @return    设定文件 
	* @return TMsgResponse<ImMessageInfo>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/message/list")
	public TMsgResponse<List<ImMessageInfo>> imMessageList(ImMessageListReq req) {
		TMsgResponse<List<ImMessageInfo>> msgResponse = new TMsgResponse<List<ImMessageInfo>>();
		try {
			msgResponse.setResult(msgService.getMessageList(req));
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());			
		}
		return msgResponse;
	}
}

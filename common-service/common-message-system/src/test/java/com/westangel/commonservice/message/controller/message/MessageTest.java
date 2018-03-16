package com.westangel.commonservice.message.controller.message;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.westangel.common.bean.message.ImChatMemberInfo;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.util.JsonUtil;
import com.westangel.commonservice.message.bean.ImChatCreateReq;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })

public class MessageTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;
	private	MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	//创建聊天
	@Test
	public void createChat() throws Exception
	{
		//添加两个对话者
		List<ImChatMemberInfo> members = new ArrayList<ImChatMemberInfo>();
		ImChatMemberInfo m1 = new ImChatMemberInfo();
		ImChatMemberInfo m2 = new ImChatMemberInfo();
		m1.setId(1L);
		m1.setRole(1);
		
		m2.setId(2L);
		m2.setRole(1);
		members.add(m1);
		members.add(m2);
		
		//创建聊天信息
		ImChatCreateReq req = new ImChatCreateReq();
		req.setBusinessId(1);
		req.setUserId(1L);
		req.setUserRole(1);
		req.setChatType(1);
		req.setMembers(members);
		 
		String json = JsonUtil.toJson(req);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/im/chat/create").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	//发送消息
	@Test
	public void sendMessage() throws Exception
	{	
		
		String content = 
			"{\"msgBody\":{\"bottom\":{\"text\":\"查看病情主诉\",\"url\":\"event://dev.esuizhen.com:8082/doctorservice/order/detail?userId=13&orderId=ORDE20160122185317932354\"},\"button\":[{\"eventKey\":\"SERVICE_APPLY_ACCEPT_NO\",\"eventUrl\":\"http://dev.esuizhen.com:8082/business/product/application/accept\",\"param\":{\"acceptFlag\":3,\"productApplyId\":\"APPL20160122185324242058\"},\"text\":\"拒绝\"},{\"eventKey\":\"SERVICE_APPLY_TEL_ACCEPT_OK\",\"eventUrl\":\"http://dev.esuizhen.com:8082/business/product/application/accept\",\"param\":{\"acceptFlag\":2,\"productApplyId\":\"APPL20160122185324242058\"},\"text\":\"同意\"}],\"price\":\"0.01\",\"style\":\"horizontal\",\"title\":\"电话咨询\"},\"msgType\":\"button\"}";
			ImMessageInfo messageInfo = new ImMessageInfo();
			messageInfo.setChatId(24L);
			messageInfo.setChatType(1);
			messageInfo.setSpeakerId(66L);
			messageInfo.setSpeakerRole(1);
			messageInfo.setAudienceId(13L);
			messageInfo.setAudienceRole(2);
			messageInfo.setContentType(101);
			messageInfo.setContent(content);
			messageInfo.setBusinessId(1);
			messageInfo.setProductId(1);
			messageInfo.setServiceId(1);
			messageInfo.setHideInChatList(1);
			messageInfo.setFromSystem(1);
//			ImSpeaker speaker = new ImSpeaker();
//			speaker.setId(66L);
//			speaker.setRole(1);
//			speaker.setName("张学东");
//			speaker.setHeadUrl("http://20image.esuizhen.com/resource/icon/1452740032554_ico.jpg");
//			messageInfo.setSpeaker(speaker);
//			messageInfo.setUniqueId("order-1");
					
			String json = JsonUtil.toJson(messageInfo);
			logger.info("req="+json);
			MvcResult result = this.mockMvc.perform(  
					MockMvcRequestBuilders.post("/message/send").characterEncoding("UTF-8")  
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(json.getBytes())
	                    ).andReturn();
			logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	//删除聊天
	@Test
	public void deleteChat() throws Exception
	{
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.get("/im/chat/delete?"+"userId=2&userRole=1&chatId=1&chatType=1").characterEncoding("UTF-8")  
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());				
	}
	
	//获取聊天列表
	@Test
	public void getChatList() throws Exception
	{
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.get("/im/chat/list?"+"userId=2&userRole=1&begAt=0&pos=1&businessId=1&productId=1").characterEncoding("UTF-8")  
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());		
	}
	
	//获取消息列表
	@Test
	public void getMessageList() throws Exception
	{
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.get("/im/message/list?"+"userId=1&userRole=1&chatId=1&chatType=1&begAt=0&pos=1").characterEncoding("UTF-8")  
                ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
}

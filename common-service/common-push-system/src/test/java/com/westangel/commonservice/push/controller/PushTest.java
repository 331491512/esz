package com.westangel.commonservice.push.controller;

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

import com.westangel.common.bean.push.PushClientEventInfo;
import com.westangel.common.bean.push.PushConstValue;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.push.PushWeixinData;
import com.westangel.common.bean.push.PushWeixinTemplate;
import com.westangel.common.bean.weixin.WeixinOpenIdGetReq;
import com.westangel.common.bean.weixin.WeixinQRReq;
import com.westangel.common.util.JsonUtil;
import com.westangel.commonservice.push.bean.PushBindReq;
import com.westangel.commonservice.push.model.weixin.WeixinChannelInfo;
import com.westangel.commonservice.push.model.weixin.WeixinTemplateInfo;
import com.westangel.commonservice.push.model.xiaomi.XiaomiChannelInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })

public class PushTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;
	private	MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void addWeixinChannel() throws Exception
	{
		WeixinChannelInfo channel = new WeixinChannelInfo();
		channel.setBusinessId(1);
		channel.setProductId(1);
		channel.setServiceName("esuizhen_doctor");
		channel.setAppId("wx9ea0c1dfa80ebf36");
		channel.setAppSecret("656b53a17e9abf9f6b882c67b98ab683");
		
		String json = JsonUtil.toJson(channel);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/push/weixin/channel/update").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void bindWeixin() throws Exception
	{
		PushBindReq req = new PushBindReq();
		req.setUserId(1L);
		req.setUserRole(1);
		req.setBusinessId(1);
		req.setProductId(1);
		req.setBindType(PushConstValue.BindType.BindTypeWeixin.ordinal());
		req.setDeviceType(PushConstValue.DeviceType.DeviceTypeWeixin.ordinal());
		req.setDeviceToken("123456");
		
		String json = JsonUtil.toJson(req);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/push/bind").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void addWeixinTemplate() throws Exception
	{
		WeixinTemplateInfo template = new WeixinTemplateInfo();
		template.setWeixinId("WJtKtNtINgi6pNjhApvZ__1nNy0RQAmyQJe8dV07Rl8");
		template.setWeixinExpression("keyword1,keyword2,keyword3");
		template.setName("reply");
		template.setRemark("咨询回复提醒");
		
		String json = JsonUtil.toJson(template);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/push/weixin/template/add").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void pushWeixinData() throws Exception
	{
		
		PushWeixinData data = new PushWeixinData();
		data.setContent("你好");
		data.setContentType("text");
		
		PushNotifyInfo notify = new PushNotifyInfo();
		notify.setUserId(1L);
		notify.setUserRole(1);
		notify.setBusinessId(1);
		notify.setProductId(1);
		notify.setPushType(PushConstValue.NotifyType.NotifyTypeWXData.ordinal());
		notify.setContent(JsonUtil.toJson(data));
		
		String json = JsonUtil.toJson(notify);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/push/notify").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());

	}
	
	@Test
	public void pushWeixinTemplate() throws Exception
	{
		List<String> values = new ArrayList<String>();
		values.add("first");
		values.add("keyword1");
		values.add("keyword2");
		values.add("keyword3");
		values.add("keyword4");
		values.add("remark");
		PushWeixinTemplate template = new PushWeixinTemplate();
		template.setName("yizhutuisongtongzhi");
//		template.setUrl("http://www.sina.com.cn");
		template.setValues(values);
		
		PushNotifyInfo notify = new PushNotifyInfo();
		notify.setUserId(20L);
		notify.setUserRole(1);
		notify.setBusinessId(1);
		notify.setProductId(2);
		notify.setPushType(PushConstValue.NotifyType.NotifyTypeWXTemplate.ordinal());
		notify.setContent(JsonUtil.toJson(template));
		
		String json = JsonUtil.toJson(notify);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/notify").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void getOpenId() throws Exception
	{
		WeixinOpenIdGetReq req = new WeixinOpenIdGetReq();
		req.setBusinessId(1);
		req.setProductId(2);
		req.setCode("xxxxx");
		String json = JsonUtil.toJson(req);
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/weixin/openId/get").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void getQR() throws Exception
	{
		WeixinQRReq req = new WeixinQRReq();
		req.setBusinessId(1);
		req.setProductId(2);
		req.setUserId(1L);
		req.setUserRole(1);

		String json = JsonUtil.toJson(req);
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/weixin/qr/get").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
		
	} 
	
	@Test
	public void getLocation() throws Exception
	{
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.get("/weixin/location/get?lat=37&lng=110").characterEncoding("UTF-8")  
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}  
	
	@Test
	public void addXiaomiChannel() throws Exception
	{
		XiaomiChannelInfo channel = new XiaomiChannelInfo();
		channel.setBusinessId(1);
		channel.setProductId(1);
		channel.setAppType("android");
		channel.setAppId("2882303761517250570");
		channel.setAppKey("5251725035570");
		channel.setAppSecret("KK1j5V66FaDnCsTa/KUs3A==");
		channel.setAppPackageName("com.yiyee.doctor");
		
		String json = JsonUtil.toJson(channel);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/push/xiaomi/channel/update").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void bindXiaomi() throws Exception
	{
		PushBindReq req = new PushBindReq();
		req.setUserId(1L);
		req.setUserRole(1);
		req.setBusinessId(1);
		req.setProductId(1);
		req.setBindType(PushConstValue.BindType.BindTypeXiaomi.ordinal());
		req.setDeviceType(PushConstValue.DeviceType.DeviceTypeAndroid.ordinal());
		req.setDeviceToken("123456");
		
		String json = JsonUtil.toJson(req);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/push/bind").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void pushClientData() throws Exception
	{			
		PushClientEventInfo event = new PushClientEventInfo();
		event.setEventType(PushClientEventInfo.EventType.EventTypeMessage.ordinal());
		event.setEventInfo("hello");
		event.setEventTip("你好");
		
		PushNotifyInfo notify = new PushNotifyInfo();
		notify.setUserId(13L);
		notify.setUserRole(2);
		notify.setBusinessId(1);
		notify.setProductId(1);
		notify.setPushType(PushConstValue.NotifyType.NotifyTypeClient.ordinal());
		notify.setContent(JsonUtil.toJson(event));
		notify.setTipText("你好");
		
		String json = JsonUtil.toJson(notify);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/notify").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());

	}
}

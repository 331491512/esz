package com.westangel.commonservice.sms.controller;

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

import com.westangel.common.bean.sms.CallTwoWayReq;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })

public class SmsTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;
	private	MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void sendCaptcha() throws Exception
	{		
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.get("/captcha/get?"+"businessId=1&productId=3&mobile=18611292320").characterEncoding("UTF-8")  
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());			
		
	}
	
	@Test
	public void checkCaptcha() throws Exception
	{
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.get("/captcha/check?"+"businessId=1&productId=1&mobile=18500972641&captcha=788857").characterEncoding("UTF-8")  
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());			
	}
	
	@Test
	public void sendContent() throws Exception
	{
		List<String> mobiles = new ArrayList<String>();
		mobiles.add("18611292320");
		SmsContentSendReq req = new SmsContentSendReq();
		req.setBusinessId(1);
		req.setProductId(1);
		req.setMobiles(mobiles);
		req.setContent("hello");
		
		
		String json = JsonUtil.toJson(req);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/sms/content/send").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());

	}
	
	@Test
	public void sendTemplateContent() throws Exception
	{		
		List<String> values = new ArrayList<String>();
		values.add("test0");
		values.add("test1");
		
		SmsTemplateSendReq req = new SmsTemplateSendReq();
		req.setBusinessId(1);
		req.setProductId(1);
		req.setMobile("18611292320");
		req.setTemplateName("yuyuejiahaotongyi");
		req.setValues(values);
		String json = JsonUtil.toJson(req);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/msg/template/send").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());		
	}
	
	@Test
	public void callTwoway() throws Exception
	{
		CallTwoWayReq req = new CallTwoWayReq();
		req.setBusinessId(1);
		req.setProductId(1);
		req.setFrom("18611292320");
		req.setTo("18146515613");
		req.setFromSerNum("10086");
		req.setToSerNum("10086");
		String json = JsonUtil.toJson(req);
		
		logger.info("req="+json);
		MvcResult result = this.mockMvc.perform(  
				MockMvcRequestBuilders.post("/call/twoway").characterEncoding("UTF-8")  
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json.getBytes())
                    ).andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
}

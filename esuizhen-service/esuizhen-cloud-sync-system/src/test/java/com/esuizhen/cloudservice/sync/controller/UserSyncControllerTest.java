package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class UserSyncControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void confirmTest() {
		TConfirmUserReq confirmUserReq = new TConfirmUserReq();
		/*
		confirmUserReq.setUuid("fd844ee2c6fb11e58f8e74d435ac1e2f");
		confirmUserReq.setUserId(1903222L);
		confirmUserReq.setIsConfirmed(1);
		confirmUserReq.setUserRole(1);
		confirmUserReq.setMobile("18501251337");
		confirmUserReq.setCaptcha("251364");
		*/
		
		confirmUserReq.setUserRole(1);
		confirmUserReq.setIsConfirmed(1);
		confirmUserReq.setMobile("18501251337");
		confirmUserReq.setUuid("patient185012513370001");
		confirmUserReq.setUserId(2036342L);
		
		MockHttpServletRequestBuilder post = post("/confirm").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(confirmUserReq));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(confirmUserReq)));
		try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}

	}
}

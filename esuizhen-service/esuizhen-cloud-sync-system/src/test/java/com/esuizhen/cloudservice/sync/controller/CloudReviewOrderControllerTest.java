package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSyncProfile;
import com.esuizhen.cloudservice.sync.service.PatientService;
import com.westangel.common.bean.User;
import com.westangel.common.util.Codec;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class CloudReviewOrderControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void syncReviewOrderFromCloud_test(){
		MockHttpServletRequestBuilder get = get("/fromcloud/order/review").
				param("hospitalId", "19193");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

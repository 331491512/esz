package com.esuizhen.cloudservice.user.controller.user.followuppatient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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

import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LostFollowupPatientControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	@Ignore
	public void aqueryLostFollowPatient() throws Exception {
		TPatientSearchInfo  patientSearchInfo = new TPatientSearchInfo();
		patientSearchInfo.setUserId(1l);
//		patientSearchInfo.setPatientNo("001010000001");
		MockHttpServletRequestBuilder post = post("/lostfollow/patient/list").content(JsonUtil.toJson(patientSearchInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("1#####################result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	@Ignore
	public void cupdateLostFollowPatient() throws Exception {
		MockHttpServletRequestBuilder get = get("/lostfollow/patient/update?patientId=2");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("3#####################result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
//	@Ignore
	public void batchRevokeLostFollowPatient() throws Exception {
		List<Long>  patientIds = new ArrayList<Long>();
		patientIds.add(123L);
		patientIds.add(234L);
		MockHttpServletRequestBuilder post = post("/lostfollow/patient/batch/revoke").content(JsonUtil.toJson(patientIds)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("1#####################result=\n"+result.getResponse().getContentAsString());
	}
}

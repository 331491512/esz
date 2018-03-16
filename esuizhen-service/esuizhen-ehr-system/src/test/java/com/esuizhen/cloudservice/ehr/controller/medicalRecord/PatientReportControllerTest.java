package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.esuizhen.cloudservice.ehr.bean.PatientReportResp;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class PatientReportControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void getNewReportList() throws Exception {

		PatientReportResp resp = new PatientReportResp();
		resp.setPatientId(1954988l);
		resp.setPage(0);
		resp.setNum(10);

		System.out.println(JsonUtil.toJson(resp));
		MockHttpServletRequestBuilder post = post("/report/list/new").content(
				JsonUtil.toJson(resp)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk())
				.andDo(print()).andReturn();
		logger.info("result=\n"
				+ JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void getMoreReportList() throws Exception {

		PatientReportResp resp = new PatientReportResp();
		resp.setPatientId(1954988l);
		resp.setPage(0);
		resp.setNum(10);

		System.out.println(JsonUtil.toJson(resp));
		MockHttpServletRequestBuilder post = post("/report/list/more").content(
				JsonUtil.toJson(resp)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk())
				.andDo(print()).andReturn();
		logger.info("result=\n"
				+ JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

}

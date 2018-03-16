package com.esuizhen.cloudservice.ehr.controller.treatment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.ParentTreatmentInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class PatientTreatmentControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void queryPatientTreatment() throws Exception {
		CommonReq req = new CommonReq();
		req.setPatientId(1954812l);
		req.setInhospitalId("EINH20170411100016472557");
		MockHttpServletRequestBuilder post = post("/patient/treatment/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());
		
	}

	
	@Test
	public void savePatientTreatment() throws Exception {
		ParentTreatmentInfo info = new ParentTreatmentInfo();
		info.setPatientId(2l);
		info.setTreatmentName("化疗");

		String json = JsonUtil.toJson(info);

		System.err.println(json);

		MockHttpServletRequestBuilder post = post("/patient/treatment/save").content(json).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());

	}
	
	@Test
	public void savePatientTreatmentDetailTest() throws Exception {
		ParentTreatmentInfo info = new ParentTreatmentInfo();
		info.setPatientId(2l);
		info.setTreatmentName("化疗");

		String json = JsonUtil.toJson(info);

		System.err.println(json);

		MockHttpServletRequestBuilder post = post("/patient/treatment/detail/save").content(json).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());

	}
	
}

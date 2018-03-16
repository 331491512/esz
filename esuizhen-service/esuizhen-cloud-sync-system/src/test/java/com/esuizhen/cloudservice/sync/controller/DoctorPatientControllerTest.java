package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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
import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.westangel.common.util.Codec;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class DoctorPatientControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	/**
	    { 
			"patientUuid":"350000es34n6i3n790djjde33s",
			"doctorUuid":"350000es34n6i3n790djjdhy3s", 
			"hospitalId":15
			"source":3
		}
	 */
	@Test
	public void syncDoctorTest() {
		DoctorPatient doctorPatient = new DoctorPatient();
		doctorPatient.setPatientUuid("patient185012513370002");
		doctorPatient.setDoctorUuid("doctor18146515613001");
		doctorPatient.setHospitalId(100L);
		doctorPatient.setSourceFlag(3);
		MockHttpServletRequestBuilder post = post("/tocloud/user/relation/patient/ofdoctor").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(doctorPatient));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(doctorPatient)));
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

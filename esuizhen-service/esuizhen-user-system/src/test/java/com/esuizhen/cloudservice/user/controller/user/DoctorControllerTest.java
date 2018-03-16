package com.esuizhen.cloudservice.user.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.esuizhen.cloudservice.user.bean.DoctorListReq;
import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class DoctorControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void getDoctorTagList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/doctor/tag/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void searchDoctorTest() throws Exception {
		DoctorProfile doctorProfile = new DoctorProfile();
		doctorProfile.setMobile("18501251337");
		
		MockHttpServletRequestBuilder post = post("/doctor/search").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(doctorProfile));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(doctorProfile)));
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	@Test
	public void searchDoctorHospitalByKeywordTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/doctor/search/bykeyword?keyword=医生&page=0&num=3");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void listDoctorsOfPatientTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/doctor/ofpatient/list?patientId=7");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void recommendDoctorTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/doctor/recommed?patientId=7&hospitalId=100");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void getDoctorList_test() {
		DoctorListReq doctorListReq = new DoctorListReq();
		
		MockHttpServletRequestBuilder post = post("/doctor/list").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(doctorListReq));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(doctorListReq)));
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

}

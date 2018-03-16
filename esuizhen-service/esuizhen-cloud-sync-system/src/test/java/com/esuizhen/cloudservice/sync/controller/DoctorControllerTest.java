package com.esuizhen.cloudservice.sync.controller;

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

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
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
	
	/**
	 * 
	  { 
			"opFlag":0,  //0:新增； 1：修改
			"uuid":”350000es34n6i3n790djjde33s”，
			"userNumber":”001256”,
			"trueName”:”老王”,
			"sex":1,
			"mobile":"13566666666",
			"email":"laowang@test.com"，
			"deptUuid":"asfasdfasdf415454",
			"childDeptUuid":1,
			"professionalRankId":13,
			"positionTitleId":101, 
			"hospitalId":15,
			"idType":1,
			"identification": "10045614782215455555",
			"birthDate":"2015-09-08 09:06:06"
		}
	 * 
	 */
	@Test
	public void syncDoctorTest() {
		TDoctorSyncProfile doctorSyncProfile = new TDoctorSyncProfile();
		doctorSyncProfile.setOpFlag(1);
		doctorSyncProfile.setUuid("doctor18146515613001");
		doctorSyncProfile.setTrueName("葫芦丝");
		doctorSyncProfile.setMobile("18501251337");
		/*
		doctorSyncProfile.setUserNumber("N1102");
		doctorSyncProfile.setSex(1);
		doctorSyncProfile.setEmail("test@esuizhen.com");
		doctorSyncProfile.setDeptUuid("a2806f4bc8dd11e58f8e74d435ac1e2f");
		doctorSyncProfile.setChildDeptUuid("a3edab12c8dd11e58f8e74d435ac1e2f");
		doctorSyncProfile.setProfessionalRankId(1);
		doctorSyncProfile.setPositionTitleId(4);
		doctorSyncProfile.setHospitalId(100);
		try {
			String[] parsePatterns = new String[]{"YYYY-MM-dd"};
			doctorSyncProfile.setBirthDate(org.apache.commons.lang.time.DateUtils.parseDate("1978-07-08", parsePatterns));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 */
		//doctorSyncProfile.setIdType(1);
		//doctorSyncProfile.setIdentification("");
		
		MockHttpServletRequestBuilder post = post("/tocloud/user/doctor").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(doctorSyncProfile));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(doctorSyncProfile)));
		try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void testSendNotifyTest() throws Exception {
		//MockHttpServletRequestBuilder get = get("/verify?userName=not");
		MockHttpServletRequestBuilder get = get("/testSendNotify/doctor?cloudDoctorUserId=2036389");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
}

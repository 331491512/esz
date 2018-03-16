package com.westangel.commonservice.authorization.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.util.Codec;
import com.westangel.common.util.JsonUtil;
import com.westangel.commonservice.authorization.bean.TUserDoctorInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class UserControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void login_test() {
		User userProfile = new User();
//		userProfile.setUserName("supermanage");
//		userProfile.setCryptPasswd(Codec.hexMD5("123456"));
		//userProfile.setUserName("lifang");
		//userProfile.setCryptPasswd("123456");
//		userProfile.setUserName("zjt4415");
//		userProfile.setCryptPasswd("123456");
//		userProfile.setUserName("zjt888");
//		userProfile.setCryptPasswd(Codec.hexMD5("123456"));
//		userProfile.setUserName("18501251337");
//		userProfile.setCryptPasswd("e10adc3949ba59abbe56e057f20f883e");
		userProfile.setUserName("18700000003");
		userProfile.setCryptPasswd("e10adc3949ba59abbe56e057f20f883e");
		//userProfile.setRole(0);
		
		MockHttpServletRequestBuilder post = post("/login").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userProfile));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(userProfile)));
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
	public void modifyPasswd_test() {
		UserProfile userProfile = new UserProfile();
		userProfile.setUserId(5L);
		userProfile.setObsoletePassword("123456");
		userProfile.setCryptPasswd("1234567");
		userProfile.setConfirmFlag(1);
		
		MockHttpServletRequestBuilder post = post("/user/passwd/modify").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userProfile));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(userProfile)));
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
	public void getUserList_test() {
		TUserDoctorInfo userDoctorInfo = new TUserDoctorInfo();
		//userDoctorInfo.setUserName("王三");
		userDoctorInfo.setAccountTypeFlag(1);
		userDoctorInfo.setPage(0);
		userDoctorInfo.setNum(10);
		MockHttpServletRequestBuilder post = post("/user/list").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userDoctorInfo));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(userDoctorInfo)));
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
	public void addUser_test() {
		TUserDoctorInfo userDoctorInfo = new TUserDoctorInfo();
		User user = new User();
		Doctor doctor = new Doctor();
		List<Doctor> subordinateUserList = new ArrayList<Doctor>();
		Doctor subordDoctor1 = new Doctor();
		
		user.setUserName("fuyuanzhang");
		user.setMobile("17777777776");
		user.setCryptPasswd("123456");
		user.setSubroles("5");
		user.setEmail("esuizhen@esuizhen.com");
		user.setSex(1);
		user.setUserRole(5);
		
		doctor.setPositionTitle(1);
		doctor.setSex(1);
		doctor.setMobile(user.getMobile());
		doctor.setStaffNo("123456789");
		doctor.setParentId(24462L);
		
		subordDoctor1.setDoctorId(11L);
		
		subordinateUserList.add(subordDoctor1);
		
		doctor.setSubordinateUserList(subordinateUserList);
		
		userDoctorInfo.setUserProfile(user);
		userDoctorInfo.setDoctorProfile(doctor);
		MockHttpServletRequestBuilder post = post("/user/add").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userDoctorInfo));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(userDoctorInfo)));
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
	public void updateUser_test() {
		TUserDoctorInfo userDoctorInfo = new TUserDoctorInfo();
		User user = new User();
		Doctor doctor = new Doctor();
		List<Doctor> subordinateUserList = new ArrayList<Doctor>();
		Doctor subordDoctor1 = new Doctor();
		
		user.setUserId(5L);
		user.setUserName("yuanzhang");
		user.setMobile("17777777777");
		user.setCryptPasswd("123456");
		user.setSubroles("4");
		user.setEmail("esuizhen@esuizhen.com");
		user.setSex(1);
		user.setUserRole(4);
		
		doctor.setPositionTitle(1);
		doctor.setSex(1);
		doctor.setMobile(user.getMobile());
		doctor.setStaffNo("123456789");
		
		subordDoctor1.setDoctorId(12L);
		
		subordinateUserList.add(subordDoctor1);
		
		doctor.setSubordinateUserList(subordinateUserList);
		
		//user.setAccountType(4);
		
		userDoctorInfo.setUserProfile(user);
		userDoctorInfo.setDoctorProfile(doctor);
		MockHttpServletRequestBuilder post = post("/user/update").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userDoctorInfo));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(userDoctorInfo)));
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
	public void updateUserState_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/user/state/update?userId=2185736&state=1");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void getManagerInfo_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/manager/user/obtain?userId=5");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void updateManagerInfo_test() {
		User user = new User();
		user.setUserId(5L);
		user.setEmail("esuizhen@esuizhen.com");
		MockHttpServletRequestBuilder post = post("/manager/info/update").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(user));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(user)));
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
	public void getOrganizationStructure_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/organizational/structure/search?hospitalId=19193&userId=5");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void activationOrCancellation_test() {
		UserProfile userProfile = new UserProfile();
		userProfile.setUserId(15L);
		userProfile.setAccountType(0);
		userProfile.setUserName("10000000015");
		userProfile.setCryptPasswd("e10adc3949ba59abbe56e057f20f883e");
		
		MockHttpServletRequestBuilder post = post("/user/activation/cancellation").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userProfile));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(userProfile)));
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

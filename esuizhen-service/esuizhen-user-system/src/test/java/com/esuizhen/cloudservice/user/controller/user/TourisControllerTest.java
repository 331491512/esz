package com.esuizhen.cloudservice.user.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.esuizhen.cloudservice.user.bean.PasswordModifyReq;
import com.esuizhen.cloudservice.user.bean.UserRegisterReq;
import com.esuizhen.cloudservice.user.model.UUserDevice;
import com.esuizhen.cloudservice.user.service.UserService;
import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.LoginByThirdPartyReq;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.SourceDiagnosisInfo;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileModifyReq;
import com.westangel.common.util.Codec;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class TourisControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void guestUserAccess_test() {
		UserRegisterReq userRegisterReq = new UserRegisterReq();
		UUserDevice deviceInfo = new UUserDevice();
		
		//登陆所使用的设备
		deviceInfo.setDeviceId("7255edced3d70f2");
		deviceInfo.setDeviceType(3);
		deviceInfo.setPhoneVendorId(0);
		deviceInfo.setPhoneBrand("HUAWEI");
		deviceInfo.setBussinessId(1);
		deviceInfo.setProductId(1);
		deviceInfo.setAppVersion("3.4.5");
		deviceInfo.setIccid("46001");
		deviceInfo.setLuid("7255edced3d70f2");
		
		//用户角色
		userRegisterReq.setRole(2);
		userRegisterReq.setDeviceInfo(deviceInfo);
		
		MockHttpServletRequestBuilder post = post("/guest/access").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userRegisterReq));
		System.out.println("请求：\n" + JsonUtil.beautiful(JsonUtil.toJson(userRegisterReq)));
	    try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}

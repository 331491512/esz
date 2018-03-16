package com.esuizhen.cloudservice.user.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

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
	@Ignore
	public void verify() throws Exception {
		//MockHttpServletRequestBuilder get = get("/verify?userName=not");
		MockHttpServletRequestBuilder get = get("/verify?userName=13253212358");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void modifyPassword() {
		PasswordModifyReq passwordModifyReq = new PasswordModifyReq();
		passwordModifyReq.setAuthcode("036144");
		passwordModifyReq.setMobile("13253212358");
		passwordModifyReq.setNewPasswd(Codec.MD5Code("123456"));
		System.out.println(JsonUtil.toJson(passwordModifyReq));
		MockHttpServletRequestBuilder post = post("/passwdmodify").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(passwordModifyReq));
		MvcResult result;
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(passwordModifyReq)));
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
	public void getDetailUserProfileTest() {
		MockHttpServletRequestBuilder get = get("/profile/detail?userId=2036459&role=1&relationId=51");
		MvcResult result;
		try {
			result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			logger.error(e.getCause() + e.getMessage());
		}
	}

	@Test
	public void loginTest() {
		UserRegisterReq userRegisterReq = new UserRegisterReq();
		try {
			userRegisterReq.setCryptPasswd(Codec.hexMD5("123456"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		userRegisterReq.setDeviceInfo(null);
		userRegisterReq.setInvitationCode(null);
		userRegisterReq.setLoginType(2);
		userRegisterReq.setRole(2);
		userRegisterReq.setUserName("18501251337");
		System.out.println(JsonUtil.toJson(userRegisterReq));
		MockHttpServletRequestBuilder post = post("/login").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.beautiful(JsonUtil.toJson(userRegisterReq)));
		MvcResult result;
		System.out.println("请求参数：\n" + JsonUtil.toJson(userRegisterReq));
		try {
			System.out.println("MD5转后后的字符串" + Codec.hexMD5("123456"));
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	@Test
	public void loginByThirdPartyTest() {
		LoginByThirdPartyReq loginByThirdPartyReq=new LoginByThirdPartyReq();
		loginByThirdPartyReq.setOpenId("oON9qszQ8p547EEG_NhpxCtMNYTg");
		loginByThirdPartyReq.setThirdPartyType(2);
		MockHttpServletRequestBuilder post = post("/thirdparty/login").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(loginByThirdPartyReq));
	    try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
    @Test
    public void bindUserTest(){
		LoginByThirdPartyReq loginByThirdPartyReq=new LoginByThirdPartyReq();
        loginByThirdPartyReq.setUserId(142L);
        loginByThirdPartyReq.setOpenId("oON9qszQ8p547EEG_NhpxCtMNYTg");
        loginByThirdPartyReq.setAuthcode("495173");
		loginByThirdPartyReq.setMobile("18501251337");
		loginByThirdPartyReq.setTrueName("步惊云");
		loginByThirdPartyReq.setPatientRelation(1);
		loginByThirdPartyReq.setThirdPartyType(2);
		//loginByThirdPartyReq.setDoctorUserId(15L);
		MockHttpServletRequestBuilder post = post("/bind").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(loginByThirdPartyReq));
	    try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
    }
    
	@Test
	public void registerUserTest() {
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
		
		//注册参数
		userRegisterReq.setUserName("18501251337");
		//userRegisterReq.setAuthcode("246754");
		userRegisterReq.setCryptPasswd(Codec.MD5Code("123456"));
		userRegisterReq.setLoginType(2);
		userRegisterReq.setDeviceInfo(deviceInfo);
		userRegisterReq.setRole(1);
		
		MockHttpServletRequestBuilder post = post("/register").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userRegisterReq));
	    try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void modifyUserProfileTest() {
		UserProfileModifyReq userProfileModifyReq = new UserProfileModifyReq();
		UserProfile userProfile = new UserProfile();
		DoctorProfile doctorProfile = new DoctorProfile();
		PatientProfile patientProfile = new PatientProfile();
		SourceDiagnosisInfo sourceDiagnosisInfo = new SourceDiagnosisInfo();
		List<SourceDiagnosisInfo> sourceDiagnosisInfoes = new ArrayList<SourceDiagnosisInfo>(3);
		
		userProfile.setUserId(142L);
		userProfile.setRole(1);
		/*
		userProfile.setCity("");
		userProfile.setCityCode("");
		userProfile.setUserName("18501251337");
		userProfile.setTrueName("18501251337");
		userProfile.setSex(1);
		userProfile.setUserPictureUrl("");
		*/
		
		doctorProfile.setWorkCredencePicUrl("http://20image.esuizhen.com/resource/icon/14531048208356_ico.jpg");
		/*
		doctorProfile.setProfessionCredence("");
		doctorProfile.setSkills("");
		doctorProfile.setWorkCredencePicUrl("");
		doctorProfile.setDept("肿瘤科");
		doctorProfile.setDeptId(100L);
		doctorProfile.setRegisterCredencePicUrl("");
		doctorProfile.setProfessionalRankId(8);
		*/
		
		patientProfile.setPatientRelation(0);
		
		sourceDiagnosisInfo.setConfirmedDate(new Date());
		sourceDiagnosisInfo.setSourceDiagnosis("肝肿瘤");
		sourceDiagnosisInfo.setSourceDiseaseTypeId(1);
		sourceDiagnosisInfo.setSourceDiseaseCode("C33.365");
		
		sourceDiagnosisInfoes.add(sourceDiagnosisInfo);
		//patientProfile.setSourceDiagnosisList(sourceDiagnosisInfoes);

		//userProfileModifyReq.setDoctorProfile(doctorProfile);
		userProfileModifyReq.setUserProfile(userProfile);
		//userProfileModifyReq.setPatientProfile(patientProfile);
		
		MockHttpServletRequestBuilder post = post("/profile/modify").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(userProfileModifyReq));
		System.out.println("请求：\n" + JsonUtil.beautiful(JsonUtil.toJson(userProfileModifyReq)));
	    try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}

	@Test
	public void queryUserInfoByTicketTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/query/byticket?ticket=abc");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Autowired
	private UserService userService;
	@Test
	public void test(){
		
	}
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${operating.strategy.user.create}")
	private String createUserToStrategy;
}

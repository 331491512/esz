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
public class PatientControllerTest {
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
			"opFlag":0,  //0:新增； 1：修改
			"uuid":"350000es34n6i3n790djjde33s", 
			"trueName":"患者老王",
			"sex":1, 
			"birthDate":"2015-09-08 09:06:06"，
			"country":"中国",
			"mobile":"13566666666"，
			"city":"北京"，
			"nativePlace":"北京海淀区",
			"nation":"汉"，
			"idType":1,
			"identification":"42584521578755"，
			"profession":"程序猿"，
			"marriageStatus":1，
			"liveStatus":1，
			"deathDate":"2015-09-08 09:06:06"，
			"causeOfDeath":"在院肿瘤死亡"，
			"latestClinicDate":"2015-09-08 09:06:06"，
			"latestOutHospitalDate":"2015-09-08 09:06:06"，
			"latestFollowupTime":"2015-09-08 09:06:06"，
			"attendingDoctorUuid":"aasdfasdfasdfsafssdfgsaew"，
			" hospitalUuid ":"asdfa15415asdfew5415 ",
			" hospitalId ":15,
			" patientContactList":[{
			      "patientRelation ":0,
			      "familyName ":"张三",
			      "familyPhone":"12345678910",
			      "address ":"北京海淀"
			       },{
			      "patientRelation ":1,
			      "familyName ":"李四",
			      "familyPhone":"12345678010",
			      " address ":"北京海淀"
			}]
		}
	 */
	@Test
	public void syncDoctorTest() {
		TPatientSyncProfile patientSyncProfile = new TPatientSyncProfile();
		patientSyncProfile.setOpFlag(1);
		patientSyncProfile.setUuid("patient185012513370002");
		patientSyncProfile.setMobile("18501251338");
		patientSyncProfile.setTrueName("葫芦娃");
		patientSyncProfile.setSex(1);
		/*
		patientSyncProfile.setCountry("中国");
		patientSyncProfile.setCity("北京");
		patientSyncProfile.setNativePlace("");
		patientSyncProfile.setNation("");
		patientSyncProfile.setIdType(1);
		patientSyncProfile.setIdentification("");
		patientSyncProfile.setProfession("");
		patientSyncProfile.setMarriageStatus(1);
		patientSyncProfile.setDeathDate(new Date());
		patientSyncProfile.setLatestClinicDate(new Date());
		patientSyncProfile.setLatestFollowupTime(new Date());
		patientSyncProfile.setAttendingDoctorUuid("");
		 */
		patientSyncProfile.setLiveStatus(1);
		patientSyncProfile.setHospitalUuid("eb1805d0c8ad11e5b79a00163e006090");
		patientSyncProfile.setHospitalId(100);
		patientSyncProfile.setPatientNo("AB-1254");
		
		String[] parsePatterns = new String[]{"YYYY-MM-dd"};
		try {
			patientSyncProfile.setBirthDate(org.apache.commons.lang.time.DateUtils.parseDate("1978-07-08", parsePatterns));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		TPatientContactInfo patientContactInfo1 = new TPatientContactInfo();
		patientContactInfo1.setPatientRelation(1);
		patientContactInfo1.setFamilyName("大师兄");
		patientContactInfo1.setFamilyPhone("18501251339");
		patientContactInfo1.setAddress("北京海淀");
		
		TPatientContactInfo patientContactInfo2 = new TPatientContactInfo();
		patientContactInfo2.setPatientRelation(1);
		patientContactInfo2.setFamilyName("");
		patientContactInfo2.setFamilyPhone("");
		patientContactInfo2.setAddress("");
		
		TPatientContactInfo patientContactInfo3 = new TPatientContactInfo();
		patientContactInfo3.setPatientRelation(1);
		patientContactInfo3.setFamilyName("");
		patientContactInfo3.setFamilyPhone("");
		patientContactInfo3.setAddress("");
		
		List<TPatientContactInfo> patientContactInfos = new ArrayList<TPatientContactInfo>();
		patientContactInfos.add(patientContactInfo1);
		//patientContactInfos.add(patientContactInfo2);
		//patientContactInfos.add(patientContactInfo3);
		patientSyncProfile.setPatientContactList(patientContactInfos);
		
		MockHttpServletRequestBuilder post = post("/tocloud/user/patient").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(patientSyncProfile));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(patientSyncProfile)));
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
	public void transferDataToCloud_test(){
		MockHttpServletRequestBuilder get = get("/transfer/patient/data/tocloud");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void syncPatientWeixinFromCloud_test(){
		MockHttpServletRequestBuilder get = get("/fromcloud/user/patient/weixin").
				param("hospitalId", "19193");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private PatientService patientService;
	@Test
	public void test(){
		User user = new User();
		//user.setUserId(2036388L);
		//user.setUserId(2036386L);
		user.setUserId(2036468L);
		user.setUuid("asdfasdf_sfsdf_215151fasdf");
		user.setRole(1);
		user.setSex(1);
		user.setBirthDate(new Date());
		user.setMobile("15963521465");
		String name = "赵龙伟";
		String diseaseTypeName = "梅病";
		//this.patientService.sendNotifyToPatientForMatchMobilePatient(user, name, diseaseTypeName);
	}
	
	@Test
	public void getWxUser(){
		MockHttpServletRequestBuilder get = get("/wx/user/get").param("uuid", "2ef80cc6085a11e692bb001f29e2f5b8");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

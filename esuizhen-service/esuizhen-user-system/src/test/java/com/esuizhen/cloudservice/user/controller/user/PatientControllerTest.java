/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller.user<br/>  
 * <b>文件名：</b>PatientControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月14日-上午10:33:27<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.HashMap;
import java.util.Map;

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

import com.esuizhen.cloudservice.user.bean.PatientCreateByMobileReq;
import com.esuizhen.cloudservice.user.bean.PatientKeywordSearchReq;
import com.esuizhen.cloudservice.user.dao.PatientDao;
import com.esuizhen.cloudservice.user.service.PatientService;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.util.JsonUtil;

/** 
* @ClassName: PatientControllerTest 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月14日 上午10:33:27  
*/
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
	
	@Test
	public void getPatientsOfDoctorList() throws Exception {
		MockHttpServletRequestBuilder get = get("/patient/ofdoctor/list?doctorId=21004&patientName=v&reqFlag=0&page=0&num=20");
		MvcResult result = mockMvc.perform(get).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void createPatientByMobile()throws Exception
	{
		PatientCreateByMobileReq patientCreateByMobileReq = new PatientCreateByMobileReq();
		patientCreateByMobileReq.setMobile("13253212357");
		patientCreateByMobileReq.setDoctorId(1l);
		patientCreateByMobileReq.setSourceDiseaseCode("12321321");
		patientCreateByMobileReq.setSourceDiagnosis("感冒");
		patientCreateByMobileReq.setTrueName("大妈1");
		System.out.println(JsonUtil.toJson(patientCreateByMobileReq));
		MockHttpServletRequestBuilder post = post("/user/patient/create/bymobile").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(patientCreateByMobileReq));
		MvcResult result;
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
	public void searchPatientBykeywordTest()throws Exception
	{
		PatientKeywordSearchReq patientKeywordSearchReq = new PatientKeywordSearchReq();
		patientKeywordSearchReq.setDoctorId(13L);
		//patientKeywordSearchReq.setKeyword("感");
		//patientKeywordSearchReq.setReqFlag(0);
		System.out.println(JsonUtil.toJson(patientKeywordSearchReq));
		MockHttpServletRequestBuilder post = post("/patient/ofdoctor/search/bykeyword").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(patientKeywordSearchReq));
		MvcResult result;
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(patientKeywordSearchReq)) + "\n***********************************************************\n");
		try {
			result = mockMvc.perform(post).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	@Test
	public void getPatientGroupListTest(){
		MockHttpServletRequestBuilder get = get("/patient/group/list?doctorId=51&groupWay=1");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listPatientGroupMembersTest(){
		MockHttpServletRequestBuilder get = get("/patient/group/members/list?doctorId=51&groupId=23&groupWay=0&page=0&num=20");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
    public void getDetailPatientProfile(){
		MockHttpServletRequestBuilder get = get("/patient/profile/detail?patientId=1954365&doctorId=13");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info(jsonStr);
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Test
	public void listPatientsOfDoctorTest() {
		MockHttpServletRequestBuilder get = get("/patient/ofdoctor/list?doctorId=51&reqFlag=0&page=0&num=100");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getCause() + e.getMessage());
		}
	}
	
	@Test
    public void createPatientOfDoctorRelationTest(){
		MockHttpServletRequestBuilder get = get("/relation/patient/ofdoctor/create?doctorId=5&patientId=9&sourceFlag=3");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info(jsonStr);
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
    public void releasePatientOfDoctorTest(){
		MockHttpServletRequestBuilder get = get("/relation/patient/ofdocotor/release?patientId=68&doctorId=5&source=2");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info(jsonStr);
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
    public void getPatientSimpleInfoTest(){
		MockHttpServletRequestBuilder get = get("/patient/simple/info?id=66&tag=user&doctorId=32");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info(jsonStr);
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
	public void delHasVisibleMedicalRecordTest(){
		MockHttpServletRequestBuilder get = get("/del/medicalRecord?doctorId=67&source=2&patientId=152");
		MvcResult result;
		try {
			result = mockMvc.perform((get)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info(jsonStr);
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void certificatePatient_test(){
		PatientSimpleInfo patientSimpleInfo = new PatientSimpleInfo();
		patientSimpleInfo.setPatientId(1954904L);
		patientSimpleInfo.setCertificateResult(0);
		patientSimpleInfo.setAuditRemark("证件号合格");
		
		MockHttpServletRequestBuilder post = post("/patient/certificate").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(patientSimpleInfo));
	    try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private PatientService patientService;
	@Test
	public void test(){
		Map<String, Number> params = new HashMap<String, Number>();
		params.put("cloudPatientId", -36);
		params.put("tobPatientId", -39);
		//params.put("mergeState", null);
		this.patientDao.mergeTobPatientInfoToFormalPatientInfo(params);
		System.out.println(params.get("mergeState"));
	}
}

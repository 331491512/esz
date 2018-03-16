package com.esuizhen.cloudservice.research.controller.result;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;
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

import com.esuizhen.cloudservice.research.bean.PatientsInProjectSearchReq;
import com.esuizhen.cloudservice.research.bean.UnselectedPatientsSearchReq;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class PatientManageControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void test_searchInProjectPatients() throws Exception {
		PatientsInProjectSearchReq unselectedPatientsSearchReq = new PatientsInProjectSearchReq();
		unselectedPatientsSearchReq.setProjectId("PROJ20160527153157699431");
		unselectedPatientsSearchReq.setDoctorId(21004L);
		logger.info("Send=\n" + JsonUtil.toJson(unselectedPatientsSearchReq));
		MockHttpServletRequestBuilder post = post("/patients/in/project/search")
				.content(JsonUtil.toJson(unselectedPatientsSearchReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void test_searchUnselectedPatients() throws Exception {
		UnselectedPatientsSearchReq unselectedPatientsSearchReq = new UnselectedPatientsSearchReq();
		unselectedPatientsSearchReq.setProjectId("PROJ20160527153157699431");
		unselectedPatientsSearchReq.setDoctorId(21004L);
		unselectedPatientsSearchReq.setInhospitalIdentity(2);
		unselectedPatientsSearchReq.setOutHospitalIdentity(2);
		logger.info("Send=\n" + JsonUtil.toJson(unselectedPatientsSearchReq));
		MockHttpServletRequestBuilder post = post("/patients/unselected/search")
				.content(JsonUtil.toJson(unselectedPatientsSearchReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void test_addPendingPatientsToProject() throws Exception {
		TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo = new TCrfResultMainInfo<List<PatientSimpleInfo>>();
		List<PatientSimpleInfo> patientSimpleInfos = new ArrayList<PatientSimpleInfo>();
		PatientSimpleInfo patientSimpleInfo1 = new PatientSimpleInfo();
		//PatientSimpleInfo patientSimpleInfo2 = new PatientSimpleInfo();
		patientSimpleInfo1.setPatientId(1954988L);
		
		patientSimpleInfos.add(patientSimpleInfo1);
		crfResultMainInfo.setProjectId("PROJ20161019111442297083");
		crfResultMainInfo.setDoctorId(21004L);
		crfResultMainInfo.setCrfResult(patientSimpleInfos);
		crfResultMainInfo.setCommon("患者{患者姓名}您好，您的主治医生{医生姓名}已通过“易随诊医生”服务平台邀请您进入“{专题名称}”临床专"
				+ "题观察，后续您将持续收到医生为您定制的随访内容及复查提醒。请您及时关注“易随诊医生”微信服务号，或联系您的主治医生扫码获取关注。");
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/patients/pending/into/project/add")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void test_joinPatientsToProject() throws Exception {
		TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo = new TCrfResultMainInfo<List<PatientSimpleInfo>>();
		List<PatientSimpleInfo> patientSimpleInfos = new ArrayList<PatientSimpleInfo>();
		PatientSimpleInfo patientSimpleInfo1 = new PatientSimpleInfo();
		PatientSimpleInfo patientSimpleInfo2 = new PatientSimpleInfo();
		patientSimpleInfo1.setPatientId(1954819L);
		
		patientSimpleInfos.add(patientSimpleInfo1);
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setDoctorId(21004L);
		crfResultMainInfo.setCrfResult(patientSimpleInfos);
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/patients/into/project/join")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void test_deletePendingPatients() throws Exception {
		TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo = new TCrfResultMainInfo<List<PatientSimpleInfo>>();
		List<PatientSimpleInfo> patientSimpleInfos = new ArrayList<PatientSimpleInfo>();
		PatientSimpleInfo patientSimpleInfo1 = new PatientSimpleInfo();
		PatientSimpleInfo patientSimpleInfo2 = new PatientSimpleInfo();
		patientSimpleInfo1.setPatientId(1954628L);
		patientSimpleInfo2.setPatientId(1954649L);
		
		patientSimpleInfos.add(patientSimpleInfo1);
		patientSimpleInfos.add(patientSimpleInfo2);
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setDoctorId(21004L);
		crfResultMainInfo.setCrfResult(patientSimpleInfos);
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/crf/pending/patients/delete")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_patientFollowupRecordList() {
		MockHttpServletRequestBuilder get = get("/crf/patient/followup/record/list/search?patientId=1954819");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

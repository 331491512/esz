package com.esuizhen.cloudservice.research.controller.result;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
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

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicAllergies;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicDemography;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicPastmedicalHistory;
import com.esuizhen.cloudservice.research.model.result.TCrfResultDiagnosisInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class EssentialControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void test_queryCrfResultDemography() {
		MockHttpServletRequestBuilder get = get("/crf/result/demography/query?crfObserveId=OBSE24552946679178960&patientId=1954819");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_saveCrfResultDemography() throws Exception {
		TCrfResultMainInfo<TCrfResultBasicDemography> crfResultMainInfo = new TCrfResultMainInfo<TCrfResultBasicDemography>();
		TCrfResultBasicDemography crfResultBasicDemography = new TCrfResultBasicDemography();
		crfResultBasicDemography.setPatientId(1954819L);
		crfResultBasicDemography.setMobile("18501251337");
		crfResultBasicDemography.setTrueName("邢正");
		crfResultBasicDemography.setSex(2);
		crfResultBasicDemography.setBirthPlace("北京朝阳");
		crfResultBasicDemography.setCountry("中国");
		crfResultBasicDemography.setNation("汉");
		crfResultBasicDemography.setProfession("工人");
		crfResultBasicDemography.setBloodType("O");
		crfResultBasicDemography.setIdType(1);
		crfResultBasicDemography.setIdentification("6625354125698521458");
		crfResultBasicDemography.setMarriageStatus(2);
		crfResultBasicDemography.setResidenceType(1);
		crfResultBasicDemography.setAddress("牛村");
		
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178960");
		crfResultMainInfo.setSubjectElementId("T11");
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setPatientId(1954819L);
		crfResultMainInfo.setCreatorId(21004L);
		crfResultMainInfo.setCrfResult(crfResultBasicDemography);
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/crf/result/demography/save")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryCrfResultAllergy() {
		MockHttpServletRequestBuilder get = get("/crf/result/allergy/query?crfObserveId=OBSE24552946679178961&patientId=1954819");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_saveCrfResultAllergy() throws Exception {
		TCrfResultMainInfo<List<TCrfResultBasicAllergies>> crfResultMainInfo = new TCrfResultMainInfo<List<TCrfResultBasicAllergies>>();
		List<TCrfResultBasicAllergies> list = new ArrayList<TCrfResultBasicAllergies>();
		TCrfResultBasicAllergies crfResultBasicAllergies = new TCrfResultBasicAllergies();
		crfResultBasicAllergies.setCrfResultId("CRRI2016053011370366384120160530113703106813");
		crfResultBasicAllergies.setAllergyName("过敏史");
		crfResultBasicAllergies.setAllergySource("皮肤");
		crfResultBasicAllergies.setAllergySymptom("红肿");
		crfResultBasicAllergies.setAllergyMedicinesName("红酒");
		crfResultBasicAllergies.setAllergyLevel(2);
		
		list.add(crfResultBasicAllergies);
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178961");
		crfResultMainInfo.setSubjectElementId("T12");
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setPatientId(1954819L);
		crfResultMainInfo.setCreatorId(21004L);
		crfResultMainInfo.setCrfResult(list);
		
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/crf/result/allergy/save")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryCrfResultPastmedicalHistory() {
		MockHttpServletRequestBuilder get = get("/crf/result/pastmedical/history/query?crfObserveId=OBSE24552946679178962&patientId=1954819");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <p>Title:test_saveCrfResultPastmedicalHistory</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午5:09:19
	 * @throws Exception
	 */
	@Test
	public void test_saveCrfResultPastmedicalHistory() throws Exception {
		TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> crfResultMainInfo = new TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>>();
		List<TCrfResultBasicPastmedicalHistory> list = new ArrayList<TCrfResultBasicPastmedicalHistory>();
		TCrfResultBasicPastmedicalHistory crfResultBasicPastmedicalHistory = new TCrfResultBasicPastmedicalHistory();
		crfResultBasicPastmedicalHistory.setCrfResultId("CRRI2016053017051291840120160530170512503525");
		crfResultBasicPastmedicalHistory.setPastmedicalName("aedf");
		crfResultBasicPastmedicalHistory.setConfirmedDate(new Date());
		crfResultBasicPastmedicalHistory.setConfirmedHospital("上的复合体如何如何");
		crfResultBasicPastmedicalHistory.setTreatment("k就哦了警告");
		crfResultBasicPastmedicalHistory.setCurrentState("稳定");
		
		list.add(crfResultBasicPastmedicalHistory);
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178962");
		crfResultMainInfo.setSubjectElementId("T13");
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setPatientId(1954819L);
		crfResultMainInfo.setCreatorId(21004L);
		crfResultMainInfo.setCrfResult(list);
		
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/crf/result/pastmedical/history/save")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryCrfResultDiagnosis() {
		MockHttpServletRequestBuilder get = get("/crf/result/diagnosis/query?crfObserveId=OBSE24552946679178951&patientId=1954819");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test_saveCrfResultDiagnosis() throws Exception {
		TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> crfResultMainInfo = new TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>>();
		List<TCrfResultDiagnosisInfo> list = new ArrayList<TCrfResultDiagnosisInfo>();
		TCrfResultDiagnosisInfo crfResultDiagnosisInfo = new TCrfResultDiagnosisInfo();
		crfResultDiagnosisInfo.setCrfResultId("CRRI2016053014512399386220160530145123631882");
		crfResultDiagnosisInfo.setDiagnosisType("坐诊");
		crfResultDiagnosisInfo.setDiagnosisCategory("主要诊断");
		crfResultDiagnosisInfo.setDiagnosisName("非小泡肿瘤");
		crfResultDiagnosisInfo.setDiagnosisStages("2");
		crfResultDiagnosisInfo.setDiagnosisBodyPart(3);
		crfResultDiagnosisInfo.setDiagnosisHospital("重庆肿瘤医院");
		crfResultDiagnosisInfo.setDiagnosisDate(new Date());
		crfResultDiagnosisInfo.setDiagnosisCode("CD1.102");
		crfResultDiagnosisInfo.setDiagnosisBasic("肿瘤块");
		crfResultDiagnosisInfo.setDiagnosisConcurrentDisease("不知道");
		crfResultDiagnosisInfo.setDiagnosisHofaDisease("同上");
		crfResultDiagnosisInfo.setDiagnosisWithDisease("还有吗");
		crfResultDiagnosisInfo.setChineseMedicineDisease("脉搏紊乱，体热。");
		
		list.add(crfResultDiagnosisInfo);
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178951");
		crfResultMainInfo.setSubjectElementId("S2");
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setPatientId(1954819L);
		crfResultMainInfo.setCreatorId(21004L);
		crfResultMainInfo.setCrfResult(list);
		
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/crf/result/diagnosis/save")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

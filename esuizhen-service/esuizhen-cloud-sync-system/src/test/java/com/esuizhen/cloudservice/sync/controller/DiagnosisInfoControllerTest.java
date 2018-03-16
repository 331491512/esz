package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.sync.bean.TDetectionReportSync;
import com.esuizhen.cloudservice.sync.bean.TExamReportSync;
import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class DiagnosisInfoControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void syncDoctorTest() {
		TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo = new TPatientDiagnosisNoteDetailInfo();
		diagnosisNoteDetailInfo.setEmrNo("0131101000987698");
		diagnosisNoteDetailInfo.setPatientUuid("patient185012513370002");
		diagnosisNoteDetailInfo.setPatientNo("NO.123456");
		diagnosisNoteDetailInfo.setDiseaseTypeId(1);
		diagnosisNoteDetailInfo.setDiagnosis("外唇恶性肿瘤");
		diagnosisNoteDetailInfo.setDiseaseCode("C00.251");
		diagnosisNoteDetailInfo.setPathologyDiagnosis("外唇恶性肿瘤");
		diagnosisNoteDetailInfo.setPathologyDiagnosisCode("C00.251");
		diagnosisNoteDetailInfo.setIsSourceDiagnosis(1);
		diagnosisNoteDetailInfo.setDiagnosisTypeId(3);
		diagnosisNoteDetailInfo.setConfirmedDate(new Date());
		diagnosisNoteDetailInfo.setHospitalId(100);
		
		MockHttpServletRequestBuilder post = post("/tocloud/emr/diagnosisnote").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(diagnosisNoteDetailInfo));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(diagnosisNoteDetailInfo)));
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
	public void examReportCoudSync_test() {
		TExamReportSync examReportSync1 = new TExamReportSync();
		TExamReportSync examReportSync2 = new TExamReportSync();
		examReportSync1.setEmrId("5555");
		examReportSync1.setExamReportId("asdfasdfasdfasdf");
		examReportSync2.setExamReportId("22222");
		examReportSync2.setEmrId("66666");	
		List<TExamReportSync> examReportList = new ArrayList<TExamReportSync>();
		examReportList.add(examReportSync1);
		examReportList.add(examReportSync2);
		MockHttpServletRequestBuilder post = post("/tocloud/exam/report").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(examReportList));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(examReportList)));
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
	public void detectionReportCloudSync_test() {
		TDetectionReportSync detectionReportSync1 = new TDetectionReportSync();
		TDetectionReportSync detectionReportSync2 = new TDetectionReportSync();
		
		detectionReportSync1.setDetectionReportId("safsdfasgsdgftsadf");
		detectionReportSync2.setDetectionReportId("22222");
		
		List<TDetectionReportSync> detectionReportSyncList = new ArrayList<TDetectionReportSync>();
		detectionReportSyncList.add(detectionReportSync1);
		detectionReportSyncList.add(detectionReportSync2);
		MockHttpServletRequestBuilder post = post("/tocloud/detection/report").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(detectionReportSyncList));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(detectionReportSyncList)));
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

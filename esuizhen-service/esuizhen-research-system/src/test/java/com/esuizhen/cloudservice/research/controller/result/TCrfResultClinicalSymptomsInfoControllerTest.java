package com.esuizhen.cloudservice.research.controller.result;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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

import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTcmSymptomsDetail;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfResultClinicalSymptomsInfoControllerTest{

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
	public void queryResultClinicalSymptoms() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/result/clinical/symptoms/query?crfObserveId=OBSE24552946679178951&patientId=0");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void saveCrfResultClinicalSymptoms() throws Exception
	{
		TCrfResultClinicalSymptomsInfo crfResultClinicalSymptomsDetail = new TCrfResultClinicalSymptomsInfo();
		List<TCrfResultClinicalSymptomsDetailInfo> clinicalSymptomsDetailInfos = new ArrayList<TCrfResultClinicalSymptomsDetailInfo>();
		TCrfResultClinicalSymptomsDetailInfo clinicalSymptomsDetailInfo = new TCrfResultClinicalSymptomsDetailInfo();
		clinicalSymptomsDetailInfo.setSymptomId(2);
		clinicalSymptomsDetailInfo.setSymptomName("困");
		
		clinicalSymptomsDetailInfos.add(clinicalSymptomsDetailInfo);
		
		crfResultClinicalSymptomsDetail.setCrfResultClinicalSymptomsDetailList(clinicalSymptomsDetailInfos);
		
		TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo> crfResultMainInfo = new TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo>();
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178951");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setCreatorId(9L);
		crfResultMainInfo.setPatientId(0L);
		crfResultMainInfo.setProjectId("000");
		crfResultMainInfo.setSubjectElementId("S1");
		crfResultMainInfo.setCrfResult(crfResultClinicalSymptomsDetail);
		
		MockHttpServletRequestBuilder post = post("/crf/result/clinical/symptoms/save").content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryCrfResultClinicalSymptomsRecord() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/result/clinical/symptoms/record/query?projectId=000&patientId=0");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryCrfResultTcmSymptoms() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/result/tcm/symptoms/query?crfObserveId=OBSE24552946679178951&patientId=0");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void saveCrfResultTcmSymptoms() throws Exception
	{
		TCrfResultTcmSymptomsDetail crfResultTcmSymptomsDetail = new TCrfResultTcmSymptomsDetail();
		crfResultTcmSymptomsDetail.setTcmSymptomId(1);
		crfResultTcmSymptomsDetail.setTcmSymptomName("困");
		List<TCrfResultTcmSymptomsDetail> crfResultTcmSymptomsDetailList = new ArrayList<TCrfResultTcmSymptomsDetail>();
		crfResultTcmSymptomsDetailList.add(crfResultTcmSymptomsDetail);
		
		TCrfResultClinicalSymptomsInfo crfResultClinicalSymptomsInfo = new TCrfResultClinicalSymptomsInfo();
		crfResultClinicalSymptomsInfo.setCrfResultTcmSymptomsDetailList(crfResultTcmSymptomsDetailList);
		
		List<TCrfResultClinicalSymptomsInfo> crfList = new ArrayList<TCrfResultClinicalSymptomsInfo>();
		crfList.add(crfResultClinicalSymptomsInfo);
		
		
		TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> crfResultMainInfo = new TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>>();
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178951");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setCreatorId(9L);
		crfResultMainInfo.setPatientId(0L);
		crfResultMainInfo.setProjectId("000");
		crfResultMainInfo.setSubjectElementId("S1");
		crfResultMainInfo.setCrfResult(crfList);
		
		MockHttpServletRequestBuilder post = post("/crf/result/tcm/symptoms/save").content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


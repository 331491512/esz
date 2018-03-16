package com.esuizhen.cloudservice.ehr.controller.patient;

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

import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentReq;
import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class PatientSymptomControllerTest{

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
	public void patientSymptomList() throws Exception
	{
		MockHttpServletRequestBuilder get = get("/patient/symptom/list?patientId=9793");//&symptomName=11
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Test
	@Ignore
	public void savePatientSymptom() throws Exception
	{
		List<PatientSymptomInfo> patientSymptomList = new ArrayList<PatientSymptomInfo>();
		PatientSymptomInfo patientSymptom = new PatientSymptomInfo();
		patientSymptom.setSymptomId("SYMP20160922173612910820");
		patientSymptom.setPatientId(9793l);
		patientSymptom.setInhospitalId("10568");
		patientSymptom.setPatientNo("185167");
		patientSymptom.setVisitTime(new Date());
		patientSymptom.setSymptomTypeId(1);
		patientSymptom.setSymptomName("疲乏11");
		patientSymptom.setFamilyHistoryDiseaseTypeId(1);
		patientSymptom.setFamilyHistoryDiseaseTypeName("无");
		patientSymptom.setRelationId(1);
		patientSymptom.setRelationName("本人");
		patientSymptom.setRiskFactors("粉尘作业");
		patientSymptomList.add(patientSymptom);
		MockHttpServletRequestBuilder post = post("/patient/symptom/save").content(JsonUtil.toJson(patientSymptomList)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	@Ignore
	public void getPatienInhospitalList() throws Exception
	{
		MockHttpServletRequestBuilder get = get("/patient/diagnosis/list?page=0&num=10&patientId=9793&diagnosisTypeId=1&diagnosis=1");//&symptomName=11
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
//	@Ignore
	public void getPatientPastTreatmentList() throws Exception
	{
		MockHttpServletRequestBuilder get = get("/patient/past/treatment/list?page=0&num=10&patientId=34331&medicine=感冒药&pageFlag=2");//&symptomName=11
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void addPatientPastTreatment() throws Exception
	{
		List<PatientPastTreatmentReq> req = new ArrayList<PatientPastTreatmentReq>();
		PatientPastTreatmentReq treatment = new PatientPastTreatmentReq();
		treatment.setCreatorId(null);
		treatment.setCreatorName("11");
		treatment.setSourceFlag(1);
		treatment.setDosageUnit("sss");
		treatment.setMedicine("ss");
		treatment.setPatientId(1L);
		treatment.setTreatmentBeginTime(new Date());
		treatment.setTreatmentDosage(52.2F);
		treatment.setTreatmentEndTime(new Date());
		treatment.setTreatmentName("deeee");
		treatment.setTreatmentProcessFlag(1);
		treatment.setTreatmentTypeId(1);
		req.add(treatment);
		MockHttpServletRequestBuilder post = post("/patient/past/treatment/add").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
}


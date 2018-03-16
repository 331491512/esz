package com.esuizhen.cloudservice.ehr.controller.diagnose;

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

import com.esuizhen.cloudservice.ehr.model.diagnose.PatientDiagnosisInfoReq;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TDiagnosisInfoControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void queryDiagnosis() throws Exception 
	{
		PatientDiagnosisInfoReq req = new PatientDiagnosisInfoReq();
		req.setPatientId(2L);
		MockHttpServletRequestBuilder post = post("/diagnosis/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void saveDiagnosis() throws Exception
	{
		List<TDiagnosisInfo> diagnosises = new ArrayList<TDiagnosisInfo>();
		TDiagnosisInfo diagnosisInfo = new TDiagnosisInfo();
		diagnosisInfo.setEmrId("EMRI201602011304033fc734fac8a111e5b79a00163e006090");
		diagnosisInfo.setPatientId(590729L);
		diagnosisInfo.setPatientNo("65865");
		diagnosisInfo.setDiagnosis("骨巨细胞瘤 (M92500/1)");
		diagnosisInfo.setDiagnosisCode("D48.052");
		diagnosisInfo.setDiagnosisExplain(2);
		diagnosisInfo.setDisagnosisPeriodizationId(4);
		diagnosisInfo.setDiagnosisTypeId(1);
		diagnosisInfo.setDiagnosisBasisId(1);
		diagnosisInfo.setInHospitalCondition(2);
		diagnosisInfo.setIsFollowup(1);
		diagnosisInfo.setIsSourceDiagnosis(1);
		diagnosisInfo.setOperatorId(1l);
		diagnosisInfo.setOrganCode("c001");
		diagnosisInfo.setOrganName("test");
		diagnosisInfo.setPathologyDiagnosis("恶性瘤，小细胞型");
		diagnosisInfo.setPathologyDiagnosisCode("8002/3");
		diagnosisInfo.setRemark("测试");
		diagnosisInfo.setSourceCancerCount(1);
		diagnosisInfo.setTreatmentHistory(1);
		diagnosisInfo.setIsSourceDiagnosis(1);
		diagnosisInfo.setSuspectedDiagnosisFlag(1);
		diagnosisInfo.setSurgeryFlag(1);
		diagnosisInfo.setFirstdiagnosisHospitalId(1);
		diagnosisInfo.setFirstdiagnosisHospitalName("华西医院");
		diagnosisInfo.setFirstdiagnosisTime(new Date());
		diagnosisInfo.setSpecialDiseaseDiagnosisId(1);
		diagnosisInfo.setDiagnosisDoctorName("李春英");
		diagnosisInfo.setDiagnosisDoctorId(1);
//		diagnosisInfo.setOperateAction("D");
		diagnosises.add(diagnosisInfo);
		MockHttpServletRequestBuilder post = post("/diagnosis/save").content(JsonUtil.toJson(diagnosises)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	
}


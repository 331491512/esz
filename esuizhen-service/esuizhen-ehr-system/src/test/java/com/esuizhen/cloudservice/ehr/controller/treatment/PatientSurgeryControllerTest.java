package com.esuizhen.cloudservice.ehr.controller.treatment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class PatientSurgeryControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void queryPatientSurgery() throws Exception 
	{
		CommonReq req = new CommonReq();
		req.setInhospitalId("EINH201602271515430038d7ccdd2211e581d374d435ac1e2f");
		String json=JsonUtil.toJson(req);
		MockHttpServletRequestBuilder post = post("/patient/surgery/query").content(json).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void savePatientSurgery() throws Exception
	{
		TPatientSurgeryInfo patientSurgeryInfo = new TPatientSurgeryInfo();
		patientSurgeryInfo.setAnesthesiaDoctor(555);
		patientSurgeryInfo.setAnesthesiaWay("aaaCode");
		patientSurgeryInfo.setInhospitalId("SUR20160707141342363060");
		patientSurgeryInfo.setOpCode("00.2202");
		patientSurgeryInfo.setOpLevel(2);
		patientSurgeryInfo.setTreatmentSchemeId(1);
		patientSurgeryInfo.setTreatmentSchemeName("IFO+EPI+DDP");
		patientSurgeryInfo.setSurgeryAssistant1(444);
		patientSurgeryInfo.setSurgeryAssistant2(555);
		patientSurgeryInfo.setSurgeryDate(new Date());
		patientSurgeryInfo.setSurgeryDoctor(333);
		patientSurgeryInfo.setSurgeryName("胸内血管血管内超声[IVUS]");
		patientSurgeryInfo.setPatientId(100L);
		patientSurgeryInfo.setPatientNo("patientNo");
		patientSurgeryInfo.setHospitalId(10);
		patientSurgeryInfo.setIncisionHealingLevel("甲");
		patientSurgeryInfo.setOperatorName("张三");
		patientSurgeryInfo.setIncisionHealingId(1);
		
		
		List<TPatientSurgeryInfo> list=new ArrayList<TPatientSurgeryInfo>();
		list.add(patientSurgeryInfo);
		TInhospitallSurgeryMsg<TPatientSurgeryInfo> inhospitallSurgeryMsg=new TInhospitallSurgeryMsg<TPatientSurgeryInfo>();
		inhospitallSurgeryMsg.setInhospitalId("SUR20160707141342363060");
		inhospitallSurgeryMsg.setPatientId(100L);
		inhospitallSurgeryMsg.setPatientNo("patientNo");
		inhospitallSurgeryMsg.setHospitalId(10);
		
		inhospitallSurgeryMsg.setResultList(list);
		
		String json=JsonUtil.toJson(inhospitallSurgeryMsg);
		
		System.err.println("_____"+json);
		
		MockHttpServletRequestBuilder post = post("/patient/surgery/save").content(json).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	
}


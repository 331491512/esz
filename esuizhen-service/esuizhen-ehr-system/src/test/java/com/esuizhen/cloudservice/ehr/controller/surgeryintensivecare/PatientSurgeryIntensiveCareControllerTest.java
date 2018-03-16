package com.esuizhen.cloudservice.ehr.controller.surgeryintensivecare;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class PatientSurgeryIntensiveCareControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void queryPatientSurgeryIntensiveCare() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/patient/surgery/intensive/care/query?inhospitalId=100");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void savePatientSurgeryIntensiveCare() throws Exception
	{
		TPatientSurgeryIntensiveCareInfo info = new TPatientSurgeryIntensiveCareInfo();
		info.setInhospitalId("EINH201602271515430038d7ccdd2211e581d374d435ac1e2f");
		
		List<TPatientSurgeryIntensiveCareInfo> list=new ArrayList<TPatientSurgeryIntensiveCareInfo>();
		list.add(info);
		
		TInhospitallSurgeryMsg<TPatientSurgeryIntensiveCareInfo> inhospitallSurgeryMsg=new TInhospitallSurgeryMsg<TPatientSurgeryIntensiveCareInfo>();
		inhospitallSurgeryMsg.setInhospitalId("EINH201602271515430038d7ccdd2211e581d374d435ac1e2f");
		inhospitallSurgeryMsg.setResultList(list);
		
		String json=JsonUtil.toJson(inhospitallSurgeryMsg);
		
		System.err.println(json);
		
		MockHttpServletRequestBuilder post = post("/patient/surgery/intensive/care/save").content(json).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	
}


package com.esuizhen.cloudservice.ehr.controller.inhospitalcost;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.math.BigDecimal;

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

import com.esuizhen.cloudservice.ehr.model.inhospitalcost.TInhospitalCostInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TInhospitalCostInfoControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void queryInhospitalCost() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/inhospital/cost/query?inhospitalId=EINH201602271515430038d7ccdd2211e581d374d435ac1e2f");
		MvcResult result = mockMvc.perform((get)).andReturn();
		System.out.println("############");
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void updateTInhospitalCostInfo() throws Exception
	{
		TInhospitalCostInfo inhospitalCostInfo = new TInhospitalCostInfo();
//		inhospitalCostInfo.setCostId(2);
		inhospitalCostInfo.setInhospitalId("EINH201602271515430038d7ccdd2211e581d374d435ac1e2f");
		inhospitalCostInfo.setPatientid(123L);
		inhospitalCostInfo.setTotalCost(new BigDecimal("101.12"));
		inhospitalCostInfo.setSelfCost(new BigDecimal("0.33"));
		
		MockHttpServletRequestBuilder post = post("/inhospital/cost/update").content(JsonUtil.toJson(inhospitalCostInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	
}


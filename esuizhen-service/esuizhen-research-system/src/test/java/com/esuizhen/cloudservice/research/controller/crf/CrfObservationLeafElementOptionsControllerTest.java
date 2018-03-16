package com.esuizhen.cloudservice.research.controller.crf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.research.model.crf.CrfObservationLeafElementOptions;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class CrfObservationLeafElementOptionsControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void create() throws Exception
	{
		CrfObservationLeafElementOptions crfObservationLeafElementOptions = new CrfObservationLeafElementOptions();
		MockHttpServletRequestBuilder post = post("/create").content(JsonUtil.toJson(crfObservationLeafElementOptions)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	public void update() throws Exception
	{
		CrfObservationLeafElementOptions crfObservationLeafElementOptions = new CrfObservationLeafElementOptions();
		MockHttpServletRequestBuilder post = post("/update").content(JsonUtil.toJson(crfObservationLeafElementOptions)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	public void delete() throws Exception 
	{
		String crfObservationLeafElementOptionsId = "123";
		MockHttpServletRequestBuilder get = get("/delete?plancrfObservationLeafElementOptionsId="+crfObservationLeafElementOptionsId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void query() throws Exception 
	{
		String  crfObservationLeafElementOptionsId = "151203055228121023";
		MockHttpServletRequestBuilder get = get("/followup/plan/template/query? crfObservationLeafElementOptionsId="+ crfObservationLeafElementOptionsId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


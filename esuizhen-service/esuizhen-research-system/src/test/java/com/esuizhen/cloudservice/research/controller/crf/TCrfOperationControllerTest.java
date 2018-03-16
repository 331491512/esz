package com.esuizhen.cloudservice.research.controller.crf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
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

import com.esuizhen.cloudservice.research.model.crf.TCrfOperation;
import com.esuizhen.cloudservice.research.model.crf.TCrfOperationInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfOperationControllerTest{

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
	public void create() throws Exception
	{
		TCrfOperationInfo crfOperationInfo1 = new TCrfOperationInfo();
		crfOperationInfo1.setOperationProperty("1");
		crfOperationInfo1.setOperationName("名称");
		crfOperationInfo1.setOperationCode("代码");
		crfOperationInfo1.setSubjectElementId("S1");
		
		TCrfOperationInfo crfOperationInfo2 = new TCrfOperationInfo();
		crfOperationInfo2.setOperationProperty("1");
		crfOperationInfo2.setOperationName("名称");
		crfOperationInfo2.setOperationCode("代码");
		crfOperationInfo2.setSubjectElementId("S2");
		
		List<TCrfOperationInfo> dataList = new ArrayList<TCrfOperationInfo>();
		dataList.add(crfOperationInfo1);
		dataList.add(crfOperationInfo2);
		
		TCrfOperation crfOperation = new TCrfOperation();
		crfOperation.setCrfObserveId("OBSE24502281970009464");
		crfOperation.setDataList(dataList);
		
		MockHttpServletRequestBuilder post = post("/crf/treatment/operation/save").content(JsonUtil.toJson(crfOperation)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void query() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/treatment/operation/query?crfObserveId=OBSE24502281970009464");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


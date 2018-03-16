package com.esuizhen.cloudservice.research.controller.crf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
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

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptom;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomInfo;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.WordTxtUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfSymptomInfoControllerTest{

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
		TCrfSymptom crfSymptom = new TCrfSymptom();
		crfSymptom.setCrfObserveId("20160405205139955516");
		
		TCrfSymptomInfo crfSymptomInfo = new TCrfSymptomInfo();
		crfSymptomInfo.setSubjectElementId("S1");
		crfSymptomInfo.setMediumDescription("描述1");
		crfSymptomInfo.setSevereDescription("描述2");
		crfSymptomInfo.setSlightDescription("描述3");
		crfSymptomInfo.setSubjectElementId("S1");
		crfSymptomInfo.setSymptomId(1);
		
		List<TCrfSymptomInfo> infoList = new ArrayList<TCrfSymptomInfo>();
		infoList.add(crfSymptomInfo);
		
		crfSymptom.setDataList(infoList);
		
		
		MockHttpServletRequestBuilder post = post("/crf/symptoms/save").content(JsonUtil.toJson(crfSymptom)).contentType(MediaType.APPLICATION_JSON);
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
		MockHttpServletRequestBuilder get = get("/crf/symptoms/query?crfObserveId=20160405205139955516");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void convertTxt2Html() throws Exception 
	{
		WordTxtUtil.convertTxt2Html(new File("E:/1.txt"), new File("E:/1.html"));
	}
}


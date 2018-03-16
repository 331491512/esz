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

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcm;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcmInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfSymptomTcmControllerTest{

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
	public void saveCrfSymptomsTcm() throws Exception
	{
		TCrfSymptomTcmInfo crfSymptomTcmInfo = new TCrfSymptomTcmInfo();
		crfSymptomTcmInfo.setSubjectElementId("T51");
		crfSymptomTcmInfo.setTcmSymptomId(1);
		crfSymptomTcmInfo.setTcmSymptomName("名称");
		
		TCrfSymptomTcmInfo crfSymptomTcmInfo2 = new TCrfSymptomTcmInfo();
		crfSymptomTcmInfo2.setSubjectElementId("T52");
		crfSymptomTcmInfo2.setTcmSymptomId(2);
		crfSymptomTcmInfo2.setTcmSymptomName("名称2");
		
		List<TCrfSymptomTcmInfo> dataList = new ArrayList<TCrfSymptomTcmInfo>();
		dataList.add(crfSymptomTcmInfo);
		dataList.add(crfSymptomTcmInfo2);
		
		TCrfSymptomTcm crfSymptomTcm = new TCrfSymptomTcm();
		crfSymptomTcm.setCrfObserveId("OBSE24502281969860974");
		crfSymptomTcm.setDataList(dataList);
		MockHttpServletRequestBuilder post = post("/crf/symptoms/tcm/save").content(JsonUtil.toJson(crfSymptomTcm)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void queryCrfSymptomsTcm() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/symptoms/tcm/query?crfObserveId=OBSE24502281969860974");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


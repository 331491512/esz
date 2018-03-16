
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

import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSigns;
import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSignsInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfPhysicalSignsControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void query() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/physical/signs/query?crfObserveId=20160405205139923564");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void create() throws Exception
	{
		TCrfPhysicalSignsInfo crfPhysicalSignsInfo1 = new TCrfPhysicalSignsInfo();
		crfPhysicalSignsInfo1.setPhysicalSignsId(1);
		crfPhysicalSignsInfo1.setSubjectElementId("S1");
		
		TCrfPhysicalSignsInfo crfPhysicalSignsInfo2 = new TCrfPhysicalSignsInfo();
		crfPhysicalSignsInfo2.setPhysicalSignsId(2);
		crfPhysicalSignsInfo2.setSubjectElementId("S1");
		
		List<TCrfPhysicalSignsInfo> crfPhysicalSignsInfoList = new ArrayList<TCrfPhysicalSignsInfo>();
		crfPhysicalSignsInfoList.add(crfPhysicalSignsInfo1);
		crfPhysicalSignsInfoList.add(crfPhysicalSignsInfo2);
		
		TCrfPhysicalSigns crfPhysicalSigns = new TCrfPhysicalSigns();
		crfPhysicalSigns.setCrfObserveId("20160405205139923564");
		crfPhysicalSigns.setPhysicalSignsList(crfPhysicalSignsInfoList);
		
		MockHttpServletRequestBuilder post = post("/crf/physical/signs/save").content(JsonUtil.toJson(crfPhysicalSigns)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	

}


package com.esuizhen.cloudservice.ehr.controller.icd10;

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

import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class MetaEicd10ControllerTest{

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
	public void addMetainfoIcd10() throws Exception
	{
		MetaEicd10 metaEicd10 = new MetaEicd10();
		metaEicd10.setCurativeEffect("123456");
		metaEicd10.setDiseaseCode("234");
		metaEicd10.setDiseaseName("名称");
		metaEicd10.setSexLimit(1);
		metaEicd10.setHelpRememberCode("321");
		MockHttpServletRequestBuilder post = post("/metainfo/icd10/add").content(JsonUtil.toJson(metaEicd10)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void updateMetainfoIcd10() throws Exception
	{
		MetaEicd10 metaEicd10 = new MetaEicd10();
		metaEicd10.setCurativeEffect("123456");
		metaEicd10.setDiseaseCode("123");
		metaEicd10.setDiseaseName("哈哈");
		metaEicd10.setSexLimit(1);
		metaEicd10.setHelpRememberCode("321");
		MockHttpServletRequestBuilder post = post("/metainfo/icd10/update").content(JsonUtil.toJson(metaEicd10)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	@Ignore
	public void deleteMetainfoIcd10() throws Exception 
	{
		String diseaseCode = "123";
		MockHttpServletRequestBuilder get = get("/metainfo/icd10/delete?diseaseCode="+diseaseCode);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryMetainfoIcd10() throws Exception 
	{
		String  diseaseCode = "123";
		MockHttpServletRequestBuilder get = get("/metainfo/icd10/query?diseaseCode="+ diseaseCode);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void metainfoIcd10List() throws Exception 
	{
//		MockHttpServletRequestBuilder get = get("/metainfo/icd10/list?timeFlag=2015-12-15");
//		MvcResult result = mockMvc.perform((get)).andReturn();
//		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("hahah");
	}
	
	@Test
	@Ignore
	public void queryMetainfoIcd102() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/icd10?diseaseTypeId=300&diseaseBodyPartId=200&diseaseCode=100");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


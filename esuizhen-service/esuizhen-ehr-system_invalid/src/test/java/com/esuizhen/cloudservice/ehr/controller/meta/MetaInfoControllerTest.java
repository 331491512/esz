/**
 * @author: Da Loong
 * @date:   2016年4月7日 下午5:01:57
 */
package com.esuizhen.cloudservice.ehr.controller.meta;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;


import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * @author Da Loong
 * @date   2016年4月7日 下午5:01:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class MetaInfoControllerTest {


	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	
	@Test
	public void testMetainfoPhysicalSignsList() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/physical/signs/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("metainfoPhysicalSignsList done.");
	}
	
	
	@Test
	public void testMetainfoKps() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/kps");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("testMetainfoKps done.");
	}
	
	@Test
	public void testMetainfoEcog() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/ecog");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("testMetainfoEcog done.");
	}
	
	@Test
	public void testMetainfoChildExamType() throws Exception 
	{
		for(int i=1;i<11;i++){
			MockHttpServletRequestBuilder get = get("/metainfo/child/exam/type/query?parentId="+i);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
			LogUtil.log.debug("testMetainfoChildExamType() done.");
		}
	}

	@Test
	public void testMetaInfoExamItemList() throws Exception 
	{
		for(int i=3;i>1;i--){
			MockHttpServletRequestBuilder get = get("/metainfo/exam/item/list?examTypeId="+i);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
			LogUtil.log.debug("testMetainfoChildExamType() done.");
		}
	}
	
	@Test
	public void tesMetaInfoDetectionUnit() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/detection/unit");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("tesMetaInfoTcmSymptom done.");
	}
	
	@Test
	public void testMetainfoChildDetectionType() throws Exception 
	{
		for(int i=1;i<7;i++){
			MockHttpServletRequestBuilder get = get("/metainfo/child/detection/type/query?parentId="+i);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
			LogUtil.log.debug("testMetainfoChildDetectionType() done.");
		}
	}

	@Test
	public void testMetaInfoDetectionItemList() throws Exception 
	{
		for(int i=15;i>9;i--){
			MockHttpServletRequestBuilder get = get("/metainfo/detection/item/list?detectionTypeId="+i);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
			LogUtil.log.debug("testMetainfoChildExamType() done.");
		}
	}
	
	
	@Test
	public void tesMetaInfoSymptom() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/symptoms/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("tesMetaInfoSymptom done.");
	}
	
	@Test
	public void tesMetaInfoQualityoflifeScale() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/qualityoflife/scale/item/list?scaleTypeId=6");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("tesMetaInfoQualityoflifeScale done.");
	}
	
	@Test
	public void tesMetaInfoTreatmentSchemeList() throws Exception 
	{
		for(int i=1;i<3;i++){
			MockHttpServletRequestBuilder get = get("/metainfo/treatment/scheme?treatmentTypeId="+i);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		}
		LogUtil.log.debug("tesMetaInfoTreatmentSchemeList done.");
	}
	
	@Test
	public void tesMetaInfoTreatmentSchemeItemList() throws Exception 
	{
		for(int i=1;i<3;i++){
			MockHttpServletRequestBuilder get = get("/metainfo/treatment/scheme/item/list?treatmentSchemeId="+i);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		}
		LogUtil.log.debug("tesMetaInfoTreatmentSchemeItemList done.");
	}
	
	@Test
	public void tesMetaInfoMedicationItemList() throws Exception 
	{
		for(int i=2;i<3;i++){
			MockHttpServletRequestBuilder get = get("/metainfo/medication/item/list?medicationType="+i);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		}
		LogUtil.log.debug("tesMetaInfoQualityoflifeScale done.");
	}
	
	@Test
	public void tesMetaInfoIcd9Cm3() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/icd9/cm3/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("tesMetaInfoIcd9Cm3 done.");
	}
	
	
	@Test
	public void tesMetaInfoAdverseReaction() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/adverse/reaction/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("tesMetaInfoAdverseReaction done.");
	}
	
	@Test
	public void tesMetaInfoTcmSymptom() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/symptoms/tcm/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("tesMetaInfoTcmSymptom done.");
	}
	@Test
	public void testMetaInfoIcd10() throws Exception 
	{
		
		MockHttpServletRequestBuilder post = post("/metainfo/icd10/search?page=0&num=10&diseaseCode=C00");
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Test
	public void testQueryMetaInfoDiseaseTypeIcdList() throws Exception 
	{
		
		MockHttpServletRequestBuilder post = post("/metainfo/diseasetype/icd/query?name=胃");
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

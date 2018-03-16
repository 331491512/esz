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

import com.esuizhen.cloudservice.research.model.crf.TCrfMedicationInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfRadiotherapyPartInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfScheme;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeChemotherapyMedication;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOther;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOtherInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeRadiotherapy;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfSchemeControllerTest{

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
	public void saveCrfSchemeChemotherapyMedicationDetail() throws Exception
	{
		TCrfMedicationInfo crfMedicationInfo = new TCrfMedicationInfo();
		crfMedicationInfo.setMedicationId(1);
		crfMedicationInfo.setMedicationName("药品");
		crfMedicationInfo.setMedicationType(1);
		
		TCrfMedicationInfo crfMedicationInfo2 = new TCrfMedicationInfo();
		crfMedicationInfo2.setMedicationId(2);
		crfMedicationInfo2.setMedicationName("药品2");
		crfMedicationInfo2.setMedicationType(2);
		
		List<TCrfMedicationInfo> crfMedicationInfoList = new ArrayList<TCrfMedicationInfo>();
		crfMedicationInfoList.add(crfMedicationInfo);
		crfMedicationInfoList.add(crfMedicationInfo2);
		
		TCrfScheme crfScheme = new TCrfScheme();
		crfScheme.setSchemeName("方案");
		crfScheme.setSubjectElementId("S3");
		crfScheme.setMedicationList(crfMedicationInfoList);
		
		List<TCrfScheme> crfSchemeList = new ArrayList<TCrfScheme>();
		crfSchemeList.add(crfScheme);
		
		TCrfSchemeChemotherapyMedication crfSchemeChemotherapyMedication = new TCrfSchemeChemotherapyMedication();
		crfSchemeChemotherapyMedication.setCrfObserveId("OBSE24502281969868092");
		crfSchemeChemotherapyMedication.setDataList(crfSchemeList);
		
		MockHttpServletRequestBuilder post = post("/crf/treatment/scheme/chemotherapy/medication/detail/save").content(JsonUtil.toJson(crfSchemeChemotherapyMedication)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryCrfSchemeChemotherapyMedicationDetail() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/treatment/scheme/chemotherapy/medication/detail/query?crfObserveId=OBSE24502281969868092");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryCrfSchemeRadiotherapyDetail() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/treatment/scheme/radiotherapy/detail/query?crfObserveId=OBSE24502281969867994");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void saveCrfSchemeRadiotherapyDetail() throws Exception
	{
		TCrfRadiotherapyPartInfo crfRadiotherapyPartInfo = new TCrfRadiotherapyPartInfo();
		crfRadiotherapyPartInfo.setRadiotherapyPartId(1);
		
		TCrfRadiotherapyPartInfo crfRadiotherapyPartInfo2 = new TCrfRadiotherapyPartInfo();
		crfRadiotherapyPartInfo2.setRadiotherapyPartId(1);
		
		List<TCrfRadiotherapyPartInfo> crfRadiotherapyPartInfoList = new ArrayList<TCrfRadiotherapyPartInfo>();
		crfRadiotherapyPartInfoList.add(crfRadiotherapyPartInfo);
		crfRadiotherapyPartInfoList.add(crfRadiotherapyPartInfo2);
		
		TCrfScheme crfScheme = new TCrfScheme();
		crfScheme.setSchemeName("方案");
		crfScheme.setSubjectElementId("S3");
		crfScheme.setBodyPartList(crfRadiotherapyPartInfoList);
		
		TCrfScheme crfScheme2 = new TCrfScheme();
		crfScheme2.setSchemeName("方案2");
		crfScheme2.setSubjectElementId("S4");
		crfScheme2.setBodyPartList(crfRadiotherapyPartInfoList);
		
		List<TCrfScheme> crfSchemeList = new ArrayList<TCrfScheme>();
		crfSchemeList.add(crfScheme);
		crfSchemeList.add(crfScheme2);
		
		TCrfSchemeRadiotherapy crfSchemeRadiotherapy = new TCrfSchemeRadiotherapy();
		crfSchemeRadiotherapy.setCrfObserveId("OBSE24502281969867994");
		crfSchemeRadiotherapy.setDataList(crfSchemeList);
		
		MockHttpServletRequestBuilder post = post("/crf/treatment/scheme/radiotherapy/detail/save").content(JsonUtil.toJson(crfSchemeRadiotherapy)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void queryCrfSchemeOtherDetail() throws Exception
	{
		MockHttpServletRequestBuilder get = get("/crf/scheme/other/detail/query?crfObserveId=OBSE24502281969867734");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void saveCrfSchemeOtherDetail() throws Exception
	{
		TCrfSchemeOtherInfo crfSchemeOtherInfo = new TCrfSchemeOtherInfo();
		crfSchemeOtherInfo.setSchemeName("方案10");
		crfSchemeOtherInfo.setSubjectElementId("S3");
		
		TCrfSchemeOtherInfo crfSchemeOtherInfo2 = new TCrfSchemeOtherInfo();
		crfSchemeOtherInfo2.setSchemeName("方案11");
		crfSchemeOtherInfo2.setSubjectElementId("S4");
		
		List<TCrfSchemeOtherInfo> crfSchemeList = new ArrayList<TCrfSchemeOtherInfo>();
		crfSchemeList.add(crfSchemeOtherInfo);
		crfSchemeList.add(crfSchemeOtherInfo2);
		
		TCrfSchemeOther crfSchemeOther = new TCrfSchemeOther();
		crfSchemeOther.setCrfObserveId("OBSE24502281969867734");
		crfSchemeOther.setDataList(crfSchemeList);
		
		MockHttpServletRequestBuilder post = post("/crf/scheme/other/detail/save").content(JsonUtil.toJson(crfSchemeOther)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
}


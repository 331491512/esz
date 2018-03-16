package com.esuizhen.cloudservice.ehr.controller.meta;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class MetaInfoFromEmcControllerTest {

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
	public void getMetaInfoPayChannelList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/pay/channel/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void getMetaInfoConditionList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/condition/list?bussinessType=0");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void getMetaInfoNationList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/nation/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void getMetaInfoNationalityList()throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/nationality/list?nationalityName=中");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void getMetaInfoOccupationList() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/occupation/list?occupationName=工");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	@Ignore
	public void getMetaInfoCountyList() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/county/list?provinceCode=130000&cityCode=130100&countyCode=130102");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void getMetaInfoTreatmentHistoryList() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/metainfo/treatment/history/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Test
	@Ignore
	public void getMetaInfoTreatmentList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/treatment/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	@Ignore
	public void getMetaInfoSurgeryIntensiveList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/surgery/intensive/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * 麻醉方式元数据列表
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void getMetaInfoAnesthesiaWayList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/anesthesia/way/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * 手术元数据列表
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void getMetaInfoIcd9Cm3List() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/icd9/cm3/list?key=LZX CZ");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * 治疗方案元数据列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void getMetaInfoTreatmentSchemeList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/treatment/scheme/list?treatmentTypeId=12");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * 肿瘤分期元数据列表
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void getMetaInfoTumourPeriodizationList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/tumour/periodization/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * 医生数据列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void getMetaInfoDoctorList() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/doctor/list").param("trueName", "王");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

}

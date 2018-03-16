package com.esuizhen.cloudservice.ehr.controller.inhospital;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Date;

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

import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.PatientInfoReq;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TInhospitalDetailInfoControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	@Test
	public void queryInhospitalInfo() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/inhospital/info/query?patientId=1915735&page=0&num=10&outhospitalDateStart=2014-01-01&outhospitalDateEnd=2016-01-01");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Test
	public void queryInhospitalDetail() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/inhospital/detail/query?inhospitalId=EINH20160712193924264616");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Test
	public void updateInhospitalDetail() throws Exception
	{
		TInhospitalDetailInfo inhospitalDetailInfo = new TInhospitalDetailInfo();
		inhospitalDetailInfo.setInhospitalId("EINH20160712193924264616");
		inhospitalDetailInfo.setAllergyDesc("修改描述");
		inhospitalDetailInfo.setTrueName("用户名字");
		inhospitalDetailInfo.setPathologyNo("456");
		inhospitalDetailInfo.setTumourPeriodizationT("T3");
		inhospitalDetailInfo.setTumourPeriodizationN("N");
		inhospitalDetailInfo.setTumourPeriodizationM1("M1");
		inhospitalDetailInfo.setPoisoningDiseaseCode("C78.503");
		inhospitalDetailInfo.setOuthoispitalWay(5);
		inhospitalDetailInfo.setNation("回");
		inhospitalDetailInfo.setNationId(2);
		inhospitalDetailInfo.setPatientId(1L);
		inhospitalDetailInfo.setPatientNo("2345");
		inhospitalDetailInfo.setHospitalId(123456);
		inhospitalDetailInfo.setInhospitalDate(new Date());
		inhospitalDetailInfo.setInhospitalTimes(1);
		inhospitalDetailInfo.setTurnDept("adfa");
		inhospitalDetailInfo.setSyncflag(1);
		inhospitalDetailInfo.setSourceflag(1);
		inhospitalDetailInfo.setDeathCause("aaaaaaa");
		inhospitalDetailInfo.setDeathTime(new Date());
		inhospitalDetailInfo.setOperatorId(1l);
		inhospitalDetailInfo.setOperatorName("张在");
		inhospitalDetailInfo.setPathologyDiagnosis("klafjlakd");
		inhospitalDetailInfo.setInchargeDoctor(3l);
		
		MockHttpServletRequestBuilder post = post("/inhospital/detail/update").content(JsonUtil.toJson(inhospitalDetailInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	@Test
	public void createInhospitalDetail() throws Exception
	{
		TInhospitalDetailInfo inhospitalDetailInfo = new TInhospitalDetailInfo();
		inhospitalDetailInfo.setEmrId("EMRI201602011304033fc734fac8a111e5b79a00163e006090");
		inhospitalDetailInfo.setPatientId(2L);
		inhospitalDetailInfo.setPatientNo("203");
		inhospitalDetailInfo.setHospitalId(23499);
		inhospitalDetailInfo.setInhospitalDate(new Date());
		inhospitalDetailInfo.setInhospitalTimes(1);
		inhospitalDetailInfo.setTurnDept("adfa");
		inhospitalDetailInfo.setSyncflag(1);
		inhospitalDetailInfo.setSourceflag(1);
		inhospitalDetailInfo.setDeathCause("aaaaaaa");
		inhospitalDetailInfo.setDeathTime(new Date());
		
		inhospitalDetailInfo.setAllergyDesc("修改描述");
		inhospitalDetailInfo.setTrueName("用户名字");
		MockHttpServletRequestBuilder post = post("/inhospital/detail/create").content(JsonUtil.toJson(inhospitalDetailInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void updateInhospitalFiling() throws Exception
	{
		PatientInfoReq req = new PatientInfoReq();
		req.setInhospitalId("100");
		MockHttpServletRequestBuilder get = post("/inhospital/filing/update").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void deleteInhospitalDetail() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/inhospital/detal/delete?inhospitalId=EINH20160712193924264616");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void importIntenetInhospitalInfo() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/inhospital/info/import/test");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


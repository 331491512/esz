package com.esuizhen.cloudservice.followup.controller.followupresult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
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

import com.esuizhen.cloudservice.followup.bean.FollowupResultLogReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupPhoneResultSearchInfo;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.util.JsonUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class FollowupResultControllerTest 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	/**
	 * 已测试通过
	 */
	@Test
	public void queryFollowupResultStatis() throws Exception
	{
		
		Map<String,Object> info = new HashMap<String,Object>();

		info.put("followupWay", 4);
		info.put("page", 0);
		info.put("num", 10);
		
		MockHttpServletRequestBuilder post = post("/result/query").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		
	}
	
	/**
	 * 已测试通过
	 */
	@Test
	public void queryFollowupResultDetail() throws Exception
	{
		
		Map<String,Object> info = new HashMap<String,Object>();

		info.put("followupWay", 1);
		info.put("page", 0);
		info.put("num", 10);
		
		MockHttpServletRequestBuilder post = post("/result/detail/query").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * 已测试通过
	 */
	@Test
	public void statisFollowupResult() throws Exception
	{
		Map<String,Object> info = new HashMap<String,Object>();

		info.put("templateId", "CONT20160901105054468718");
		info.put("followupWay", 1);
		
		MockHttpServletRequestBuilder post = post("/result/statis").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		
	}
	
	/**
	 * 已测试通过
	 */
	@Test
	public void queryFollowupPhoneResult() throws Exception
	{
		TFollowupPhoneResultSearchInfo info=new TFollowupPhoneResultSearchInfo();
		info.setPage(0);
		info.setNum(10);
//		info.setOperator(0L);
		
		
//		info.setTreatmentSchemeIds("1,2,3");
		
		
		MockHttpServletRequestBuilder post = post("/result/phone/query").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void statisFollowupPhoneResult() throws Exception
	{
		TFollowupPhoneResultSearchInfo info=new TFollowupPhoneResultSearchInfo();
		info.setPage(0);
		info.setNum(10);
		MockHttpServletRequestBuilder post = post("/result/phone/statis").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		
	}
	
	/**
	 * 已测试通过
	 */
	@Test
	public void queryFollowupResultHistory() throws Exception
	{
		MockHttpServletRequestBuilder get = get("/result/history/query")
				.param("page", "0")
				.param("patientId", "60074")
				.param("num","10");
		MvcResult result = mockMvc.perform(( get))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryLastFollowupResultList() throws Exception
	{
		List<PatientSimpleInfo> patientSimpleInfos = new ArrayList<PatientSimpleInfo>();
		PatientSimpleInfo info1 = new PatientSimpleInfo();
		info1.setPatientId(413019L);
		
		patientSimpleInfos.add(info1);
		MockHttpServletRequestBuilder post = post("/result/last/followup/result/query").content(JsonUtil.toJson(patientSimpleInfos)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * 已测试通过
	 */
	@Test
	public void queryFollowupResultLog() throws Exception
	{
		FollowupResultLogReq info=new FollowupResultLogReq();
		info.setPage(0);
		info.setNum(10);
		info.setPatientId(389816L);
		
		MockHttpServletRequestBuilder post = post("/result/log/list").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

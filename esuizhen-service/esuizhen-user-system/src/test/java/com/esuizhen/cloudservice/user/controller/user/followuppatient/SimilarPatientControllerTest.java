package com.esuizhen.cloudservice.user.controller.user.followuppatient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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

import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimilarPatientControllerTest {
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
	public void aquerySimilarPatient() throws Exception {
		TPatientSearchInfo  similarPatientSearchInfo = new TPatientSearchInfo();
		similarPatientSearchInfo.setUserId(1l);
//		similarPatientSearchInfo.setPatientNo("001010000001");
		MockHttpServletRequestBuilder post = post("/similar/patient/list").content(JsonUtil.toJson(similarPatientSearchInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("\nresult=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
//	@Ignore
	public void bgetSearchSimilarPatientSimpleInfo() throws Exception {
		TwiceSearchReq twiceSearchReq = new TwiceSearchReq();
		twiceSearchReq.setPage(0);
		twiceSearchReq.setNum(10);
		twiceSearchReq.setSearchId(4698);
		MockHttpServletRequestBuilder post = post("/similar/patient/simple/list/search").content(JsonUtil.toJson(twiceSearchReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("\nresult=\n"+result.getResponse().getContentAsString());
	}

	@Test
	@Ignore
	public void cmergeSimilarPatient() throws Exception {
		List<Long> list = new ArrayList<Long>();
		list.add(43l);
		list.add(44l);
		MockHttpServletRequestBuilder post = post("/similar/patient/merge").content(JsonUtil.toJson(list)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("\nresult=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	@Ignore
	public void drevokeSimilarPatient() throws Exception {
		MockHttpServletRequestBuilder get = get("/similar/patient/revoke?patientId=2");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("\n#####################result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryDemandMightRepeatPatientList() throws Exception
	{
		MockHttpServletRequestBuilder get = get("/demand/might/repeat/patient/list?searchId=" + 5630);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

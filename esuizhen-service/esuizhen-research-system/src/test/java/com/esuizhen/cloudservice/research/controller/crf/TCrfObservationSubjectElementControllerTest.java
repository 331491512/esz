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

import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElementSet;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfObservationSubjectElementControllerTest{

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
	public void query() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/subject/element/child/query?crfCourseItemId=1&parentId=1");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void set() throws Exception
	{
		TCrfObservationSubjectElementSet crfObservationSubjectElementSet = new TCrfObservationSubjectElementSet();
		
		List<TCrfObservationSubjectElement> subjectElemenList = new ArrayList<TCrfObservationSubjectElement>();
		
		TCrfObservationSubjectElement crfObservationSubjectElement = new TCrfObservationSubjectElement();
		crfObservationSubjectElement.setSubjectElementId("S1");
		crfObservationSubjectElement.setSubjectIndex(0);
		
		TCrfObservationSubjectElement crfObservationSubjectElement2 = new TCrfObservationSubjectElement();
		crfObservationSubjectElement2.setSubjectElementId("S3");
		crfObservationSubjectElement2.setSubjectIndex(1);
		
		
		subjectElemenList.add(crfObservationSubjectElement);
		subjectElemenList.add(crfObservationSubjectElement2);
		
		crfObservationSubjectElementSet.setCrfCourseItemId("CITEM24502281969863982");
		crfObservationSubjectElementSet.setSubjectElemenList(subjectElemenList);
		
		MockHttpServletRequestBuilder post = post("/crf/subject/element/child/set").content(JsonUtil.toJson(crfObservationSubjectElementSet)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Ignore
	@Test
	public void remove() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/subject/element/child/remove?crfObserveId=1");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryFollowupTimeAxis() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/result/outline/secondary/query?crfCourseItemId=COUR24552946679178941&patientId=1954819");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


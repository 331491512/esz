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

import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReaction;
import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReactionInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfAdverseReactionControllerTest{

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
	public void saveCrfAdverseReaction() throws Exception
	{
		TCrfAdverseReactionInfo crfAdverseReactionInfo = new TCrfAdverseReactionInfo();
		crfAdverseReactionInfo.setAdverseReactionId(1);
		crfAdverseReactionInfo.setSubjectElementId("T51");
		
		TCrfAdverseReactionInfo crfAdverseReactionInfo2 = new TCrfAdverseReactionInfo();
		crfAdverseReactionInfo2.setAdverseReactionId(2);
		crfAdverseReactionInfo2.setSubjectElementId("T53");
		
		List<TCrfAdverseReactionInfo> list = new ArrayList<TCrfAdverseReactionInfo>();
		list.add(crfAdverseReactionInfo);
		list.add(crfAdverseReactionInfo2);
		
		TCrfAdverseReaction crfAdverseReaction = new TCrfAdverseReaction();
		crfAdverseReaction.setCrfObserveId("OBSE24502281969864044");
		crfAdverseReaction.setAdverseReactionList(list);
		
				
		MockHttpServletRequestBuilder post = post("/crf/adverse/reaction/save").content(JsonUtil.toJson(crfAdverseReaction)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Test
	@Ignore
	public void queryCrfAdverseReaction() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/adverse/reaction/query?crfObserveId=OBSE24502281969864044");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


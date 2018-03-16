package com.esuizhen.cloudservice.statistics;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;

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

import com.esuizhen.cloudservice.statistics.model.TRetrievalParamentMould;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class RetrievalControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void test_searchRetrievalParamentMouldList() throws Exception {
		TRetrievalParamentMould retrievalParamentMould = new TRetrievalParamentMould();
		
		logger.info("Send=\n" + JsonUtil.toJson(retrievalParamentMould));
		MockHttpServletRequestBuilder post = post("/retrieval/parament/mould/list")
				.content(JsonUtil.toJson(retrievalParamentMould)).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_getRetrievalParamentMouldDetail() throws Exception {
		MockHttpServletRequestBuilder get = get("/retrieval/parament/mould/detail").
				param("mouldId", "abc");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_removeRetrievalParamentMould() throws Exception {
		TRetrievalParamentMould retrievalParamentMould = new TRetrievalParamentMould();
		retrievalParamentMould.setMouldId("ABC1254");
		logger.info("Send=\n" + JsonUtil.toJson(retrievalParamentMould));
		MockHttpServletRequestBuilder post = post("/retrieval/parament/mould/delete")
				.content(JsonUtil.toJson(retrievalParamentMould)).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

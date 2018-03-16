package com.esuizhen.cloudservice.user.controller.user.followuppatient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.FixMethodOrder;
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

import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommonControllerTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	protected MvcResult doGet(String reqUrl) {
		MockHttpServletRequestBuilder get = get(reqUrl);
		MvcResult result = null;
		try {
			result = mockMvc.perform((get)).andReturn();
			logger.info("\n#################result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected MvcResult doPost(String reqUrl,Object o) {
		logger.debug("打印请求参数："+JsonUtil.toJson(o));
		MockHttpServletRequestBuilder post = post(reqUrl).content(JsonUtil.toJson(o)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = null;
		try {
			result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("\n#################result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

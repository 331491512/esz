/**
 * 
 */
package com.esuizhen.cloudservice.research.controller.meta;

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
/**
 * @author Da Loong
 *
 */
public class CrfMetaInfoControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void query() throws Exception {
		for (int i = 1; i <= 11; i++) {
			String parentId = "S" + i;
			MockHttpServletRequestBuilder get = get(
					"/project/metainfo/crf/subject/element/child/list?parentId=" + parentId);
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("\n========================" + i + ":parentId=" + parentId + ". result=\n"
					+ JsonUtil.beautiful(result.getResponse().getContentAsString()));
		}
	}
	
	@Test
	public void queryMetaSubcenterRoleList_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/meta/subcenter/role/list/query");
		MvcResult result = mockMvc.perform(get).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

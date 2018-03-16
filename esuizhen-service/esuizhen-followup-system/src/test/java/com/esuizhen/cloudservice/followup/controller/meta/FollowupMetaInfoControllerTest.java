package com.esuizhen.cloudservice.followup.controller.meta;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Date;
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

import com.esuizhen.cloudservice.followup.bean.TFollowupTaskCreateReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByLeaderQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByOperatorQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.dao.user.UserDao;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupContentTemplateSimpleInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssign;
import com.westangel.common.util.JsonUtil;

/**
 * @author DaLoong
 * @date  2016-8-13 下午12:34:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupMetaInfoControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Autowired
	private UserDao userDao;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	/**
	 * 随访人员-按任务
	 * @throws Exception
	 */
	@Test
	public void getFollowupOperatorListTest() throws Exception {
		
		MockHttpServletRequestBuilder get = get("/metainfo/operator/list").param("followupTaskId", "1");
				
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	/**
	 * 随访人员-所有
	 * @throws Exception
	 */
	@Test
	public void getFollowupOperatorListTest_Case2() throws Exception {
		
		MockHttpServletRequestBuilder get = get("/metainfo/operator/list");
				
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}

	
	/**
	 * 随访结果
	 * @throws Exception
	 */
	@Test
	public void getMetaInfoFollowupResultValueListTest() throws Exception {
		
		MockHttpServletRequestBuilder get = get("/metainfo/followupresultvalue/list");
				
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}

	/**
	 * 随访结果
	 * @throws Exception
	 */
	@Test
	public void getMetaInfoFollowupResultValueListTest_Case2() throws Exception {
		
		MockHttpServletRequestBuilder get = get("/metainfo/followupresultvalue/list?type=1");
				
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}



	/**
	 * 随访方式
	 * @throws Exception
	 */
	@Test
	public void getMetaInfoFollowupWayListTest() throws Exception {
		
		MockHttpServletRequestBuilder get = get("/metainfo/followupway/list");
				
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}

}

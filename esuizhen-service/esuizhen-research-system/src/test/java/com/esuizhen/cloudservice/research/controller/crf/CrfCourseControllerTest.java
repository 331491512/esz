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

import com.esuizhen.cloudservice.research.bean.TCrfCourseConf;
import com.esuizhen.cloudservice.research.bean.TCrfCourseConfInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class CrfCourseControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void projectTemplateCrfCourseSet_test() throws Exception {
		TCrfCourseConf tCrfCourseConf = new TCrfCourseConf();
		List<TCrfCourseConfInfo> crfCourseList = new ArrayList<TCrfCourseConfInfo>();
		TCrfCourseConfInfo crfCourseConfInfo1 = new TCrfCourseConfInfo();
		TCrfCourseConfInfo crfCourseConfInfo2 = new TCrfCourseConfInfo();
		TCrfCourseConfInfo crfCourseConfInfo3 = new TCrfCourseConfInfo();
		
		crfCourseConfInfo1.setCrfCourseItemName("第一阶段");
		crfCourseConfInfo1.setCrfCourseIndex(1);
		crfCourseConfInfo1.setFollowupPeriod(2);
		crfCourseConfInfo1.setFollowupPeriodUnit("m");
		crfCourseConfInfo1.setFollowupFrequency(1);
		crfCourseConfInfo1.setFollowupFrequencyUnit("w");
		crfCourseConfInfo1.setFollowupCount(8);
		
		crfCourseConfInfo2.setCrfCourseItemName("第二阶段");
		crfCourseConfInfo2.setCrfCourseIndex(2);
		crfCourseConfInfo2.setFollowupPeriod(2);
		crfCourseConfInfo2.setFollowupPeriodUnit("y");
		crfCourseConfInfo2.setFollowupFrequency(6);
		crfCourseConfInfo2.setFollowupFrequencyUnit("m");
		crfCourseConfInfo2.setFollowupCount(4);
		
		crfCourseConfInfo3.setCrfCourseItemName("第三阶段");
		crfCourseConfInfo3.setCrfCourseIndex(3);
		crfCourseConfInfo3.setFollowupPeriod(5);
		crfCourseConfInfo3.setFollowupPeriodUnit("y");
		crfCourseConfInfo3.setFollowupFrequency(1);
		crfCourseConfInfo3.setFollowupFrequencyUnit("y");
		crfCourseConfInfo3.setFollowupCount(5);
		
		tCrfCourseConf.setCrfTemplateId("PTEM20160406144740626392");
		tCrfCourseConf.setFollowupStartMark(1);
		
		crfCourseList.add(crfCourseConfInfo1);
		crfCourseList.add(crfCourseConfInfo2);
		crfCourseList.add(crfCourseConfInfo3);
		tCrfCourseConf.setCrfCourseList(crfCourseList);
		
		logger.info("Send=\n" + JsonUtil.toJson(tCrfCourseConf));
		MockHttpServletRequestBuilder post = post("/template/crfcourse/set")
				.content(JsonUtil.toJson(tCrfCourseConf)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void projectTemplateCrfCourseQuery_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/template/crfcourse/query?crfTemplateId=PTEM24502281969860964");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void queryCrfObserve_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/observe/query?crfTemplateId=PTEM24522662965456052");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryProjectCourseItems() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/result/outline/first/query?projectId=PROJ20160527153157699431&patientId=1954819");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

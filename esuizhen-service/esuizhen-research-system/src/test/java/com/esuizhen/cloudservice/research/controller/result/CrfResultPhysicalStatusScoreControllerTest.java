package com.esuizhen.cloudservice.research.controller.result;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalStatusScore;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class CrfResultPhysicalStatusScoreControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void test_queryCrfResultPhysicalStatusScoreRecord() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/result/physical/status/score/record/query?projectId=PROJ20160527153157699431&patientId=1954819");
		MvcResult result = mockMvc.perform(get).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryCrfResultPhysicalStatusScoreI() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/result/physical/status/score/query?crfObserveId=OBSE24552946679178953&patientId=1954819");
		MvcResult result = mockMvc.perform(get).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void test_saveCrfResultPhysicalStatusScore() throws Exception {
		TCrfResultMainInfo<TCrfResultPhysicalStatusScore> crfResultMainInfo = new TCrfResultMainInfo<TCrfResultPhysicalStatusScore>();
		TCrfResultPhysicalStatusScore crfResultPhysicalStatusScore = new TCrfResultPhysicalStatusScore();
		crfResultPhysicalStatusScore.setCrfResultId("CRRI20160601182347824518");
		crfResultPhysicalStatusScore.setCheckDate(new Date());
		crfResultPhysicalStatusScore.setSubjectElementId("T41");
		crfResultPhysicalStatusScore.setScore(80);
		
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178953");
		crfResultMainInfo.setSubjectElementId("S4");
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setPatientId(1954819L);
		crfResultMainInfo.setCreatorId(21004L);
		crfResultMainInfo.setCrfResult(crfResultPhysicalStatusScore);
		
		List<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>> crfResultMainInfoes = new ArrayList<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>>();
		crfResultMainInfoes.add(crfResultMainInfo);
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfoes));
		MockHttpServletRequestBuilder post = post("/crf/result/physical/status/score/save")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

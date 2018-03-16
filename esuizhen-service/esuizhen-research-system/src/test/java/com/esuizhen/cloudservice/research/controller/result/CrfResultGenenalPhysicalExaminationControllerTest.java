package com.esuizhen.cloudservice.research.controller.result;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Date;

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

import com.esuizhen.cloudservice.research.model.result.TCrfResultGenenalPhysicalExamination;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class CrfResultGenenalPhysicalExaminationControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void test_queryCrfResultGenenaPhysicalExamRecord() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/result/genenal/physical/exam/record/query?projectId=PROJ20160527153157699431&patientId=1954819");
		MvcResult result = mockMvc.perform(get).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryCrfResultDemography() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/result/genenal/physical/exam/query?crfObserveId=OBSE24552946679178963&patientId=1954819");
		MvcResult result = mockMvc.perform(get).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void test_saveGenenalPhysicalExam() throws Exception {
		TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> crfResultMainInfo = new TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>();
		TCrfResultGenenalPhysicalExamination crfResultGenenalPhysicalExamination = new TCrfResultGenenalPhysicalExamination();
		crfResultGenenalPhysicalExamination.setCrfResultId("CRRI2016053116130130752220160531161301947182");
		crfResultGenenalPhysicalExamination.setCheckDate(new Date());
		crfResultGenenalPhysicalExamination.setHight(180);
		
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178963");
		crfResultMainInfo.setSubjectElementId("T11");
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setPatientId(1954819L);
		crfResultMainInfo.setCreatorId(21004L);
		crfResultMainInfo.setCrfResult(crfResultGenenalPhysicalExamination);
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/crf/result/genenal/physical/exam/save")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void test_queryCrfProfilePhysicalExamThreshold() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/profile/physical/exam/threshold/query?projectId=PROJ20160527153157699431&patientId=1954819");
		MvcResult result = mockMvc.perform(get).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

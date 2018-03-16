package com.esuizhen.cloudservice.research.controller.result;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;
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

import com.esuizhen.cloudservice.research.model.result.TCrfResultExam;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class CrfResultExamControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void test_queryCrfResultExamRecord() {
		MockHttpServletRequestBuilder get = get("/crf/result/exam/record/query?projectId=PROJ20160527153157699431&patientId=1954819");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_crfResultExamQuery() {
		MockHttpServletRequestBuilder get = get("/crf/result/exam/query?crfObserveId=OBSE24552946679178954&patientId=1954819");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_saveCrfResultExam() {
		TCrfResultMainInfo<List<TCrfResultExam>> crfResultMainInfo = new TCrfResultMainInfo<List<TCrfResultExam>>();
		List<TCrfResultExam> crfResultExams = new ArrayList<TCrfResultExam>();
		TCrfResultExam crfResultExam1 = new TCrfResultExam();
		crfResultExam1.setCrfResultId("CRRI20160602103504887383");
		crfResultExam1.setExamParentTypeId("S1");
		
		crfResultExams.add(crfResultExam1);
		
		crfResultMainInfo.setCrfObserveId("OBSE24552946679178954");
		crfResultMainInfo.setCrfResultId("CRRI20160602103504887383");
		crfResultMainInfo.setSubjectElementId("S5");
		crfResultMainInfo.setProjectId("PROJ20160527153157699431");
		crfResultMainInfo.setCrfCourseItemTime(new Date());
		crfResultMainInfo.setPatientId(1954819L);
		crfResultMainInfo.setCreatorId(21004L);
		crfResultMainInfo.setCrfResult(crfResultExams);
		logger.info("Send=\n" + JsonUtil.toJson(crfResultMainInfo));
		MockHttpServletRequestBuilder post = post("/crf/result/exam/save")
				.content(JsonUtil.toJson(crfResultMainInfo)).contentType(MediaType.APPLICATION_JSON);
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

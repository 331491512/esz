package com.esuizhen.cloudservice.statistics;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;

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

import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class QuestionnaireStatisticsControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void searchQuestionnaireSurvey_test() {
		TCommonParam commonParam = new TCommonParam();
		//commonParam.setSubject("问卷");
		//commonParam.setFollowupTaskName("测试");
		logger.info("Send=\n" + JsonUtil.toJson(commonParam));
		MockHttpServletRequestBuilder post = post("/questionnaire/survey/search")
				.content(JsonUtil.toJson(commonParam)).contentType(MediaType.APPLICATION_JSON);
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
	public void statisQuestionnaireSurveyResult_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/questionnaire/survey/result/statis").
				param("questionnaireId", "QUES20160830165016309924");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

}

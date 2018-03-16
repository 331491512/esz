package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.SimpleDateFormat;
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

import com.esuizhen.cloudservice.sync.model.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireOptions;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireStem;
import com.westangel.common.util.JsonUtil;

/** 
 *@className QuestionnaireControllerTest
 *@Description:
 *@author yuanwenming
 *@date 2017年8月11日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class QuestionnaireControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void syncQuestionnaireFollowupResultFromCloud(){
		MockHttpServletRequestBuilder get = get("/fromcloud/questionnaire/followupresult").param("hospitalId", "19193");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendQuestionnaireFollowupMessage() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date fillDate = format.parse("2017-08-11 13:23:31");
		TFollowupQuestionnaireDetailInfo detailInfo = new TFollowupQuestionnaireDetailInfo();
		TFollowupContentTemplateInfo contentTemplateInfo = new TFollowupContentTemplateInfo();
		detailInfo.setContentTemplateInfo(contentTemplateInfo);
		contentTemplateInfo.setAuthor(3);
		contentTemplateInfo.setContent("单位测试001--111");
		contentTemplateInfo.setContentTemplateId("CONT20170811132702201524");
		contentTemplateInfo.setContentTemplateName("单位测试001");
		contentTemplateInfo.setContentTemplateType(6);
		contentTemplateInfo.setNeedReply(0);
		contentTemplateInfo.setIsPublish(1);
		contentTemplateInfo.setCreateTime(fillDate);
		contentTemplateInfo.setUpdateTime(fillDate);
		detailInfo.setQuestionnaireId("QUES20170811132702575093");
		detailInfo.setContentTemplateId("CONT20170811132702201524");
		detailInfo.setSubject("单位测试001");
		detailInfo.setDescription("单位测试001--111");
		detailInfo.setAuthor(3);
		detailInfo.setCreateTime(fillDate);
		detailInfo.setUpdateTime(fillDate);
		List<TFollowupQuestionnaireStem> stemList = new ArrayList<TFollowupQuestionnaireStem>();
		detailInfo.setStemList(stemList);
		TFollowupQuestionnaireStem stem = new TFollowupQuestionnaireStem();
		stem.setQuestionnaireStemId("QSTE20170811132702298928");
		stem.setQuestionnaireId("QUES20170811132702575093");
		stem.setMandatoryFlag(1);
		stem.setContent("九寨沟是哪个地方");
		stem.setStemCode(1+"");
		stem.setStemIndex(1);
		stem.setSectionTitle("中国地名");
		stem.setQuestionType(1);
		stem.setCreateTime(fillDate);
		stem.setUpdateTime(fillDate);
		stemList.add(stem);
		List<TFollowupQuestionnaireOptions> questionOptions = new ArrayList<TFollowupQuestionnaireOptions>();
		stem.setQuestionOptions(questionOptions);
		TFollowupQuestionnaireOptions options1 = new TFollowupQuestionnaireOptions();
		options1.setQuestionnaireOptionId("QOPT20170811132702378719");
		options1.setQuestionnaireStemId("QSTE20170811132702298928");
		options1.setQuestionnaireId("QUES20170811132702575093");
		options1.setContentType(1);
		options1.setContent("四川");
		options1.setOptionIndex(1);
		options1.setStemCode(1+"");
		options1.setNextStemCode(2+"");
		options1.setParentOptionId(0+"");
		options1.setLevel(0);
		options1.setFillFlag(0);
		options1.setFillContentType(1);
		options1.setIsChecked(0);
		TFollowupQuestionnaireOptions options2 = new TFollowupQuestionnaireOptions();
		options2.setQuestionnaireOptionId("QOPT20170811132702990998");
		options2.setQuestionnaireStemId("QSTE20170811132702298928");
		options2.setQuestionnaireId("QUES20170811132702575093");
		options2.setContentType(1);
		options2.setContent("云南");
		options2.setOptionIndex(2);
		options2.setStemCode(1+"");
		options2.setNextStemCode(2+"");
		options2.setParentOptionId(0+"");
		options2.setLevel(0);
		options2.setFillFlag(0);
		options2.setFillContentType(1);
		options2.setIsChecked(0);
		questionOptions.add(options1);
		questionOptions.add(options2);
		
		MockHttpServletRequestBuilder post = post("/questionnaire/message/send").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(detailInfo));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(detailInfo)));
		try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
}

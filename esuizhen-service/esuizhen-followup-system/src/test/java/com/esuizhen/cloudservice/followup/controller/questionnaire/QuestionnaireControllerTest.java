package com.esuizhen.cloudservice.followup.controller.questionnaire;

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

import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireOptions;
import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireStem;
import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireTitle;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnaireResultOptionsDetail;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnaireResultStem;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class QuestionnaireControllerTest 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	@Ignore
	public void createPlanTemplate() throws Exception
	{
		TFollowupQuestionnaireOptions options = new TFollowupQuestionnaireOptions();
		options.setContent("B");
		options.setContentType(1);
		List<TFollowupQuestionnaireOptions> optionsList = new ArrayList<TFollowupQuestionnaireOptions>();
		optionsList.add(options);
		
		TFollowupQuestionnaireStem stem = new TFollowupQuestionnaireStem();
		stem.setContent("请选择答案");
		stem.setQuestionOptions(optionsList);
		List<TFollowupQuestionnaireStem> stemList = new ArrayList<TFollowupQuestionnaireStem>();
		stemList.add(stem);
		
		TFollowupQuestionnaireTitle title = new TFollowupQuestionnaireTitle();
		title.setTitle("您最近身体怎么样？");
		title.setQuestionnaireList(stemList);
		
		List<TFollowupQuestionnaireTitle> titleList = new ArrayList<TFollowupQuestionnaireTitle>();
		titleList.add(title);
		
		TFollowupQuestionnaireDetailInfo detialInfo = new TFollowupQuestionnaireDetailInfo();
		detialInfo.setSubject("问卷名称");
		detialInfo.setDescription("问卷描述");
		//detialInfo.setTitleList(titleList);
		
		
		
		MockHttpServletRequestBuilder post = post("/questionnaire/add").content(JsonUtil.toJson(detialInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	@Ignore
	public void deleteFollowupQuestionnaire() throws Exception 
	{
		String questionnaireId = "151207074138725977";
		MockHttpServletRequestBuilder get = get("/questionnaire/delete?questionnaireId="+questionnaireId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void queryFollowupQuestionnaire() throws Exception 
	{
		//MockHttpServletRequestBuilder get = get("/questionnaire/query").param("questionnaireId", "151211055447162278");
		MockHttpServletRequestBuilder get = get("/questionnaire/query").param("contentTemplateId", "CONT20160903182800795463");
		//MockHttpServletRequestBuilder get = get("/questionnaire/query?patientId=20");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void updateFollowupQuestionnaire() throws Exception
	{
		TFollowupQuestionnaireOptions options = new TFollowupQuestionnaireOptions();
		options.setContent("C");
		options.setContentType(1);
		List<TFollowupQuestionnaireOptions> optionsList = new ArrayList<TFollowupQuestionnaireOptions>();
		optionsList.add(options);
		
		TFollowupQuestionnaireStem stem = new TFollowupQuestionnaireStem();
		stem.setContent("请选择答案");
		stem.setQuestionOptions(optionsList);
		List<TFollowupQuestionnaireStem> stemList = new ArrayList<TFollowupQuestionnaireStem>();
		stemList.add(stem);
		
		TFollowupQuestionnaireTitle title = new TFollowupQuestionnaireTitle();
		title.setTitle("您最近复查了吗？");
		title.setQuestionnaireList(stemList);
		
		List<TFollowupQuestionnaireTitle> titleList = new ArrayList<TFollowupQuestionnaireTitle>();
		titleList.add(title);
		
		TFollowupQuestionnaireDetailInfo detialInfo = new TFollowupQuestionnaireDetailInfo();
		detialInfo.setQuestionnaireId("151207074144448100");
		detialInfo.setSubject("问卷名称");
		detialInfo.setDescription("问卷描述");
		//detialInfo.setTitleList(titleList);
		
		
		
		MockHttpServletRequestBuilder post = post("/questionnaire/update").content(JsonUtil.toJson(detialInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void followupQuestionnaireResultList() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/questionnaire/result/list?patientId=10&reqFlag=0&page=0&num=4");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void queryFollowupQuestionnaireResult() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/questionnaire/result/query?followupItemId=20160115093753575363");
//		MockHttpServletRequestBuilder get = get("/questionnaire/result/query?questionnaireResultId=20160115105856931827");
		
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void wirteFollowupQuestionnaireResult() throws Exception 
	{
		
		
		TQuestionnaireResultStem stem1 = new TQuestionnaireResultStem();
		stem1.setContent("请连续答30天问卷");
		stem1.setQuestionnaireId(GeneralUtil.generatorTimeUUID());
		stem1.setQuestionnaireStemId(GeneralUtil.generatorTimeUUID());
		stem1.setMandatoryFlag(1);
		stem1.setSectionTitle("标题");
		stem1.setStemIndex(1);
		stem1.setStemCode("000");
		stem1.setQuestionType(1);
		stem1.setAnswerFlag(1);
		
		

		
		
		TQuestionnaireResultOptionsDetail detail = new TQuestionnaireResultOptionsDetail();
		detail.setQuestionnaireOptionId(GeneralUtil.generatorTimeUUID());
		detail.setQuestionnaireStemId(GeneralUtil.generatorTimeUUID());
		detail.setStemCode("000");
		detail.setOptionIndex(1);
		detail.setContentType(1);
		detail.setContent("马马虎虎");
		detail.setIndicateValue("1");
		detail.setNextStemCode("111");
		detail.setParentOptionId("0");
		detail.setLevel(0);
		detail.setIsChecked(1);
		
		
		
		TQuestionnaireResultOptionsDetail detail2 = new TQuestionnaireResultOptionsDetail();
		detail2.setQuestionnaireOptionId(GeneralUtil.generatorTimeUUID());
		detail2.setQuestionnaireStemId(GeneralUtil.generatorTimeUUID());
		detail2.setStemCode("000");
		detail2.setOptionIndex(1);
		detail2.setContentType(1);
		detail2.setContent("马马虎虎2");
		detail2.setIndicateValue("1");
		detail2.setNextStemCode("111");
		detail2.setParentOptionId(detail.getQuestionnaireResultOptionId());
		detail2.setLevel(0);
		detail2.setIsChecked(1);
		
		List<TQuestionnaireResultOptionsDetail> detailList2 = new ArrayList<TQuestionnaireResultOptionsDetail>();
		detailList2.add(detail2);
		
		detail.setQuestionOptions(detailList2);
		List<TQuestionnaireResultOptionsDetail> detailList = new ArrayList<TQuestionnaireResultOptionsDetail>();
		detailList.add(detail);
		
		
		stem1.setQuestionOptions(detailList);
		List<TQuestionnaireResultStem> list = new ArrayList<TQuestionnaireResultStem>();
		list.add(stem1);
		logger.info("result=\n"+JsonUtil.beautiful(JsonUtil.toJson(list)));
		MockHttpServletRequestBuilder post = post("/questionnaire/result/wirte").content(JsonUtil.toJson(list)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

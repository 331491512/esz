package com.esuizhen.cloudservice.questionnaire;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.esuizhen.cloudservice.questionnaire.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireOptions;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireStem;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireTitle;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultOptionsDetail;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultStem;
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
//	@Ignore
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
		
		
		
		MockHttpServletRequestBuilder post = post("/add").content(JsonUtil.toJson(detialInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void createPlanTemplate_2() throws Exception
	{
		TFollowupQuestionnaireOptions options = new TFollowupQuestionnaireOptions();
		options.setContent("本人");
		options.setContentType(1);
		options.setOptionIndex(1);
		options.setIsChecked(0);
		TFollowupQuestionnaireOptions options1 = new TFollowupQuestionnaireOptions();
		options1.setContent("配偶");
		options1.setContentType(1);
		options1.setOptionIndex(2);
		options1.setIsChecked(0);
		TFollowupQuestionnaireOptions options2 = new TFollowupQuestionnaireOptions();
		options2.setContent("父母");
		options2.setContentType(1);
		options2.setOptionIndex(3);
		options2.setIsChecked(0);
		List<TFollowupQuestionnaireOptions> optionsList = new ArrayList<TFollowupQuestionnaireOptions>();
		optionsList.add(options);
		optionsList.add(options1);
		optionsList.add(options2);
		TFollowupQuestionnaireStem stem = new TFollowupQuestionnaireStem();
		stem.setContent("受访者与患者关系");
		stem.setSectionTitle("二级回访满意度调查表");
		stem.setQuestionType(1);
		stem.setQuestionOptions(optionsList);
		List<TFollowupQuestionnaireStem> stemList = new ArrayList<TFollowupQuestionnaireStem>();
		stemList.add(stem);
		
		TFollowupQuestionnaireDetailInfo detialInfo = new TFollowupQuestionnaireDetailInfo();
		detialInfo.setAuthor(3);
		detialInfo.setSubject("二级回访工作记录表");
		detialInfo.setDescription("二级回访是指医院回访中心或专人对全部或部分出院患者贺就诊患者进行全方位信息了解、征信、分析、反馈的制度规定");
		detialInfo.setStemList(stemList);
		
		MockHttpServletRequestBuilder post = post("/add").content(JsonUtil.toJson(detialInfo)).contentType(MediaType.APPLICATION_JSON);
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
		MockHttpServletRequestBuilder get = get("/delete?questionnaireId="+questionnaireId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void queryFollowupQuestionnaire() throws Exception 
	{
		//MockHttpServletRequestBuilder get = get("/query").param("questionnaireId", "151211055447162278");
		MockHttpServletRequestBuilder get = get("/query").param("contentTemplateId", "CONT20160903182800795463");
		//MockHttpServletRequestBuilder get = get("/query?patientId=20");
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
		
		
		
		MockHttpServletRequestBuilder post = post("/update").content(JsonUtil.toJson(detialInfo)).contentType(MediaType.APPLICATION_JSON);
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
		MockHttpServletRequestBuilder get = get("/result/list?patientId=10&reqFlag=0&page=0&num=4");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void queryFollowupQuestionnaireResult() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/result/query?followupItemId=20160115093753575363");
//		MockHttpServletRequestBuilder get = get("/result/query?questionnaireResultId=20160115105856931827");
		
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
		MockHttpServletRequestBuilder post = post("/result/wirte").content(JsonUtil.toJson(list)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
//	@Ignore
	public void sendQuestionnaireFollowup() throws Exception
	{
		FollowupMsgSendReq followupMsgSendReq = new FollowupMsgSendReq();
		followupMsgSendReq.setTemplateId("CONT20170811132702201524");
		followupMsgSendReq.setQuestionnaireId("151211055447162278");
		followupMsgSendReq.setTaskId("TASK20170814144820410526");
		followupMsgSendReq.setAssignId("ASSI20170814144820592183");
//		followupMsgSendReq.setPatientId(590352l);
//		followupMsgSendReq.setContent("1111");
		followupMsgSendReq.setHospitalId(19193);
		followupMsgSendReq.setTrueName("kaif");
		followupMsgSendReq.setOperator(9l);
		List<Map<String, Object>> patientInfoList = new ArrayList<Map<String, Object>>();
		followupMsgSendReq.setPatientInfoList(patientInfoList);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientInfoList.add(patientMap);
		patientMap.put("patientId", 590352l);//王荣先
		patientMap.put("trueName", "王荣先");
		
		MockHttpServletRequestBuilder post = post("/do/questionnaire/send").content(JsonUtil.toJson(followupMsgSendReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void scanQuestionnaireReply() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/test/questionnaire/sync/result");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

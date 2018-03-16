package com.esuizhen.cloudservice.followup.controller.followup;

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

import com.esuizhen.cloudservice.followup.bean.FollowupTaskPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskScreenPatientReq;
import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplate;
import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplateDetialInfo;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class FollowupControllerTest 
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
		
		FollowupPlanTemplateDetialInfo detailInfo = new FollowupPlanTemplateDetialInfo();
		detailInfo.setContent("患教知识");
		detailInfo.setActionType(1);
		detailInfo.setIntervalDays(100);
		detailInfo.setIntervalDaysTips("您有新的消息~");
		
		List<FollowupPlanTemplateDetialInfo> detailList = new ArrayList<FollowupPlanTemplateDetialInfo>();
		detailList.add(detailInfo);
		
		FollowupPlanTemplate template = new FollowupPlanTemplate();
		template.setPlanTemplateName("hello");
		template.setAuthor(9);
		template.setIsPublic(1);
		template.setPlanTemplateType(1);
		template.setDetailList(detailList);
		
		
		MockHttpServletRequestBuilder post = post("/plan/template/create").content(JsonUtil.toJson(template)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void updatePlanTemplate() throws Exception
	{
		
		FollowupPlanTemplateDetialInfo detailInfo = new FollowupPlanTemplateDetialInfo();
		detailInfo.setContent("专题随访问卷");
		detailInfo.setActionType(1);
		detailInfo.setIntervalDays(100);
		detailInfo.setIntervalDaysTips("您有新的消息~");
		
		List<FollowupPlanTemplateDetialInfo> detailList = new ArrayList<FollowupPlanTemplateDetialInfo>();
		detailList.add(detailInfo);
		
		FollowupPlanTemplate template = new FollowupPlanTemplate();
		template.setPlanTemplateId("151203055228121023");
		template.setPlanTemplateName("你好");
		template.setAuthor(10);
		template.setIsPublic(null);
		template.setPlanTemplateType(1);
		template.setDetailList(detailList);
		
		
		MockHttpServletRequestBuilder post = post("/plan/template/update").content(JsonUtil.toJson(template)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	@Ignore
	public void deletePlanTemplate() throws Exception 
	{
		String planTemplateId = "151203044319154743";
		MockHttpServletRequestBuilder get = get("/plan/template/delete?planTemplateId="+planTemplateId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryFollowupPlanDetail() throws Exception 
	{
		String planTemplateId = "TEMP20160302154129934885";
		MockHttpServletRequestBuilder get = get("/plan/template/query?planTemplateId="+planTemplateId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void followupPlanTemplatePublicList() throws Exception 
	{
		String doctorId = "10";
		MockHttpServletRequestBuilder get = get("/plan/template/list?doctorId="+doctorId+"&page=0&num=8");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void queryFollowupPlanDetailInfo() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/detail/query?patientId=1823220");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void followupPatientList() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/patient/list?doctorId=1&page=2&num=3&sortFlag=4");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void getFollowupTaskScreenPatientBySearch() throws Exception 
	{
		FollowupTaskScreenPatientReq req = new FollowupTaskScreenPatientReq();
		req.setSearchId(661);
		req.setOperator(20984L);
		req.setNeedContactFlag(1);
		
		MockHttpServletRequestBuilder post = post("/task/screen/patient/search").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void getFollowupTaskPatientListWithOverlap() throws Exception 
	{
		FollowupTaskPatientReq req = new FollowupTaskPatientReq();
		req.setOperator(3l);
		req.setSearchId(120);
//		req.setFollowupCycle(90);
		List<Integer> diseaseTypeIds = new ArrayList<Integer>();
		diseaseTypeIds.add(1);
		diseaseTypeIds.add(2);
		req.setDiseaseTypeIds(diseaseTypeIds);
//		req.setMobile("13934209213");
//		req.setPatientNo("0000718");
		req.setInHospitalTimes(9);
		req.setInHospitalDateStart(DateUtil.stringToDate("2016-01-01", "yyyy-MM-dd"));
		req.setInHospitalDateEnd(DateUtil.stringToDate("2017-01-01", "yyyy-MM-dd"));
		/*req.setInhospitalDeptTimes(9);
		req.setInhospitalDeptId(null);
		req.setOutHospitalTimes(9);
		req.setOutHospitalDateStart(DateUtil.stringToDate("2016-01-01", "yyyy-MM-dd"));
		req.setOutHospitalDateEnd(DateUtil.stringToDate("2016-01-01", "yyyy-MM-dd"));
		req.setOutHospitalDeptTimes(9);
		req.setOutHospitalDept(null);*/
		
		MockHttpServletRequestBuilder post = post("/task/overlap/screen/patient/list").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
}

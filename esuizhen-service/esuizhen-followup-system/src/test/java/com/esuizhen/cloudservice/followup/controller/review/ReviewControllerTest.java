package com.esuizhen.cloudservice.followup.controller.review;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.esuizhen.cloudservice.followup.bean.ReBasiserReviewOrderReq;
import com.esuizhen.cloudservice.followup.bean.ReviewRecordReq;
import com.esuizhen.cloudservice.followup.model.review.FollowupReviewAppoint;
import com.westangel.common.util.JsonUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class ReviewControllerTest 
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
	public void reBasiserReviewOrder() throws Exception
	{
		ReBasiserReviewOrderReq reBasiserReviewOrderReq = new ReBasiserReviewOrderReq();
		reBasiserReviewOrderReq.setApplyTime(new Date());
		reBasiserReviewOrderReq.setAppointDate(new Date());
		reBasiserReviewOrderReq.setAppointDeptId(1);
		reBasiserReviewOrderReq.setAppointDeptName("内科");
		reBasiserReviewOrderReq.setAppointDoctorId(2);
		reBasiserReviewOrderReq.setAppointDoctorName("外科医生");
		reBasiserReviewOrderReq.setAppointTimeRange(1);
		reBasiserReviewOrderReq.setDiagnosis("肺部感染");
		reBasiserReviewOrderReq.setOperatorId(1L);
		reBasiserReviewOrderReq.setOperatorName("开发人员ywm");
		reBasiserReviewOrderReq.setPatientId(6L);
		reBasiserReviewOrderReq.setHospitalId(1);
		reBasiserReviewOrderReq.setFollowupTaskId("11");
		reBasiserReviewOrderReq.setFollowupAssignId("22");
		reBasiserReviewOrderReq.setRemark("备注");
		
		
		MockHttpServletRequestBuilder post = post("/review/order/reBasiser").content(JsonUtil.toJson(reBasiserReviewOrderReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryReviewRecord() throws Exception 
	{
		ReviewRecordReq reviewRecordReq = new ReviewRecordReq();
		reviewRecordReq.setPage(0);
		reviewRecordReq.setNum(10);
		MockHttpServletRequestBuilder post = post("/review/record/query").content(JsonUtil.toJson(reviewRecordReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
//	@Ignore
	public void exportReviewRecord() throws Exception 
	{
		ReviewRecordReq reviewRecordReq = new ReviewRecordReq();
		reviewRecordReq.setNum(10);
		MockHttpServletRequestBuilder post = post("/review/record/export").content(JsonUtil.toJson(reviewRecordReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryReviewOrderSummary() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/review/summary/query?userRole=1&userId=1");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void saveReviewRecordAnswer() throws Exception 
	{
		FollowupReviewAppoint record = new FollowupReviewAppoint();
		record.setAppointId("APP20161010144400502696");
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		Date date=s.parse("2016-11-16");
		record.setAppointDate(date);
		record.setAppointTimeRange(0);
		record.setDoctorReply("早点来，过时不候！");
		MockHttpServletRequestBuilder post = post("/review/answer/save").content(JsonUtil.toJson(record)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

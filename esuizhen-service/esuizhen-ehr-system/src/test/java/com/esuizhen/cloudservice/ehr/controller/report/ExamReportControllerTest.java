package com.esuizhen.cloudservice.ehr.controller.report;

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

import com.esuizhen.cloudservice.ehr.bean.TExamReportListReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReport;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReportDetail;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class ExamReportControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void getExamReportList() throws Exception
	{
		
		TExamReportListReq req=new TExamReportListReq();
		req.setPatientId(663290L);
		System.out.println(JsonUtil.toJson(req));
		MockHttpServletRequestBuilder post = post("/exam/report/list").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void addExamReport() throws Exception
	{
		List<ExamReport> mainList=new ArrayList<ExamReport>();
		List<ExamReportDetail> subList=new ArrayList<ExamReportDetail>();
		ExamReport req=new ExamReport();
		ExamReportDetail erd1=new ExamReportDetail();
		mainList.add(req);
		subList.add(erd1);
		
		req.setPatientId(1955040L);
		req.setPatientNo("0000000753");
		req.setPatientName("王瑞云");
		req.setExamTypeId(2);
		req.setExamTypeId(1);
		req.setExamTypeName("细胞病理学检查");
		req.setExamFinding("肉眼可见");
		req.setExamConclusion("结论是进行治疗");
		req.setApplyDoctorName("张三");
		req.setReportDoctorName("李四");
		req.setReadFlag(0);
		req.setApplyTime(new Date());
		req.setPathologicalSampleType("病理标本类型");
		req.setRawCreateTime(new Date());
		
		erd1.setSeqNo(1);
		erd1.setOrganCode("001");
		erd1.setOrgan("肝");
		erd1.setNidusSourceFlag(1);
		req.setExamReportSubItemDetailInfos(subList);
		
		System.out.println(JsonUtil.toJson(mainList));
		MockHttpServletRequestBuilder post = post("/exam/report/add").content(JsonUtil.toJson(mainList)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


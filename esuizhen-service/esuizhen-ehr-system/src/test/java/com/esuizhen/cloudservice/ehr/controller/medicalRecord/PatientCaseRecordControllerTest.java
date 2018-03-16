package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

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

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.GenenalExaminationInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.PhysicalSigns;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class PatientCaseRecordControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void saveGenenalExamSignsInfo_insert() throws Exception
	{
		GenenalExamSignsInfo genenalExamSigns=new GenenalExamSignsInfo();
		GenenalExaminationInfo genenalExamination=new GenenalExaminationInfo();
		List<PhysicalSigns> physicalSignsList=new ArrayList<PhysicalSigns>();
		genenalExamSigns.setGenenalExamination(genenalExamination);
		genenalExamSigns.setPhysicalSigns(physicalSignsList);
		
		genenalExamination.setPatientId(1954331L);
		genenalExamination.setCheckDate(new Date());
		genenalExamination.setBloodHigh(0.9F);
		genenalExamination.setBodilyId(1);
		genenalExamination.setBodilyName("无力型");
		genenalExamination.setBreath(30);
		
		PhysicalSigns physicalSigns1=new PhysicalSigns();
		physicalSigns1.setPatientId(1954331L);
		physicalSigns1.setPhysicalSignsId(1);
		physicalSigns1.setPhysicalSignsName("皮肤检查");
		physicalSigns1.setSignsStatus(2);
		
		PhysicalSigns physicalSigns2=new PhysicalSigns();
		physicalSigns2.setPatientId(1954331L);
		physicalSigns2.setPhysicalSignsId(2);
		physicalSigns2.setPhysicalSignsName("淋巴结检查");
		physicalSigns2.setSignsStatus(2);
		
		physicalSignsList.add(physicalSigns1);
		physicalSignsList.add(physicalSigns2);
		
		System.out.println(JsonUtil.toJson(genenalExamSigns));
		MockHttpServletRequestBuilder post = post("/patient/genenal/exam/signs/info/save").content(JsonUtil.toJson(genenalExamSigns)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void queryGenenalExamSignsInfo() throws Exception
	{
		
		AttendPatientReq req=new AttendPatientReq();
		req.setPatientId(1954331L);
		MockHttpServletRequestBuilder post = post("/patient/genenal/exam/signs/info/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	
	@Test
	public void saveQualityoflifeInfo_insert() throws Exception
	{
		QualityoflifeInfo info=new QualityoflifeInfo();
		info.setEmrId("EMRI2017012019093963195841742151");//不能为空
		info.setPatientId(1954331L);
		info.setPatientNo("1615154");
		info.setKpsValue(100);
		info.setEcogValue(0);
		info.setRemark("很好");
		info.setVisitTime(new Date());//不能为空
		System.out.println(JsonUtil.toJson(info));
		MockHttpServletRequestBuilder post = post("/patient/qualityoflife/info/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void queryQualityoflifeInfo() throws Exception
	{
		
		AttendPatientReq req=new AttendPatientReq();
		req.setPatientId(1954331L);
		MockHttpServletRequestBuilder post = post("/patient/qualityoflife/info/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void saveAdverseReactionResult_insert() throws Exception
	{
		List<AdverseReactionResultInfo> infoList=new ArrayList<AdverseReactionResultInfo>();
		AdverseReactionResultInfo info1=new AdverseReactionResultInfo();
		AdverseReactionResultInfo info2=new AdverseReactionResultInfo();
		infoList.add(info1);
		infoList.add(info2);
		
		info1.setPatientId(1954331L);
		info1.setAdverseReactionId(1);
		info1.setAdverseReactionName("贫血");
		info1.setPatientId(1954331L);
		info1.setLevel(1);
		
		info2.setPatientId(1954331L);
		info2.setAdverseReactionId(2);
		info2.setAdverseReactionName("骨髓细胞过少");
		info2.setPatientId(1954331L);
		info2.setLevel(1);
		
		System.out.println(JsonUtil.toJson(infoList));
		MockHttpServletRequestBuilder post = post("/patient/adverse/reaction/result/save").content(JsonUtil.toJson(infoList)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	public void queryAdverseReactionResult() throws Exception
	{
		
		AttendPatientReq req=new AttendPatientReq();
		req.setPatientId(1954331L);
		MockHttpServletRequestBuilder post = post("/patient/adverse/reaction/result/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
}


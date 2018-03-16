package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Date;
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

import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalPhotoOcrs;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class EmedicalRecordControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void upload() throws Exception
	{
		EmedicalPhotoOcrs ocr = new EmedicalPhotoOcrs();
		ocr.setOcrApply(1);
		ocr.setOcrFlag(2);
		ocr.setPicFileUrl("http://www.baidu.com");
		
		EmedicalPhotoOcrs ocr2 = new EmedicalPhotoOcrs();
		ocr2.setOcrApply(1);
		ocr2.setOcrFlag(2);
		ocr2.setPicFileUrl("http://www.google.com");
		
		List<EmedicalPhotoOcrs> ocrs = new ArrayList<EmedicalPhotoOcrs>();
		ocrs.add(ocr);
		ocrs.add(ocr2);
		
		EmedicalRecord emedicalRecord = new EmedicalRecord();
		emedicalRecord.setEmrNo("123456");
		emedicalRecord.setPatientId(55L);
		emedicalRecord.setEmrType(1);
		emedicalRecord.setEmrSubType(3);
		emedicalRecord.setSourceFlag(2);
		emedicalRecord.setRemark("备注");
		emedicalRecord.setCreatorId(42L);
		emedicalRecord.setStructFlag(2);
		emedicalRecord.setVisibleFlag(1);
		emedicalRecord.setVisitTime(new Date());
		emedicalRecord.setMedicalPicInfoList(ocrs);
		
		System.out.println(JsonUtil.toJson(emedicalRecord));
		MockHttpServletRequestBuilder post = post("/upload").content(JsonUtil.toJson(emedicalRecord)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Test
	@Ignore
	public void modify() throws Exception
	{
		EmedicalPhotoOcrs ocr = new EmedicalPhotoOcrs();
		ocr.setOcrApply(1);
		ocr.setOcrFlag(2);
		ocr.setPicFileUrl("http://www.youku.com");
		
		List<EmedicalPhotoOcrs> ocrs = new ArrayList<EmedicalPhotoOcrs>();
		ocrs.add(ocr);
		
		EmedicalRecord emedicalRecord = new EmedicalRecord();
		emedicalRecord.setEmrId("151215095508426375");
		emedicalRecord.setEmrNo("123456");
		emedicalRecord.setPatientId(123456L);
		emedicalRecord.setEmrType(1);
		emedicalRecord.setEmrSubType(3);
		emedicalRecord.setSourceFlag(2);
		emedicalRecord.setRemark("修改");
		emedicalRecord.setCreatorId(123L);
		emedicalRecord.setSourceFlag(1);
		emedicalRecord.setStructFlag(2);
		emedicalRecord.setVisibleFlag(3);
		emedicalRecord.setVisitTime(new Date());
		emedicalRecord.setMedicalPicInfoList(ocrs);
		System.out.println(JsonUtil.toJson(emedicalRecord));
		MockHttpServletRequestBuilder post = post("/modify").content(JsonUtil.toJson(emedicalRecord)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	@Ignore
	public void delete() throws Exception 
	{
		String emrId = "151215095331239405";
		MockHttpServletRequestBuilder get = get("/delete?emrId="+emrId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void query() throws Exception 
	{
		String  emrId = "151215095508426375";
		MockHttpServletRequestBuilder get = get("/detail?emrId="+emrId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void medicalRecordBookList() throws Exception 
	{
		String patientId = "7";
		MockHttpServletRequestBuilder get = get("/book/list?userId=13&role=1&page=0&num=10&patientId="+patientId);
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void savePatientMedicalRecord() throws Exception
	{
		EmedicalPhotoOcrs ocr = new EmedicalPhotoOcrs();
		ocr.setOcrApply(1);
		ocr.setOcrFlag(2);
		ocr.setPicFileUrl("http://www.youku.com");
		
		List<EmedicalPhotoOcrs> ocrs = new ArrayList<EmedicalPhotoOcrs>();
		ocrs.add(ocr);
		
		EmedicalRecord emedicalRecord = new EmedicalRecord();
		emedicalRecord.setEmrId("151215095508426375");
		emedicalRecord.setEmrNo("123456");
		emedicalRecord.setPatientId(123456L);
		emedicalRecord.setEmrType(1);
		emedicalRecord.setEmrSubType(3);
		emedicalRecord.setSourceFlag(2);
		emedicalRecord.setRemark("修改");
		emedicalRecord.setCreatorId(123L);
		emedicalRecord.setSourceFlag(1);
		emedicalRecord.setStructFlag(2);
		emedicalRecord.setVisibleFlag(3);
		emedicalRecord.setVisitTime(new Date());
		emedicalRecord.setMedicalPicInfoList(ocrs);
		System.out.println(JsonUtil.toJson(emedicalRecord));
		MockHttpServletRequestBuilder post = post("/modify").content(JsonUtil.toJson(emedicalRecord)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
}


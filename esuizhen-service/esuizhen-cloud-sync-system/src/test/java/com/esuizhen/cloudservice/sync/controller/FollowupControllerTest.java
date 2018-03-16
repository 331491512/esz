package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.esuizhen.cloudservice.sync.bean.TDetectionReportSync;
import com.esuizhen.cloudservice.sync.bean.TExamReportSync;
import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncRecord;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void syncFollowupResultFromCloud_test(){
		MockHttpServletRequestBuilder get = get("/fromcloud/followupresult").
				param("hospitalId", "19193");
		try {
			MvcResult result = mockMvc.perform(get).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void syncResultNotifyToCloud_test() {
		TSyncResultNotify resultNotify = new TSyncResultNotify();
		resultNotify.setResultType(4);
		resultNotify.setHospitalId(19193);
		List<TSyncRecord> uuids = new ArrayList<TSyncRecord>();
		TSyncRecord record1 = new TSyncRecord();
		record1.setId(104716L);
		record1.setQuestionnaireResultId("sssssssssssss");
		uuids.add(record1);
		resultNotify.setUuids(uuids);
		
		MockHttpServletRequestBuilder post = post("/tocloud/result/notify").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(resultNotify));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(resultNotify)));
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

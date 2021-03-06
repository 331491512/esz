package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class OutHospitalNoteControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void outHospitalNoteTest() throws ParseException {
		TOutHospitalNoteInfo outHospitalNote = new TOutHospitalNoteInfo();
		outHospitalNote.setOuthospitalId("3333");
		outHospitalNote.setInhospitalId("3333");
		outHospitalNote.setInhospitalNo("3333");
		
		outHospitalNote.setContentType(1);
		outHospitalNote.setCreateTime(new Date());
		outHospitalNote.setEmrId("3333");
		outHospitalNote.setEmrNo("3333");
		outHospitalNote.setEmrSubType(3333);
		outHospitalNote.setEmrType(3333);
		outHospitalNote.setHospitalId(3333);
		outHospitalNote.setInhospitalDate(new Date());
		outHospitalNote.setInhospitalDays(1);
		outHospitalNote.setInhospitalDiagnosis("3333");
		outHospitalNote.setInhospitalId("3333");
		outHospitalNote.setInhospitalTimes(3333);
		outHospitalNote.setMainID("3333");
		outHospitalNote.setVisitTime(new Date());
		outHospitalNote.setUpdateTime(new Date());
		outHospitalNote.setTreatmentSummary("3333");
		outHospitalNote.setTreatmentResult("3333");
		outHospitalNote.setSyncFlag(3333);
		outHospitalNote.setSymptomSummary("3333");
		outHospitalNote.setSummaryContent("3333");
		outHospitalNote.setRawContent("3333");
		outHospitalNote.setPatientUuid("3333");
		outHospitalNote.setPatientNo("3333");

		
		
		MockHttpServletRequestBuilder post = post("/tocloud/emr/outhospitalnote").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(outHospitalNote));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(outHospitalNote)));
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

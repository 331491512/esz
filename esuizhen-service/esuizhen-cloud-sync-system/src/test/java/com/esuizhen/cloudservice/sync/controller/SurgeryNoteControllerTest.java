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

import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class SurgeryNoteControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void syncDoctorTest() throws ParseException {
		TPatientSurgeryNoteDetailInfo surgeryInfo = new TPatientSurgeryNoteDetailInfo();
		surgeryInfo.setEmrNo("0131101000987698");
		surgeryInfo.setPatientUuid("4ec63ffa1de711e68ef5001f29e2f5b8");
		surgeryInfo.setPatientNo("NO.123");
		surgeryInfo.setSurgeryName("切除右肺叶手术");
		surgeryInfo.setSurgeryDate(new Date());
		surgeryInfo.setAnesthesiaDoctorUuid("doctor18146515613001");
		surgeryInfo.setSurgeryAssistant1Uuid("doctor18146515613001");
		surgeryInfo.setSurgeryAssistant2Uuid("doctor18146515613001");
		surgeryInfo.setAnesthesiaWay("全麻");
		surgeryInfo.setSurgeryDoctorUuid("doctor18146515613001");
		surgeryInfo.setHospitalId(100);
		surgeryInfo.setCurePlan(1111);
		//add by fanpanwei
		surgeryInfo.setSurgeryId("1111"); 
		surgeryInfo.setEmrId("1111");
		surgeryInfo.setDeptUuid("1111");
		surgeryInfo.setBedNo("1111");
		surgeryInfo.setSurgeryBeginTime(new Date());
		surgeryInfo.setSurgeryEndTime(new Date());
		surgeryInfo.setPreOperativeDiagnosis("1111");
		surgeryInfo.setInOperativeDiagnosis("1111");
		surgeryInfo.setBodyPosture("1111");
		surgeryInfo.setTransfusion(1);
		surgeryInfo.setSurgeryNurses("1111");
		surgeryInfo.setOperativeApproach("1111");
		surgeryInfo.setOperativeProbe("1111"); 
		surgeryInfo.setOperativeMeasures("1111");
		surgeryInfo.setOperativeSituation("1111");
		surgeryInfo.setCm3Code("opcode");
		surgeryInfo.setWoundClosureWay("1111");
		surgeryInfo.setIncisionBandagedWay("1111");
		surgeryInfo.setRemark("1111");
		surgeryInfo.setCreateTime(new Date());
		surgeryInfo.setUpdateTime(new Date());
		surgeryInfo.setMainID("1111");
		surgeryInfo.setInhospitalTimes(1111);
		surgeryInfo.setOpLevel(1);
		surgeryInfo.setSurgeryDoctorName("1111");
		surgeryInfo.setSurgeryAssistant1Name("1111");
		surgeryInfo.setSurgeryAssistant2Name("1111");
		surgeryInfo.setAnesthesiaDoctorName("1111");
		surgeryInfo.setIncisionHeal(1);
		surgeryInfo.setIncisionLevel(1);
		surgeryInfo.setTreatmentSchemeId(1111);
		surgeryInfo.setTreatmentSchemeName("1111");
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		Date date=s.parse("2016-10-10");
		surgeryInfo.setRawCreateTime(date);
		
		MockHttpServletRequestBuilder post = post("/tocloud/emr/surgerynote").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(surgeryInfo));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(surgeryInfo)));
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

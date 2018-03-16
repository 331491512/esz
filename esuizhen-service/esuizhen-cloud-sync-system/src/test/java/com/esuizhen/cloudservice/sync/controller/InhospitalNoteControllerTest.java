package com.esuizhen.cloudservice.sync.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
import com.esuizhen.cloudservice.sync.bean.TPatientInHospitalNoteDetailInfo;
import com.westangel.common.util.Codec;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class InhospitalNoteControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	/**
	  { 
			"patientUuid":"asdfweskpko145645454545ga",
			"patientNo":"01254852",
	      	"emrNo":"0131101000987698",//TOB生成的电子病历住院登记编号，唯一标识一次住院
			"inhospitalWay”:1,
			“inhospitalDate”: "2015-10-9 10:02:00”,
			“inhospitalDeptUuid”: "uuid541541515”,
			“inhospitalWard”: "vip 1病室”，
			“inhospitalTimes”:3,
			“medicalPayType”:4，
			“healthCardNo”:"N012544444"，
			“turnDeptUuid”:”uuid”，
			“turnDeptDate”:"2015-09-08 09:06:06"，
			“outhospitalDeptUuid”:”uuid”，
			“outhospitalDate”:"2015-09-08 09:06:06"，
			“outhospitalWard”:3，
			“inhospitalDays”:7，
			“diagnose”:"肿瘤"，
			“diseaseCode”:"c34"，
			“deptDoctorUuid”: “11111asdfasdf”
			“directorDoctorUuid”: “fasfegege15545feefe”，
			“inchargeDoctorUuid”: “fasfegege15545feefe”，
			“inhospitalDoctorUuid”: “fasfegege15545feefe”，
			“attendingDoctorUuid”: “fasfegege15545feefe”，
			“dutyNurseUuid”: “fasfegege15545feefe”，
			“postgraduateDoctorUuid”: vfasfegege15545feefe”，
			“internshipDoctorUuid”: “fasfegege15545feefe”，
			“codePersonUuid”: “fasfegege15545feefe”，
			“medicalRecordsQuality”:1，
			“qualityControlDoctorUuid”:”asdfasdf545454”，
			“qualityControlNurseUuid”:”asdf545454”，
			“qualityControlDate”:15632，
			“mainDiagnosis”:"肺癌"，
			“mainDiagnosisCode”:"c34"，
			“inhospitalCondition”:1，
			“sourceflag”:3，
			“historyCuration”:13，
			“sourceCancerNum”:1， 
			" hospitalId ":15,
		}
	 */
	@Test
	public void syncDoctorTest() {
		TPatientInHospitalNoteDetailInfo inhospitalInfo = new TPatientInHospitalNoteDetailInfo();
		inhospitalInfo.setPatientUuid("patient185012513370002");
		inhospitalInfo.setPatientNo("N01254852");
		inhospitalInfo.setEmrNo("0131101000987698");
		inhospitalInfo.setInhospitalWay(1);
		inhospitalInfo.setInhospitalDate(new Date());
		inhospitalInfo.setInhospitalDeptUuid("a3edab12c8dd11e58f8e74d435ac1e2f");
		inhospitalInfo.setInhospitalWard("NA0012");
		inhospitalInfo.setInhospitalTimes(2);
		inhospitalInfo.setMedicalPayType(1);
		inhospitalInfo.setHealthCardNo("N012544444");
		/*
		inhospitalInfo.setTurnDeptUuid("");
		inhospitalInfo.setTurnDeptDate(new Date());
		*/
		inhospitalInfo.setOuthospitalDeptUuid("a3edab12c8dd11e58f8e74d435ac1e2f");
		inhospitalInfo.setOuthospitalDate(new Date());
		inhospitalInfo.setOuthoispitalWay(1);
		inhospitalInfo.setInhospitalDays(23);
		inhospitalInfo.setDiagnose("外唇恶性肿瘤");
		inhospitalInfo.setDiseaseCode("C00.251");
		inhospitalInfo.setDeptDoctorUuid("doctor18146515613001");
		inhospitalInfo.setDirectorDoctorUuid("doctor18146515613001");
		inhospitalInfo.setInchargeDoctorUuid("doctor18146515613001");
		inhospitalInfo.setInhospitalDoctorUuid("doctor18146515613001");
		inhospitalInfo.setAttendingDoctorUuid("doctor18146515613001");
		inhospitalInfo.setDutyNurseUuid("doctor18146515613001");
		inhospitalInfo.setPostgraduateDoctorUuid("doctor18146515613001");
		inhospitalInfo.setInternshipDoctorUuid("doctor18146515613001");
		inhospitalInfo.setCodePersonUuid("doctor18146515613001");
		inhospitalInfo.setMedicalRecordsQuality(1);
		inhospitalInfo.setQualityControlDoctorUuid("doctor18146515613001");
		inhospitalInfo.setQualityControlNurseUuid("doctor18146515613001");
		inhospitalInfo.setQualityControlDate(new Date());
		inhospitalInfo.setMainDiagnosis("唇部粘膜恶性肿瘤");
		inhospitalInfo.setMainDiagnosisCode("C00.554");
		inhospitalInfo.setInhospitalCondition(1);
		inhospitalInfo.setSourceFlag(3);
		inhospitalInfo.setHistoryCuration(13);
		inhospitalInfo.setSourceCancerNum(1);
		inhospitalInfo.setHospitalId(100);
		
		MockHttpServletRequestBuilder post = post("/tocloud/emr/inhospitalnote").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(inhospitalInfo));
		logger.info("参数：\n" + JsonUtil.beautiful(JsonUtil.toJson(inhospitalInfo)));
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

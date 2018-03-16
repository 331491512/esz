package com.esuizhen.cloudservice.ehr.controller.inhospital;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfoQueryReq;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class PatientClinicInfoControllerTest {
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void queryPatientClinicInfoListTest() throws Exception 
	{
		PatientClinicInfoQueryReq req = new PatientClinicInfoQueryReq();
		req.setPatientId(2l);
		//req.setInhospitalId("EINH20170411100016472557");
		MockHttpServletRequestBuilder post = post("/patient/clinic/info/list/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());
	}
	
	@Test
	public void savePatientClinicInfoTest() throws Exception 
	{
		PatientClinicInfo req = new PatientClinicInfo();
		req.setClinicMedicalId("CLI010001");
		req.setPatientNo("001010001");
		req.setClinicNo("20160922797010");
		req.setVisitTime("2016-09-22 00:00:00");
		req.setDeptName("妇科二病区");
		req.setClinicDoctor(11L);
		req.setMainDiagnosis("食管下段恶性肿瘤");
		req.setEmrId("emrTEST123");
		req.setPatientId(2L);
		req.setHospitalId(19193);
		req.setHealthCardNo("cardh123");
		req.setPatientName("张三");
		req.setPatientIdno("145789854785478521");
		req.setPatientAddress("海淀区创业园");
		req.setPatientMobile("12457854578");
		req.setPatientSex(1);
		req.setPatientBirth(new Date());
		req.setPatientAge(12);
		req.setDeptId(1);
		req.setAttendingDoctorId(11L);
		req.setAttendingDoctorName("李四");
		req.setSymptomSummary("无");
		req.setMainDiseaseCode("M80900/1");
		req.setRemark("");
		req.setVisitTimes(1);
		req.setMedicalPayType(1);
		req.setNationalityId(1);
		req.setNationalityName("中国");
		req.setBabyAge(3);
		req.setBabyBornWeight(6);
		req.setBabyWeightInHospital(6);
		req.setNativePlaceCityCode("110101");
		req.setNativePlaceAddress("北京市东城区");
		req.setOccupationName("务农");
		req.setOccupationId(1);
		req.setMarriageStatus(2);
		req.setLiveZipCode("100000");
		req.setLiveAddress("西城区幸福路3号");
		req.setLiveTel("010-69660000");
		req.setLiveProvinceCode("110000");
		req.setLiveCityCode("110100");
		req.setLiveCountyCode("110101");
		req.setHouseholdProvinceCode("110000");
		req.setHouseholdCityCode("110100");
		req.setHouseholdCountyCode("110101");
		req.setHouseholdZipCode("100000");
		req.setHouseholdAddress("西城区幸福路3号");
		req.setCompanyZipCode("100000");
		req.setCompanyAddress("西城区幸福路3号");
		req.setCompanyProvinceCode("110000");
		req.setCompanyCityCode("110100");
		req.setCompanyCountyCode("110101");
		req.setFamilyTel("13810000000");
		req.setFamilyProvinceCode("110000");
		req.setFamilyCityCode("110100");
		req.setFamilyCountyCode("110101");
		req.setFamilyAddress("幸福路");
		req.setFamilyName("张三");
		req.setPatientRelation(2);
		req.setPathologyDiagnosis("良性肿瘤");
		req.setPathologyDiagnosisCode("800000/0");
		req.setPathologyNo("0");
		req.setTumourPeriodization("I");
		req.setTumourPeriodizationT("T0");
		req.setTumourPeriodizationN("No");
		req.setTumourPeriodizationM1("M0");
		req.setTumourPeriodizationClinic("TNM");
		req.setIsAllergy(0);
		req.setAllergyDesc("无");
		req.setAboBlood(1);
		req.setRhBlood(1);
		req.setRedBloodCell(100);
		req.setPlatelet(100);
		req.setPlasma(100);
		req.setWholeBlood(100);
		req.setOther(0);
		MockHttpServletRequestBuilder post = post("/patient/clinic/info/save").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());
	}
	
	@Test
	public void queryPatientClinicDetailTest() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/patient/clinic/detail/query?clinicMedicalId=ECLI2016110715554710137856797879");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

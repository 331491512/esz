package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

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

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsExerciseInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsFoodInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSleepInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSmokeInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSotInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsInfo;
import com.esuizhen.cloudservice.ehr.bean.TumourFamilyHistoryInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class PresentationMorbidityControllerTest {
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	@Test
	public void queryPresentationMorbidity() throws Exception 
	{
		CommonReq req = new CommonReq();
		req.setPatientId(1954993L);
		req.setInhospitalId("EINH2016101514282546555121480736");
		MockHttpServletRequestBuilder post = post("/patient/presentation/morbidity/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	@Ignore
	@Test
	public void savePresentationMorbidity() throws Exception 
	{
		PresentationMorbidityInfo presentationMorbidity = new PresentationMorbidityInfo();
		presentationMorbidity.setPatientId(1954993l);
		presentationMorbidity.setInhospitalId("EINH2016101514282546555121480736");
		presentationMorbidity.setClinicMedicalId(null);
		//患者症状信息
		List<PatientSymptomInfo> symptomList = new ArrayList<PatientSymptomInfo>();
		PatientSymptomInfo symptom1 = new PatientSymptomInfo();
		symptom1.setEmrId("1");
		symptom1.setOperatorId(5l);
		symptom1.setInhospitalId("EINH2016101514282546555121480736");
		symptom1.setPatientId(1954993L);
		symptom1.setPatientNo("0000216959");
		symptom1.setRemark("单元测试");
		symptom1.setSustainTime("1");
		symptom1.setSustainTimeUnit(1);
		symptom1.setSymptomDegree(1);
		symptom1.setSymptomName("心急");
		symptom1.setSymptomTypeId(1);
		symptom1.setVisitTime(new Date());
		PatientSymptomInfo symptom2 = new PatientSymptomInfo();
		symptom2.setEmrId("1");
		symptom2.setOperatorId(5l);
		symptom2.setInhospitalId("EINH2016101514282546555121480736");
		symptom2.setPatientId(1954993L);
		symptom2.setPatientNo("0000216959");
		symptom2.setRemark("单元测试");
		symptom2.setSustainTime("2");
		symptom2.setSustainTimeUnit(1);
		symptom2.setSymptomDegree(1);
		symptom2.setSymptomName("心急01");
		symptom2.setSymptomTypeId(2);
		symptom2.setVisitTime(new Date());
		symptomList.add(symptom1);
		symptomList.add(symptom2);
		presentationMorbidity.setSymptomList(symptomList);
		
		//肿瘤家族史
		List<TumourFamilyHistoryInfo> familyHistoryList = new ArrayList<TumourFamilyHistoryInfo>();
		TumourFamilyHistoryInfo familyHistory1 = new TumourFamilyHistoryInfo();
		familyHistory1.setDiseaseTypeId("1");
		familyHistory1.setDiseaseTypeName("鼻咽癌wwwwww");
		familyHistory1.setInhospitalId("EINH2016101514282546555121480736");
		familyHistory1.setMorbidityAge(30);
		familyHistory1.setMorbidityTime(new Date());
		familyHistory1.setPatientId(1954993L);
		familyHistory1.setRelationId(1);
		familyHistory1.setRelationName("本人");
		TumourFamilyHistoryInfo familyHistory2 = new TumourFamilyHistoryInfo();
		familyHistory2.setDiseaseTypeId("1");
		familyHistory2.setDiseaseTypeName("鼻咽癌");
		familyHistory2.setInhospitalId("EINH2016101514282546555121480736");
		familyHistory2.setMorbidityAge(30);
		familyHistory2.setMorbidityTime(new Date());
		familyHistory2.setPatientId(1954993L);
		familyHistory2.setRelationId(1);
		familyHistory2.setRelationName("本人qqq");
		familyHistoryList.add(familyHistory1);
		familyHistoryList.add(familyHistory2);
		presentationMorbidity.setFamilyHistoryList(familyHistoryList);
		
		//危险因素
		RiskfactorsInfo Riskfactors = new RiskfactorsInfo();
		Riskfactors.setInhospitalId("EINH2016101514282546555121480736");
		Riskfactors.setPatientId(1954993L);
		Riskfactors.setRiskfactorsTypeId("1,2,3,4,5");
		Riskfactors.setRiskfactorsTypeName("吸烟,嗜酒,饮食,锻炼,睡眠");
		//吸烟
		RiskfactorsSmokeInfo smokeInfo = new RiskfactorsSmokeInfo();
		smokeInfo.setSmokeInfoId("RISK20170405185716203159");
		smokeInfo.setAbstainYear(1);
		smokeInfo.setDailyCount(1);
		smokeInfo.setFirstAge(2);
		smokeInfo.setPassivitySmoke(1);
		smokeInfo.setSustainYear(4);
		Riskfactors.setSmokeInfo(smokeInfo);
		//嗜酒
		RiskfactorsSotInfo sotInfo = new RiskfactorsSotInfo();
		sotInfo.setSotInfoId("RSOT20170405185716204636");
		sotInfo.setAbstainYear(1);
		sotInfo.setDailyMil(1);
		sotInfo.setDrinkTypeId("1,2");
		sotInfo.setFirstAge(1);
		sotInfo.setMonthCount(2);
		sotInfo.setSustainYear(1);
		sotInfo.setWeekCount(2);
		sotInfo.setYearCount(1);
		Riskfactors.setSotInfo(sotInfo);
		//饮食
		RiskfactorsFoodInfo foodInfo = new RiskfactorsFoodInfo();
		foodInfo.setFoodInfoId("RISK20170405185716807094");
		foodInfo.setFoodDes("1,2");
		Riskfactors.setFoodInfo(foodInfo);
		//锻炼
		RiskfactorsExerciseInfo exerciseInfo = new RiskfactorsExerciseInfo();
		exerciseInfo.setExerciseInfoId("EXER20170405185716711176");
		exerciseInfo.setEveryTimeMinute(30);
		exerciseInfo.setExerciseWay("1,2");
		exerciseInfo.setSustainYear(1);
		exerciseInfo.setWeekCount(3);
		Riskfactors.setExerciseInfo(exerciseInfo);
		//睡眠
		RiskfactorsSleepInfo sleepInfo = new RiskfactorsSleepInfo();
		sleepInfo.setSleepInfoId("SLEE20170405185716781442");
		sleepInfo.setSleepDes(2);
		Riskfactors.setSleepInfo(sleepInfo);
		presentationMorbidity.setRiskfactors(Riskfactors);
		MockHttpServletRequestBuilder post = post("/patient/presentation/morbidity/save").content(JsonUtil.toJson(presentationMorbidity)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

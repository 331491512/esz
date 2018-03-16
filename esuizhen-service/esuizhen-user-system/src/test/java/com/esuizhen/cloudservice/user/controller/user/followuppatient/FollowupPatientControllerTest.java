package com.esuizhen.cloudservice.user.controller.user.followuppatient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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

import com.esuizhen.cloudservice.user.bean.followuppatient.PatientConfirmedDateReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.PatientSeniorScreenReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.esuizhen.cloudservice.user.model.followuppatient.FollowupPatientProfile;
import com.westangel.common.bean.search.RetrievalConditionReq;
import com.westangel.common.bean.search.RetrievalParamentReq;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FollowupPatientControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void aqueryPatient() throws Exception {
		TPatientSearchInfo  patientSearchInfo = new TPatientSearchInfo();
		patientSearchInfo.setPatientNo("0000005");
		patientSearchInfo.setUserId(3l);
		patientSearchInfo.setSourceFlag(1);
		patientSearchInfo.setOperator(3l);
		patientSearchInfo.setTreatmentPlaceState("2");
//		patientSearchInfo.setBatchPatientNo("1010000001,1010000006");
//		patientSearchInfo.setPatientNo("177849");
		/*patientSearchInfo.setTrueName("袁文明");
		patientSearchInfo.setMobile("15120038940");
		patientSearchInfo.setSourceDiagnosis("恶性");
		patientSearchInfo.setSourceDiseaseCode("C001");
		patientSearchInfo.setSourceDiseaseTypeId(1);
		patientSearchInfo.setSourcePathologyDiagnosis("恶性");
		patientSearchInfo.setSourcePathologyDiseaseCode("C002");
		patientSearchInfo.setConfirmedDateStart(new Date());
		patientSearchInfo.setConfirmedDateEnd(new Date());
		patientSearchInfo.setFollowupResultValue(1);*/
		//patientSearchInfo.setOuthospitalTimes(1);
//		patientSearchInfo.setOuthospitalDateStart(DateUtil.stringToDate("2013-08-01","yyyy-MM-dd"));
//		patientSearchInfo.setOuthospitalDateEnd(new Date());
		/*patientSearchInfo.setMissingType(99);
		patientSearchInfo.setInvalidType(99);*/
//		patientSearchInfo.setFaultType(99);
		/*patientSearchInfo.setFollowupFlag(2);
		patientSearchInfo.setLostFollowupCauseResultValue(1);*/
		
		
		
		if(patientSearchInfo.getFollowupFlag() != null && patientSearchInfo.getFollowupFlag()==2) {
			MockHttpServletRequestBuilder post = post("/patient/list").content(JsonUtil.toJson(patientSearchInfo)).contentType(MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(( post))
					  .andExpect(status().isOk())
					  .andDo(print())
					  .andReturn();
			logger.info("\nlost########################result=\n"+result.getResponse().getContentAsString());
		}else if(patientSearchInfo.getFaultType() !=null && patientSearchInfo.getFaultType() ==99) {
			MockHttpServletRequestBuilder post = post("/patient/list").content(JsonUtil.toJson(patientSearchInfo)).contentType(MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(( post))
					  .andExpect(status().isOk())
					  .andDo(print())
					  .andReturn();
			logger.info("\nfault########################result=\n"+result.getResponse().getContentAsString());
		}else {
			MockHttpServletRequestBuilder post = post("/patient/list").content(JsonUtil.toJson(patientSearchInfo)).contentType(MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(( post))
					  .andExpect(status().isOk())
					  .andDo(print())
					  .andReturn();
			logger.info("all########################result=\n"+result.getResponse().getContentAsString());
		}
	}

	@Test
	@Ignore
	public void bgetSearchPatientSimpleInfo() throws Exception {
		TwiceSearchReq twiceSearchReq = new TwiceSearchReq();
		twiceSearchReq.setConditionId(1);
		twiceSearchReq.setNum(10);
		twiceSearchReq.setPage(0);
		twiceSearchReq.setSearchId(3262);
		MockHttpServletRequestBuilder post = post("/patient/simple/list/search").content(JsonUtil.toJson(twiceSearchReq)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("\n########################result=\n"+result.getResponse().getContentAsString());
	}

	@Test
	public void cqueryPatientDetail() throws Exception {
		MockHttpServletRequestBuilder get = get("/patient/detail/query?patientId=590352");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("\n#################result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	@Ignore
	public void dupdatePatient() throws Exception {
		FollowupPatientProfile  patientProfile = new FollowupPatientProfile();
		patientProfile.setPatientId(1l);
		patientProfile.setAuditRemark("测试修改患者基本信息");
		patientProfile.setBirthDate(new Date());
		patientProfile.setBirthPlaceAddress("北京市海淀区");
		patientProfile.setBirthPlaceCode("110000");
		patientProfile.setCauseOfDeath("1");
		patientProfile.setCountry("中国");
		patientProfile.setNationalityId(1);
		patientProfile.setDeathDate(new Date());
		patientProfile.setIdentification("52222519847771001X");
		patientProfile.setLatestClinicDate(new Date());
		patientProfile.setLiveStatus(0);
		patientProfile.setMarriageStatus(1);
		patientProfile.setMobile("15120068940");
		patientProfile.setNationId(20);
		patientProfile.setNation("汉族");
		patientProfile.setNativePlace("北京市海淀区");
		patientProfile.setTrueName("后端测试");
		patientProfile.setProfession("工人");
		patientProfile.setOccupationId(1);
		patientProfile.setSex(1);
		patientProfile.setUserId(180l);
		List<PatientFamily> list = new ArrayList<PatientFamily>();
		PatientFamily pf = new PatientFamily();
		pf.setPatientRelation(1);
		pf.setAddress("北京市海淀区");
		pf.setFamilyName("张5丰");
		pf.setFamilyPhone("15120068940");
		pf.setIsDefault(0);
		pf.setIsValid(1);
		pf.setPatientId(1l);
		pf.setZipcode("100071");
		pf.setRemark("测试测试");
		list.add(pf);
		
		PatientFamily pf1 = new PatientFamily();
		pf1.setId(289285l);
		pf1.setPatientRelation(2);
		pf1.setAddress("北京市海淀区");
		pf1.setFamilyName("母亲8");
		pf1.setFamilyPhone("14457877777");
		pf1.setIsDefault(0);
		pf1.setIsValid(1);
		pf1.setPatientId(1l);
		pf1.setZipcode("100071");
		pf1.setRemark("测试测试");
		list.add(pf1);
		patientProfile.setPatientFamilyList(list);
		MockHttpServletRequestBuilder post = post("/patient/detail/update").content(JsonUtil.toJson(patientProfile)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("\n########################result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
	@Ignore
	public void emodifyUserContactPhoneStatus() throws Exception {
		PatientFamily patientFamily = new PatientFamily();
		
		// 情况一：状态无效、错号的情况
		patientFamily.setId(3786425l);
		patientFamily.setIsValid(0);
		patientFamily.setPhoneStatus(9);

		// 情况二：状态有效、拒绝接听的情况
		// patientFamily.setId(3786425l);
		// patientFamily.setPhoneStatus(11);
		
		// 以上两种情况需要分开测试，测试的患者是“袁志国”
		
		MockHttpServletRequestBuilder post = post("/contact/phone/status/modify").content(JsonUtil.toJson(patientFamily)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("\n########################result=\n"+result.getResponse().getContentAsString());
	}
	
	@Test
//	@Ignore
	public void fqueryPatientCallBackInfo() throws Exception {
		MockHttpServletRequestBuilder get = get("/patient/callback/info/list?phone=13513653338");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("\n#################result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryPatientSeniorScreen() throws Exception {
		PatientSeniorScreenReq req = new PatientSeniorScreenReq();
		req.setLatestOperator(1L);
		req.setOperator(2L);
		req.setUserRole(12);
		req.setCatalogState(3);
		req.setCatalogWithUpdate(1);
		List<RetrievalParamentReq> paraments = new ArrayList<RetrievalParamentReq>();
		req.setParaments(paraments);
		RetrievalParamentReq parament = new RetrievalParamentReq();
		parament.setParament("user_db");
		parament.setChildParaments("u_patient.patientNo");
		parament.setParamentType("1");
		paraments.add(parament);
		List<RetrievalConditionReq> conditions = new ArrayList<RetrievalConditionReq>();
		parament.setConditions(conditions);
		RetrievalConditionReq condition = new RetrievalConditionReq();
		conditions.add(condition);
		condition.setConditionId(1);
		List<String> values = new ArrayList<String>();
		condition.setValues(values);
		values.add("0000012947");
		
		
		MockHttpServletRequestBuilder post = post("/patient/senior/screen/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		logger.info("\n########################result=\n"+result.getResponse().getContentAsString());
	}
	
	
	@Test
//	@Ignore
	public void queryPatientInfoList() throws Exception {

		/**
		 * 注意！注意！注意！测试时需要将"/patient/info/list/query"方法里面的“HttpServletRequest
		 * request,”部分去掉，否则不走该方法，直接报错。
		 */

		String jsonStr="{\"searchId\":11637,\"page\":0,\"num\":10,\"clickType\":1,\"userRole\":12,\"operator\":3}";
		MockHttpServletRequestBuilder post = post("/patient/info/list/query").content(jsonStr).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
		
		logger.info("\n########################result=\n" + result.getResponse().getContentAsString());
	}
	
	@Test
//	@Ignore
	public void patientConfirmedDateModify() throws Exception {
		PatientConfirmedDateReq req = new PatientConfirmedDateReq();
		// req.setPatientId(854128l);
		// req.setConfirmedDate(new Date());
		// req.setConfirmedDateSource("2");
		// req.setOperatorId(3l);
		//
		// req.setUpdateDate(new Date());
		// req.setOperatorName("郝乐乐");
		// req.setOldConfirmedDate(new Date());
		// req.setConfirmedDate(new Date());
		// req.setConfirmedDateSource("2");

		req.setPatientId(592295l);
		req.setOperatorId(3l);
		req.setOldConfirmedDate(new Date());
		req.setConfirmedDate(new Date());
		req.setConfirmedDateModCount(1);
		req.setUpdateDate(new Date());

		MockHttpServletRequestBuilder post = post("/patient/confirmed/date/update").content(JsonUtil.toJson(req)).contentType(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("\n########################result=\n" + result.getResponse().getContentAsString());
	}

}

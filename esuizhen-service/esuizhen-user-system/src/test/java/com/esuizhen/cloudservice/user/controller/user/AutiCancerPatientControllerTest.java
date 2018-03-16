/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller.user<br/>  
 * <b>文件名：</b>PatientControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月14日-上午10:33:27<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.SimpleDateFormat;
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

import com.esuizhen.cloudservice.user.bean.AutiCancerLinkManContact;
import com.esuizhen.cloudservice.user.bean.AutiCancerPatientInfo;
import com.esuizhen.cloudservice.user.bean.AutiCancerTreatmentsInfo;
import com.esuizhen.cloudservice.user.bean.AutiPatientApproveInfo;
import com.esuizhen.cloudservice.user.bean.AutiPatientReq;
import com.esuizhen.cloudservice.user.bean.GeneticDiseaseContact;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseReq;
import com.westangel.common.util.JsonUtil;

/**
 * 
 * @author fanpanwei
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class AutiCancerPatientControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	
	@Test
	public void queryAutiCancerPatientList()throws Exception
	{
		AutiPatientReq autiPatientReq = new AutiPatientReq();
		autiPatientReq.setPatientName("lilimn");
		System.out.println(JsonUtil.toJson(autiPatientReq));
		
		MockHttpServletRequestBuilder post = post("/auticancer/patient/query").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(autiPatientReq));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	
	@Test
	public void exportAutiCancerPatientList()throws Exception
	{
		AutiPatientReq autiPatientReq = new AutiPatientReq();
		autiPatientReq.setPatientName("李新患者");
		System.out.println(JsonUtil.toJson(autiPatientReq));
		
		MockHttpServletRequestBuilder post = post("/auticancer/patient/export").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(autiPatientReq));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void queryAutiPatientTotal()throws Exception
	{
		AutiPatientReq autiPatientReq = null;
		
		System.out.println(JsonUtil.toJson(autiPatientReq));
		
		MockHttpServletRequestBuilder post = post("/auticancer/patienttotal/query").contentType(MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void queryAntiCancerPatientInfo()throws Exception
	{
		Integer patientId = 1;
		System.out.println(JsonUtil.toJson(patientId));
		
		MockHttpServletRequestBuilder post = get("/auticancer/patientinfo/query?patientId=1");
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void saveAntiCancerPatientInfo()throws Exception
	{
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		Date date=s.parse("2016-10-10");
		List<AutiCancerLinkManContact> contactsList = new ArrayList<AutiCancerLinkManContact>();
		AutiCancerLinkManContact contact = new AutiCancerLinkManContact();
		contact.setLinkAddress("阿斯顿");
		contact.setFamilyName("阿斯顿");
		contact.setFamilyPhone("1233545445");
		contact.setRelationId(1);
		contact.setZipcode("110000");
		contactsList.add(contact);
		List<GeneticDiseaseContact> geneticDiseaseList = new ArrayList<GeneticDiseaseContact>();
		GeneticDiseaseContact gene = new GeneticDiseaseContact();
		gene.setDeathDate(date);
		gene.setFamilyName("阿斯顿");
		gene.setDiseaseTypeId(1);
		gene.setLiveStatus(1);
		gene.setOtherGeneDisease("阿斯顿");
		gene.setRelationId(0);
		geneticDiseaseList.add(gene);
		
		AutiCancerPatientInfo patientInfo = new AutiCancerPatientInfo();
		patientInfo.setAddress("123");
		
		patientInfo.setSex(1);
		patientInfo.setBirthDate(date);
		patientInfo.setBirthPlaceAddress("aaa");
		patientInfo.setComZipCode("100000");
		patientInfo.setCompanyAddress("上海浦东新区");
		patientInfo.setCompanyTel("010-665321");
		patientInfo.setFamZipcode("4603218");
		patientInfo.setFamilyTel("0556-4027618");
		patientInfo.setIdNo("340822199101031210");
		patientInfo.setCountry("中国");
		patientInfo.setMarriageStatus(2);
		patientInfo.setMedicalCareAreaId(25335);
		patientInfo.setMedicalCareCardNo("665540");
		patientInfo.setMedicalCarePlace("BJ");
		//patientInfo.setMedicalCareType();
		patientInfo.setMobile("15120030980");
		patientInfo.setNationId(4);
		patientInfo.setNationalityId(1);
		patientInfo.setOccupationId(1);
		
		
		patientInfo.setNation("布依族");
		patientInfo.setContactsList(contactsList);
		patientInfo.setGeneticDiseaseList(geneticDiseaseList);
		/*patientInfo.setContactsList(contactsList);
		patientInfo.setDelContactsList(delContactsList);
		patientInfo.setDelGeneDiseaseList(delGeneDiseaseList);
		patientInfo.setGeneticDiseaseList(geneticDiseaseList);*/
		
		//patientInfo.setPatientId(1);
		patientInfo.setPatientId(1l);
		patientInfo.setPatientName("李新患者");
		patientInfo.setPatientNo("560660");
		patientInfo.setSex(1);
		//patientInfo.setUserId(userId);
		

		System.out.println(JsonUtil.toJson(patientInfo));
		
		MockHttpServletRequestBuilder post = post("/auticancer/patientinfo/save").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(patientInfo));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test  //查询审批信息
	public void queryAutiPatientApproveInfo()throws Exception
	{
		Integer patientId = 2113955;
		System.out.println(JsonUtil.toJson(patientId));
		
		MockHttpServletRequestBuilder post = get("/auticancer/approveinfo/query?patientId=2113955").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(patientId));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	@Test
	public void saveAntiCancerPatientApproveInfo()throws Exception
	{
		
		AutiPatientApproveInfo autiPatientApproveInfo = new AutiPatientApproveInfo();
		//autiPatientApproveInfo.setApprovalId("1");
		autiPatientApproveInfo.setPatientId(2113955);
		autiPatientApproveInfo.setAdviceId(1);
		//autiPatientApproveInfo.setHandleDate(handleDate);
		autiPatientApproveInfo.setdiagnosisDescId(1);
		autiPatientApproveInfo.setSpecialistName("审批新专家");
		autiPatientApproveInfo.setSpecialFollowupRecord("特病随访记录");
		autiPatientApproveInfo.setSpecializedFollowupRecord("专科随访记录");
		autiPatientApproveInfo.setRemark("安心治疗，等待疗效");
		
		System.out.println(JsonUtil.toJson(autiPatientApproveInfo));
		
		MockHttpServletRequestBuilder post = post("/auticancer/approveinfo/save").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(autiPatientApproveInfo));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test  //查询特殊病记录
	public void querySpecialDiseaseRecord()throws Exception
	{
		
		SpecialDiseaseReq specialDiseaseReq = new SpecialDiseaseReq();
		/*Date beginDate = new Date(2016, 10, 6);
		specialDiseaseReq.setBeginDate(beginDate);
		Date endDate = new Date(2016, 10, 8);
		specialDiseaseReq.setEndDate(endDate);*/
		//specialDiseaseReq.setPatientName("李新患者");
		
		System.out.println(JsonUtil.toJson(specialDiseaseReq));
		
		MockHttpServletRequestBuilder post = post("/auticancer/specialdisease/query").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(specialDiseaseReq));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test  //导出特殊病记录
	public void exportSpecialDiseaseRecord()throws Exception
	{
		
		SpecialDiseaseReq specialDiseaseReq = new SpecialDiseaseReq();
		/*Date beginDate = new Date(2016, 10, 6);
		specialDiseaseReq.setBeginDate(beginDate);
		Date endDate = new Date(2016, 10, 8);
		specialDiseaseReq.setEndDate(endDate);*/
		//specialDiseaseReq.setPatientName("李新患者");
		
		System.out.println(JsonUtil.toJson(specialDiseaseReq));
		
		MockHttpServletRequestBuilder post = post("/auticancer/specialdisease/export").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(specialDiseaseReq));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test  //获取特病诊治及建议元数据元
	public void queryTreatmentMethodsTest()throws Exception
	{
		
		AutiCancerTreatmentsInfo treatmentsInfo = new AutiCancerTreatmentsInfo();
		treatmentsInfo.setSdtId(5);
		//treatmentsInfo.setSdtName(sdtName);
		
		System.out.println(JsonUtil.toJson(treatmentsInfo));
		
		MockHttpServletRequestBuilder post = post("/auticancer/treatment/query").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(treatmentsInfo));
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
}

package com.esuizhen.cloudservice.user.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.HospitalSearchReq;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class HospitalControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void searchHospitalTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/hospital/search?cityCode=100&hospitalName=北");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void getHospitalDetailTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/hospital/detail?hospitalId=100");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void addHospital() throws Exception {
		HospitalProfile hopitalModifyReq = new HospitalProfile();
		hopitalModifyReq.setHospitalName("北京大学肿瘤医院");
		hopitalModifyReq.setGradeId(2);
		hopitalModifyReq.setSpecialClinics("乳腺癌预防治疗中心,乳腺肿瘤内科,胃肠肿瘤外科,肾癌黑色素瘤内科,胃肠肿瘤微创外科,结直肠肿瘤外科,淋巴肿瘤内科");
		hopitalModifyReq.setAddress("北京海淀区阜成路52号（定慧寺）");
		hopitalModifyReq.setBusLines("414、运通102等定慧寺东站下车，或乘公交89路定慧寺南站下车。");
		hopitalModifyReq.setCityId(10);
		hopitalModifyReq.setTel("123458888");
		hopitalModifyReq.setIntroduction("");
		
		System.out.println(JsonUtil.toJson(hopitalModifyReq));
		
		MockHttpServletRequestBuilder post = post("/hospital/add").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(hopitalModifyReq));
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
	public void modifyHospitalTest() {
		HospitalProfile hopitalModifyReq = new HospitalProfile();
		hopitalModifyReq.setHospitalId(100);
		hopitalModifyReq.setHospitalName("北京大学肿瘤医院");
		hopitalModifyReq.setGradeId(2);
		hopitalModifyReq.setSpecialClinics("乳腺癌预防治疗中心,乳腺肿瘤内科,胃肠肿瘤外科,肾癌黑色素瘤内科,胃肠肿瘤微创外科,结直肠肿瘤外科,淋巴肿瘤内科");
		hopitalModifyReq.setAddress("北京海淀区阜成路52号（定慧寺）");
		hopitalModifyReq.setBusLines("414、运通102等定慧寺东站下车，或乘公交89路定慧寺南站下车。");
		hopitalModifyReq.setCityId(10);
		hopitalModifyReq.setTel("123458888");
		hopitalModifyReq.setIntroduction("");
		System.out.println(JsonUtil.toJson(hopitalModifyReq));
		MockHttpServletRequestBuilder post = post("/hospital/modify").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(hopitalModifyReq));
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
	public void listDepartmentTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/department/list?hospitalId=100");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void searchHospitalTimeFlagTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/metainfo/hospital/list?timeFlag=2015-12-23&reqFlag=0");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void getHospitalsOfPatientListTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/hospital/ofpatient/list?patientId=1954336");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void getHospitalListInfo_test() {
		HospitalSearchReq hospitalSearchReq = new HospitalSearchReq();
		//hospitalSearchReq.setHospitalName("中");
		//hospitalSearchReq.setReqFlag(1);
		hospitalSearchReq.setHospitalId(0);
		
		MockHttpServletRequestBuilder post = post("/hospital/search/list").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(hospitalSearchReq));
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

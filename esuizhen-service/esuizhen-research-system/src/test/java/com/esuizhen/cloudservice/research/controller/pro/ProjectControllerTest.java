package com.esuizhen.cloudservice.research.controller.pro;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Date;

import org.apache.http.impl.cookie.DateUtils;
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

import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;
import com.esuizhen.cloudservice.research.service.result.PatientManageService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class ProjectControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void createProject_test() throws Exception {
		String[] partten = {"yyyy-MM-dd HH:mm:ss"};
		TProjectSimpleInfo projectSimpleInfo = new TProjectSimpleInfo();
		projectSimpleInfo.setProjectName("2016胃癌科研专题");
		projectSimpleInfo.setDescription("临床科研，胃癌专题研究，新药测试，新疗法。");
		projectSimpleInfo.setProjectDirector(9L);
		projectSimpleInfo.setProjectBeginTime(DateUtils.parseDate("2016-04-15 09:00:00", partten));
		projectSimpleInfo.setProjectEndTime(DateUtils.parseDate("2020-10-01 00:00:00", partten));
		projectSimpleInfo.setMainDiseaseTypeId(20);
		
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(projectSimpleInfo)));
		MockHttpServletRequestBuilder post = post("/create").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(projectSimpleInfo));
		try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void removeProject_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/remove").
				param("projectId", "PROJ20161028201132687157");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void projectModify_test() throws Exception {
		String[] partten = {"yyyy-MM-dd HH:mm:ss"};
		TProjectSimpleInfo projectSimpleInfo = new TProjectSimpleInfo();
		projectSimpleInfo.setProjectId("PROJ20160406110725515086");
		projectSimpleInfo.setProjectName("2016肺癌科研专题");
		projectSimpleInfo.setDescription("临床科研，肺癌专题研究，新药测试，新疗法。");
		projectSimpleInfo.setProjectDirector(20995L);
		projectSimpleInfo.setProjectBeginTime(DateUtils.parseDate("2016-04-15 09:00:00", partten));
		projectSimpleInfo.setProjectEndTime(DateUtils.parseDate("2020-10-01 00:00:00", partten));
		projectSimpleInfo.setMainDiseaseTypeId(20);
		projectSimpleInfo.setIsProjectTemplateSet(1);
		
		MockHttpServletRequestBuilder post = post("/project/modfy").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.toJson(projectSimpleInfo));
		logger.info("result=\n" + JsonUtil.beautiful(JsonUtil.toJson(projectSimpleInfo)));
		try {
			MvcResult result = mockMvc.perform((post)).andReturn();
			String jsonStr = result.getResponse().getContentAsString();
			logger.info("result=\n" + JsonUtil.beautiful(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void listProject_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/list?doctorId=20983&attributeFlag=3");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void queryProjectCount_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/count/query?doctorId=209951&projectId=PROJ20160406110725515086");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void queryProjectDetail_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/detail/query?doctorId=9&projectId=PROJ20161019111442297083");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Autowired
	private ProjectDao projectDao;
	@Test
	public void setIsProjectTemplateSet_test() throws Exception {
		this.projectDao.setIsProjectTemplateSet("PROJ20160412202728273142", 1);
	}
	
}

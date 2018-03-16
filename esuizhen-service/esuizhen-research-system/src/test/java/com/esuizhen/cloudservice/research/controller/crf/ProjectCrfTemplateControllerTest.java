package com.esuizhen.cloudservice.research.controller.crf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.research.bean.TProjectTemplateDetailInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class ProjectCrfTemplateControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void createProjectTemplate_test() throws Exception {
		TProjectTemplateDetailInfo projectTemplateDeatilInfo = new TProjectTemplateDetailInfo();
		projectTemplateDeatilInfo.setCrfTemplateName("2016-喉癌科研专题模板");
		projectTemplateDeatilInfo.setCrfTemplateType(1);
		projectTemplateDeatilInfo.setDescription("2016年，测试阶段，开发用测试科研专题模板，随意修改。");
		projectTemplateDeatilInfo.setAuthor(2044L);
		
		logger.info("Send=\n" + JsonUtil.toJson(projectTemplateDeatilInfo));
		MockHttpServletRequestBuilder post = post("/template/create")
				.content(JsonUtil.toJson(projectTemplateDeatilInfo)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void listProjectPublicTempaltes_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/public/template/list");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void projectTemplatePublish_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/template/publish?crfTemplateId=PTEM20160406144740626392");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void projectTempalatePreview_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/template/preview?crfTemplateId=PTEM24522662965456052");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void projectTemplateCopy_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/template/copy?projectId=PROJ20160413113805279806&crfTemplateId=PTEM24502281969860964&doctorId=9");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
}

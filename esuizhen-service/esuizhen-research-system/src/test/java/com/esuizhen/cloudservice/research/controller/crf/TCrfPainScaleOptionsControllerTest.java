package com.esuizhen.cloudservice.research.controller.crf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.util.ArrayList;
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

import com.esuizhen.cloudservice.research.model.crf.TCrfPainScaleOptions;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptom;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomInfo;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.WordTxtUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class TCrfPainScaleOptionsControllerTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void saveCrfPainScaleInfo_test() throws Exception {
		TCrfPainScaleOptions crfPainScaleOptions = new TCrfPainScaleOptions();
		crfPainScaleOptions.setCollectionFlag(1);
		crfPainScaleOptions.setCrfPainScaleId("CRPS24628345098644950");
		crfPainScaleOptions.setCrfObserveId("OBSE24628345098644690");

		MockHttpServletRequestBuilder post = post("/crf/pain/scale/save").content(JsonUtil.toJson(crfPainScaleOptions))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void queryCrfPainScaleInfo_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/crf/pain/scale/query?crfObserveId=20160405205139955516");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

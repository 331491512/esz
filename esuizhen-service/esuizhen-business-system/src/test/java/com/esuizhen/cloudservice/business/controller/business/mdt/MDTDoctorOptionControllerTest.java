package com.esuizhen.cloudservice.business.controller.business.mdt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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

import com.esuizhen.cloudservice.business.bean.MdtDoctorOptionInfo;
import com.esuizhen.cloudservice.business.bean.MdtReq;
import com.esuizhen.cloudservice.business.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class MDTDoctorOptionControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void submitMdtDoctorOption() {
		
		MdtDoctorOptionInfo req = new MdtDoctorOptionInfo();
		req.setDoctorName("内科");
		req.setDoctorUserId(2036772L);
		req.setFlag(1);//暂存标识
		req.setMdtFlowStateId(4);
		//req.setSpecimenIntactFlag(1);
		req.setGroupType(2);
		req.setNeedRadiateFlag(0);
		req.setRadiateUserId(null);
		req.setOpinion("11");
		req.setId(40L);
		req.setProductApplyId("APPL20161008140758665188");
		//req.setRadiateUserId(6L);
		//MdtDoctorOptionInfo req = new MdtDoctorOptionInfo();
		req.setDoctorName("病理");
		req.setDoctorUserId(2036770L);
		req.setFlag(1);//暂存标识
		req.setMdtFlowStateId(2);
		req.setSpecimenIntactFlag(1);
		req.setGroupType(1);
		//req.setNeedRadiateFlag(1);
		//req.setOpinion("建议化疗");
		//req.setId(1L);
		req.setProductApplyId("APPL20161008144651178134");
		
		
		MockHttpServletRequestBuilder post = post("/service/mdt/option/submit").content(JsonUtil.toJson(req))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

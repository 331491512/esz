package com.esuizhen.cloudservice.business.controller.business.mdt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.esuizhen.cloudservice.business.bean.MdtReq;
import com.esuizhen.cloudservice.business.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class MdtProductControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void findSMdtAppleByUserId() {//&flag=1&mdtRole=&mdtFlowStateId=1
		MockHttpServletRequestBuilder get = get("/untreated/mdt/apple/get?userId=3329");
		try {
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void getMdtStatis() {//&flag=1&mdtRole=&mdtFlowStateId=1
		MockHttpServletRequestBuilder get = get("/service/mdt/statis?flag=0&userId=2036455&mdtRole=2&mdtFlowStateId=5");
		try {
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void queryMdtList() {
		MdtReq req = new MdtReq();
//		req.setDoctorName("张山");
//		req.setRecommendedDoctorMobile("15120038940");
//		req.setStartDate("2016-04-01");
//		req.setEndDate("2016-09-01");
//		req.setFlag(null);
		req.setMdtFlowStateId(2);
		req.setUserId(2184260L);
		req.setMdtRole(0);
//		req.setMdtApplyNo("sss");
//		req.setMobile("sss");
//		req.setSampleNo("sss");
//		req.setTrueName("sss");
//		req.setDoctorName("牛鼻子");
//		req.setRecommendedDoctorMobile("15120038940");
//		req.setStartDate("2016-04-01");
//		req.setEndDate("2016-09-01");
//		req.setFlag(1);
//		req.setMdtFlowStateId(2);
//		req.setUserId(2036769l);
		req.setNum(10);
		req.setPage(0);
		
		MockHttpServletRequestBuilder post = post("/service/mdt/list").content(JsonUtil.toJson(req))
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

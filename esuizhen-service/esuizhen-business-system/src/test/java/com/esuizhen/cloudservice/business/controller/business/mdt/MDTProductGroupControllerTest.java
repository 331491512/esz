package com.esuizhen.cloudservice.business.controller.business.mdt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;

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

import com.esuizhen.cloudservice.business.bean.TDoctorAnnouncement;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicInfo;
import com.esuizhen.cloudservice.business.bean.TProductApply;
import com.esuizhen.cloudservice.business.model.business.DoctorClinicSchedule;
import com.esuizhen.cloudservice.business.util.JsonUtil;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class MDTProductGroupControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void getMDTExpertGroupDetail_test() throws Exception {
		toGet("/mdt/expert/group/detail?productId=PROD20160926172459857528");
	}
	
	@Test
	public void getMDTDoctorInProductGroupList_test() throws Exception {
		toGet("/mdt/doctor/in/product/group/list?productId=PROD20160929193919262599&doctorType=3");
	}
	
	@Test
	public void getMDTProductList_test() throws Exception {
		toGet("/mdt/product/list");
	}

	private void toGet(String url) {
		MockHttpServletRequestBuilder get = get(url);
		try {
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

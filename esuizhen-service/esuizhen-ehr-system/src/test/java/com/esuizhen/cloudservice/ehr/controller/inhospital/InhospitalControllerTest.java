package com.esuizhen.cloudservice.ehr.controller.inhospital;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.esuizhen.cloudservice.ehr.model.inhospital.InhospitalTurnRecord;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class InhospitalControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	/**
	 * 转科情况添加功能
	 */
	@Test
	public void addInhospitalTurnRecord() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		InhospitalTurnRecord req = new InhospitalTurnRecord();
		req.setPatientId("4");
		req.setInhospitalId("19393");
		req.setInDeptCode("1");
		req.setInDeptName("转入科室");
		req.setOutDeptCode("2");
		req.setOutDeptName("转出科室");
		req.setTurnDate(sdf.parse("2017-10-10"));
		
		InhospitalTurnRecord req1 = new InhospitalTurnRecord();
		req1.setPatientId("5");
		req1.setInhospitalId("19393");
		req1.setInDeptCode("3");
		req1.setInDeptName("转入科室1");
		req1.setOutDeptCode("4");
		req1.setOutDeptName("转出科室1");
		req1.setTurnDate(sdf.parse("2017-10-11"));
		
		List<InhospitalTurnRecord> list = new ArrayList<InhospitalTurnRecord>();
		list.add(req);
		list.add(req1);

		System.out.println(JsonUtil.toJson(list));

		MockHttpServletRequestBuilder post = post("/inhospital/turn/record/add").content(JsonUtil.toJson(list)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());
	}

	/**
	 * 转科情况删除功能
	 */
	@Test
	public void delInhospitalTurnRecord() throws Exception {

		InhospitalTurnRecord req = new InhospitalTurnRecord();
		req.setTurnId(25);
		
		InhospitalTurnRecord req1 = new InhospitalTurnRecord();
		req1.setTurnId(26);

		List<InhospitalTurnRecord> ls = new ArrayList<InhospitalTurnRecord>();
		ls.add(req);
		ls.add(req1);
		
		System.out.println(JsonUtil.toJson(ls));

		MockHttpServletRequestBuilder post = post("/inhospital/turn/record/del").content(JsonUtil.toJson(ls)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());
	}

	/**
	 * 转科情况查询功能
	 */
	@Test
	public void queryInhospitalTurnRecord() throws Exception {

		InhospitalTurnRecord req = new InhospitalTurnRecord();
		req.setPatientId("2");
		req.setInhospitalId("19393");

		System.out.println(JsonUtil.toJson(req));

		MockHttpServletRequestBuilder post = post("/inhospital/turn/record/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + result.getResponse().getContentAsString());
	}
}

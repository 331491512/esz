package com.esuizhen.cloudservice.research.controller.crf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.research.model.crf.TCrfExams;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamsDetail;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamsItemInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfExamDetailControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	@Ignore
	public void saveCrfExamItemDetail() throws Exception
	{
		
		TCrfExamsItemInfo crfExamsItemInfo = new TCrfExamsItemInfo();
		crfExamsItemInfo.setExamItemId(1);
		
		TCrfExamsItemInfo crfExamsItemInfo2 = new TCrfExamsItemInfo();
		crfExamsItemInfo2.setExamItemId(2);
		
		List<TCrfExamsItemInfo> dataList = new ArrayList<TCrfExamsItemInfo>();
//		dataList.add(crfExamsItemInfo);
//		dataList.add(crfExamsItemInfo2);
		
		TCrfExamsDetail crfExamsDetail = new TCrfExamsDetail();
		crfExamsDetail.setExamTypeId(3);
		crfExamsDetail.setSubjectElementId("S1");
		
		crfExamsDetail.setExamItemList(dataList);
		
		List<TCrfExamsDetail> detailList = new ArrayList<TCrfExamsDetail>();
		detailList.add(crfExamsDetail);
		
		TCrfExams crfExams = new TCrfExams();
		crfExams.setCrfObserveId("OBSE20160419200828404561");
		crfExams.setDataList(detailList);
		
		MockHttpServletRequestBuilder post = post("/crf/exam/item/detail/save").content(JsonUtil.toJson(crfExams)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryCrfExamItemDetail() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/exam/item/detail/query?crfObserveId=20160405205139923564");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


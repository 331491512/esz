
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

import com.esuizhen.cloudservice.research.model.crf.TCrfDetection;
import com.esuizhen.cloudservice.research.model.crf.TCrfDetectionDetail;
import com.esuizhen.cloudservice.research.model.crf.TCrfDetectionItemInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TCrfDetectionControllerTest{

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
	public void saveCrfDetectionItemDetail() throws Exception
	{
		TCrfDetectionItemInfo crfDetectionItemInfo = new TCrfDetectionItemInfo();
		crfDetectionItemInfo.setDetectionItemId(1);
		
		List<TCrfDetectionItemInfo> crfDetectionItemInfoList= new ArrayList<TCrfDetectionItemInfo>();
		crfDetectionItemInfoList.add(crfDetectionItemInfo);
		
		TCrfDetectionDetail detail1 = new TCrfDetectionDetail();
		detail1.setSubjectElementId("T61");
		detail1.setDetectionTypeId(100000000);
		detail1.setDetectionItemList(crfDetectionItemInfoList);
		
		TCrfDetectionDetail detail2 = new TCrfDetectionDetail();
		detail2.setSubjectElementId("T61");
		detail2.setDetectionTypeId(200000000);
		detail2.setDetectionItemList(crfDetectionItemInfoList);
		
		List<TCrfDetectionDetail> detailList = new ArrayList<TCrfDetectionDetail>();
		detailList.add(detail1);
		detailList.add(detail2);
		
		TCrfDetection crfDetection = new TCrfDetection();
		crfDetection.setCrfObserveId("OBSE24502281969860975");
		crfDetection.setDataList(detailList);
		
		MockHttpServletRequestBuilder post = post("/crf/detection/item/detail/save").content(JsonUtil.toJson(crfDetection)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryCrfDetectionItemDetail() throws Exception 
	{
		MockHttpServletRequestBuilder get = get("/crf/detection/item/detail/query?crfObserveId=OBSE24449161613017202");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}


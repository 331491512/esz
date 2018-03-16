/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.controller.conf<br/>  
 * <b>文件名：</b>FollowupContentTemplateInfoControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午5:24:21<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.controller.conf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.followup.bean.TFollowupConfigDiseaseType;
import com.esuizhen.cloudservice.followup.bean.TFollowupRangeIcdCodeText;
import com.westangel.common.util.JsonUtil;

/**
 * 
 * @author raox
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupRangeControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void getFollowupConfigDiseaseTypeList() throws Exception { 
		MockHttpServletRequestBuilder get=get("/config/diseaseType/list");
		MvcResult result = mockMvc.perform(( get))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void saveFollowupConfigDiseaseType() throws Exception { 
		List<TFollowupConfigDiseaseType> testList=new ArrayList<TFollowupConfigDiseaseType>();
		TFollowupConfigDiseaseType info=new TFollowupConfigDiseaseType();
		info.setDiseaseTypeId(1);
		info.setDiseaseTypeName("鼻咽癌");
		info.setDiseaseBodyPartId(1);
		info.setDiseaseBodyPartName("头颈肿瘤");
		testList.add(info);
		
		TFollowupConfigDiseaseType info2=new TFollowupConfigDiseaseType();
		info2.setDiseaseTypeId(2);
		info2.setDiseaseTypeName("口腔癌");
		info2.setDiseaseBodyPartId(1);
		info2.setDiseaseBodyPartName("头颈肿瘤");
		testList.add(info2);
		
		logger.info(JsonUtil.toJson(testList));
		MockHttpServletRequestBuilder post=post("/config/diseaseType/save").content(JsonUtil.toJson(testList)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void getFollowupConfigIcdCodeList() throws Exception { 
		MockHttpServletRequestBuilder get=get("/config/icd/code/list");
		MvcResult result = mockMvc.perform(( get))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void saveFollowupConfigIcdCode() throws Exception { 
		List<TFollowupRangeIcdCodeText> testList=new ArrayList<TFollowupRangeIcdCodeText>();
		
		TFollowupRangeIcdCodeText info=new TFollowupRangeIcdCodeText();
		info.setDiseaseCodeStart("C00");
		info.setType(0);
		
		TFollowupRangeIcdCodeText info1=new TFollowupRangeIcdCodeText();
		info1.setDiseaseCodeStart("C00");
		info1.setDiseaseCodeEnd("C20");
		info1.setType(1);
		
		TFollowupRangeIcdCodeText info2=new TFollowupRangeIcdCodeText();
		info2.setDiseaseCodeStart("C00.001");
		info2.setDiseaseCodeEnd("C20");
		info2.setType(1);
		
		TFollowupRangeIcdCodeText info3=new TFollowupRangeIcdCodeText();
		info3.setDiseaseCodeStart("C00.001");
		info3.setType(0);
		
		testList.add(info);
		testList.add(info1);
		testList.add(info2);
		testList.add(info3);
		
		logger.info(JsonUtil.toJson(testList));
		MockHttpServletRequestBuilder post=post("/config/icd/code/save").content(JsonUtil.toJson(testList)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

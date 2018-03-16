/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.controller.conf<br/>  
 * <b>文件名：</b>FollowupGlobalConfigInfoControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午7:52:22<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.controller.conf;

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

import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.westangel.common.util.JsonUtil;

/** 
* @ClassName: FollowupGlobalConfigInfoControllerTest
* @Description: 
* @author NiDan
* @date 2016年8月11日下午7:52:22 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupGlobalConfigInfoControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void setFollowupGlobalConfig() throws Exception{
		TFollowupGlobalConfigInfo info=new TFollowupGlobalConfigInfo();
		info.setAutoPatientNoPaddingDigits(1);
		info.setAutoPatientNoPaddingFlag(10);
		info.setCancerFilterFlag(1);
		info.setPhoneResultMustConnectFlag(0);
		info.setHospitalName("易随诊肿瘤医院");
		info.setIsOutsideCallAuth(null);
		info.setOutsideCallNum(null);
		info.setIsIpCall(null);
		info.setIpCallNum(null);
		info.setAutoGuessDiedFlag(1);
		info.setExportSensitiveDataFlag(1);
		MockHttpServletRequestBuilder post=post("/config/global/set").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	
	@Test
	@Ignore
	public void queryFollowupContentTemplateDetail() throws Exception { 
		MockHttpServletRequestBuilder get=get("/config/global/get");
		MvcResult result = mockMvc.perform(( get))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	

}

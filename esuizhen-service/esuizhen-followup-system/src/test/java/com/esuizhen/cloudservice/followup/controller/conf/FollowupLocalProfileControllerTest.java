/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.controller.conf<br/>  
 * <b>文件名：</b>FollowupLocalProfileControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午8:01:14<br/>  
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

import com.esuizhen.cloudservice.followup.model.conf.TFollowupLocalProfile;
import com.westangel.common.util.JsonUtil;

/** 
* @ClassName: FollowupLocalProfileControllerTest
* @Description: 
* @author NiDan
* @date 2016年8月11日下午8:01:14 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupLocalProfileControllerTest {
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
	public void setFollowupLocalProfile() throws Exception{
		TFollowupLocalProfile info=new TFollowupLocalProfile();
		info.setDeviceCode("1234567890");
		info.setIsOutsideCallAuth(1);
		info.setIsIpCall(1);
		info.setLocalPhoneNumber("10086");
		info.setVoiceBoxFlag(2);
		info.setUserId(3l);
		MockHttpServletRequestBuilder post=post("/config/local/profile/set").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void getFollowupLocalProfile() throws Exception { 
		MockHttpServletRequestBuilder get=get("/config/local/profile/get").param("userId", "1");
		MvcResult result = mockMvc.perform(( get))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

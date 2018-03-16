/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.controller.conf<br/>  
 * <b>文件名：</b>FollowupReplyParseRulesInfoControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午8:16:41<br/>  
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

import com.esuizhen.cloudservice.followup.bean.FollowupReplyParseRulesInfoReq;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupReplyParseRulesInfo;
import com.westangel.common.util.JsonUtil;

/** 
* @ClassName: FollowupReplyParseRulesInfoControllerTest
* @Description: 
* @author NiDan
* @date 2016年8月11日下午8:16:41 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupReplyParseRulesInfoControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void saveFollowupReplyParseRules() throws Exception{
		TFollowupReplyParseRulesInfo info=null;
		List<TFollowupReplyParseRulesInfo> list=new ArrayList<TFollowupReplyParseRulesInfo>();
		for (int i = 0; i < 5; i++) {
			info=new TFollowupReplyParseRulesInfo();
			info.setFollowupResultValueId(1+i);
			info.setFollowupResultValueName("稳定"+i);
			info.setReplyContent("好"+i);
			list.add(info);
		}
		
		FollowupReplyParseRulesInfoReq req=new FollowupReplyParseRulesInfoReq();
		req.setRules(list);
		MockHttpServletRequestBuilder post=post("/config/reply/parse/rules/save").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void queryFollowupReplyParseRules() throws Exception { 
		MockHttpServletRequestBuilder get=get("/config/reply/parse/rules/query");
		MvcResult result = mockMvc.perform(( get))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

}

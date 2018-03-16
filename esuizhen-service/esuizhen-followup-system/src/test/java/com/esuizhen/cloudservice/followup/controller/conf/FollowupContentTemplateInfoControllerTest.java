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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Date;

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

import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateQueryReq;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;
import com.westangel.common.util.JsonUtil;

/** 
* @ClassName: FollowupContentTemplateInfoControllerTest
* @Description: 
* @author NiDan
* @date 2016年8月11日下午5:24:21 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupContentTemplateInfoControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void createFollowupContentTemplateInfo() throws Exception { 
		TFollowupContentTemplateInfo info=new TFollowupContentTemplateInfo();
		info.setContentTemplateName("问卷随访模板");
		info.setContentTemplateType(6);
		info.setContent("问卷随访模板测试");
		info.setNeedReply(0);
		info.setIsPublish(1);
		info.setSignature("测试。。");
		info.setAutoReplyContent("ok。ok。");
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		logger.info(JsonUtil.toJson(info));
		MockHttpServletRequestBuilder post=post("/config/content/template/create").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	
	@Test
	public void createFollowupContentTemplateInfoSms() throws Exception { 
		TFollowupContentTemplateInfo info=new TFollowupContentTemplateInfo();
		info.setContentTemplateName("测试001");
		info.setContentTemplateType(1);
		info.setContent("亲爱的患者朋友，医生十分关心您出院后的康复情况，望您能够配合反馈病情：稳定回复1；复发回复2；转移回复3；其他情况回复4。您的反馈将有助于医生为您制定后续治疗方案，谢谢配合！");
		info.setNeedReply(0);
		info.setIsPublish(0);
		info.setSignature("张三");
		info.setAutoReplyContent("我们已收到了您的反馈，感谢配合，祝您早日康复！");
		logger.info(JsonUtil.toJson(info));
		MockHttpServletRequestBuilder post=post("/config/content/template/create").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	@Ignore
	public void modifyFollowupContentTemplateInfo() throws Exception { 
		TFollowupContentTemplateInfo info=new TFollowupContentTemplateInfo();
		info.setContentTemplateId("CONT20160811192914126478");
		info.setContentTemplateName("电话随访模板");
		info.setContentTemplateType(1);
		info.setContent("电话随访内容添加ok了？");
		info.setNeedReply(0);
		info.setIsPublish(1);
		info.setSignature("测试");
		info.setAutoReplyContent("ok了。");
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		logger.info(JsonUtil.toJson(info));
		MockHttpServletRequestBuilder post=post("/config/content/template/modify").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	

	@Test
	@Ignore
	public void queryFollowupContentTemplateDetail() throws Exception { 
		MockHttpServletRequestBuilder get=get("/config/content/template/detail/get").param("contentTemplateId", "CONT20160811192914126478");
		MvcResult result = mockMvc.perform(( get))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	

	@Test
	public void queryFollowupContentTemplate() throws Exception { 
		FollowupContentTemplateQueryReq info=new FollowupContentTemplateQueryReq();
		info.setContentTemplateName("微信随访模板");
		//info.setContentTemplateType(1);
		//info.setNeedReply(0);
		//info.setPage(0);
		//info.setNum(2);
		MockHttpServletRequestBuilder post=post("/config/content/template/query").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void deleteFollowupContentTemplate() throws Exception {
		TFollowupContentTemplateInfo info=new TFollowupContentTemplateInfo();
		info.setContentTemplateId("CONT20160823105253306894");
		MockHttpServletRequestBuilder post=post("/config/content/template/delete").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
				  .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();

       logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

}

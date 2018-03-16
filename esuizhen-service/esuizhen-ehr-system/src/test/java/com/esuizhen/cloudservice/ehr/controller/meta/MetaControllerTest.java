/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.controller.meta<br/>  
 * <b>文件名：</b>MetaControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日下午4:44:49<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.controller.meta;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
/** 
* @ClassName: MetaControllerTest
* @Description: 
* @author NiDan
* @date 2016年8月15日下午4:44:49 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/webapp")
@ContextConfiguration({"classpath:spring/application.xml"})
public class MetaControllerTest {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc=webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void getMetaInfoIcdOList() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/icdo/list");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("getMetaInfoIcdOList() done.");
	}
	
	@Test
	public void getMetaInfoDiagnosisTypeList() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/diagnosis/type/list");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("getMetaInfoDiagnosisTypeList() done.");
	}
	
	@Test
	public void queryDiagnosisBasis() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/diagnosisBasis/query");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("queryDiagnosisBasis() done.");
	}
	
	@Test
	public void getMetaInfoAnesthesiaWayList() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/anesthesia/way/list");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("getMetaInfoAnesthesiaWayList() done.");
	}
	
	// add by zhuguo
	@Test
	public void queryOperationNature() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/operation/nature/query");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("queryOperationNature() done.");
	}
	
	// add by zhuguo
	@Test
	public void queryNNISOperationIncisionClean() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/nnis/operation/incision/clean/query");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("queryNNISOperationIncisionClean() done.");
	}
	
	// add by zhuguo
	@Test
	public void queryNNISAnaesthesiaLevel() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/nnis/anaesthesia/level/query");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("queryNNISAnaesthesiaLevel() done.");
	}
	
	// add by zhuguo
	@Test
	public void queryNNISOperationLevel() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/nnis/operation/level/query");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("queryNNISOperationLevel() done.");
	}
	
	// add by zhuguo
	@Test
	public void queryNNISOperationContinuedTime() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/nnis/operation/continued/time/query");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("queryNNISOperationContinuedTime() done.");
	}
	
	// add by zhuguo
	@Test
	public void queryNNISIncisionInfected() throws Exception{
		MockHttpServletRequestBuilder get=get("/metainfo/nnis/incision/infected/query");
		MvcResult result=mockMvc.perform(get).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
		LogUtil.log.debug("queryNNISIncisionInfected() done.");
	}
	
}

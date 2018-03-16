/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.util;<br/>  
 * <b>文件名：</b>SysControllerTest.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日下午2:02:38<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.controller;

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

import com.westangel.common.util.JsonUtil;
import com.westangel.commonservice.sys.bean.TActivitySignup;
import com.westangel.commonservice.sys.bean.TFeedBack;


/** 底层接口测试类
* @ClassName: SysControllerTest
* @Description: 
* @author lichenghao
* @date 2015年12月17日 下午2:02:38  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class SysControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	/**
	 * 用户反馈
	 * @author lichenghao
	 * @title :setFeedback
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 下午2:21:31
	 */
	@Test
	@Ignore
	public void setFeedback()throws Exception{
		TFeedBack feedback = new TFeedBack();
		feedback.setUserId(1l);
		feedback.setUserRole(1);
		feedback.setBusinessId(1);
		feedback.setProductId("123");
		feedback.setDescription("界面不好看，需要优化");
		feedback.setAppVersion("test-v1.0");
		toPost("/system/feedback", feedback);
	}
	
	/**
	 * 获取版本
	 * @author lichenghao
	 * @title :getVersion
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 下午2:21:54
	 */
	@Test
	@Ignore
	public void getVersion()throws Exception{
		//服务号 businessId
		//产品号 productId
		//版本号 version
		//内部版本号 versionCode
		//获取类型 deviceType 3.android 4 ios  
		toGet("/system/checkversion?businessId=1&productId=10&version=3.3.5&versionCode=1&deviceType=3");
	}
	
	/**
	 * 获取banner
	 * @author lichenghao
	 * @title :getSystemBannerList
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 下午5:52:59
	 */
	@Test
	public void getSystemBannerList()throws Exception{
		//请求标志 reqFlag 1.app  2.web
		//用户编号 userId
		//角色 1.患者 2.医生
		toGet("/system/banner/list?reqFlag=1&userId=1&role=1");
	}
	
	/**
	 *获取活动预告 
	 * @author lichenghao
	 * @title :getActityQuery
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 下午5:53:30
	 */
	@Test
	@Ignore
	public void getActityHistory()throws Exception{
		//城市编码  cityCode
		toGet("/system/activity/query?cityCode=010");
	}
	
	/**
	 * 获取往期活动
	 * @author lichenghao
	 * @title :getActityQuery
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 下午5:55:23
	 */
	@Test
	@Ignore
	public void getActityQuery()throws Exception{
		//城市编码  cityCode
		//页码 page
		//条数 num
		toGet("/system/activity/history/list?cityCode=010&page=0&num=10");
	}
	
	/**
	 * 活动报名
	 * @author lichenghao
	 * @title :signupActivity
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 下午5:56:26
	 */
	@Test
	@Ignore
	public void signupActivity()throws Exception{
		TActivitySignup signup = new TActivitySignup();
		//活动编号
		signup.setActivityId("1");
		//报名手机
		signup.setMobile("13999847369");
		toGet("/system/activity/history/list?cityCode=010&page=0&num=10");
	}
	
	public void toPost(String url, Object object) {
		MockHttpServletRequestBuilder post = post(url).content(JsonUtil.toJson(object))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toGet(String url) {
		MockHttpServletRequestBuilder get = get(url);
		try {
			MvcResult result = mockMvc.perform((get)).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

///**
// * 
// */
//package com.westangel.commonservice.trade.service.test;
//
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//
//import javax.annotation.Resource;
//
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.westangel.commonservice.trade.service.pay.PayService;
//
///**
// * @author zhiyinglong
// * @date  2016年2月1日 下午5:34:28
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration(value = "/WebContent")
//@ContextConfiguration({ "classpath:spring/application.xml" })
//public class PayServiceTest {
//	
//	@Autowired
//	private WebApplicationContext wac;
//	
//	@Resource(name="payServiceImpl")
//	PayService payService;
//
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setup() {
//		this.mockMvc = webAppContextSetup(this.wac).build();
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void refund() throws Exception {
//		String orderId= "ORDE20160201165240840875";
//		payService.refund(orderId);
//	}
//
//}

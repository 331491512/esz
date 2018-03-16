package com.esuizhen.cloudservice.business.controller.business;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;

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

import com.esuizhen.cloudservice.business.bean.TDoctorAnnouncement;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicInfo;
import com.esuizhen.cloudservice.business.bean.TProductApply;
import com.esuizhen.cloudservice.business.model.business.DoctorClinicSchedule;
import com.esuizhen.cloudservice.business.notify.sender.ProductApplyNotifySender;
import com.esuizhen.cloudservice.business.util.JsonUtil;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class BusinessControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :getDoctorAnnouncement
	 * @Description:获取医生当前公告
	 * @return void
	 * @date 2015年12月14日 下午12:55:21
	 */
	@Test
	@Ignore
	public void getDoctorAnnouncement() throws Exception {
		String doctorId = "1";
		toGet("/business/doctor/announcement/current?doctorId=" + doctorId);
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :getDoctorAnnouncementList
	 * @Description:获取医生公告历史
	 * @return void
	 * @date 2015年12月14日 下午1:34:08
	 */
	@Test
	@Ignore
	public void getDoctorAnnouncementList() throws Exception {
		String doctorId = "1";
		toGet("/business/doctor/announcement/history/list?doctorId=" + doctorId);
	}

	/**
	 * 医生发布公告
	 * 
	 * @author lichenghao
	 * @title :createDoctorAnnouncement
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月14日 下午2:33:30
	 */
	@Test
	@Ignore
	public void createDoctorAnnouncement() throws Exception {
		// 模拟公告
		TDoctorAnnouncement doctorAnnouncement = new TDoctorAnnouncement();
		doctorAnnouncement.setDoctorId(1L);
		doctorAnnouncement.setAnnouncementContent("这是公告内容");
		doctorAnnouncement.setPublishType(2); // 发布类型 1,首页 2 患者

		toPost("/business/doctor/announcement/publish", doctorAnnouncement);
	}

	/**
	 * 医生删除公告
	 * 
	 * @author lichenghao
	 * @title :deleteDoctorAnnouncement
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月14日 下午2:33:43
	 */
	@Test
	@Ignore
	public void deleteDoctorAnnouncement() throws Exception {

		TDoctorAnnouncement doctorAnnouncement = new TDoctorAnnouncement();
		doctorAnnouncement.setDoctorId(1L);
		doctorAnnouncement.setAnnouncements(new Integer[] { 1, 2, 3 });

		toPost("/business/doctor/announcement/delete", doctorAnnouncement);
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :getDoctorAnnouncementList
	 * @Description:获取医生公告历史
	 * @return void
	 * @date 2015年12月14日 下午1:34:08
	 */
	@Test
	@Ignore
	public void getDoctorClinicSchedule() throws Exception {
		String doctorId = "100";
		toGet("/business/doctor/clinic/schedule/get?doctorId=" + doctorId);
	}

	/**
	 * 医生出诊时间设置
	 * 
	 * @author lichenghao
	 * @title :setDoctorClinicSchedules
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月14日 下午6:05:33
	 */
	@Test
	@Ignore
	public void setDoctorClinicSchedules() throws Exception {
		TDoctorClinicInfo tds = new TDoctorClinicInfo();
//		tds.setDoctorId(100L);
//		tds.setClinicScheduleList(new ArrayList<DoctorClinicSchedule>());
		// for(int i = 1;i<8;i++){
		// if(i%2==0){
		// DoctorClinicSchedule dcs = new DoctorClinicSchedule();
		// dcs.setClinicDay(i);
		// tds.getClinicScheduleList().add(dcs);
		// }
		// }
		toPost("/business/doctor/clinic/schedule/set", tds);
	}
	
	/**
	 * 服务申请
	 * @author lichenghao
	 * @title :applyProduct
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月16日 下午4:02:29
	 */
	@Test
	@Ignore
	public void applyProduct() throws Exception {
		TProductApply productApply = new TProductApply();
		TOrderPublishInfo orderInfo = new TOrderPublishInfo();
		orderInfo.setBuyer((long) 15);
		orderInfo.setVendor((long) 13);
		orderInfo.setProductId("PROD150618125004348205");
		orderInfo.setRealPrice(5.0f);
		orderInfo.setAmount(1);
		orderInfo.setRemark("申请开通图文咨询，患者已完成支付");
		orderInfo.setOrderTitle("申请图文咨询");
		productApply.setOrderInfo(orderInfo);
		TOrderPayInfo payInfo = new TOrderPayInfo();
		payInfo.setState(1);
		payInfo.setPoints(50);
		payInfo.setPointsPayValue(0f);
		payInfo.setBalancePayValue(0);
		payInfo.setOnlinePayValue(100);
		payInfo.setOnlinePayWay(2);
		payInfo.setOnlinePayAccount("wx2342343434");
		payInfo.setOnlinePayNo("88934340");
		productApply.setPayInfo(payInfo);
		// 服务产品类型
		productApply.setProductType(1);
		toPost("/business/product/apply", productApply);
	}
	
	/**
	 * 医生图文咨询总结
	 * @author lichenghao
	 * @title :summarizeRichtextChatConsulting
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月16日 下午5:39:27
	 */
	@Test
	@Ignore
	public void summarizeRichtextChatConsulting()throws Exception{
		TProductApply productApply = new TProductApply();
		productApply.setProductApplyId("APPL151216025208298066");
		productApply.setSummarization("好像写错了");
		toPost("/business/service/richtextchat/consult/summarize", productApply);
	}
	
	/**
	 * 患者对医生的评价
	 * @author lichenghao
	 * @title :evaluateProduct
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月16日 下午5:39:40
	 */
	@Test
	public void evaluateProduct()throws Exception{
		TProductApply productApply = new TProductApply();
		productApply.setProductApplyId("APPL151216025208298066");
		productApply.setServiceLevel(1);
		productApply.setEvaluationRemark("非常专业");
		toPost("/business/product/service/evaluate", productApply);
	}
	
	@Test
	public void testProductDetailInvoke(){
		toGet("/service/mdt/detail?buyer=" + 66+"&orderId=ORDE20160107191903886435");
//		toGet("/service/mdt/detail?id="+250l);
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

	@Autowired
	private ProductApplyNotifySender  notifySender;
	
	@Test
	public void sendReportToPathologyDoctor_test(){
		//给基层病理医生推送做病理消息
		this.notifySender.sendReportToPathologyDoctor(null,"APPL20161008181844366784");
	}
}

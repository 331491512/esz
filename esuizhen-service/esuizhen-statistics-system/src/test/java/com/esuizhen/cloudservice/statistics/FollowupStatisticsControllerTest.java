package com.esuizhen.cloudservice.statistics;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;
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

import com.esuizhen.cloudservice.statistics.bean.FollowupPatientStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupPatientStatusStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.StatsExportReq;
import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupStatisticsControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void test() throws Exception {
		MockHttpServletRequestBuilder get = get("/test");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void statisticsLostFollowPatient_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/follow/lost?allFlag=0&doctorId=668");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void statisticsFollowupResult_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/followup/result/statistics").
				param("followupTaskId", "TASK20160909092648619912").
				param("followupAssignId", "ASSI20160909092648639821");
		
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void statisticsFollowupWayProgress_test() throws Exception {
		MockHttpServletRequestBuilder get = get("/followup/way/statistics").
				param("followupTaskId", "TASK20160907180050116573").
				param("followupAssignId", "").
				param("userId", "1161572");
		
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void statisticsFollowupProgress_test() throws Exception {
		//MockHttpServletRequestBuilder get = get("/followup/progress/statistics?userId=1161782");
		MockHttpServletRequestBuilder get = get("/followup/progress/statistics?followupTaskId=20&followupAssignId=");
		
//		MockHttpServletRequestBuilder get = get("/followup/progress/statistics").
//				param("followupTaskId", "TASK20160903104230949209").
//				param("followupAssignId", "ASSI20160903104230802448");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	public void statisticsFollowupWorkload_test() {
		TCommonParam commonParam = new TCommonParam();

		// 按人员统计
		commonParam.setStatisticsMethods(1);
		commonParam.setUserId(3L);

		// 按任务统计
		// commonParam.setStatisticsMethods(2);
		// commonParam.setUserId(3L);

		// 按病种统计
		// commonParam.setStatisticsMethods(4);
		// commonParam.setUserId(3L);

		// 按方式统计
		// commonParam.setStatisticsMethods(7);
		// commonParam.setUserId(3L);

		// 历史导入统计
		// commonParam.setSourceFlag(5);
		// commonParam.setStatisticsMethods(4);
		// commonParam.setUserId(3L);

		// 自动生成统计
		// commonParam.setSourceFlag(6);
		// commonParam.setStatisticsMethods(4);
		// commonParam.setUserId(3L);

		logger.info("Send=\n" + JsonUtil.toJson(commonParam));
		MockHttpServletRequestBuilder post = post("/followup/workload/statistics").content(JsonUtil.toJson(commonParam)).contentType(
				MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void statisticsFollowupTelephoneConnRate_test() {
		TCommonParam commonParam = new TCommonParam();
		//commonParam.setCategory(10);
		commonParam.setCategory(20);
		//commonParam.setCategory(30);
		//commonParam.setUserId(1356226L);
		//commonParam.setBeginDate(DateUtil.stringToDate("2016-08-19 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		//commonParam.setEndDate(DateUtil.stringToDate("2016-08-20 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		logger.info("Send=\n" + JsonUtil.toJson(commonParam));
		MockHttpServletRequestBuilder post = post("/followup/telephone/connection/rate/statistics")
				.content(JsonUtil.toJson(commonParam)).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void statisticsDailyGainPatientList_test() {
		TCommonParam commonParam = new TCommonParam();
		commonParam.setNum(10);
		//commonParam.setBeginDate(DateUtil.stringToDate("2016-08-19 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		//commonParam.setEndDate(DateUtil.stringToDate("2016-08-20 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		logger.info("Send=\n" + JsonUtil.toJson(commonParam));
		MockHttpServletRequestBuilder post = post("/daily/gain/patient/statistics")
				.content(JsonUtil.toJson(commonParam)).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//add by fanpanwei
	@Test
	public void statisticScheduletest() {
		FollowupScheduleStatisticsReq req = new FollowupScheduleStatisticsReq();
		req.setFollowupBeginDate(DateUtil.stringToDate("2015-12-24 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		req.setConfirmBeginDate(DateUtil.stringToDate("2015-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		req.setIncludeDeathFlag(1);
		logger.info("Send=\n" + JsonUtil.toJson(req));
		MockHttpServletRequestBuilder post = post("/followup/schedule/statistics")
				.content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void exportStatsData() {
		StatsExportReq req = new StatsExportReq();
		req.setExportTemplateId("EXPT014");
		req.setFollowupWaySearchId(8724);
		req.setOutPatientFlagSearchId(8725);
		req.setFollowupWayTotalSearchId(8726);
		MockHttpServletRequestBuilder post = post("/followupway/statistics/export")
				.content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void statisticsFollowupPatient() {
		FollowupPatientStatisticsReq req = new FollowupPatientStatisticsReq();
		req.setOperator(3l);

		FollowupPatientStatusStatisticsReq[] reqs = new FollowupPatientStatusStatisticsReq[4];
		
		for (int i = 0; i < reqs.length; i++) {
			reqs[i] = new FollowupPatientStatusStatisticsReq();
		}
		
		reqs[0].setStatisticsType("tumourPart");
		reqs[1].setStatisticsType("tumorStatus");

		reqs[2].setStatisticsType("age");
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		reqs[2].setTumorFlag(ls);

		reqs[3].setStatisticsType("sex");
		reqs[3].setTumorFlag(ls);

		req.setStatisticsReqs(reqs);

		MockHttpServletRequestBuilder post = post("/followup/patient/statistics").content(JsonUtil.toJson(req)).contentType(
				MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(post).andExpect(status().isOk()).andDo(print()).andReturn();
			logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

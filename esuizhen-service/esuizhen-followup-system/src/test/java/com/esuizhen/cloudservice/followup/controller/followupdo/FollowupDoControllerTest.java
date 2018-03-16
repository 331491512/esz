package com.esuizhen.cloudservice.followup.controller.followupdo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupPhoneCallIncomingQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDeleteReq;
import com.esuizhen.cloudservice.followup.bean.FollowupSmsInvalidSetReq;
import com.esuizhen.cloudservice.followup.bean.FollowupSmsSendReq;
import com.esuizhen.cloudservice.followup.bean.QualityoflifeReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallIncomingInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallStatusInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupSmsReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupDoControllerTest {
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
	public void queryFollowupPhonePatientPageTurn() throws Exception {
		MockHttpServletRequestBuilder get = get("/do/phone/patient/page/turn/query")
				.param("followupTaskId", "TASK20170224151522426550")
				.param("followupAssignId", "ASSI20170224151522776545")
				.param("patientId", "1954362")
				;
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过2016-8-12
	 */
	@Test
	@Ignore
	public void saveFollowupPhoneCallStatus() throws Exception {
		TFollowupPhoneCallStatusInfo info = new TFollowupPhoneCallStatusInfo();

		info.setFollowupAssignId("A12");
		info.setFollowupResultId("Abuff12");
		info.setHospitalId(6);
		info.setCallId("12121");
		info.setFollowupDate(new Date());
		info.setTrueName("张三");
		info.setTelphone("1335646456");
		info.setState(1);
		MockHttpServletRequestBuilder post = post("/do/phone/call/status/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description:测试已通过2016-8-13
	 */
	@Test
	@Ignore
	public void saveFollowupPhoneResultTemp() throws Exception {
		//{"followupResultId":"RESU20161210185238842997","followupAssignId":"ASSI20161210153525355016",
//		"followupTaskId":"TASK20161210153525417687","patientId":386117,"hospitalId":20431,"operator":1348,"followupResultValue":1,
//		"followupWay":2,"followupResultPhone":"13188408632","followupFlag":1,"patientFamilyId":1717543}
		
		TFollowupResultDetailInfo info = new TFollowupResultDetailInfo();

		info.setFollowupResultId("RESU20161216110516709985");
		info.setFollowupAssignId("ASSI20161216105713561152");
		info.setFollowupTaskId("TASK20161216105713373375");
		info.setHospitalId(20431);
		info.setPatientId(438644L);
		info.setOperator(1348L);
		info.setFollowupResultValue(3);
		info.setFollowupWay(2);
		info.setFollowupResultPhone("15042623776");
		info.setFollowupFlag(1);
		info.setPatientFamilyId(1767260L);
		
		MockHttpServletRequestBuilder post = post("/do/phone/result/temp/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description:测试已通过2016-8-13
	 */
	@Test
//	@Ignore
	public void saveFollowupPhone() throws Exception {
		TFollowupResultDetailInfo info = new TFollowupResultDetailInfo();

		// 情况一：设置空号
//		info.setFollowupAssignId("ASSIGN94");
//		info.setFollowupFlag(1);
//		info.setFollowupResultId("RESU20170707115048975979");
//		info.setFollowupResultPhone("13934502408");
//		info.setFollowupResultValue(8);
//		info.setFollowupTaskId("94");
//		info.setFollowupWay(2);
//		info.setHospitalId(19193);
//		info.setOperator(3L);
//		info.setPatientFamilyId(3786425l);
//		info.setPatientId(618202l);
		
		// 情况二：设置无人接听
//		info.setFollowupAssignId("ASSIGN94");
//		info.setFollowupFlag(1);
//		info.setFollowupResultBuffId("RBUFF20170707114846957825");
//		info.setFollowupResultId("RESU20170707114846125251");
//		info.setFollowupResultPhone("13934502408");
//		info.setFollowupResultValue(7);
//		info.setFollowupTaskId("94");
//		info.setFollowupWay(2);
//		info.setHospitalId(19193);
//		info.setOperator(3L);
//		info.setPatientFamilyId(3808334l);
//		info.setPatientId(618202l);
		
		
		// 情况三：设置稳定
		info.setFollowupAssignId("ASSIGN94");
		info.setFollowupFlag(1);
		info.setFollowupResultId("RESU20170707115048975979");
		info.setFollowupResultPhone("13934534838");
		info.setFollowupResultValue(1);
		info.setFollowupTaskId("94");
		info.setFollowupWay(2);
		info.setHospitalId(19193);
		info.setOperator(3L);
		info.setPatientFamilyId(3786467l);
		info.setPatientId(618202l);
		info.setWholeProcessFlag("1");
		
		MockHttpServletRequestBuilder post = post("/do/phone/result/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过
	 */
	@Test
	@Ignore
	public void sendWxFollowup() throws Exception {
		FollowupMsgSendReq info = new FollowupMsgSendReq();
		info.setFollowupTaskId("TASK20160830095009811146");
		info.setFollowupAssignId("ASSI20160830095010988355");
		info.setHospitalId(20431);
		info.setPatientId(157193L);
		info.setTemplateId("CONT20160827103554256827");
		info.setOpenId("oON9qswHh0fXNoP9qFfod2EzEfCk");
		info.setTrueName("李月云");
		info.setContent("亲爱的患者朋友，医生十分关心您出院后的康复情况，望您能够配合反馈病情：稳定回复1；复发回复2；转移回复3；其他情况回复4。您的反馈将有助于医生为您制定后续治疗方案，谢谢配合！");

		MockHttpServletRequestBuilder post = post("/do/wx/send").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过
	 */
	@Test
	@Ignore
	public void sendWxMassFollowup() throws Exception {
		FollowupMsgSendReq info = new FollowupMsgSendReq();

		info.setFollowupAssignId("A12");
		info.setHospitalId(6);
		info.setPatientId(12L);
		info.setTemplateId("1");
		info.setOpenId("111111");
		info.setTrueName("1a");

		MockHttpServletRequestBuilder post = post("/do/wx/mass/send").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过
	 */
	@Test
	@Ignore
	public void sendSmsFollowup() throws Exception {
		//{"templateId":"CONT20161214172620882690","followupTaskId":"TASK20161220091558461277","followupAssignId":"ASSI20161220091558715057",
		//"patientId":464174,"content":"亲爱的患者朋友，医生十分关心您出院后的康复情况，望您能够配合反馈病情：稳定回复1；复发回复2；转移回复3；其他情况回复4。您的反馈将有助于医生为您制定后续治疗方案，谢谢配合！","hospitalId":20431,"trueName":"潘士新"}
		FollowupMsgSendReq info = new FollowupMsgSendReq();
		info.setPatientId(464174L);
		info.setTemplateId("CONT20161214172620882690");
		info.setTrueName("张三");
		info.setFollowupTaskId("TASK20161220091558461277");
		info.setFollowupAssignId("ASSI20161220091558715057");
		info.setHospitalId(20431);
		info.setContent("亲爱的患者朋友，医生十分关心您出院后的康复情况，望您能够配合反馈病情：稳定回复1；复发回复2；转移回复3；其他情况回复4。您的反馈将有助于医生为您制定后续治疗方案，谢谢配合！");
//		info.setTimerTaskDate(DateUtil.getOffsetMinutes(5));

		MockHttpServletRequestBuilder post = post("/do/sms/send").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过2016-8-12
	 */
	@Test
	@Ignore
	public void sendSmsMassFollowup() throws Exception {
		FollowupMsgSendReq info = new FollowupMsgSendReq();

		info.setFollowupTaskId("TASK20160909091705458380");
		info.setFollowupAssignId("ASSI20160909091705959204");
		info.setHospitalId(20431);
		info.setTemplateId("CONT20160907100340110724");
		info.setContent("稳定回复1；复发回复2；转移回复3；其他情况回复4。");
		info.setTimerTaskDate(DateUtil.getOffsetMinutes(5));
		MockHttpServletRequestBuilder post = post("/do/sms/mass/send").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过2016-8-12 16:32
	 */
	@Test
	@Ignore
	public void queryFollowupSmsReply() throws Exception {
		Map<String, Object> info = new HashMap<String, Object>();

		info.put("page", 0);
		info.put("num", 20);

		MockHttpServletRequestBuilder post = post("/do/sms/reply/list").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * @Description: 短信回复按数据权限查看
	 */
	@Test
	@Ignore
	public void queryFollowupSmsReplyDataAccess() throws Exception {
		FollowupSmsSendReq info = new FollowupSmsSendReq();

		info.setPage(0);
		info.setNum(20);
		info.setOperator(1347L);

		MockHttpServletRequestBuilder post = post("/do/sms/reply/list").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
		

	}

	/**
	 * @Description: 已测试通过2016-8-12 16:32
	 */
	@Test
	@Ignore
	public void processFollowupSmsReply() throws Exception {
		TFollowupResultDetailInfo info = new TFollowupResultDetailInfo();

		info.setFollowupAssignId("1");
		info.setHospitalId(6);
		info.setPatientId(1l);
		info.setOperator(1L);
		info.setFollowupResultValue(1);
		info.setFollowupWay(1);
		info.setFollowupTime(new Date());
		info.setReqId(1L);

		MockHttpServletRequestBuilder post = post("/do/sms/reply/process").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过2016-8-12 16:32
	 */
	@Test
	@Ignore
	public void setInvalidSmsFollowup() throws Exception {
		FollowupSmsInvalidSetReq req = new FollowupSmsInvalidSetReq();
		req.setReqId(43L);
		MockHttpServletRequestBuilder post = post("/do/sms/invalid/set").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过2016-8-15 18:32
	 */
	@Test
	@Ignore
	public void setFollowupNeedless() throws Exception {
		MockHttpServletRequestBuilder get = get("/do/patient/needless/set").param("patientId", "1");
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	@Test
	@Ignore
	public void scanAllReply() throws Exception {
		MockHttpServletRequestBuilder get = get("/do/scanAllReply");
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过2016-8-12 16:32
	 */
	@Test
//	@Ignore
	public void queryPhoneCallIncoming() throws Exception {
		FollowupPhoneCallIncomingQueryReq req = new FollowupPhoneCallIncomingQueryReq();
		req.setUserRole(12);
		req.setOperator(3l);
		req.setPage(0);
		req.setNum(10);

		MockHttpServletRequestBuilder post = post("/do/phone/call/incoming/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}

	/**
	 * @Description: 已测试通过2016-8-12 16:32
	 */
	@Test
	@Ignore
	public void savePhoneCallIncoming() throws Exception {
		TFollowupPhoneCallIncomingInfo info = new TFollowupPhoneCallIncomingInfo();

		info.setFollowupAssignId("1");
		info.setHospitalId(6);
		info.setPatientId(1l);
		info.setFollowupAssignId("1");
		info.setHospitalId(6);
		info.setPatientId(1l);

		MockHttpServletRequestBuilder post = post("/do/phone/call/incoming/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @Description: 已测试通过2016-8-12 16:32
	 */
	@Test
	@Ignore
	public void receiptSmsSendState() throws Exception {
		SmsSendReportInfo info = new SmsSendReportInfo();
		info.setMobile("18146515613");
		info.setStatus(0);
		info.setReportTime("2016-08-12");
		info.setDesc("顶戴");
		List<SmsSendReportInfo> list = new ArrayList<SmsSendReportInfo>();
		list.add(info);
		Map<String, List<SmsSendReportInfo>> map = new HashMap<String, List<SmsSendReportInfo>>();
		map.put("data", list);

		MockHttpServletRequestBuilder post = post("/do/sms/send/state/receipt").content(JsonUtil.toJson(map)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * @Description: 
	 */
	@Test
	@Ignore
	public void saveFollowupResult() throws Exception {
		TFollowupResultDetailInfo info = new TFollowupResultDetailInfo();
		info.setFollowupResultId("RESU20161201103716739543");
		info.setFollowupResultBuffId("RBUFF20161201103716276604");
		info.setFollowupTaskId("TASK20161130154752731041");
		info.setFollowupResultValue(2);
		info.setFollowupResultValueName("复发");
		info.setOperator(1350L);
		info.setOperatorName("王芳");
		info.setPatientId(389816L);
		info.setFollowupTime(DateUtil.stringToDate("2016-12-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		
		MockHttpServletRequestBuilder post = post("/do/result/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * @Description: 
	 */
	@Test
	public void saveFollowupQualityoflife() throws Exception {
		QualityoflifeReq info = new QualityoflifeReq();
		info.setOperator(20983L);
		info.setPatientId(1954331L);
		info.setDeathDate(new Date());
		info.setFollowupWay(8);
		info.setIsTumourDeath(1);
		
		MockHttpServletRequestBuilder post = post("/do/qualityoflife/result/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	@Test
	public void saveFollowupResult_Insert() throws Exception {
		TFollowupResultDetailInfo info = new TFollowupResultDetailInfo();
		info.setFollowupResultValue(2);
		info.setFollowupResultValueName("复发");
		info.setOperator(655L);
		info.setUpdateOperator(655L);
		info.setFollowupWay(4);
		info.setOperatorName("吉阳");
		info.setUpdateOperatorName("吉阳");
		info.setPatientId(590779L);
		info.setFollowupTime(DateUtil.stringToDate("2016-12-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		
		MockHttpServletRequestBuilder post = post("/do/result/save").content(JsonUtil.toJson(info)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * @Description: 已测试通过2016-8-12 16:32
	 */
	@Test
	@Ignore
	public void deleteFollowupResult() throws Exception {
		FollowupResultDeleteReq req=new FollowupResultDeleteReq();
		req.setFollowupResultId("RESU20161201103716739543");
		req.setFollowupResultBuffId("RBUFF20161201103716276604");
		req.setUpdateOperator(1350L);
		req.setUpdateOperatorName("王芳");
		MockHttpServletRequestBuilder post = post("/do/result/delete").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @author fanpanwei
	 * @date 2017年7月5日
	 * @param
	 * @description:测试随访短信记录功能
	 * @return
	 */
	@Test
	public void queryFollowupSmsReplyRecordsTest() throws Exception {
		FollowupSmsSendReq req = new FollowupSmsSendReq();
		// 1、同一个患者的同一次任务有多条回复短信
		req.setPatientId(760981L);
		req.setFollowupTaskId("62");
		// 2、同一个患者不同任务中分别有回复短信
		// req.setPatientId(813708L);
		// 3、只根据任务去查回复短信
		// req.setFollowupTaskId("62");

		MockHttpServletRequestBuilder post = post("/do/sms/record/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}

	/**
	 * @author fanpanwei
	 * @date 2017年7月5日
	 * @param
	 * @description:测试随访短信回显到解析弹窗的接口
	 * @return
	 */
	@Test
	public void queryFollowupBuffBySms() throws Exception {
		TFollowupSmsReqInfo req = new TFollowupSmsReqInfo();
		req.setPatientId(814019L);
		req.setFollowupTaskId("78");

		MockHttpServletRequestBuilder post = post("/do/sms/followup/buff/query").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void patienPhoneCallIncomingStateModify() throws Exception {
		// MockHttpServletRequestBuilder get = get("/do/phone/call/incoming/state?patientId=703836&taskId=TASK20170210150010464695");
		MockHttpServletRequestBuilder get = get("/do/phone/call/incoming/state?callIncomingPhone=13935404677");
		MvcResult result = mockMvc.perform((get)).andReturn();
		logger.info("result=\n"+JsonUtil.beautiful(result.getResponse().getContentAsString()));
	}
}

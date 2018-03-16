package com.esuizhen.cloudservice.followup.controller.followuptask;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import com.esuizhen.cloudservice.followup.bean.FollowupTaskOperatorAlloPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskCreateReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByLeaderQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByOperatorQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskStopReq;
import com.esuizhen.cloudservice.followup.dao.user.UserDao;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupContentTemplateSimpleInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssign;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskSimpleInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration({ "classpath:spring/application.xml" })
public class FollowupTaskControllerTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Autowired
	private UserDao userDao;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	/**
	 * 任务查询-随访主任
	 * @throws Exception
	 */
	@Test
	public void queryFollowupTaskListByLeaderTest() throws Exception {
		TFollowupTaskListByLeaderQueryReq 
		 req=new TFollowupTaskListByLeaderQueryReq();
		
		req.setReqFlag(0);
		req.setPage(0);

		req.setReqFlag(2);
		req.setNum(10);
		
		MockHttpServletRequestBuilder post = post("/task/query/byleader").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	/**
	 * 任务查询-随访主任-已结束
	 * @throws Exception
	 */
	@Test
	public void queryFollowupTaskListByLeaderTest_Case2() throws Exception {
		TFollowupTaskListByLeaderQueryReq req=new TFollowupTaskListByLeaderQueryReq();
		
//		req.setReqFlag(0);
		req.setReqFlag(2);
		req.setUserId(3L);
		req.setPage(0);
		req.setNum(10);
		
		MockHttpServletRequestBuilder post = post("/task/query/byleader").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}


	/**
	 * 任务查询-随访人员
	 * @throws Exception
	 */
	@Test
	public void queryFollowupTaskListByOperatorTest() throws Exception {
		TFollowupTaskListByOperatorQueryReq 
		 req=new TFollowupTaskListByOperatorQueryReq();
		
		req.setUserId(11L);
		req.setReqFlag(0);
		req.setPage(0);
		req.setNum(10);
		
		MockHttpServletRequestBuilder post = post("/task/query/byoperator").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	

	/**
	 * 任务详情-随访主任
	 * @throws Exception
	 */
	@Test
	public void queryFollowupTaskDetailTest() throws Exception {
		MockHttpServletRequestBuilder get = get("/task/detail/query").
				param("userId", "1050").
				param("taskId","TASK20160819053122143964");
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	/**
	 * 随访任务修改
	 * @throws Exception
	 */
	@Test
	public void updateFollowupTaskTest() throws Exception {
		TFollowupTaskSimpleInfo  req=new TFollowupTaskSimpleInfo();
		req.setFollowupTaskId("TASK20160819053122143964");
		req.setFollowupTaskName("改名字了");
				
		MockHttpServletRequestBuilder post = post("/task/update").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	/**
	 * 任务详情-随访人员
	 * @throws Exception
	 */
	@Test
	public void queryFollowupTaskDetailTest_Case2() throws Exception {
		/*
		MockHttpServletRequestBuilder get = get("/task/detail/query").param("userId", "3").
					param("taskId","TASK20160819053122143964").
					param("assignId","ASSI20160819053122100494");
		*/
		MockHttpServletRequestBuilder get = get("/task/detail/query").param("userId", "5").
				param("taskId","TASK20160819175249691294").
				param("assignId", "ASSI20160819175250964480");
		MvcResult result = mockMvc.perform((get)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	/**
	 * 任务详情-患者列表-随访主任
	 * @throws Exception
	 */
	@Test
	public void queryFollowupTaskPatientListTest() throws Exception {
		String jsonStr="{\"page\":0,\"num\":10,\"taskId\":\"TASK20170720115852235709\",\"patientNo\":\"1706427\"}";
		// 测试民族
		//jsonStr="{\"page\":0,\"num\":10,\"taskId\":\"TASK20170720115852235709\",\"patientNo\":\"1706427\",\"nationIdStr\":1}";
		// 测试病种
		//jsonStr="{\"page\":0,\"num\":10,\"taskId\":\"TASK20170720115852235709\",\"patientNo\":\"1706427\",\"sourceDiseaseTypeIdStr\":\"61\"}";
		
		MockHttpServletRequestBuilder post = post("/task/patient/list").content(jsonStr).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	
	/**
	 * 任务详情-患者列表-随访人员
	 * @throws Exception
	 */
	@Test
	public void queryFollowupTaskPatientListTest_Case2() throws Exception {
		TFollowupTaskPatientListQueryReq 
		   req=new TFollowupTaskPatientListQueryReq();
		
		req.setTaskId("102");
		req.setPage(0);
		req.setNum(10);
		
		MockHttpServletRequestBuilder post = post("/task/patient/list").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	/**
	 * 创建随访任务
	 * @throws Exception
	 */
	@Test
	public void createFollowupTaskTest() throws Exception {
		TFollowupTaskCreateReq   
		 req=new TFollowupTaskCreateReq();
		
		int patientIdIndexBegin=30;
		int totalPatientNum=60;
		int doctorIdIndexBegin=13;
		int operatorNum=4;
		
		req.setUserId(3L);
		req.setFollowupTaskName("鼻咽癌随访任务");
		req.setDiseaseTypeId(1);
		req.setTotalPatientNum(totalPatientNum);
		List<Long> patientIdList=new ArrayList<Long>();
		int  i=patientIdIndexBegin;
		int patientRealNum=0;
		while(true)
		{
			if(!userDao.isPatientExist(new Long(i)).equals(0)){
				patientIdList.add(new Long(i));
				patientRealNum++;
			}
			i++;
			if(patientRealNum>=totalPatientNum)
				break;
		}
		
		req.setPatientIdList(patientIdList);
		
		List<TFollowupTaskAssign> taskAssignList=new ArrayList<TFollowupTaskAssign>();
		for(i=0;i<operatorNum;i++){
			TFollowupTaskAssign assign=new TFollowupTaskAssign();
			assign.setOperator(new Long(doctorIdIndexBegin+i));
			assign.setTotalPatientNum(totalPatientNum/operatorNum);
			taskAssignList.add(assign);
		}
		req.setTaskAssignList(taskAssignList);
		
		List<TFollowupContentTemplateSimpleInfo> contentTemplateList=new ArrayList<TFollowupContentTemplateSimpleInfo>();
		TFollowupContentTemplateSimpleInfo templateInfo=new TFollowupContentTemplateSimpleInfo();
		templateInfo.setContentTemplateId("CONT20160811192914126478");
		templateInfo.setContentTemplateType(1);
		contentTemplateList.add(templateInfo);
		TFollowupContentTemplateSimpleInfo templateInfo2=new TFollowupContentTemplateSimpleInfo();
		templateInfo2.setContentTemplateId("1");
		templateInfo2.setContentTemplateType(2);
		contentTemplateList.add(templateInfo2);
		req.setContentTemplateList(contentTemplateList);
		
		
		MockHttpServletRequestBuilder post = post("/task/create").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	
	/**
	 * 创建随访任务-searchId
	 * @throws Exception
	 */
	@Test
	public void createFollowupTaskBySearchIdTest_Case2() throws Exception {
		TFollowupTaskCreateReq   
		 req=new TFollowupTaskCreateReq();
		
		int totalPatientNum=8;
		int doctorIdIndexBegin=13;
		int operatorNum=2;
		
		req.setUserId(5L);
		req.setFollowupTaskName("喉癌随访任务");
		req.setTotalPatientNum(totalPatientNum);
	
		req.setSearchId(2);
		req.setConditionId(0);
		
		List<TFollowupTaskAssign> taskAssignList=new ArrayList<TFollowupTaskAssign>();
		for(int i=0;i<operatorNum;i++){
			TFollowupTaskAssign assign=new TFollowupTaskAssign();
			assign.setOperator(new Long(doctorIdIndexBegin+i));
			assign.setTotalPatientNum(totalPatientNum/operatorNum);
			taskAssignList.add(assign);
		}
		req.setTaskAssignList(taskAssignList);
		
		List<TFollowupContentTemplateSimpleInfo> contentTemplateList=new ArrayList<TFollowupContentTemplateSimpleInfo>();
		TFollowupContentTemplateSimpleInfo templateInfo=new TFollowupContentTemplateSimpleInfo();
		templateInfo.setContentTemplateId("CONT20160811192914126478");
		templateInfo.setContentTemplateType(1);
		contentTemplateList.add(templateInfo);
		TFollowupContentTemplateSimpleInfo templateInfo2=new TFollowupContentTemplateSimpleInfo();
		templateInfo2.setContentTemplateId("1");
		templateInfo2.setContentTemplateType(2);
		contentTemplateList.add(templateInfo2);
		req.setContentTemplateList(contentTemplateList);
		
		
		MockHttpServletRequestBuilder post = post("/task/create").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	/**
	 * 创建随访任务-searchId
	 * @throws Exception
	 */
	@Test
	public void createFollowupTaskBySearchIdTest_Case3() throws Exception {
		TFollowupTaskCreateReq   
		 req=new TFollowupTaskCreateReq();
		
		int totalPatientNum=13;
		
		req.setUserId(3l);
		req.setFollowupTaskName("测试舌癌");
		req.setTotalPatientNum(totalPatientNum);
	
		req.setSearchId(3378);
		req.setConditionId(0);
		req.setIsLastFollowupControl(1);
		
		List<TFollowupTaskAssign> taskAssignList=new ArrayList<TFollowupTaskAssign>();
		
//		TFollowupTaskAssign assign=new TFollowupTaskAssign();
//		assign.setOperator(1348L);
//		assign.setTotalPatientNum(2);
//		assign.setLastFollowupPatientNum(4);
//		assign.setIsLastFollowup(1);
//		taskAssignList.add(assign);
		
		TFollowupTaskAssign assign1=new TFollowupTaskAssign();
		assign1.setOperator(1348L);
		assign1.setTotalPatientNum(13);
		assign1.setLastFollowupPatientNum(12);
		assign1.setIsLastFollowup(1);
		taskAssignList.add(assign1);
		
		req.setTaskAssignList(taskAssignList);
		
		/*List<TFollowupContentTemplateSimpleInfo> contentTemplateList=new ArrayList<TFollowupContentTemplateSimpleInfo>();
		TFollowupContentTemplateSimpleInfo templateInfo=new TFollowupContentTemplateSimpleInfo();
		templateInfo.setContentTemplateId("CONT20160811192914126478");
		templateInfo.setContentTemplateType(1);
		contentTemplateList.add(templateInfo);
		TFollowupContentTemplateSimpleInfo templateInfo2=new TFollowupContentTemplateSimpleInfo();
		templateInfo2.setContentTemplateId("1");
		templateInfo2.setContentTemplateType(2);
		contentTemplateList.add(templateInfo2);
		req.setContentTemplateList(contentTemplateList);*/
		
		
		MockHttpServletRequestBuilder post = post("/task/create").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	/**
	 * 创建随访任务-searchId
	 * @throws Exception
	 */
	@Test
	public void createFollowupTaskBySearchIdTest_CaseByPatient() throws Exception {
		TFollowupTaskCreateReq req=new TFollowupTaskCreateReq();
		
		req.setUserId(1887282L);
		req.setFollowupTaskName("2017-02-27-16:12:38");
		req.setTotalPatientNum(321);
		req.setSearchId(3225);
		req.setConditionId(0);
		req.setIsLastFollowupControl(0);
		
		List<TFollowupTaskAssign> taskAssignList=new ArrayList<TFollowupTaskAssign>();
		TFollowupTaskAssign assign=new TFollowupTaskAssign();
		assign.setOperator(18111L);
		assign.setTotalPatientNum(10);
		taskAssignList.add(assign);
		req.setTaskAssignList(taskAssignList);
		
//		List<TFollowupContentTemplateSimpleInfo> contentTemplateList=new ArrayList<TFollowupContentTemplateSimpleInfo>();
//		TFollowupContentTemplateSimpleInfo templateInfo=new TFollowupContentTemplateSimpleInfo();
//		templateInfo.setContentTemplateId("CONT20160811192914126478");
//		templateInfo.setContentTemplateType(1);
//		contentTemplateList.add(templateInfo);
//		TFollowupContentTemplateSimpleInfo templateInfo2=new TFollowupContentTemplateSimpleInfo();
//		templateInfo2.setContentTemplateId("1");
//		templateInfo2.setContentTemplateType(2);
//		contentTemplateList.add(templateInfo2);
//		req.setContentTemplateList(contentTemplateList);
		
		
		MockHttpServletRequestBuilder post = post("/task/create").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	/**
	 * 终止随访任务- stopTask
	 * @throws Exception
	 */
	@Test
	public void stopFollowupTaskTest() throws Exception {
		TFollowupTaskStopReq   
		 req=new TFollowupTaskStopReq();
		
			
		req.setUserId(3L);
		List<String> taskIdList=new ArrayList<String>();
		taskIdList.add("TASK20160819062334273224");
		req.setTaskId(taskIdList);
		
		MockHttpServletRequestBuilder post = post("/task/stop").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	/**
	 * add by fanpanwei
	 */
	@Test
	public void createFollowupTaskOperatorAlloPatientTest() throws Exception {
		FollowupTaskOperatorAlloPatientReq   
		 req=new FollowupTaskOperatorAlloPatientReq();
		
			
		List<Long> patientIdList=new ArrayList<Long>();
		patientIdList.add(191L);
		patientIdList.add(231L);
		patientIdList.add(234L);
		req.setPatientIdList(patientIdList);
		List<Long> operatorList = new ArrayList<Long>();
		operatorList.add(19803L);
		operatorList.add(12683L);
		operatorList.add(11L);
		req.setOperators(operatorList);
		MockHttpServletRequestBuilder post = post("/task/operator/allo/patient/list").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform((post)).andExpect(status().isOk()).andDo(print()).andReturn();
		logger.info("result=\n" + JsonUtil.beautiful(result.getResponse().getContentAsString()));

	}
	
	
}

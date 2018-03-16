/**
 * 
 */
package com.esuizhen.cloudservice.followup.service.followuptask.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.followup.bean.FollowupTask;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskOperatorAlloPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskCreateReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByLeaderQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByOperatorQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskStopReq;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.followup.dao.followupdo.FollowupPhoneCallRecordDao;
import com.esuizhen.cloudservice.followup.dao.followuptask.FollowupTaskDao;
import com.esuizhen.cloudservice.followup.dao.user.UserDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupContentTemplateSimpleInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupPatientInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssign;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssignPatient;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssignPatientSearchId;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskContentTemplateRelation;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskDetailInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskSimpleInfo;
import com.esuizhen.cloudservice.followup.service.followuptask.FollowupTaskService;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.dao.search.SearchDao;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

/**
 * @author bigdragon 2016/8/6
 */
@Service
@Transactional
public class FollowupTaskServiceImpl implements FollowupTaskService {
	@Autowired
	FollowupTaskDao dao;

	@Autowired
	UserDao userDao;

	@Autowired
	private SearchDao searchDao;

	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;

	@Autowired
	private FollowupPhoneCallRecordDao followupPhoneCallRecordDao;
	
	// add by zhuguo
	@Autowired
	private OrganizationDoctorService organizationDoctorService;

	/**
	 * 2.1.1 随访任务查询(随访主任)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<TFollowupTaskSimpleInfo> queryFollowupTaskListByLeader(TFollowupTaskListByLeaderQueryReq req) {
		// TODO Auto-generated method
		// stub
		// 1. 获得任务基本信息
		if (req.getNum() == null || req.getNum() == 0)
			req.setNum(10);
		if (req.getPage() == null)
			req.setPage(0);
		
		// add by zhuguo
		if (req.getUserId() != null) {
			String powerSql = organizationDoctorService.getDoctorIdSql(null, req.getUserId());
			if (powerSql == null || "".equals(powerSql)) {
				LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			} else {
				req.setSql(powerSql);
			}
		}
		// end

		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TFollowupTaskSimpleInfo> list = dao.queryFollowupTaskListByLeader(req);
		Page<TFollowupTaskSimpleInfo> page = PageUtil.returnPage((com.github.pagehelper.Page<TFollowupTaskSimpleInfo>) list);

		// 2. 获得任务进展和有效随访率
		if (list != null && list.size() > 0)
			getTaskProgressAndEffectiveRate(list);

		// 3. 获取随访人员列表
		if (list != null && list.size() > 0)
			getTaskOperatorList(list);

		return page;
	}

	private void getTaskProgressAndEffectiveRate(List<TFollowupTaskSimpleInfo> list) {
		// TODO Auto-generated method
		// stub

		getTaskProgress(list);

		getTaskEffectiveRate(list);
	}

	private void getTaskOperatorList(List<TFollowupTaskSimpleInfo> list) {
		// TODO Auto-generated method
		// stub
		if (list != null && list.size() > 0) {
			List<String> ids = new ArrayList<String>();
			for (TFollowupTaskSimpleInfo task : list) {
				ids.add(task.getFollowupTaskId());
			}

			List<TFollowupTaskSimpleInfo> assignList = dao.queryFollowupTaskAssignList(ids);
			if (assignList != null) {
				// 获得了有效率，保存到结果中
				LogUtil.log.debug("Query assignList succeed. size=" + assignList.size());
				for (TFollowupTaskSimpleInfo task : list) {
					for (TFollowupTaskSimpleInfo assign : assignList)
						if (task.getFollowupTaskId().equals(assign.getFollowupTaskId())) {
							task.setOperatorList(assign.getOperatorList());
						}
				}

			}
		}
	}

	private void getTaskEffectiveRate(List<TFollowupTaskSimpleInfo> list) {
		// TODO Auto-generated method
		// stub

		// 获取随访有效率
		if (list != null && list.size() > 0) {
			List<String> ids = new ArrayList<String>();
			for (TFollowupTaskSimpleInfo task : list) {
				ids.add(task.getFollowupTaskId());
			}

			List<TFollowupTaskSimpleInfo> effectiveList = dao.queryFollowupTaskEffectiveRate(ids);
			if (effectiveList != null) {
				// 获得了有效率，保存到结果中
				LogUtil.log.debug("Query effectiveRate succeed. size=" + effectiveList.size());
				for (TFollowupTaskSimpleInfo task : list) {
					for (TFollowupTaskSimpleInfo e : effectiveList)
						if (task.getFollowupTaskId().equals(e.getFollowupTaskId())) {
							task.setEffectiveRate(e.getEffectiveRate());
						}
				}

			}
		}
	}

	private void getTaskProgress(List<TFollowupTaskSimpleInfo> list) {
		// TODO Auto-generated method
		// stub
		// 获取随访进度
		if (list != null && list.size() > 0) {
			List<String> ids = new ArrayList<String>();
			for (TFollowupTaskSimpleInfo task : list) {
				ids.add(task.getFollowupTaskId());
			}

			List<TFollowupTaskSimpleInfo> progressList = dao.queryFollowupTaskProgress(ids);
			if (progressList != null) {
				// 获得了有效率，保存到结果中
				LogUtil.log.debug("Query progress succeed. size=" + progressList.size());
				for (TFollowupTaskSimpleInfo task : list) {
					for (TFollowupTaskSimpleInfo e : progressList)
						if (task.getFollowupTaskId().equals(e.getFollowupTaskId())) {
							task.setProgress(e.getProgress());
						}
				}

			}
		}
	}

	/**
	 * 2.1.2 随访任务查询(随访人员)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<TFollowupTaskSimpleInfo> queryFollowupTaskListByOperator(TFollowupTaskListByOperatorQueryReq req) {
		// TODO Auto-generated method
		// stub
		// 1. 获得任务基本信息
		if (req.getNum() == null || req.getNum() == 0)
			req.setNum(10);
		if (req.getPage() == null)
			req.setPage(0);

		// add by zhuguo
		// if (req.getOperator() != null) {
		// String powerSql =
		// organizationDoctorService.getDoctorIdSql(req.getOperator(), null);
		// if (powerSql == null || "".equals(powerSql)) {
		// LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
		// } else {
		// req.setSql(powerSql);
		// }
		// }
		// req.setRole(organizationDoctorService.getDoctorRoleById(req.getOperator(),
		// null));
		// end

		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TFollowupTaskSimpleInfo> list = dao.queryFollowupTaskListByOperator(req);
		Page<TFollowupTaskSimpleInfo> page = PageUtil.returnPage((com.github.pagehelper.Page<TFollowupTaskSimpleInfo>) list);

		// 2. 获得任务进展和有效随访率
		if (list != null && list.size() > 0)
			getTaskProgressAndEffectiveRate(list);

		return page;

	}

	/**
	 * 查看随访任务详情
	 */
	@Override
	public TFollowupTaskDetailInfo queryFollowupTaskDetail(Long userId, String taskId, String assignId) {
		// TODO Auto-generated method
		// stub
		TFollowupTaskDetailInfo result = null;
		if (StringUtils.isEmpty(assignId))// 随访任务详情（随访主任）
		{
			result = dao.queryFollowupTaskDetail(userId, taskId);
		} else {
			// 需要返回随访人员姓名
			result = dao.queryFollowupTaskAssignDetail(userId, taskId, assignId);

		}
		return result;

		// 需要补充一下就诊人数统计
	}

	/**
	 * 随访任务患者列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<TFollowupPatientInfo> queryFollowupTaskPatientList(TFollowupTaskPatientListQueryReq req) {
		// TODO Auto-generated method
		// stub
		if (req.getNum() == null || req.getNum() == 0)
			req.setNum(10);
		if (req.getPage() == null)
			req.setPage(0);

		// 随访全局配置
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		Integer otherAsValidResultFlag = globalConfig.getOtherAsValidResultFlag();
		Integer followupResultFlag = globalConfig.getFollowupResultFlag();
		Integer validResultControlFlag = globalConfig.getValidResultControlFlag();

		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TFollowupPatientInfo> resultList = new ArrayList<TFollowupPatientInfo>();
		List<TFollowupPatientInfo> list = dao.queryFollowupTaskPatientList(req);

		if (UtilValidate.isNotEmpty(list)) {
			for (TFollowupPatientInfo info : list) {
				if (info.getFollowupState() == 1) {
					info.setPhoneFlag(1);
				} else if (info.getFollowupFlag() == 2) {// 患者已失访
					info.setPhoneFlag(0);
				} else if (followupResultFlag == 0 && UtilValidate.isNotEmpty(info.getFollowupResultValue())) {// 随访结果控制
					if (info.getFollowupWay() == Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS && info.getFollowupResultValue() == 5) {// 短信随访方式需要能够进入电话随访页面（内部随访结果=5）
						info.setPhoneFlag(1);
					} else if (info.getFollowupResultType() == 1) {// 已有有效结果
						info.setPhoneFlag(0);
					} else if (info.getFollowupResultType() == 2 && validResultControlFlag == 0) {// 无效结果控制
						info.setPhoneFlag(0);
					}
				} else if (UtilValidate.isNotEmpty(info.getFollowupResultValue())) {
					if (followupResultFlag == 1 && info.getFollowupWay() == Constant.FOLLOWUPWAY.FOLLOWUPWAY_PHONE) {// 开启电话为准
						if (info.getFollowupResultType() == 1) {// 已有有效结果
							info.setPhoneFlag(0);
						} else if (info.getFollowupResultType() == 2 && validResultControlFlag == 0) {// 无效结果控制
							info.setPhoneFlag(0);
						}
					} else if (followupResultFlag == 1 && info.getFollowupWay() != Constant.FOLLOWUPWAY.FOLLOWUPWAY_PHONE) {
						info.setPhoneFlag(1);
					} else if (info.getFollowupState() == 2) {// 任务已结束
						info.setPhoneFlag(0);
					}
				} else if (UtilValidate.isEmpty(info.getPhoneFlag())) {
					info.setPhoneFlag(1);
				}
				resultList.add(info);
			}
		}

		Page<TFollowupPatientInfo> resultPage = PageUtil.returnPage((com.github.pagehelper.Page<TFollowupPatientInfo>) list);
		resultPage.setDataList(resultList);
		return resultPage;
	}

	/**
	 * 随访任务创建和分配
	 * 
	 * @throws ParamMismatchExcption
	 */
	@Override
	public String createFollowupTask(TFollowupTaskCreateReq req) throws ParamMismatchExcption {
		if (req.getTaskAssignList() == null) {
			throw new EmptyParamExcption();
		}

		int assignPatientNum = getAssignPatientNum(req.getTaskAssignList());
		if (req.getTotalPatientNum() != assignPatientNum) {
			// //患者总数和各随访人员分配的数目不符，前端传入有误，抛出异常
			LogUtil.logError.error("ERROR in createFollowupTask():totalPatientNum !=task assign patient num");
			throw new ParamMismatchExcption();
		}

		// 生成TASKID
		String taskId = GeneralUtil.generateUniqueID("TASK");
		if (req.getPatientIdList() != null && !req.getPatientIdList().isEmpty()) {
			// 1. 通过传入的患者列表进行分配
			int patientNum = req.getPatientIdList().size();
			if (req.getTotalPatientNum() != patientNum) {
				// 患者总数和patientIdList数组的数目不符，前端传入有误，抛出异常
				LogUtil.logError.error("ERROR in createFollowupTask():totalPatientNum !=patientIdList.size");
				throw new ParamMismatchExcption();
			}

			// 生成随访任务、随访任务分配、随访任务和内容模板关系表记录
			this.doCreateFollowupTask(req, taskId);
			// 根据患者列表，生成随访任务-患者关系表记录
			this.doAssignFollowupTaskPatient(req, taskId, req.getPatientIdList());
		} else {
			// 生成随访任务、随访任务分配、随访任务和内容模板关系表记录
			this.doCreateFollowupTask(req, taskId);
			// 通过searchId/conditionId分配患者
			this.doAssignFollowupTaskPatient(req, taskId, req.getSearchId());

		}

		return taskId;
	}

	/**
	 * 随访任务创建和分配
	 * 
	 * @throws ParamMismatchExcption
	 */
	@Override
	public String createFollowupTaskForLastFollowup(TFollowupTaskCreateReq req) throws ParamMismatchExcption {
		if (req.getTaskAssignList() == null) {
			throw new EmptyParamExcption();
		}

		int assignPatientNum = getAssignPatientNum(req.getTaskAssignList());
		if (req.getTotalPatientNum() != assignPatientNum) {
			// //患者总数和各随访人员分配的数目不符，前端传入有误，抛出异常
			LogUtil.logError.error("ERROR in createFollowupTask():totalPatientNum !=task assign patient num");
			throw new ParamMismatchExcption();
		}

		// 生成TASKID
		String taskId = GeneralUtil.generateUniqueID("TASK");

		// 生成随访任务、随访任务分配、随访任务和内容模板关系表记录
		this.doCreateFollowupTask(req, taskId);

		List<TFollowupTaskAssign> tempList = new ArrayList<TFollowupTaskAssign>();
		SearchInfo searchInfo = this.searchDao.querySearchById(req.getSearchId());
		for (TFollowupTaskAssign assign : req.getTaskAssignList()) {
			if (assign.getIsLastFollowup() == 1) {
				if (assign.getLastFollowupPatientNum() >= assign.getTotalPatientNum()) {
					this.assignLastPatientBySearchId(assign, searchInfo);
				} else {
					Integer surplusCount = assign.getTotalPatientNum() - assign.getLastFollowupPatientNum();
					assign.setTotalPatientNum(assign.getLastFollowupPatientNum());
					this.assignLastPatientBySearchId(assign, searchInfo);

					assign.setTotalPatientNum(surplusCount);
					tempList.add(assign);
				}
			} else {
				tempList.add(assign);
			}
		}

		for (TFollowupTaskAssign assign : tempList) {
			this.assignPatientBySearchId(assign, searchInfo);
		}

		return taskId;
	}

	// 给每个随访人员分配患者
	private void doAssignFollowupTaskPatient(TFollowupTaskCreateReq req, String taskId, Integer searchId) {
		SearchInfo searchInfo = this.searchDao.querySearchById(searchId);
		for (TFollowupTaskAssign assign : req.getTaskAssignList()) {
			this.assignPatientBySearchId(assign, searchInfo);
		}
	}

	// 将患者分配给末次随访人员
	private void assignLastPatientBySearchId(TFollowupTaskAssign assign, SearchInfo searchInfo) {
		TFollowupTaskAssignPatientSearchId assignSearch = new TFollowupTaskAssignPatientSearchId();
		assignSearch.setFollowupTaskId(assign.getFollowupTaskId());
		assignSearch.setFollowupAssignId(assign.getFollowupAssignId());
		assignSearch.setSearchId(searchInfo.getSearchId());
		assignSearch.setPatientNum(assign.getTotalPatientNum());
		assignSearch.setSearchTableName(searchInfo.getSearchTableName());
		assignSearch.setSearchColumnName(searchInfo.getSearchColumn());
		assignSearch.setOperator(assign.getOperator());

		assignSearch.setPatientIds(dao.getLastFollowupPatientBySearchId(assignSearch));
		dao.createLastFollowupPatientBySearchId(assignSearch);

		// 分配完成，将查询到宽表中的患者的searchId列还原置位
		this.dao.recoveryLastFollowupPatientSearchTable(assignSearch);
	}

	// 将患者分配给随访人员
	private void assignPatientBySearchId(TFollowupTaskAssign assign, SearchInfo searchInfo) {
		TFollowupTaskAssignPatientSearchId assignSearch = new TFollowupTaskAssignPatientSearchId();
		assignSearch.setFollowupTaskId(assign.getFollowupTaskId());
		assignSearch.setFollowupAssignId(assign.getFollowupAssignId());
		assignSearch.setSearchId(searchInfo.getSearchId());
		assignSearch.setPatientNum(assign.getTotalPatientNum());
		assignSearch.setSearchTableName(searchInfo.getSearchTableName());
		assignSearch.setSearchColumnName(searchInfo.getSearchColumn());
		dao.createFollowupTaskAssignPatientBySearchId(assignSearch);
		// 分配完成，将查询到宽表中的患者的searchId列还原置位
		this.dao.recoverySearchTable(assignSearch);

		/*
		 * //分配后，
		 * 需要将var_search_patient表的flag置位
		 * dao.setSearchPatientFlag(
		 * assignSearch);
		 */
	}

	private void doAssignFollowupTaskPatient(TFollowupTaskCreateReq req, String taskId, List<Long> patientIdList) {
		// TODO Auto-generated method
		// stub
		List<TFollowupTaskAssignPatient> taskPatientList = new ArrayList<TFollowupTaskAssignPatient>();
		// 分配患者ID
		for (TFollowupTaskAssign assign : req.getTaskAssignList()) {
			assignPatient(taskPatientList, assign, patientIdList);
		}

		// 一次性插入到数据库表
		// r_followup_task_patient
		dao.createFollowupTaskAssignPatient(taskPatientList);
	}

	private void assignPatient(List<TFollowupTaskAssignPatient> taskPatientList, TFollowupTaskAssign assign, List<Long> patientIdList) {
		// TODO Auto-generated method
		// stub
		// 分配患者ID
		int beginIndex = taskPatientList.size();// 从上次分配末尾，往下继续分配
		for (int i = 0; i < assign.getTotalPatientNum(); i++) {
			TFollowupTaskAssignPatient assignPatient = new TFollowupTaskAssignPatient();
			assignPatient.setFollowupAssignId(assign.getFollowupAssignId());
			assignPatient.setFollowupTaskId(assign.getFollowupTaskId());
			assignPatient.setPatientId(patientIdList.get(i + beginIndex));
			taskPatientList.add(assignPatient);
		}
	}

	// 执行真正的任务创建和分配
	private String doCreateFollowupTask(TFollowupTaskCreateReq req, String taskId) {
		// TODO Auto-generated method
		// stub

		// 创建和分配任务需要在四个表中插入数据：随访任务表、随访任务分配表、随访任务和随访内容模板关系表、随访任务和患者关系表

		// 1.生成随访任务表记录
		TFollowupTaskSimpleInfo taskInfo = createTaskInfo(req, taskId);
		dao.createFollowupTask(taskInfo);

		// 2.生成随访任务分配表记录
		setAssignInfo(req, taskId);
		dao.createFollowupTaskAssign(req.getTaskAssignList());

		// 3.生成随访任务和内容模板关系表记录
		if (req.getContentTemplateList() != null) {
			List<TFollowupTaskContentTemplateRelation> taskTemplateList = createFollowupTaskContentTemplateRelation(req, taskId);
			dao.createFollowupTaskContentTemplate(taskTemplateList);

		}
		return taskId;
	}

	private List<TFollowupTaskContentTemplateRelation> createFollowupTaskContentTemplateRelation(TFollowupTaskCreateReq req, String taskId) {
		// TODO Auto-generated method
		// stub
		List<TFollowupTaskContentTemplateRelation> taskTemplateList = new ArrayList<TFollowupTaskContentTemplateRelation>();
		for (TFollowupContentTemplateSimpleInfo contentTemplate : req.getContentTemplateList()) {
			TFollowupTaskContentTemplateRelation r = new TFollowupTaskContentTemplateRelation();
			r.setContentTemplateId(contentTemplate.getContentTemplateId());
			r.setContentTemplateType(contentTemplate.getContentTemplateType());
			r.setFollowupTaskId(taskId);
			taskTemplateList.add(r);
		}
		return taskTemplateList;
	}

	private void setAssignInfo(TFollowupTaskCreateReq req, String taskId) {
		// TODO Auto-generated method
		// stub

		for (TFollowupTaskAssign assign : req.getTaskAssignList()) {
			String assignId = GeneralUtil.generateUniqueID("ASSIGN");
			assign.setFollowupAssignId(assignId);
			assign.setFollowupTaskId(taskId);

		}

		return;
	}

	private TFollowupTaskSimpleInfo createTaskInfo(TFollowupTaskCreateReq req, String taskId) {
		// TODO Auto-generated method
		// stub
		TFollowupTaskSimpleInfo taskInfo = new TFollowupTaskSimpleInfo();
		taskInfo.setFollowupTaskId(taskId);
		taskInfo.setFollowupTaskName(req.getFollowupTaskName());
		taskInfo.setPlanFinishTime(req.getPlanFinishTime());
		taskInfo.setCreator(userDao.getDoctorId(req.getUserId()));
		taskInfo.setTotalPatientNum(req.getTotalPatientNum());
		taskInfo.setDiseaseTypeId(req.getDiseaseTypeId());
		taskInfo.setOperatorNum(req.getTaskAssignList().size());
		return taskInfo;
	}

	private int getAssignPatientNum(List<TFollowupTaskAssign> taskAssignList) {
		// TODO Auto-generated method
		// stub
		int result = 0;
		for (TFollowupTaskAssign a : taskAssignList)
			result += a.getTotalPatientNum();
		return result;
	}

	/**
	 * 终止随访任务
	 */
	@Override
	public boolean stopFollowupTask(TFollowupTaskStopReq req) {

		if (req.getTaskId() == null)
			return false;

		/*
		 * for(String
		 * taskId:req.getTaskId()){
		 * Integer isCreator =
		 * dao.queryFollowupTaskCreator
		 * (req.getUserId(),taskId);
		 * if(isCreator!=null &&
		 * isCreator.intValue()>0) { }
		 * else{ LogUtil.logError.error(
		 * "stopFollowupTask failed! The userId "
		 * + req.getUserId()+
		 * " should be the creator of the task "
		 * +taskId); return false; } }
		 */// 先不做角色判断

		// 终止任务
		dao.stopFollowupTask(req.getTaskId());

		return true;
	}

	/**
	 * 随访任务进行中
	 */
	@Override
	public void underwayFollowupTask(String followupTaskId, String followupAssignId) {
		TFollowupTaskSimpleInfo taskInfo = new TFollowupTaskSimpleInfo();
		taskInfo.setFollowupTaskId(followupTaskId);
		taskInfo.setState(1);
		dao.updateFollowupTask(taskInfo);

		TFollowupTaskAssign taskAssignInfo = new TFollowupTaskAssign();
		taskAssignInfo.setFollowupAssignId(followupAssignId);
		taskAssignInfo.setState(1);
		dao.updateFollowupTaskAssign(taskAssignInfo);
	}

	@Override
	public List<FollowupTask> getMetaInfoFollowupTaskList() {
		// TODO Auto-generated method
		// stub
		return dao.queryMetaFollowupTaskList();
	}

	/**
	 * 随访任务创建和分配
	 * 
	 * @throws ParamMismatchExcption
	 */
	@Override
	public void updateFollowupTask(TFollowupTaskSimpleInfo req) throws ParamMismatchExcption {
		if (req != null) {
			if (req.getFollowupTaskId() != null) {
				dao.updateFollowupTask(req);
			}
		}
	}

	/**
	 * 
	 * @author fanpanwei
	 * @date 2016年12月1日
	 * @param
	 * @description: 
	 *               根具带随访患者反查，最后随访各患者的随访员列表即其随访人数
	 * @return
	 */
	@Override
	public List<HashMap<String, Object>> getOperatorsFollowUpInfoByPatients(FollowupTaskOperatorAlloPatientReq req) {
		// TODO Auto-generated method
		// stub
		List<HashMap<String, Object>> epigoneInfoList = new ArrayList<HashMap<String, Object>>();
		// req.getConditionId();
		// req.getOperators();
		// req.getPatientIdList();
		// req.getSearchId();
		// req.getTaskPatientCount();
		List<Long> patientIdList = req.getPatientIdList();
		List<Long> operatorsList = req.getOperators();

		boolean patientListExist = false;
		if (patientIdList != null && patientIdList.size() > 0)
			patientListExist = true;
		SearchInfo searchInfo;// = null;
		if (!patientListExist) {// 没传患者的情况，查所有患者
			searchInfo = new SearchInfo();
			searchInfo = this.searchDao.querySearchById(req.getSearchId());

			req.setSearchTableName(searchInfo.getSearchTableName());
			req.setSearchColumnName(searchInfo.getSearchColumn());
		}

		/*
		 * if(operatorsList!=null&&
		 * operatorsList.size()>0){
		 * //1、当operatorsList不为空时
		 * ，表示是查指定随访医生下的追随患者数
		 * if(patientListExist){
		 * //1.1、表示查指定患者中追随指定医生的人数
		 * //查取指定患者中有追随患者的医生及其追随信息
		 * epigoneInfoList =
		 * this.dao.queryEpigoneInfoByDOrP
		 * (req);
		 * }else{//1.2、表示查所有患者中追随指定医生的人数
		 * //查取所有患者中有追随患者的医生及其追随信息 }
		 * 
		 * }else{//2、当operatorsList是空，
		 * 表示查患者要追随的医生
		 * 
		 * if(patientListExist){
		 * //2.1、表示查指定患者的要追随的医生
		 * epigoneInfoList =
		 * this.dao.queryEpigoneInfoByDOrP
		 * (req);
		 * }else{//2.2、表示查所有患者要追随的医生
		 * 
		 * } }
		 */
		epigoneInfoList = this.dao.queryEpigoneInfoByDOrP(req);
		return epigoneInfoList;
	}

}

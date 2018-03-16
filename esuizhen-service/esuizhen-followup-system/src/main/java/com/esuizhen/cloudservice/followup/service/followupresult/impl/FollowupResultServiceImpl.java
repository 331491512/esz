package com.esuizhen.cloudservice.followup.service.followupresult.impl;

import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupPatientInfo;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDeleteReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultHistoryQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.followup.dao.followup.FollowupPlanDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupResultWayDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupTaskPatientDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.TVarPatientFollowupTobDao;
import com.esuizhen.cloudservice.followup.dao.followuptask.FollowupTaskDao;
import com.esuizhen.cloudservice.followup.dao.meta.FollowupMetaInfoDao;
import com.esuizhen.cloudservice.followup.dao.user.DoctorDao;
import com.esuizhen.cloudservice.followup.dao.user.PatientDao;
import com.esuizhen.cloudservice.followup.dao.user.UserDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupTaskPatient;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssign;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskDetailInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskSimpleInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupOperatorInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.model.meta.FollowupWay;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupResultLogService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupSmsResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupWxResultService;
import com.esuizhen.cloudservice.followup.service.followuptask.FollowupTaskService;
import com.esuizhen.cloudservice.followup.util.MathExtend;
import com.esuizhen.cloudservice.followup.util.MyHttpUtil;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.followup.TVarPatientFollowup;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.dao.search.SearchDao;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.TimerTaskFactoryService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
public class FollowupResultServiceImpl implements FollowupResultService {

	@Autowired
	private FollowupResultWayDao followupResultDao;

	@Autowired
	private TVarPatientFollowupTobDao varPatientFollowupDao;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private FollowupTaskDao followupTaskDao;

	@Autowired
	private FollowupPlanDao followupPlanDao;

	@Autowired
	private FollowupTaskPatientDao followupTaskPatientDao;

	@Autowired

	private FollowupMetaInfoDao followupMetaInfoDao;
	
	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;
	@Autowired
	private FollowupWxResultService followupWxResultService;

	@Autowired
	private FollowupSmsResultService followupSmsResultService;

	@Autowired
	private TimerTaskFactoryService timerTaskFactoryService;

	@Autowired
	private FollowupTaskService followupTaskService;
	
	@Autowired
	private FollowupResultLogService followupResultLogService;

	@Value("${local.url}")
	private String localUrl;
	
	@Autowired
	private SearchDao searchDao;

	@Override
	public Page<TFollowupResultDetailInfo> queryFollowupResultHistory(Map<String, Object> searchParams, Integer page, Integer num) {
		PageHelper.startPage(page + 1, num);
		List<TFollowupResultDetailInfo> list = followupResultDao.queryFollowupResultHistory(searchParams);
//		for(int i = 0; i < list.size(); i++){
//			long patientId = list.get(i).getPatientId();
//			String taskId = list.get(i).getFollowupTaskId();
//		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultDetailInfo>) list);
	}

	@Override
	public List<TFollowupResultDetailInfo> queryFollowupResultHistory(Map<String, Object> searchParams) {
		List<TFollowupResultDetailInfo> list = followupResultDao.queryFollowupResultHistory(searchParams);
		return list;
	}

	@Override
	public void insertFollowupResultBuff(TFollowupResultDetailInfo followupResultDetailInfo) {
		if (followupResultDetailInfo == null)
			throw new EmptyParamExcption(" param error followupResultDetailInfo is null");
		if (followupResultDetailInfo.getPatientId() == null)
			throw new EmptyParamExcption(" param error patientId is null");

		//如果当前随访暂存结果的FollowupResultId不为空，则查询患者任务下所有随访暂存结果,将FollowupResultId设置为空
		if(UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupResultId())){
			Map<String, Object> searchParams = new HashMap<String, Object>();
//			searchParams.put("followupTaskId", followupResultDetailInfo.getFollowupTaskId());
//			searchParams.put("followupAssignId", followupResultDetailInfo.getFollowupAssignId());
//			searchParams.put("patientId", followupResultDetailInfo.getPatientId());
			searchParams.put("followupResultId", followupResultDetailInfo.getFollowupResultId());
			List<TFollowupResultDetailInfo> followupResultDetailList = followupResultDao.queryFollowupResultBuff(searchParams);
			
			TFollowupResultDetailInfo temp=null;
			for(TFollowupResultDetailInfo info:followupResultDetailList){
				temp=new TFollowupResultDetailInfo();
				temp.setFollowupResultBuffId(info.getFollowupResultBuffId());
				temp.setFollowupResultId("");
				this.updateFollowupResultBuff(temp);
			}
		}
		
		followupResultDetailInfo.setFollowupResultBuffId(GeneralUtil.generatorUUID("RBUFF"));
		this.followupResultDao.insertFollowupResultBuff(followupResultDetailInfo);
	}

	@Override
	public void updateFollowupResultBuff(TFollowupResultDetailInfo followupResultDetailInfo) {
		this.followupResultDao.updateFollowupResultBuff(followupResultDetailInfo);
	}

	@Override
	public void insertFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo) {
		if (followupResultDetailInfo == null)
			throw new EmptyParamExcption(" param error followupResultDetailInfo is null");

		Long patientId=followupResultDetailInfo.getPatientId();
		if (patientId == null)
			throw new EmptyParamExcption(" param error patientId is null");

		//死亡时间自动估算控制
		if(followupResultDetailInfo.getFollowupResultState()==2){
			TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
			Integer autoGuessDiedFlag=globalConfig.getAutoGuessDiedFlag();
			if(autoGuessDiedFlag==1 && followupResultDetailInfo.getFollowupResultValue()==4
					&&UtilValidate.isEmpty(followupResultDetailInfo.getDeathDate())){
				if(UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime()))followupResultDetailInfo.setFollowupTime(new Date());
				Date latestTouchDate = varPatientFollowupDao.queryLatestTouchDate(followupResultDetailInfo.getPatientId());
				Date deathDate = this.calculateDeathDate(followupResultDetailInfo.getDeathDate(), latestTouchDate,followupResultDetailInfo.getFollowupTime());
				followupResultDetailInfo.setDeathDate(deathDate);
			}
		}
		//标识默认为正式
		if(UtilValidate.isEmpty(followupResultDetailInfo.getFollowupResultState())){
			followupResultDetailInfo.setFollowupResultState(2);//正式结果
		}
		
		// 更新任务状态为进行中
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupAssignId())) {
			followupTaskService.underwayFollowupTask(followupResultDetailInfo.getFollowupTaskId(), followupResultDetailInfo.getFollowupAssignId());
		}

		// 保存失访状态
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupFlag()) && followupResultDetailInfo.getFollowupFlag() == 2) {// 失访标识
			followupResultDetailInfo.setFollowupFlag(1);
			this.patientDao.savePatientFollowupFlag(patientId, 2, followupResultDetailInfo.getLostFollowupCauseResultValue(),followupResultDetailInfo.getLostFollowupCause(), new Date());
		} else if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupFlag()) && followupResultDetailInfo.getFollowupFlag() == 1) {
			followupResultDetailInfo.setFollowupFlag(0);
			this.patientDao.savePatientFollowupFlag(patientId, 1, null, null, null);// 患者随访标识为能随访
		}
		followupResultDetailInfo.setFollowupResultId(GeneralUtil.generatorUUID("RESU"));
		this.followupResultDao.insertFollowupResult(followupResultDetailInfo);

		// 动态保存随访信息
		saveVarPatientFollowup(patientId, followupResultDetailInfo);
		
		// 根据随访结果更新患者
		this.updatePatientByFollowupResult(patientId,followupResultDetailInfo);

		// 根据条件更新任务完成状态
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupAssignId())) {
			this.completeFollowupTask(followupResultDetailInfo.getFollowupTaskId(), followupResultDetailInfo.getFollowupAssignId());
			//手工增加随访结果，如果该患者已经在任务中，应该把r_followup_task_patient表中的状态改成已完成状态
			TFollowupTaskPatient taskPatient = new TFollowupTaskPatient();
			taskPatient.setFollowupTaskId(followupResultDetailInfo.getFollowupTaskId());
			taskPatient.setFollowupAssignId(followupResultDetailInfo.getFollowupAssignId());
			taskPatient.setPatientId(patientId);
			taskPatient.setState(2);
			followupTaskPatientDao.updateFollowupTaskPatient(taskPatient);
		}
	}

	@Override
	public void updateFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo) {
		Long patientId=followupResultDetailInfo.getPatientId();
		//死亡时间自动估算控制
		if(followupResultDetailInfo.getFollowupResultState()==2){
			TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
			Integer autoGuessDiedFlag=globalConfig.getAutoGuessDiedFlag();
			if(autoGuessDiedFlag==1 && followupResultDetailInfo.getFollowupResultValue()==4
					&&UtilValidate.isEmpty(followupResultDetailInfo.getDeathDate())){
				if(UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime()))followupResultDetailInfo.setFollowupTime(new Date());
				Date latestTouchDate = varPatientFollowupDao.queryLatestTouchDate(followupResultDetailInfo.getPatientId());
				Date deathDate = this.calculateDeathDate(followupResultDetailInfo.getDeathDate(), latestTouchDate,followupResultDetailInfo.getFollowupTime());
				followupResultDetailInfo.setDeathDate(deathDate);
			}
		}
		// 保存失访状态
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupFlag()) && followupResultDetailInfo.getFollowupFlag() == 2) {// 失访标识
			followupResultDetailInfo.setFollowupFlag(1);
			this.patientDao.savePatientFollowupFlag(patientId, 2, followupResultDetailInfo.getLostFollowupCauseResultValue(),
					followupResultDetailInfo.getLostFollowupCause(), new Date());
		} else if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupFlag()) && followupResultDetailInfo.getFollowupFlag() == 1) {
			followupResultDetailInfo.setFollowupFlag(0);
			this.patientDao.savePatientFollowupFlag(patientId, 1, null, null, null);// 患者随访标识为能随访
		}

		this.followupResultDao.updateFollowupResult(followupResultDetailInfo);
		// 动态保存随访信息
		saveVarPatientFollowup(patientId, followupResultDetailInfo);
		// 根据随访结果更新患者
		this.updatePatientByFollowupResult(patientId,followupResultDetailInfo);
		
		// 根据条件更新任务完成状态
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupAssignId())) {
			this.completeFollowupTask(followupResultDetailInfo.getFollowupTaskId(), followupResultDetailInfo.getFollowupAssignId());
		}
	}

	@Override
	public void saveVarPatientFollowup(Long patientId, TFollowupResultDetailInfo followupResultDetailInfo) {
		// 动态保存随访信息
		TVarPatientFollowup varPatientFollowup = varPatientFollowupDao.queryVarPatientFollowupByPatientId(patientId);
		varPatientFollowup = setVarPatientFollowup(patientId, followupResultDetailInfo, varPatientFollowup);
		Date currFollowupTime=followupResultDetailInfo.getFollowupTime();
		if (UtilValidate.isNotEmpty(varPatientFollowup) && UtilValidate.isNotEmpty(varPatientFollowup.getId())) {
			Date varFollowupTime=varPatientFollowup.getLatestFollowupTime();
			if(null != currFollowupTime && null != varFollowupTime && currFollowupTime.getTime() >= varFollowupTime.getTime()){
				varPatientFollowupDao.updateVarPatientFollowup(varPatientFollowup);
			}
		} else {
			varPatientFollowupDao.insertVarPatientFollowup(varPatientFollowup);
		}
	}

	public TVarPatientFollowup setVarPatientFollowup(Long patientId, TFollowupResultDetailInfo followupResultDetailInfo, TVarPatientFollowup varPatientFollowup) {
		Integer followupResultValue = followupResultDetailInfo.getFollowupResultValue();
		String followupTaskId = followupResultDetailInfo.getFollowupTaskId();
		
		LinkedHashMap<String, Object> patientMap = userDao.queryUserInfoByPatientId(patientId);

		if (UtilValidate.isEmpty(varPatientFollowup)) {
			varPatientFollowup = new TVarPatientFollowup();
		}

		// 将随访结果传参赋值给动态随访结果
		BeanUtils.copyProperties(followupResultDetailInfo, varPatientFollowup);
		varPatientFollowup.setFollowupRemark(followupResultDetailInfo.getRemark());
		varPatientFollowup.setSmsSendTime(followupResultDetailInfo.getSendTime());
		varPatientFollowup.setSmsReplyContent(followupResultDetailInfo.getReplyContent());
		//没有暂存标识则默认为2（1：暂存；2:正式；）
		if(UtilValidate.isEmpty(followupResultDetailInfo.getFollowupResultState()) || 1!=followupResultDetailInfo.getFollowupResultState()){
			varPatientFollowup.setFollowupResultState(2);
		}
		if(UtilValidate.isNotEmpty(followupResultDetailInfo.getOperator())){
			FollowupOperatorInfo followupOperatorInfo=followupMetaInfoDao.getFollowupOperatorById(followupResultDetailInfo.getOperator());
			varPatientFollowup.setFollowupOperator(followupResultDetailInfo.getOperator());
			varPatientFollowup.setFollowupOperatorName(followupOperatorInfo.getOperatorName());
		}
		if(UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupWay())){
			FollowupWay followupWay=followupMetaInfoDao.getMetaInfoFollowupWayById(followupResultDetailInfo.getFollowupWay());
			varPatientFollowup.setFollowupWay(followupResultDetailInfo.getFollowupWay());
			varPatientFollowup.setFollowupWayName(followupWay.getFollowupWayName());
		}
		
		Map<String, Object> resultDetailMap = null;

		if (UtilValidate.isNotEmpty(followupTaskId)) {
			resultDetailMap = this.followupResultDao.getFollowupTaskNameById(followupTaskId);
			if(UtilValidate.isNotEmpty(varPatientFollowup)){
				varPatientFollowup.setFollowupTaskName((String) resultDetailMap.get("followupTaskName"));
			}
		}

		// 动态保存随访信息
		varPatientFollowup.setPatientId(patientId);
		varPatientFollowup.setFollowupState(1);
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupTime())) {
			varPatientFollowup.setLatestFollowupTime(followupResultDetailInfo.getFollowupTime());
		} else {
			varPatientFollowup.setLatestFollowupTime(new Date());
		}

		if (followupResultDetailInfo.getFollowupResultValue() == 4) {// 死亡
			// 已结束
			varPatientFollowup.setFollowupState(2);
		}
		
		if(UtilValidate.isNotEmpty(followupResultValue)){
			// 已结束
			varPatientFollowup.setFollowupState(2);
		}
		
		// 是否分配
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupAssignId())) {
			varPatientFollowup.setFollowupAssignFlag(1);
		} else {
			varPatientFollowup.setFollowupAssignFlag(2);
		}

		// 当前随访结果反馈时间
		varPatientFollowup.setLatestFollowupFeedbackTime(new Date());

		// 随访结果
		varPatientFollowup.setFollowupResultValue(followupResultValue);

		// 确诊时间
		try {
			// 随访结果元数据
			FollowupResultValue metaFollowupResultValue = followupMetaInfoDao.getMetaInfoFollowupResultValueById(followupResultValue);
			Integer resultValidType = metaFollowupResultValue.getType();
			
			TFollowupResultDetailInfo temp1=followupResultDao.queryFollowupResultById(followupResultDetailInfo.getFollowupResultId());
			if (resultValidType == 1 && UtilValidate.isNotEmpty(temp1.getFollowupResultState()) && temp1.getFollowupResultState()==2) {
				varPatientFollowup.setFollowupValidResultValue(followupResultDetailInfo.getFollowupResultValue());
				varPatientFollowup.setLatestValidFollowupTime(followupResultDetailInfo.getFollowupTime());
				
				varPatientFollowup.setValidFollowupOperator(followupResultDetailInfo.getOperator());
				varPatientFollowup.setValidFollowupOperatorName(followupResultDetailInfo.getOperatorName());
				varPatientFollowup.setValidFollowupWay(followupResultDetailInfo.getFollowupWay());
				varPatientFollowup.setValidFollowupWayName(followupResultDetailInfo.getFollowupWayName());
				
				Date confirmedDate = (Date) patientMap.get("confirmedDate");
				if (UtilValidate.isNotEmpty(confirmedDate)) {
					Integer liveDay = 0;
					if (followupResultDetailInfo.getFollowupResultValue() == 4) {
						Date deathDate = this.calculateDeathDate(followupResultDetailInfo.getDeathDate(), followupResultDetailInfo.getFollowupTime());
						liveDay = DateUtil.daysBetween(confirmedDate, deathDate);
					} else {
						liveDay = DateUtil.daysBetween(confirmedDate, varPatientFollowup.getLatestValidFollowupTime());
					}
					// 生存时间公式
					String strMonth = (liveDay / 365.25) * 12 + "";
					strMonth = MathExtend.round(strMonth, 2);
					varPatientFollowup.setLiveDay(liveDay);
					varPatientFollowup.setLiveMonth(Float.valueOf(strMonth));
				}else{
					varPatientFollowup.setLiveDay(0);
					varPatientFollowup.setLiveMonth(Float.valueOf(0));
				}
			} else {
				varPatientFollowup.setLiveDay(0);
				varPatientFollowup.setLiveMonth(Float.valueOf(0));
			}
		} catch (ParseException e) {
			LogUtil.log.error("[生存时间计算出错：]" + e.getMessage());
			e.printStackTrace();
		}
		return varPatientFollowup;
	}

	/*
	 * 短信、微信结果入库规则
	 */
	@Override
	public TFollowupResultDetailInfo storeRuleFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo) {
		if (followupResultDetailInfo == null)
			throw new EmptyParamExcption(" param error followupResultDetailInfo is null");
		if (StringUtils.isEmpty(followupResultDetailInfo.getFollowupAssignId()))
			throw new EmptyParamExcption(" param error followupAssignId is null");
		if (followupResultDetailInfo.getPatientId() == null)
			throw new EmptyParamExcption(" param error patientId is null");
		if (followupResultDetailInfo.getFollowupResultValue() == null)
			throw new EmptyParamExcption(" param error followupResultValue is null");

		
		//随访全局配置
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		
		//死亡时间自动估算控制
		Integer autoGuessDiedFlag=globalConfig.getAutoGuessDiedFlag();
		if(autoGuessDiedFlag==1 && followupResultDetailInfo.getFollowupResultValue()==4
				&&UtilValidate.isEmpty(followupResultDetailInfo.getDeathDate())){
			Date deathDate=null;
			Date latestTouchDate = varPatientFollowupDao.queryLatestTouchDate(followupResultDetailInfo.getPatientId());
			if(UtilValidate.isNotEmpty(latestTouchDate)){
				Date replyDate=null;
				if(UtilValidate.isNotEmpty(followupResultDetailInfo.getReplyTime())){
					replyDate=followupResultDetailInfo.getReplyTime();
				}else replyDate=new Date();
				deathDate=this.calculateDeathDate(followupResultDetailInfo.getDeathDate(),latestTouchDate,replyDate);
			}else deathDate=new Date();
			followupResultDetailInfo.setDeathDate(deathDate);
		}

		String followupTaskId = followupResultDetailInfo.getFollowupTaskId();
		String followupAssignId = followupResultDetailInfo.getFollowupAssignId();
		Integer followupWay = followupResultDetailInfo.getFollowupWay();

		Long patientId = followupResultDetailInfo.getPatientId();
		if (UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime())) {
			followupResultDetailInfo.setFollowupTime(new Date());
		}

		// 查询患者随访关系表
		TFollowupTaskPatient followupTaskPatient = followupTaskPatientDao.queryFollowupTaskByPatientId(followupTaskId, followupAssignId, patientId);
		Long operator = followupTaskPatient.getOperator();
		followupResultDetailInfo.setOperator(operator);

		// 更新患者随访关系表
		followupTaskPatient.setState(2);// 随访已完成
		if (followupWay == Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS) {
			followupTaskPatient.setSmsState(3);// 已回复
		} else if (followupWay == Constant.FOLLOWUPWAY.FOLLOWUPWAY_WX) {
			followupTaskPatient.setWxState(3);// 已回复
		}
		followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);

		// 同步设置默认标识
		if (followupWay == Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS) {
			followupResultDetailInfo.setSyncFlag(0);// 未同步
			followupResultDetailInfo.setSourceFlag(1);// 数据来源标识B端填写
		}

		// 查询随访结果
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("followupTaskId", followupTaskId);
		searchParams.put("followupAssignId", followupAssignId);
		searchParams.put("patientId", patientId);
		List<TFollowupResultDetailInfo> followupResultDetailList = followupResultDao.queryFollowupResult(searchParams);

		// 按照"无<短信<微信<电话"的规则保存
		followupResultDetailInfo.setFollowupResultState(2);
		if (UtilValidate.isNotEmpty(followupResultDetailList)) {
			TFollowupResultDetailInfo temp = followupResultDetailList.get(0);
			followupResultDetailInfo.setFollowupResultId(temp.getFollowupResultId());
			
			//是否是暂存记录
			if(1==temp.getFollowupResultState()){

				updateFollowupResult(followupResultDetailInfo);
			}else if (temp.getFollowupResultType() == 2) {//无效结果优先被覆盖
				//根据全局配置开启设置后，保存的电话结果为无效结果时，仍然可以点击进入拨打电话(followupResultFlag 0:关闭。1：开启)
				Integer validResultControlFlag=globalConfig.getValidResultControlFlag();
				if(validResultControlFlag==1){
					updateFollowupResult(followupResultDetailInfo);
				}
			}else{
				//根据全局配置判断是否保存(followupResultFlag 0:不再更新。1：根据规则更新)
				Integer followupResultFlag=globalConfig.getFollowupResultFlag();
				
				if(followupResultFlag==0){
					followupResultDetailInfo.setFollowupResultId(null);//设置FollowupResultId为空，作为暂存记录
				}else{
					//根据规则更新
					if(temp.getFollowupWay() == followupWay) {
						updateFollowupResult(followupResultDetailInfo);
					} else if (temp.getFollowupWay() == Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS) {
						updateFollowupResult(followupResultDetailInfo);
					} else if (temp.getFollowupWay() == Constant.FOLLOWUPWAY.FOLLOWUPWAY_WX && followupWay != Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS) {
						updateFollowupResult(followupResultDetailInfo);
					}
				}

			}
			
		} else {
			// 如果没有该用户此次随访结果则保存
			insertFollowupResult(followupResultDetailInfo);
		}

		// 插入暂存表
		searchParams.put("followUpWay", followupWay);
		List<TFollowupResultDetailInfo> followupResultBuffDetailList = null;
		TFollowupResultDetailInfo oldFollowupResult=null;
		//add by fanpanwei 1表示是短信解析修改
		Integer followupResultBySmsFlag = followupResultDetailInfo.getFollowupResultBySmsFlag();
		boolean logFlag=true;
		if(followupResultBySmsFlag!=null&&followupResultBySmsFlag==1){
			followupResultBuffDetailList=followupResultDao.queryFollowupResultBuff(searchParams);
			if (UtilValidate.isNotEmpty(followupResultBuffDetailList)) {
				//短信解析修改时：修改最后一条短信buffer记录
				oldFollowupResult=followupResultBuffDetailList.get(0);
				followupResultDetailInfo.setFollowupResultBuffId(oldFollowupResult.getFollowupResultBuffId());
				followupResultDao.deleteFollowupResultBuff(oldFollowupResult.getFollowupResultBuffId());
				if(followupResultDetailInfo.getUpdateOperator()!=null&&StringUtils.isBlank(followupResultDetailInfo.getOperatorName())){
					Doctor doctor = doctorDao.getDoctorById(followupResultDetailInfo.getUpdateOperator());
					if(doctor!=null)
						followupResultDetailInfo.setUpdateOperatorName(doctor.getTrueName());
				}
			}else{
				logFlag=false;
				followupResultDetailInfo.setFollowupResultState(2);//正式
			}
		}else {
			followupResultDetailInfo.setFollowupResultState(2);//正式
		}
		insertFollowupResultBuff(followupResultDetailInfo);
		// 回填结果ID及暂存ID
		followupResultDetailList = followupResultDao.queryFollowupResult(searchParams);
		followupResultBuffDetailList = followupResultDao.queryFollowupResultBuff(searchParams);
		if (UtilValidate.isNotEmpty(followupResultDetailList)) {
			followupResultDetailInfo.setFollowupResultId(followupResultDetailList.get(0).getFollowupResultId());
		}
		if (UtilValidate.isNotEmpty(followupResultDetailList)) {
			followupResultDetailInfo.setFollowupResultBuffId(followupResultBuffDetailList.get(0).getFollowupResultBuffId());
		}
		//add by fanpanwei 当时短信解析修改时：记录日志
		if(logFlag&&followupResultBySmsFlag!=null&&followupResultBySmsFlag==1){
			followupResultBuffDetailList.get(0).setUpdateOperator(followupResultDetailInfo.getUpdateOperator());
			followupResultBuffDetailList.get(0).setUpdateOperatorName(followupResultDetailInfo.getUpdateOperatorName());
			followupResultLogService.saveFollowupResultLog(oldFollowupResult,followupResultBuffDetailList.get(0),3);
		}
		
		return followupResultDetailInfo;

	}

	/*
	 * 同步TOC结果入库规则
	 */
	@Override
	public void storeRuleSyncFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo) {
		if (followupResultDetailInfo == null)
			throw new EmptyParamExcption(" param error followupResultDetailInfo is null");
		if (followupResultDetailInfo.getPatientId() == null)
			throw new EmptyParamExcption(" param error patientId is null");
		if (followupResultDetailInfo.getFollowupResultValue() == null)
			throw new EmptyParamExcption(" param error followupResultValue is null");


		//随访全局配置
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		
		//死亡时间自动估算控制
		Integer autoGuessDiedFlag=globalConfig.getAutoGuessDiedFlag();
		if(autoGuessDiedFlag==1 && followupResultDetailInfo.getFollowupResultValue()==4
				&&UtilValidate.isEmpty(followupResultDetailInfo.getDeathDate())){
			Date deathDate=null;
			Date latestTouchDate = varPatientFollowupDao.queryLatestTouchDate(followupResultDetailInfo.getPatientId());
			if(UtilValidate.isNotEmpty(latestTouchDate)){
				Date replyDate=null;
				if(UtilValidate.isNotEmpty(followupResultDetailInfo.getReplyTime())){
					replyDate=followupResultDetailInfo.getReplyTime();
				}else replyDate=new Date();
				deathDate=this.calculateDeathDate(followupResultDetailInfo.getDeathDate(),latestTouchDate,replyDate);
			}else deathDate=new Date();
			followupResultDetailInfo.setDeathDate(deathDate);
		}
				

		String followupTaskId = followupResultDetailInfo.getFollowupTaskId();
		String followupAssignId = followupResultDetailInfo.getFollowupAssignId();
		Integer followupWay = followupResultDetailInfo.getFollowupWay();

		Long patientId = followupResultDetailInfo.getPatientId();
		if (UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime())) {
			followupResultDetailInfo.setFollowupTime(new Date());
		}

		// 查询患者随访关系表
		if (UtilValidate.isNotEmpty(followupTaskId) && UtilValidate.isNotEmpty(followupAssignId)) {
			TFollowupTaskPatient followupTaskPatient = followupTaskPatientDao.queryFollowupTaskByPatientId(followupTaskId, followupAssignId, patientId);
			if (UtilValidate.isNotEmpty(followupTaskPatient)) {
				Long operator = followupTaskPatient.getOperator();
				followupResultDetailInfo.setOperator(operator);
				// 更新患者随访关系表
				followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);
			}
		}

		// 查询随访结果
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("followupTaskId", followupTaskId);
		searchParams.put("followupAssignId", followupAssignId);
		searchParams.put("patientId", patientId);
		List<TFollowupResultDetailInfo> followupResultDetailList = followupResultDao.queryFollowupResult(searchParams);
		if (UtilValidate.isNotEmpty(followupResultDetailList)) {
			TFollowupResultDetailInfo temp = followupResultDetailList.get(0);
			followupResultDetailInfo.setFollowupResultId(temp.getFollowupResultId());

			
			// 按照"无<短信<微信<电话"的规则保存
			followupResultDetailInfo.setFollowupResultState(2);
			if(1==temp.getFollowupResultState()){

				updateFollowupResult(followupResultDetailInfo);
			}else if (temp.getFollowupResultType() == 2) {//无效结果优先被覆盖
				//根据全局配置开启设置后，保存的电话结果为无效结果时，仍然可以点击进入拨打电话(followupResultFlag 0:关闭。1：开启)
				Integer validResultControlFlag=globalConfig.getValidResultControlFlag();
				if(validResultControlFlag==1){
					updateFollowupResult(followupResultDetailInfo);
				}
			}else{
				//根据全局配置判断是否保存(followupResultFlag 0:不再更新。1：根据规则更新)
				Integer followupResultFlag=globalConfig.getFollowupResultFlag();
				if(followupResultFlag==0){
					followupResultDetailInfo.setFollowupResultId(null);//设置FollowupResultId为空，作为暂存记录
				}else{
					//根据规则更新
					if (temp.getFollowupWay() == followupWay) {
						updateFollowupResult(followupResultDetailInfo);
					} else if (temp.getFollowupWay() == Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS) {
						updateFollowupResult(followupResultDetailInfo);
					} else if (temp.getFollowupWay() == Constant.FOLLOWUPWAY.FOLLOWUPWAY_WX && followupWay != Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS) {
						updateFollowupResult(followupResultDetailInfo);
					} else if (temp.getFollowupWay() == Constant.FOLLOWUPWAY.FOLLOWUPWAY_APP && followupWay != Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS) {
						updateFollowupResult(followupResultDetailInfo);
					}
				}

			}
		} else {
			// 如果没有该用户此次随访结果则保存
			insertFollowupResult(followupResultDetailInfo);
		}

		insertFollowupResultBuff(followupResultDetailInfo);
	}

	/**
	 * 微信、短信回复
	 */
	@Override
	public void scanSmsReply() {
		// 调用短信接口获取回复结果
		String smsUrl = localUrl + "/sms/receipt/content/get";
		LogUtil.log.debug("[扫描短信回复smsUrl]:" + smsUrl);
		String messageJson = MyHttpUtil.httpGet(smsUrl);
		LogUtil.log.debug("[扫描短信回复Result]:" + messageJson);

		TMsgResponse<List<Map<String, Object>>> tMsgResponse = JsonUtil.toObject(messageJson, TMsgResponse.class);
		List<Map<String, Object>> smsItemList = tMsgResponse.getResult();

		// 短信赋值并操作随访结果
		if (UtilValidate.isNotEmpty(smsItemList)) {
			Map<String, Map<String, Object>> noRepeatMap=new HashMap<String, Map<String,Object>>();
			List<Map<String, Object>> repeatList=new ArrayList<Map<String,Object>>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String finalTime = null;
			String TempTime = null;		
			Date finalDate = null;
			Date TempDate = null;
			for (Map<String, Object> tempMap : smsItemList) {
				String fromMobile = (String) tempMap.get("fromMobile");
				if(noRepeatMap.containsKey(fromMobile)){
					Map<String, Object> finalMap = noRepeatMap.get(fromMobile);
					finalTime = (String) finalMap.get("recTime");
					TempTime = (String) tempMap.get("recTime");
					try {
						finalDate = sdf.parse(finalTime);
						TempDate = sdf.parse(TempTime);
					} catch (ParseException e) {
						continue;
						//e.printStackTrace();
					}
					if(finalDate.after(TempDate)){
						repeatList.add(finalMap);
						noRepeatMap.put(fromMobile, tempMap);
					}else{
						repeatList.add(tempMap);
					}
				}else noRepeatMap.put(fromMobile, tempMap);
			}
			if(UtilValidate.isEmpty(noRepeatMap))return;
			Set<String> keySet = noRepeatMap.keySet();
			Map<String, Object> smsItemMap = null;
			for (String keyStr : keySet) {
				smsItemMap=noRepeatMap.get(keyStr);
				LogUtil.log.debug("[本次扫描各手机号最早一条短信回复！]fromMobile:" + smsItemMap.get("fromMobile") + ",结果值为：" + smsItemMap.get("content"));
				this.followupSmsResultService.replySmsFollowupResult(smsItemMap);
			}
			if(repeatList==null||repeatList.size()==0||repeatList.get(0)==null)return;
			for (Map<String, Object> iteratorMap : repeatList) {
				LogUtil.log.debug("[本次扫描各手机号非最早一条短信回复！]fromMobile:" + iteratorMap.get("fromMobile") + ",结果值为：" + iteratorMap.get("content"));
				this.followupSmsResultService.replySmsFollowupResult(iteratorMap);
			}
		}
	}

	@Override
	public List<FollowupPatientInfo> queryPatientIdsByFollowupResult(FollowupMsgSendReq followupMsgSendReq) {
		return this.followupResultDao.queryPatientIdsByFollowupResult(followupMsgSendReq);
	}

	@Override
	public Integer queryHadWxRecordTotal(FollowupMsgSendReq followupMsgSendReq) {
		return this.followupResultDao.getHadWxRecordTotal(followupMsgSendReq);
	}
	@Override
	public Integer queryHadSmsRecordTotal(FollowupMsgSendReq followupMsgSendReq) {
		return this.followupResultDao.getHadSmsRecordTotal(followupMsgSendReq);
	}

	@Override
	public Integer queryPatientIdCountByFollowupResult(FollowupMsgSendReq followupMsgSendReq) {
		return this.followupResultDao.queryPatientIdCountByFollowupResult(followupMsgSendReq);
	}
	@Override
	public String getValidFollowupFlag(FollowupMsgSendReq followupMsgSendReq) {
		return this.followupResultDao.queryValidFollowupFlag(followupMsgSendReq);
	}
	@Override
	public void setFollowupNeedless(Long patientId,Integer searchId) {
		if(searchId != null) {
			// 查询search数据
			SearchInfo searchInfo = searchDao.querySearchById(searchId);
			if(searchInfo != null && StringUtils.isNotEmpty(searchInfo.getSearchTableName()) && StringUtils.isNotEmpty(searchInfo.getSearchColumn())) {
				Map<String,Object> searchMap = new HashMap<String,Object>();
				searchMap.put("searchTableName", searchInfo.getSearchTableName());
				searchMap.put("searchColumn", searchInfo.getSearchColumn());
				searchMap.put("patientId", patientId);
				this.patientDao.updateSearchTableInfo(searchMap);
			}
		}
		this.patientDao.savePatientFollowupFlag(patientId, 3, null, null, null);// 设置为无需随访
	}

	@Override
	public void completeFollowupTask(String followupTaskId, String followupAssignId) {
		// 任务分配状态
		int taskAssignCount = followupTaskDao.queryUnfinishedFollowupTaskAssignCount(followupAssignId);
		if (taskAssignCount == 0) {
			TFollowupTaskAssign taskAssignInfo = new TFollowupTaskAssign();
			taskAssignInfo.setFollowupAssignId(followupAssignId);
			taskAssignInfo.setState(2);// 已完成
			followupTaskDao.updateFollowupTaskAssign(taskAssignInfo);
		}

		// 任务状态
		int taskCount = followupTaskDao.queryUnfinishedFollowupTaskCount(followupTaskId);
		if (taskCount == 0) {
			TFollowupTaskSimpleInfo taskInfo = new TFollowupTaskSimpleInfo();
			taskInfo.setFollowupTaskId(followupTaskId);
			taskInfo.setState(2);// 已完成
			taskInfo.setFinishTime(new Date());
			followupTaskDao.updateFollowupTask(taskInfo);
		}
	}
	@Override
	public Date calculateDeathDate(Date deathDate, Date latestFollowupTime,Date replyDate) {
		try {
			if (UtilValidate.isNotEmpty(deathDate)) {
				return deathDate;
			}
			//与患者回复的时间做比较
			int day = DateUtil.daysBetween(latestFollowupTime, replyDate);
			day = day / 2;
			return DateUtil.getOffsetDate(latestFollowupTime, day);

		} catch (ParseException e) {
			LogUtil.log.error("【死亡时间计算错误】" + e.getMessage());
		}
		return null;
	}
	
	public Date calculateDeathDate(Date deathDate, Date latestFollowupTime) {
		try {
			if (UtilValidate.isNotEmpty(deathDate)) {
				return deathDate;
			}
			Date now=new Date();
			//与患者回复的时间做比较
			int day = DateUtil.daysBetween(latestFollowupTime, now);
			day = day / 2;
			return DateUtil.getOffsetDate(latestFollowupTime, day);

		} catch (ParseException e) {
			LogUtil.log.error("【死亡时间计算错误】" + e.getMessage());
		}
		return null;
	}
	@Override
	public TFollowupResultDetailInfo queryLastFollowupResultByPatientUuid(String patientUuid) {
		return this.followupResultDao.queryLastFollowupResultByPatientUuid(patientUuid);
	}
	
	//随访结果保存
	@Override
	public void createFollowupResult(FollowupResultReq req) {
		if(req.getOperator()==null||req.getPatientId()==null||req.getFollowupResultValue()==null || req.getHospitalId()==null ||req.getSourceFlag()==null)
			throw new EmptyParamExcption("param error; param:"+JsonUtil.toJson(req));
		TFollowupResultDetailInfo info  = new TFollowupResultDetailInfo();
		BeanUtils.copyProperties(req, info);
		info.setFollowupResultBuffId(GeneralUtil.generatorUUID("RBUFF"));
		//随访结果保存并验证
		updateFollowupResultToC(info);
	}

	@Override
	public Page queryFollowupResultFormalHistory(FollowupResultHistoryQueryReq req) {
		// TODO Auto-generated method stub
		if(req.getPage()==null)
			req.setPage(0);
		if(req.getNum()==null)
			req.setNum(10);
		if(req.getPatientId()==null)
			throw new EmptyParamExcption("Error : patientId IS NULL");
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TFollowupResultDetailInfo> list = followupResultDao.queryFollowupResultFormalHistory(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultDetailInfo>) list);
	}

	
	@Override
	public void updateFollowupResultToC(TFollowupResultDetailInfo followupResultBuff) {
		//随访结果判断
		Integer syncFlag = patientDao.queryPatientSyncFlagByPatientId(followupResultBuff.getPatientId());
		if(syncFlag==0)
			followupResultBuff.setFollowupResultId(GeneralUtil.generatorUUID("RESU"));
		//插入缓存表
		followupResultDao.insertFollowupResultBuff(followupResultBuff);
		//插入正式表
		if(syncFlag==0){
			followupResultDao.insertFollowupResult(followupResultBuff);
			try {
				updateTocVarPatientFollowup(followupResultBuff);
			} catch (Exception e) {
				LogUtil.logError.error("setTocVarPatientFollowup error :"+e.getMessage());
			}
		}
	}
	
	@Override
	public void updateTocVarPatientFollowup(TFollowupResultDetailInfo followupResult){
		if(followupResult.getPatientId()==null)
			throw new EmptyParamExcption("patientId is null");
		if(followupResult.getFollowupResultValue()==null)
			throw new EmptyParamExcption("followupResultValue is null");
		if(followupResult.getFollowupWay()==null)
			throw new EmptyParamExcption("followupWay is null");
		//获取动态结果
		TVarPatientFollowup varPatientFollowup = varPatientFollowupDao.queryVarPatientFollowupByPatientId(followupResult.getPatientId());
		LinkedHashMap<String, Object> patientMap= userDao.queryUserInfoByPatientId(followupResult.getPatientId());
		if(varPatientFollowup==null){
			//创建一条动态数据
			varPatientFollowup = new TVarPatientFollowup();
			// 动态保存随访信息
			varPatientFollowup = new TVarPatientFollowup();
			varPatientFollowup.setPatientId(followupResult.getPatientId());
			varPatientFollowup.setFollowupState(1);
			varPatientFollowup.setFollowupFlag(1);
			varPatientFollowup.setProjectFollowupState(1);
			varPatientFollowup.setLatestFollowupTime(new Date());
			varPatientFollowup.setConfirmedDate(DateUtil.getDateStr((Date)patientMap.get("confirmedDate")));
			varPatientFollowup.setCurrFollowupPerformDays(0);
		}
		//患者修改信息对象
		Patient patient = new Patient();
		patient.setPatientId(followupResult.getPatientId());
		FollowupResultValue resultValue = followupMetaInfoDao.getMetaInfoFollowupResultValueById(followupResult.getFollowupResultValue());
		
		//动态结果填写
		varPatientFollowup.setLatestFollowupTime(followupResult.getFollowupTime());
		varPatientFollowup.setFollowupResultValue(followupResult.getFollowupResultValue());
		//记录有效结果以及生存时间
		if(resultValue.getType()==1){
			varPatientFollowup.setLatestValidFollowupTime(followupResult.getFollowupTime());
			varPatientFollowup.setFollowupValidResultValue(followupResult.getFollowupResultValue());
			//生存时间确定
			Date confirmDate = (Date)patientMap.get("confirmedDate");
			int liveDay = 0;
			float liveMonth = 0l;
			if(confirmDate!=null&&confirmDate.getTime()<followupResult.getFollowupTime().getTime()){
				try {
					if (followupResult.getFollowupResultValue() == 4)
						liveDay = DateUtil.daysBetween(confirmDate, calculateDeathDate(followupResult.getDeathDate(), followupResult.getFollowupTime()));
					else
						liveDay = DateUtil.daysBetween(confirmDate, followupResult.getFollowupTime());
//					liveMonth = SurvivalUtil.calculateLiveMonth(liveDay);
				} catch (Exception e) {
					LogUtil.logError.error("calculation liveDay error " + e.getMessage());
				}
			}
			varPatientFollowup.setLiveDay(liveDay);
			varPatientFollowup.setLiveMonth(liveMonth);
		}
		//记录人员
		varPatientFollowup.setFollowupOperator(followupResult.getOperator());
		if(followupResult.getOperator()!=null){
			Doctor doctor = doctorDao.getDoctorById(followupResult.getOperator());
			if(doctor!=null)
				varPatientFollowup.setFollowupOperatorName(doctor.getTrueName());
		}
		//随访方式
		varPatientFollowup.setFollowupWay(followupResult.getFollowupWay());
		FollowupWay followupWay = followupMetaInfoDao.getMetaInfoFollowupWayByFollowupWayId(followupResult.getFollowupWay());
		if(followupWay!=null)
			varPatientFollowup.setFollowupWayName(followupWay.getFollowupWayName());
		//复发
		if(StringUtils.isNotEmpty(followupResult.getRelapseParts())){
			varPatientFollowup.setRelapseParts(followupResult.getRelapseParts());
			varPatientFollowup.setRelapseDate(followupResult.getRelapseDate());
		}
		//转移
		if(StringUtils.isNotEmpty(followupResult.getTransferParts())){
			varPatientFollowup.setTransferParts(followupResult.getTransferParts());
			varPatientFollowup.setTransferDate(followupResult.getTransferDate());
		}
		//判断是插 还是修改
		if(varPatientFollowup.getId()==null)
			varPatientFollowupDao.insertVarPatientFollowup(varPatientFollowup);
		else
			varPatientFollowupDao.updateVarPatientFollowup(varPatientFollowup);
		
		if(resultValue.getType()==2){
			patient.setFollowupFlag(2);
			patient.setLostFollowupCause(followupResult.getOtherCause());
			patient.setLostFollowupTime(followupResult.getFollowupTime());
		}
		else
			patient.setFollowupFlag(1);
		
		//更新患者信息
		if(followupResult.getFollowupResultValue()==4){
			StringBuffer deathCause = new StringBuffer("");
			patient.setLiveStatus(0);// 死亡
			patient.setDeathDate(calculateDeathDate(followupResult.getDeathDate(), followupResult.getFollowupTime()));
			patient.setIsInHospitalDeath(followupResult.getIsInHospitalDeath());
			patient.setIsTumourDeath(followupResult.getIsTumourDeath());

			if (followupResult.getIsInHospitalDeath()!=null) {
				if (1 == followupResult.getIsInHospitalDeath()) {
					deathCause.append("在院死亡");
				} else {
					deathCause.append("非在院死亡");
				}
			}
			if (followupResult.getIsTumourDeath()!=null) {
				if (1 == followupResult.getIsTumourDeath()) {
					deathCause.append("肿瘤死亡");
				} else {
					deathCause.append("非肿瘤死亡");
				}
			}
			patient.setDeathCause(deathCause.toString());
			patient.setFollowupFlag(0);
			//add by fanpanwei 终止患者随访计划
			followupPlanDao.updateFollowupPlanByPatientId(followupResult.getPatientId(), "2");
		}
		//更新患者表信息
		patientDao.updatePatientByFollowupResult(patient);
		
		// 取消定时任务
		String queryFollowupPlanId = followupPlanDao.queryFollowupPlanId(followupResult.getPatientId()+"");
		if(StringUtils.isNotBlank(queryFollowupPlanId)){
		Integer code = timerTaskFactoryService
					.cancelFollowupPlanTimerTask(queryFollowupPlanId);
		if (ErrorMessage.SUCCESS.code != code) {
			throw new RuntimeException("定时任务取消失败");
		}
	}
	}

	@Override
	public List<TFollowupResultDetailInfo> queryLastFollowupResultList(List<PatientSimpleInfo> params) {
		if (params == null || params.isEmpty()) {
			return null;
		}
		return this.followupResultDao.findLastFollowupResultList(params);
	}

	@Override
	public void updatePatientByFollowupResult(Long patientId,TFollowupResultDetailInfo followupResult){
		if(1==followupResult.getFollowupResultState())return;
		Patient patient=patientDao.queryPatientByPrimaryKey(patientId);
		//更新患者信息
		if(followupResult.getFollowupResultValue()==4){
			StringBuffer deathCause = new StringBuffer("");
			patient.setPatientId(patientId);
			patient.setLiveStatus(0);// 死亡
			patient.setDeathDate(calculateDeathDate(followupResult.getDeathDate(), followupResult.getFollowupTime()));
			patient.setIsInHospitalDeath(followupResult.getIsInHospitalDeath());
			patient.setIsTumourDeath(followupResult.getIsTumourDeath());

			if (followupResult.getIsInHospitalDeath()!=null) {
				if (1 == followupResult.getIsInHospitalDeath()) {
					deathCause.append("在院死亡");
				} else {
					deathCause.append("非在院死亡");
				}
			}
			if (followupResult.getIsTumourDeath()!=null) {
				if (1 == followupResult.getIsTumourDeath()) {
					deathCause.append("肿瘤死亡");
					patient.setUnderlyCausesOfDeath(patient.getSourceDiseaseCode()+patient.getSourceDiagnosis());
				} else {
					deathCause.append("非肿瘤死亡");
				}
			}
			patient.setDeathCause(deathCause.toString());
			patient.setFollowupFlag(0);
			// 全程诊疗 add by zhuguo
			if (null != followupResult.getWholeProcessFlag() && !"".equals(followupResult.getWholeProcessFlag())) {
				patient.setWholeProcessFlag(followupResult.getWholeProcessFlag());
			}
			
			//更新患者表信息
			patientDao.updatePatientByFollowupResult(patient);
		}else{
			//清空患者死亡相关标识
			if(patient.getLiveStatus()==0){
				patient.setLiveStatus(1);
				if(patient.getFollowupFlag()==0){
					patient.setFollowupFlag(1);
				}
				patient.setDeathDate(null);
				patient.setIsInHospitalDeath(null);
				patient.setIsTumourDeath(null);
				patient.setDeathCause(null);
			}
			// 全程诊疗 add by zhuguo
			if (null != followupResult.getWholeProcessFlag() && !"".equals(followupResult.getWholeProcessFlag())) {
				patient.setWholeProcessFlag(followupResult.getWholeProcessFlag());
			}
			
			patientDao.updatePatientByPrimaryKey(patient);
		}
		
	}
	
	@Transactional
	@Override
	public void saveFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo) {
		Long patientId=followupResultDetailInfo.getPatientId();
		// 保存随访结果
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupResultId())) {
			//查询已存在的随访结果
			TFollowupResultDetailInfo oldFollowupResult=followupResultDao.queryFollowupResultById(followupResultDetailInfo.getFollowupResultId());
			
			// 保存修改后的随访结果
			this.followupResultDao.updateFollowupResultNotSelective(followupResultDetailInfo);
			
			// 查询随访结果
			Map<String, Object> searchParams = new HashMap<String, Object>();
			searchParams.put("patientId", patientId);
			searchParams.put("followupResultValue",4);
			List<TFollowupResultDetailInfo> list=followupResultDao.queryFollowupResult(searchParams);
			if(followupResultDetailInfo.getFollowupResultValue()==4 || UtilValidate.isEmpty(list)){
				// 根据随访结果更新患者
				this.updatePatientByFollowupResult(patientId,followupResultDetailInfo);
			}
			
			// 动态保存随访信息
			saveVarPatientFollowup(patientId, followupResultDetailInfo);
			
			this.followupResultDao.updateFollowupResultBuffNotSelective(followupResultDetailInfo);
			
			//保存日志
			this.followupResultLogService.saveFollowupResultLog(oldFollowupResult, followupResultDetailInfo, 3);
		}else if(UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupResultBuffId())){
			//查询已存在的随访结果
			TFollowupResultDetailInfo oldFollowupResult=followupResultDao.queryFollowupResultBuffByPrimaryKey(followupResultDetailInfo.getFollowupResultBuffId());
			
			//修改随访缓存结果
			this.followupResultDao.updateFollowupResultBuffNotSelective(followupResultDetailInfo);
			
			//保存日志
			this.followupResultLogService.saveFollowupResultLog(oldFollowupResult, followupResultDetailInfo, 3);
		}else{//手工新增随访记录
			TFollowupTaskPatient taskPatient=followupTaskPatientDao.queryUnfinishedFollowupTaskByPatientId(patientId, followupResultDetailInfo.getFollowupTime());
			if(UtilValidate.isNotEmpty(taskPatient)){
				followupResultDetailInfo.setFollowupAssignId(taskPatient.getFollowupAssignId());
				followupResultDetailInfo.setFollowupTaskId(taskPatient.getFollowupTaskId());
			}
			followupResultDetailInfo.setSourceFlag(1);
			this.insertFollowupResult(followupResultDetailInfo);
			this.insertFollowupResultBuff(followupResultDetailInfo);
			//保存日志
			this.followupResultLogService.saveFollowupResultLog(null, followupResultDetailInfo, 1);
		}
	}
	
	@Transactional
	@Override
	public void deleteFollowupResult(FollowupResultDeleteReq req) {
		String followupResultId=req.getFollowupResultId();
		String followupResultBuffId=req.getFollowupResultBuffId();
		TFollowupResultDetailInfo currFollowupResultBuff=new TFollowupResultDetailInfo();
		currFollowupResultBuff.setUpdateOperator(req.getUpdateOperator());
		currFollowupResultBuff.setUpdateOperatorName(req.getUpdateOperatorName());
		
		//查询已存在的随访结果
		TFollowupResultDetailInfo oldFollowupResultBuff=followupResultDao.queryFollowupResultBuffByPrimaryKey(followupResultBuffId);
		
		if(UtilValidate.isNotEmpty(followupResultId)){
			//获取随访结果（患者ID及任务ID）
			TFollowupResultDetailInfo followupResult=followupResultDao.queryFollowupResultById(followupResultId);
			Long patientId = followupResult.getPatientId();
			//删除随访缓存结果
			followupResultDao.deleteFollowupResultBuff(followupResultBuffId);
			//删除随访结果
			followupResultDao.deleteFollowupResult(followupResultId);
			//如果任务不为空，更新r_task_patient状态
			if(UtilValidate.isNotEmpty(followupResult.getFollowupTaskId())){
				// 更新随访结果患者表状态
				TFollowupTaskPatient followupTaskPatient = new TFollowupTaskPatient();
				followupTaskPatient.setFollowupTaskId(followupResult.getFollowupTaskId());
				followupTaskPatient.setFollowupAssignId(followupResult.getFollowupAssignId());
				followupTaskPatient.setPatientId(patientId);
				
				//查询是否有缓存，如果有则增加到正式结果表中，类型标识为暂存
				Map<String, Object> searchParams = new HashMap<String, Object>();
				searchParams.put("followupTaskId", followupResult.getFollowupTaskId());
				searchParams.put("patientId", patientId);
				List<TFollowupResultDetailInfo> followupResultDetailList = followupResultDao.queryFollowupResultBuff(searchParams);
				if (UtilValidate.isNotEmpty(followupResultDetailList)) {
					TFollowupResultDetailInfo buff = followupResultDetailList.get(0);
					buff.setFollowupResultState(1);//暂存状态
					buff.setFollowupResultId(GeneralUtil.generatorUUID("RESU"));
					this.followupResultDao.insertFollowupResult(buff);
					this.updateFollowupResultBuff(buff);
					
					followupTaskPatient.setState(1);// 暂存
				}else{
					followupTaskPatient.setState(0);// 未完成
				}
				//更新患者任务状态
				followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);
			}
			
			// 查询全局设置（随访周期）
			TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
			Integer cycleDay = globalConfig.getFollowupCycle();
			Integer currCycleDay = null;
			try {
				// 计算随访时间是否超出随访周期（当前日期-随访日期）
				currCycleDay = DateUtil.daysBetween(followupResult.getFollowupTime(), new Date());
			} catch (ParseException e) {
				LogUtil.log.error("【随访周期计算错误】" + e.getMessage());
			}
			
			//查询任务
			TFollowupTaskDetailInfo followupTask=followupTaskDao.queryFollowupTaskByPrimaryKey(followupResult.getFollowupTaskId());
			
			//如果周期内且任务为已结束则改为未完成
			if (currCycleDay <= cycleDay && UtilValidate.isNotEmpty(followupTask) && followupTask.getState()==2 ) {
				TFollowupTaskAssign taskAssignInfo = new TFollowupTaskAssign();
				taskAssignInfo.setFollowupAssignId(followupResult.getFollowupAssignId());
				taskAssignInfo.setState(1);// 进行中
				followupTaskDao.updateFollowupTaskAssign(taskAssignInfo);

				// 任务状态
				TFollowupTaskSimpleInfo taskInfo = new TFollowupTaskSimpleInfo();
				taskInfo.setFollowupTaskId(followupResult.getFollowupTaskId());
				taskInfo.setState(1);// 进行中
				followupTaskDao.updateFollowupTask(taskInfo);
			}
			//保存日志
			this.followupResultLogService.saveFollowupResultLog(followupResult, currFollowupResultBuff, 2);
			
			// 查询随访结果
			Map<String, Object> searchParams = new HashMap<String, Object>();
			searchParams.put("patientId", patientId);
			searchParams.put("followupResultValue",4);
			List<TFollowupResultDetailInfo> list=followupResultDao.queryFollowupResult(searchParams);
			if(followupResult.getFollowupResultValue()==4 && UtilValidate.isEmpty(list)){
				//清空患者死亡相关标识
				Patient patient=patientDao.queryPatientByPrimaryKey(patientId);
				if(patient.getLiveStatus()==0){
					patient.setLiveStatus(1);
					if(patient.getFollowupFlag()==0){
						patient.setFollowupFlag(1);
					}
					patient.setDeathDate(null);
					patient.setIsInHospitalDeath(null);
					patient.setIsTumourDeath(null);
					patient.setDeathCause(null);
				}
				patientDao.updatePatientByPrimaryKey(patient);
			}
			
			try{
				frushVarPatientFollowup(patientId);
			}catch(Exception e){
				LogUtil.log.error("患者ID："+patientId+"【删除随访结果后刷新动态表失败】"+e.getMessage());
			}
		}else if(UtilValidate.isNotEmpty(followupResultBuffId)){
			//删除随访缓存结果
			followupResultDao.deleteFollowupResultBuff(followupResultBuffId);
			
			//保存日志
			this.followupResultLogService.saveFollowupResultLog(oldFollowupResultBuff, currFollowupResultBuff, 2);
		}
	}
	
	public void frushVarPatientFollowup(Long patientId) {
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("patientId", patientId);
		List<TFollowupResultDetailInfo> list=followupResultDao.queryFollowupResult(searchParams);
		
		TVarPatientFollowup varPatientFollowup = varPatientFollowupDao.queryVarPatientFollowupByPatientId(patientId);
		
		// 动态保存随访信息
		if(UtilValidate.isEmpty(list)){
			if(UtilValidate.isNotEmpty(varPatientFollowup)){
				//删除动态记录
				varPatientFollowupDao.deleteVarPatientFollowup(varPatientFollowup.getId());
			}
		}else if(list.size()==1){
			this.saveVarPatientFollowup(patientId, list.get(0));
		}else{
			//查询正式有效结果
			searchParams.put("followupResultState", 2);
			searchParams.put("followupResultType", 1);
			list=followupResultDao.queryFollowupResult(searchParams);
			if(UtilValidate.isNotEmpty(list)){
				this.saveVarPatientFollowup(patientId, list.get(0));
			}
			
			//查询正式随访结果
			searchParams = new HashMap<String, Object>();
			searchParams.put("followupResultState", 2);
			list=followupResultDao.queryFollowupResult(searchParams);
			if(UtilValidate.isNotEmpty(list)){
				this.saveVarPatientFollowup(patientId, list.get(0));
			}
		}
	}
	/**
	* @author fanpanwei
	* @date 2017年8月23日
	* @param 
	* @description:传入的死亡时间和患者id，自动估算患者死亡时间
	* @return
	 */
	@Override
	public Date guessDeathDate(Date deathDate,Long patientId){
		//死亡时间自动估算控制
		if(UtilValidate.isEmpty(deathDate)){
			TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
			Integer autoGuessDiedFlag=globalConfig.getAutoGuessDiedFlag();
			if(autoGuessDiedFlag==1){
				//TVarPatientFollowup varPatientFollowup = varPatientFollowupDao.queryVarPatientFollowupByPatientId(patientId);
				Date latestTouchDate = varPatientFollowupDao.queryLatestTouchDate(patientId);
				if(UtilValidate.isNotEmpty(latestTouchDate)){
					deathDate=this.calculateDeathDate(deathDate, latestTouchDate);
				}else deathDate=new Date();
			}
		}
		return deathDate;
	}
}

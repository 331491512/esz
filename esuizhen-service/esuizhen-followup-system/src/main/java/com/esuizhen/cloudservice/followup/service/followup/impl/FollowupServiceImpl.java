package com.esuizhen.cloudservice.followup.service.followup.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.dao.followup.FollowupMetaDao;
import com.esuizhen.cloudservice.followup.dao.followup.FollowupPlanDao;
import com.esuizhen.cloudservice.followup.dao.followup.FollowupResultDao;
import com.esuizhen.cloudservice.followup.dao.followup.TVarPatientFollowupDao;
import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplate;
import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplateDetialInfo;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlan;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanDetialInfo;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanTemplateSimpleInfo;
import com.esuizhen.cloudservice.followup.model.followup.TPatientSimpleInfo;
import com.esuizhen.cloudservice.followup.service.followup.FollowupService;
import com.github.pagehelper.PageHelper;
import com.mchange.v2.log.LogUtils;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TFollowupResultInfo;
import com.westangel.common.bean.followup.TVarPatientFollowup;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.TimerTaskFactoryService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service(value = "followupService")
@Transactional
public class FollowupServiceImpl implements FollowupService {

	/**
	 * 随访，随访模版数据操作接口
	 */
	@Autowired
	private FollowupPlanDao dao;

	@Autowired
	private FollowupMetaDao metaDao;

	@Autowired
	private FollowupResultDao followupResultDao;

	@Autowired
	private TVarPatientFollowupDao varPatientFollowupDao;

	@Autowired
	private TimerTaskFactoryService timerTaskFactoryService;

	@Value("${server.wx.url.root}")
	private String wxUrl;

	@Value("${server.questionnaire.write.path}")
	private String writePath;

	@Value("${server.questionnaire.result.list.path}")
	private String resultPath;

	@Value("${followup.start.tips}")
	private String followupTips;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createFollowupPlanTemplate(FollowupPlanTemplate template) {
		// 生成ID
		String planTemplateId = GeneralUtil.generatorTimeUUID();
		template.setPlanTemplateId(planTemplateId);

		// 创建随访计划模版
		dao.createFollowupPlanTemplate(template);

		// 添加随访计划模版详情
		if (template.getDetailList() != null) {
			for (int i = 0; i < template.getDetailList().size(); i++) {
				FollowupPlanTemplateDetialInfo detialInfo = template.getDetailList().get(i);
				detialInfo.setPlanTemplateItemId(GeneralUtil.generatorTimeUUID());
				detialInfo.setPlanTemplateId(planTemplateId);
				detialInfo.setPlanTemplateItemIndex(i + 1);
			}
		}
		dao.addFollowupPlanTemplateDetialInfo(template.getDetailList());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteFollowupPlanTemplate(String planTemplateId) {
		// 删除随访计划模版
		dao.deleteFollowupPlanTemplateById(planTemplateId);

		// 删除随访计划模版详情
		dao.deleteFollowupPlanTemplateDetialInfoByPlanId(planTemplateId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateFollowupPlanTemplate(FollowupPlanTemplate template) {
		// 修改随访计划模版
		dao.updateFollowupPlanTemplate(template);

		// 删除随访计划模版详情
		dao.deleteFollowupPlanTemplateDetialInfoByPlanId(template.getPlanTemplateId());

		// 添加随访计划模版详情
		if (template.getDetailList() != null) {
			for (int i = 0; i < template.getDetailList().size(); i++) {
				FollowupPlanTemplateDetialInfo detialInfo = template.getDetailList().get(i);
				detialInfo.setPlanTemplateItemId(GeneralUtil.generatorTimeUUID());
				detialInfo.setPlanTemplateId(template.getPlanTemplateId());
				detialInfo.setPlanTemplateItemIndex(i + 1);
			}
		}
		dao.addFollowupPlanTemplateDetialInfo(template.getDetailList());
	}

	@Override
	public FollowupPlanTemplate queryFollowupPlanTemplate(String planTemplateId) {
		return dao.queryFollowupPlanTemplate(planTemplateId);
	}

	@Override
	public Page selectFollowupPlanTemplate(String doctorId, Integer page, Integer num) {
		PageHelper.startPage(page + 1, num);
		List<TFollowupPlanTemplateSimpleInfo> list = dao.selectFollowupPlanTemplate();
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupPlanTemplateSimpleInfo>) list);
	}

	@Override
	public TFollowupPlan queryFollowupPlanDetailInfo(Long doctorId, Long patientId) {
		LinkedHashMap<String, Object> param = new LinkedHashMap<String, Object>();
		param.put("doctorId", doctorId);
		param.put("patientId", patientId);
		param.put("questionnaireUrl", wxUrl + writePath + "?followupItemId=");
		param.put("questionnaireResultUrl", wxUrl + resultPath + "?patientId=" + patientId + "&followupItemId=");
		return dao.queryFollowupPlanDetailInfo(param);
	}

	@Override
	public Page followupPatientList(Long doctorId, Integer page, Integer num, Integer sortFlag) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("doctorId", doctorId);
		param.put("sortFlag", sortFlag);
		PageHelper.startPage(page + 1, num);
		List<TPatientSimpleInfo> list = dao.selectFollowupPatientList(param);
		return PageUtil.returnPage((com.github.pagehelper.Page<TPatientSimpleInfo>) list);
	}

	@Override
	public boolean initNormalFollowupPlan(Long patientId, String confirmedDate, Long diseaseTypeId) {
		return initNormalFollowupPlan(patientId, confirmedDate, diseaseTypeId, null, null);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean initNormalFollowupPlan(Long patientId, String confirmedDate, Long diseaseTypeId, String doctorName,
			Integer wxProductId) {
		// 成功失败标志位
		boolean flag = true;

		try {
			// 创建随访计划
			LinkedHashMap<String, Object> followupMap = new LinkedHashMap<String, Object>();
			followupMap.put("patientId", patientId);
			TFollowupPlan followupPlan = dao.queryFollowupPlanInfo(followupMap);
			String followupId = null;
			if (followupPlan != null) {// 如果已经创建用现有随访计划
				followupId = followupPlan.getFollowupId();
			} else {// 创建随访计划
				followupId = createFollowupPlan(patientId, confirmedDate, diseaseTypeId, wxProductId, doctorName);
			}
			// 创建随访计划任务(取消任务创建)
			Integer code = timerTaskFactoryService.createFollowupPlanTimerTask(followupId, doctorName, wxProductId);
			flag = ErrorMessage.SUCCESS.code == code ? true : false;
			if(!flag){
				LogUtil.logError.error("create followup plan timer error,followupId:{}",followupId);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}

		return flag;
	}

	public String createFollowupPlan(Long patientId, String confirmedDate, Long diseaseTypeId, Integer wxProductId,
			String name) {
		// 获取随访计划生成模版ID
		String planTemplateId = dao.queryplanTemplateIdByPatientId(patientId, diseaseTypeId);
		// 生成ID
		String followupId = GeneralUtil.generatorTimeUUID();
		LinkedHashMap<String, Object> followupPlan = new LinkedHashMap<String, Object>();
		followupPlan.put("patientId", patientId);
		followupPlan.put("followupId", followupId);
		followupPlan.put("planTemplateId", planTemplateId);
		followupPlan.put("confirmedDate", confirmedDate);
		// 为空默认为平台
		if (wxProductId == null)
			wxProductId = Constant.Push.WEIXIN_BIND_DEFAULT_PRODUCT_ID;
		followupPlan.put("wxProductId", wxProductId);
		// 获取开启姓名
		if (StringUtils.isEmpty(name)) {
			LinkedHashMap<String, String> userSourceMap =  dao.queryPatientSource(patientId,wxProductId);
			name = StringUtils.isEmpty(userSourceMap.get("trueName"))?userSourceMap.get("weixinName"):userSourceMap.get("trueName");
		}
		followupPlan.put("followupSource", name);
		// 创建随访计划
		dao.createFollowupPlan(followupPlan);

		// 添加随访计划开启记录
		TFollowupPlanDetialInfo detialInfo = new TFollowupPlanDetialInfo();
		detialInfo.setFollowupItemId(GeneralUtil.generateUniqueID("ITEM"));
		detialInfo.setFollowupId(followupId);
		detialInfo.setActionType("0");
		detialInfo.setPlanTemplateItemIndex(1);
		detialInfo.setFollowupDate(new Date());
		detialInfo.setIntervalDays(1);
		detialInfo.setIntervalMonths(0);
		detialInfo.setIsAlertSent(1);
		detialInfo.setIntervalDaysTips(null);
		detialInfo.setIsSurveryFeedback(0);
		detialInfo.setContent(followupTips);
		detialInfo.setUpdateTime(new Date());
		detialInfo.setCreateTime(new Date());
		dao.addFollowupPlanDetialInfoParam(detialInfo);

		// 添加随访计划详情
		String followupItemId = GeneralUtil.generatorTimeUUID();
		TFollowupPlanDetialInfo followupPlanDetialInfo = new TFollowupPlanDetialInfo();
		followupPlanDetialInfo.setFollowupId(followupId);
		followupPlanDetialInfo.setFollowupItemId(followupItemId);
		followupPlanDetialInfo.setPatientId(patientId);
		followupPlanDetialInfo.setConfirmedDate(confirmedDate);
		followupPlanDetialInfo.setPlanTemplateId(planTemplateId);
		dao.addFollowupPlanDetialInfo(followupPlanDetialInfo);

		// 动态保存随访信息
		TVarPatientFollowup varPatientFollowup = new TVarPatientFollowup();
		varPatientFollowup.setPatientId(patientId);
		varPatientFollowup.setFollowupState(1);
		varPatientFollowup.setFollowupFlag(1);
		varPatientFollowup.setProjectFollowupState(1);
		varPatientFollowup.setLatestFollowupTime(new Date());
		varPatientFollowup.setConfirmedDate(confirmedDate);
		varPatientFollowup.setCurrFollowupPerformDays(0);
		//稳定 待处理
		varPatientFollowup.setFollowupResultValue(1);
		varPatientFollowupDao.insertVarPatientFollowup(varPatientFollowup);

		return followupId;
	}

	/**
	 * 判断是否开启随访计划
	 */
	@Override
	public boolean checkPatientHasFollowup(Long patientId) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, Object> followupMap = new LinkedHashMap<String, Object>();
		followupMap.put("patientId", patientId);
		TFollowupPlan followupPlan = dao.queryFollowupPlanInfo(followupMap);
		return followupPlan != null;
	}

	/**
	 * 复查提醒元数据获取
	 */
	@Override
	public Object followupReviewList() {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.addAll(metaDao.queryFollowupReviewDetection());
		list.addAll(list.size(), metaDao.queryFollowupReviewExam());
		return list;
	}

	/**
	 * 最后一次随访结果
	 */
	@Override
	public TFollowupResultInfo getLastFollowupResultByUserId(Long userId) {
		// TODO Auto-generated method stub
		return followupResultDao.queryLastFollowupResultByUserId(userId);
	}
	@Override
	public void  updateFollowupPlanDetail(TFollowupPlanDetialInfo followupPlanDetialInfo){
		dao.updateFollowupPlanDetail(followupPlanDetialInfo);
	}
	
}

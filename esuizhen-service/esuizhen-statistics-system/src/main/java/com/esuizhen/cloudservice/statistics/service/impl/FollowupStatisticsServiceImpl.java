package com.esuizhen.cloudservice.statistics.service.impl;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.statistics.bean.FollowupPatientStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupPatientStatusStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsResult;
import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TDailyGainPatient;
import com.esuizhen.cloudservice.statistics.bean.TFollowupProgressInfo;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultStatistics;
import com.esuizhen.cloudservice.statistics.bean.TFollowupWayProgressInfo;
import com.esuizhen.cloudservice.statistics.bean.TFollowupWayStatisticInfo;
import com.esuizhen.cloudservice.statistics.bean.TFollowupWayStatisticResultInfo;
import com.esuizhen.cloudservice.statistics.bean.TStatisticResultInfo;
import com.esuizhen.cloudservice.statistics.bean.TStatisticTitleInfo;
import com.esuizhen.cloudservice.statistics.constant.Constants;
import com.esuizhen.cloudservice.statistics.dao.FollowupProgressDao;
import com.esuizhen.cloudservice.statistics.dao.FollowupResultDao;
import com.esuizhen.cloudservice.statistics.dao.FollowupWayDao;
import com.esuizhen.cloudservice.statistics.dao.PatientDao;
import com.esuizhen.cloudservice.statistics.dao.RUserRoleDao;
import com.esuizhen.cloudservice.statistics.dao.StatsExportTemplateDao;
import com.esuizhen.cloudservice.statistics.dao.StatsExportValueInfoDao;
import com.esuizhen.cloudservice.statistics.service.FollowupStatisticsService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.search.ConfGlobal;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.bean.search.StatsExportValueInfo;
import com.westangel.common.bean.user.RConfDataPrivilege;
import com.westangel.common.bean.user.TRDoctor;
import com.westangel.common.dao.search.ConfGlobalDao;
import com.westangel.common.dao.search.SearchDao;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.service.AuthorizationService;
import com.westangel.common.service.DoctorService;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
public class FollowupStatisticsServiceImpl implements FollowupStatisticsService {
	@Autowired
	private FollowupProgressDao followupProgressDao;
	@Autowired
	private FollowupWayDao followupWayDao;
	@Autowired
	private FollowupResultDao followupResultDao;
	@Autowired
	private SearchDao searchDao;
	@Autowired
	private StatsExportValueInfoDao statsExportValueInfoDao;
	@Autowired
	private ConfGlobalDao confGlobalDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private StatsExportTemplateDao statsExportTemplateDao;
	/** 院际医生工作站  add by yuan_wm 20170217 start */
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private DoctorService doctorService;
	/** 院际医生工作站  add by yuan_wm 20170217 end */
	@Autowired
	private RUserRoleDao userRoleDao;
	
	// add by zhuguo
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	// end
	
	@Override
	public TFollowupProgressInfo statisticsFollowupProgress(String followupTaskId, String followupAssignId,
			Long userId) {
		TFollowupProgressInfo followupProgressInfo = null;
		if (StringUtils.isEmpty(followupAssignId)) {
			// 随访任务总进展
			if (StringUtils.isEmpty(followupTaskId)) {
				ConfGlobal conf = confGlobalDao.queryConfGlobal();
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("cancerFilterFlag", conf.getCancerFilterFlag());
				paramsMap.put("followupCycle", conf.getFollowupCycle());
				followupProgressInfo = this.followupProgressDao.findAllFollowupProgress(paramsMap);
				int totalNum = followupProgressDao.countPatientNum(null);
				followupProgressInfo.setTotalNum(totalNum);
				// PageHelper.startPage(1, 3);
				List<TFollowupProgressInfo> followupProgressInfos = this.followupProgressDao
						.findFollowupProgressList(null, null, userId, 3);
				followupProgressInfo.setSubFollowTaskList(followupProgressInfos);
			} else {
				followupProgressInfo = this.followupProgressDao.findFollowupProgress(followupTaskId, null);
				followupProgressInfo.setOperatorList(
						this.followupProgressDao.findPersonalFollowupProgress(followupTaskId, null, null));
			}
		} else {
			// 随访人员
			List<TFollowupProgressInfo> followupProgressInfos = this.followupProgressDao
					.findPersonalFollowupProgress(followupTaskId, followupAssignId, userId);
			if (followupProgressInfos != null && !followupProgressInfos.isEmpty()) {
				followupProgressInfo = followupProgressInfos.get(0);
			}
		}
		return followupProgressInfo;
	}

	@Override
	public List<TFollowupResultStatistics> statisticsFollowupResult(String followupTaskId, String followupAssignId,
			Long userId) {
		List<TFollowupResultStatistics> followupResultStatistics = null;
		if (StringUtils.isEmpty(followupAssignId)) {
			if (StringUtils.isEmpty(followupTaskId)) {
				// 最近一次随访结果分布
				// 总数
				Integer total = this.followupResultDao.findLastFollowupResultTypeTotal(null);
				// 有效随访结果
				followupResultStatistics = this.followupResultDao.findLastFollowupResultStatistics(1, total, total);
				// 无效随访
				Integer invalidTotal = this.followupResultDao.findLastFollowupResultTypeTotal(2);
				if (invalidTotal != 0) {
					NumberFormat numberFormat = NumberFormat.getInstance();
					// 设置精确到小数点后2位
					numberFormat.setMaximumFractionDigits(2);
					TFollowupResultStatistics resultStatistics = new TFollowupResultStatistics();
					String result = "0";
					if (total > 0) {
						result = numberFormat.format((float) invalidTotal / (float) total * 100);
						resultStatistics.setPercentage(new Float(result));
					}
					resultStatistics.setFollowupResultValueId(-1);
					resultStatistics.setFollowupResultValueName("其他");
					resultStatistics.setQuantity(invalidTotal);
					resultStatistics.setType(2);
					// 各无效随访统计
					resultStatistics.setDetailedList(
							this.followupResultDao.findLastFollowupResultStatistics(2, invalidTotal, total));

					followupResultStatistics.add(resultStatistics);
				}
			} else {
				// 总数
				Integer total = this.followupResultDao.findFollowupResultTypeTotal(followupTaskId, null, null, null);
				// 随访任务总的结果统计
				// 有效随访结果
				followupResultStatistics = this.followupResultDao.findFollowupResultStatistics(followupTaskId, null,
						null, 1, total, total);
				// 无效随访结果
				Integer invalidTotal = this.followupResultDao.findFollowupResultTypeTotal(followupTaskId, null, null,
						2);
				if (invalidTotal != 0) {
					NumberFormat numberFormat = NumberFormat.getInstance();
					// 设置精确到小数点后2位
					numberFormat.setMaximumFractionDigits(2);
					TFollowupResultStatistics resultStatistics = new TFollowupResultStatistics();
					String result = "0";
					if (total > 0) {
						result = numberFormat.format((float) invalidTotal / (float) total * 100);
						resultStatistics.setPercentage(new Float(result));
					}
					resultStatistics.setFollowupResultValueId(-1);
					resultStatistics.setFollowupResultValueName("其他");
					resultStatistics.setQuantity(invalidTotal);
					resultStatistics.setType(2);
					// 各无效随访统计
					resultStatistics.setDetailedList(this.followupResultDao.findFollowupResultStatistics(followupTaskId,
							null, null, 2, invalidTotal, total));

					followupResultStatistics.add(resultStatistics);
				}
			}
		} else {
			// 总数
			Integer total = this.followupResultDao.findFollowupResultTypeTotal(followupTaskId, followupAssignId, null,
					null);
			// 随访人员个人的随访结果统计
			// 有效随访结果
			followupResultStatistics = this.followupResultDao.findFollowupResultStatistics(followupTaskId,
					followupAssignId, userId, 1, total, total);
			// 无效随访结果
			Integer invalidTotal = this.followupResultDao.findFollowupResultTypeTotal(followupTaskId, followupAssignId,
					userId, 2);
			if (invalidTotal != 0) {
				NumberFormat numberFormat = NumberFormat.getInstance();
				// 设置精确到小数点后2位
				numberFormat.setMaximumFractionDigits(2);
				String result = numberFormat.format((float) invalidTotal / (float) total * 100);
				TFollowupResultStatistics resultStatistics = new TFollowupResultStatistics();
				resultStatistics.setFollowupResultValueId(-1);
				resultStatistics.setFollowupResultValueName("其他");
				resultStatistics.setQuantity(invalidTotal);
				resultStatistics.setPercentage(new Float(result));
				resultStatistics.setType(2);
				// 各无效随访统计
				resultStatistics.setDetailedList(this.followupResultDao.findFollowupResultStatistics(followupTaskId,
						followupAssignId, userId, 2, invalidTotal, total));

				followupResultStatistics.add(resultStatistics);
			}
		}
		return followupResultStatistics;
	}

	@Override
	public List<TFollowupWayProgressInfo> statisticsFollowupWayProgress(String followupTaskId, String followupAssignId,
			Long userId) {
		List<TFollowupWayProgressInfo> followupWayProgressInfos = new ArrayList<TFollowupWayProgressInfo>(4);
		if (StringUtils.isEmpty(followupAssignId)) {
			// 总的随访任务统计随访方式
			// 微信随访
			TFollowupWayProgressInfo wx_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsWXFollowupWay(followupTaskId, null, null);
			followupWayProgressInfos.add(wx_TFollowupWayProgressInfo);
			// 短信随访
			TFollowupWayProgressInfo SMS_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsSMSFollowupWay(followupTaskId, null, null);
			followupWayProgressInfos.add(SMS_TFollowupWayProgressInfo);
			// 电话随访
			TFollowupWayProgressInfo call_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsCallFollowupWay(followupTaskId, null, null);
			followupWayProgressInfos.add(call_TFollowupWayProgressInfo);
			// 就诊自动标记
			TFollowupWayProgressInfo treatment_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsTreatmentFollowupWay(followupTaskId, null, null);
			followupWayProgressInfos.add(treatment_TFollowupWayProgressInfo);
		} else {
			// 查看随访人员的随访使用的随访方式
			// 微信随访
			TFollowupWayProgressInfo wx_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsWXFollowupWay(followupTaskId, followupAssignId, userId);
			followupWayProgressInfos.add(wx_TFollowupWayProgressInfo);
			// 短信随访
			TFollowupWayProgressInfo SMS_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsSMSFollowupWay(followupTaskId, followupAssignId, userId);
			followupWayProgressInfos.add(SMS_TFollowupWayProgressInfo);
			// 电话随访
			TFollowupWayProgressInfo call_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsCallFollowupWay(followupTaskId, followupAssignId, userId);
			followupWayProgressInfos.add(call_TFollowupWayProgressInfo);
			// 就诊自动标记
			TFollowupWayProgressInfo treatment_TFollowupWayProgressInfo = this.followupWayDao
					.statisticsTreatmentFollowupWay(followupTaskId, followupAssignId, userId);
			followupWayProgressInfos.add(treatment_TFollowupWayProgressInfo);
		}
		return followupWayProgressInfos;
	}

	/**
	 * 随访工作量统计
	 * 根据“statisticsMode”的值调用不同的统计方式
	 */
	@Override
	public TStatisticResultInfo statisticsFollowupWorkload(TCommonParam commonParam) throws InsufficientParameterExcption {
		if (commonParam.getStatisticsMethods() == null) {
			throw new InsufficientParameterExcption("Parameter statisticsMode cannot be empty!");
		}
		switch (commonParam.getStatisticsMethods()) {
		case 1://按人员统计
			return this.workloadStatisticsByFollowupPersonnel(commonParam);
		case 2://按任务统计
			return this.workloadStatisticsByFollowupTask(commonParam);
		case 4://按病种统计
			return this.workloadStatisticsByDieaseType(commonParam);
		case 7://按随访方式统计
			return workloadStatisticsByFollowupWay(commonParam);
		}
		return null;
	}

	/**
	 * 随访工作量统计-按病种统计
	 * @param commonParam
	 * @return
	 */
	private TStatisticResultInfo workloadStatisticsByDieaseType(TCommonParam commonParam) {
		TStatisticResultInfo statisticResultInfo = new TStatisticResultInfo();

		// 随访结果其他标识的随访结果是否有效
		int otherFollowupResultType = 2;
		TFollowupResultStatistics otherTFollowupResultStatistics = this.followupResultDao.findFollowupResult(5);
		if (otherTFollowupResultStatistics != null) {
			otherFollowupResultType = otherTFollowupResultStatistics.getType();
		}
		
		if(commonParam.getSourceFlag() != null && commonParam.getSourceFlag() == 6) {//自动生成统计
			statisticResultInfo.setExportTemplateId("EXPT015");
		}else {
			if (otherFollowupResultType == 2) {
				statisticResultInfo.setExportTemplateId("EXPT001");
			} else {
				statisticResultInfo.setExportTemplateId("EXPT005");
			}
		}
		/*
		List<TStatisticTitleInfo> titles = new ArrayList<TStatisticTitleInfo>();
		// 病种名称
		TStatisticTitleInfo diseaseTypeName = new TStatisticTitleInfo();
		diseaseTypeName.setId("diseaseTypeName");
		diseaseTypeName.setName("病种");
		diseaseTypeName.setType(2);
		diseaseTypeName.setRows(1);
		diseaseTypeName.setCols(1);
		titles.add(diseaseTypeName);

		// 已随患者总人数
		TStatisticTitleInfo finishedQuantity = new TStatisticTitleInfo();
		finishedQuantity.setId("finishedQuantity");
		finishedQuantity.setName("已随患者总人数");
		finishedQuantity.setType(1);
		finishedQuantity.setRows(1);
		finishedQuantity.setCols(1);
		titles.add(finishedQuantity);

		// 已随访患者总人次
		TStatisticTitleInfo followupCount = new TStatisticTitleInfo();
		followupCount.setId("followupCount");
		followupCount.setName("已随访患者总人次");
		followupCount.setType(1);
		followupCount.setRows(1);
		followupCount.setCols(1);
		titles.add(followupCount);

		// 有效随访
		TStatisticTitleInfo effectiveFollowup = new TStatisticTitleInfo();
		effectiveFollowup.setId("effectiveFollowup");
		effectiveFollowup.setName("有效随访");
		effectiveFollowup.setType(1);
		effectiveFollowup.setRows(1);
		effectiveFollowup.setCols(1);
		titles.add(effectiveFollowup);
		
		// 随访有效率
		TStatisticTitleInfo effectiveFollowupRate = new TStatisticTitleInfo();
		effectiveFollowupRate.setId("effectiveFollowupRate");
		effectiveFollowupRate.setName("随访有效率");
		effectiveFollowupRate.setType(2);
		effectiveFollowupRate.setRows(1);
		effectiveFollowupRate.setCols(1);
		titles.add(effectiveFollowupRate);

		// 无效随访
		TStatisticTitleInfo invalidFollowup = new TStatisticTitleInfo();
		invalidFollowup.setId("invalidFollowup");
		invalidFollowup.setName("无效随访");
		invalidFollowup.setType(1);
		invalidFollowup.setRows(1);
		invalidFollowup.setCols(1);
		titles.add(invalidFollowup);
		
		// 随访无效率
		TStatisticTitleInfo invalidFollowupRate = new TStatisticTitleInfo();
		invalidFollowupRate.setId("invalidFollowupRate");
		invalidFollowupRate.setName("随访无效率");
		invalidFollowupRate.setType(2);
		invalidFollowupRate.setRows(1);
		invalidFollowupRate.setCols(1);
		titles.add(invalidFollowupRate);
		*/
		if(commonParam != null) {
			ConfGlobal conf = confGlobalDao.queryConfGlobal();
			//随访范围写入
			if(conf!=null){
				commonParam.setFollowupRangeFlag(conf.getFollowupRangeFlag());
				commonParam.setSourceTumorFlags(conf.getNotMalignantTumorFlag());
			}
		}
		
		// add by zhuguo
		if (commonParam.getUserId() != null && commonParam.getOperator() == null) {
			// boolean result =
			// organizationDoctorService.queryDoctorRoleById(null,
			// commonParam.getUserId());
			// if (result) {
			// String powerSql = organizationDoctorService.getPatientSql(null,
			// commonParam.getUserId());
			// if (powerSql == null) {
			// LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			// } else {
			// commonParam.setSql(powerSql);
			// }
			// }

			String powerSql = organizationDoctorService.getDoctorIdSql(null, commonParam.getUserId());
			if (powerSql == null || "".equals(powerSql)) {
				LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			} else {
				commonParam.setSql(powerSql);
			}
		}
		// end	
		
		String jsonStr = this.statsExportTemplateDao.findExportTitleInfo(statisticResultInfo.getExportTemplateId());
		List<TStatisticTitleInfo> titles = com.esuizhen.cloudservice.statistics.util.JsonUtil.jsonStrConvertTableHand(jsonStr);
		statisticResultInfo.setTitiles(titles);
		commonParam.setOtherFollowupResultType(otherFollowupResultType);
		List<Map<String, Object>> values = this.followupResultDao.statisticsFollowupWorkload(commonParam);
		if (values != null && !values.isEmpty()) {
			for (int i = values.size() - 1; i>= 0; i--) {
				Map<String, Object> map = values.get(i);
				if (map == null) {
					values.remove(i);
				}
			}
		}
		if (values != null && !values.isEmpty()) {
			statisticResultInfo.setValues(values);
			this.saveReturnResult(commonParam, statisticResultInfo, values);
		}
		return statisticResultInfo;
	}

	/**
	 * 随访工作量统计-按随访任务统计
	 * @param commonParam
	 * @return
	 */
	private TStatisticResultInfo workloadStatisticsByFollowupTask(TCommonParam commonParam) {
		TStatisticResultInfo statisticResultInfo = new TStatisticResultInfo();
		//导出使用的模板
		statisticResultInfo.setExportTemplateId("EXPT013");

		/*
		List<TStatisticTitleInfo> titles = new ArrayList<TStatisticTitleInfo>();
		// 任务名称
		TStatisticTitleInfo followupTaskName = new TStatisticTitleInfo();
		followupTaskName.setId("followupTaskName");
		followupTaskName.setName("任务名称");
		followupTaskName.setType(2);
		followupTaskName.setRows(1);
		followupTaskName.setCols(1);
		titles.add(followupTaskName);
		
		// 随访人员
		TStatisticTitleInfo diseaseTypeName = new TStatisticTitleInfo();
		diseaseTypeName.setId("operatorName");
		diseaseTypeName.setName("随访人员");
		diseaseTypeName.setType(2);
		diseaseTypeName.setRows(1);
		diseaseTypeName.setCols(1);
		titles.add(diseaseTypeName);

		// 任务数量
		TStatisticTitleInfo taskNum = new TStatisticTitleInfo();
		taskNum.setId("taskNum");
		taskNum.setName("任务数量");
		taskNum.setType(1);
		taskNum.setRows(1);
		taskNum.setCols(1);
		titles.add(taskNum);

		// 已完成
		TStatisticTitleInfo completedQuantity = new TStatisticTitleInfo();
		completedQuantity.setId("completedQuantity");
		completedQuantity.setName("已完成");
		completedQuantity.setType(1);
		completedQuantity.setRows(1);
		completedQuantity.setCols(1);
		titles.add(completedQuantity);
		
		// 完成率
		TStatisticTitleInfo completedQuantityRate = new TStatisticTitleInfo();
		completedQuantityRate.setId("completedQuantityRate");
		completedQuantityRate.setName("完成率");
		completedQuantityRate.setType(2);
		completedQuantityRate.setRows(1);
		completedQuantityRate.setCols(1);
		titles.add(completedQuantityRate);

		// 有效随访
		TStatisticTitleInfo effectiveFollowup = new TStatisticTitleInfo();
		effectiveFollowup.setId("effectiveFollowup");
		effectiveFollowup.setName("有效随访");
		effectiveFollowup.setType(1);
		effectiveFollowup.setRows(1);
		effectiveFollowup.setCols(1);
		titles.add(effectiveFollowup);
		
		// 随访有效率
		TStatisticTitleInfo effectiveFollowupRate = new TStatisticTitleInfo();
		effectiveFollowupRate.setId("effectiveFollowupRate");
		effectiveFollowupRate.setName("随访有效率");
		effectiveFollowupRate.setType(2);
		effectiveFollowupRate.setRows(1);
		effectiveFollowupRate.setCols(1);
		titles.add(effectiveFollowupRate);

		// 无效随访
		TStatisticTitleInfo invalidFollowup = new TStatisticTitleInfo();
		invalidFollowup.setId("invalidFollowup");
		invalidFollowup.setName("无效随访");
		invalidFollowup.setType(1);
		invalidFollowup.setRows(1);
		invalidFollowup.setCols(1);
		titles.add(invalidFollowup);
		
		// 随访无效率
		TStatisticTitleInfo invalidFollowupRate = new TStatisticTitleInfo();
		invalidFollowupRate.setId("invalidFollowupRate");
		invalidFollowupRate.setName("随访无效率");
		invalidFollowupRate.setType(2);
		invalidFollowupRate.setRows(1);
		invalidFollowupRate.setCols(1);
		titles.add(invalidFollowupRate);
		*/
		if(commonParam != null) {
			ConfGlobal conf = confGlobalDao.queryConfGlobal();
			//随访范围写入
			if(conf!=null){
				commonParam.setFollowupRangeFlag(conf.getFollowupRangeFlag());
				commonParam.setSourceTumorFlags(conf.getNotMalignantTumorFlag());
			}
		}
		
		// add by zhuguo
		if (commonParam.getUserId() != null && commonParam.getOperator() == null) {
			// boolean result =
			// organizationDoctorService.queryDoctorRoleById(null,
			// commonParam.getUserId());
			// if (result) {
			// String powerSql = organizationDoctorService.getPatientSql(null,
			// commonParam.getUserId());
			// if (powerSql == null) {
			// LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			// } else {
			// commonParam.setSql(powerSql);
			// }
			// }

			String powerSql = organizationDoctorService.getDoctorIdSql(null, commonParam.getUserId());
			if (powerSql == null || "".equals(powerSql)) {
				LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			} else {
				commonParam.setSql(powerSql);
			}
		}
		// end	
		
		String jsonStr = this.statsExportTemplateDao.findExportTitleInfo(statisticResultInfo.getExportTemplateId());
		List<TStatisticTitleInfo> titles = com.esuizhen.cloudservice.statistics.util.JsonUtil.jsonStrConvertTableHand(jsonStr);
		statisticResultInfo.setTitiles(titles);
		List<Map<String, Object>> values = this.followupResultDao.statisticsTaskFollowupWorkload(commonParam);
		for (int i = values.size() - 1; i >= 0; i--) {
			Map<String, Object> map = values.get(i);
			if (map == null) {
				values.remove(i);//处理空对象
			}
		}
		if (values != null && !values.isEmpty()) {
			statisticResultInfo.setValues(values);
			this.saveReturnResult(commonParam, statisticResultInfo, values);
		}
		return statisticResultInfo;
	}

	/**
	 * 随访工作量统计-按随访人员统计
	 * @param commonParam
	 * @return
	 */
	private TStatisticResultInfo workloadStatisticsByFollowupPersonnel(TCommonParam commonParam) {
		TStatisticResultInfo statisticResultInfo = new TStatisticResultInfo();
		//导出使用的模板
		statisticResultInfo.setExportTemplateId("EXPT012");
		
		/*
		List<TStatisticTitleInfo> titles = new ArrayList<TStatisticTitleInfo>();
		// 随访人员
		TStatisticTitleInfo diseaseTypeName = new TStatisticTitleInfo();
		diseaseTypeName.setId("operatorName");
		diseaseTypeName.setName("随访人员");
		diseaseTypeName.setType(2);
		diseaseTypeName.setRows(1);
		diseaseTypeName.setCols(1);
		titles.add(diseaseTypeName);

		// 随访患者总数
		TStatisticTitleInfo finishedQuantity = new TStatisticTitleInfo();
		finishedQuantity.setId("finishedQuantity");
		finishedQuantity.setName("随访患者总数");
		finishedQuantity.setType(1);
		finishedQuantity.setRows(1);
		finishedQuantity.setCols(1);
		titles.add(finishedQuantity);

		// 随访人次
		TStatisticTitleInfo followupCount = new TStatisticTitleInfo();
		followupCount.setId("followupCount");
		followupCount.setName("随访人次");
		followupCount.setType(1);
		followupCount.setRows(1);
		followupCount.setCols(1);
		titles.add(followupCount);

		// 有效随访
		TStatisticTitleInfo effectiveFollowup = new TStatisticTitleInfo();
		effectiveFollowup.setId("effectiveFollowup");
		effectiveFollowup.setName("有效随访");
		effectiveFollowup.setType(1);
		effectiveFollowup.setRows(1);
		effectiveFollowup.setCols(1);
		titles.add(effectiveFollowup);
		
		// 随访有效率
		TStatisticTitleInfo effectiveFollowupRate = new TStatisticTitleInfo();
		effectiveFollowupRate.setId("effectiveFollowupRate");
		effectiveFollowupRate.setName("随访有效率");
		effectiveFollowupRate.setType(2);
		effectiveFollowupRate.setRows(1);
		effectiveFollowupRate.setCols(1);
		titles.add(effectiveFollowupRate);

		// 无效随访
		TStatisticTitleInfo invalidFollowup = new TStatisticTitleInfo();
		invalidFollowup.setId("invalidFollowup");
		invalidFollowup.setName("无效随访");
		invalidFollowup.setType(1);
		invalidFollowup.setRows(1);
		invalidFollowup.setCols(1);
		titles.add(invalidFollowup);
		
		// 随访无效率
		TStatisticTitleInfo invalidFollowupRate = new TStatisticTitleInfo();
		invalidFollowupRate.setId("invalidFollowupRate");
		invalidFollowupRate.setName("随访无效率");
		invalidFollowupRate.setType(2);
		invalidFollowupRate.setRows(1);
		invalidFollowupRate.setCols(1);
		titles.add(invalidFollowupRate);
		*/
		if(commonParam != null) {
			ConfGlobal conf = confGlobalDao.queryConfGlobal();
			//随访范围写入
			if(conf!=null){
				commonParam.setFollowupRangeFlag(conf.getFollowupRangeFlag());
				commonParam.setSourceTumorFlags(conf.getNotMalignantTumorFlag());
			}
		}
		
		// add by zhuguo
		if (commonParam.getUserId() != null && commonParam.getOperator() == null) {
			// boolean result =
			// organizationDoctorService.queryDoctorRoleById(null,
			// commonParam.getUserId());
			// if (result) {
			// String powerSql = organizationDoctorService.getPatientSql(null,
			// commonParam.getUserId());
			// if (powerSql == null) {
			// LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			// } else {
			// commonParam.setSql(powerSql);
			// }
			// }

			String powerSql = organizationDoctorService.getDoctorIdSql(null, commonParam.getUserId());
			if (powerSql == null || "".equals(powerSql)) {
				LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			} else {
				commonParam.setSql(powerSql);
			}
		}
		// end		
		
		String jsonStr = this.statsExportTemplateDao.findExportTitleInfo(statisticResultInfo.getExportTemplateId());
		List<TStatisticTitleInfo> titles = com.esuizhen.cloudservice.statistics.util.JsonUtil.jsonStrConvertTableHand(jsonStr);
		statisticResultInfo.setTitiles(titles);
		List<Map<String, Object>> values = this.followupResultDao.statisticsOperatorFollowupWorkload(commonParam);
		if (values != null && !values.isEmpty()) {
			for(int i = values.size() - 1; i>= 0; i--){
				Map<String, Object> map = values.get(i);
				if (map == null) {
					values.remove(i);
				}
			}
		}
		if (values != null && !values.isEmpty()) {
			statisticResultInfo.setValues(values);
			this.saveReturnResult(commonParam, statisticResultInfo, values);
		}
		return statisticResultInfo;
	}

	@Override
	public TStatisticResultInfo statisticsFollowupTelephoneConnRate(TCommonParam commonParam) {
		TStatisticResultInfo statisticResultInfo = new TStatisticResultInfo();
		List<TStatisticTitleInfo> titles = new ArrayList<TStatisticTitleInfo>();
		statisticResultInfo.setTitiles(titles);
		// 序号
		TStatisticTitleInfo no = new TStatisticTitleInfo();
		no.setId("no");
		no.setName("序号");
		no.setType(2);
		no.setRows(1);
		no.setCols(1);
		titles.add(no);

		switch (commonParam.getCategory()) {
		case 10:
			// 科室
			TStatisticTitleInfo deptName = new TStatisticTitleInfo();
			deptName.setId("deptName");
			deptName.setName("科室");
			deptName.setType(2);
			deptName.setRows(1);
			deptName.setCols(1);
			titles.add(deptName);
			break;
		case 20:
			// 随访人员
			TStatisticTitleInfo operatorName = new TStatisticTitleInfo();
			operatorName.setId("operatorName");
			operatorName.setName("随访人员");
			operatorName.setType(1);
			operatorName.setRows(1);
			operatorName.setCols(1);
			titles.add(operatorName);
			break;
		case 30:
			// 病种名称
			TStatisticTitleInfo diseaseTypeName = new TStatisticTitleInfo();
			diseaseTypeName.setId("diseaseTypeName");
			diseaseTypeName.setName("病种名称");
			diseaseTypeName.setType(2);
			diseaseTypeName.setRows(1);
			diseaseTypeName.setCols(1);
			titles.add(diseaseTypeName);
			break;
		default:
			// 随访人员
			TStatisticTitleInfo defaultColumnName = new TStatisticTitleInfo();
			defaultColumnName.setId("operatorName");
			defaultColumnName.setName("科室/随访人员/病种");
			defaultColumnName.setType(2);
			defaultColumnName.setRows(1);
			defaultColumnName.setCols(1);
			titles.add(defaultColumnName);
			break;
		}

		// 已随访患者
		TStatisticTitleInfo followupQuantity = new TStatisticTitleInfo();
		followupQuantity.setId("followupQuantity");
		followupQuantity.setName("已随访患者人数");
		followupQuantity.setType(1);
		followupQuantity.setRows(1);
		followupQuantity.setCols(1);
		titles.add(followupQuantity);

		// 已随访患者人次
		TStatisticTitleInfo followupTotalCount = new TStatisticTitleInfo();
		followupTotalCount.setId("followupTotalCount");
		followupTotalCount.setName("已随访患者人次");
		followupTotalCount.setType(1);
		followupTotalCount.setRows(1);
		followupTotalCount.setCols(1);
		titles.add(followupTotalCount);

		// 随访率
		/*
		 * TStatisticTitleInfo followupRate = new TStatisticTitleInfo();
		 * followupRate.setId("followupRate"); followupRate.setName("随访率");
		 * followupRate.setType(2); followupRate.setRows(1);
		 * followupRate.setCols(1); titles.add(followupRate);
		 */

		// 成功
		TStatisticTitleInfo finishedQuantity = new TStatisticTitleInfo();
		finishedQuantity.setId("finishedQuantity");
		finishedQuantity.setName("成功");
		finishedQuantity.setType(1);
		finishedQuantity.setRows(1);
		finishedQuantity.setCols(1);
		titles.add(finishedQuantity);

		// 成功率
		TStatisticTitleInfo finishedRate = new TStatisticTitleInfo();
		finishedRate.setId("finishedRate");
		finishedRate.setName("成功率");
		finishedRate.setType(2);
		finishedRate.setRows(1);
		finishedRate.setCols(1);
		titles.add(finishedRate);

		// 无人接听
		TStatisticTitleInfo noanswerQuantity = new TStatisticTitleInfo();
		noanswerQuantity.setId("noanswerQuantity");
		noanswerQuantity.setName("无人接听");
		noanswerQuantity.setType(1);
		noanswerQuantity.setRows(1);
		noanswerQuantity.setCols(1);
		titles.add(noanswerQuantity);

		// 无人接听率
		TStatisticTitleInfo noanswerRate = new TStatisticTitleInfo();
		noanswerRate.setId("noanswerRate");
		noanswerRate.setName("无人接听率");
		noanswerRate.setType(2);
		noanswerRate.setRows(1);
		noanswerRate.setCols(1);
		titles.add(noanswerRate);

		// wrongQuantity
		TStatisticTitleInfo wrongQuantity = new TStatisticTitleInfo();
		wrongQuantity.setId("wrongQuantity");
		wrongQuantity.setName("空/错号");
		wrongQuantity.setType(1);
		wrongQuantity.setRows(1);
		wrongQuantity.setCols(1);
		titles.add(wrongQuantity);

		// 空/错号率
		TStatisticTitleInfo wrongRate = new TStatisticTitleInfo();
		wrongRate.setId("wrongRate");
		wrongRate.setName("空/错号率");
		wrongRate.setType(2);
		wrongRate.setRows(1);
		wrongRate.setCols(1);
		titles.add(wrongRate);

		// 拒绝随访
		TStatisticTitleInfo refuseQuantity = new TStatisticTitleInfo();
		refuseQuantity.setId("refuseQuantity");
		refuseQuantity.setName("拒绝随访");
		refuseQuantity.setType(1);
		refuseQuantity.setRows(1);
		refuseQuantity.setCols(1);
		titles.add(refuseQuantity);

		// 拒绝随访率
		TStatisticTitleInfo refuseRate = new TStatisticTitleInfo();
		refuseRate.setId("refuseRate");
		refuseRate.setName("拒绝随访率");
		refuseRate.setType(2);
		refuseRate.setRows(1);
		refuseRate.setCols(1);
		titles.add(refuseRate);

		// 主动拒接
		TStatisticTitleInfo activeRefuseQuantity = new TStatisticTitleInfo();
		activeRefuseQuantity.setId("activeRefuseQuantity");
		activeRefuseQuantity.setName("主动拒接");
		activeRefuseQuantity.setType(1);
		activeRefuseQuantity.setRows(1);
		activeRefuseQuantity.setCols(1);
		titles.add(activeRefuseQuantity);

		// 主动拒接率
		TStatisticTitleInfo activeRefuseRate = new TStatisticTitleInfo();
		activeRefuseRate.setId("activeRefuseRate");
		activeRefuseRate.setName("主动拒接率");
		activeRefuseRate.setType(2);
		activeRefuseRate.setRows(1);
		activeRefuseRate.setCols(1);
		titles.add(activeRefuseRate);

		// 无法接通
		TStatisticTitleInfo notAvailableQuantity = new TStatisticTitleInfo();
		notAvailableQuantity.setId("notAvailableQuantity");
		notAvailableQuantity.setName("无法接通");
		notAvailableQuantity.setType(1);
		notAvailableQuantity.setRows(1);
		notAvailableQuantity.setCols(1);
		titles.add(notAvailableQuantity);

		// 无法接通率
		TStatisticTitleInfo notAvailableRate = new TStatisticTitleInfo();
		notAvailableRate.setId("notAvailableRate");
		notAvailableRate.setName("无法接通率");
		notAvailableRate.setType(2);
		notAvailableRate.setRows(1);
		notAvailableRate.setCols(1);
		titles.add(notAvailableRate);

		// 停机
		TStatisticTitleInfo disconnectedQuantity = new TStatisticTitleInfo();
		disconnectedQuantity.setId("disconnectedQuantity");
		disconnectedQuantity.setName("停机");
		disconnectedQuantity.setType(1);
		disconnectedQuantity.setRows(1);
		disconnectedQuantity.setCols(1);
		titles.add(disconnectedQuantity);

		// 停机率
		TStatisticTitleInfo disconnectedRate = new TStatisticTitleInfo();
		disconnectedRate.setId("disconnectedRate");
		disconnectedRate.setName("停机率");
		disconnectedRate.setType(2);
		disconnectedRate.setRows(1);
		disconnectedRate.setCols(1);
		titles.add(disconnectedRate);

		// 关机
		TStatisticTitleInfo offQuantity = new TStatisticTitleInfo();
		offQuantity.setId("offQuantity");
		offQuantity.setName("关机");
		offQuantity.setType(1);
		offQuantity.setRows(1);
		offQuantity.setCols(1);
		titles.add(offQuantity);

		// 关机率
		TStatisticTitleInfo offRate = new TStatisticTitleInfo();
		offRate.setId("offRate");
		offRate.setName("关机率");
		offRate.setType(2);
		offRate.setRows(1);
		offRate.setCols(1);
		titles.add(offRate);

		// 随访结果其他标识的随访结果是否有效
		int otherFollowupResultType = 2;
		TFollowupResultStatistics otherTFollowupResultStatistics = this.followupResultDao.findFollowupResult(5);
		if (otherTFollowupResultStatistics != null) {
			otherFollowupResultType = otherTFollowupResultStatistics.getType();
		}
		commonParam.setOtherFollowupResultType(otherFollowupResultType);
		if (otherFollowupResultType == 2) {
			// 其他情况
			TStatisticTitleInfo otherQuantity = new TStatisticTitleInfo();
			otherQuantity.setId("otherQuantity");
			otherQuantity.setName("其他情况");
			otherQuantity.setType(1);
			otherQuantity.setRows(1);
			otherQuantity.setCols(1);
			titles.add(otherQuantity);

			// 其他情况率
			TStatisticTitleInfo otherRate = new TStatisticTitleInfo();
			otherRate.setId("otherRate");
			otherRate.setName("其他情况率");
			otherRate.setType(2);
			otherRate.setRows(1);
			otherRate.setCols(1);
			titles.add(otherRate);
		}

		List<Map<String, Object>> values = null;
		switch (commonParam.getCategory()) {
		case 10:
			if (otherFollowupResultType == 1) {
				statisticResultInfo.setExportTemplateId("EXPT006");
			} else {
				statisticResultInfo.setExportTemplateId("EXPT002");
			}
			values = this.followupResultDao.statisticsFollowupTelephoneConnRateForDept(commonParam);
			break;
		case 20:
			if (otherFollowupResultType == 1) {
				statisticResultInfo.setExportTemplateId("EXPT007");
			} else {
				statisticResultInfo.setExportTemplateId("EXPT003");
			}
			values = this.followupResultDao.statisticsFollowupTelephoneConnRateForOperator(commonParam);
			break;
		case 30:
			if (otherFollowupResultType == 1) {
				statisticResultInfo.setExportTemplateId("EXPT008");
			} else {
				statisticResultInfo.setExportTemplateId("EXPT004");
			}
			values = this.followupResultDao.statisticsFollowupTelephoneConnRateForDiseaseType(commonParam);
			break;
		}
		statisticResultInfo.setValues(values);

		if (values != null && !values.isEmpty()) {
			this.saveReturnResult(commonParam, statisticResultInfo, values);
		}

		return statisticResultInfo;
	}

	private void saveReturnResult(final TCommonParam commonParam, final TStatisticResultInfo statisticResultInfo,
			final List<Map<String, Object>> values) {
		// 将查询结果保存到 统计导出模板表里
		SearchInfo searchInfo = new SearchInfo();
		searchInfo.setTotalNum(values.size());
		searchInfo.setInterfaceName("/statistics/followup/telephone/connection/rate/statistics");
		searchInfo.setReq(JsonUtil.toJson(commonParam));
		searchInfo.setOperator(commonParam.getUserId());
		this.searchDao.insert(searchInfo);
		statisticResultInfo.setSearchId(searchInfo.getSearchId());
		
		new Thread(){
			@Override
			public void run() {
				List<StatsExportValueInfo> exportValueInfos = new ArrayList<StatsExportValueInfo>();
				for (int i = 0; i < values.size(); i++) {
					Map<String, Object> map = values.get(i);
					
					StatsExportValueInfo statsExportValueInfo = new StatsExportValueInfo();
					statsExportValueInfo.setExportTemplateId(statisticResultInfo.getExportTemplateId());
					statsExportValueInfo.setSearchId(new Long(statisticResultInfo.getSearchId()));
					statsExportValueInfo.setValues(JsonUtil.toJson(map));
					
					exportValueInfos.add(statsExportValueInfo);
					if ((i + 1) % 50 == 0) {
						statsExportValueInfoDao.insertByBatch(exportValueInfos);
						exportValueInfos.clear();
					}
				}
				if (!exportValueInfos.isEmpty()) {
					statsExportValueInfoDao.insertByBatch(exportValueInfos);
					exportValueInfos.clear();
				}
			}
		}.start();
	}

	@SuppressWarnings("unchecked")
	@Override
	public TDailyGainPatient statisticsDailyGainPatientList(TCommonParam commonParam) {
		TDailyGainPatient dailyGainPatient = this.followupResultDao.statisticsDailyGainPatientListSum(commonParam);
		if (dailyGainPatient == null) {
			return dailyGainPatient;
		}
		if (commonParam.getPage() == null) {
			commonParam.setPage(0);
		}
		if (commonParam.getNum() == null || commonParam.getNum() < 1) {
			commonParam.setNum(10);
		}
		PageHelper.startPage(commonParam.getPage() + 1, commonParam.getNum());
		List<TDailyGainPatient> dailyGainPatients = this.followupResultDao.statisticsDailyGainPatientList(commonParam);
		dailyGainPatient.setEveryDayPatientList(
				PageUtil.returnPage((com.github.pagehelper.Page<TDailyGainPatient>) dailyGainPatients));
		return dailyGainPatient;
	}

	@Override
	public List<Map<String, Object>> statisticsLostFollowPatient(Integer allFlag, Long doctorId) throws InsufficientParameterExcption {
		if (allFlag == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		
		// add by zhuguo
		String powerSql = null;
		if (doctorId != null) {
			boolean result = organizationDoctorService.queryDoctorRoleById(doctorId, null);
			if (result) {
				powerSql = organizationDoctorService.getPatientSql(doctorId, null);
				if (powerSql == null || "".equals(powerSql)) {
					LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
				}
			}
		}
		// end
		
		List<Map<String, Object>> resultList= this.followupResultDao.statisticsLostFollowPatient(allFlag, powerSql);
		
		return resultList;
	}

	@Override
	public FollowupScheduleStatisticsResult statisticsFollowupSchedule(FollowupScheduleStatisticsReq req) {
		
		Date followupEndDate = req.getFollowupEndDate();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");//设置日期格式
		String nowTime = df.format(new Date());// new Date()为获取当前系统时间
		try {
			Date nowDate = df.parse(nowTime);
			if (followupEndDate==null || (followupEndDate.getTime()>=nowDate.getTime())) {
				req.setCalTaskFlag(1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*followupRangeFlag:
	 	0：关闭。使用恶性肿瘤。即u_patient.sourceTumorFlag=1
		1：按疾病类型，此时看notMalignantTumorFlag取值；
		2: 按大病种（diseaseType）
		3：按ICD病种，此时看conf_followup_range_icd*/
		//肿瘤有效性判断
		ConfGlobal conf = confGlobalDao.queryConfGlobal();
		if(conf!=null){
			Integer followupRangeFlag =conf.getFollowupRangeFlag();
			req.setFollowupRangeFlag(followupRangeFlag);
			String sourceTumorFlags ="("+conf.getNotMalignantTumorFlag()+")";
			req.setSourceTumorFlags(sourceTumorFlags);
		}
		
		//已随访人数
		FollowupScheduleStatisticsResult result=followupResultDao.statisticsFollowupScheduleInfo(req);
		
		/*if(req.getCalTaskFlag()==1){//统计分配任务情况时
			Integer notAllotTasktotal = result.getNotFollowupCount()
					-result.getSurvivalState().getEverLostFollowupCount()
					-result.getSurvivalState().getAlreadyAllotTask();
			result.getSurvivalState().setNotAllotTask(notAllotTasktotal);
		}*/
		
		/*//应随访人数
		int shouldFollowupCount=followupResultDao.findShouldFollowupCount(req);
		result.setShouldFollowupCount(shouldFollowupCount);
		//未随访人数
		result.setNotFollowupCount(shouldFollowupCount-result.getAlreadyFollowupCount());
		//已随访中生存数
		SurvivalStateSpread survivalState=result.getSurvivalState();
		int surviveFollowupCount=result.getAlreadyFollowupCount()-survivalState.getDeathFollowupCount()-survivalState.getInvalidFollowupCount()-survivalState.getLostFollowupCount();
		result.getSurvivalState().setSurviveFollowupCount(surviveFollowupCount);
		//其他随访方式总数
		FollowupWaySpread followupWay=result.getFollowupWay();
		int otherFollowupCount=result.getAlreadyFollowupCount()-followupWay.getOutpatientFollowupCount()-followupWay.getPhoneFollowupCount()-followupWay.getSmsFollowupCount()-followupWay.getWexinFollowupCount();
		result.getFollowupWay().setOtherFollowupCount(otherFollowupCount);*/
		return result;
	}
	
	
	/**
	 * 患者统计部分
	 * @param req
	 * @return
	 */
	@Override
	public Map<String,Object> statisticsFollowupPatient(FollowupPatientStatisticsReq req) {
		if(req ==null){
			throw new EmptyParamExcption(" parame is null");
		}
		RConfDataPrivilege rConfDataPrivilege = authorizationService.findDataPrivilegeByDoctor(req.getOperator());
		ConfGlobal conf = confGlobalDao.queryConfGlobal();
		boolean flag = false;//默认是B端
		Map<String,Object> result = new HashMap<String,Object>();
		if(req.getStatisticsTypes() !=null && req.getStatisticsTypes().length > 0){
			FollowupPatientStatusStatisticsReq statisticsReq = new FollowupPatientStatusStatisticsReq();
			statisticsReq.setOperator(req.getOperator());
			statisticsReq.setOutPatientFlag(2);//默认B端
			if(rConfDataPrivilege != null && rConfDataPrivilege.getDataId() != null) {
				statisticsReq.setDataId(rConfDataPrivilege.getDataId());
				statisticsReq.setOutPatientFlag(null);
			}else {
				if(conf != null) {
					if(conf.getDeployLocation() != null && conf.getDeployLocation() == 2) {
						statisticsReq.setDeployLocation(conf.getDeployLocation());
						flag = true;
						int existFlag = userRoleDao.existUserRoleRelationship(req.getOperator(), req.getUserRole());
						if(existFlag > 0) {
							statisticsReq.setUserRole(req.getUserRole());
						}
					}
				}
			}
			if(flag) {
				TRDoctor rDoctor = doctorService.getTRDoctorByDoctorId(req.getOperator());
				if(rDoctor != null) {
					statisticsReq.setDoctorLevel(rDoctor.getDoctorLevel());
				}
				statisticsReq.setOutPatientFlag(null);
			}
			statisticsReq.setHospitalId(req.getHospitalId());
			
			// add by zhuguo
			if (req.getOperator() != null) {
				boolean roleResult = organizationDoctorService.queryDoctorRoleById(req.getOperator(), null);
				if (roleResult) {
					String powerSql = organizationDoctorService.getPatientSql(req.getOperator(), null);
					if (powerSql == null || "".equals(powerSql)) {
						LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
					} else {
						statisticsReq.setPowerSql(powerSql);
					}
				}
			}
			// end
			
			LogUtil.log.info("患者统计=>"+statisticsReq.toString());
			for(String type:req.getStatisticsTypes()){
				switch (type) {
				case Constants.PatientStatistics.TOTAL:
					result.put(Constants.PatientStatistics.TOTAL+"Patient", patientDao.statisticsTotalPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.TUMOR:
					result.put(Constants.PatientStatistics.TUMOR+"Patient", patientDao.statisticsTumorPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.TASK:
					result.put(Constants.PatientStatistics.TASK+"Patient", patientDao.statisticsTaskPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.LOST_FOLLOWUP:
					result.put(Constants.PatientStatistics.LOST_FOLLOWUP+"Patient", patientDao.statisticsLostFollowupPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.SIMILAR:
					result.put(Constants.PatientStatistics.SIMILAR+"Patient", patientDao.statisticsSimilarPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.FAULT:
					result.put(Constants.PatientStatistics.FAULT+"Patient", patientDao.statisticsFaultPatient(statisticsReq));
					break;
				default:
					break;
				}
			}
		}
		flag = false;
		/** 263 add by yuanwenming start */
		if(req.getStatisticsReqs() != null && req.getStatisticsReqs().length > 0) {
			for(FollowupPatientStatusStatisticsReq statisticsReq:req.getStatisticsReqs()){
				statisticsReq.setOperator(req.getOperator());
				statisticsReq.setOutPatientFlag(2);//默认B端
				if(rConfDataPrivilege != null && rConfDataPrivilege.getDataId() != null) {
					statisticsReq.setDataId(rConfDataPrivilege.getDataId());
					statisticsReq.setOutPatientFlag(null);
				}else {
					if(conf != null) {
						if(conf.getDeployLocation() != null && conf.getDeployLocation() == 2) {
							statisticsReq.setDeployLocation(conf.getDeployLocation());
							flag = true;
						}
					}
				}
				if(flag) {
					TRDoctor rDoctor = null;
					rDoctor = doctorService.getTRDoctorByDoctorId(req.getOperator());
					if(rDoctor != null) {
						statisticsReq.setDoctorLevel(rDoctor.getDoctorLevel());
					}
					statisticsReq.setOutPatientFlag(null);
				}
				LogUtil.log.info("患者情况统计=>"+statisticsReq.toString());
				switch (statisticsReq.getStatisticsType()) {
				case Constants.PatientStatistics.TUMOR_STATUS:
					result.put("tumourStatusStatistics", patientDao.statisticsTumorStatusPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.TUMOR_PART:
					result.put("tumourPartStatistics", patientDao.statisticsTumourPartPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.DISEASE_TYPE:
					result.put("diseaseTypeStatistics", patientDao.statisticsDiseaseTypePatient(statisticsReq));
					break;
				case Constants.PatientStatistics.DEPARTMENT:
					result.put("departmentStatistics", patientDao.statisticsDepartmentPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.AREA:
					result.put("areaStatistics", patientDao.statisticsAreaPatient(statisticsReq));
					break;
				case Constants.PatientStatistics.AGE:
					result.put("ageStatistics", patientDao.statisticsAgePatient(statisticsReq));
					break;
				case Constants.PatientStatistics.SEX:
					result.put("sexStatistics", patientDao.statisticsSexPatient(statisticsReq));
					break;
				default:
					break;
				}
			}
		}
		/** 263 add by yuanwenming end */
		return result;
	}
	
	/**
	 * 随访工作量统计-按随访方式统计
	 * @param commonParam
	 * @return
	 */
	private TStatisticResultInfo workloadStatisticsByFollowupWay(TCommonParam commonParam) {
		TFollowupWayStatisticResultInfo statisticResultInfo = new TFollowupWayStatisticResultInfo();
		statisticResultInfo.setExportTemplateId("EXPT014");

		if(commonParam != null) {
			ConfGlobal conf = confGlobalDao.queryConfGlobal();
			//随访范围写入
			if(conf!=null){
				commonParam.setFollowupRangeFlag(conf.getFollowupRangeFlag());
				commonParam.setSourceTumorFlags(conf.getNotMalignantTumorFlag());
			}
		}
		
		// add by zhuguo
		if (commonParam.getUserId() != null) {
			// boolean result =
			// organizationDoctorService.queryDoctorRoleById(null,
			// commonParam.getUserId());
			// if (result) {
			// String powerSql = organizationDoctorService.getPatientSql(null,
			// commonParam.getUserId());
			// if (powerSql == null) {
			// LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			// } else {
			// commonParam.setSql(powerSql);
			// }
			// }

			String powerSql = organizationDoctorService.getDoctorIdSql(null, commonParam.getUserId());
			if (powerSql == null || "".equals(powerSql)) {
				LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
			} else {
				commonParam.setSql(powerSql);
			}
		}
		// end
		
		String jsonStr = this.statsExportTemplateDao.findExportTitleInfo(statisticResultInfo.getExportTemplateId());
		TFollowupWayStatisticInfo followupWayStatistic = com.esuizhen.cloudservice.statistics.util.JsonUtil.convertTableHandByFollowupWay(jsonStr);
		statisticResultInfo.setFollowupWayStatistic(followupWayStatistic);
		//电话、短信、微信随访
		commonParam.setCategory(1);
		commonParam.setFollowupWay("1,2,4");
		List<Map<String, Object>> values = this.followupResultDao.statisticsWorkloadByFollowupWay(commonParam);
		if (values != null && !values.isEmpty()) {
			for (int i = values.size() - 1; i>= 0; i--) {
				Map<String, Object> map = values.get(i);
				if (map == null) {
					values.remove(i);
				}
			}
		}
		fillEmptyData(values,1);
		if (values != null && !values.isEmpty()) {
			statisticResultInfo.setValues(values);
			this.saveReturnResult(commonParam, statisticResultInfo, values);
			followupWayStatistic.setFollowupWayValues(values);
			statisticResultInfo.setFollowupWaySearchId(statisticResultInfo.getSearchId());
		}
		//门诊/住院复诊
		commonParam.setCategory(2);
		commonParam.setFollowupWay("7,8");
		values = this.followupResultDao.statisticsWorkloadByFollowupWay(commonParam);
		if (values != null && !values.isEmpty()) {
			for (int i = values.size() - 1; i>= 0; i--) {
				Map<String, Object> map = values.get(i);
				if (map == null) {
					values.remove(i);
				}
			}
		}
		fillEmptyData(values,2);
		if (values != null && !values.isEmpty()) {
			statisticResultInfo.setValues(values);
			this.saveReturnResult(commonParam, statisticResultInfo, values);
			followupWayStatistic.setOutPatientFlagValues(values);
			statisticResultInfo.setOutPatientFlagSearchId(statisticResultInfo.getSearchId());
		}
		//合计
		commonParam.setCategory(3);
		commonParam.setFollowupWay(null);
		values = this.followupResultDao.statisticsWorkloadByFollowupWay(commonParam);
		if (values != null && !values.isEmpty()) {
			for (int i = values.size() - 1; i>= 0; i--) {
				Map<String, Object> map = values.get(i);
				if (map == null) {
					values.remove(i);
				}
			}
		}
		if (values != null && !values.isEmpty()) {
			statisticResultInfo.setValues(values);
			this.saveReturnResult(commonParam, statisticResultInfo, values);
			followupWayStatistic.setFollowupWayTotalValues(values);
			statisticResultInfo.setFollowupWayTotalSearchId(statisticResultInfo.getSearchId());
		}
		return statisticResultInfo;
	}
	
	private void fillEmptyData(List<Map<String, Object>> values,Integer category) {
		if(values == null) {
			values = new ArrayList<Map<String, Object>>();
			if(category == 1) {
				Map<String, Object> noteMap = new HashMap<String, Object>();
				noteMap.put("followUpWay", "短信随访");
				noteMap.put("finishedQuantity", 0);
				noteMap.put("followupCount", 0);
				noteMap.put("effectiveFollowup", 0);
				noteMap.put("invalidFollowup", 0);
				noteMap.put("effectiveStable", 0);
				noteMap.put("effectiveRecrudescence", 0);
				noteMap.put("effectiveTransfer", 0);
				noteMap.put("effectiveDeath", 0);
				noteMap.put("invalidOther", 0);
				noteMap.put("invalidNoanswer", 0);
				noteMap.put("invalidRefuse", 0);
				noteMap.put("invalidEmpty", 0);
				noteMap.put("invalidWrong", 0);
				noteMap.put("invalidActiveRefuse", 0);
				noteMap.put("invalidOff", 0);
				noteMap.put("invalidNotservice", 0);
				noteMap.put("invalidDisconnected", 0);
				values.add(noteMap);
				Map<String, Object> phoneMap = new HashMap<String, Object>();
				phoneMap.put("followUpWay", "电话随访");
				phoneMap.put("finishedQuantity", 0);
				phoneMap.put("followupCount", 0);
				phoneMap.put("effectiveFollowup", 0);
				phoneMap.put("invalidFollowup", 0);
				phoneMap.put("effectiveStable", 0);
				phoneMap.put("effectiveRecrudescence", 0);
				phoneMap.put("effectiveTransfer", 0);
				phoneMap.put("effectiveDeath", 0);
				phoneMap.put("invalidOther", 0);
				phoneMap.put("invalidNoanswer", 0);
				phoneMap.put("invalidRefuse", 0);
				phoneMap.put("invalidEmpty", 0);
				phoneMap.put("invalidWrong", 0);
				phoneMap.put("invalidActiveRefuse", 0);
				phoneMap.put("invalidOff", 0);
				phoneMap.put("invalidNotservice", 0);
				phoneMap.put("invalidDisconnected", 0);
				values.add(phoneMap);
				Map<String, Object> webchatMap = new HashMap<String, Object>();
				webchatMap.put("followUpWay", "微信随访");
				webchatMap.put("finishedQuantity", 0);
				webchatMap.put("followupCount", 0);
				webchatMap.put("effectiveFollowup", 0);
				webchatMap.put("invalidFollowup", 0);
				webchatMap.put("effectiveStable", 0);
				webchatMap.put("effectiveRecrudescence", 0);
				webchatMap.put("effectiveTransfer", 0);
				webchatMap.put("effectiveDeath", 0);
				webchatMap.put("invalidOther", 0);
				webchatMap.put("invalidNoanswer", 0);
				webchatMap.put("invalidRefuse", 0);
				webchatMap.put("invalidEmpty", 0);
				webchatMap.put("invalidWrong", 0);
				webchatMap.put("invalidActiveRefuse", 0);
				webchatMap.put("invalidOff", 0);
				webchatMap.put("invalidNotservice", 0);
				webchatMap.put("invalidDisconnected", 0);
				values.add(webchatMap);
			}else if(category == 2) {
				Map<String, Object> outPatientMap = new HashMap<String, Object>();
				outPatientMap.put("followUpWay", "门诊复诊");
				outPatientMap.put("finishedQuantity", 0);
				outPatientMap.put("followupCount", 0);
				outPatientMap.put("effectiveFollowup", 0);
				outPatientMap.put("effectiveDeath", 0);
				outPatientMap.put("treatmentLive", 0);
				values.add(outPatientMap);
				Map<String, Object> hospitalMap = new HashMap<String, Object>();
				hospitalMap.put("followUpWay", "住院复诊");
				hospitalMap.put("finishedQuantity", 0);
				hospitalMap.put("followupCount", 0);
				hospitalMap.put("effectiveFollowup", 0);
				hospitalMap.put("effectiveDeath", 0);
				hospitalMap.put("treatmentLive", 0);
				values.add(hospitalMap);
			}
		}else {
			//默认是没有随访方式值
			boolean note = true;
			boolean phone = true;
			boolean webchat = true;
			boolean outPatientFlag = true;
			boolean hospitalFlag = true;
			Iterator<Map<String, Object>> itor = values.iterator();
			while(itor.hasNext()) {
				Map<String, Object> map = itor.next();
				Integer followupWayVal = (Integer)map.get("followupWayVal");
				if(followupWayVal != null && followupWayVal == 1) {
					note = false;
				}else if(followupWayVal != null && followupWayVal == 2) {
					phone = false;
				}else if(followupWayVal != null && followupWayVal == 4) {
					webchat = false;
				}else if(followupWayVal != null && followupWayVal == 7) {
					outPatientFlag = false;
				}else if(followupWayVal != null && followupWayVal == 8) {
					hospitalFlag = false;
				}
			}
			if(category == 1) {
				if(note) {
					Map<String, Object> followupWayMap = new HashMap<String, Object>();
					followupWayMap.put("followUpWay", "短信随访");
					followupWayMap.put("finishedQuantity", 0);
					followupWayMap.put("followupCount", 0);
					followupWayMap.put("effectiveFollowup", 0);
					followupWayMap.put("invalidFollowup", 0);
					followupWayMap.put("effectiveStable", 0);
					followupWayMap.put("effectiveRecrudescence", 0);
					followupWayMap.put("effectiveTransfer", 0);
					followupWayMap.put("effectiveDeath", 0);
					followupWayMap.put("invalidOther", 0);
					followupWayMap.put("invalidNoanswer", 0);
					followupWayMap.put("invalidRefuse", 0);
					followupWayMap.put("invalidEmpty", 0);
					followupWayMap.put("invalidWrong", 0);
					followupWayMap.put("invalidActiveRefuse", 0);
					followupWayMap.put("invalidOff", 0);
					followupWayMap.put("invalidNotservice", 0);
					followupWayMap.put("invalidDisconnected", 0);
					values.add(followupWayMap);
				}
				if(phone) {
					Map<String, Object> followupWayMap = new HashMap<String, Object>();
					followupWayMap.put("followUpWay", "电话随访");
					followupWayMap.put("finishedQuantity", 0);
					followupWayMap.put("followupCount", 0);
					followupWayMap.put("effectiveFollowup", 0);
					followupWayMap.put("invalidFollowup", 0);
					followupWayMap.put("effectiveStable", 0);
					followupWayMap.put("effectiveRecrudescence", 0);
					followupWayMap.put("effectiveTransfer", 0);
					followupWayMap.put("effectiveDeath", 0);
					followupWayMap.put("invalidOther", 0);
					followupWayMap.put("invalidNoanswer", 0);
					followupWayMap.put("invalidRefuse", 0);
					followupWayMap.put("invalidEmpty", 0);
					followupWayMap.put("invalidWrong", 0);
					followupWayMap.put("invalidActiveRefuse", 0);
					followupWayMap.put("invalidOff", 0);
					followupWayMap.put("invalidNotservice", 0);
					followupWayMap.put("invalidDisconnected", 0);
					values.add(followupWayMap);
				}
				if(webchat) {
					Map<String, Object> followupWayMap = new HashMap<String, Object>();
					followupWayMap.put("followUpWay", "微信随访");
					followupWayMap.put("finishedQuantity", 0);
					followupWayMap.put("followupCount", 0);
					followupWayMap.put("effectiveFollowup", 0);
					followupWayMap.put("invalidFollowup", 0);
					followupWayMap.put("effectiveStable", 0);
					followupWayMap.put("effectiveRecrudescence", 0);
					followupWayMap.put("effectiveTransfer", 0);
					followupWayMap.put("effectiveDeath", 0);
					followupWayMap.put("invalidOther", 0);
					followupWayMap.put("invalidNoanswer", 0);
					followupWayMap.put("invalidRefuse", 0);
					followupWayMap.put("invalidEmpty", 0);
					followupWayMap.put("invalidWrong", 0);
					followupWayMap.put("invalidActiveRefuse", 0);
					followupWayMap.put("invalidOff", 0);
					followupWayMap.put("invalidNotservice", 0);
					followupWayMap.put("invalidDisconnected", 0);
					values.add(followupWayMap);
				}
			}else if(category == 2) {
				if(outPatientFlag) {
					Map<String, Object> followupWayMap = new HashMap<String, Object>();
					followupWayMap.put("followUpWay", "门诊复诊");
					followupWayMap.put("finishedQuantity", 0);
					followupWayMap.put("followupCount", 0);
					followupWayMap.put("effectiveFollowup", 0);
					followupWayMap.put("effectiveDeath", 0);
					followupWayMap.put("treatmentLive", 0);
					values.add(followupWayMap);
				}
				if(hospitalFlag) {
					Map<String, Object> followupWayMap = new HashMap<String, Object>();
					followupWayMap.put("followUpWay", "住院复诊");
					followupWayMap.put("finishedQuantity", 0);
					followupWayMap.put("followupCount", 0);
					followupWayMap.put("effectiveFollowup", 0);
					followupWayMap.put("effectiveDeath", 0);
					followupWayMap.put("treatmentLive", 0);
					values.add(followupWayMap);
				}
			}
		}
	}
}

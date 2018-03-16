package com.esuizhen.cloudservice.statistics.service;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.statistics.bean.FollowupPatientStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsResult;
import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TDailyGainPatient;
import com.esuizhen.cloudservice.statistics.bean.TFollowupProgressInfo;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultStatistics;
import com.esuizhen.cloudservice.statistics.bean.TFollowupWayProgressInfo;
import com.esuizhen.cloudservice.statistics.bean.TStatisticResultInfo;
import com.westangel.common.excption.InsufficientParameterExcption;

public interface FollowupStatisticsService {

	/**
	 * <p>Title:statisticsFollowupProgress</p>
	 * <p>Description:统计随访进展情况，各个随访任务的分布情况</p>
	 * @author YYCHEN
	 * @date 2016年8月8日 下午5:16:01
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	TFollowupProgressInfo statisticsFollowupProgress(String followupTaskId, String followupAssignId, Long userId);

	/**
	 * <p>Title:statisticsFollowupResult</p>
	 * <p>Description:各随访结果统计</p>
	 * @author YYCHEN
	 * @date 2016年8月9日 下午5:17:15
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	List<TFollowupResultStatistics> statisticsFollowupResult(String followupTaskId, String followupAssignId, Long userId);

	/**
	 * <p>Title:statisticsFollowupWayProgress</p>
	 * <p>Description:统计随访方式分布情况</p>
	 * @author YYCHEN
	 * @date 2016年8月10日 下午4:20:03
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	List<TFollowupWayProgressInfo> statisticsFollowupWayProgress(String followupTaskId, String followupAssignId,
			Long userId);

	/**
	 * <p>Title:statisticsFollowupWorkload</p>
	 * <p>Description:分别通过按科室、按随访人员、按病种统计随访工作量</p>
	 * @author YYCHEN
	 * @date 2016年8月10日 下午6:15:29
	 * @param commonParam
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	TStatisticResultInfo statisticsFollowupWorkload(TCommonParam commonParam) throws InsufficientParameterExcption;

	/**
	 * <p>Title:statisticsFollowupTelephoneConnRate</p>
	 * <p>Description:分别通过按科室、按随访人员、按病种统计随访电话接通率情况。</p>
	 * @author YYCHEN
	 * @date 2016年8月10日 下午8:20:46
	 * @param commonParam
	 * @return
	 */
	TStatisticResultInfo statisticsFollowupTelephoneConnRate(TCommonParam commonParam);

	/**
	 * <p>Title:statisticsDailyGainPatientList</p>
	 * <p>Description:统计每日新增患者信息，及患者信息变化总数</p>
	 * @author YYCHEN
	 * @date 2016年8月11日 上午10:26:27
	 * @param commonParam
	 * @return
	 */
	TDailyGainPatient statisticsDailyGainPatientList(TCommonParam commonParam);

	/**
	 * <p>Title:statisticsLostFollowPatient</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月17日 下午5:41:41
	 * @param allFlag
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	List<Map<String, Object>> statisticsLostFollowPatient(Integer allFlag, Long doctorId) throws InsufficientParameterExcption;

	/**
	 * 随访进度统计
	 * @author Nidan
	 * @title:statisticsFollowupSchedule
	 * @Description:统计随访进度情况，生存状态统计，随访方式分布，无效随访原因统计
	 * @return FollowupScheduleStatisticsResult
	 * @date 2016年11月26日上午11:56:59
	 */
	FollowupScheduleStatisticsResult statisticsFollowupSchedule(FollowupScheduleStatisticsReq req);

	/**
	 * 随访肿瘤患者数统计
	 * @author Nidan
	 * @title:statisticsFollowupPatient
	 * @Description:
	 * @return FollowupPatientStatisticsResult
	 * @date 2016年11月28日上午11:52:32
	 */
	Map<String, Object> statisticsFollowupPatient(FollowupPatientStatisticsReq req);

}

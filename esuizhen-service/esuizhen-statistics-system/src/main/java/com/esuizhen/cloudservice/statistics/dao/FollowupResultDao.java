package com.esuizhen.cloudservice.statistics.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsResult;
import com.esuizhen.cloudservice.statistics.bean.FollowupWaySpread;
import com.esuizhen.cloudservice.statistics.bean.InvalidFollowupReasonsSpread;
import com.esuizhen.cloudservice.statistics.bean.SurvivalStateSpread;
import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TDailyGainPatient;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultStatistics;
import com.esuizhen.cloudservice.statistics.bean.TaskPatientSpread;
import com.esuizhen.cloudservice.statistics.bean.TumorPatientSpread;

public interface FollowupResultDao {
	
	/**
	 * <p>Title:findFollowupResult</p>
	 * <p>Description:获取随访结果对象</p>
	 * @author YYCHEN
	 * @date 2016年8月11日 下午6:18:16
	 * @param followupResultValueId
	 * @return
	 */
	TFollowupResultStatistics findFollowupResult(@Param("followupResultValueId")Integer followupResultValueId);

	/**
	 * <p>Title:statisticsFollowupWorkload</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月12日 上午10:09:33
	 * @param otherFollowupResultType
	 * @return
	 */
	List<Map<String, Object>> statisticsFollowupWorkload(TCommonParam commonParam);

	/**
	 * <p>Title:statisticsFollowupTelephoneConnRateForDept</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月13日 下午7:29:11
	 * @param commonParam
	 * @return
	 */
	List<Map<String, Object>> statisticsFollowupTelephoneConnRateForDept(@Param("commonParam")TCommonParam commonParam);
	/**
	 * <p>Title:statisticsFollowupTelephoneConnRateForOperator</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月12日 下午10:57:15
	 * @param commonParam
	 * @return
	 */
	List<Map<String, Object>> statisticsFollowupTelephoneConnRateForOperator(@Param("commonParam")TCommonParam commonParam);
	
	/**
	 * <p>Title:findFollowupResultStatistics</p>
	 * <p>Description:随访结果统计</p>
	 * @author YYCHEN
	 * @date 2016年8月9日 下午6:06:45
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @param type
	 * @param total
	 * @return
	 */
	List<TFollowupResultStatistics> findFollowupResultStatistics(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId,
			@Param("userId")Long userId, @Param("type")Integer type, @Param("ratio")Integer ratio, @Param("total")Integer total);
	
	/**
	 * <p>Title:findFollowupResultTypeTotal</p>
	 * <p>Description:查询随访结果类型总数</p>
	 * @author YYCHEN
	 * @date 2016年8月9日 下午6:36:39
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @param type
	 * @return
	 */
	int findFollowupResultTypeTotal(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId, @Param("userId")Long userId, @Param("type")Integer type);
	/**
	 * <p>Title:statisticsFollowupTelephoneConnRateForDiseaseType</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月13日 下午3:55:08
	 * @param commonParam
	 * @return
	 */
	List<Map<String, Object>> statisticsFollowupTelephoneConnRateForDiseaseType(@Param("commonParam")TCommonParam commonParam);

	/**
	 * <p>Title:statisticsDailyGainPatientListSum</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月15日 上午10:14:00
	 * @param commonParam
	 * @return
	 */
	TDailyGainPatient statisticsDailyGainPatientListSum(@Param("commonParam")TCommonParam commonParam);
	/**
	 * <p>Title:statisticsDailyGainPatientList</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月14日 下午4:35:30
	 * @param commonParam
	 * @return
	 */
	List<TDailyGainPatient> statisticsDailyGainPatientList(@Param("commonParam")TCommonParam commonParam);

	List<Map<String, Object>> statisticsLostFollowPatient(@Param("allFlag")Integer allFlag, @Param("powerSql")String powerSql);

	/**
	 * <p>Title:findLastFollowupResultTypeTotal</p>
	 * <p>Description:查询最后一次随访总数</p>
	 * @author YYCHEN
	 * @date 2016年9月1日 下午4:05:18
	 * @param type
	 * @return
	 */
	Integer findLastFollowupResultTypeTotal(@Param("type")Integer type);

	/**
	 * <p>Title:findLastFollowupResultStatistics</p>
	 * <p>Description:最后一次随访结果统计</p>
	 * @author YYCHEN
	 * @date 2016年9月1日 下午4:16:09
	 * @param type
	 * @param ratio
	 * @param total
	 * @return
	 */
	List<TFollowupResultStatistics> findLastFollowupResultStatistics(@Param("type")Integer type, @Param("ratio")Integer ratio, @Param("total")Integer total);

	/**
	 * 按随访人员统计随访工作量
	 * @param commonParam
	 * @return
	 */
	List<Map<String, Object>> statisticsOperatorFollowupWorkload(TCommonParam commonParam);

	/**
	 * 按随访任务统计随访工作量
	 * @param commonParam
	 * @return
	 */
	List<Map<String, Object>> statisticsTaskFollowupWorkload(TCommonParam commonParam);

	/**
	 * 应随访总人数
	 * @author Nidan
	 * @title:findShouldFollowupCount
	 * @Description:
	 * @return int
	 * @date 2016年11月26日下午2:57:24
	 */
	int findShouldFollowupCount(FollowupScheduleStatisticsReq req);

	/**
	 * 已随访结果信息统计
	 * @author Nidan
	 * @title:findAlreadyFollowupCount
	 * @Description:
	 * @return int
	 * @date 2016年11月26日下午3:01:53
	 */
	FollowupScheduleStatisticsResult statisticsFollowupScheduleInfo(FollowupScheduleStatisticsReq req);

	/**
	 * 统计全员肿瘤患者信息
	 * @author Nidan
	 * @title:statisticsTumorPatient
	 * @Description:
	 * @return TumorPatientSpread
	 * @date 2016年11月28日上午11:56:48
	 */
	TumorPatientSpread statisticsTumorPatient();

	/**
	 * 统计当前任务中的患者信息
	 * @author Nidan
	 * @title:statisticsTaskPatient
	 * @Description:
	 * @return TaskPatientSpread
	 * @date 2016年11月28日上午11:57:04
	 */
	TaskPatientSpread statisticsTaskPatient();
	
	/**
	 * add by fanpanwei 获取非恶性肿瘤筛选的全局配置
	 */
	HashMap<String, Object> querySourceTumorFlag();
	
	/**
	 * 按随访方式统计
	 * @param commonParam
	 * @return
	 */
	List<Map<String, Object>> statisticsWorkloadByFollowupWay(TCommonParam commonParam);
}

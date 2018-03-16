package com.esuizhen.cloudservice.statistics.dao;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.statistics.bean.TFollowupWayProgressInfo;

public interface FollowupWayDao {

	/**
	 * <p>Title:statisticsWXFollowupWay</p>
	 * <p>Description:统计微信随访方式的随访量</p>
	 * @author YYCHEN
	 * @date 2016年8月11日 上午10:58:31
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	TFollowupWayProgressInfo statisticsWXFollowupWay(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId, @Param("userId")Long userId);

	/**
	 * <p>Title:statisticsSMSFollowupWay</p>
	 * <p>Description:统计短信随访方式的随访量</p>
	 * @author YYCHEN
	 * @date 2016年8月11日 上午11:08:41
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	TFollowupWayProgressInfo statisticsSMSFollowupWay(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId, @Param("userId")Long userId);
	
	/**
	 * <p>Title:statisticsCallFollowupWay</p>
	 * <p>Description:电话随访方式的随访量</p>
	 * @author YYCHEN
	 * @date 2016年8月11日 下午3:50:25
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	TFollowupWayProgressInfo statisticsCallFollowupWay(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId, @Param("userId")Long userId);
	
	/**
	 * <p>Title:statisticsTreatmentFollowupWay</p>
	 * <p>Description:就诊自动标记随访方式的随访量</p>
	 * @author YYCHEN
	 * @date 2016年8月11日 下午3:50:48
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	TFollowupWayProgressInfo statisticsTreatmentFollowupWay(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId, @Param("userId")Long userId);
	
}

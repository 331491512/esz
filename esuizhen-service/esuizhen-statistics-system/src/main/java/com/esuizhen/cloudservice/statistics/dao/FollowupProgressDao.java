package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.statistics.bean.TFollowupProgressInfo;

/**
 * <p>Title:FollowupProgress</p>
 * <p>Description:随访进展数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年8月9日 上午10:45:14
 */
public interface FollowupProgressDao {
	/**
	 * <p>Title:findPersonalFollowupProgress</p>
	 * <p>Description:随访人员个人随访进展统计</p>
	 * @author YYCHEN
	 * @date 2016年8月9日 上午10:56:34
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	List<TFollowupProgressInfo> findPersonalFollowupProgress(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId, @Param("userId")Long userId);
	
	/**
	 * <p>Title:findFollowupProgress</p>
	 * <p>Description:随访任务总进展统计</p>
	 * @author YYCHEN
	 * @date 2016年8月9日 上午11:39:58
	 * @param followupTaskId
	 * @param userId
	 * @return
	 */
	TFollowupProgressInfo findFollowupProgress(@Param("followupTaskId")String followupTaskId, @Param("userId")Long userId);

	/**
	 * <p>Title:findAllFollowupProgress</p>
	 * <p>Description:所有患者随访进展</p>
	 * @author YYCHEN
	 * @date 2016年8月17日 下午5:09:45
	 * @param followupTaskId
	 * @param object
	 * @return
	 */
	TFollowupProgressInfo findAllFollowupProgress(Map<String,Object> paramsMap);
	
	/**
	 * <p>Title:findNotFinished</p>
	 * <p>Description:未完成和未结束的随访任务进展统计</p>
	 * @author YYCHEN
	 * @date 2016年8月9日 下午3:54:44
	 * @return
	 */
	List<TFollowupProgressInfo> findNotFinished();

	/**
	 * <p>Title:findFollowupProgressList</p>
	 * <p>Description:查看随访任务列表进展</p>
	 * @author YYCHEN
	 * @date 2016年8月19日 下午2:33:20
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	List<TFollowupProgressInfo> findFollowupProgressList(@Param("followupTaskId")String followupTaskId, @Param("followupAssignId")String followupAssignId, @Param("userId")Long userId, @Param("limit")Integer limit);
	
	/**
	 * 患者总数统计
	 * @param paramsMap
	 * @return
	 */
	int countPatientNum(Map<String,Object> paramsMap);
}

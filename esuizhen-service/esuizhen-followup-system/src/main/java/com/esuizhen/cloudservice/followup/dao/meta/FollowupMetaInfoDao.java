/**
 * 
 */
package com.esuizhen.cloudservice.followup.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.model.meta.FollowupOperatorInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.model.meta.FollowupWay;

/**
 * @author DaLoong
 * @date  2016-8-13 下午12:04:46
 */
public interface FollowupMetaInfoDao {

	public List<FollowupOperatorInfo> getFollowupOperatorListInTask(String followupTaskId, String sql);

	public List<FollowupOperatorInfo> getAllOpertorList(@Param("hospitalId") Integer hospitalId, @Param("sql") String sql) ;

	public List<FollowupResultValue> getMetaInfoFollowupResultValueList(@Param("type")
			Integer type);

	public List<FollowupWay> getMetaInfoFollowupWayList();
	
	public FollowupWay getMetaInfoFollowupWayByFollowupWayId(@Param("followupWayId")Integer followupWayId);

	public FollowupResultValue getMetaInfoFollowupResultValueById(@Param("followupResultValueId") Integer followupResultValueId);
	
	public FollowupWay getMetaInfoFollowupWayById(@Param("followupWayId") Integer followupWayId);
	
	public FollowupOperatorInfo getFollowupOperatorById(@Param("operator") Long operator);

	public void updateFollowupResultValueType(FollowupResultValue followupResultValue);

}

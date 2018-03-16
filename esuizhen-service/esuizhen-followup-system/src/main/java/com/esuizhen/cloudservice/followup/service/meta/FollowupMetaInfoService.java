/**
 * 
 */
package com.esuizhen.cloudservice.followup.service.meta;

import java.util.List;

import com.esuizhen.cloudservice.followup.model.meta.FollowupOperatorInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.model.meta.FollowupWay;

/**
 * @author DaLoong
 * @date  2016-8-13 上午10:51:49
 */
public interface FollowupMetaInfoService {

	List<FollowupOperatorInfo> getFollowupOperatorList(Integer hospitalId,String followupTaskId, Long doctorId);

	List<FollowupResultValue> getMetaInfoFollowupResultValueList(Integer type);

	List<FollowupWay> getMetaInfoFollowupWayList();

}

package com.esuizhen.cloudservice.followup.dao.review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.ReBasiserReviewOrderReq;
import com.esuizhen.cloudservice.followup.model.review.FollowupReviewAppoint;

public interface FollowupReviewAppointDao {
    int deleteByPrimaryKey(Integer appointId);

    int insert(ReBasiserReviewOrderReq reBasiserReviewOrderReq);

    int insertSelective(FollowupReviewAppoint record);

    FollowupReviewAppoint selectByPrimaryKey(Integer appointId);
    
    FollowupReviewAppoint selectByFollowup(@Param("followupTaskId")String followupTaskId,@Param("followupAssignId")String followupAssignId);
    
    List<FollowupReviewAppoint> queryByPage(Map<String, Object> paramsMap);
    
    List<Map<String,Object>> getRecord(@Param("sql") String sql);
    
    Map<String, Integer> queryReviewOrderSummary(@Param("userRole") Integer userRole,@Param("userId") Long userId);

    int updateByPrimaryKeySelective(FollowupReviewAppoint record);

    int updateByPrimaryKey(FollowupReviewAppoint record);
}
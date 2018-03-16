package com.esuizhen.cloudservice.followup.service.review;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.esuizhen.cloudservice.followup.bean.ReBasiserReviewOrderReq;
import com.esuizhen.cloudservice.followup.bean.ReviewRecordReq;
import com.esuizhen.cloudservice.followup.model.review.FollowupReviewAppoint;
import com.westangel.common.bean.Page;

public interface ReviewService {
	/**
	 * 
	 * @param reBasiserReviewOrderReq
	 * @return
	 */
	int reBasiserReviewOrder(ReBasiserReviewOrderReq reBasiserReviewOrderReq);
	/**
	 * 
	 * @param reviewRecordReq
	 * @return
	 */
	Page<FollowupReviewAppoint> queryReviewRecord(ReviewRecordReq reviewRecordReq);
	/**
	 * 
	 * @param reviewRecordReq
	 * @return
	 */
	String exportReviewRecord(ReviewRecordReq reviewRecordReq);
	/**
	 * 
	 * @param userRole
	 * @param userId
	 * @return
	 */
	Map<String,Integer> queryReviewOrderSummary(Integer userRole,Long userId);
	
	public int saveReviewOrderAnswer(FollowupReviewAppoint record);
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>ReviewAlertDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月24日下午4:12:16<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.business.model.business.TReviewAlertDetailInfo;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertStatisInfo;

/** 
* @ClassName: ReviewAlertDao
* @Description: 
* @author lichenghao
* @date 2017年8月24日 下午4:12:16  
*/
public interface ReviewAlertDao {
	//存储过程调用
	void callProReviewAlert();
	//需要推送消息的医生
	List<LinkedHashMap> queryNotSendReviewAlert();
	LinkedHashMap queryreviewBatch(@Param("reviewBatchId")String reviewBatchId);
	LinkedHashMap queryreviewDetail(@Param("reviewBatchId")String reviewBatchId);
	//修改批次推送状态 
	int updateReviewAlertSend(Object obj);
	//修改详情为发送状态
	int updateReviewAlertDetailSend(Object obj);
	//修改复查提醒批次详情
	int updateReviewAlertDetail(Object obj);
	
	//	获取提醒患者列表
	List<TReviewAlertDetailInfo> queryReviewAlertPatientListByBatchId(Object obj);
	//待提醒患者列表
	List<TReviewAlertDetailInfo> queryWaitPatientList(Object obj);
	//获取过期患者列表
	List<TReviewAlertDetailInfo> queryExpirPatientList(Object obj);
	//获取已预约赴约中
	List<TReviewAlertDetailInfo> queryProductApplyReviewAlert(Object obj);
	
	//获取患者发送列表
	List<LinkedHashMap> queryReviewAlertSendPatientList(Object obj);
	//获取提醒详情
	TReviewAlertDetailInfo queryReviewBatchDetailInfo(Object obj);
	//扫描未发送随访计划
	List<LinkedHashMap> queryFollowupPlanNotSend();
	//更新随访计划项发送状态
	void updateFollowupItemSend(@Param("followupItemId")String followupItem);
	//更新随访计划状态
	void callProFollowupPlanUpdate();
	//获取发送信息
	LinkedHashMap querySendInfoByReviewDetailId(@Param("reviewDetailId")String reviewDetailId);
	//获取统计信息
	TReviewAlertStatisInfo statisAlertNum(Object obj);
	//初始化未进入复查提醒详情中的信息
	int initNotInReviewAlert(Map<String, Object> params);
	//创建复查提醒详情
	int createReviewAlertDetail(Object info);
}

package com.esuizhen.cloudservice.followup.dao.daily;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.model.daily.DailyInfo;
import com.esuizhen.cloudservice.followup.model.statis.TStatisData;

/**
 * 
* @ClassName: DailyDao 
* @Description: 随访日报统计 
* @author lichenghao
* @date 2016年2月4日 下午2:44:29
 */
public interface DailyDao{
	
	//获取日报基本信息
	List queryDailInfo(Object params);
	
	//获取听医生日报
	DailyInfo queryDailyNewAddPatient(Object params);
	
	//获取前一天新增患者
	Integer queryAfterDayNewAddPatient(Object params);
	
	//获取随访计划总数
	Integer queryFollowResultCount(Object params);
	
	//获取随访方式总数（短信 电话）
	Integer queryFollowWayResultCount(Object params);
	
	//新增患者兵种统计
	List queryPatientDiseaseGroupResult(Object params);
	
	//随访计划随访类型
	List queryFollowupResultTypeCount(Object params);
	
	//复查提醒
	TStatisData queryFollowupIsAlertCount(Object params);
	
	//随访日报发送
	TStatisData queryFollowupQuestionIsAlertCount(Object params);
	
	//随访结果统计
	List queryFollowupResult(Object params);
	
	//随访结果3月数据统计
	List queryFollowupResultThreeMonth(Object params);
	
	//随访结果3月数据百分比
	List queryFollowupResultThreeMonthPercentage(Object params);
	
	//创建随访日报
	void createDaily(DailyInfo dailyInfo);
	
	//医生随访日报获取
	List queryDailyInfoList(@Param("doctorId") Long doctorId);
}

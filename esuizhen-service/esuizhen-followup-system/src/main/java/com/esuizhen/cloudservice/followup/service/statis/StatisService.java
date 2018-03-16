package com.esuizhen.cloudservice.followup.service.statis;

import com.esuizhen.cloudservice.followup.model.statis.TStatisResult;

/**
* @ClassName: FollowupStatisticsService 
* @Description: 随访接口统计 
* @author wang_hw
* @date 2016年1月15日 下午5:26:44
 */
public interface StatisService
{
	
	public TStatisResult querySURStatisResult(String doctorId ,String confirmedDateBegin ,String confirmedDateEnd , String diseaseTypeIds);
	
}

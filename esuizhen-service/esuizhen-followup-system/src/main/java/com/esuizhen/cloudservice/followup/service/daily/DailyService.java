package com.esuizhen.cloudservice.followup.service.daily;

import com.esuizhen.cloudservice.followup.model.daily.DailyInfo;
import com.esuizhen.cloudservice.followup.model.daily.FollowupDailyListReq;
import com.esuizhen.cloudservice.followup.model.daily.FollowupDailyStatisResultQueryReq;
import com.westangel.common.bean.Page;

/**
* @ClassName: FollowupStatisticsService 
* @Description: 随访接口统计 
* @author wang_hw
* @date 2016年1月15日 下午5:26:44
 */
public interface DailyService
{
	//日报基本信息
	public void sendDailyInfo(Long doctorId);
	//日报详细信息查询
	public Object queryDailyStaticResult(FollowupDailyStatisResultQueryReq req);
	//日报列表获取
	public Page<DailyInfo> getDailyInfoList(FollowupDailyListReq req);
}

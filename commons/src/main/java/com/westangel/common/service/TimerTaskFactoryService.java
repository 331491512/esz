package com.westangel.common.service;

import java.util.Date;

public interface TimerTaskFactoryService
{
	/**
	 * 
	 * @author wang_hw
	 * @title :createFollowupTask
	 * @Description:生成随访计划定时任务数据
	 * @return Integer
	 * @date 2016年1月8日 下午5:00:33
	 */
	public Integer createFollowupPlanTimerTask(String followupId);
	public Integer createFollowupPlanTimerTask(String followupId,String doctorName,Integer wxProductId);
	
	/**
	 * @author wang_hw
	 * @title :cancelFollowupPlanTimerTask
	 * @Description:取消随访计划
	 * @return Integer
	 * @date 2016年3月10日 下午5:55:20
	 */
	public Integer cancelFollowupPlanTimerTask(String followupId);
	
	/**
	 * @author wang_hw
	 * @title :creatDoAcceptTimeTask
	 * @Description:创建修改Accept状态任务
	 * @return void
	 * @date 2016年3月22日 下午2:32:36
	 */
	public void creatDoAcceptTimeTask(String productApplyId, String param);
	/**
	 * 
	 * @author lichenghao
	 * @title :creatDoAcceptTimeTask
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月21日 上午11:40:38
	 */
	public void creatDoAcceptTimeTask(String productApplyId, String param,String taskTag,Long addTimer);
	public void creatDoAcceptTimeTask(String productApplyId, String param,String taskTag,Date addTimer);
	
	/**
	 * 创建mdt提醒定时器
	 * @author lichenghao
	 * @title :createMdtTimer
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年4月13日 下午2:53:32
	 */
	public Integer createMdtAlertTimer(String productApplyId);
	
	
	/**
	 * 检查报状态变更提醒
	 * @author lichenghao
	 * @title :createInspectionReportCheckTimer
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月3日 下午5:44:29
	 */
	public void createInspectionReportCheckTimer(String productApplyId);
}

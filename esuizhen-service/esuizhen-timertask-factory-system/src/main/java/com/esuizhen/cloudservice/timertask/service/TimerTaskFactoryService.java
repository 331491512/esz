package com.esuizhen.cloudservice.timertask.service;

public interface TimerTaskFactoryService
{
	/**
	 * @author wang_hw
	 * @title :createTelconsultTimer
	 * @Description:生成电话咨询定时任务数据
	 * @return Integer
	 * @date 2016年1月20日 下午3:49:14
	 */
	public Integer createTelconsultTimer(String productApplyId) ;
	
	/**
	 * @author wang_hw
	 * @title :createGeneralserviceTimer
	 * @Description:通用任务数据生成
	 * @return Integer
	 * @date 2016年1月20日 下午3:49:25
	 */
	public Integer createGeneralserviceTimer(String productApplyId ,Integer productType , String taskTag); 
	
	
}

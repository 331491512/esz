package com.westangel.common.service;

import java.util.List;

import com.westangel.common.bean.timertask.Timertask;

/**
* @ClassName: TimetaskService 
* @Description: 定时器服务接口
* @author wang_hw
* @date 2016年1月13日 下午5:00:16
 */
public interface TimertaskService{
	
	/**
	 * @author wang_hw
	 * @title :createTimetask
	 * @Description:创建定时器
	 * @return void
	 * @date 2016年1月13日 下午5:01:15
	 */
	public Integer createTimetask(Timertask timetask);
	
	/**
	 * @author wang_hw
	 * @title :createTimetask
	 * @Description:创建定时器
	 * @return void
	 * @date 2016年1月13日 下午5:01:15
	 */
	public Integer createTimetaskList(List<Timertask> taskList);
	
	/**
	 * @author wang_hw
	 * @title :cancelTimetask
	 * @Description:取消定时器
	 * @return void
	 * @date 2016年1月13日 下午5:01:42
	 */
	public Integer cancelTimetask(int serviceType , String serviceTargetId , String taskTag);
	
	/**
	 * @author wang_hw
	 * @title :testPush
	 * @Description:测试推送
	 * @return void
	 * @date 2016年10月12日 上午10:49:43
	 */
	public void testPush(Long pushRuleId);
	
}

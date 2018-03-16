package com.westangel.timertask.dao;

import com.westangel.timertask.model.ConfTimer;

/**
* @ClassName: ConfTimerDao 
* @Description: 定时任务时间执行配置
* @author wang_hw
* @date 2016年2月24日 上午10:45:24
 */
public interface ConfTimerDao{
	
	/**
	 * @author wang_hw
	 * @title :insertConfTimer
	 * @Description:保存定时配置
	 * @return void
	 * @date 2016年2月24日 上午10:45:40
	 */
	public void insertConfTimer(ConfTimer confTimer);
	
	/**
	 * @author wang_hw
	 * @title :updateConfTimer
	 * @Description:TODO
	 * @return void
	 * @date 2016年2月24日 上午10:45:53
	 */
	public void updateConfTimer(ConfTimer confTimer);
	
	/**
	 * @author wang_hw
	 * @title :deleteConfTimer
	 * @Description:TODO
	 * @return void
	 * @date 2016年2月24日 上午10:45:56
	 */
	public void deleteConfTimer(Long confTimerId);
	
	/**
	 * @author wang_hw
	 * @title :queryConfTimer
	 * @Description:TODO
	 * @return ConfTimer
	 * @date 2016年2月24日 上午10:46:01
	 */
	public ConfTimer queryConfTimer(Long confTimerId);
	
}

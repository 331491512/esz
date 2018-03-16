package com.westangel.timertask.service;

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
	 * @title :updateTimetask
	 * @Description:更新定时器
	 * @return void
	 * @date 2016年1月13日 下午5:01:07
	 */
	public void updateTimetask(Timertask timetask);
	
	/**
	 * @author wang_hw
	 * @title :queryUserOpenId
	 * @Description:查看患者OpenId
	 * @return String
	 * @date 2016年1月13日 下午7:50:22
	 */
	public String queryUserOpenId(String userId,Integer productId);
	
	/**
	 * @author wang_hw
	 * @title :deleteTimetask
	 * @Description:删除定时器
	 * @return void
	 * @date 2016年1月13日 下午5:05:48
	 */
	public void deleteTimetask(String timetaskId);
	
	/**
	 * @author wang_hw
	 * @title :queryTimetaskById
	 * @Description:定时器查询
	 * @return Timetask
	 * @date 2016年1月13日 下午5:01:55
	 */
	public Timertask queryTimetaskById(String timetaskId);
	
	/**
	 * @author wang_hw
	 * @title :queryTimetaskByServiceType
	 * @Description:根据服务类型查询任务
	 * @return List<Timetask>
	 * @date 2016年1月13日 下午6:34:53
	 */
	public List<Timertask> queryTimetaskByServiceType(String serviceType ,Integer periodType  , String serviceTargetId);
	
	/**
	 * 
	 * @author wang_hw
	 * @title :queryTimetaskByServiceTypes
	 * @Description:根据多个类型查询任务
	 * @return List<Timertask>
	 * @date 2016年1月27日 下午1:26:16
	 */
	public List<Timertask> queryTimetaskByServiceTypes(String serviceTypes);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :execProcedure
	 * @Description:调用存储过程
	 * @return void
	 * @date 2017年8月24日 下午4:39:23
	 */
	public boolean execProcedure(String procedureContent);
}

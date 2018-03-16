package com.westangel.timertask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.timertask.Timertask;

/**
* @ClassName: TimetaskDao 
* @Description: 定时器数据录入接口
* @author wang_hw
* @date 2016年1月13日 下午5:04:49
 */
public interface TimertaskDao{
	
	/**
	 * @author wang_hw
	 * @title :insertTimetask
	 * @Description:录入定时器
	 * @return void
	 * @date 2016年1月13日 下午5:05:09
	 */
	public void insertTimetask(Timertask timetask);
	
	/**
	 * @author wang_hw
	 * @title :insertTimetaskList
	 * @Description:批量录入问题列表
	 * @return void
	 * @date 2016年2月18日 上午11:35:53
	 */
	public void insertTimetaskList(List<Timertask> list);
	
	/**
	 * @author wang_hw
	 * @title :updateTimetask
	 * @Description:修改定时器
	 * @return void
	 * @date 2016年1月13日 下午5:05:28
	 */
	public void updateTimetask(Timertask timetask);
	
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
	 * @title :deleteTimetaskByTargetId
	 * @Description:根据业务类型删除
	 * @return void
	 * @date 2016年1月14日 下午4:18:07
	 */
	public void deleteTimetaskByTargetId(@Param("serviceType") Integer  serviceType , @Param("serviceTargetId") String serviceTargetId , @Param("taskTag")String taskTag);
	
	/**
	 * @author wang_hw
	 * @title :queryTimetaskById
	 * @Description:查询定时器
	 * @return Timetask
	 * @date 2016年1月13日 下午5:06:03
	 */
	public Timertask queryTimetaskById(String timetaskId);
	
	/**
	 * @author wang_hw
	 * @title :queryTimetaskByServiceType
	 * @Description:根据服务类型查询任务
	 * @return List<Timetask>
	 * @date 2016年1月13日 下午6:34:53
	 */
	public List<Timertask> queryTimetaskByServiceType(@Param("serviceType")String serviceType , @Param("periodType")Integer periodType , @Param("serviceTargetId") String serviceTargetId);
	
	/**
	 * @author wang_hw
	 * @title :queryTimetaskByServiceTypes
	 * @Description:根据服务类型查询任务
	 * @return List<Timertask>
	 * @date 2016年1月27日 下午1:30:48
	 */
	public List<Timertask> queryTimetaskByServiceTypes(@Param("serviceTypes") String serviceTypes);
	
	/**
	 * @author wang_hw
	 * @title :queryUserOpenId
	 * @Description:查看患者OpenId
	 * @return String
	 * @date 2016年1月13日 下午7:50:22
	 */
	public String queryUserOpenId(@Param("userId")String userId,@Param("productId")Integer wxProductId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :callProcedure
	 * @Description:执行存储过程
	 * @return void
	 * @date 2017年8月24日 下午4:42:30
	 */
	public void callProcedure(@Param("sql")String sql);
	
}

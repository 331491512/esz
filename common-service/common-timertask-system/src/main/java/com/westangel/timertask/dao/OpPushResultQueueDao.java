package com.westangel.timertask.dao;

import org.apache.ibatis.annotations.Param;

import com.westangel.timertask.model.OpPushResultQueue;

/**
* @ClassName: OpPushResultQueueDao 
* @Description: 推送结果队列数据操作接口
* @author wang_hw
* @date 2016年10月7日 下午4:57:43
 */
public interface OpPushResultQueueDao{
	
	/**
	 * @author wang_hw
	 * @title :insertOpPushResultQueue
	 * @Description:推送队列录入
	 * @return void
	 * @date 2016年10月7日 下午4:58:06
	 */
	public void insertOpPushResultQueue(OpPushResultQueue opPushResultQueue);
	
	/**
	 * @author wang_hw
	 * @title :updateOpPushResultQueue
	 * @Description:推送队列修改
	 * @return void
	 * @date 2016年10月7日 下午4:58:30
	 */
	public void updateOpPushResultQueue(OpPushResultQueue opPushResultQueue);
	
	/**
	 * @author wang_hw
	 * @title :deleteOpPushResultQueue
	 * @Description:推送队列删除
	 * @return void
	 * @date 2016年10月7日 下午4:58:44
	 */
	public void deleteOpPushResultQueue(Integer pushResultQueueId);
	
	/**
	 * @author wang_hw
	 * @title :queryOpPushResultQueue
	 * @Description:推送队列查询
	 * @return OpPushResultQueue
	 * @date 2016年10月7日 下午4:58:59
	 */
	public OpPushResultQueue queryOpPushResultQueue(Integer opPushResultQueueId);
	
	/**
	 * @author wang_hw
	 * @title :queryOpPushResultQueueByPatientId
	 * @Description:推送队列查询
	 * @return OpPushResultQueue
	 * @date 2016年10月7日 下午4:59:14
	 */
	public OpPushResultQueue queryOpPushResultQueueByPatientId(@Param("pushRuleId")Integer pushRuleId , @Param("patientId")Long patientId);
	
}

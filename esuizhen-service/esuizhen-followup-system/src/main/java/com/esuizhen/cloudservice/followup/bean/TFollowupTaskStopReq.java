/**
 * 
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.List;

/**
 * @author DaLoong
 * @date  2016-8-11 下午9:11:52
 */
public class TFollowupTaskStopReq {

	Long  userId;
	List<String>  taskId;
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the taskId
	 */
	public List<String> getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(List<String> taskId) {
		this.taskId = taskId;
	}
	
	
}

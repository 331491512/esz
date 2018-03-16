package com.esuizhen.cloudservice.sync.service;


import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.bean.TSyncReviewRecord;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.HospitalWithoutRightExcption;

public interface CloudReviewOrderService {
	/**
	 * 
	* @Title: setReviewSyncedFlag 
	* @Description: 设置复查预约同步结果 
	* @param @param uuids    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void setReviewSyncedFlag(TSyncResultNotify notify);
	

	//add by fanpanwei 
	public Page<TSyncReviewRecord> syncReviewOrderFromCloud(Integer hospitalId, Integer pageIndex, Integer pageSize) throws HospitalWithoutRightExcption;
}

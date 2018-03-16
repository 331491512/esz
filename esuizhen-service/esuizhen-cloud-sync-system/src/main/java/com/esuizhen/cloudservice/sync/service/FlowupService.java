package com.esuizhen.cloudservice.sync.service;


import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.DuplicateRecordExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;

public interface FlowupService {
	/**
	 * @throws HospitalWithoutRightExcption 
	 * 
	* @Title: syncB2CResultRecord 
	* @Description: B端到C端同步增量 
	* @param @param result    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public String syncB2CResultRecord(TPatientFollowupResultDetailInfo result) throws HospitalWithoutRightExcption,DuplicateRecordExcption;
	
	/**
	 * @throws HospitalWithoutRightExcption 
	 * 
	* @Title: getIncrResultRecords 
	* @Description: 获取未同步的C端到B端同步随访结果
	* @param @param hostpitalId
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public Page<TPatientFollowupResultDetailInfo> syncFollowupResultFromCloud(Integer hospitalId, Integer pageIndex, Integer pageSize) throws HospitalWithoutRightExcption;
	/**
	 * 
	* @Title: setSyncResult 
	* @Description: 设置同步随访结果 
	* @param @param records    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void setSyncedFlag4Uuids(TSyncResultNotify notify);
}

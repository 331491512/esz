package com.esuizhen.cloudservice.followup.service.followupTable;

import java.util.List;

import com.esuizhen.cloudservice.followup.bean.FollowupTableReq;

/**
 * 
 * @author fanpanwei
 *
 */
public interface FollowupTableService {
	
	/**
	 * 
	* @author fanpanwei
	* @date 2017年3月10日
	* @param 
	* @description  是否开启随访表 ！1：开启
	* @return
	 */
	public Integer isOpenedFollowupTable(Integer patientId);
	/**
	* @author fanpanwei
	* @date 2017年3月7日
	* @param 
	* @description：查询随访表内容
	* @return
	 */
	public FollowupTableReq getFollowupTable(Integer patientId);
	/**
	* @author fanpanwei
	* @date 2017年3月7日
	* @param 
	* @description:更新随访表内容
	* @return
	 */
	public void updateFollowupTable(FollowupTableReq followupTableReq);
	
}

package com.esuizhen.cloudservice.followup.dao.followup;

import com.westangel.common.bean.followup.TVarPatientFollowup;

/**
* @ClassName: TVarPatientFollowupDao 
* @Description: 随访动态记录表 
* @author wang_hw
* @date 2016年1月16日 下午12:58:12
 */
public interface TVarPatientFollowupDao{
	
	/**
	 * @author wang_hw
	 * @title :insertVarPatientFollowup
	 * @Description:保存随访动态更新信息
	 * @return void
	 * @date 2016年1月16日 下午12:58:26
	 */
	public void insertVarPatientFollowup(TVarPatientFollowup varPatientFollowup);
	
	/**
	 * @author wang_hw
	 * @title :updateVarPatientFollowup
	 * @Description:修改随访动态更新信息
	 * @return void
	 * @date 2016年1月16日 下午12:59:02
	 */
	public void updateVarPatientFollowup(TVarPatientFollowup varPatientFollowup);
	
	/**
	 * @author wang_hw
	 * @title :updateUserLiveStatus
	 * @Description:用户死亡专题修改
	 * @return void
	 * @date 2016年3月10日 下午5:48:52
	 */
	public void updateUserLiveStatus(String patientId);
	
	/**
	 * @author wang_hw
	 * @title :deleteVarPatientFollowup
	 * @Description:删除随访动态更新信息
	 * @return void
	 * @date 2016年1月16日 下午12:59:26
	 */
	public void deleteVarPatientFollowup(Long id);
	
	/**
	 * @author wang_hw
	 * @title :queryVarPatientFollowup
	 * @Description:查询随访动态更新信息
	 * @return TVarPatientFollowup
	 * @date 2016年1月16日 下午12:59:41
	 */
	public TVarPatientFollowup queryVarPatientFollowup(Long id);

	/**
	 * 
	* @Title: queryVarPatientFollowup
	* @Description: 查询患者是否已在动态表
	* @date 2016年8月11日 上午11:36:41
	 */
	public TVarPatientFollowup queryVarPatientFollowupByPatientId(Long patientId);
	
}

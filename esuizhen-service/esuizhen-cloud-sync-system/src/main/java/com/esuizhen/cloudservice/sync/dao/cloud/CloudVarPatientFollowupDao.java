package com.esuizhen.cloudservice.sync.dao.cloud;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.followup.TVarPatientFollowup;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudVarPatientFollowupDao {
	/**
	 * 
	 * @param patientId
	 * @param followupState
	 * @return
	 */
	public int setPatientDeathStatus(@Param("patientId")Long patientId, @Param("followupState")Integer followupState);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :insertVarPatientFollowup
	 * @Description:保存动态表数据
	 * @return void
	 * @date 2016年10月28日 下午2:45:37
	 */
	public void insertVarPatientFollowup(TVarPatientFollowup varPatientFollowup);
	/**
	 * 
	 * @author lichenghao
	 * @title :queryVarPatientFollowup
	 * @Description:获取动态信息
	 * @return TVarPatientFollowup
	 * @date 2016年10月28日 下午2:32:05
	 */
	public TVarPatientFollowup queryVarPatientFollowupByPatientId(@Param("patientId")Long patientId);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateVarPatientFollowup
	 * @Description:更新随访结果动态表
	 * @return void
	 * @date 2016年10月28日 下午8:09:23
	 */
	public void updateVarPatientFollowup(TVarPatientFollowup varPatientFollowup);
}

package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.medicalRecord.TVarPatientMedical;

/**
* @ClassName: TVarPatientMedicalDao 
* @Description: 病例动态更新
* @author wang_hw
* @date 2016年1月16日 下午1:42:12
 */
public interface TVarPatientMedicalDao{
	
	/**
	 * @author wang_hw
	 * @title :insertVarPatientMedical
	 * @Description:录入病例动态更新信息
	 * @return void
	 * @date 2016年1月16日 下午1:42:29
	 */
	public void insertVarPatientMedical(TVarPatientMedical varPatientMedical);
	
	/**
	 * @author wang_hw
	 * @title :updateVarPatientMedical
	 * @Description:修改病例动态更新信息
	 * @return void
	 * @date 2016年1月16日 下午1:42:46
	 */
	public void updateVarPatientMedical(TVarPatientMedical varPatientMedical);
	
	/**
	 * @author wang_hw
	 * @title :deleteVarPatientMedical
	 * @Description:删除病例动态更新信息
	 * @return void
	 * @date 2016年1月16日 下午1:42:51
	 */
	public void deleteVarPatientMedical(Long id);
	
	/**
	 * @author wang_hw
	 * @title :queryVarPatientMedical
	 * @Description:查询病例动态更新信息
	 * @return TVarPatientMedical
	 * @date 2016年1月16日 下午1:42:56
	 */
	public TVarPatientMedical queryVarPatientMedical(Long id);
	
	/**
	 * @author wang_hw
	 * @title :queryVarPatientMedicalByPatientId
	 * @Description:查询患者动态信息
	 * @return TVarPatientMedical
	 * @date 2016年1月18日 上午10:19:58
	 */
	public TVarPatientMedical queryVarPatientMedicalByPatientId(@Param("patientId")Long patientId);
}

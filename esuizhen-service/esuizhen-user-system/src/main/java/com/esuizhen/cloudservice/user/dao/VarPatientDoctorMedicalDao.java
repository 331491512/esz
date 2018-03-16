package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
* @ClassName: TVarPatientDoctorMedicalDao 
* @Description: 医患病历信息表
* @author lichenghao
* @date 2016年3月31日 下午2:51:34
 */
public interface VarPatientDoctorMedicalDao{
	/**创建医患病历关系*/
	public Integer createVarPatientDoctorMedical(Object param);
	
	/**更新医患病历关系*/
	public Integer modifyVarPatientDoctorMedical(Object param);
	
	/**删除医患病历关系*/
	public Integer deleteVarPatientDoctorMedical(Object parama);
	
	int updateInfoToCloudPatientInfo(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
	
	/**
	 * <p>Title:deleteByPatientId</p>
	 * <p>Description:通过患者ID删除病历关系</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午2:39:19
	 * @param patientId
	 * @return
	 */
	public int deleteByPatientId(Long patientId);
}

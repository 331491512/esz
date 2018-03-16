package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.Map;

/**
 * 
* @ClassName: TVarPatientDoctorMedicalDao 
* @Description: 医患病历信息表
* @author lichenghao
* @date 2016年3月31日 下午2:51:34
 */
public interface TVarPatientDoctorMedicalDao{
	/**创建医患病历关系*/
	public Integer createVarPatientDoctorMedical(Object param);
	
	/**更新医患病历关系*/
	public Integer modifyVarPatientDoctorMedical(Object param);
	
	/**删除医患病历关系*/
	public Integer deleteVarPatientDoctorMedical(Object parama);

	public int insert(Map<String, Object> param);
}

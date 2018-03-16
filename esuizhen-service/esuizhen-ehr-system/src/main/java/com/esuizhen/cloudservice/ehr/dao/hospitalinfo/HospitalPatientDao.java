package com.esuizhen.cloudservice.ehr.dao.hospitalinfo;

import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface HospitalPatientDao {
	/**
	 * 
	* @Title: hasRelationOfHospitalPatient 
	* @Description: 是否已存在 
	* @param @param briefInfo
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer hasRelationOfHospitalPatient(HospitalPatientBriefInfo briefInfo);
	/**
	 * 
	* @Title: insertRelationOfHospitalPatient 
	* @Description: 插入关系 
	* @param @param briefInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public int insertRelationOfHospitalPatient(HospitalPatientBriefInfo briefInfo);
	
	/**
	 * 查询医院信息
	 * @param hospital
	 * @return
	 */
	HospitalProfile queryHospital(HospitalProfile hospital);
	/**
	 * 更新医院信息
	 * @return
	 */
	int updateHospital(HospitalProfile hospital);
}

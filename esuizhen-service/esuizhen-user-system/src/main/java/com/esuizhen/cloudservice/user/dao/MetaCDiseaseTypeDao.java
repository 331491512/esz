package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.TDiseaseInfo;
import com.westangel.common.bean.ehr.MetaCDiseaseType;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MetaCDiseaseTypeDao {
	public MetaCDiseaseType findByDiseaseTypeId(Integer diseaseTypeId);
	
	//获取医生的患者病种
	public List<TDiseaseInfo> queryPatientDiseaseByDoctorId(@Param("doctorId")Long doctorId);
}

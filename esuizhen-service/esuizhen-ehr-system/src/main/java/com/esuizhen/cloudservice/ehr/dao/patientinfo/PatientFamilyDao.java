package com.esuizhen.cloudservice.ehr.dao.patientinfo;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.westangel.common.bean.user.PatientFamily;

public interface PatientFamilyDao extends CommonDao<PatientFamily>
{
	public void batchInsert(Map<String,Object> patientFamilyMap);
	//add by fanpanwei
	public int update(PatientFamily patientFamily);
	public List<PatientFamily> find(@Param("patientId")Long patientId, @Param("mobile")String mobile,@Param("familyName") String familyName);
}

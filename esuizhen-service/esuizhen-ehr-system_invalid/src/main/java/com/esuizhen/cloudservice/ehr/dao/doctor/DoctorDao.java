package com.esuizhen.cloudservice.ehr.dao.doctor;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.Doctor;

/**
 * 用户简单数据查询。内部使用。
 * @author bigdragon
 *
 */
public interface DoctorDao {

	Map<String,Object> getDoctorInfoById(@Param("doctorId") Long doctorId);
	
	//获取患者最后一次主诊医师
	public Doctor queryDoctorByLashInhospitalInfo(Long patientId);
	
	//获取任意患者诊治医生
	public Doctor queryDoctorByRelation(Long patientId);
	
	//获取任意患者诊治医生
	public Doctor queryServiceDutyDoctor(Integer hospitalId);
	

}
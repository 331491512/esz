package com.esuizhen.cloudservice.sync.dao.cloud;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.DoctorPatient;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudDoctorPatientDao {
	
	/**
	 * 
	 * @param doctorPatient
	 * @return
	 */
	public long insert(DoctorPatient doctorPatient);
	
	public int update(DoctorPatient doctorPatient);
	
	/**
	 * 
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	public DoctorPatient findDoctorPatient(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId);
}

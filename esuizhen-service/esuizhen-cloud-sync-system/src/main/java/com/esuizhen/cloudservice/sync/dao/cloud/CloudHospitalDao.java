package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import com.esuizhen.cloudservice.sync.model.Hospital;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudHospitalDao {
	public Hospital findByUuid(String uuid);
	
	public List<Hospital> findByDoctorId(Long doctor);

	public int existHospital(Integer hospitalId);

	public Hospital findById(Integer hospitalId);
}

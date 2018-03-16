package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.HospitalDoctor;

/**
 * 云端数据库医院、科室、医生关系数据访问接口
 * @author YYCHEN
 *
 */
public interface CloudHospitalDoctorDao {

	public long insert(HospitalDoctor hospitalDoctor);
	
	public List<HospitalDoctor> findByDoctorId(@Param("hospitalId")Integer hospitalId, @Param("doctorId")Long doctorId);
	
	public HospitalDoctor find(HospitalDoctor hospitalDoctor);

	public int update(HospitalDoctor cloudHospitalDoctor);
}

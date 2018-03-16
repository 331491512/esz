package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.Hospital;
import com.esuizhen.cloudservice.sync.model.HospitalDoctor;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 匹配数据库医院、医生、科室数据访问接口
 * @author YYCHEN
 *
 */
public interface MatchHospitalDoctorDao {
	
	public long insert(HospitalDoctor hospitalDoctor);
	
	public int delete(Long id);

	public int updateDoctorUuid(@Param("finalUuid")String finalUuid, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	public HospitalDoctor findByHospitalUuidAndDeptIdAndDoctorUuid(@Param("hospitalUuid")String hospitalUuid, @Param("deptUuid")String deptUuid, @Param("doctorUuid")String doctorUuid);
	
	public List<HospitalDoctor> findByDoctorFinalUuid(String doctorFinalUuid);
	
	public List<Hospital> findByDoctorUuid(String doctorUuid);
}

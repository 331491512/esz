package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 匹配数据库医生、患者数据访问接口
 * @author YYCHEN
 *
 */
public interface MatchDoctorPatientDao {
	
	public long insert(DoctorPatient doctorPatient);
	
	public int delete(Long id);

	public int updateDoctorUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);

	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	public DoctorPatient findByDoctorUuidAndPatientUuid(@Param("doctorUuid")String doctorUuid, @Param("patientUuid")String patientUuid);

	public List<DoctorPatient> findByDoctorUuid(String doctorFinalUuid);

	public List<DoctorPatient> findByPatientUuid(String patientFinalUuid);
}

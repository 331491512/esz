package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.DoctorPatient;

/**
 * 增量数据库医生、患者关系数据访问接口
 * @author YYCHEN
 *
 */
public interface IncreDoctorPatientDao {
	
	public long insert(DoctorPatient doctorPatient);
	
	public int delete(Long id);
}

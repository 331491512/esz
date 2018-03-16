package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.HospitalDoctor;

/**
 * 增量数据库医院、医生关系数据访问接口
 * @author YYCHEN
 *
 */
public interface IncreHospitalDoctorDao {
	public long insert(HospitalDoctor hospitalDoctor);
	
	public int delete(Long id);
}

package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.HospitalPatient;

/**
 * 增量数据库医院、患者关系数据访问接口
 * @author YYCHEN
 *
 */
public interface IncreHospitalPatientDao {
	/**
	 * 
	 * @param 
	 * @return
	 */
	public long insert(HospitalPatient hospitalPatient);
	
	public int delete(Long id);
}

package com.esuizhen.cloudservice.sync.dao.incre;

import com.westangel.common.bean.Patient;

/**
 * 患者数据
 * @author YYCHEN
 *
 */
public interface IncrePatientDao {
	
	public long insert(Patient patient);
}

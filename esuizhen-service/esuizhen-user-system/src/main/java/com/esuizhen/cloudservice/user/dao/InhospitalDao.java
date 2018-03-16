package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author YYCHEN
 *
 */
public interface InhospitalDao {
	
	public int update(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
}

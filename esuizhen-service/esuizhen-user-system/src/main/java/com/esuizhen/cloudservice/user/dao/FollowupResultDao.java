package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author YYCHEN
 *
 */
public interface FollowupResultDao {
	public int update(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
	
	public int setVarPatientFollowupDeath(Long patientId);
}

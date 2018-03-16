package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

public interface EciEetectionDetailDao {
	/**
	 * <p>Title:updateToBToCloudPatientId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午3:26:16
	 * @param cloudPatientId
	 * @param tobPatientId
	 * @return
	 */
	public int updateToBToCloudPatientId(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
}

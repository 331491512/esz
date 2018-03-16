package com.esuizhen.cloudservice.user.dao;

/**
 * <p>Title:VarPatientMedicalDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月16日 下午2:25:09
 */
public interface VarPatientMedicalDao {
	/**
	 * <p>Title:deleteByPatientId</p>
	 * <p>Description:通过患者ID删除病历动态数据</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午2:26:52
	 * @param patientId
	 * @return
	 */
	public int deleteByPatientId(Long patientId);
}

package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

public interface EciExamReportDao {
	/**
	 * <p>Title:updateToBToCloudPatientId</p>
	 * <p>Description:将ToB导入的患者PACS数据改为数据云端的患者</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午3:17:56
	 * @param cloudPatientId
	 * @param tobPatientId
	 * @return
	 */
	public int updateToBToCloudPatientId(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
}

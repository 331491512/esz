package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

/**
 * <p>Title:EciTreatmentNoteDao</p>
 * <p>Description:患者治疗信息数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年7月6日 下午5:04:34
 */
public interface EciTreatmentNoteDao {

	/**
	 * <p>Title:update</p>
	 * <p>Description:将ToB患者的治疗信息导入到云端患者下</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午5:05:30
	 * @param cloudPatientId
	 * @param tobPatientId
	 * @return
	 */
	int update(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);

}

package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TProjectThresholdPatient;

/**
 * <p>Title:ProjectThresholdPatientDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年6月1日 下午4:48:11
 */
public interface TProjectThresholdPatientDao {
	/**
	 * <p>Title:findCrfProfilePhysicalExamThreshold</p>
	 * <p>Description:根据专题ID、患者ID和创建人ID查找患者常规体检项目阈值</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午4:51:24
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	List<TProjectThresholdPatient> findCrfProfilePhysicalExamThreshold(@Param("projectId")String projectId, @Param("patientId")Long patientId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:deleteByProjectIdAndPatientId</p>
	 * <p>Description:根据专题ID和患者ID删除之间的阈值</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:07:42
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	int deleteByProjectIdAndPatientId(@Param("projectId")String projectId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:批量新增患者常规体检项目阈值</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:05:29
	 * @param projectThresholdPatients
	 * @return
	 */
	int insertByBatch(@Param("projectThresholdPatients")List<TProjectThresholdPatient> projectThresholdPatients);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午7:56:36
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);
}

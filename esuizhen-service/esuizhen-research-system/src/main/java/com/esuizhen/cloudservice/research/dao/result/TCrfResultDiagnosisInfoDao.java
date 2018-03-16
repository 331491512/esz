package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultDiagnosisInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultBasicDemographyDao</p>
 * <p>Description:诊断信息结果数据访问层</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:48:26
 */
public interface TCrfResultDiagnosisInfoDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:51:59
	 * @param crfResultDiagnosisInfo
	 * @return
	 */
	public int insert(TCrfResultDiagnosisInfo crfResultDiagnosisInfo);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:52:02
	 * @param crfResultDiagnosisInfo
	 * @return
	 */
	public int update(TCrfResultDiagnosisInfo crfResultDiagnosisInfo);
	
	/**
	 * <p>Title:delete</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:52:05
	 * @param crfDiagnosisResultId
	 * @return
	 */
	public int delete(String crfDiagnosisResultId);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:根据crfResultId和患者ID删除记录</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午2:46:43
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	public int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:findCrfResultDiagnosisInfoes</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午2:37:57
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	public TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> findCrfResultDiagnosisInfoes(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:26:37
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}

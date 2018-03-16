package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalStatusScore;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultPhysicalStatusScoreDao</p>
 * <p>Description:患者身体状况评分结果数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:32:02
 */
public interface TCrfResultPhysicalStatusScoreDao {

	/**
	 * <p>Title:findCrfResultPhysicalStatusScoreRecord</p>
	 * <p>Description:获取患者身体状况评分数据列表</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:54:33
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>> findCrfResultPhysicalStatusScoreRecord(@Param("projectId")String projectId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:findCrfResultPhysicalStatusScores</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:56:31
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	TCrfResultMainInfo<TCrfResultPhysicalStatusScore> findCrfResultPhysicalStatusScores(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:58:44
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:59:52
	 * @param crfResultPhysicalStatusScore
	 * @return
	 */
	int insert(TCrfResultPhysicalStatusScore crfResultPhysicalStatusScore);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:21:25
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);

}

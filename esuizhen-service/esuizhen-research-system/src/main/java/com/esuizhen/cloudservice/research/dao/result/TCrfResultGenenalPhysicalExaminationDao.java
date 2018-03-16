package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultGenenalPhysicalExamination;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultGenenalPhysicalExaminationDao</p>
 * <p>Description:患者体格检查-常规体检结果数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:01:19
 */
public interface TCrfResultGenenalPhysicalExaminationDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增患者体格检查-常规体检结果</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午6:08:12
	 * @param crfResultGenenalPhysicalExamination
	 * @return
	 */
	int insert(TCrfResultGenenalPhysicalExamination crfResultGenenalPhysicalExamination);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:更新患者体格检查-常规体检结果</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午6:08:43
	 * @param crfResultGenenalPhysicalExamination
	 * @return
	 */
	int update(TCrfResultGenenalPhysicalExamination crfResultGenenalPhysicalExamination);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:通过crfResultId和患者ID删除患者体格检查-常规体检结果数据</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:25:12
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:findCrfResultGenenalPhysicalExaminations</p>
	 * <p>Description:CRF常规体检结果查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:01:50
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> findCrfResultGenenalPhysicalExaminations(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:findCrfResultGenenaPhysicalExamRecord</p>
	 * <p>Description:CRF常规体检历史记录查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:38:09
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	List<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>> findCrfResultGenenaPhysicalExamRecord(
			@Param("projectId")String projectId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:25:04
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);
}

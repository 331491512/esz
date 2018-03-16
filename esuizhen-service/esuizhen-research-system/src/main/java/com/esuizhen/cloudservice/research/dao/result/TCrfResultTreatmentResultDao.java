package com.esuizhen.cloudservice.research.dao.result;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreantmentResultInfo;

/**
 * <p>Title:TCrfResultTreatmentResultDao</p>
 * <p>Description:CRF治疗效果结果</p>
 * @author YYCHEN
 * @date 2016年10月21日 上午10:30:33
 */
public interface TCrfResultTreatmentResultDao {

	/**
	 * <p>Title:findCrfResultTreatmentResultInfo</p>
	 * <p>Description:根据CRF设置项和患者ID查询治疗效果结果</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午10:51:42
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	TCrfResultMainInfo<TCrfResultTreantmentResultInfo> findCrfResultTreatmentResultInfo(@Param("crfObserveId")String crfObserveId,
			@Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:根据CRF采集结果ID和患者ID删除治疗效果结果数据</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午11:04:26
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增CRF治疗效果结果数据</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午11:06:09
	 * @param crfResultTreantmentResultInfo
	 * @return
	 */
	int insert(TCrfResultTreantmentResultInfo crfResultTreantmentResultInfo);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:12:14
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);
}

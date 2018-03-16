package com.esuizhen.cloudservice.research.dao.result;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultPainScaleInfo;

/**
 * <p>Title:TCrfResultPainScaleDao</p>
 * <p>Description:CRF临床症状-疼痛指数</p>
 * @author YYCHEN
 * @date 2016年10月21日 上午9:40:41
 */
public interface TCrfResultPainScaleDao {

	/**
	 * <p>Title:findCrfResultPainScaleInfo</p>
	 * <p>Description:根据CRF观察项ID和患者ID查询患者临床症状疼痛指数结果</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午9:44:06
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	TCrfResultMainInfo<TCrfResultPainScaleInfo> findCrfResultPainScaleInfo(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:使用CRF采集结果ID和患者ID删除临床症状-疼痛指数结果数据</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午10:03:10
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增CRF临床症状-疼痛指数结果</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午10:04:37
	 * @param crfResultPainScaleInfo
	 * @return
	 */
	int insert(TCrfResultPainScaleInfo crfResultPainScaleInfo);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:06:04
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);
	
}

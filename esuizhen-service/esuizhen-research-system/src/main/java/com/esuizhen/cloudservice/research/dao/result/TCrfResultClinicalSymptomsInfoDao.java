package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * @ClassName: TCrfResultClinicalSymptomsInfoDao
 * @Description: 症状结果数据操作接口
 * @author wang_hw
 * @date 2016年5月31日 下午3:32:00
 */
public interface TCrfResultClinicalSymptomsInfoDao {
	/**
	 * @author wang_hw
	 * @title :insertCrfResultClinicalSymptoms
	 * @Description:症状结果保存
	 * @return void
	 * @date 2016年5月31日 下午3:35:09
	 */
	public void insertCrfResultClinicalSymptoms(TCrfResultClinicalSymptomsInfo crfResultClinicalSymptoms);

	/**
	 * @author wang_hw
	 * @title :updateCrfResultClinicalSymptoms
	 * @Description:症状结果修改
	 * @return void
	 * @date 2016年5月31日 下午3:35:26
	 */
	public void updateCrfResultClinicalSymptoms(TCrfResultClinicalSymptomsInfo crfResultClinicalSymptoms);

	/**
	 * @author wang_hw
	 * @title :deleteCrfResultClinicalSymptoms
	 * @Description:症状结果删除
	 * @return void
	 * @date 2016年5月31日 下午3:35:38
	 */
	public void deleteCrfResultClinicalSymptoms(String crfResultClinicalSymptomsId);

	/**
	 * @author wang_hw
	 * @title :deleteCrfResultClinicalSymptomsByCrfResultId
	 * @Description:症状结果删除(根据结果ID)
	 * @return void
	 * @date 2016年6月7日 上午10:55:18
	 */
	public void deleteCrfResultClinicalSymptomsByCrfResultId(String crfResultId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultClinicalSymptoms
	 * @Description:症状结果查询
	 * @return TCrfResultClinicalSymptomsInfo
	 * @date 2016年5月31日 下午3:35:52
	 */
	public TCrfResultClinicalSymptomsInfo queryCrfResultClinicalSymptoms(String crfResultClinicalSymptomsId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultClinicalSymptomsByPatientIdAndCrfObserveId
	 * @Description:症状结果查询（根据患者ID观察项ID）
	 * @return TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo>
	 * @date 2016年5月31日 下午3:55:41
	 */
	public TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> queryCrfResultClinicalSymptomsByPatientIdAndCrfObserveId(
			@Param("crfObserveId") String crfObserveId, @Param("patientId") Long patientId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultClinicalSymptomsByPatientIdAndProjectId
	 * @Description:症状结果查询（根据患者ID专题ID）
	 * @return List<TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo>>
	 * @date 2016年5月31日 下午3:55:48
	 */
	List<TCrfResultClinicalSymptomsInfo> queryCrfResultClinicalSymptomsByPatientIdAndProjectId(
			@Param("projectId") String projectId, @Param("patientId") Long patientId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTcmSymptomsByPatientIdAndCrfObserveId
	 * @Description:症状中医结果查询（根据患者ID观察项ID）
	 * @return TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo>
	 * @date 2016年5月31日 下午9:11:37
	 */
	public TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> queryCrfResultTcmSymptomsByPatientIdAndCrfObserveId(
			@Param("crfObserveId") String crfObserveId, @Param("patientId") Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:10:19
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}

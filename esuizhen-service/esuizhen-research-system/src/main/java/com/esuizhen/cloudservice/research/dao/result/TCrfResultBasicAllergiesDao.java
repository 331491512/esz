package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicAllergies;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultBasicDemographyDao</p>
 * <p>Description:基本信息-过敏史结果数据访问层</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:48:26
 */
public interface TCrfResultBasicAllergiesDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:51:59
	 * @param crfResultBasicAllergies
	 * @return
	 */
	public int insert(TCrfResultBasicAllergies crfResultBasicAllergies);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:52:02
	 * @param crfResultBasicAllergies
	 * @return
	 */
	public int update(TCrfResultBasicAllergies crfResultBasicAllergies);
	
	/**
	 * <p>Title:delete</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:52:05
	 * @param crfAllergiesResultId
	 * @return
	 */
	public int delete(String crfAllergiesResultId);
	
	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:43:40
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	public int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:findCrfResultBasicAllergies</p>
	 * <p>Description:通过crfObserveId和patientId获取患者基本信息-过敏史结果</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:17:27
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	public TCrfResultMainInfo<List<TCrfResultBasicAllergies>> findCrfResultBasicAllergies(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:批量保存过敏病史数据</p>
	 * @author YYCHEN
	 * @date 2016年6月28日 下午6:00:14
	 * @param crfResultBasicAllergieses
	 * @return
	 */
	public int insertByBatch(@Param("crfResultBasicAllergieses")List<TCrfResultBasicAllergies> crfResultBasicAllergieses);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:29:51
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}

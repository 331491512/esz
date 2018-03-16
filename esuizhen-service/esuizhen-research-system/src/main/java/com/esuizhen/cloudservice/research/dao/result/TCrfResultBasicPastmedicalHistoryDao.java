package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicPastmedicalHistory;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultBasicDemographyDao</p>
 * <p>Description:基本信息-既往病史结果数据访问层</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:48:26
 */
public interface TCrfResultBasicPastmedicalHistoryDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:批量保存</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:51:59
	 * @param crfResultBasicPastmedicalHistories
	 * @return
	 */
	public int insertByBatch(@Param("crfResultBasicPastmedicalHistories")List<TCrfResultBasicPastmedicalHistory> crfResultBasicPastmedicalHistories);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:52:02
	 * @param crfResultBasicAllergies
	 * @return
	 */
	public int update(TCrfResultBasicPastmedicalHistory crfResultBasicPastmedicalHistory);
	
	/**
	 * <p>Title:delete</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 上午10:52:05
	 * @param crfAllergiesResultId
	 * @return
	 */
	public int delete(String crfPastmedicalResultId);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午4:59:26
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	public int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:findCrfResultBasicPastmedicalHistory</p>
	 * <p>Description:查询信息-既往病史结果</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午2:26:40
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	public TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> findCrfResultBasicPastmedicalHistory(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:28:25
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}

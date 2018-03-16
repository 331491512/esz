package com.esuizhen.cloudservice.research.dao.result;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicDemography;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultBasicDemographyDao</p>
 * <p>Description:基本信息-人口学信息结果数据访问层</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:48:26
 */
public interface TCrfResultBasicDemographyDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增患者基本信息-人口学信息结果</p>
	 * @author YYCHEN
	 * @date 2016年5月26日 下午3:49:15
	 * @param crfResultBasicDemography
	 * @return
	 */
	public int insert(TCrfResultBasicDemography crfResultBasicDemography);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月26日 下午3:50:02
	 * @param crfResultBasicDemography
	 * @return
	 */
	public int update(TCrfResultBasicDemography crfResultBasicDemography);
	
	/**
	 * <p>Title:delete</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月26日 下午3:50:31
	 * @param crfDemographyResultId
	 * @return
	 */
	public int delete(String crfDemographyResultId);
	
	/**
	 * <p>Title:deleteByCrfResultId</p>
	 * <p>Description:通过观察项结果Id删除基本信息-人口学信息结果</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 下午5:59:46
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	public int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:findCrfResultDemography</p>
	 * <p>Description:通过观察项ID和患者ID查询患者CRF人口学信息</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 下午2:56:44
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	public TCrfResultMainInfo<TCrfResultBasicDemography> findCrfResultDemography(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:31:20
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}

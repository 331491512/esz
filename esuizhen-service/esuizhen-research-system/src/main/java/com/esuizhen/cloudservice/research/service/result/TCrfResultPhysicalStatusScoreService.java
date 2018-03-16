package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalStatusScore;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultPhysicalStatusScoreService</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年6月1日 下午5:47:11
 */
public interface TCrfResultPhysicalStatusScoreService {

	/**
	 * <p>Title:queryCrfResultPhysicalStatusScoreRecord</p>
	 * <p>Description:CRF患者身体状况评分结果记录查询</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:47:17
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	public List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>> queryCrfResultPhysicalStatusScoreRecord(String projectId,
			Long patientId, Long doctorId);

	/**
	 * <p>Title:queryCrfResultPhysicalStatusScoreI</p>
	 * <p>Description:CRF患者身体状况评分结果查询</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:49:19
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	TCrfResultMainInfo<TCrfResultPhysicalStatusScore> queryCrfResultPhysicalStatusScoreI(String crfObserveId,
			Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:saveCrfResultPhysicalStatusScore</p>
	 * <p>Description:CRF患者身体状况评分保存</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:51:13
	 * @param crfResultMainInfoes
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean saveCrfResultPhysicalStatusScore(List<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>> crfResultMainInfoes) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

}

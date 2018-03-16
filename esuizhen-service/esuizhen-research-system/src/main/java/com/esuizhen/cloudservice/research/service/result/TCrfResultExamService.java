package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultExam;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultExamService</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年6月2日 上午9:47:06
 */
public interface TCrfResultExamService {

	/**
	 * <p>Title:queryCrfResultExamRecord</p>
	 * <p>Description:CRF检查项目记录查询</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午9:48:15
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	List<TCrfResultMainInfo<List<TCrfResultExam>>> queryCrfResultExamRecord(String projectId, Long patientId, Long doctorId, String examParentTypeId, String orderBy, String orderType);

	/**
	 * <p>Title:crfResultExamQuery</p>
	 * <p>Description:CRF患者检查信息查询</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午9:48:49
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	TCrfResultMainInfo<List<TCrfResultExam>> crfResultExamQuery(String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:saveCrfResultExam</p>
	 * <p>Description:CRF患者检查信息保存</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午9:49:29
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean saveCrfResultExam(TCrfResultMainInfo<List<TCrfResultExam>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

}

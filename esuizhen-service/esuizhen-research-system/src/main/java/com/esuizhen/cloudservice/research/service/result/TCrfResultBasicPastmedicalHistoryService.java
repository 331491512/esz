package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicPastmedicalHistory;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultBasicPastmedicalHistoryService</p>
 * <p>Description:CRF患者诊断信息结果业务层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午2:14:52
 */
public interface TCrfResultBasicPastmedicalHistoryService {

	/**
	 * <p>Title:queryCrfResultPastmedicalHistory</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午4:50:30
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> queryCrfResultPastmedicalHistory(String crfObserveId,
			Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:saveCrfResultPastmedicalHistory</p>
	 * <p>Description:CRF患者既往病史信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午4:55:09
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean saveCrfResultPastmedicalHistory(TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
}

package com.esuizhen.cloudservice.research.service.result;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultPainScaleInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:TCrfResultPainScaleService</p>
 * <p>Description:CRF临床症状-疼痛指数结果</p>
 * @author YYCHEN
 * @date 2016年10月21日 上午9:37:57
 */
public interface TCrfResultPainScaleService {

	/**
	 * <p>Title:queryCrfResultPainScaleInfo</p>
	 * <p>Description:查询随访阶段中的临床症状-疼痛指数结果</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午9:38:31
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	TCrfResultMainInfo<TCrfResultPainScaleInfo> queryCrfResultPainScaleInfo(String crfObserveId, Long patientId);

	/**
	 * <p>Title:saveGenenalPhysicalExam</p>
	 * <p>Description:保存随访阶段中的临床症状-疼痛指数结果</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午9:38:34
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean saveGenenalPhysicalExam(TCrfResultMainInfo<TCrfResultPainScaleInfo> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

}

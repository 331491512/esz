package com.esuizhen.cloudservice.research.service.result;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreantmentResultInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:TCrfResultTreatmentResultService</p>
 * <p>Description:CRF治疗效果</p>
 * @author YYCHEN
 * @date 2016年10月21日 上午10:26:32
 */
public interface TCrfResultTreatmentResultService {

	/**
	 * <p>Title:queryCrfResultTreatmentResultInfo</p>
	 * <p>Description:根据CRF设置项ID和患者ID查询CRF治疗效果结果</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午10:27:50
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	TCrfResultMainInfo<TCrfResultTreantmentResultInfo> queryCrfResultTreatmentResultInfo(String crfObserveId, Long patientId);

	/**
	 * <p>Title:saveCrfResultTreatmentResultInfo</p>
	 * <p>Description:CRF治疗效果结果保存</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午10:28:30
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean saveCrfResultTreatmentResultInfo(TCrfResultMainInfo<TCrfResultTreantmentResultInfo> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
}

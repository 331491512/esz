package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultDiagnosisInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultDiagnosisInfoService</p>
 * <p>Description:CRF患者诊断信息结果业务层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午2:32:58
 */
public interface TCrfResultDiagnosisInfoService {

	/**
	 * <p>Title:queryCrfResultDiagnosis</p>
	 * <p>Description:CRF患者诊断信息结果查询</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午2:35:23
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> queryCrfResultDiagnosis(String crfObserveId, Long patientId,
			Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:saveCrfResultDiagnosis</p>
	 * <p>Description:CRF患者诊断信息结果保存</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午2:43:31
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	public boolean saveCrfResultDiagnosis(TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:autoSupplement</p>
	 * <p>Description:自动填充患者诊断信息患者入组时调用</p>
	 * @author YYCHEN
	 * @date 2016年6月13日 上午10:35:55
	 * @param info
	 * @return
	 * @throws 
	 * @throws ParameterCannotBeNullException 
	 */
	public boolean autoSupplement(TCrfResultMainInfo<List<PatientSimpleInfo>> info) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
}

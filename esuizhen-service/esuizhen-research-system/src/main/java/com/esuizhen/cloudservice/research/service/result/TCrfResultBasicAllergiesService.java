package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicAllergies;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultBasicAllergiesService</p>
 * <p>Description:患者基本信息-过敏史结果业务层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 上午11:11:52
 */
public interface TCrfResultBasicAllergiesService {
	/**
	 * <p>Title:queryCrfResultAllergy</p>
	 * <p>Description:患者信息-过敏史结果查询</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:13:49
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	public TCrfResultMainInfo<List<TCrfResultBasicAllergies>> queryCrfResultAllergy(String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
	
	/**
	 * <p>Title:saveCrfResultAllergy</p>
	 * <p>Description:CRF患者过敏史信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:38:57
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	public boolean saveCrfResultAllergy(TCrfResultMainInfo<List<TCrfResultBasicAllergies>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
}

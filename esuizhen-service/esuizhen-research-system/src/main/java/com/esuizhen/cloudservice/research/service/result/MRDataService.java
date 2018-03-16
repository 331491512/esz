package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.excption.InsufficientParameterExcption;

/**
 * <p>Title:MRDataService</p>
 * <p>Description:数据源及数据业务层</p>
 * @author YYCHEN
 * @date 2016年7月25日 上午10:42:42
 */
public interface MRDataService {

	/**
	 * <p>Title:queryCrfDataSources</p>
	 * <p>Description:数据源查询</p>
	 * @author YYCHEN
	 * @date 2016年7月25日 上午10:47:15
	 * @param crfResultMainInfo
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>> queryCrfDataSources(
			TCrfResultMainInfo<Void> crfResultMainInfo) throws InsufficientParameterExcption;

	/**
	 * <p>Title:queryCrfDataSourceData</p>
	 * <p>Description:获取数据源中的数据</p>
	 * @author YYCHEN
	 * @date 2016年7月25日 上午10:47:30
	 * @param medicalRecordType
	 * @param emrId
	 * @param patientId
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	TCrfResultMainInfo<?> queryCrfDataSourceData(Integer medicalRecordType, String emrId, Long patientId) throws InsufficientParameterExcption;

}

package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicDemography;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultBasicDemographyService</p>
 * <p>Description:基本信息-人口学信息结果业务处理层接口</p>
 * @author YYCHEN
 * @date 2016年5月27日 上午11:33:37
 */
public interface TCrfResultBasicDemographyService {
	/**
	 * <p>Title:queryCrfResultDemography</p>
	 * <p>Description:CRF人口学信息查询</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 下午2:37:25
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	public TCrfResultMainInfo<TCrfResultBasicDemography> queryCrfResultDemography(String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:saveCrfResultDemography</p>
	 * <p>Description:CRF人口学信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 下午3:59:09
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	public boolean saveCrfResultDemography(TCrfResultMainInfo<TCrfResultBasicDemography> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
	
	/**
	 * <p>Title:autoSupplement</p>
	 * <p>Description:自动补充患者人口学信息（患者入组时调用）</p>
	 * @author YYCHEN
	 * @date 2016年6月12日 下午6:08:07
	 * @param crfResultMainInfo
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	public boolean autoSupplement(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
}

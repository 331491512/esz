package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalSigns;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultPhysicalSignsService</p>
 * <p>Description:患者体格检查-体征情况结果业务层接口</p>
 * @author YYCHEN
 * @date 2016年5月31日 下午4:50:09
 */
public interface TCrfResultPhysicalSignsService {

	/**
	 * <p>Title:queryCrfResultPhysicalSignsRecord</p>
	 * <p>Description:CRF患者体征记录查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:50:13
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	Page<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>> queryCrfResultPhysicalSignsRecord(String projectId,
			Long patientId, Long doctorId, Integer page, Integer num);

	/**
	 * <p>Title:queryCrfResultPhysicalSigns</p>
	 * <p>Description:CRF患者体征情况信息查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:50:17
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> queryCrfResultPhysicalSigns(String crfObserveId, Long patientId,
			Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:saveCrfResultPhysicalSigns</p>
	 * <p>Description:CRF患者体征情况信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:50:20
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean saveCrfResultPhysicalSigns(TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

}

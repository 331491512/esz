package com.esuizhen.cloudservice.research.service.result;

import com.esuizhen.cloudservice.research.model.result.TCrfResultGenenalPhysicalExamination;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:CrfResultGenenalPhysicalExaminationService</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月31日 下午3:52:49
 */
public interface TCrfResultGenenalPhysicalExaminationService {

	/**
	 * <p>Title:queryCrfResultGenenaPhysicalExamRecord</p>
	 * <p>Description:CRF常规体检历史记录查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:33:21
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	Page<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>> queryCrfResultGenenaPhysicalExamRecord(String projectId, Long patientId, Long doctorId, Integer page, Integer num);

	/**
	 * <p>Title:queryCrfResultGenenalPhysicalExam</p>
	 * <p>Description:CRF常规体检结果查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:58:55
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParameterCannotBeNullException 
	 */
	TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> queryCrfResultGenenalPhysicalExam(String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:saveGenenalPhysicalExam</p>
	 * <p>Description:CRF患者常规体检结果保存</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:20:57
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean saveGenenalPhysicalExam(TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

}

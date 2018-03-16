package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TProjectThresholdPatient;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:ProjectThresholdPatientService</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年6月1日 下午4:45:35
 */
public interface ProjectThresholdPatientService {

	/**
	 * <p>Title:queryCrfProfilePhysicalExamThreshold</p>
	 * <p>Description:CRF常规体检项目阈值查询</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午4:47:18
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	List<TProjectThresholdPatient> queryCrfProfilePhysicalExamThreshold(String projectId, Long patientId, Long doctorId);

	/**
	 * <p>Title:saveCrfProfilePhysicalExamThreshol</p>
	 * <p>Description:CRF患者常规检验项目阈值保存</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午4:58:28
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 */
	boolean saveCrfProfilePhysicalExamThreshol(TCrfResultMainInfo<List<TProjectThresholdPatient>> crfResultMainInfo) throws ParameterCannotBeNullException;
}

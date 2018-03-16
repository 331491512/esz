package com.esuizhen.cloudservice.user.service;

import com.westangel.common.bean.Patient;
import com.westangel.common.bean.user.PatientFamily;

public interface PatientFamilyService {
	/**
	 * <p>Title:addOrModifyPatientFamily</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月13日 下午6:11:01
	 * @param patient
	 * @return
	 */
	public boolean addOrModifyPatientFamily(Patient patient);
	
	/**
	 * <p>Title:mergePatientFamily</p>
	 * <p>Description:将ToB导入的患者家属改为云端患者的家属</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午3:50:59
	 * @param cloudPatientId
	 * @param tobPatientId
	 * @return
	 */
	public boolean mergePatientFamily(Long cloudPatientId, Long tobPatientId);
	
	/**
	 * 修改有效状态
	 * @param patientFamily
	 * @return
	 */
	int update(PatientFamily patientFamily);
}

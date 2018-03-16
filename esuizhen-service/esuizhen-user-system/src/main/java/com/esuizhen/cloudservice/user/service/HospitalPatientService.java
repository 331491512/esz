package com.esuizhen.cloudservice.user.service;

import com.westangel.common.bean.Patient;

public interface HospitalPatientService {
	/**
	 * <p>Title:mergeHospitalPatient</p>
	 * <p>Description:合并ToB导入的医院患者关系</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午8:22:41
	 * @param patient
	 * @param tobPatient
	 * @return
	 */
	public boolean mergeHospitalPatient(Patient patient, Patient tobPatient);

	/**
	 * <p>Title:handleHospitalPatientRelation</p>
	 * <p>Description:合并医院、患者关系</p>
	 * @author YYCHEN
	 * @date 2016年5月26日 下午5:47:30
	 * @param cloudPatient
	 * @param toBPatient
	 * @return
	 */
	public boolean handleHospitalPatientRelation(Patient cloudPatient, Patient toBPatient);
	
	/**
	 * <p>Title:changeHospitalPatientRelation</p>
	 * <p>Description:将ToB导入的医院患者关系改为云端的医院患者关系</p>
	 * @author YYCHEN
	 * @date 2016年7月7日 上午10:36:16
	 * @param cloudPatientId
	 * @param tobPatientId
	 * @return
	 */
	public boolean changeHospitalPatientRelation(Long cloudPatientId, Long tobPatientId);
}

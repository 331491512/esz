package com.esuizhen.cloudservice.user.service;

import com.westangel.common.bean.Patient;

public interface DoctorPatientService {
	/**
	 * <p>Title:mergeDoctorPatient</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午7:51:02
	 * @param patient
	 * @param tobPatient
	 * @return
	 */
	public boolean mergeDoctorPatient(Patient patient, Patient tobPatient);
}

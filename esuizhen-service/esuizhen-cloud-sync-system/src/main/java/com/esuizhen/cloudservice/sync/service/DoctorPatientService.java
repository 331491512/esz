package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;

/**
 * 
 * @author YYCHEN
 *
 */
public interface DoctorPatientService {
	
	public boolean syncPatientOfDoctorRelation(DoctorPatient doctorPatient) throws EmptyParamExcption, HospitalWithoutRightExcption;
	
	public boolean mergeDoctorPatient(String doctorUuid, String patientUuid) throws EmptyParamExcption;
}

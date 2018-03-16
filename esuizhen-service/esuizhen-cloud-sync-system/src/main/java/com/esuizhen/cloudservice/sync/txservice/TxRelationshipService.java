package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.model.DoctorPatient;

public interface TxRelationshipService {

	boolean syncDoctorPatientRelationship(DoctorPatient doctorPatient);
}

package com.esuizhen.cloudservice.ehr.service.patient;

import com.esuizhen.cloudservice.ehr.bean.ConsultDoctorsOfPatientGetReq;
import com.esuizhen.cloudservice.ehr.bean.TConsultDoctorDetailResp;
import com.westangel.common.bean.Doctor;

public interface DoctorService {

	public Doctor getConsultDoctorOfPatient(ConsultDoctorsOfPatientGetReq req);
	
	public Doctor getServiceDutyDoctor(Integer hospitalId);

	public TConsultDoctorDetailResp getConsultDoctorDetailOfPatient(ConsultDoctorsOfPatientGetReq req);
}

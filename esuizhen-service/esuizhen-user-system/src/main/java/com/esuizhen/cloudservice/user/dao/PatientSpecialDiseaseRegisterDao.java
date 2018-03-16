package com.esuizhen.cloudservice.user.dao;

import com.esuizhen.cloudservice.user.bean.AutiCancerPatientInfo;

public interface PatientSpecialDiseaseRegisterDao {
	int insertSpecialDisease(AutiCancerPatientInfo autiCancerPatientInfo);
	int updateSpecialDisease(AutiCancerPatientInfo autiCancerPatientInfo);
}

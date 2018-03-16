package com.esuizhen.cloudservice.user.service;

import com.westangel.common.bean.Patient;

public interface EciDetectionReportService {
	public boolean mergeDetection(Patient cloudPatient, Patient tobPatient);
}

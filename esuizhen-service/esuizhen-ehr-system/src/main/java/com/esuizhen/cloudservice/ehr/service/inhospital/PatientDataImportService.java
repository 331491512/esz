package com.esuizhen.cloudservice.ehr.service.inhospital;

import java.io.InputStream;

import javax.servlet.http.HttpSession;

public interface PatientDataImportService {
	
	int importInhospitalInfo(InputStream in,int type, String templateFileName, HttpSession session) throws Exception;
}

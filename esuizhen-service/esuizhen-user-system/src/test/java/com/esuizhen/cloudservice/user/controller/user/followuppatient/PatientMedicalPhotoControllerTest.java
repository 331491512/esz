package com.esuizhen.cloudservice.user.controller.user.followuppatient;

import org.junit.Test;

import com.esuizhen.cloudservice.user.bean.followuppatient.PatientMedicalPhotoQueryReq;

public class PatientMedicalPhotoControllerTest extends CommonControllerTest{
	
	@Test
	public void queryPatientMedicalPhotoList() throws Exception{
		PatientMedicalPhotoQueryReq req = new PatientMedicalPhotoQueryReq();
		req.setPage(0);
		req.setNum(10);
		req.setPatientId(807300L);
		this.doPost("/patient/medical/photo/list/query", req);
	}
}

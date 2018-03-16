package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.CommonDao;
import com.esuizhen.cloudservice.user.dao.followuppatient.PatientMedicalPhotoDao;
import com.esuizhen.cloudservice.user.model.followuppatient.TMedicalPicInfo;
import com.esuizhen.cloudservice.user.service.followuppatient.PatientMedicalPhotoService;
import com.esuizhen.cloudservice.user.service.impl.CommonServiceImpl;

@Service
public class PatientMedicalPhotoServiceImpl extends CommonServiceImpl<TMedicalPicInfo> implements PatientMedicalPhotoService<TMedicalPicInfo>{
	@Autowired
	private PatientMedicalPhotoDao patientMedicalPhotoDao;

	@Override
	protected CommonDao<TMedicalPicInfo> getCommonDao() {
		return patientMedicalPhotoDao;
	}
	
}

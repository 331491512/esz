package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.followuppatient.TPatientExportTemplateInfoDao;
import com.esuizhen.cloudservice.user.model.followuppatient.TPatientExportTemplateInfo;
import com.esuizhen.cloudservice.user.service.followuppatient.TPatientExportTemplateInfoService;

@Service
public class TPatientExportTemplateInfoServiceImpl implements
		TPatientExportTemplateInfoService {
	
	@Autowired
	private TPatientExportTemplateInfoDao patientExportTemplateInfoDao;

	@Override
	public TPatientExportTemplateInfo getPatientExportTemplateById(String id) {
		return patientExportTemplateInfoDao.getPatientExportTemplateById(id);
	}

}

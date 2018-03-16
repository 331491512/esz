package com.esuizhen.cloudservice.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.EciDetectionReportDao;
import com.esuizhen.cloudservice.user.dao.EciEetectionDetailDao;
import com.esuizhen.cloudservice.user.service.EciDetectionReportService;
import com.westangel.common.bean.Patient;

@Service
public class EciDetectionReportServiceImpl implements EciDetectionReportService {
	@Autowired
	private EciDetectionReportDao eciDetectionReportDao;
	@Autowired
	private EciEetectionDetailDao eciEetectionDetailDao;

	public boolean mergeDetection(Patient cloudPatient, Patient tobPatient){
		//合并患者LIS数据
		this.eciEetectionDetailDao.updateToBToCloudPatientId(cloudPatient.getPatientId(), tobPatient.getPatientId());
		//合并患者LIS详情数据
		this.eciDetectionReportDao.updateToBToCloudPatientId(cloudPatient.getPatientId(), tobPatient.getPatientId());
		return true;
	}
}

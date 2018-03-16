package com.esuizhen.cloudservice.ehr.service.patientinfo.impl;

import com.esuizhen.cloudservice.ehr.dao.patientinfo.TPatientInfoDao;
import com.westangel.common.util.LogUtil;

public class AsyncUpdateDoctorOfPatientServiceImpl implements Runnable{
	private Long patientId;
	private TPatientInfoDao patientInfoDao;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public TPatientInfoDao getPatientInfoDao() {
		return patientInfoDao;
	}

	public void setPatientInfoDao(TPatientInfoDao patientInfoDao) {
		this.patientInfoDao = patientInfoDao;
	}

	@Override
	public void run() {
		LogUtil.log.debug("开始更新医患关系信息...");
		long start = System.currentTimeMillis();
		patientInfoDao.updateDoctorOfPatient(patientId);
		long end = System.currentTimeMillis();
		long diff = (end - start)/1000l;
		LogUtil.log.debug("开始更新医患关系信息结束"+diff);
	}
}

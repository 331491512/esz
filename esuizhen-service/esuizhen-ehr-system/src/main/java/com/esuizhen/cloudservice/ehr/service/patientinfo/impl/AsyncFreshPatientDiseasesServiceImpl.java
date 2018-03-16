package com.esuizhen.cloudservice.ehr.service.patientinfo.impl;

import java.util.HashMap;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.dao.diagnose.TDiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.westangel.common.util.LogUtil;

public class AsyncFreshPatientDiseasesServiceImpl implements Runnable{
	private Long patientId;
	private String inhospitalId;
	private TDiagnosisInfoDao<TDiagnosisInfo> diagnosisInfoDao;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public TDiagnosisInfoDao<TDiagnosisInfo> getDiagnosisInfoDao() {
		return diagnosisInfoDao;
	}

	public void setDiagnosisInfoDao(
			TDiagnosisInfoDao<TDiagnosisInfo> diagnosisInfoDao) {
		this.diagnosisInfoDao = diagnosisInfoDao;
	}

	@Override
	public void run() {
		Map<String,Object> diseaseTypeMap = new HashMap<String,Object>();
		diseaseTypeMap.put("textpatientid", patientId);
		diseaseTypeMap.put("textInhospitalId", inhospitalId);
		LogUtil.log.debug("开始调用存储过程刷新病种...");
		long start = System.currentTimeMillis();
		diagnosisInfoDao.freshPatientDiseases(diseaseTypeMap);
		long end = System.currentTimeMillis();
		long diff = (end-start)/1000l;
		LogUtil.log.debug("调用存储过程刷新病种，共花了："+diff+"秒");
	}
}

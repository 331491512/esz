package com.esuizhen.cloudservice.ehr.service.progressdiagnosis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.progressdiagnosis.TProgressDiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.model.progressdiagnosis.TProgressDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.service.progressdiagnosis.TProgressDiagnosisInfoService;

@Service("progressDiagnosisInfoService")
public class TProgressDiagnosisInfoServiceImpl implements
		TProgressDiagnosisInfoService<TProgressDiagnosisInfo> {
	
	@Autowired
	private TProgressDiagnosisInfoDao<TProgressDiagnosisInfo> progressDiagnosisInfoDao;
	
	@Override
	public int createTProgressDiagnosisInfo(
			TProgressDiagnosisInfo progressDiagnosis) {
		return progressDiagnosisInfoDao.createTProgressDiagnosisInfo(progressDiagnosis);
	}

	@Override
	public int deleteTProgressDiagnosisInfoById(String issuedId) {
		return progressDiagnosisInfoDao.deleteTProgressDiagnosisInfoById(issuedId);
	}

	@Override
	public TProgressDiagnosisInfo queryTProgressDiagnosisInfoById(
			String issuedId) {
		return progressDiagnosisInfoDao.queryTProgressDiagnosisInfoById(issuedId);
	}

	@Override
	public List<TProgressDiagnosisInfo> queryTProgressDiagnosisInfoByDiagnosisCardId(
			String diagnosisCardId) {
		return progressDiagnosisInfoDao.queryTProgressDiagnosisInfoByDiagnosisCardId(diagnosisCardId);
	}

}

package com.esuizhen.cloudservice.ehr.service.patientinfo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.diagnose.TDiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.PatientWideTableDao;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.service.patientinfo.PatientWideTableService;
import com.westangel.common.bean.PatientWideTable;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.util.LogUtil;

@Service
@Transactional
public class PatientWideTableServiceImpl implements PatientWideTableService {
	@Autowired
	private PatientWideTableDao patientWideTableDao;
	
	@Autowired
	private TDiagnosisInfoDao<TDiagnosisInfo> diagnosisInfoDao;

	private void updatePatientWideTable(Long patientId,String inhospitalId,Integer type) {
		PatientWideTable patientWideTable = patientWideTableDao.selectPatientWideTableByPatientId(patientId);
		if(patientWideTable == null) {
			patientWideTableDao.insertByPatientId(patientId);
		}
		//刷新病种
		Map<String,Object> diseaseTypeMap = new HashMap<String,Object>();
		diseaseTypeMap.put("textpatientid", patientId);
		diseaseTypeMap.put("textInhospitalId", inhospitalId);
		LogUtil.log.debug("开始调用存储过程刷新病种...");
		long start = System.currentTimeMillis();
		diagnosisInfoDao.freshPatientDiseases(diseaseTypeMap);
		long end = System.currentTimeMillis();
		long diff = (end-start)/1000l;
		LogUtil.log.debug("调用存储过程刷新病种，共花了："+diff+"秒");
		
		PatientWideTable pwt = null;
		if(type == null) {
			pwt = selectByPatientId(patientId);
		}else {
			pwt = selectFamilyRelationByPatientId(patientId);
		}
		if(pwt != null) {
			pwt.setPatientId(patientId);
			patientWideTableDao.updateByPrimaryKey(pwt);
		}
	}
	
	PatientWideTable selectByPatientId(Long patientId) {
		return patientWideTableDao.selectByPatientId(patientId);
	}
	PatientWideTable selectFamilyRelationByPatientId(Long patientId) {
		List<PatientFamily> familyList = patientWideTableDao.selectFamilyRelationByPatientId(patientId);
		
		return null;
	}

	@Override
	public void updatePatientWideTable(final Long patientId, final String inhospitalId){
		LogUtil.log.info("开始更新宽表...");
		long start = System.currentTimeMillis();
		updatePatientWideTable(patientId, inhospitalId,null);
		long end = System.currentTimeMillis();
		long diff = (end-start)/1000l;
		LogUtil.log.info("更新宽表结束,共花了"+diff+"秒");
	}
}

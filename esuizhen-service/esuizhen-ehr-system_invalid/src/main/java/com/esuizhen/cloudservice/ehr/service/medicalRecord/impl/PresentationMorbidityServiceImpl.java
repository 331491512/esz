package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;
import com.esuizhen.cloudservice.ehr.bean.TumourFamilyHistoryInfo;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.CommonService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.PresentationMorbidityService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsInfoService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.TumourFamilyHistoryInfoService;
import com.esuizhen.cloudservice.ehr.service.patient.PatientService;

@Service
public class PresentationMorbidityServiceImpl implements
		PresentationMorbidityService {
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private TumourFamilyHistoryInfoService familyHistoryInfoService;
	
	@Autowired
	private CommonService<TumourFamilyHistoryInfo> tumourFamilyHistoryInfoService;
	
	@Autowired
	private RiskfactorsInfoService riskfactorsInfoService;
	
	@Override
	public int insertPresentationMorbidity(PresentationMorbidityInfo presentationMorbidity) {
		int res = 0;
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("patientId", presentationMorbidity.getPatientId());
		paramsMap.put("inhospitalId", presentationMorbidity.getInhospitalId());
		paramsMap.put("clinicMedicalId", presentationMorbidity.getClinicMedicalId());
		patientService.deletePatientSymptom(paramsMap);
		familyHistoryInfoService.deleteTumourFamilyHistoryInfo(paramsMap);
		riskfactorsInfoService.deleteRiskfactorsInfo(paramsMap);
		res += patientService.savePatientSymptom(presentationMorbidity.getSymptomList());
		res += familyHistoryInfoService.batchInsertTumourFamilyHistoryInfo(presentationMorbidity.getFamilyHistoryList());
		res += riskfactorsInfoService.insertRiskfactorsInfo(presentationMorbidity.getRiskfactors());
		return res;
	}

	@Override
	public PresentationMorbidityInfo queryPresentationMorbidity(CommonReq req) {
		PresentationMorbidityInfo presentationMorbidity = new PresentationMorbidityInfo();
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("patientId", req.getPatientId());
		paramsMap.put("inhospitalId", req.getInhospitalId());
		paramsMap.put("clinicMedicalId", req.getClinicMedicalId());
		presentationMorbidity.setSymptomList(patientService.patientSymptomList(paramsMap));
		presentationMorbidity.setFamilyHistoryList(tumourFamilyHistoryInfoService.queryList(req));
		presentationMorbidity.setRiskfactors(riskfactorsInfoService.queryRiskfactorsInfo(req));
		return presentationMorbidity;
	}
}

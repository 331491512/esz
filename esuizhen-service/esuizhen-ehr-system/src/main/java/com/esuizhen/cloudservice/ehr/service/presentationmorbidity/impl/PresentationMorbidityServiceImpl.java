package com.esuizhen.cloudservice.ehr.service.presentationmorbidity.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;
import com.esuizhen.cloudservice.ehr.bean.TumourFamilyHistoryInfo;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.CommonService;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.PresentationMorbidityService;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.RiskfactorsInfoService;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.TumourFamilyHistoryInfoService;
import com.esuizhen.cloudservice.ehr.service.symptom.SymptomService;

@Service
public class PresentationMorbidityServiceImpl implements PresentationMorbidityService {
	
	@Autowired
	private SymptomService symptomService;
	
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
		symptomService.deletePatientSymptom(paramsMap);
		familyHistoryInfoService.deleteTumourFamilyHistoryInfo(paramsMap);
		riskfactorsInfoService.deleteRiskfactorsInfo(paramsMap);
		res += symptomService.savePatientSymptom(presentationMorbidity.getSymptomList());
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
		presentationMorbidity.setSymptomList(symptomService.patientSymptomList(paramsMap));
		presentationMorbidity.setFamilyHistoryList(tumourFamilyHistoryInfoService.queryList(req));
		presentationMorbidity.setRiskfactors(riskfactorsInfoService.queryRiskfactorsInfo(req));
		return presentationMorbidity;
	}
}

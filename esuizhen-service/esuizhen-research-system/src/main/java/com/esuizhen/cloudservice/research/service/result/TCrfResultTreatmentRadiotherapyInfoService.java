package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentRadiotherapyInfo;


public interface TCrfResultTreatmentRadiotherapyInfoService{

	public TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>> queryCrfResultTreatmentRadiotherapy(String crfObserveId , Long patientId);
	
	public void saveCrfResultTreatmentRadiotherapy(TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>> crfResultMainInfo);
}

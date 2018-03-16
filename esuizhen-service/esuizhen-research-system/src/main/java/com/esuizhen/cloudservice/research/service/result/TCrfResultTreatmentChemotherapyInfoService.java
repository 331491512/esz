package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentChemotherapyInfo;

public interface TCrfResultTreatmentChemotherapyInfoService
{

	public TCrfResultMainInfo<List<TCrfResultTreatmentChemotherapyInfo>> queryCrfResultTreatmentChemotherapy(String crfObserveId , Long patientId);
	
	public void saveResultTreatmentChemotherapy(TCrfResultMainInfo<List<TCrfResultTreatmentChemotherapyInfo>> crfResultMainInfo);
}

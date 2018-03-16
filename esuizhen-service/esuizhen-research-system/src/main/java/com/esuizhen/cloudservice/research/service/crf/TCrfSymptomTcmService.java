package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcm;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcmInfo;


public interface TCrfSymptomTcmService{
	
	public List<TCrfSymptomTcmInfo> queryCrfSymptomsTcm(String crfObserveId);
	
	public void saveCrfSymptomsTcm(TCrfSymptomTcm crfSymptomTcm);
}

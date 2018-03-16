package com.esuizhen.cloudservice.research.service.crf;

import com.esuizhen.cloudservice.research.model.crf.CrfObservationLeafElementOptions;

public interface CrfLeafElementOptionsService{
	
	public void insertCrfObservationLeafElementOptions(CrfObservationLeafElementOptions crfObservationLeafElementOptions);
	
	public void updateCrfObservationLeafElementOptions(CrfObservationLeafElementOptions crfObservationLeafElementOptions);
	
	public void deleteCrfObservationLeafElementOptions(Long crfObservationLeafElementOptionsId);
	
	public CrfObservationLeafElementOptions queryCrfObservationLeafElementOptions(Long crfObservationLeafElementOptionsId);

}

package com.esuizhen.cloudservice.research.dao.crf;

import com.esuizhen.cloudservice.research.model.crf.CrfObservationLeafElementOptions;

public interface CrfObservationLeafElementOptionsDao{
	
	public void insertCrfObservationLeafElementOptions(CrfObservationLeafElementOptions crfObservationLeafElementOptions);
	
	public void updateCrfObservationLeafElementOptions(CrfObservationLeafElementOptions crfObservationLeafElementOptions);
	
	public void deleteCrfObservationLeafElementOptions(Long crfObservationLeafElementOptionsId);
	
	public CrfObservationLeafElementOptions queryCrfObservationLeafElementOptions(Long crfObservationLeafElementOptionsId);
	
}

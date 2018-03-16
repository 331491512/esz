package com.esuizhen.cloudservice.research.service.impl.crf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.CrfObservationLeafElementOptionsDao;
import com.esuizhen.cloudservice.research.model.crf.CrfObservationLeafElementOptions;
import com.esuizhen.cloudservice.research.service.crf.CrfLeafElementOptionsService;

@Service
@Transactional
public class CrfLeafElementOptionsServiceImpl implements CrfLeafElementOptionsService {

	@Autowired
	private CrfObservationLeafElementOptionsDao dao;

	@Override
	public void insertCrfObservationLeafElementOptions(
			CrfObservationLeafElementOptions crfObservationLeafElementOptions) {
		dao.insertCrfObservationLeafElementOptions(crfObservationLeafElementOptions);
	}

	@Override
	public void updateCrfObservationLeafElementOptions(
			CrfObservationLeafElementOptions crfObservationLeafElementOptions) {
		dao.updateCrfObservationLeafElementOptions(crfObservationLeafElementOptions);
	}

	@Override
	public void deleteCrfObservationLeafElementOptions(Long crfObservationLeafElementOptionsId) {
		dao.deleteCrfObservationLeafElementOptions(crfObservationLeafElementOptionsId);
	}

	@Override
	public CrfObservationLeafElementOptions queryCrfObservationLeafElementOptions(
			Long crfObservationLeafElementOptionsId) {
		return dao.queryCrfObservationLeafElementOptions(crfObservationLeafElementOptionsId);
	}

}

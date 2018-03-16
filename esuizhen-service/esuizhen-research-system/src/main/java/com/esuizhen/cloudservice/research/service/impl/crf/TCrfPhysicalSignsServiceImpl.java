package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfPhysicalSignsDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSigns;
import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSignsInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfPhysicalSignsService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfPhysicalSignsServiceImpl implements TCrfPhysicalSignsService {

	@Autowired
	private TCrfPhysicalSignsDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfPhysicalSigns(TCrfPhysicalSigns crfPhysicalSigns) {
		dao.deleteCrfObservationPhysicalSignsOptionsByCrfObserveId(crfPhysicalSigns.getCrfObserveId());

		if (crfPhysicalSigns.getPhysicalSignsList() == null || crfPhysicalSigns.getPhysicalSignsList().size() < 1) {// 如果为清空操作直接退出
			return;
		}

		for (TCrfPhysicalSignsInfo crfPhysicalSignsInfo : crfPhysicalSigns.getPhysicalSignsList()) {
			crfPhysicalSignsInfo.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
			crfPhysicalSignsInfo.setCrfObserveId(crfPhysicalSigns.getCrfObserveId());
		}

		dao.insertCrfObservationPhysicalSignsOptionsList(crfPhysicalSigns.getPhysicalSignsList());
	}

	@Override
	public List<TCrfPhysicalSignsInfo> queryCrfPhysicalSigns(String crfObserveId) {
		return dao.queryCrfObservationPhysicalSignsOptionsByCrfObserveId(crfObserveId);
	}

}

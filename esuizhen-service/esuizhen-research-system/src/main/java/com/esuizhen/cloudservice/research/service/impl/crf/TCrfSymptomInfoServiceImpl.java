package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfSymptomInfoDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptom;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfSymptomInfoService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfSymptomInfoServiceImpl implements TCrfSymptomInfoService {

	@Autowired
	private TCrfSymptomInfoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfSymptoms(TCrfSymptom crfSymptom) {
		dao.deleteCrfObservationClinicSymptomOptionsByCrfObserveId(crfSymptom.getCrfObserveId());

		if (crfSymptom.getDataList() == null || crfSymptom.getDataList().size() < 1) {// 如果为清空操作直接退出
			return;
		}

		for (int i = 0, size = crfSymptom.getDataList().size(); i < size; i++) {
			TCrfSymptomInfo crfSymptomInfo = crfSymptom.getDataList().get(i);

			crfSymptomInfo.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
			crfSymptomInfo.setCrfObserveId(crfSymptom.getCrfObserveId());
			crfSymptomInfo.setIndex(i);
		}

		dao.insertCrfObservationClinicSymptomOptionsList(crfSymptom.getDataList());
	}

	@Override
	public List<TCrfSymptomInfo> queryCrfSymptoms(String crfObserveId) {
		return dao.queryByCrfObserveId(crfObserveId);
	}
}

package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfSymptomTcmInfoDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcm;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcmInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfSymptomTcmService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfSymptomTcmServiceImpl implements TCrfSymptomTcmService {

	@Autowired
	private TCrfSymptomTcmInfoDao dao;

	@Override
	public List<TCrfSymptomTcmInfo> queryCrfSymptomsTcm(String crfObserveId) {
		return dao.queryCrfObservationTcmSymptomOptionsByCrfObserveId(crfObserveId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfSymptomsTcm(TCrfSymptomTcm crfSymptomTcm) {
		dao.deleteCrfObservationTcmSymptomOptionsByCrfObserveId(crfSymptomTcm.getCrfObserveId());

		if (crfSymptomTcm.getDataList() == null || crfSymptomTcm.getDataList().size() < 1) {// 如果为清空操作直接退出
			return;
		}

		for (TCrfSymptomTcmInfo crfSymptomTcmInfo : crfSymptomTcm.getDataList()) {
			crfSymptomTcmInfo.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
			crfSymptomTcmInfo.setCrfObserveId(crfSymptomTcm.getCrfObserveId());
		}

		dao.insertCrfObservationTcmSymptomOptionsList(crfSymptomTcm.getDataList());
	}

}

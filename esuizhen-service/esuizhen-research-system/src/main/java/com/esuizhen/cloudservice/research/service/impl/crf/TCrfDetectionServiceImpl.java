package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfDetectionDetailDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfDetection;
import com.esuizhen.cloudservice.research.model.crf.TCrfDetectionDetail;
import com.esuizhen.cloudservice.research.model.crf.TCrfDetectionItemInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfDetectionService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfDetectionServiceImpl implements TCrfDetectionService {

	@Autowired
	private TCrfDetectionDetailDao dao;

	@Override
	public List<TCrfDetectionDetail> queryCrfDetectionItemDetail(String crfObserveId) {
		return dao.queryCrfObservationDetectionItemDetailOptionsByCrfObserveId(crfObserveId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfDetectionItemDetail(TCrfDetection crfDetection) {
		dao.deleteCrfObservationDetectionItemDetailOptionsByCrfObserveId(crfDetection.getCrfObserveId());

		List<TCrfDetectionDetail> detailList = new ArrayList<TCrfDetectionDetail>();
		for (int i = 0; i < crfDetection.getDataList().size(); i++) {
			TCrfDetectionDetail crfDetectionDetail = crfDetection.getDataList().get(i);
			crfDetectionDetail.setIndex(i);
			List<TCrfDetectionItemInfo> crfDetectionItemInfos = crfDetectionDetail.getDetectionItemList();
			for (int j = 0; j < crfDetectionItemInfos.size(); j++) {
				TCrfDetectionItemInfo crfDetectionItemInfo = crfDetectionItemInfos.get(j);
				TCrfDetectionDetail detail = (TCrfDetectionDetail) crfDetectionDetail.clone();
				detail.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
				detail.setCrfObserveId(crfDetection.getCrfObserveId());
				detail.setDetectionItemId(crfDetectionItemInfo.getDetectionItemId());
				detail.setRefrenceRangeMin(crfDetectionItemInfo.getRefrenceRangeMin());
				detail.setRefrenceRangeMax(crfDetectionItemInfo.getRefrenceRangeMax());
				detail.setUnit(crfDetectionItemInfo.getUnit());
				detail.setIndex(j);// 排序索引
				detailList.add(detail);
			}
		}
		if (!detailList.isEmpty()) {
			dao.insertCrfObservationDetectionItemDetailOptionsList(detailList);
		}
	}

}

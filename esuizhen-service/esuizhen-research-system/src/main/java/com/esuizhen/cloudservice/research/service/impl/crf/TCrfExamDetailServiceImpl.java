package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfExamDetailDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfExams;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamsDetail;
import com.esuizhen.cloudservice.research.service.crf.TCrfExamDetailService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfExamDetailServiceImpl implements TCrfExamDetailService {

	@Autowired
	private TCrfExamDetailDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfExamItemDetail(TCrfExams crfExams) {
		dao.deleteCrfObservationExamItemDetailOptionsByCrfObserveId(crfExams.getCrfObserveId());

		if (crfExams.getDataList() == null || crfExams.getDataList().size() < 1) {// 如果为清空操作直接退出
			return;
		}
		for (int i = 0; i < crfExams.getDataList().size(); i++) {
			TCrfExamsDetail crfExamsDetail = crfExams.getDataList().get(i);
			crfExamsDetail.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
			crfExamsDetail.setCrfObserveId(crfExams.getCrfObserveId());
			crfExamsDetail.setIndex(i);

			// for(TCrfExamsItemInfo crfExamsItemInfo :
			// crfExamsDetail.getExamItemList())
			// {
			// TCrfExamsDetail detail = (TCrfExamsDetail)
			// crfExamsDetail.clone();
			// detail.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
			// detail.setCrfObserveId(crfExams.getCrfObserveId());
			// detail.setExamItemId(crfExamsItemInfo.getExamItemId());
			// detail.setExamItemCode(crfExamsItemInfo.getExamItemCode());
			// detailList.add(detail);
			// }
		}
		dao.insertCrfObservationExamItemDetailOptionsList(crfExams.getDataList());
	}

	@Override
	public List<TCrfExamsDetail> queryCrfExamItemDetail(String crfObserveId) {
		return dao.queryCrfObservationExamItemDetailOptionsByCrfObserveId(crfObserveId);
	}

}

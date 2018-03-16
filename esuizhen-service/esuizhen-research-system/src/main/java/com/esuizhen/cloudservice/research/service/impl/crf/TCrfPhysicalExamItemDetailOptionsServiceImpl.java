package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.bean.TCrfPhysicalConditionScoreInfo;
import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamItemDetailOptions;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.service.crf.TCrfPhysicalconditionScoreService;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfPhysicalExamItemDetailOptionsServiceImpl implements TCrfPhysicalconditionScoreService {
	@Autowired
	private TCrfObservationSubjectElementDao crfObservationSubjectElementDao;

	@Override
	public List<TCrfExamItemDetailOptions> queryCrfPhysicalConditionScoreInfo(String crfObserveId) {
		return this.crfObservationSubjectElementDao.findChildListByCrfObserveId(crfObserveId);
	}

	@Transactional
	@Override
	public boolean saveCrfPhysicalConditionScore(TCrfPhysicalConditionScoreInfo crfPhysicalConditionScoreInfo) {
		TCrfObservationSubjectElement parent = this.crfObservationSubjectElementDao.queryCrfObservationSubjectElement(crfPhysicalConditionScoreInfo.getCrfObserveId());
		if (parent == null) {
			return false;
		}
		//删除之前的CRF身体状况评分设置项
		List<TCrfExamItemDetailOptions> list = this.crfObservationSubjectElementDao.findChildListByCrfObserveId(crfPhysicalConditionScoreInfo.getCrfObserveId());
		if (list != null && !list.isEmpty()) {
			this.crfObservationSubjectElementDao.deleteByBatch(list);
		}
		//保存新的CRF身体状况评分设置项
		List<TCrfObservationSubjectElement> crfExamItemDetailOptions = crfPhysicalConditionScoreInfo.getPhysicalConditionScoreList();
		for (int i = 0; i < crfExamItemDetailOptions.size(); i++) {
			TCrfObservationSubjectElement crfObservationSubjectElement = crfExamItemDetailOptions.get(i);
			crfObservationSubjectElement.setCrfObserveId(GeneralUtil.generateUniqueID("OBSE"));
			crfObservationSubjectElement.setCrfCourseItemId(parent.getCrfCourseItemId());
			crfObservationSubjectElement.setParentId(parent.getSubjectElementId());
			crfObservationSubjectElement.setSubjectIndex(i);
		}
		this.crfObservationSubjectElementDao.insertCrfObservationSubjectElementList(crfExamItemDetailOptions);
		return true;
	}

}

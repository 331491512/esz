package com.esuizhen.cloudservice.research.service.impl.crf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.dao.crf.TCrfPainScaleOptionsDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.crf.TCrfPainScaleOptions;
import com.esuizhen.cloudservice.research.service.crf.TCrfPainScaleOptionsService;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfPainScaleOptionsServiceImpl implements TCrfPainScaleOptionsService {
	@Autowired
	private TCrfObservationSubjectElementDao crfObservationSubjectElementDao;
	@Autowired
	private TCrfPainScaleOptionsDao crfPainScaleOptionsDao;

	@Override
	public TCrfPainScaleOptions getCrfPainScaleInfoByCrfObserveId(String crfObserveId) {
		TCrfPainScaleOptions crfPainScaleOptions = this.crfPainScaleOptionsDao.findCrfPainScaleInfoByCrfObserveId(crfObserveId);
		if (crfPainScaleOptions == null) {
			return this.createDefault(crfObserveId);
		}
		return crfPainScaleOptions;
	}
	
	/**
	 * <p>Title:createDefault</p>
	 * <p>Description:增加默认疼痛指数</p>
	 * @author YYCHEN
	 * @date 2016年11月4日 下午4:11:49
	 * @param crfObserveId
	 * @return
	 */
	private TCrfPainScaleOptions createDefault(String crfObserveId){
		TCrfObservationSubjectElement crfObservationSubjectElement = this.crfObservationSubjectElementDao.queryCrfObservationSubjectElement(crfObserveId);
		if (crfObservationSubjectElement == null) {
			return null;
		}
		TCrfPainScaleOptions crfPainScaleOptions = new TCrfPainScaleOptions();
		crfPainScaleOptions.setCrfPainScaleId(GeneralUtil.generateUniqueID("CRPS"));
		crfPainScaleOptions.setCrfObserveId(crfObserveId);
		crfPainScaleOptions.setSubjectElementId(crfObservationSubjectElement.getSubjectElementId());
		crfPainScaleOptions.setCollectionFlag(1);
		
		this.crfPainScaleOptionsDao.insert(crfPainScaleOptions);
		
		return crfPainScaleOptions;
	}

	@Override
	public boolean saveCrfPainScaleInfo(TCrfPainScaleOptions crfPainScaleOptions) {
		return this.crfPainScaleOptionsDao.update(crfPainScaleOptions) > 0;
	}

}

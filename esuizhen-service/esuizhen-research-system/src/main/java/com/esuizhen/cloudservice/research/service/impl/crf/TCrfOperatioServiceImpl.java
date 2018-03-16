package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfOperationInfoDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfOperation;
import com.esuizhen.cloudservice.research.model.crf.TCrfOperationInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfOperationService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfOperatioServiceImpl implements TCrfOperationService{
	
	@Autowired
	private TCrfOperationInfoDao dao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveCrfTreatmentOperation(TCrfOperation crfOperation)
	{
		dao.deleteCrfObservationtreatmentOperationOptionsByCrfObserveId(crfOperation.getCrfObserveId());
		
		if(crfOperation.getDataList()==null || crfOperation.getDataList().size()<1)
		{//如果为清空操作直接退出
			return;
		}
		
		for(int i = 0; i < crfOperation.getDataList().size(); i++)
		{
			TCrfOperationInfo crfOperationInfo = crfOperation.getDataList().get(i);
			crfOperationInfo.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
			crfOperationInfo.setCrfObserveId(crfOperation.getCrfObserveId());
			crfOperationInfo.setIndex(i);
		}
		dao.insertCrfObservationtreatmentOperationOptionsList(crfOperation.getDataList());
	}

	@Override
	public List<TCrfOperationInfo> queryCrfTreatmentOperation(String crfObserveId)
	{
		return dao.queryCrfObservationtreatmentOperationOptionsByCrfObserveId(crfObserveId);
	}
	
}

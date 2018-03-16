package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfAdverseReactionInfoDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReaction;
import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReactionInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfAdverseReactionService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfAdverseReactionServiceImpl implements TCrfAdverseReactionService{
	
	@Autowired
	private TCrfAdverseReactionInfoDao dao;

	@Override
	public List<TCrfAdverseReactionInfo> queryCrfAdverseReaction(String crfObserveId)
	{
		return dao.queryCrfObservationAdverseReactionOptionsByCrfObserveId(crfObserveId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveCrfAdverseReaction(TCrfAdverseReaction crfAdverseReaction)
	{
		dao.deleteCrfObservationAdverseReactionOptionsByCrfObserveId(crfAdverseReaction.getCrfObserveId());
		
		if(crfAdverseReaction.getAdverseReactionList()==null || crfAdverseReaction.getAdverseReactionList().size()<1)
		{//如果为清空操作直接退出
			return;
		}
		
		for(int i = 0; i < crfAdverseReaction.getAdverseReactionList().size(); i++)
		{
			TCrfAdverseReactionInfo crfAdverseReactionInfo = crfAdverseReaction.getAdverseReactionList().get(i);
			crfAdverseReactionInfo.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
			crfAdverseReactionInfo.setCrfObserveId(crfAdverseReaction.getCrfObserveId());
			crfAdverseReactionInfo.setIndex(i);
		}
		
		dao.insertCrfObservationAdverseReactionOptionsList(crfAdverseReaction.getAdverseReactionList());
	}
}

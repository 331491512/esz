package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultAdverseReactionInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultAdverseReactionInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultAdverseReactionInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
@Transactional
public class TCrfResultAdverseReactionInfoServiceImpl implements TCrfResultAdverseReactionInfoService{
	
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultAdverseReactionInfoDao crfResultAdverseReactionInfoDao;

	@Override
	public TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>> queryCrfResultAdverseReaction(String crfObserveId, Long patientId)
	{
		return crfResultAdverseReactionInfoDao.queryCrfResultAdverseReactionByCrfObserveIdAndPatientId(crfObserveId, patientId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveCrfResultAdverseReaction(TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>> crfResultMainInfo)
	{
		//查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		
		if(mainInfo!=null)
		{//如果填写过则删除
			
			//删除不良反应结果
			crfResultAdverseReactionInfoDao.deleteCrfResultAdverseReactionByCrfResultId(mainInfo.getCrfResultId());
			
			//删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}
				
		//保存结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);
		
		List<TCrfResultAdverseReactionInfo> adverseReactionInfos = crfResultMainInfo.getCrfResult();
		if (adverseReactionInfos == null || adverseReactionInfos.isEmpty()) {
			return;
		}
		//保存不良反应结果信息
		for(int i = 0; i < adverseReactionInfos.size(); i++)
		{
			TCrfResultAdverseReactionInfo crfResultAdverseReactionInfo = adverseReactionInfos.get(i);
			crfResultAdverseReactionInfo.setIndex(i);
			String crfAdverseReactionResultId = GeneralUtil.generateUniqueID("CRAR");
			crfResultAdverseReactionInfo.setCrfResultId(crfResultId);
			crfResultAdverseReactionInfo.setCrfAdverseReactionResultId(crfAdverseReactionResultId);
		}
		crfResultAdverseReactionInfoDao.insertCrfResultAdverseReactionList(adverseReactionInfos);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TCrfResultAdverseReactionInfo> queryCrfResultAdverseReactionRecord(String projectId, Long patientId, Integer page, Integer num)
	{
		if (StringUtils.isEmpty(projectId) || patientId == null) {
			return null;
		}
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1) {
			num = 10;
		}
		PageHelper.startPage(page + 1, num);
		List<TCrfResultAdverseReactionInfo> adverseReactionInfos = crfResultAdverseReactionInfoDao.queryCrfResultAdverseReactionRecords(projectId, patientId);
		return PageUtil.returnPage((com.github.pagehelper.Page<TCrfResultAdverseReactionInfo>)adverseReactionInfos);
	}
	
}

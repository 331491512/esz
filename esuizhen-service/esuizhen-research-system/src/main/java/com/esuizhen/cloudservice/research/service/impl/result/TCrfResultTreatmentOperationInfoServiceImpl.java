package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentOperationInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentOperationInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentOperationInfoService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfResultTreatmentOperationInfoServiceImpl implements TCrfResultTreatmentOperationInfoService{
	
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultTreatmentOperationInfoDao crfResultTreatmentOperationInfoDao;

	@Override
	public TCrfResultMainInfo<List<TCrfResultTreatmentOperationInfo>> queryCrfResultTreatmentOperation(String crfObserveId, Long patientId)
	{
		return crfResultTreatmentOperationInfoDao.queryCrfResultTreatmentOperationByCrfObserveIdAndPatientId(crfObserveId, patientId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveCrfResultTreatmentOperation(TCrfResultMainInfo<List<TCrfResultTreatmentOperationInfo>> crfResultMainInfo)
	{
		//查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		
		if(mainInfo!=null)
		{//如果填写过则删除
			
			//删除手术结果
			crfResultTreatmentOperationInfoDao.deleteCrfResultTreatmentOperationByCrfResultId(mainInfo.getCrfResultId());
			
			//删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}
				
		//保存手术结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);
		
		//保存手术结果信息
		for(int i = 0; i < crfResultMainInfo.getCrfResult().size(); i++)
		{
			TCrfResultTreatmentOperationInfo crfResultTreatmentOperationInfo = crfResultMainInfo.getCrfResult().get(i);
			String crfTreatmentOperationResultId = GeneralUtil.generateUniqueID("CRTE");
			crfResultTreatmentOperationInfo.setCrfResultId(crfResultId);
			crfResultTreatmentOperationInfo.setCrfTreatmentOperationResultId(crfTreatmentOperationResultId);
		}
		
		crfResultTreatmentOperationInfoDao.insertCrfResultTreatmentOperationList(crfResultMainInfo.getCrfResult());;
	}
	
	
}

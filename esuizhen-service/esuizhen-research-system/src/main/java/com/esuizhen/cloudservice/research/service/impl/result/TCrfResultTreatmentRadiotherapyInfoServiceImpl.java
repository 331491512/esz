package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentRadiotherapyDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentRadiotherapyInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentRadiotherapyDetail;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentRadiotherapyInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentRadiotherapyInfoService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfResultTreatmentRadiotherapyInfoServiceImpl implements TCrfResultTreatmentRadiotherapyInfoService{
	
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultTreatmentRadiotherapyInfoDao crfResultTreatmentRadiotherapyInfoDao;

	@Autowired
	private TCrfResultTreatmentRadiotherapyDetailDao crfResultTreatmentRadiotherapyDetailDao;
	
	@Override
	public TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>> queryCrfResultTreatmentRadiotherapy(String crfObserveId, Long patientId)
	{
		return crfResultTreatmentRadiotherapyInfoDao.queryCrfResultTreatmentRadiotherapyByCrfObserveIdAndPatientId(crfObserveId, patientId);
	}

	@Override
	public void saveCrfResultTreatmentRadiotherapy(TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>> crfResultMainInfo)
	{
		//查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		
		if(mainInfo!=null)
		{//如果填写过则删除
			
			//删除放疗结果明细
			crfResultTreatmentRadiotherapyDetailDao.deleteCrfResultTreatmentRadiotherapyDetailByCrfResultId(mainInfo.getCrfResultId());
			
			//删除放疗结果
			crfResultTreatmentRadiotherapyInfoDao.deleteCrfResultTreatmentRadiotherapyByCrfResultId(mainInfo.getCrfResultId());
			
			//删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}
				
		//保存放疗结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);
		
		//保存放疗结果信息
		for(TCrfResultTreatmentRadiotherapyInfo crfResultTreatmentRadiotherapyInfo : crfResultMainInfo.getCrfResult())
		{
			String crfTreatmentRadiotherapyResultId = GeneralUtil.generateUniqueID("CRTE");
			crfResultTreatmentRadiotherapyInfo.setCrfResultId(crfResultId);
			crfResultTreatmentRadiotherapyInfo.setCrfTreatmentRadiotherapyResultId(crfTreatmentRadiotherapyResultId);
			crfResultTreatmentRadiotherapyInfoDao.insertCrfResultTreatmentRadiotherapy(crfResultTreatmentRadiotherapyInfo);
			
			//保存放疗结果明细
			for(TCrfResultTreatmentRadiotherapyDetail crfResultTreatmentRadiotherapyDetail : crfResultTreatmentRadiotherapyInfo.getCrfResultTreatmentRadiotherapyDetailList())
			{
				String crfTreatmentRadiotherapyResultDetailId = GeneralUtil.generateUniqueID("CTDE");
				crfResultTreatmentRadiotherapyDetail.setCrfTreatmentRadiotherapyResultId(crfTreatmentRadiotherapyResultId);
				crfResultTreatmentRadiotherapyDetail.setCrfTreatmentRadiotherapyResultDetailId(crfTreatmentRadiotherapyResultDetailId);;
			}
			
			crfResultTreatmentRadiotherapyDetailDao.insertCrfResultTreatmentRadiotherapyDetailList(crfResultTreatmentRadiotherapyInfo.getCrfResultTreatmentRadiotherapyDetailList());
		}
	}
	
	
}

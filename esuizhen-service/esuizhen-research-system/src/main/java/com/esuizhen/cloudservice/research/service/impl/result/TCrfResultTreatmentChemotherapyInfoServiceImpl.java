package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentChemotherapyInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentChemotherapyMedicationDetailDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentChemotherapyInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentChemotherapyMedicationDetail;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentChemotherapyInfoService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfResultTreatmentChemotherapyInfoServiceImpl implements TCrfResultTreatmentChemotherapyInfoService
{
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultTreatmentChemotherapyInfoDao crfResultTreatmentChemotherapyInfoDao;

	@Autowired
	private TCrfResultTreatmentChemotherapyMedicationDetailDao crfResultTreatmentChemotherapyMedicationDetailDao;
	@Override
	public TCrfResultMainInfo<List<TCrfResultTreatmentChemotherapyInfo>> queryCrfResultTreatmentChemotherapy(String crfObserveId, Long patientId)
	{
		return crfResultTreatmentChemotherapyInfoDao.queryCrfResultTreatmentChemotherapyByCrfObserveIdPatientId(crfObserveId, patientId);
	}

	@Transactional
	@Override
	public void saveResultTreatmentChemotherapy(TCrfResultMainInfo<List<TCrfResultTreatmentChemotherapyInfo>> crfResultMainInfo)
	{
		//查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		
		if(mainInfo!=null)
		{//如果填写过则删除
			
			//删除化疗结果明细
			crfResultTreatmentChemotherapyMedicationDetailDao.deleteCrfResultTreatmentChemotherapyMedicationDetailByCrfResultId(mainInfo.getCrfResultId());
			
			//删除化疗结果
			crfResultTreatmentChemotherapyInfoDao.deleteCrfResultTreatmentChemotherapyByCrfResultId(mainInfo.getCrfResultId());
			
			//删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}
				
		//保存化疗结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);
		
		List<TCrfResultTreatmentChemotherapyInfo> crfResultTreatmentChemotherapyInfos = crfResultMainInfo.getCrfResult();
		if (crfResultTreatmentChemotherapyInfos == null || crfResultTreatmentChemotherapyInfos.isEmpty()) {
			return;
		}
		//保存化疗结果信息
		for(TCrfResultTreatmentChemotherapyInfo crfResultTreatmentChemotherapyInfo : crfResultTreatmentChemotherapyInfos)
		{
			String crfTreatmentChemotherapyResultId = GeneralUtil.generateUniqueID("CRTE");
			crfResultTreatmentChemotherapyInfo.setCrfResultId(crfResultId);
			crfResultTreatmentChemotherapyInfo.setCrfTreatmentChemotherapyResultId(crfTreatmentChemotherapyResultId);
			this.crfResultTreatmentChemotherapyInfoDao.insertCrfResultTreatmentChemotherapy(crfResultTreatmentChemotherapyInfo);
			
			//保存化疗结果明细
			List<TCrfResultTreatmentChemotherapyMedicationDetail> chemotherapyMedicationDetails = crfResultTreatmentChemotherapyInfo.getCrfResultTreatmentChemotherapyMedicationDetailList();
			for(int i = 0; i < chemotherapyMedicationDetails.size(); i++)
			{
				TCrfResultTreatmentChemotherapyMedicationDetail crfResultTreatmentChemotherapyMedicationDetail = chemotherapyMedicationDetails.get(i);
				String crfChemotherapyMedicationResultDetailId = GeneralUtil.generateUniqueID("CTDE");
				crfResultTreatmentChemotherapyMedicationDetail.setCrfChemotherapyMedicationResultDetailId(crfChemotherapyMedicationResultDetailId);
				crfResultTreatmentChemotherapyMedicationDetail.setCrfResultId(crfResultId);
				crfResultTreatmentChemotherapyMedicationDetail.setCrfTreatmentChemotherapyResultId(crfTreatmentChemotherapyResultId);
				crfResultTreatmentChemotherapyMedicationDetail.setIndex(i);
			}
			this.crfResultTreatmentChemotherapyMedicationDetailDao.insertCrfResultTreatmentChemotherapyMedicationDetailList(chemotherapyMedicationDetails);
		}
	}
}

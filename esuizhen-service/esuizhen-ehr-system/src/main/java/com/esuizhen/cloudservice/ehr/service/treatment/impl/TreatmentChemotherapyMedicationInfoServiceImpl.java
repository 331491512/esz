package com.esuizhen.cloudservice.ehr.service.treatment.impl;

import java.util.List;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.treatment.TreatmentChemotherapyMedicationInfoDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentChemotherapyMedicationDetailInfoService;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentChemotherapyMedicationInfoService;
import com.westangel.common.util.GeneralUtil;

@Service
public class TreatmentChemotherapyMedicationInfoServiceImpl extends CommonServiceImpl<TreatmentChemotherapyMedicationInfo> implements TreatmentChemotherapyMedicationInfoService{
	
	@Autowired
	private TreatmentChemotherapyMedicationInfoDao treatmentChemotherapyMedicationInfoDao;
	
	@Autowired
	private TreatmentChemotherapyMedicationDetailInfoService chemotherapyMedicationDetailInfoService;
	
	@Override
	public CommonDao<TreatmentChemotherapyMedicationInfo> getCommonDao() {
		return treatmentChemotherapyMedicationInfoDao;
	}

	@Override
	public List<TreatmentChemotherapyMedicationInfo> queryChemotherapyMedicationInfo(CommonReq req) {
		return super.queryList(req);
	}

	@Override
	public int saveChemotherapyMedicationInfo(
			TreatmentChemotherapyMedicationInfo chemotherapyMedicationInfo) {
		int res = 0;
		if(chemotherapyMedicationInfo.getChemotherapyMedicationRecordId() == null) {
			chemotherapyMedicationInfo.setChemotherapyMedicationRecordId(GeneralUtil.generatorUUID("CHME"));
			res += super.save(chemotherapyMedicationInfo);
		}else {
			res += super.update(chemotherapyMedicationInfo);
		}
		res += chemotherapyMedicationDetailInfoService.saveTreatmentChemotherapyMedicationDetailInfo(chemotherapyMedicationInfo);
		return res;
	}

	@Override
	public void deleteChemotherapyMedicationInfo(Map<String,Object> paramsMap) {
		chemotherapyMedicationDetailInfoService.deleteTreatmentChemotherapyMedicationDetailInfo(paramsMap);
		treatmentChemotherapyMedicationInfoDao.deleteChemotherapyMedicationInfo(paramsMap);
	}

}

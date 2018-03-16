package com.esuizhen.cloudservice.ehr.service.treatment.impl;

import java.util.List;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.treatment.TreatmentRadiotherapyInfoDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentRadiotherapyDetailInfoService;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentRadiotherapyInfoService;
import com.westangel.common.util.GeneralUtil;

@Service
public class TreatmentRadiotherapyInfoServiceImpl extends CommonServiceImpl<TreatmentRadiotherapyInfo> implements
		TreatmentRadiotherapyInfoService {
	
	@Autowired
	private TreatmentRadiotherapyInfoDao treatmentRadiotherapyInfoDao;
	
	@Autowired
	private TreatmentRadiotherapyDetailInfoService treatmentRadiotherapyDetailInfoService;
	
	@Override
	public CommonDao<TreatmentRadiotherapyInfo> getCommonDao() {
		return treatmentRadiotherapyInfoDao;
	}

	@Override
	public List<TreatmentRadiotherapyInfo> queryRadiotherapyInfo(CommonReq req) {
		return super.queryList(req);
	}

	@Override
	public int saveRadiotherapyInfo(TreatmentRadiotherapyInfo radiotherapyInfo) {
		int res = 0;
		if(radiotherapyInfo.getTreatmentRadiotherapyRecordId() == null) {
			radiotherapyInfo.setTreatmentRadiotherapyRecordId(GeneralUtil.generatorUUID("RADI"));
			res += super.save(radiotherapyInfo);
		}else {
			res += super.update(radiotherapyInfo);
		}
		res += treatmentRadiotherapyDetailInfoService.saveRadiotherapyDetailInfo(radiotherapyInfo);
		return res;
	}

	@Override
	public void deleteRadiotherapyInfo(Map<String,Object> paramsMap) {
		treatmentRadiotherapyDetailInfoService.deleteRadiotherapyDetailInfo(paramsMap);
		treatmentRadiotherapyInfoDao.deleteRadiotherapyInfo(paramsMap);
	}

}

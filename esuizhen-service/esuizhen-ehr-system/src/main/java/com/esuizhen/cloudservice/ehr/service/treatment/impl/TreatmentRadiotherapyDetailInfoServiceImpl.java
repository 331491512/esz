package com.esuizhen.cloudservice.ehr.service.treatment.impl;

import java.util.Iterator;  
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.treatment.TreatmentRadiotherapyDetailInfoDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyDetailInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentRadiotherapyDetailInfoService;
import com.westangel.common.util.GeneralUtil;

@Service
public class TreatmentRadiotherapyDetailInfoServiceImpl extends CommonServiceImpl<TreatmentRadiotherapyDetailInfo> implements
		TreatmentRadiotherapyDetailInfoService {
	@Autowired
	private TreatmentRadiotherapyDetailInfoDao treatmentRadiotherapyDetailInfoDao;
	
	@Override
	public CommonDao<TreatmentRadiotherapyDetailInfo> getCommonDao() {
		return treatmentRadiotherapyDetailInfoDao;
	}

	@Override
	public int saveRadiotherapyDetailInfo(TreatmentRadiotherapyInfo radiotherapyInfo) {
		int res = 0;
		List<TreatmentRadiotherapyDetailInfo> radiotherapyDetailInfos = radiotherapyInfo.getRadiotherapyDetailInfos();
		if(radiotherapyDetailInfos != null && radiotherapyDetailInfos.size() > 0) {
			Iterator<TreatmentRadiotherapyDetailInfo> itor = radiotherapyDetailInfos.iterator();
			while(itor.hasNext()) {
				TreatmentRadiotherapyDetailInfo radiotherapyDetailInfo = itor.next();
				radiotherapyDetailInfo.setTreatmentId(radiotherapyInfo.getTreatmentId());
				radiotherapyDetailInfo.setTreatmentRadiotherapyRecordId(radiotherapyInfo.getTreatmentRadiotherapyRecordId());
				radiotherapyDetailInfo.setPatientId(radiotherapyInfo.getPatientId());
				radiotherapyDetailInfo.setInhospitalId(radiotherapyInfo.getInhospitalId());
				radiotherapyDetailInfo.setClinicMedicalId(radiotherapyInfo.getClinicMedicalId());
				if(radiotherapyDetailInfo.getTreatmentRadiotherapyDetailId() == null) {
					radiotherapyDetailInfo.setTreatmentRadiotherapyDetailId(GeneralUtil.generatorUUID("RADD"));
					res += super.save(radiotherapyDetailInfo);
				}else {
					res += super.update(radiotherapyDetailInfo);
				}
			}
		}
		return res;
	}

	@Override
	public void deleteRadiotherapyDetailInfo(Map<String,Object> paramsMap) {
		treatmentRadiotherapyDetailInfoDao.deleteRadiotherapyDetailInfo(paramsMap);
	}
	
}

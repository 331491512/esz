package com.esuizhen.cloudservice.ehr.service.qualitylife.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.QualityoflifeInfoDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;
import com.esuizhen.cloudservice.ehr.service.qualitylife.QualityLifeService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.util.GeneralUtil;

@Service
public class QualityLifeServiceImpl implements QualityLifeService{
	
	@Autowired
	private QualityoflifeInfoDao qualityoflifeInfoDao;

	@Override
	public void saveQualityoflifeInfo(QualityoflifeInfo qualityoflifeInfo) {
		if(UtilValidate.isNotEmpty(qualityoflifeInfo.getIsDelete()) && 1==qualityoflifeInfo.getIsDelete()){
			this.qualityoflifeInfoDao.deleteQualityoflifeInfo(qualityoflifeInfo.getQolId());
		}else if(UtilValidate.isNotEmpty(qualityoflifeInfo.getQolId())){
			this.qualityoflifeInfoDao.updateQualityoflifeInfo(qualityoflifeInfo);
		}else{
			if(UtilValidate.isEmpty(qualityoflifeInfo.getEmrId())){
				qualityoflifeInfo.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
			}
			qualityoflifeInfo.setQolId(GeneralUtil.generateUniqueID("EQOL"));
			this.qualityoflifeInfoDao.insertQualityoflifeInfo(qualityoflifeInfo);
		}

	}

	@Override
	public QualityoflifeInfo queryQualityoflifeInfo(AttendPatientReq req) {
		QualityoflifeInfo result=this.qualityoflifeInfoDao.queryQualityoflifeInfo(req);
		return result;
	}
}

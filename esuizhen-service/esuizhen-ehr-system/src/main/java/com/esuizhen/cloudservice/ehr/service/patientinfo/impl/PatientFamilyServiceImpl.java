package com.esuizhen.cloudservice.ehr.service.patientinfo.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.patientinfo.PatientFamilyDao;
import com.esuizhen.cloudservice.ehr.service.patientinfo.PatientFamilyService;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.util.GeneralUtil;

/** 
 *@className PatientFamilyServiceImpl
 *@Description:
 *@author yuanwenming
 *@date 2017年5月26日
 */
@Service
@Transactional
public class PatientFamilyServiceImpl implements PatientFamilyService {
	@Autowired
	private PatientFamilyDao patientFamilyDao;
	
	@Override
	public boolean addOrModifyPatientFamily(Map<String,Object> paramsMap) {
		Long patientId = (Long)paramsMap.get("patientId");
		String familyName = (String)paramsMap.get("familyName");
		String oldFamilyName = (String)paramsMap.get("oldFamilyName");
		String familyTel = (String)paramsMap.get("familyTel");
		String oldFamilyTel = (String)paramsMap.get("oldFamilyTel");
		Integer patientRelation = (Integer)paramsMap.get("patientRelation");
		if (StringUtils.isEmpty(familyTel)) {
			return true;
		}
		
		List<PatientFamily> patientFamiliesNew = this.patientFamilyDao.find(patientId, familyTel,familyName);
		if(patientFamiliesNew != null && patientFamiliesNew.size() > 0) {
			return true;
		}
		List<PatientFamily> patientFamilies = this.patientFamilyDao.find(patientId, oldFamilyTel,oldFamilyName);
		Date nowTime = new Date();
		PatientFamily patientFamily = new PatientFamily();
		if (patientFamilies == null || patientFamilies.isEmpty()) {
			patientFamily.setContactId(GeneralUtil.generateUniqueID("CONT"));
			patientFamily.setPatientId(patientId);
			patientFamily.setFamilyName(familyName);
			patientFamily.setFamilyPhone(familyTel);
			patientFamily.setPatientRelation(patientRelation==null?9:patientRelation);
			patientFamily.setCreateTime(nowTime);
			this.patientFamilyDao.insert(patientFamily);
		}else{
			patientFamily.setId(patientFamilies.get(0).getId());
			patientFamily.setPatientId(patientId);
			patientFamily.setFamilyName(familyName);
			patientFamily.setFamilyPhone(familyTel);
			patientFamily.setPatientRelation(patientRelation);
			patientFamily.setUpdateTime(nowTime);
			this.patientFamilyDao.update(patientFamily);
		}
		return true;
	}
	
}

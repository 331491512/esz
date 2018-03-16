package com.esuizhen.cloudservice.ehr.service.symptom.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.esuizhen.cloudservice.ehr.dao.patient.PatientSymptomDao;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.esuizhen.cloudservice.ehr.service.symptom.SymptomService;
import com.westangel.common.bean.UserDefinedMetaData;
import com.westangel.common.util.GeneralUtil;

@Service
public class SymptomServiceImpl implements SymptomService {
	
	@Autowired
	private MetaDataService metaDataService;
	
	@Autowired
	private PatientSymptomDao patientSymptomDao;
	
	@Override
	public List<PatientSymptomInfo> patientSymptomList(Map<String,Object> paramsMap) {
		return patientSymptomDao.patientSymptomList(paramsMap);
	}
	
	@Transactional
	@Override
	public int savePatientSymptom(List<PatientSymptomInfo> patientSymptom) {
		int res = 0;
		if(patientSymptom != null && patientSymptom.size() > 0) {
			if(patientSymptom.get(0).getPatientId() != null) {
				for(PatientSymptomInfo symptom: patientSymptom){
					if(StringUtils.isEmpty(symptom.getSymptomId())) {
						symptom.setSymptomId(GeneralUtil.generateUniqueID("SYMP"));
					}
					//更新检验类型元数据信息
					//String mainKey=symptom.getSymptomTypeId()!=null?symptom.getSymptomTypeId().toString():null;
					if(StringUtils.isNotBlank(symptom.getSymptomName())){
						UserDefinedMetaData metaData=new UserDefinedMetaData();
						metaData.setMainKey(null);
						metaData.setMetaName(symptom.getSymptomName());
						metaData.setCreator(symptom.getOperatorId());
						
						metaData.setMetaDataTable("ehr_db.meta_e_clinic_symptom");
						metaData.setMainKeyField("symptomId");
						metaData.setMetaNameField("symptomName");
						Integer finalKey=this.metaDataService.addMetaDate(metaData);
						symptom.setSymptomTypeId(finalKey);
					}
					//更新业务表信息
					res += patientSymptomDao.insertPatientSymptom(symptom);
				}
			}
		}
		return res;
	}
	
	@Override
	public int deletePatientSymptom(Map<String, Object> paramsMap) {
		return patientSymptomDao.deletePatientSymptom(paramsMap);
	}
}

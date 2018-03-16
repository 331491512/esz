package com.esuizhen.cloudservice.ehr.service.inhospital.impl;

import java.util.Map; 

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.common.OperationHistoryDao;
import com.esuizhen.cloudservice.ehr.dao.hospitalinfo.HospitalPatientDao;
import com.esuizhen.cloudservice.ehr.dao.inhospital.PatientClinicInfoDao;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.inhospital.PatientClinicInfoService;
import com.esuizhen.cloudservice.ehr.service.patientinfo.PatientFamilyService;
import com.esuizhen.cloudservice.ehr.service.patientinfo.TPatientInfoService;
import com.westangel.common.util.BeanUtils;
import com.westangel.common.util.GeneralUtil;
@Transactional
@Service("patientClinicInfoService")
public class PatientClinicInfoServiceImpl extends CommonServiceImpl<PatientClinicInfo> implements PatientClinicInfoService{
	@Autowired
	private PatientClinicInfoDao patientClinicInfoDao;
	@Autowired
	private PatientFamilyService patientFamilyService;
	
	@Autowired
	private OperationHistoryDao operationHistoryDao;
	
	@Autowired
	private HospitalPatientDao hospitalPatientDao;
	
	@Autowired
	private TPatientInfoService patientInfoService;

	@Override
	public CommonDao<PatientClinicInfo> getCommonDao() {
		return patientClinicInfoDao;
	}
	
	@Override
	public PatientClinicInfo insertPatientClinicInfo(PatientClinicInfo patientClinicInfo) {
		PatientClinicInfo pc = null;
		Map<String,Object> paramsMap = BeanUtils.toMap(patientClinicInfo);
		paramsMap.put("trueName", patientClinicInfo.getPatientName());
		paramsMap.put("birthDate", patientClinicInfo.getPatientBirth());
		paramsMap.put("identification", patientClinicInfo.getPatientIdno());
		paramsMap.put("mobile", patientClinicInfo.getPatientMobile());
		paramsMap.put("sex", patientClinicInfo.getPatientSex());
		if(patientClinicInfo.getPatientId() == null) {
			paramsMap.put("outPatientFlag", 1);
			patientInfoService.insert(paramsMap);
			patientClinicInfo.setPatientId((Long)paramsMap.get("patientId"));
		}
		
		if(StringUtils.isNotEmpty(patientClinicInfo.getClinicMedicalId())) {
			PatientClinicInfo clinicInfo = this.queryOne(patientClinicInfo.getClinicMedicalId());
			if(clinicInfo != null) {
				paramsMap.put("oldFamilyTel", clinicInfo.getFamilyTel());
				paramsMap.put("oldFamilyName", clinicInfo.getFamilyName());
			}
			StringBuffer tumourPeriodization = new StringBuffer();
			tumourPeriodization.append(patientClinicInfo.getTumourPeriodizationT()==null?"":patientClinicInfo.getTumourPeriodizationT());
			tumourPeriodization.append(patientClinicInfo.getTumourPeriodizationN()==null?"":patientClinicInfo.getTumourPeriodizationN());
			tumourPeriodization.append(patientClinicInfo.getTumourPeriodizationM1()==null?"":patientClinicInfo.getTumourPeriodizationM1());
			tumourPeriodization.append(" ");
			tumourPeriodization.append(patientClinicInfo.getTumourPeriodizationClinic()==null?"":patientClinicInfo.getTumourPeriodizationClinic());
			patientClinicInfo.setTumourPeriodization(tumourPeriodization.toString());
			this.update(patientClinicInfo);
			paramsMap.put("catalogState", 2);
		}else {
			patientClinicInfo.setClinicMedicalId(GeneralUtil.generateUniqueID("ECLI"));
			patientClinicInfo.setClinicNo(GeneralUtil.generateUniqueID("ECCN"));
			save(patientClinicInfo);
			pc = patientClinicInfo;
		}
		patientInfoService.update(paramsMap);
		//add by yuanwenming  添加联系人信息
		patientFamilyService.addOrModifyPatientFamily(paramsMap);
		return pc;
	}
}

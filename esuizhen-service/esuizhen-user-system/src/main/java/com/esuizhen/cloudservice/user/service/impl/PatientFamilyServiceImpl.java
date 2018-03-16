package com.esuizhen.cloudservice.user.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.user.dao.PatientFamilyDao;
import com.esuizhen.cloudservice.user.service.PatientFamilyService;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.util.GeneralUtil;

@Service
public class PatientFamilyServiceImpl implements PatientFamilyService {
	@Autowired
	private PatientFamilyDao patientFamilyDao;


	/**
	 * 添加或修改患者联系人
	 * @param patient
	 * @return
	 */
	public boolean addOrModifyPatientFamily(Patient patient) {
		if (patient.getPatientRelation() == null ||
				StringUtils.isEmpty(patient.getTrueName()) ||
				StringUtils.isEmpty(patient.getMobile())) {
			return true;
		}
		List<PatientFamily> patientFamilies = this.patientFamilyDao.find(patient.getPatientId(), patient.getMobile());
		Date nowTime = new Date();
		PatientFamily patientFamily = new PatientFamily();
		if (patientFamilies == null || patientFamilies.isEmpty()) {
			patientFamily = new PatientFamily();
			patientFamily.setContactId(GeneralUtil.generateUniqueID("CONT"));
			patientFamily.setPatientId(patient.getPatientId());
			patientFamily.setFamilyName(patient.getTrueName());
			patientFamily.setFamilyPhone(patient.getMobile());
			patientFamily.setPatientRelation(patient.getPatientRelation());
			patientFamily.setCreateTime(nowTime);
			this.patientFamilyDao.insert(patientFamily);
		}else{
			patientFamily.setFamilyName(patient.getTrueName());
			patientFamily.setFamilyPhone(patient.getMobile());
			patientFamily.setPatientRelation(patient.getPatientRelation());
			patientFamily.setUpdateTime(nowTime);
			this.patientFamilyDao.update(patientFamily);
		}
		return true;
	}

	@Transactional
	@Override
	public boolean mergePatientFamily(Long cloudPatientId, Long tobPatientId) {
		//云端存在的患者家属
		List<PatientFamily> cloudPatientFamilies = this.patientFamilyDao.find(cloudPatientId, null);
		if (cloudPatientFamilies == null || cloudPatientFamilies.isEmpty()) {
			this.patientFamilyDao.updateToBPatientFamilyToCloudRelation(cloudPatientId, tobPatientId);
			return true;
		}
		//B端存在的患者家属
		List<PatientFamily> tobPatientFamilies = this.patientFamilyDao.find(tobPatientId, null);
		if (tobPatientFamilies == null || tobPatientFamilies.isEmpty()) {
			return true;
		}
		for (int i = 0, size = tobPatientFamilies.size(); i < size; i++) {
			PatientFamily patientFamily = tobPatientFamilies.get(i);
			//B端患者家属手机号为空不用处理，后面会删除
			if (StringUtils.isBlank(patientFamily.getFamilyPhone())) {
				continue;
			}
			boolean flag = true;
			for (PatientFamily cloudPatientFamily : cloudPatientFamilies) {
				//云端存在该手机号的患者
				if (cloudPatientFamily.getFamilyPhone() != null &&
						cloudPatientFamily.getFamilyPhone().equals(patientFamily.getFamilyPhone())) {
					if(patientFamily.getSourceFlag()!=null){
						cloudPatientFamily.setSourceFlag(patientFamily.getSourceFlag());
						this.patientFamilyDao.update(cloudPatientFamily);
					}
					flag = false;
					break;
				}
			}
			if (flag) {
				patientFamily.setPatientId(cloudPatientId);
				this.patientFamilyDao.update(patientFamily);
			}
		}
		this.patientFamilyDao.deleteByPatientId(tobPatientId);
		return true;
	}

	@Override
	public int update(PatientFamily patientFamily) {
		int result = 0;

		// 修改患者家庭信息
		result += patientFamilyDao.update(patientFamily);

		// 当修改患者家庭电话状态的时候
		if (null != patientFamily.getId()) {
			
			// 获取患者id和家庭电话
			PatientFamily pf = patientFamilyDao
					.findPatientInfoById(patientFamily);

			// 根据患者id和家庭电话修改电话状态
			result += patientFamilyDao.updatePatientFamilyPhoneStatus(pf);
		}

		return result;
	}
}

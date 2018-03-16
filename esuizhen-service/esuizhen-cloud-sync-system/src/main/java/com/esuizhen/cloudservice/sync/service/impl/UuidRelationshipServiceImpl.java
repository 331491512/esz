package com.esuizhen.cloudservice.sync.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.dao.cloud.CloudDepartmentDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchUuidRelationshipDao;
import com.esuizhen.cloudservice.sync.model.Department;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 
 * @author YYCHEN
 *
 */
@Service(value="uuidRelationshipService")
public class UuidRelationshipServiceImpl implements UuidRelationshipService, com.westangel.common.service.UuidRelationshipService {
	@Autowired
	private MatchUuidRelationshipDao matchUuidRelationshipDao;
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	
	@Autowired
	private CloudPatientDao cloudPatientDao;
	
	@Autowired
	private CloudDepartmentDao cloudDepartmentDao;
	
	
	/**
	 * 
	 */
	@Transactional
	@Override
	public boolean save(UuidRelationship uuidRelationship){
		if(this.matchUuidRelationshipDao.find(uuidRelationship.getUuidFinal(), uuidRelationship.getUuid()) < 1){
			return this.matchUuidRelationshipDao.insert(uuidRelationship) > 0;
		}
		return false;
	}

	@Override
	public UuidRelationship getByUuid(String uuid) {
		return this.matchUuidRelationshipDao.findByUuid(uuid);
	}
	
	@Override
	public String getFinalUuidByUuid(String uuid){
		if (StringUtils.isEmpty(uuid)) {
			return uuid;
		}
		String finalUuid = this.matchUuidRelationshipDao.findUuidFinalByUuid(uuid);
		if (StringUtils.isEmpty(finalUuid)) {
			return uuid;
		}
		return finalUuid;
	}

	@Override
	public String getUserId(Long userId) {
		return this.matchUuidRelationshipDao.findUuidFinalByUserId(userId);
	}

	@Override
	public List<UuidRelationship> getByFinalUuid(String finalUuid) {
		return this.matchUuidRelationshipDao.findByFinalUuid(finalUuid);
	}

	@Override
	public Long getDoctorId(String doctorUuId) {
		if(StringUtils.isEmpty(doctorUuId))
			return null;
		String finalUuid = getFinalUuidByUuid(doctorUuId);
		if (StringUtils.isNotEmpty(finalUuid)) {
			Doctor doctor = this.cloudDoctorDao.findByUuid(finalUuid);
			if (doctor != null) {
				return doctor.getDoctorId();
			}
		}
		return null;
	}

	@Override
	public Long getPatientId(String patientUuId) {
		// 确定患者uuid值
		String patientFinalUuid = getFinalUuidByUuid(patientUuId);
		if (StringUtils.isNotEmpty(patientFinalUuid)) {
			Patient patient = this.cloudPatientDao.findByUuid(patientFinalUuid);
			if (patient != null)
				return patient.getPatientId();
		}
		return null;
	}

	@Override
	public Integer getDeptId(String deptUuid) {
		Department dept = this.cloudDepartmentDao.findByUuid(deptUuid);
		if (dept != null) {
			return dept.getDeptId();
		}
		return null;
	}
}

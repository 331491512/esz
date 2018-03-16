package com.esuizhen.cloudservice.sync.txservice.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxRelationshipService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Patient;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Service
public class TxRelationshipServiceImpl implements TxRelationshipService {
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudDoctorPatientDao cloudDoctorPatientDao;
	
	@Autowired
	private MatchDoctorDao matchDoctorDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private MatchDoctorPatientDao matchDoctorPatientDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;

	@Transactional
	@Override
	public boolean syncDoctorPatientRelationship(DoctorPatient doctorPatient) {
		if (doctorPatient.getHospitalId()==null) {
			throw new EmptyParamExcption("\"hospitalId\" is empty!");
		}
		if (StringUtils.isEmpty(doctorPatient.getDoctorUuid())) {
			throw new EmptyParamExcption("\"doctorUuid\" is empty!");
		}
		if (StringUtils.isEmpty(doctorPatient.getPatientUuid())) {
			throw new EmptyParamExcption("\"patientUuid\" is empty!");
		}
		if (doctorPatient.getSourceFlag() == null) {
			throw new EmptyParamExcption("\"sourceFlag\" is empty!");
		}
		//查找云端对应的医生uuid值
		String doctorFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(doctorPatient.getDoctorUuid());
		if (StringUtils.isEmpty(doctorFinalUuid)) {
			doctorFinalUuid = doctorPatient.getDoctorUuid();
		}
		//查找云端对应的患者uuid值
		String patientFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(doctorPatient.getPatientUuid());
		if (StringUtils.isEmpty(patientFinalUuid)) {
			patientFinalUuid = doctorPatient.getPatientUuid();
		}
		Doctor doctor = this.cloudDoctorDao.findByUuid(doctorFinalUuid);
		Patient patient = this.cloudPatientDao.findByUuid(patientFinalUuid);
		if(patient==null){
			Patient matchPatient = matchPatientDao.findByUuid(patientFinalUuid);
			if(matchPatient==null)
			throw new EmptyObjectExcption("sync doctorAndPatient error doctor and patient not in cloud");
		}
		if (doctor == null || patient == null) {
			//保存到匹配中间库
			this.saveDoctorPatientToMatch(doctorPatient);
		}else{
			//保存到云端数据库
			this.saveDoctorPatientToCloud(doctorPatient, patient, doctor);
		}
		return true;
	}

	/**
	 * 
	 * @param hospitalUuid
	 * @param doctorUuid
	 * @param patientUuid
	 * @param source
	 * @return
	 */
	private boolean saveDoctorPatientToMatch(DoctorPatient inDoctorPatient){
		LogUtil.log.debug("保存医患关系到中间库（saveDoctorPatientToMatch()）---------->>>");
		//判断是否有该医患关系
		DoctorPatient doctorPatient = this.matchDoctorPatientDao.findByDoctorUuidAndPatientUuid(inDoctorPatient.getDoctorUuid(), inDoctorPatient.getPatientUuid());
		//删除重新创建 以最新的为主
		if (doctorPatient != null) {
			matchDoctorPatientDao.delete(doctorPatient.getId());
		}
		doctorPatient = inDoctorPatient.createMatchDoctorPatient();
		this.matchDoctorPatientDao.insert(doctorPatient);
		LogUtil.log.debug("保存医患关系到中间库完成（saveDoctorPatientToMatch()）---------->>>");
		return true;
	}

	/**
	 * 
	 * @param hospital
	 * @param doctor
	 * @param patient
	 * @param source
	 * @return
	 */
	private boolean saveDoctorPatientToCloud(DoctorPatient inDoctorPatient, Patient patient, Doctor doctor) {
		LogUtil.log.debug("保存医患关系到云端库（saveDoctorPatientToCloud()）---------->>>");
		//查询是否有该医患关系
		DoctorPatient doctorPatient = this.cloudDoctorPatientDao.findDoctorPatient(patient.getPatientId(), doctor.getDoctorId());
		if (doctorPatient != null) {
			return true;
		}
		//如果没有就创建医患关系
		doctorPatient = inDoctorPatient.createDoctorPatient();
		doctorPatient.setDoctorId(doctor.getDoctorId());
		doctorPatient.setPatientId(patient.getPatientId());
		this.cloudDoctorPatientDao.insert(doctorPatient);
		LogUtil.log.debug("保存医患关系到云端库完成（saveDoctorPatientToCloud()）---------->>>");
		return true;
	}
}

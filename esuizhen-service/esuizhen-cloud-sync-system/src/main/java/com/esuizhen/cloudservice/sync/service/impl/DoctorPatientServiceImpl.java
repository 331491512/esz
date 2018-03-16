package com.esuizhen.cloudservice.sync.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorPatientDao;
import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.DoctorPatientService;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxRelationshipService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Patient;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;

@Service
public class DoctorPatientServiceImpl implements DoctorPatientService {
	@Autowired
	private IncreDoctorPatientDao increDoctorPatientDao;
	
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudDoctorPatientDao cloudDoctorPatientDao;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	@Autowired
	private MatchDoctorPatientDao matchDoctorPatientDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private TxRelationshipService txRelationshipService;

	/**
	 * @throws HospitalWithoutRightExcption 
	 * 
	 */
	@Transactional
	@Override
	public boolean syncPatientOfDoctorRelation(DoctorPatient doctorPatient) throws EmptyParamExcption, HospitalWithoutRightExcption {
		if(doctorPatient==null||doctorPatient.getHospitalId()==null||!checkBeforeSyncService.checkHospitalId((int)(long)doctorPatient.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		//将数据保存到增量数据库
		this.saveDoctorPatientToIncre(doctorPatient);
		return this.txRelationshipService.syncDoctorPatientRelationship(doctorPatient);
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
		Date nowTime = new Date();
		doctorPatient = new DoctorPatient();
		doctorPatient.setDoctorId(doctor.getDoctorId());
		doctorPatient.setPatientId(patient.getPatientId());
		doctorPatient.setSourceFlag(inDoctorPatient.getSourceFlag());
		//处理sourceFlag
		if (doctorPatient.getSourceFlag() == null) {
			doctorPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		doctorPatient.setVipFlag(inDoctorPatient.getVipFlag());
		doctorPatient.setHasMedicalRecord(inDoctorPatient.getHasMedicalRecord());
		doctorPatient.setAttentionTime(nowTime);
		doctorPatient.setCreateTime(nowTime);
		this.cloudDoctorPatientDao.insert(doctorPatient);
		LogUtil.log.debug("保存医患关系到云端库完成（saveDoctorPatientToCloud()）---------->>>");
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
	private boolean saveDoctorPatientToIncre(DoctorPatient inDoctorPatient){
		LogUtil.log.debug("保存医患关系到增量库（saveDoctorPatientToMatch()）---------->>>");
		/*
		DoctorPatient doctorPatient = new DoctorPatient();
		doctorPatient.setDoctorUuid(inDoctorPatient.getDoctorUuid());
		doctorPatient.setPatientUuid(inDoctorPatient.getPatientUuid());
		doctorPatient.setSourceFlag(inDoctorPatient.getSourceFlag());
		*/
		if(inDoctorPatient.getSourceFlag()==null)
			inDoctorPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		if(inDoctorPatient.getCreateTime()==null)
			inDoctorPatient.setCreateTime(new Date());
		if(inDoctorPatient.getAttentionTime()==null)
			inDoctorPatient.setAttentionTime(inDoctorPatient.getCreateTime());
		inDoctorPatient.setSyncTime(new Date());
		this.increDoctorPatientDao.insert(inDoctorPatient);
		LogUtil.log.debug("保存医患关系到增量库完成（saveDoctorPatientToMatch()）----------<<<");
		return true;
	}

	@Transactional
	@Override
	public boolean mergeDoctorPatient(String doctorUuid, String patientUuid) throws EmptyParamExcption{
		if (StringUtils.isEmpty(doctorUuid)) {
			throw new EmptyParamExcption("\"doctorUuid\" is empty!");
		}
		if (StringUtils.isEmpty(patientUuid)) {
			throw new EmptyParamExcption("\"patientUuid\" is empty!");
		}
		//查找医生对应的uuid值
		String doctorFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(doctorUuid);
		if (StringUtils.isEmpty(doctorFinalUuid)) {
			doctorFinalUuid = doctorUuid;
		}
		//查找患者对应的uuid值
		String patientFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(patientUuid);
		if (StringUtils.isEmpty(patientFinalUuid)) {
			patientFinalUuid = patientUuid;
		}
		Doctor doctor = this.cloudDoctorDao.findByUuid(doctorFinalUuid);
		Patient patient = this.cloudPatientDao.findByUuid(patientFinalUuid);
		if (doctor != null && patient != null) {
			//获取中间库的医患关系
			DoctorPatient interimDoctorPatient = this.matchDoctorPatientDao.findByDoctorUuidAndPatientUuid(doctorUuid, patientUuid);
			long id = interimDoctorPatient.getId();
			//保存到云端数据库
			this.saveDoctorPatientToCloud(interimDoctorPatient, patient, doctor);
			//删除中间库的医患关系
			this.matchDoctorPatientDao.delete(id);
		}
		return true;
	}
	
}

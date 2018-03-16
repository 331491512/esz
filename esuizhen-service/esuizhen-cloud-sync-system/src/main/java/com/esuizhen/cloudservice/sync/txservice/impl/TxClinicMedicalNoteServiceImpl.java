package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudClinicMedicalNoteDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDepartmentDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchClinicMedicalNoteDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.model.Department;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxClinicMedicalNoteService;
import com.esuizhen.cloudservice.sync.txservice.check.ClinicMedicalNoteCheck;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

@Service
public class TxClinicMedicalNoteServiceImpl implements TxClinicMedicalNoteService {
	@Autowired
	private MatchMedicalRecordDao matchMedicalRecordDao;
	@Autowired
	private MatchClinicMedicalNoteDao matchClinicMedicalDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	
	@Autowired
	private CloudMedicalRecordDao cloudMedicalRecordDao;
	@Autowired
	private CloudClinicMedicalNoteDao cloudClinicMedicalDao;
	
	@Autowired
	private ClinicMedicalNoteCheck clinicMedicalNoteCheck;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	
	@Autowired
	private CloudDepartmentDao cloudDepartmentDao;

	@Transactional
	@Override
	public MedicalRecord syncClinicMedicalInfo(TClinicMedicalNoteInfo clinicMedicalInfo) throws RejectRequestExcption{
		clinicMedicalInfo.setPatientId(null);
		Department deptment = cloudDepartmentDao.findByUuid(clinicMedicalInfo.getDeptUuid());
		if(deptment!=null)clinicMedicalInfo.setDeptId(deptment.getDeptId());
		if(!clinicMedicalNoteCheck.checkClinicMedicalNoteInMatch(clinicMedicalInfo)){
			//保存到正式库
			this.saveCloudClinicMedicalInfo(clinicMedicalInfo);
		}else{
			if(clinicMedicalInfo.getPatientId()==null){
				Patient patient = matchPatientDao.findByUuid(clinicMedicalInfo.getPatientUuid());
				if(patient==null)
					throw new RejectRequestExcption("sync error :patient not in clound");
			}
			//保存到匹配库
			this.saveMatchClinicMedicalInfo(clinicMedicalInfo);
		}
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(clinicMedicalInfo.getEmrId());
		return medicalRecord;
	}

	//保存到生产库
	private void saveCloudClinicMedicalInfo(TClinicMedicalNoteInfo clinicMedicalInfo) {
		MedicalRecord medicalRecord = clinicMedicalInfo.createMedicalRecord();
		this.cloudMedicalRecordDao.insert(medicalRecord);
		
		//clinicMedicalInfo.setEmrId(medicalRecord.getEmrId());
		clinicMedicalInfo.setSyncFlag(Constant.SYNC_OK);
		this.cloudClinicMedicalDao.insert(clinicMedicalInfo);
	}

	//保存到匹配中间库
	private void saveMatchClinicMedicalInfo(TClinicMedicalNoteInfo clinicMedicalInfo) {
		this.matchClinicMedicalDao.insert(clinicMedicalInfo);
	}

	@Override
	public boolean mergeClinicMedicalNote(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start merge clinic medical note data---------->>");
		//将患者住院信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchMedicalRecordDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
			this.matchClinicMedicalDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<TClinicMedicalNoteInfo> clinicMedicalNoteInfoes = this.matchClinicMedicalDao.findByPatientUuid(patientFinalUuid);
		if (clinicMedicalNoteInfoes == null || clinicMedicalNoteInfoes.isEmpty()) {
			return true;
		}
		for (int i = 0, size = clinicMedicalNoteInfoes.size(); i < size; i++) {
			TClinicMedicalNoteInfo clinicMedicalNoteInfo = clinicMedicalNoteInfoes.get(i);
			clinicMedicalNoteInfo.setPatientId(patientId);
			clinicMedicalNoteInfo.setPatientUuid(patientFinalUuid);
			if(clinicMedicalNoteCheck.checkClinicMedicalNoteInMatch(clinicMedicalNoteInfo))
				continue;
			//生成电子病历数据
			MedicalRecord medicalRecord = clinicMedicalNoteInfo.createMedicalRecord();
			clinicMedicalNoteInfo.setSyncFlag(Constant.SYNC_OK);
			//将数据保存到生产库
			this.cloudMedicalRecordDao.insert(medicalRecord);
			this.cloudClinicMedicalDao.insert(clinicMedicalNoteInfo);
			//将中间库中的门诊数据删除
			this.matchClinicMedicalDao.delete(clinicMedicalNoteInfo.getClinicMedicalId());
			this.matchMedicalRecordDao.delete(medicalRecord.getEmrId());
		}
		LogUtil.log.debug("complete merge clinic medical note data----------<<");
		return true;
	}
}

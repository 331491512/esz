package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudOutHospitalNoteDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchOutHospitalNoteDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxOutHospitalNoteService;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

@Service
public class TxOutHospitalNoteServiceImpl implements TxOutHospitalNoteService {
	@Autowired
	private MatchOutHospitalNoteDao matchOutHospitalNoteDao;
	
	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudMedicalRecordDao cloudMedicalRecordDao;
	@Autowired
	private CloudOutHospitalNoteDao cloudOutHospitalNoteDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	
	@Autowired
	private UuidRelationshipService uuidRelationshipService;

	@Transactional
	@Override
	public MedicalRecord syncOutHospitalNote(TOutHospitalNoteInfo outHospitalNoteInfo) throws RejectRequestExcption {
		//确定患者uuid
		String patientFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(outHospitalNoteInfo.getPatientUuid());
		if (StringUtils.isNotEmpty(patientFinalUuid)) {
			outHospitalNoteInfo.setPatientUuid(patientFinalUuid);
		}
		Patient patient = this.cloudPatientDao.findByUuid(outHospitalNoteInfo.getPatientUuid());
		if (patient != null) {
			//保存到云端数据库
			outHospitalNoteInfo.setPatientId(patient.getPatientId());
			this.saveOutHospitalNoteInfoToCloud(outHospitalNoteInfo);
		} else {
			patient = this.matchPatientDao.findByUuid(outHospitalNoteInfo.getPatientUuid());
			if (patient != null) {//保存到匹配中间库
				this.saveOutHospitalNoteInfoToMatch(outHospitalNoteInfo);
			}else  throw new RejectRequestExcption("patient is null!");
		}
		
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(outHospitalNoteInfo.getEmrId());
		return medicalRecord;
	}
	
	private boolean saveOutHospitalNoteInfoToCloud(TOutHospitalNoteInfo outHospitalNoteInfo){
		//电子病历
		MedicalRecord medicalRecord = outHospitalNoteInfo.createMedicalRecord();
		this.cloudMedicalRecordDao.insert(medicalRecord);
		outHospitalNoteInfo.setSyncFlag(Constant.SYNC_OK);
		this.cloudOutHospitalNoteDao.insert(outHospitalNoteInfo);
		return true;
	}
	
	/**
	 * 
	 * @param surgeryInfo
	 * @return
	 */
	private void saveOutHospitalNoteInfoToMatch(TOutHospitalNoteInfo outHospitalNoteInfo){
		//出院小结信息添加到匹配库
		this.matchOutHospitalNoteDao.insert(outHospitalNoteInfo);
	}
	
	/**
	 * 合并出院小结
	 */
	@Override
	public boolean mergeOuthospitalNote(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with surgical data---------->>");
		// 将患者诊断信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchOutHospitalNoteDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<TOutHospitalNoteInfo> outhospitalNotes = this.matchOutHospitalNoteDao.findByPatientUuid(patientFinalUuid);
		if (outhospitalNotes == null || outhospitalNotes.isEmpty()) {
			return true;
		}
		for (int i = outhospitalNotes.size() - 1; i >= 0; i--) {
			TOutHospitalNoteInfo outhospitalNote = outhospitalNotes.get(i);
			outhospitalNote.setPatientId(patientId);
			outhospitalNote.setPatientUuid(patientFinalUuid);
			MedicalRecord medicalRecord = outhospitalNote.createMedicalRecord();
			outhospitalNote.setSyncFlag(Constant.SYNC_OK);
			// 保存到云端数据库
			this.cloudMedicalRecordDao.insert(medicalRecord);
			this.cloudOutHospitalNoteDao.insert(outhospitalNote);
			// 添加治疗记录
			// this.eciTreatmentNoteService.saveByDiagnosisInfo(surgeryNote);
			// 将匹配中间库的数据删除
			this.matchOutHospitalNoteDao.delete(outhospitalNote.getOuthospitalId());
			this.matchOutHospitalNoteDao.delete(medicalRecord.getEmrId());
		}
		LogUtil.log.debug("Combined surgical data completion----------<<");
		return true;
	}
	

}

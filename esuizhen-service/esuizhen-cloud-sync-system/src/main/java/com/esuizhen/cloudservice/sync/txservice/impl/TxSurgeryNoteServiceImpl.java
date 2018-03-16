package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudSurgeryNoteDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchSurgeryNoteDao;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.model.SurgeryNote;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxSurgeryNoteService;
import com.esuizhen.cloudservice.sync.txservice.check.SurgeryNoteCheck;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.LogUtil;

@Service
public class TxSurgeryNoteServiceImpl implements TxSurgeryNoteService {
	@Autowired
	private MatchMedicalRecordDao matchMedicalRecordDao;
	@Autowired
	private MatchSurgeryNoteDao matchSurgeryNoteDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private CloudMedicalRecordDao cloudMedicalRecordDao;
	@Autowired
	private CloudSurgeryNoteDao cloudSurgeryNoteDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private SurgeryNoteCheck surgeryNoteCheck;

	@Transactional
	@Override
	public MedicalRecord syncSurgery(TPatientSurgeryNoteDetailInfo surgeryInfo){
		surgeryInfo.setPatientId(null);
		if(!surgeryNoteCheck.checkSurgerNoteNoteInMatch(surgeryInfo))
			//保存到正式库
			savePatientSurgeryNoteDetailInfoToCloud(surgeryInfo);
		else{
			if(surgeryInfo.getPatientId()==null){
				Patient patient = matchPatientDao.findByUuid(surgeryInfo.getPatientUuid());
				if(patient==null)
					throw new EmptyObjectExcption("error patient is not in cloud");
			}
			//保存到匹配库
			savePatientSurgeryNoteDetailInfoToMatch(surgeryInfo);
		}
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(surgeryInfo.getEmrId());
		return medicalRecord;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :savePatientSurgeryNoteDetailInfoToCloud
	 * @Description:保存到生产库
	 * @return boolean
	 * @date 2016年12月24日 下午4:32:30
	 */
	private boolean savePatientSurgeryNoteDetailInfoToCloud(TPatientSurgeryNoteDetailInfo surgeryInfo){
		//电子病历
		MedicalRecord medicalRecord = surgeryInfo.createMedicalRecord();
		this.cloudMedicalRecordDao.insert(medicalRecord);
		//手术信息
		SurgeryNote surgeryNote = surgeryInfo.createSurgeryNote();
		this.cloudSurgeryNoteDao.insert(surgeryNote);

		return true;
	}
	
	/**
	 * 
	 * @param surgeryInfo
	 * @return
	 */
	private boolean savePatientSurgeryNoteDetailInfoToMatch(TPatientSurgeryNoteDetailInfo surgeryInfo){
		//手术信息
		SurgeryNote surgeryNote = surgeryInfo.createSurgeryNote();
		this.matchSurgeryNoteDao.insert(surgeryNote);
		return true;
	}


	@Override
	public boolean mergeSurgeryNote(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with surgical data---------->>");
		//将患者诊断信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchSurgeryNoteDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<TPatientSurgeryNoteDetailInfo> surgeryNotes = this.matchSurgeryNoteDao.findByPatientUuid(patientFinalUuid);
		if (surgeryNotes == null || surgeryNotes.isEmpty()) {
			return true;
		}
		for (int i = surgeryNotes.size() - 1; i >= 0; i--) {
			TPatientSurgeryNoteDetailInfo surgeryNoteInfo = surgeryNotes.get(i);
			surgeryNoteInfo.setPatientId(patientId);
			surgeryNoteInfo.setPatientUuid(patientFinalUuid);
			if(surgeryNoteCheck.checkSurgerNoteNoteInMatch(surgeryNoteInfo))
				continue;
			SurgeryNote surgeryNote = surgeryNoteInfo.createSurgeryNote();
			MedicalRecord medicalRecord = surgeryNoteInfo.createMedicalRecord();
			//保存到云端数据库
			this.cloudMedicalRecordDao.insert(medicalRecord);
			this.cloudSurgeryNoteDao.insert(surgeryNote);
			//将匹配中间库的数据删除
			this.matchSurgeryNoteDao.delete(surgeryNote.getSurgeryId());
			this.matchMedicalRecordDao.delete(medicalRecord.getEmrId());
		}
		LogUtil.log.debug("Combined surgical data completion----------<<");
		return true;
	}

}

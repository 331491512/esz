package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.dao.cloud.CloudEciTreatmentNoteDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchEciTreatmentNoteDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxTreatmentNoteService;
import com.esuizhen.cloudservice.sync.txservice.check.TreatmentCheck;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

@Service
public class TxTreatmentNoteServiceImpl implements TxTreatmentNoteService {
	@Autowired
	private MatchEciTreatmentNoteDao matchEciTreatmentNoteDao;
	@Autowired
	private MatchMedicalRecordDao matchMedicalRecordDao;
	@Autowired
	private CloudMedicalRecordDao cloudMedicalRecordDao;
	@Autowired
	private CloudEciTreatmentNoteDao cloudEciTreatmentNoteDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private MatchPatientDao matchPatientDao;
	
	@Autowired
	private TreatmentCheck treatmentCheck;

	@Transactional
	@Override
	public MedicalRecord syncTreatmentNote(EciTreatmentNote treatmentNoteInfo) throws RejectRequestExcption {
		treatmentNoteInfo.setPatientId(null);
		if(treatmentCheck.checkTreatmentNoteInMatch(treatmentNoteInfo)){
			if(treatmentNoteInfo.getPatientId()==null){
				Patient patient = matchPatientDao.findByUuid(treatmentNoteInfo.getPatientUuid());
				if(patient==null)
					throw new RejectRequestExcption("patient not in cloud");
			}
			//保存到匹配库
			this.saveTreatmentNoteInfoToMatch(treatmentNoteInfo);
		}else{
			//保存到云端数据库
			this.saveTreatmentNoteInfoToCloud(treatmentNoteInfo);
		}
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(treatmentNoteInfo.getEmrId());
		return medicalRecord;
	}
	
	private boolean saveTreatmentNoteInfoToCloud(EciTreatmentNote treatmentNoteInfo){
		//生成电子病历
		MedicalRecord medicalRecord = treatmentNoteInfo.createMedicalRecord();
		this.cloudMedicalRecordDao.insert(medicalRecord);
		treatmentNoteInfo.setSyncFlag(Constant.SYNC_OK);
		this.cloudEciTreatmentNoteDao.insert(treatmentNoteInfo);
		return true;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :saveTreatmentNoteInfoToMatch
	 * @Description:出院治疗信息添加到匹配库
	 * @return void
	 * @date 2016年12月24日 下午5:49:13
	 */
	private void saveTreatmentNoteInfoToMatch(EciTreatmentNote treatmentNoteInfo){
		this.matchEciTreatmentNoteDao.insert(treatmentNoteInfo);
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :mergeTreatmentNote
	 * @Description:治疗记录合并
	 * @return boolean
	 * @date 2016年12月24日 下午5:51:31
	 */
	@Override
	public boolean mergeTreatmentNote(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with surgical data---------->>");
		//将患者诊断信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchEciTreatmentNoteDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<EciTreatmentNote> treatmentNotes = this.matchEciTreatmentNoteDao.findByPatientUuid(patientFinalUuid);
		if (treatmentNotes == null || treatmentNotes.isEmpty()) {
			return true;
		}
		for (int i = treatmentNotes.size() - 1; i >= 0; i--) {
			EciTreatmentNote treatmentNote = treatmentNotes.get(i);
			treatmentNote.setPatientId(patientId);
			treatmentNote.setPatientUuid(patientFinalUuid);
			if(treatmentCheck.checkTreatmentNoteInMatch(treatmentNote))
				continue;
			MedicalRecord medicalRecord = treatmentNote.createMedicalRecord();
			//保存到云端数据库
			treatmentNote.setSyncFlag(Constant.SYNC_OK);
			this.cloudMedicalRecordDao.insert(medicalRecord);
			this.cloudEciTreatmentNoteDao.insert(treatmentNote);
			//添加治疗记录
			//this.eciTreatmentNoteService.saveByDiagnosisInfo(surgeryNote);
			//将匹配中间库的数据删除
			this.matchEciTreatmentNoteDao.delete(treatmentNote.getTreatmentId());
			this.matchMedicalRecordDao.delete(medicalRecord.getEmrId());
		}
		LogUtil.log.debug("合并治疗数据完成----------<<");
		return true;
	}
}

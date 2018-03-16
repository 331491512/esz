package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TPatientInHospitalNoteDetailInfo;
import com.esuizhen.cloudservice.sync.common.Const;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudInhospitalNoteDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchInhospitalNoteDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.model.InhospitalNote;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxInhospitalNoteService;
import com.esuizhen.cloudservice.sync.txservice.check.InhospitalNoteCheck;
import com.esuizhen.cloudservice.sync.txservice.check.MedicalRecordCheck;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.LogUtil;

@Service
public class TxInhospitalNoteServiceImpl implements TxInhospitalNoteService {
	@Autowired
	private MatchMedicalRecordDao matchMedicalRecordDao;
	@Autowired
	private MatchInhospitalNoteDao matchInhospitalNoteDao;
	@Autowired
	private CloudMedicalRecordDao cloudMedicalRecordDao;
	@Autowired
	private CloudInhospitalNoteDao cloudInhospitalNoteDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private MedicalRecordCheck medicalRecordCheck;
	@Autowired
	private InhospitalNoteCheck inhospitalNoteCheck;
	@Autowired
	private MatchPatientDao matchPatientDao;
	
	@Transactional
	@Override
	public MedicalRecord syncInhospitalNote(TPatientInHospitalNoteDetailInfo inHospitalNoteDetailInfo) {
		//检查是否存在匹配库
		inHospitalNoteDetailInfo.setPatientId(null);
		boolean flag = inhospitalNoteCheck.checkInhospitalNoteInMatch(inHospitalNoteDetailInfo);
		if(flag && inHospitalNoteDetailInfo.getPatientId()!=null)//存放在匹配中间库
			this.savePatientInHospitalNoteDetailInfoToMatch(inHospitalNoteDetailInfo);
		//存放在云端数据库
		if(inHospitalNoteDetailInfo.getPatientId()!=null)
			this.savePatientInHospitalNoteDetailInfoToCloud(inHospitalNoteDetailInfo);
		else{
			if(matchPatientDao.findByUuid(inHospitalNoteDetailInfo.getPatientUuid())!=null)
				this.savePatientInHospitalNoteDetailInfoToMatch(inHospitalNoteDetailInfo);
			else
				throw new EmptyObjectExcption("sync inhospitalnote error patientId not in cloud");
		}
		MedicalRecord patientInhospitalNoteRespose = new MedicalRecord();
		patientInhospitalNoteRespose.setEmrId(inHospitalNoteDetailInfo.getEmrId());
		return patientInhospitalNoteRespose;
	}
	/**
	 * 
	 * @param patient
	 * @param inHospitalNoteDetailInfo
	 * @return
	 */
	private boolean savePatientInHospitalNoteDetailInfoToCloud(TPatientInHospitalNoteDetailInfo inHospitalNoteDetailInfo){
		//电子病历
		MedicalRecord medicalRecord = inHospitalNoteDetailInfo.createMedicalRecord();
		medicalRecord.setCreateTime(inHospitalNoteDetailInfo.getCreateTime());
		//电子病历保存
		this.cloudMedicalRecordDao.insert(medicalRecord);
		//住院信息
		InhospitalNote inhospitalNote = inHospitalNoteDetailInfo.createInhospitalNote();
		//住院次数
		if (inHospitalNoteDetailInfo.getInhospitalTimes() == null) {
			inHospitalNoteDetailInfo.setInhospitalTimes(Const.INHOSPITALTIMES_FIRST);//默认第一次住院
		}
		if (inhospitalNote.getSourceFlag() == null) {
			inhospitalNote.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		inhospitalNote.setSyncFlag(Constant.User.SYNCFLAG_YES);
		//住院病案首页内容保存
		this.cloudInhospitalNoteDao.insert(inhospitalNote);
		return true;
	}

	/**
	 * 在云端数据库创建医患关系
	 * @param doctorId
	 * @param patientId
	 * @param source
	 * @return
	 */
//	private boolean createDoctorPatientToCloud(Long doctorId, Long patientId, Integer source){
//		DoctorPatient doctorPatient = this.cloudDoctorPatientDao.findDoctorPatient(patientId, doctorId);
//		if (doctorPatient != null) {
//			return true;
//		}
//		Date nowTime = new Date();
//		doctorPatient = new DoctorPatient();
//		doctorPatient.setDoctorId(doctorId);
//		doctorPatient.setPatientId(patientId);
//		doctorPatient.setSourceFlag(source);
//		doctorPatient.setCreateTime(nowTime);
//		doctorPatient.setAttentionTime(nowTime);
//		return this.cloudDoctorPatientDao.insert(doctorPatient) > 0;
//	}
	
	/**
	 * 
	 * @param inHospitalNoteDetailInfo
	 * @return
	 */
	private boolean savePatientInHospitalNoteDetailInfoToMatch(TPatientInHospitalNoteDetailInfo inHospitalNoteDetailInfo){
		//电子病历,不再进入云端库
//		MedicalRecord medicalRecord = inHospitalNoteDetailInfo.createMedicalRecord();
//		this.matchMedicalRecordDao.insert(medicalRecord);
		//住院信息
		InhospitalNote inhospitalNote = inHospitalNoteDetailInfo.createInhospitalNote();
		//住院次数
		if (inHospitalNoteDetailInfo.getInhospitalTimes() == null) {
			inHospitalNoteDetailInfo.setInhospitalTimes(Const.INHOSPITALTIMES_FIRST);//默认第一次住院
		}
		this.matchInhospitalNoteDao.insert(inhospitalNote);
		return true;
	}

	@Override
	public boolean mergeInhospitalNote(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with hospitalization data---------->>");
		//将患者住院信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchInhospitalNoteDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<TPatientInHospitalNoteDetailInfo> inhospitalNotes = this.matchInhospitalNoteDao.findByPatientUuid(patientFinalUuid);
		if (inhospitalNotes == null || inhospitalNotes.isEmpty()) {
			return true;
		}
		for (int i = inhospitalNotes.size() - 1; i >= 0; i--) {
			TPatientInHospitalNoteDetailInfo inhospitalNoteInfo = inhospitalNotes.get(i);
			InhospitalNote inhospitalNote = inhospitalNoteInfo.createInhospitalNote();
			MedicalRecord medicalRecord = this.matchMedicalRecordDao.findByEmrId(inhospitalNote.getEmrId());
			//电子病历不存在，创建
			if (medicalRecord == null) {
				medicalRecord = inhospitalNoteInfo.createMedicalRecord();
			}
			medicalRecord.setCreateTime(inhospitalNoteInfo.getCreateTime());
			inhospitalNote.setPatientId(patientId);
			inhospitalNote.setPatientUuid(patientFinalUuid);
			boolean flag =inhospitalNoteCheck.checkMatchToCloud(inhospitalNote);
			//电子病历属性补充
			medicalRecordCheck.checkMatchToCloudInhospitalNote(medicalRecord, inhospitalNote);
			//保存到云端数据库
			this.cloudMedicalRecordDao.insert(medicalRecord);
			inhospitalNote.setSyncFlag(Constant.SYNC_OK);
			this.cloudInhospitalNoteDao.insert(inhospitalNote);
			//将匹配中间库的数据删除 部分不匹配 完全匹配删除
			if(flag){
				this.matchInhospitalNoteDao.delete(inhospitalNote.getInhospitalId());
				this.matchMedicalRecordDao.delete(medicalRecord.getEmrId());
			}
		}
		LogUtil.log.debug("Combined hospitalization data completion----------<<");
		return true;
	}
}

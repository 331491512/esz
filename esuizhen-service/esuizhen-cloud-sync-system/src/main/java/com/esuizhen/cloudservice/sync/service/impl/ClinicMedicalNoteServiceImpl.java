package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.esuizhen.cloudservice.sync.dao.incre.IncreClinicMedicalNoteDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreMedicalRecordDao;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.ClinicMedicalNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxClinicMedicalNoteService;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.GeneralUtil;

@Service
public class ClinicMedicalNoteServiceImpl implements ClinicMedicalNoteService {
	@Autowired
	private IncreMedicalRecordDao increMedicalRecordDao;
	@Autowired
	private IncreClinicMedicalNoteDao increClinicMedicalDao;
	
	@Autowired
	private TxClinicMedicalNoteService txClinicMedicalNoteService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;

	@Override
	public MedicalRecord syncClinicMedicalInfo(TClinicMedicalNoteInfo clinicMedicalInfo) throws RejectRequestExcption, HospitalWithoutRightExcption {
		if(clinicMedicalInfo==null||!checkBeforeSyncService.checkHospitalId(clinicMedicalInfo.getHospitalId())){
			throw new HospitalWithoutRightExcption("");
		}
		//保存到增量库
		MedicalRecord medicalRecord = this.saveIncreClinicMedicalInfo(clinicMedicalInfo);
		this.txClinicMedicalNoteService.syncClinicMedicalInfo(clinicMedicalInfo);
		return medicalRecord;
	}

	//保存到增量库
	private MedicalRecord saveIncreClinicMedicalInfo(TClinicMedicalNoteInfo clinicMedicalInfo) {
		if(StringUtils.isBlank(clinicMedicalInfo.getEmrId()))
		clinicMedicalInfo.setEmrId(GeneralUtil.generatorUUID("EMRI"));
		clinicMedicalInfo.setClinicMedicalId(GeneralUtil.generatorUUID("ECLI"));
		
		if (clinicMedicalInfo.getSyncFlag() == null) {
			clinicMedicalInfo.setSyncFlag(Constant.SYNC_OK);
		}
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(clinicMedicalInfo.getEmrId());
		medicalRecord.setEmrNo(clinicMedicalInfo.getEmrNo());
		medicalRecord.setPatientId(clinicMedicalInfo.getPatientId());
		medicalRecord.setPatientUuid(clinicMedicalInfo.getPatientUuid());
		medicalRecord.setPatientNo(clinicMedicalInfo.getPatientNo());
		medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_EMERGENCY);
		medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_EMERGENCY);
		medicalRecord.setHospitalId(clinicMedicalInfo.getHospitalId());
		medicalRecord.setHospitalUuid(clinicMedicalInfo.getHospitalUuid());
		medicalRecord.setSourceFlag(clinicMedicalInfo.getSourceFlag());
		if (medicalRecord.getSourceFlag() == null) {
			medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_NO);
		medicalRecord.setVisibleFlag(Constant.Ehr.VISIBLEFLAG_NO_ONE);
		medicalRecord.setVisitTime(clinicMedicalInfo.getVisitTime());
		medicalRecord.setHandleFlag(Constant.Ehr.HANDLEFLAG_PENDING);
		medicalRecord.setCreateTime(clinicMedicalInfo.getCreateTime());
		//clinicMedicalInfo.setEmrId(medicalRecord.getEmrId());
		//this.increMedicalRecordDao.insert(medicalRecord);
		this.increClinicMedicalDao.insert(clinicMedicalInfo);
		
		return medicalRecord;
	}

}

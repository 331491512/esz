package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.dao.incre.IncreClinicMedicalNoteDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreOutHospitalNoteDao;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.model.SurgeryNote;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.ClinicMedicalNoteService;
import com.esuizhen.cloudservice.sync.service.OutHospitalNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxClinicMedicalNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxOutHospitalNoteService;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.GeneralUtil;

@Service
public class OutHospitalNoteServiceImpl implements OutHospitalNoteService {
	@Autowired
	private IncreOutHospitalNoteDao outHospitalNoteDao;
	@Autowired
	private IncreMedicalRecordDao increMedicalRecordDao;
	@Autowired
	private TxOutHospitalNoteService txOutHospitalNoteService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;



	@Override
	public MedicalRecord syncOutHospitalInfo(TOutHospitalNoteInfo outHospitalNoteInfo) throws RejectRequestExcption, HospitalWithoutRightExcption {
		if(outHospitalNoteInfo==null||!checkBeforeSyncService.checkHospitalId(outHospitalNoteInfo.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		//将数据保存到增量数据库
		this.saveOutHospitalInfoToIncre(outHospitalNoteInfo);
				
		return this.txOutHospitalNoteService.syncOutHospitalNote(outHospitalNoteInfo);
	}
	
	private boolean saveOutHospitalInfoToIncre(TOutHospitalNoteInfo outHospitalNoteInfo){
		
		
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(outHospitalNoteInfo.getEmrId());
		medicalRecord.setEmrNo(outHospitalNoteInfo.getEmrNo());
		medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		medicalRecord.setEmrSubType(23);
		medicalRecord.setPatientUuid(outHospitalNoteInfo.getPatientUuid());
		medicalRecord.setPatientNo(outHospitalNoteInfo.getPatientNo());
		medicalRecord.setHospitalId(outHospitalNoteInfo.getHospitalId());
		medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
		medicalRecord.setVisitTime(outHospitalNoteInfo.getVisitTime());
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(outHospitalNoteInfo.getOuthospitalDate());
		}
		
		//this.increMedicalRecordDao.insert(medicalRecord);
		this.outHospitalNoteDao.savecOutHospitalInfo(outHospitalNoteInfo);
		return true;
	}

}

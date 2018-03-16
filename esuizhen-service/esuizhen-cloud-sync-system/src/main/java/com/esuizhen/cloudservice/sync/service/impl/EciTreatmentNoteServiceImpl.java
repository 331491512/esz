package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.common.Const;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudEciTreatmentNoteDao;
import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.esuizhen.cloudservice.sync.model.SurgeryNote;
import com.esuizhen.cloudservice.sync.service.EciTreatmentNoteService;
import com.westangel.common.util.GeneralUtil;

@Service
public class EciTreatmentNoteServiceImpl implements EciTreatmentNoteService {
	@Autowired
	private CloudEciTreatmentNoteDao cloudEciTreatmentNoteDao;
	
	@Override
	public boolean saveByDiagnosisInfo(SurgeryNote surgeryNote){
		EciTreatmentNote eciTreatmentNote = new EciTreatmentNote();
		eciTreatmentNote.setTreatmentId(GeneralUtil.generatorUUID("ETRE"));
		eciTreatmentNote.setEmrId(surgeryNote.getEmrId());
		eciTreatmentNote.setPatientId(surgeryNote.getPatientId());
		eciTreatmentNote.setPatientNo(surgeryNote.getPatientNo());
		eciTreatmentNote.setHospitalId(surgeryNote.getHospitalId());
		eciTreatmentNote.setTreatmentTypeId(Const.ECITREATMENTNOTE_TREATMENTTYPEId);
		eciTreatmentNote.setTreatmentName(surgeryNote.getSurgeryName());
		eciTreatmentNote.setTreatmentWay(Const.ECITREATMENTNOTE_TREATMENTTYPENAME);
		eciTreatmentNote.setTreatmentProcessFlag(Const.TREATMENTPROCESSFLAG_FINISHED);
		eciTreatmentNote.setOperationDoctor(surgeryNote.getSurgeryDoctor());
		//add by fanpanwei
		eciTreatmentNote.setOperationDoctorUuid(surgeryNote.getSurgeryDoctorUuid());
		eciTreatmentNote.setTreatmentBeginTime(surgeryNote.getSurgeryBeginTime());
		if (eciTreatmentNote.getTreatmentBeginTime() == null) {
			eciTreatmentNote.setTreatmentBeginTime(surgeryNote.getSurgeryDate());
		}
		eciTreatmentNote.setTreatmentEndTime(surgeryNote.getSurgeryEndTime());
		eciTreatmentNote.setOpCode(surgeryNote.getOpCode());
		this.cloudEciTreatmentNoteDao.insert(eciTreatmentNote);
		return true;
	}
}

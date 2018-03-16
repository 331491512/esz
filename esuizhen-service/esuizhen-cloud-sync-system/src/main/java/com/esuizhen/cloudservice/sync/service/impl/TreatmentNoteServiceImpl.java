package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.dao.incre.IncreEciTreatmentNoteDao;
import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.TreatmentNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxTreatmentNoteService;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;

@Service
public class TreatmentNoteServiceImpl implements TreatmentNoteService {
	@Autowired
	private IncreEciTreatmentNoteDao treatmentNoteDao;
	@Autowired
	private TxTreatmentNoteService txTreatmentNoteService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;



	@Override
	public void syncTreatmentNote(EciTreatmentNote treatmentNoteInfo) throws RejectRequestExcption, HospitalWithoutRightExcption {
		if(treatmentNoteInfo==null||!checkBeforeSyncService.checkHospitalId(treatmentNoteInfo.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}

		//将数据保存到增量数据库
		this.saveTreatmentNoteInfoToIncre(treatmentNoteInfo);
				
		this.txTreatmentNoteService.syncTreatmentNote(treatmentNoteInfo);
	}
	
	private boolean saveTreatmentNoteInfoToIncre(EciTreatmentNote treatmentNote){
		this.treatmentNoteDao.saveTreatmentNote(treatmentNote);
		return true;
	}

}

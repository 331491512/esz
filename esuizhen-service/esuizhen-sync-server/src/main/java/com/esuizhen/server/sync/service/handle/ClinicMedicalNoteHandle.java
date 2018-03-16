package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.ClinicMedicalNoteRes;
import com.esuizhen.server.sync.dao.server.TClinicMedicalNoteDao;
import com.esuizhen.server.sync.dao.server.TMedicalRecordDao;
import com.esuizhen.server.sync.model.server.TMedicalRecord;
import com.westangel.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidan on 2017年03月28 下午 18:44
 */
@Component
public class ClinicMedicalNoteHandle {

    @Autowired
    private TClinicMedicalNoteDao clinicMedicalNoteDao;
    @Autowired
    private TMedicalRecordDao medicalRecordDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncAddInhospitalNote(ClinicMedicalNoteRes clinicMedicalNote) {
        //this.handleMedicalRecord(clinicMedicalNote);
        clinicMedicalNoteDao.insertSelective(clinicMedicalNote);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncUpdateInhospitalNote(ClinicMedicalNoteRes clinicMedicalNote) {
        //this.handleMedicalRecord(clinicMedicalNote);
        clinicMedicalNoteDao.updateByPrimaryKeySelective(clinicMedicalNote);
    }

    private void handleMedicalRecord(ClinicMedicalNoteRes clinicMedicalNote){
        if(clinicMedicalNote.getCpFlag().equals(0)){
            //添加主表
            TMedicalRecord medicalRecord=new TMedicalRecord();
            medicalRecord.setPatientUuid(clinicMedicalNote.getPatientUuid());
            medicalRecord.setPatientId(clinicMedicalNote.getPatientId());
            medicalRecord.setEmrId(clinicMedicalNote.getEmrId());
            medicalRecord.setHospitalId(clinicMedicalNote.getHospitalId());
            medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_EMERGENCY);//门（急）诊病历
            medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_EMERGENCY);//门（急）诊诊疗记录病历
            medicalRecord.setSourceFlag(clinicMedicalNote.getSourceFlag());//医院同步
            medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);//医院同步过来的结构化的数据
            medicalRecord.setVisitTime(clinicMedicalNote.getVisitTime());
            medicalRecordDao.insertSelective(medicalRecord);
        }
    }

}

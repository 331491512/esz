package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.SurgeryNoteRes;
import com.esuizhen.server.sync.dao.server.TMedicalRecordDao;
import com.esuizhen.server.sync.dao.server.TSurgeryNoteDao;
import com.esuizhen.server.sync.model.server.TMedicalRecord;
import com.westangel.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidan on 2017年03月28 下午 18:34
 */
@Component
public class SurgeryNoteHandle {

    @Autowired
    private TSurgeryNoteDao surgeryNoteDao;
    @Autowired
    private TMedicalRecordDao medicalRecordDao;

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void syncAddSurgeryNote(SurgeryNoteRes surgeryNote) {
        //this.handleMedicalRecord(surgeryNote);
        surgeryNoteDao.insertSelective(surgeryNote);
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void syncUpdateSurgeryNote(SurgeryNoteRes surgeryNote) {
       // this.handleMedicalRecord(surgeryNote);
        surgeryNoteDao.updateByPrimaryKeySelective(surgeryNote);
    }

    private void handleMedicalRecord(SurgeryNoteRes surgeryNote){
        if(surgeryNote.getCpFlag().equals(0)){
            //添加主表
            TMedicalRecord medicalRecord=new TMedicalRecord();
            medicalRecord.setPatientUuid(surgeryNote.getPatientUuid());
            medicalRecord.setPatientId(surgeryNote.getPatientId());
            medicalRecord.setEmrId(surgeryNote.getEmrId());
            medicalRecord.setHospitalId(surgeryNote.getHospitalId());
            medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_OPERATION);//手术单
            medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);//住院病历
            medicalRecord.setSourceFlag(surgeryNote.getSourceFlag());//医院同步
            medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);//医院同步过来的结构化的数据
            medicalRecord.setVisitTime(surgeryNote.getSurgeryDate());
            medicalRecordDao.insertSelective(medicalRecord);
        }
    }

}

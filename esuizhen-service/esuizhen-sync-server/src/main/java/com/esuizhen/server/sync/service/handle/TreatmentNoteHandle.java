package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.TreatmentNoteRes;
import com.esuizhen.server.sync.dao.server.TMedicalRecordDao;
import com.esuizhen.server.sync.dao.server.TTreatmentNoteDao;
import com.esuizhen.server.sync.model.server.TMedicalRecord;
import com.westangel.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidan on 2017年03月28 下午 18:37
 */
@Component
public class TreatmentNoteHandle {

    @Autowired
    private TTreatmentNoteDao treatmentNoteDao;
    @Autowired
    private TMedicalRecordDao medicalRecordDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncAddTreatmentNote(TreatmentNoteRes treatmentNote) {
        //this.handleMedicalRecord(treatmentNote);
        treatmentNoteDao.insertSelective(treatmentNote);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncUpdateTreatmentNote(TreatmentNoteRes treatmentNote) {
        //this.handleMedicalRecord(treatmentNote);
        treatmentNoteDao.updateByPrimaryKeySelective(treatmentNote);
    }

    private void handleMedicalRecord(TreatmentNoteRes treatmentNote){
        if(treatmentNote.getCpFlag().equals(0)){
            //添加主表
            TMedicalRecord medicalRecord=new TMedicalRecord();
            medicalRecord.setPatientUuid(treatmentNote.getPatientUuid());
            medicalRecord.setPatientId(treatmentNote.getPatientId());
            medicalRecord.setEmrId(treatmentNote.getEmrId());
            medicalRecord.setHospitalId(treatmentNote.getHospitalId());
            medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_TREATMENT);//治疗处置记录
            medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);//住院病历
            medicalRecord.setSourceFlag(treatmentNote.getSourceFlag());//医院同步
            medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);//医院同步过来的结构化的数据
            medicalRecord.setVisitTime(treatmentNote.getRawCreateTime());
            medicalRecordDao.insertSelective(medicalRecord);
        }
    }

}

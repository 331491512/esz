package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.OuthospitalNoteRes;
import com.esuizhen.server.sync.dao.server.TMedicalRecordDao;
import com.esuizhen.server.sync.dao.server.TOuthospitalNoteDao;
import com.esuizhen.server.sync.model.server.TMedicalRecord;
import com.westangel.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidan on 2017年03月28 下午 18:27
 */
@Component
public class OutHospitalNoteHandle {

    @Autowired
    private TOuthospitalNoteDao outhospitalNoteDao;
    @Autowired
    private TMedicalRecordDao medicalRecordDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncAddOuthospitalNote(OuthospitalNoteRes outhospitalNote) {
        //this.handleMedicalRecord(outhospitalNote);
        outhospitalNoteDao.insertSelective(outhospitalNote);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncUpdateOuthospitalNote(OuthospitalNoteRes outhospitalNote) {
       // this.handleMedicalRecord(outhospitalNote);
        outhospitalNoteDao.updateByPrimaryKeySelective(outhospitalNote);
    }

    private void handleMedicalRecord(OuthospitalNoteRes outhospitalNote){
        if(outhospitalNote.getCpFlag().equals(0)){
            //添加主表
            TMedicalRecord medicalRecord=new TMedicalRecord();
            medicalRecord.setPatientUuid(outhospitalNote.getPatientuuId());
            medicalRecord.setPatientId(outhospitalNote.getPatientId());
            medicalRecord.setEmrId(outhospitalNote.getEmrId());
            medicalRecord.setHospitalId(outhospitalNote.getHospitalId());
            medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_OUTHOSPITAL);//出院记录
            medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);//住院诊疗记录
            medicalRecord.setSourceFlag(outhospitalNote.getSourceFlag());//医院同步
            medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);//医院同步过来的结构化的数据
            medicalRecord.setVisitTime(outhospitalNote.getInhospitalDate());
            medicalRecordDao.insertSelective(medicalRecord);
        }
    }
}

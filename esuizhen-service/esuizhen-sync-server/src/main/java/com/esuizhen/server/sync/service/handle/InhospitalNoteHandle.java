package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.InhospitalNoteRes;
import com.esuizhen.server.sync.dao.server.TInhospitalNoteDao;
import com.esuizhen.server.sync.dao.server.TMedicalRecordDao;
import com.esuizhen.server.sync.model.server.TMedicalRecord;
import com.westangel.common.constant.Constant;
import com.westangel.common.constant.ConstantSync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidan on 2017年03月28 下午 18:23
 */
@Component
public class InhospitalNoteHandle {

    @Autowired
    private TInhospitalNoteDao inhospitalNoteDao;
    @Autowired
    private TMedicalRecordDao medicalRecordDao;

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void syncUpdateInhospitalNote(InhospitalNoteRes inhospitalNote) throws Exception {
        //this.handleMedicalRecord(inhospitalNote);
        inhospitalNote.setSyncflag(ConstantSync.SYNCFLAG.SYNC_UPDATE);
        inhospitalNoteDao.updateByPrimaryKeySelective(inhospitalNote);
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void syncAddInhospitalNote(InhospitalNoteRes inhospitalNote) throws Exception {
       // this.handleMedicalRecord(inhospitalNote);
        inhospitalNoteDao.insertSelective(inhospitalNote);
    }

    private void handleMedicalRecord(InhospitalNoteRes inhospitalNote){
        if(inhospitalNote.getCpFlag().equals(0)){
            //添加主表
            TMedicalRecord medicalRecord=new TMedicalRecord();
            medicalRecord.setPatientUuid(inhospitalNote.getPatientUuid());
            medicalRecord.setPatientId(inhospitalNote.getPatientId());
            medicalRecord.setEmrId(inhospitalNote.getEmrId());
            medicalRecord.setHospitalId(inhospitalNote.getHospitalId());
            medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_HOSPITALIZATION);//住院病案首页（住院基本信息）
            medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);//住院诊疗记录
            medicalRecord.setSourceFlag(inhospitalNote.getSourceFlag());//医院同步
            medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);//医院同步过来的结构化的数据
            medicalRecord.setVisitTime(inhospitalNote.getInhospitalDate());
            medicalRecordDao.insertSelective(medicalRecord);
        }
    }

}

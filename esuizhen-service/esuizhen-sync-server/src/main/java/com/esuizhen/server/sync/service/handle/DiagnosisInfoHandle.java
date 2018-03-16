package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.DiagnosisInfoRes;
import com.esuizhen.server.sync.dao.server.TDiagnosisInfoDao;
import com.esuizhen.server.sync.dao.server.TMedicalRecordDao;
import com.esuizhen.server.sync.model.server.TMedicalRecord;
import com.westangel.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidan on 2017年03月28 下午 18:30
 */
@Component
public class DiagnosisInfoHandle {

    @Autowired
    private TDiagnosisInfoDao diagnosisInfoDao;
    @Autowired
    private TMedicalRecordDao medicalRecordDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncAddDiagnosisInfo(DiagnosisInfoRes diagnosisInfo) {
        //this.handleMedicalRecord(diagnosisInfo);
        diagnosisInfoDao.insertSelective(diagnosisInfo);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncUpdateDiagnosisInfo(DiagnosisInfoRes diagnosisInfo) {
        //this.handleMedicalRecord(diagnosisInfo);
        diagnosisInfoDao.updateByPrimaryKeySelective(diagnosisInfo);
    }

    private void handleMedicalRecord(DiagnosisInfoRes diagnosisInfo){
        if(diagnosisInfo.getCpFlag().equals(0)){
            //添加主表
            TMedicalRecord medicalRecord=new TMedicalRecord();
            medicalRecord.setPatientUuid(diagnosisInfo.getPatientUuid());
            medicalRecord.setPatientId(diagnosisInfo.getPatientId());
            medicalRecord.setEmrId(diagnosisInfo.getEmrId());
            //medicalRecord.setHospitalId(diagnosisInfo.getHospitalId());
            medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_DIAGNOSIS);//诊断报告
            medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);//住院病历
            medicalRecord.setSourceFlag(diagnosisInfo.getSourceFlag());//医院同步
            medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);//医院同步过来的结构化的数据
            medicalRecord.setVisitTime(diagnosisInfo.getVisitTime());
            medicalRecordDao.insertSelective(medicalRecord);
        }
    }

}

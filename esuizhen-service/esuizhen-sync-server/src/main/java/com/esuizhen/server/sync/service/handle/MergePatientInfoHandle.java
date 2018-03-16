package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.PatientMergeInfoSyncReq;
import com.esuizhen.server.sync.dao.sc.PatientSyncResultServerDao;
import com.esuizhen.server.sync.dao.server.PatientDao;
import com.esuizhen.server.sync.model.server.TPatient;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.excption.EmptyObjectExcption;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nidan on 2017年04月14 上午 10:28
 */
@Component
public class MergePatientInfoHandle {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientSyncResultServerDao patientSyncResultServerDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void mergePatientInfoDeleteHandle(PatientMergeInfoSyncReq req){
        TPatient patient=patientDao.findPatientByUuid(req.getMergeFromUuid());
        //TPatient targetPatient=patientDao.findPatientByUuid(req.getMergeTargetUuid());
        if(patient==null){
            return;
        }
        TPatient p=new TPatient();
        BeanUtils.copyProperties(req,p);
        p.setPatientId(patient.getPatientId());
        p.setPatientType(-1);
        p.setMergeFromUuid(patient.getUuid());
        p.setMergeTargetUuid(req.getMergeTargetUuid());
        p.setMergeTime(req.getMergeTime());
        patientDao.update(p);
        //将患者相关的其他信息进行合并标识
        patientDao.mergePatientInfoDeleteProce(patient.getPatientId(),req.getMergeFromUuid(), req.getMergeTargetUuid(), req.getMergeTime());
        //更新result中的同步标识
        patientSyncResultServerDao.updatePatientMergeSyncFlag(req.getMergeFromUuid(), ConstantSync.SYNCFLAG.SYNC_MERGER_WAIT);
    }

}

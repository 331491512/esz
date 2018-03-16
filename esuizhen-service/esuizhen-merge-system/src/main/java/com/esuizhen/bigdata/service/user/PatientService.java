package com.esuizhen.bigdata.service.user;

import com.esuizhen.bigdata.bean.PatientInfoReq;
import com.esuizhen.bigdata.domain.user.UPatient;

import java.util.List;

/**
 * Created by fqc on 17/1/7.
 */
public interface PatientService  {
    void setVisitingTimeByPatients(List<UPatient> patients);

    void setVisitingTimeByPatientIds(List<Long> patientIds);

    void save(List<UPatient> patients);

    void save(UPatient patient);

    Integer saveMiddlePatientMerge(PatientInfoReq req, String path, Long userId) throws InterruptedException;

    int queryPreMergePatientCount();

    int queryAfterMergePatientCount();

    void mergeLiveStatus(Long targetPatientId);

    void mergeLostFollowupStatus(Long targetPatientId, List<Long> otherPatients);

    UPatient findTargetPatient(Long targetPatientId);

    void mergeLostFollowupStatusAndCause(Long targetPatientId, List<Long> otherPatientIds);
    //add by fqc end
    public void updatePatientSyncFlag(Long patientId,Integer fromSyncFlag, Integer toSyncFlag);

    public void flushPatientDisease(Long patientId);

}

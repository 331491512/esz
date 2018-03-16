package com.esuizhen.bigdata.service;

import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UUser;

import java.util.List;

/**
 * Created by fqc on 17/1/3.
 */
public interface RollBackMergeService {
    void executeRollBackMerge(Long targetPatientId, Long operatorId);

    void initialFrozenPatients(Long targetPatientId);

    List<UPatient> retrieveMergedPatients(Long targetPatientId);

    void rollBackOtherPatients(List<UPatient> otherPatients);

    void rollBackTargetPatient(UPatient targetPatient);

    void clearBackupOfTargetPatient(Long targetPatientId);

    void rollbackTargetUser(UPatient targetPatient);

    void rollbackMergedUsers(List<UPatient> otherPatients);

    void clearBackupOfTargetUser(UUser targetUser);

    void rollbackSimilarState(Long targetPatientId);
}

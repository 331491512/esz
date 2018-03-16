package com.esuizhen.bigdata.service.followup;

import com.esuizhen.bigdata.domain.followup.RFollowupTaskPatient;

import java.util.List;

/**
 * Created by fqc on 17/1/4.
 */
public interface RFollowupTaskPatientService {
    List<RFollowupTaskPatient> findTargetTaskPatient(Long targetPatientId);

    List<RFollowupTaskPatient> findOtherTaskPatients(List<Long> otherPatientIds);

    void rollback(Long targetPatientId);

    void merge(Long targetPatientId, List<Long> otherPatientIds);

}

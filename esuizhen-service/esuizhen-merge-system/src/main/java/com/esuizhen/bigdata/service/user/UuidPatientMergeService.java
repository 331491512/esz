package com.esuizhen.bigdata.service.user;

import com.esuizhen.bigdata.domain.user.UuidPatientMerge;

import java.util.List;

/**
 * Created by fqc on 17/1/9.
 */
public interface UuidPatientMergeService {
    List<UuidPatientMerge> findAllOrderByPatientId(List<Long> patientIds);

    void updateMergeStatus(Long targetPatientId, List<Long> mergePatientIds);
}

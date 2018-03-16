package com.esuizhen.bigdata.repository.user;

import org.springframework.data.repository.query.Param;

/**
 * Created by Nidan on 2016年12月24 上午 11:37
 */
public interface PatientMergeRepositoryCustom {
    int patientMerge(@Param("patientIds") String patientIds, @Param("i_operator") Long i_operator, @Param("i_mergeReason") String i_mergeReason);

    boolean flushTaskPatientStateAndNumber();

    int flushVarPatientFollowUp();
}

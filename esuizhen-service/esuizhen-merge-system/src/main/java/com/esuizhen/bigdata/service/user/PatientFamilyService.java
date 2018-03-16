package com.esuizhen.bigdata.service.user;

import com.esuizhen.bigdata.domain.user.UPatientFamily;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by fqc on 17/1/8.
 */
public interface PatientFamilyService {
    List<UPatientFamily> findPatientFamiliesAfterLostFollowupTime(List<Long> mergeGroupId,Timestamp lostFollowupTime);
}

package com.esuizhen.bigdata.service.ehr;

import com.esuizhen.bigdata.domain.followup.VarPatientFollowup;
import com.esuizhen.bigdata.domain.user.UPatient;

import java.util.List;

/**
 * Created by fqc on 17/1/9.
 */
public interface VarPatientFollowupService {
    List<VarPatientFollowup> findTarget(Long targetPatientId);
}

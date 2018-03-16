package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.VarPatientFollowup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by  fqc on 17/1/6.
 */
public interface VarPatientFollowupRepository extends JpaRepository<VarPatientFollowup,Integer>{
    VarPatientFollowup findByPatientIdAndFollowupTaskId(Long patientId, String taskId);

    VarPatientFollowup findByPatientId(Long targetPatientId);

    List<VarPatientFollowup> findByNewContactFlagAndPatientIdIn(Integer newContactFlag, List<Long> lostFollowupPatientIds);
}


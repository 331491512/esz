package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.RFollowupTaskPatient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fqc on 17/1/4.
 */
public interface RFollowupTaskPatientRepository extends JpaRepository<RFollowupTaskPatient, Long> {

    List<RFollowupTaskPatient> findByPatientId(Long patientId);

    List<RFollowupTaskPatient> findByPatientIdIn(List<Long> patientIds);

    List<RFollowupTaskPatient> findByFollowupTaskIdAndPatientIdIn(String followupTaskId, List<Long> mergePatientIds);

    RFollowupTaskPatient findByFollowupTaskIdAndPatientId(String followupTaskId, Long patientId);

    List<RFollowupTaskPatient> findByMergeFlagAndMergeTarget(Integer mergeFlag, Long targetPatientId);

    List<RFollowupTaskPatient> findByMergeTarget(Long targetPatientId);

    RFollowupTaskPatient findByMergeTargetAndMergeFromAndMergeFlagAndFollowupTaskId(Long targetPatientId, Long targetPatientId1, int i, String followupTaskId);

    //List<RFollowupTaskPatient> findByMergeTargetIsNullFollowupTaskIdAndPatientIdIn(String followupTaskId, List<Long> patientId);

    List<RFollowupTaskPatient> findByFollowupTaskIdAndPatientIdInAndMergeTargetIsNull(String followupTaskId, List<Long> pids);

    RFollowupTaskPatient findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(String followupTaskId, long patientId);

    List<RFollowupTaskPatient> findByPatientIdInAndMergeTargetIsNull(List<Long> otherPatientIds);

    RFollowupTaskPatient findByMergeTargetAndMergeFromAndFollowupTaskId(Long targetPatientId, Long targetPatientId1, String followupTaskId);
}

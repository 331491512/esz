package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.FollowupResultBuff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

/**
 * Created by fqc on 17/1/4.
 */
public interface FollowupResultBufferRepository extends JpaRepository<FollowupResultBuff, String> {

    List<FollowupResultBuff> findByPatientId(Long targetPatientId);

    List<FollowupResultBuff> findAll();

    List<FollowupResultBuff> findByPatientIdIn(List<Long> otherPatientIds);


    List<FollowupResultBuff> findByMergeFlagAndMergeTarget(int i, Long targetPatientId);

    List<FollowupResultBuff> findByMergeTarget(Long targetPatientId);

    List<FollowupResultBuff> findByPatientIdAndDeathDateGreaterThan(Long targetPatientId, Date followupTime);

    List<FollowupResultBuff> findByPatientIdAndFollowupResultValueAndDeathDateIsNotNullOrderByDeathDateAsc(Long patientId, Integer FollowupResultValue);

    List<FollowupResultBuff> findByPatientIdAndFollowupTaskId(long patientId, String followupTaskId);

    List<FollowupResultBuff> findByPatientIdInAndFollowupTaskIdIsNull(List<Long> otherPatientIds);

    FollowupResultBuff findByFollowupResultId(String followupResultId);

    FollowupResultBuff findByFollowupResultBuffId(String followupResultBuffId);

    List<FollowupResultBuff> findByPatientIdAndFollowupResultValueAndMergeFlagNot(Long targetPatientId, Integer followupResultValue, Integer mergeFlag);
}

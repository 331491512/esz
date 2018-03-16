package com.esuizhen.bigdata.service.followup;

import com.esuizhen.bigdata.domain.followup.FollowupResultBuff;

import java.util.List;

/**
 * Created by fqc on 17/1/4.
 */
public interface FollowupResultBufferService {

    /**
     * -- 一个患者对应的多个随访结果缓冲
     * SELECT
     * a.patientId ,
     * GROUP_CONCAT(a.followupResultId) ,
     * count(a.followupResultId) AS cn
     * FROM
     * followup_db.followup_result_buff a
     * GROUP BY
     * a.patientId
     * HAVING
     * cn > 1
     * ORDER BY
     * cn;
     * -- where a.patientId
     *
     * @param targetPatientId
     * @return
     */
    List<FollowupResultBuff> findFollowupResultBuffersOfTargetPatient(Long targetPatientId);

    List<FollowupResultBuff> findFollowupResultBuffers();

    List<FollowupResultBuff> findFollowupResultBuffersOfOtherPatients(List<Long> otherPatientIds);

    void merge(Long targetPatientId, List<Long> otherPatientIds);

    void rollback(Long targetPatientId, List<Long> otherPatientIds);

    void save(List<FollowupResultBuff> followupResults);

    void deleteFollowupResultAfterSpecificDeathDate(Long targetPatientId, Long retainPatientId);
}

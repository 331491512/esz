package com.esuizhen.bigdata.service.followup;

import com.esuizhen.bigdata.domain.followup.FollowupResult;

import java.util.List;

/**
 * Created by fqc on 17/1/4.
 */
public interface FollowupResultService {

    /**
     * -- 一个患者对应的多个随访结果
     * SELECT
     * a.patientId ,
     * GROUP_CONCAT(a.followupResultId) ,
     * count(a.followupResultId) AS cn
     * FROM
     * followup_db.followup_result a
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
    List<FollowupResult> findFollowupResultsOfTargetPatient(Long targetPatientId);

    List<FollowupResult> findFollowupResult();

    void merge(Long targetPatientId, List<Long> otherPatientIds);

    void rollback(Long targetPatientId);

    List<FollowupResult> findDeathRecord(Long targetPatientId);

    void batchUpdateResultValue(List<FollowupResult> followupResultsOfTargetPatient, Integer resultValue);

    List<FollowupResult> findLostFollowupFlagBean(List<Long> mergeGroupId, Integer flag);

    void save(List<FollowupResult> followupResults);

    void deleteFollowupResultAfterDeathDate(Long targetPatientId);

    void deleteFollowupResultAfterSpecificDeathDate(Long targetPatientId, Long retainPatientId);

    void mergeFollowupResult(Long targetPatientId, List<Long> otherPatientIds, Long retainPatientId);

    void updateVarPatientFollowupResult(Long targetPatientId);
}

package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.FollowupResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by fqc on 16/12/17.
 */
@Transactional
public interface FollowupResultRepository extends //RevisionRepository<FollowupResult, Long, Integer> ,
        JpaRepository<FollowupResult, String> {
    List<FollowupResult> findByPatientId(Long patientId);

    /**
     * taskId可能为空，查出的结果可能不唯一
     *
     * @param patientId
     * @param taskId
     * @return
     */
    List<FollowupResult> findByPatientIdAndFollowupTaskId(Long patientId, String taskId);

    List<FollowupResult> findByPatientIdOrderByDeathDateAsc(Long patientId);

    //select a.patientId, a.deathDate , a.deathCause from followup_db.followup_result  a where a.followupResultValue = 4 and patientId = 2622737;

    /**
     * 查找随访结果中随访结果类型为指定状态(类型4为死亡)的指定id的患者
     *
     * @param patientId
     * @param FollowupResultValue
     * @return
     */
    List<FollowupResult> findByPatientIdAndFollowupResultValueOrderByDeathDateAsc(Long patientId, Integer FollowupResultValue);

    List<FollowupResult> findByPatientIdAndFollowupResultValueAndDeathDateIsNotNullOrderByDeathDateAsc(Long patientId, Integer FollowupResultValue);

    //@Query(value = "select  min(a.deathDate),a.patientId from followup_db.followup_result  a " +
    //        "where patientId = ?1  and a.followupResultValue = ?2 group by a.patientId", nativeQuery = true)
    // 这种方式需自己写转换器，不如直接使用集合操作
    @Query("select min(f.deathDate) from FollowupResult f where f.patientId=:patientId and f.followupResultValue=:followupResultValue group by f.patientId")
    FollowupResult findFollowupResultByPatientIdAndMinDeathDate(@Param("patientId") Long patientId, @Param("followupResultValue") Integer FollowupResultValue);

    List<FollowupResult> findByPatientIdIn(List<Long> otherPatientIds);

    List<FollowupResult> findAllByFollowupResultValueAndPatientIdIn(Integer followupResultValue, List<Long> patientIds);

    List<FollowupResult> findAllByPatientIdAndFollowupTimeGreaterThan(Long patientId, Date followupTime);

    List<FollowupResult> findByMergeFlagAndMergeTarget(Integer mergeFlag, Long targetPatientId);

    List<FollowupResult> findByLostFollowupFlagAndPatientIdIn(Integer flag, List<Long> patientIds);

    List<FollowupResult> findByMergeTarget(Long targetPatientId);

    FollowupResult findByMergeTargetAndMergeFromAndMergeFlagAndFollowupTaskId(Long targetPatientId, Long targetPatientId1, int i, String followupTaskId);

    List<FollowupResult> findByPatientIdAndDeathDateGreaterThan(Long targetPatientId, Date followupTime);

    FollowupResult findByPatientIdAndDeathDateIsNotNull(Long targetPatientId);

    FollowupResult findByPatientIdAndFollowupResultValue(Long targetPatientId,Integer followupResultValue);

    List<FollowupResult> findAllByPatientIdInAndFollowupResultValueNotAndFollowupTimeGreaterThan(List<Long> patientIds, int i, Date deathDate);

    List<FollowupResult> findByPatientIdInAndFollowupTaskIdIsNotNull(List<Long> allPatientIds);

    List<FollowupResult> findByPatientIdInAndDeathDateIsNotNull(List<Long> patientIds);

    List<FollowupResult> findByPatientIdInAndFollowupResultValue(List<Long> patientIds,Integer followupResultValue);

    List<FollowupResult> findAllByPatientIdInAndFollowupResultValueNotAndFollowupTimeLessThan(List<Long> otherPatientIds, int i, Date deathDate);

    List<FollowupResult> findByPatientIdInAndFollowupTaskId(List<Long> patientIds, String followupTaskId);

    List<FollowupResult> findByPatientIdInAndMergeTargetIsNull(List<Long> otherPatientIds);

    FollowupResult findByFollowupResultIdAndMergeTargetIsNull(String followupResultId);

    List<FollowupResult> findAllByPatientIdInAndMergeTargetIsNull(List<Long> otherPatientIds);

    List<FollowupResult> findByPatientIdInAndFollowupTaskIdAndMergeTargetIsNull(List<Long> pids, String followupTaskId);

    FollowupResult findByMergeTargetAndMergeFromAndFollowupTaskId(Long targetPatientId, Long targetPatientId1, String followupTaskId);

    FollowupResult findByPatientIdAndFollowupResultValueAndMergeFlagNot(Long targetPatientId, int i, int i1);

    List<FollowupResult> findByPatientIdAndMergeFlagNotAndState(Long targetPatientId, int i, int i1);

    FollowupResult findByFollowupResultId(String followupResultId);

    FollowupResult findTopByPatientIdAndStateAndMergeFlagNotOrderByFollowupTimeDesc(Long patientId,Integer state, Integer mergeFlag);

    @Query(value = "select f.* from followup_db.followup_result f where f.patientId=:patientId and f.state=2 and f.followupResultValue in (select m.followupResultValueId from followup_db.meta_followup_result_value m where m.type=1) order by f.followupTime desc limit 0,1",nativeQuery = true)
    FollowupResult findLastValidFollowupResult(@Param("patientId") Long patientId);
}


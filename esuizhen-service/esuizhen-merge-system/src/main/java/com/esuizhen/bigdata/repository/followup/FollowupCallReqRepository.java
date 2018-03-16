package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.FollowupCallReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2017年01月05 上午 11:55
 */
public interface FollowupCallReqRepository extends JpaRepository<FollowupCallReq,Long> {

    List<FollowupCallReq> findAllByPatientIdIn(List<Long> otherPatientIds);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update FollowupCallReq set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

}

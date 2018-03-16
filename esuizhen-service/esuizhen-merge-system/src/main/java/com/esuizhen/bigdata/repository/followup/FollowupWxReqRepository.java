package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.FollowupWxReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2017年01月05 下午 16:57
 */
public interface FollowupWxReqRepository extends JpaRepository<FollowupWxReq,Long> {

    public List<FollowupWxReq> findAllByPatientIdIn(List<Long> otherPatientIds);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update FollowupWxReq set mergeFlag=0,mergeTime=null,mergeTarget=NULL,mergeFrom=NULL where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

}

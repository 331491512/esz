package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.EciDetectionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2016年12月17 下午 17:17
 */
public interface DetectionReportRepository extends JpaRepository<EciDetectionReport, String> {

    public List<EciDetectionReport> findAllByPatientIdIn(List<Long> patientId);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update EciDetectionReport set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

}

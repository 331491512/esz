package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.EciExamReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2016年12月17 下午 17:28
 */
public interface ExamReportRepository extends JpaRepository<EciExamReport, String> {

    public List<EciExamReport> findAllByPatientIdIn(List<Long> patientIds);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update EciExamReport set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);


}

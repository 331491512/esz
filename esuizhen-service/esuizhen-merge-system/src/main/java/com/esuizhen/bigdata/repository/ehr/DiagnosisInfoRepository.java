package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.EDiagnosisInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2016年12月17 下午 16:55
 */
public interface DiagnosisInfoRepository extends JpaRepository<EDiagnosisInfo, String> {

    public List<EDiagnosisInfo> findAllByPatientIdIn(List<Long> patientId);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update EDiagnosisInfo set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

    @Modifying
    @Query("update EDiagnosisInfo set inhospitalTimes=:inhospitalTimes where inhospitalId=:inhospitalId")
    void updateInhospitalTImesByInhospitalId(@Param("inhospitalTimes") Integer inhospitalTimes,
                                             @Param("inhospitalId") String inhospitalId);

    @Modifying
    @Query("UPDATE EDiagnosisInfo SET handleFlag=0,diseaseTypeId=NULL,icdDiseaseTypeId=NULL,isSourceDiagnosis=0 WHERE patientId=:patientId")
    void updateHandleFlagByPatientId(@Param("patientId") Long patientId);
}

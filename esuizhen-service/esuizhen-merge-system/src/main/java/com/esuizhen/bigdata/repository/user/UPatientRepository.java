package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.UPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fqc on 16/12/2.
 */
@RepositoryRestController
@Transactional
public interface UPatientRepository extends //RevisionRepository<UPatient, Long, Integer> ,
        JpaRepository<UPatient, Long> {

    UPatient findByTrueName(String trueName);

    UPatient findByPatientId(Long patientId);

    List<UPatient> findAllByPatientIdIn(Iterable<Long> patientIds);

    List<UPatient> findByPatientIdInAndMergeFlag(Iterable<Long> patientIds, Integer mergeFlag);

    List<UPatient> findByPatientIdInAndSyncFlag(Iterable<Long> patientIds, Integer syncFlag);

    int countByMergeFlag(Integer mergeFlag);

    List<UPatient> findByMergeTarget(Long targetId);

    List<UPatient> findByFollowupFlagAndPatientIdIn(Integer followupFlag, List<Long> mergeGroupId);

    @Modifying
    @Query("UPDATE UPatient SET sourceDiagnosis = NULL,sourceDiseaseCode = NULL,sourceDiseaseTypeId = NULL," +
            "confirmedDate = NULL,icdDiseaseTypeId = NULL,diagnosisType = NULL," +
            "diagnosisId = NULL,inhospitalId = NULL,sourceTumorFlag = NULL," +
            "sourcePathologyDiagnosis = NULL,sourcePathologyDiseaseCode = NULL," +
            "sourceDiagnosis2 = NULL,sourceDiseaseCode2 = NULL,sourceDiseaseTypeId2 = NULL," +
            "confirmedDate2 = NULL,icdDiseaseTypeId2 = NULL,diagnosisType2 = NULL," +
            "diagnosisId2 = NULL,inhospitalId2 = NULL,sourceTumorFlag2 = NULL," +
            "sourcePathologyDiagnosis2 = NULL,sourcePathologyDiseaseCode2 = NULL WHERE patientId=:patientId")
    void updatePatientDisease(@Param("patientId") Long patientId);
}

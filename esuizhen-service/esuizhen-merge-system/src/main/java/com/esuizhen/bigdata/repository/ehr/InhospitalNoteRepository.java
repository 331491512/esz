package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2016年12月19 下午 15:53
 */
public interface InhospitalNoteRepository extends JpaRepository<EiInhospitalNote, String> {

    List<EiInhospitalNote> findAllByPatientIdIn(List<Long> patientIds);

    List<EiInhospitalNote> findAllByPatientId(Long patientId);

    EiInhospitalNote findByOldPatientNoAndOldInhospitalTimes(String patientNo, Integer inhospitalTimes);

    List<EiInhospitalNote> findFirstByOldPatientNoAndOldInhospitalTimes(String patientNo, Integer inhospitalTimes);

    List<EiInhospitalNote> findAllByPatientIdOrderByInhospitalDateAsc(Long patientId);

    EiInhospitalNote findByOldInhospitalIdAndMergeFlag(String inhospitalId, Integer mergeFlag);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update EiInhospitalNote set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

    List<EiInhospitalNote> findFirstByOldPatientNoAndOldInhospitalTimesAndMergeFromAndMergeFlag(String oldPatientNo, Integer oldInhospitalTimes, Long patientId, Integer mergeFlag);
}

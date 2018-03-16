package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.EciTreatmentNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:09
 */
public interface TreatmentNoteRepository extends JpaRepository<EciTreatmentNote,String> {

    List<EciTreatmentNote> findAllByPatientIdIn(List<Long> otherPatientIds);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update EciTreatmentNote set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

    @Modifying
    @Query("update EciTreatmentNote set inhospitalTimes=:inhospitalTimes where inhospitalId=:inhospitalId")
    void updateInhospitalTImesByInhospitalId(@Param("inhospitalTimes") Integer inhospitalTimes,
                                             @Param("inhospitalId") String inhospitalId);
}

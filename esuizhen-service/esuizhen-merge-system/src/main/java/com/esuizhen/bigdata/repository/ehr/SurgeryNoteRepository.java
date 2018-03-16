package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.EciSurgeryNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2016年12月17 下午 17:04
 */
public interface SurgeryNoteRepository extends JpaRepository<EciSurgeryNote, String> {
    public List<EciSurgeryNote> findAllByPatientIdIn(List<Long> patientId);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update EciSurgeryNote set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

    List<EciSurgeryNote> findFirstByOldPatientNoAndOldInhospitalTimes(String oldPatientNo, Integer oldInhospitalTimes);

    @Modifying
    @Query("update EciSurgeryNote set inhospitalTimes=:inhospitalTimes where inhospitalId=:inhospitalId")
    void updateInhospitalTImesByInhospitalId(@Param("inhospitalTimes") Integer inhospitalTimes,
                                             @Param("inhospitalId") String inhospitalId);
}

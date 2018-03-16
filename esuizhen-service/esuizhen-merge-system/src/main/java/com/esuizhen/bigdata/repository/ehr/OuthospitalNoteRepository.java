package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.EiOuthospitalNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2016年12月17 下午 17:37
 */
public interface OuthospitalNoteRepository extends JpaRepository<EiOuthospitalNote, String> {

    public List<EiOuthospitalNote> findAllByPatientIdIn(List<Long> patientId);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update EiOuthospitalNote set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);

    @Modifying
    @Query("update EiOuthospitalNote set inhospitalTimes=:inhospitalTimes where inhospitalId=:inhospitalId")
    void updateInhospitalTImesByInhospitalId(@Param("inhospitalTimes") Integer inhospitalTimes,
                                             @Param("inhospitalId") String inhospitalId);
}

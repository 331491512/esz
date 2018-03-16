package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.RDeptPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nidan on 2017年07月25 上午 10:24
 */
public interface DeptPatientRepository extends JpaRepository<RDeptPatient,Integer> {


    List<RDeptPatient> findByPatientId(Long goalPatientId);

    List<RDeptPatient> findByPatientIdIn(List<Long> otherPatientIds);

    void deleteByMergeTargetAndMergeFlag(Long patientId, Integer mergeFlag);

    @Modifying
    @Query("update RDeptPatient set mergeFlag=0,mergeTime=null,mergeTarget=null,mergeFrom=null where mergeFlag=:mergeFlag and mergeTarget=:patientId")
    void updateMergeFlag(@Param("patientId") Long patientId, @Param("mergeFlag") Integer mergeFlag);
}

package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.UuidPatientMerge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nidan on 2016年12月23 上午 10:53
 */
public interface PatientMergeRepository extends JpaRepository<UuidPatientMerge,Long>,PatientMergeRepositoryCustom {

    public UuidPatientMerge findByPatientid(Long patientId);

	public List<UuidPatientMerge> findAllByGoalpatientid(Long goalpatientid);

}

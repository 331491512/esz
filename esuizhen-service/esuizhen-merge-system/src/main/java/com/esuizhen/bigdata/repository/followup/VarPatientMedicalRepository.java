package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.ehr.VarPatientMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fqc on 16/12/18.
 */
@RepositoryRestResource
//@EnableTransactionManagement
@Transactional
public interface VarPatientMedicalRepository extends //RevisionRepository<VarPatientMedical, Long, Integer>,
        JpaRepository<VarPatientMedical, Long> {
    VarPatientMedical findByPatientId(Long patientId);
}

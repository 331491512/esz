package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.mergebak.user.UPatientMergeBak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fqc on 16/12/22.
 */
@RepositoryRestResource
@Transactional
public interface UPatientMergeBakRepository extends //RevisionRepository<UPatientMergeBak, Long, Integer>,
        JpaRepository<UPatientMergeBak, Long> {
    UPatientMergeBak findByPatientId(Long targetPatientId);
}

package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.mergebak.followup.RFollowupTaskPatientMergeBak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fqc on 17/1/5.
 */
@RepositoryRestResource
@Transactional
public interface RFollowupTaskPatientMergeBakRepository extends JpaRepository<RFollowupTaskPatientMergeBak, Long> {

    List<RFollowupTaskPatientMergeBak> findByPatientId(Long targetPatientId);

    RFollowupTaskPatientMergeBak findByPatientIdAndFollowupTaskId(long patientId, String followupTaskId);
}


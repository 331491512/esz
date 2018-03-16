package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.mergebak.followup.FollowupResultBuffMergeBak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Nidan on 2017年02月14 下午 16:26
 */
public interface FollowupResultBuffMergeBakRepository extends JpaRepository<FollowupResultBuffMergeBak, String> {
    List<FollowupResultBuffMergeBak> findByPatientIdIn(List<Long> patientIds);

    FollowupResultBuffMergeBak findByFollowupResultId(String followupResultId);
}

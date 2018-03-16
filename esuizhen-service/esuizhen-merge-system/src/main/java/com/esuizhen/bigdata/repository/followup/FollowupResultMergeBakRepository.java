package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.mergebak.followup.FollowupResultMergeBak;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fqc on 17/1/21.
 */
public interface FollowupResultMergeBakRepository extends JpaRepository<FollowupResultMergeBak, String> {

    FollowupResultMergeBak findByFollowupResultId(String followupResultId);
}

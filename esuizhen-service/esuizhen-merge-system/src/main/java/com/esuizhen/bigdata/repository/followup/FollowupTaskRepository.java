package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.FollowupTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nidan on 2017年02月07 下午 17:58
 */
public interface FollowupTaskRepository extends JpaRepository<FollowupTask, String> {

    FollowupTask findByFollowupTaskId(String followupTaskId);
}

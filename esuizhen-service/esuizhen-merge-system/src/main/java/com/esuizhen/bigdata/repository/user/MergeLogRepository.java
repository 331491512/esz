package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.UMergeLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nidan on 2016年12月23 下午 15:36
 */
public interface MergeLogRepository extends JpaRepository<UMergeLog,Integer> {


}

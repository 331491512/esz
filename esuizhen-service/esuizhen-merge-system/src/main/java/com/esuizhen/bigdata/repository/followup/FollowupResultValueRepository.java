package com.esuizhen.bigdata.repository.followup;

import com.esuizhen.bigdata.domain.followup.MetaFollowupResultValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Nidan on 2017年05月18 下午 16:57
 */
public interface FollowupResultValueRepository extends JpaRepository<MetaFollowupResultValue,Integer> {

    List<MetaFollowupResultValue> findAllByType(Integer type);

}

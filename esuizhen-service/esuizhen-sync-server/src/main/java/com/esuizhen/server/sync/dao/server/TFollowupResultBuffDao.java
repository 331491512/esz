package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.FollowupResultBuffRes;

/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TFollowupResultBuffDao {

    void insertSelective(FollowupResultBuffRes record);

    void updateByPrimaryKeySelective(FollowupResultBuffRes record);
}
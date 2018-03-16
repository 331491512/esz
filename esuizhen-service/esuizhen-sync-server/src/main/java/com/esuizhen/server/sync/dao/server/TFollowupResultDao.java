package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.FollowupResultRes;

public interface TFollowupResultDao {

    void insertSelective(FollowupResultRes record);

    void updateByPrimaryKeySelective(FollowupResultRes record);
}
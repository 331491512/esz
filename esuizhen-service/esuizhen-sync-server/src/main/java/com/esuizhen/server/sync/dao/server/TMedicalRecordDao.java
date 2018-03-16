package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.model.server.TMedicalRecord;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TMedicalRecordDao {

    void insertSelective(TMedicalRecord record);

    void updateByPrimaryKeySelective(TMedicalRecord record);
}
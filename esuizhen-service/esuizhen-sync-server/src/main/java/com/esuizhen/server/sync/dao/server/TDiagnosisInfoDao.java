package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.DiagnosisInfoRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TDiagnosisInfoDao {

    void insertSelective(DiagnosisInfoRes record);

    void updateByPrimaryKeySelective(DiagnosisInfoRes record);
}
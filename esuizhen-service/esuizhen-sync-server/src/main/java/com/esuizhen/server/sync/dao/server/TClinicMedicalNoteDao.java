package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.ClinicMedicalNoteRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TClinicMedicalNoteDao {

    void insertSelective(ClinicMedicalNoteRes record);

    void updateByPrimaryKeySelective(ClinicMedicalNoteRes record);
}
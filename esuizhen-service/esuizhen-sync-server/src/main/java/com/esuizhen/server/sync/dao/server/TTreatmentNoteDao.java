package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.TreatmentNoteRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TTreatmentNoteDao {

    void insertSelective(TreatmentNoteRes record);

    void updateByPrimaryKeySelective(TreatmentNoteRes record);
}
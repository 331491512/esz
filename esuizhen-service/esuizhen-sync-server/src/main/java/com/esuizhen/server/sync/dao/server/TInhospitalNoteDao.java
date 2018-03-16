package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.InhospitalNoteRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TInhospitalNoteDao {

    void insertSelective(InhospitalNoteRes record);

    void updateByPrimaryKeySelective(InhospitalNoteRes record);
}
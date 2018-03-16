package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.SurgeryNoteRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TSurgeryNoteDao {

    void insertSelective(SurgeryNoteRes record);

    void updateByPrimaryKeySelective(SurgeryNoteRes record);
}
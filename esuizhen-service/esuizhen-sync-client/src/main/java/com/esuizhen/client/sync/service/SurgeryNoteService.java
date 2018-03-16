package com.esuizhen.client.sync.service;

import com.esuizhen.client.sync.model.TableInfo;

public interface SurgeryNoteService {
    void BatchSyncSurgeryNote(TableInfo tableInfo);
}

package com.esuizhen.client.sync.service;

import com.esuizhen.client.sync.model.TableInfo;

public interface PatientService {
    void BatchSyncPatient(TableInfo tableInfo);
}

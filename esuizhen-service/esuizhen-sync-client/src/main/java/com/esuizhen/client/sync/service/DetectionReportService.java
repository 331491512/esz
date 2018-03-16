package com.esuizhen.client.sync.service;

import com.esuizhen.client.sync.model.TableInfo;

public interface DetectionReportService {
    void BatchSyncDetectionReport(TableInfo tableInfo);
}

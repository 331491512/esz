package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.DiagnosisInfoRes;
import com.esuizhen.server.sync.model.temp.SyncEDiagnosisInfo;

public interface TempEDiagnosisInfoDao {

	void insert(SyncEDiagnosisInfo eDiagnosisInfo);

    List<DiagnosisInfoRes> getSyncDiagnosisInfo(TBatchDetailInfo detail);
}

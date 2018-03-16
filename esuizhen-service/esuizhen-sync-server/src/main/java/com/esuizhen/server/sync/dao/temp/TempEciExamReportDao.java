package com.esuizhen.server.sync.dao.temp;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.ExamReportRes;
import com.esuizhen.server.sync.model.temp.SyncEciExamReport;

import java.util.List;

public interface TempEciExamReportDao {

	void insert(SyncEciExamReport eciExamReport);

    List<ExamReportRes> getSyncExamReport(TBatchDetailInfo detail);

    /**
     * 向实时库同步一份
     * @param detail
     * @return
     */
    List<ExamReportRes> getSyncExamReportByRealtime(TBatchDetailInfo detail);
}

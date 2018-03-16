package com.esuizhen.bigdata.service.ehr;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 21:11
 */
public interface ExamReportService {

    public void mergeExamReport(Long goalPatientId, List<Long> otherPatientIds);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeExamReport(Long patientId);
}

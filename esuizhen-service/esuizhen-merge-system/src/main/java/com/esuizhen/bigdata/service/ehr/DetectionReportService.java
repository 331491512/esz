package com.esuizhen.bigdata.service.ehr;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:52
 */
public interface DetectionReportService {

    /**
     * 合并
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeDetectionReport(Long goalPatientId, List<Long> otherPatientIds);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeDetectionReport(Long patientId);

}

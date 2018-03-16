package com.esuizhen.bigdata.service.ehr;

import com.esuizhen.bigdata.domain.ehr.EciDetectionReport;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 21:02
 */
public interface DetectionDetailService {

    /**
     * 合并
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeDetectionDetail(Long goalPatientId, List<Long> otherPatientIds);

    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeDetectionDetail(Long patientId);

    /**
     * 根据detectionReportId合并相应的Detail结果
     * @param detectionReport2
     * @param detectionReportId
     */
    void mergeDetectionDetailById(EciDetectionReport detectionReport2, String detectionReportId);
}

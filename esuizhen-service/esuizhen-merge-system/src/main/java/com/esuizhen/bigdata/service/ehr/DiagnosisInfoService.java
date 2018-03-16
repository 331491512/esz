package com.esuizhen.bigdata.service.ehr;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 上午 11:12
 */
public interface DiagnosisInfoService {

    /**
     * 合并诊断信息
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeDiagnosisInfo(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeDiagnosisInfo(Long patientId);

    void updateHandleFlagByPatientId(Long goalPatientId);
}

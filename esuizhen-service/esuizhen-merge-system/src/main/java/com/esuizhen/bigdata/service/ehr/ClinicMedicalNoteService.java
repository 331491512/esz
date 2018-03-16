package com.esuizhen.bigdata.service.ehr;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:41
 */
public interface ClinicMedicalNoteService {

    /**
     * 合并门诊信息
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeClinicMedicalNote(Long goalPatientId, List<Long> otherPatientIds);

    /**
     * 撤销被合并的门诊信息
     * @param patientId
     */
    public void revokeMergeClinicMedicalNote(Long patientId);
}

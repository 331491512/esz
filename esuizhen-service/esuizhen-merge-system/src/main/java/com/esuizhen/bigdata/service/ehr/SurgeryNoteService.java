package com.esuizhen.bigdata.service.ehr;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 18:45
 */
public interface SurgeryNoteService {

    /**
     * 合并手术信息
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeSurgeryNote(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeSurgeryNote(Long patientId);
}

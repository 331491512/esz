package com.esuizhen.bigdata.service.ehr;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:07
 */
public interface TreatmentNoteService {

    /**
     * 合并治疗信息
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeTreatNote(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeTreatmentNote(Long patientId);
}

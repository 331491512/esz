package com.esuizhen.bigdata.service.ehr;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:27
 */
public interface OuthospitalNoteService {

    /**
     * 合并出院小结
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeOuthospitalNote(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeOuthospitalNote(Long patientId);
}

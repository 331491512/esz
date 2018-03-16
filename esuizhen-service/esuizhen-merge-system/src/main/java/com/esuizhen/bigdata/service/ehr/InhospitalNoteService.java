package com.esuizhen.bigdata.service.ehr;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;

import java.util.List;

/**
 * Created by Nidan on 2017年01月03 下午 16:22
 */
public interface InhospitalNoteService {

    /**
     * 合并患者的住院信息
     * @param goalPatientId
     * @param otherPatientIds
     */
    public List<EiInhospitalNote> mergeInhospitalNote(Long goalPatientId, List<Long> otherPatientIds);

    /**
     * 重新计算患者的住院次数
     * @param goalPatientId
     */
    public void reCountInhospitalTimes(Long goalPatientId);

    /**
     * 撤销合并的住院信息
     * @param patientId
     */
    public void revokeMergeInhospitalNote(Long patientId);

}

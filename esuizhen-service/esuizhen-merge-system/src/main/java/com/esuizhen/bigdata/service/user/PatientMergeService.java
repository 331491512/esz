package com.esuizhen.bigdata.service.user;

import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.bean.PatientResult;

import java.util.List;

/**
 * Created by Nidan on 2016年12月23 上午 10:54
 */
public interface PatientMergeService {

    void updatePatientSimilarState(Long patientId) throws Exception;

    int mergePatientInfo(MergePatientReq req);

    PatientResult electionTargetPatient(List<Long> patientIds);
}

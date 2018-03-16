package com.esuizhen.bigdata.service.followup;

import java.util.List;

/**
 * Created by Nidan on 2017年01月05 上午 11:48
 */
public interface FollowupCallReqService {

    /**
     * 合并电话发送记录
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeFollowupCallReq(Long goalPatientId, List<Long> otherPatientIds);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeFollowupCallReq(Long patientId);
}

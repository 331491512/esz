package com.esuizhen.bigdata.service.followup;

import java.util.List;

/**
 * Created by Nidan on 2017年01月05 下午 17:34
 */
public interface FollowupWxReqService {

    /**
     * 合并微信发送记录
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeFollowupwxReq(Long goalPatientId, List<Long> otherPatientIds);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeFollowupWxReq(Long patientId);
}

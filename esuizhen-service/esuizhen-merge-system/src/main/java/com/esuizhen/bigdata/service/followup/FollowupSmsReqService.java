package com.esuizhen.bigdata.service.followup;

import java.util.List;

/**
 * Created by Nidan on 2017年01月05 下午 17:24
 */
public interface FollowupSmsReqService {

    /**
     * 合并短信发送记录
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeFollowupSmsReq(Long goalPatientId, List<Long> otherPatientIds);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeFollowupSmsReq(Long patientId);
 }

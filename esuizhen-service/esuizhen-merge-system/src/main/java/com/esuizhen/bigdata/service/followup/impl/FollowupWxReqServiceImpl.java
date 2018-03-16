package com.esuizhen.bigdata.service.followup.impl;

import com.esuizhen.bigdata.domain.followup.FollowupWxReq;
import com.esuizhen.bigdata.repository.followup.FollowupWxReqRepository;
import com.esuizhen.bigdata.service.followup.FollowupWxReqService;
import com.westangel.common.util.GeneralUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nidan on 2017年01月05 下午 17:35
 */
@Service
@Transactional
public class FollowupWxReqServiceImpl implements FollowupWxReqService {

    @Autowired
    private FollowupWxReqRepository followupWxReqRepository;

    @Override
    public void revokeMergeFollowupWxReq(Long patientId) {
        followupWxReqRepository.deleteByMergeTargetAndMergeFlag(patientId,1);
        followupWxReqRepository.updateMergeFlag(patientId,2);
    }

    @Override
    public void mergeFollowupwxReq(Long goalPatientId, List<Long> otherPatientIds) {
        List<FollowupWxReq> list=followupWxReqRepository.findAllByPatientIdIn(otherPatientIds);
        FollowupWxReq followupWxReq2=null;

        for (FollowupWxReq followupWxReq : list) {
            followupWxReq.setMergeFlag(2);
            followupWxReq.setMergeTarget(goalPatientId);
            followupWxReq.setMergeFrom(followupWxReq.getPatientId());
            followupWxReq.setMergeTime(new Timestamp(System.currentTimeMillis()));
            followupWxReqRepository.save(followupWxReq);

            followupWxReq2=new FollowupWxReq();
            BeanUtils.copyProperties(followupWxReq,followupWxReq2,"reqId");

            followupWxReq2.setMergeFrom(followupWxReq.getPatientId());
            followupWxReq2.setMergeTarget(goalPatientId);
            followupWxReq2.setMessageId(GeneralUtil.generateUniqueID("WXMSG"));
            followupWxReq2.setMergeFlag(1);
            followupWxReq2.setPatientId(goalPatientId);

            followupWxReqRepository.save(followupWxReq2);

        }


    }
}

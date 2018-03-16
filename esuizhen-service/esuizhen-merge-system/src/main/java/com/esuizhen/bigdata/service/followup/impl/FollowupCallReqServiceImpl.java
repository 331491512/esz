package com.esuizhen.bigdata.service.followup.impl;

import com.esuizhen.bigdata.domain.followup.FollowupCallReq;
import com.esuizhen.bigdata.repository.followup.FollowupCallReqRepository;
import com.esuizhen.bigdata.service.followup.FollowupCallReqService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nidan on 2017年01月05 上午 11:53
 */
@Service
@Transactional
public class FollowupCallReqServiceImpl implements FollowupCallReqService {

    @Autowired
    private FollowupCallReqRepository followupCallReqRepository;

    @Override
    public void revokeMergeFollowupCallReq(Long patientId) {
        followupCallReqRepository.deleteByMergeTargetAndMergeFlag(patientId,1);
        followupCallReqRepository.updateMergeFlag(patientId,2);
    }

    @Override
    public void mergeFollowupCallReq(Long goalPatientId, List<Long> otherPatientIds) {
        List<FollowupCallReq> list=followupCallReqRepository.findAllByPatientIdIn(otherPatientIds);
        FollowupCallReq followupCallReq2=null;
        for (FollowupCallReq followupCallReq : list) {
            followupCallReq.setMergeFlag(2);
            followupCallReq.setMergeTarget(goalPatientId);
            followupCallReq.setMergeFrom(followupCallReq.getPatientId());
            followupCallReq.setMergeTime(new Timestamp(System.currentTimeMillis()));
            followupCallReqRepository.save(followupCallReq);

            followupCallReq2=new FollowupCallReq();
            BeanUtils.copyProperties(followupCallReq,followupCallReq2,"reqId");

            followupCallReq2.setMergeFrom(followupCallReq.getPatientId());
            followupCallReq2.setMergeTarget(goalPatientId);
            followupCallReq2.setMergeFlag(1);
            followupCallReq2.setPatientId(goalPatientId);
            followupCallReqRepository.save(followupCallReq2);

        }
    }
}

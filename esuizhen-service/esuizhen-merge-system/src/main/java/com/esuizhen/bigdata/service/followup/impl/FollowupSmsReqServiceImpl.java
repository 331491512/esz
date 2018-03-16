package com.esuizhen.bigdata.service.followup.impl;

import com.esuizhen.bigdata.domain.followup.FollowupSmsReq;
import com.esuizhen.bigdata.repository.followup.FollowupSmsReqRepository;
import com.esuizhen.bigdata.service.followup.FollowupSmsReqService;
import com.westangel.common.util.GeneralUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nidan on 2017年01月05 下午 17:26
 */
@Service
@Transactional
public class FollowupSmsReqServiceImpl implements FollowupSmsReqService {

    @Autowired
    private FollowupSmsReqRepository followupSmsReqRepository;

    @Override
    public void mergeFollowupSmsReq(Long goalPatientId, List<Long> otherPatientIds) {
        List<FollowupSmsReq> list=followupSmsReqRepository.findAllByPatientIdIn(otherPatientIds);
        FollowupSmsReq followupSmsReq2=null;

        for (FollowupSmsReq followupSmsReq : list) {
            followupSmsReq.setMergeFlag(2);
            followupSmsReq.setMergeTarget(goalPatientId);
            followupSmsReq.setMergeFrom(followupSmsReq.getPatientId());
            followupSmsReq.setMergeTime(new Timestamp(System.currentTimeMillis()));
            followupSmsReqRepository.save(followupSmsReq);

            followupSmsReq2=new FollowupSmsReq();
            BeanUtils.copyProperties(followupSmsReq,followupSmsReq2,"reqid");

            followupSmsReq2.setMergeFrom(followupSmsReq.getPatientId());
            followupSmsReq2.setMergeTarget(goalPatientId);
            followupSmsReq2.setMessageId(GeneralUtil.generateUniqueID("SMSMSG"));
            followupSmsReq2.setMergeFlag(1);
            followupSmsReq2.setPatientId(goalPatientId);

            followupSmsReqRepository.save(followupSmsReq2);

        }
    }

    @Override
    public void revokeMergeFollowupSmsReq(Long patientId) {
        followupSmsReqRepository.deleteByMergeTargetAndMergeFlag(patientId,1);
        followupSmsReqRepository.updateMergeFlag(patientId,2);
    }
}

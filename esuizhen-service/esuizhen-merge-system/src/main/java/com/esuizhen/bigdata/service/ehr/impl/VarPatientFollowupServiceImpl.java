package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.domain.followup.VarPatientFollowup;
import com.esuizhen.bigdata.repository.followup.VarPatientFollowupRepository;
import com.esuizhen.bigdata.service.ehr.VarPatientFollowupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fqc on 17/1/9.
 */
@Service
@Transactional
public class VarPatientFollowupServiceImpl implements VarPatientFollowupService {

    @Autowired
    private VarPatientFollowupRepository varPatientFollowupRepository;

    @Override
    public List<VarPatientFollowup> findTarget(Long targetPatientId) {
       // return varPatientFollowupRepository.findByPatientId(targetPatientId);
        //此方法暂时先不用，注释一下
        return null;
    }
}

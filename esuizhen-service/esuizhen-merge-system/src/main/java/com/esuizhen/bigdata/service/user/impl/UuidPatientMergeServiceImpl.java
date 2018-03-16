package com.esuizhen.bigdata.service.user.impl;

import com.esuizhen.bigdata.domain.user.UuidPatientMerge;
import com.esuizhen.bigdata.repository.user.UuidPatientMergeRepository;
import com.esuizhen.bigdata.service.user.UuidPatientMergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fqc on 17/1/9.
 */

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UuidPatientMergeServiceImpl implements UuidPatientMergeService {

    @Autowired
    private UuidPatientMergeRepository uuidPatientMergeRepository;

    @Override
    public List<UuidPatientMerge> findAllOrderByPatientId(List<Long> patientIds) {
        List<UuidPatientMerge> uuidPatientMergeGroup = uuidPatientMergeRepository.findByPatientidIn(patientIds);
        return uuidPatientMergeGroup;
    }

    @Override
    public void updateMergeStatus(Long targetPatientId, List<Long> mergePatientIds) {
        List<UuidPatientMerge> uuidPatientMergeList = this.findAllOrderByPatientId(mergePatientIds);
        Long goalPatientId=uuidPatientMergeList.get(0).getGoalpatientid();
        for (UuidPatientMerge uuidPatientMerge : uuidPatientMergeList){
        //uuidPatientMergeList.forEach(uuidPatientMerge -> {
            uuidPatientMerge.setRepeatflag(0);
            uuidPatientMerge.setResultflag(1);
            uuidPatientMerge.setGoalpatientid(targetPatientId);
        }
        uuidPatientMergeRepository.save(uuidPatientMergeList);
       /* List<Object> similarPatientButJustOne = uuidPatientMergeRepository.getSimilarPatientButJustOne();
        similarPatientButJustOne.forEach(id -> {
            uuidPatientMergeRepository.delete((Long) id);
        });*/

        //剩余疑似患者标识更新
        List<UuidPatientMerge> list=uuidPatientMergeRepository.findByGoalpatientidAndRepeatflagAndCancelflag(goalPatientId,1,0);
        if(list!=null&&list.size()==1){
            UuidPatientMerge patientMerge=list.get(0);
            patientMerge.setGoalpatientid(null);
            patientMerge.setRepeatflag(0);
            patientMerge.setRemark(null);
            uuidPatientMergeRepository.save(patientMerge);
        }else if(list!=null&&list.size()>1){
            Long goalPId=list.get(0).getPatientid();
            for (UuidPatientMerge patientMerge : list){
                patientMerge.setGoalpatientid(goalPId);
                uuidPatientMergeRepository.save(patientMerge);
            }
        }

    }
}

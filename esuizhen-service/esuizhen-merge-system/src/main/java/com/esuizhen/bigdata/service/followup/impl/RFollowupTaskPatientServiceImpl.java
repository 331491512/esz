package com.esuizhen.bigdata.service.followup.impl;

import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.domain.followup.RFollowupTaskPatient;
import com.esuizhen.bigdata.domain.mergebak.followup.RFollowupTaskPatientMergeBak;
import com.esuizhen.bigdata.repository.followup.FollowupResultMergeBakRepository;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.repository.followup.RFollowupTaskPatientMergeBakRepository;
import com.esuizhen.bigdata.repository.followup.RFollowupTaskPatientRepository;
import com.esuizhen.bigdata.service.followup.RFollowupTaskPatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fqc on 17/1/4.
 */
@Service
@Transactional
public class RFollowupTaskPatientServiceImpl implements RFollowupTaskPatientService {

    @Autowired
    private RFollowupTaskPatientRepository rFollowupTaskPatientRepository;

    @Autowired
    private RFollowupTaskPatientMergeBakRepository rFollowupTaskPatientMergeBakRepository;

    @Autowired
    private FollowupResultRepository followupResultRepository;

    @Autowired
    private FollowupResultMergeBakRepository followupResultMergeBakRepository;


    @Override
    public List<RFollowupTaskPatient> findTargetTaskPatient(Long targetPatientId) {
        List<RFollowupTaskPatient> rFollowupTaskPatients = rFollowupTaskPatientRepository.findByPatientId(targetPatientId);
        return rFollowupTaskPatients;
    }

    @Override
    public List<RFollowupTaskPatient> findOtherTaskPatients(List<Long> otherPatientIds) {
        List<RFollowupTaskPatient> otherTaskPatients = rFollowupTaskPatientRepository.findByPatientIdIn(otherPatientIds);
        return otherTaskPatients;
    }

    @Override
    public void rollback(Long targetPatientId) {
        //mergeTarget = patientId mergeFlag = 2 的 修改标记状态
        //mergeTarget = patientId mergeFlag = 1 的 是被选举后而追加上的，删除
        //bak中的先用来更新目标患者相应的任务 ，然后删除
        /*List<RFollowupTaskPatient> flaggedTaskPatients = rFollowupTaskPatientRepository.findByMergeFlagAndMergeTarget(2, targetPatientId);

        flaggedTaskPatients.forEach(rFollowupTaskPatient -> {
            rFollowupTaskPatient.setMergeFlag(0);
            rFollowupTaskPatient.setMergeFrom(null);
            rFollowupTaskPatient.setMergeTarget(null);
            rFollowupTaskPatient.setMergeTime(null);
        });
        rFollowupTaskPatientRepository.save(flaggedTaskPatients);

        List<RFollowupTaskPatient> appended2TargetPatients = rFollowupTaskPatientRepository.findByMergeFlagAndMergeTarget(1, targetPatientId);
        if (!appended2TargetPatients.isEmpty()) {
            rFollowupTaskPatientRepository.deleteInBatch(appended2TargetPatients);
        }

        List<RFollowupTaskPatientMergeBak> backupedTaskPatients = rFollowupTaskPatientMergeBakRepository.findByPatientId(targetPatientId);
        if (!backupedTaskPatients.isEmpty()) {
            backupedTaskPatients.forEach(rFollowupTaskPatientMergeBak -> {
                String taskId = rFollowupTaskPatientMergeBak.getFollowupTaskId();
                Long patientId = rFollowupTaskPatientMergeBak.getPatientId();
                RFollowupTaskPatient target = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(taskId, patientId);
                BeanUtils.copyProperties(rFollowupTaskPatientMergeBak, target);
                rFollowupTaskPatientRepository.save(target);
            });
        }

        rFollowupTaskPatientMergeBakRepository.deleteInBatch(backupedTaskPatients);
*/
        /*List<RFollowupTaskPatient> followupTaskPatients=rFollowupTaskPatientRepository.findByMergeTarget(targetPatientId);
        followupTaskPatients.forEach(o1 -> {
            RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByMergeTargetAndMergeFromAndMergeFlagAndFollowupTaskId(targetPatientId,targetPatientId,2,o1.getFollowupTaskId());
            if(followupTaskPatient!=null&&followupTaskPatient.getId()==o1.getId()){
                List<FollowupResult> followupResults=followupResultRepository.findByPatientIdAndFollowupTaskId(targetPatientId,followupTaskPatient.getFollowupTaskId());
                if(followupResults!=null&&followupResults.size()>0){
                    FollowupResult followupResult=followupResults.get(0);
                    if(followupResult.getMergeTime().after(followupResult.getFollowupTime())){

                        RFollowupTaskPatient followupTaskPatient1=new RFollowupTaskPatient();
                        BeanUtils.copyProperties(o1,followupTaskPatient1);

                        RFollowupTaskPatient followupTaskPatient2=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(o1.getFollowupTaskId(),targetPatientId);
                        BeanUtils.copyProperties(followupTaskPatient2,o1,"id","patientId");
                        o1.setMergeFlag(0);
                        o1.setMergeTime(null);
                        o1.setMergeFrom(null);
                        o1.setMergeTarget(null);
                        rFollowupTaskPatientRepository.save(o1);

                        BeanUtils.copyProperties(followupTaskPatient1,followupTaskPatient2,"id","patientId");

                        followupTaskPatient2.setMergeFlag(0);
                        followupTaskPatient2.setMergeTarget(null);
                        followupTaskPatient2.setMergeFrom(null);
                        followupTaskPatient2.setMergeTime(null);
                        rFollowupTaskPatientRepository.save(followupTaskPatient2);

                    }else{
                        o1.setMergeFlag(0);
                        o1.setMergeTarget(null);
                        o1.setMergeFrom(null);
                        o1.setMergeTime(null);
                        rFollowupTaskPatientRepository.save(o1);

                        RFollowupTaskPatient followupTaskPatient2=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(o1.getFollowupTaskId(),targetPatientId);
                        followupTaskPatient2.setMergeFlag(0);
                        followupTaskPatient2.setMergeFrom(null);
                        followupTaskPatient2.setMergeTarget(null);
                        followupTaskPatient2.setMergeTime(null);
                        rFollowupTaskPatientRepository.save(followupTaskPatient2);
                    }
                }else{
                    if(o1.getMergeFrom()!=null) {

                        RFollowupTaskPatient followupTaskPatient1=new RFollowupTaskPatient();
                        BeanUtils.copyProperties(o1,followupTaskPatient1);

                        RFollowupTaskPatient followupTaskPatient2=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(o1.getFollowupTaskId(),targetPatientId);
                        BeanUtils.copyProperties(followupTaskPatient2,o1,"id","patientId");
                        o1.setMergeFlag(0);
                        o1.setMergeTime(null);
                        o1.setMergeFrom(null);
                        o1.setMergeTarget(null);
                        rFollowupTaskPatientRepository.save(o1);

                        BeanUtils.copyProperties(followupTaskPatient1,followupTaskPatient2,"id","patientId");

                        followupTaskPatient2.setMergeFlag(0);
                        followupTaskPatient2.setMergeTarget(null);
                        followupTaskPatient2.setMergeFrom(null);
                        followupTaskPatient2.setMergeTime(null);
                        rFollowupTaskPatientRepository.save(followupTaskPatient2);
                    }
                }
            }else if(o1.getMergeFrom()!=null){
                    if(followupTaskPatient!=null){
                        if(o1.getPatientId()!=followupTaskPatient.getMergeFrom()){
                            o1.setMergeFlag(0);
                            o1.setPatientId(o1.getMergeFrom());
                            o1.setMergeTarget(null);
                            o1.setMergeFrom(null);
                            o1.setMergeTime(null);
                            rFollowupTaskPatientRepository.save(o1);
                        }
                    }else{
                        o1.setMergeFlag(0);
                        o1.setPatientId(o1.getMergeFrom());
                        o1.setMergeTarget(null);
                        o1.setMergeFrom(null);
                        o1.setMergeTime(null);
                        rFollowupTaskPatientRepository.save(o1);
                    }
            }
        });*/
        List<RFollowupTaskPatient> followupTaskPatients=rFollowupTaskPatientRepository.findByMergeTarget(targetPatientId);
        for (RFollowupTaskPatient o1 : followupTaskPatients) {
        //followupTaskPatients.forEach(o1 -> {
            RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByMergeTargetAndMergeFromAndFollowupTaskId(targetPatientId,targetPatientId,o1.getFollowupTaskId());
            if(followupTaskPatient!=null&&o1.getPatientId()==followupTaskPatient.getPatientId()){
                List<FollowupResult> followupResults=followupResultRepository.findByPatientIdAndFollowupTaskId(targetPatientId,followupTaskPatient.getFollowupTaskId());
                if(followupResults!=null&&followupResults.size()>0) {
                    FollowupResult followupResult = followupResults.get(0);
                    RFollowupTaskPatientMergeBak followupTaskPatientMergeBak=rFollowupTaskPatientMergeBakRepository.findByPatientIdAndFollowupTaskId(followupResult.getPatientId(),followupResult.getFollowupTaskId());
                    if (followupResult.getMergeTime().after(followupResult.getFollowupTime())) {
                        BeanUtils.copyProperties(followupTaskPatientMergeBak,followupTaskPatient);
                        rFollowupTaskPatientRepository.save(followupTaskPatient);
                    }else{
                        followupTaskPatient.setMergeFlag(0);
                        followupTaskPatient.setMergeTarget(null);
                        followupTaskPatient.setMergeFrom(null);
                        followupTaskPatient.setMergeTime(null);
                        rFollowupTaskPatientRepository.save(followupTaskPatient);
                    }
                    rFollowupTaskPatientMergeBakRepository.delete(followupTaskPatientMergeBak);
                }
            }else{
                o1.setMergeFlag(0);
                o1.setPatientId(o1.getMergeFrom());
                o1.setMergeTarget(null);
                o1.setMergeFrom(null);
                o1.setMergeTime(null);
                rFollowupTaskPatientRepository.save(o1);
            }
        }
    }

    // TODO:重构 17/1/8
    @Override
    public void merge(Long targetPatientId, List<Long> otherPatientIds) {

    }

}

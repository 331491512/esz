package com.esuizhen.bigdata.service.followup.impl;

import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.domain.followup.FollowupResultBuff;
import com.esuizhen.bigdata.domain.mergebak.followup.FollowupResultBuffMergeBak;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.merge.AbstractMergeBean;
import com.esuizhen.bigdata.repository.followup.FollowupResultBuffMergeBakRepository;
import com.esuizhen.bigdata.repository.followup.FollowupResultBufferRepository;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.followup.FollowupResultBufferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by fqc on 17/1/4.
 */
@Service
@Transactional
public class FollowupResultBufferServiceImpl implements FollowupResultBufferService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AbstractMergeBean.class);

    @Autowired
    FollowupResultBufferRepository followupResultBufferRepository;
    @Autowired
    FollowupResultRepository followupResultRepository;

    @Autowired
    private FollowupResultBuffMergeBakRepository followupResultBuffMergeBakRepository;

    @Autowired
    private UPatientRepository patientRepository;

    @Override
    public List<FollowupResultBuff> findFollowupResultBuffersOfTargetPatient(Long targetPatientId) {
        List<FollowupResultBuff> followupResultBuffersOfTargetPatient = followupResultBufferRepository.findByPatientId(targetPatientId);
        return followupResultBuffersOfTargetPatient;
    }

    @Override
    public List<FollowupResultBuff> findFollowupResultBuffers() {
        return followupResultBufferRepository.findAll();
    }

    @Override
    public List<FollowupResultBuff> findFollowupResultBuffersOfOtherPatients(List<Long> otherPatientIds) {
        List<FollowupResultBuff> followupResultBuffersOfOtherPatients = followupResultBufferRepository.findByPatientIdIn(otherPatientIds);
        return followupResultBuffersOfOtherPatients;
    }

    @Override
    public void merge(Long targetPatientId, List<Long> otherPatientIds) {
        List<FollowupResultBuff> followupResultsOfOtherPatients = followupResultBufferRepository.findByPatientIdIn(otherPatientIds);

        appendOtherFollowupResults2TargetPatient(targetPatientId, followupResultsOfOtherPatients);
        flagOtherFollowupResults(targetPatientId, followupResultsOfOtherPatients);
    }

    private void flagOtherFollowupResults(Long targetPatientId, List<FollowupResultBuff> followupResultsOfOtherPatients) {
        //followupResultsOfOtherPatients.forEach(otherFollowupResultBean -> {
        for (FollowupResultBuff otherFollowupResultBean :followupResultsOfOtherPatients) {
            otherFollowupResultBean.setMergeFlag(2);
            otherFollowupResultBean.setMergeFrom(otherFollowupResultBean.getPatientId());
            otherFollowupResultBean.setMergeTarget(targetPatientId);
            otherFollowupResultBean.setMergeTime(TimeUtils.getCurrentTimestamp());
        }
    }

    private void appendOtherFollowupResults2TargetPatient(Long targetPatientId, List<FollowupResultBuff> followupResultsOfOtherPatients) {

        List<FollowupResultBuff> batchInsertBeans = new ArrayList<>();
        for (FollowupResultBuff source : followupResultsOfOtherPatients){
        //followupResultsOfOtherPatients.forEach(source -> {
            FollowupResultBuff append2TargetBean = new FollowupResultBuff();
            BeanUtils.copyProperties(source, append2TargetBean, "followupResultBuffId", "patientId");
            append2TargetBean.setPatientId(targetPatientId);
            append2TargetBean.setMergeFlag(1);
            append2TargetBean.setMergeFrom(source.getPatientId());
            append2TargetBean.setMergeTarget(targetPatientId);
            append2TargetBean.setMergeTime(TimeUtils.getCurrentTimestamp());
            batchInsertBeans.add(append2TargetBean);
        }
        followupResultBufferRepository.save(batchInsertBeans);
    }

    @Override
    public void rollback(Long targetPatientId, List<Long> otherPatientIds) {
        //List<FollowupResultBuff> mergedResults = followupResultBufferRepository.findByMergeFlagAndMergeTarget(1, targetPatientId);
        //List<FollowupResultBuff> flaggedResults = followupResultBufferRepository.findByMergeFlagAndMergeTarget(2, targetPatientId);
        //rollbackThatWasAppended2TargetPatient(mergedResults);
        //rollbackThatWasFlaggedMerged(flaggedResults);
//        List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByMergeTarget(targetPatientId);
//        followupResultBuffs.forEach(o1 -> {
//            o1.setPatientId(o1.getMergeFrom());
//            o1.setMergeFlag(0);
//            o1.setMergeTarget(null);
//            o1.setMergeFrom(null);
//            o1.setMergeTime(null);
//        });
        //List<FollowupResultBuff> mergedResults = followupResultBufferRepository.findByMergeFlagAndMergeTarget(1, targetPatientId);
        //List<FollowupResultBuff> flaggedResults = followupResultBufferRepository.findByMergeFlagAndMergeTarget(2, targetPatientId);
        //rollbackThatWasAppended2TargetPatient(mergedResults);
        //rollbackThatWasFlaggedMerged(flaggedResults);
        List<Long> patientIds= new ArrayList<>();
        patientIds.add(targetPatientId);
        List<UPatient> patients=patientRepository.findByMergeTarget(targetPatientId);
        /*patients.forEach(o1 -> {
            patientIds.add(o1.getPatientId());
        });*/
        for (UPatient o1 : patients) patientIds.add(o1.getPatientId());
        List<FollowupResultBuffMergeBak> followupResultBuffMergeBaks=followupResultBuffMergeBakRepository.findByPatientIdIn(patientIds);
        for (FollowupResultBuffMergeBak o1 : followupResultBuffMergeBaks){
        //followupResultBuffMergeBaks.forEach(o1 -> {
            FollowupResultBuff followupResultBuff=followupResultBufferRepository.findByFollowupResultBuffId(o1.getFollowupResultBuffId());
            BeanUtils.copyProperties(o1,followupResultBuff);
            followupResultBufferRepository.save(followupResultBuff);
            followupResultBuffMergeBakRepository.delete(o1);
        }

        List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByMergeTarget(targetPatientId);
        for (FollowupResultBuff o1 : followupResultBuffs){
        //followupResultBuffs.forEach(o1 -> {
            List<FollowupResult> list=followupResultRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());
            if(list!=null&&list.size()>0){
                FollowupResult followupResult=list.get(0);
                if(followupResult.getMergeTime()!=null&&
                        followupResult.getMergeTime().after(followupResult.getFollowupTime())){
                    o1.setPatientId(o1.getMergeFrom());
                    o1.setMergeFlag(0);
                    o1.setMergeTarget(null);
                    o1.setMergeFrom(null);
                    o1.setMergeTime(null);
                }else{
                    o1.setMergeFlag(0);
                    o1.setMergeTarget(null);
                    o1.setMergeFrom(null);
                    o1.setMergeTime(null);
                }
            }else{
                if(o1.getMergeFrom()!=null){
                    o1.setPatientId(o1.getMergeFrom());
                    o1.setMergeFlag(0);
                    o1.setMergeTarget(null);
                    o1.setMergeFrom(null);
                    o1.setMergeTime(null);
                }
            }
        }
        followupResultBufferRepository.save(followupResultBuffs);
    }

    @Override
    public void save(List<FollowupResultBuff> followupResults) {
        if (followupResults != null && (!followupResults.isEmpty())) {
            followupResultBufferRepository.save(followupResults);
        }
    }

    @Override
    public void deleteFollowupResultAfterSpecificDeathDate(Long targetPatientId, Long retainPatientId) {
        //查询出选择保留患者的死亡随访记录
        List<FollowupResultBuff> followupResultsOfRetainPatient = followupResultBufferRepository.
                findByPatientIdAndFollowupResultValueAndDeathDateIsNotNullOrderByDeathDateAsc(retainPatientId, 4);
        if (followupResultsOfRetainPatient != null && followupResultsOfRetainPatient.size() > 0) {
            FollowupResultBuff retainFollowupResultBuff = followupResultsOfRetainPatient.get(0);
            Date deathFollowupTime = retainFollowupResultBuff.getDeathDate();

            List<FollowupResultBuff> followupResultsAfterDeathDate = followupResultBufferRepository.findByPatientIdAndDeathDateGreaterThan(targetPatientId, deathFollowupTime);
            /*followupResultsAfterDeathDate.forEach(beDeletedFollowupResult -> {
                LOGGER.info("将被删除的死亡日期后的随访结果");
            });*/
            for (FollowupResultBuff beDeletedFollowupResult : followupResultsAfterDeathDate)LOGGER.info("将被删除的死亡日期后的随访结果");
            followupResultBufferRepository.deleteInBatch(followupResultsAfterDeathDate);
        }
    }

    private void rollbackThatWasFlaggedMerged(List<FollowupResultBuff> flaggedResults) {
        for (FollowupResultBuff followupResult : flaggedResults){
       // flaggedResults.forEach(followupResult -> {
            followupResult.setMergeFlag(0);
            followupResult.setMergeFrom(null);
            followupResult.setMergeTarget(null);
            followupResult.setMergeTime(null);
        }
    }

    private void rollbackThatWasAppended2TargetPatient(List<FollowupResultBuff> mergedResults) {
        followupResultBufferRepository.deleteInBatch(mergedResults);
    }

}

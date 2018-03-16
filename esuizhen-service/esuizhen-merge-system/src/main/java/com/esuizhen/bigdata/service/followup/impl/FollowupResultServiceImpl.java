package com.esuizhen.bigdata.service.followup.impl;

import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.followup.*;
import com.esuizhen.bigdata.domain.mergebak.followup.FollowupResultBuffMergeBak;
import com.esuizhen.bigdata.domain.mergebak.followup.FollowupResultMergeBak;
import com.esuizhen.bigdata.domain.mergebak.followup.RFollowupTaskPatientMergeBak;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UUser;
import com.esuizhen.bigdata.merge.AbstractMergeBean;
import com.esuizhen.bigdata.repository.followup.*;
import com.esuizhen.bigdata.repository.user.PatientMergeRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.repository.user.UUserRepository;
import com.esuizhen.bigdata.service.followup.FollowupResultService;
import com.esuizhen.bigdata.utils.MathExtend;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fqc on 11/29/16.
 */
@Service
@Transactional
public class FollowupResultServiceImpl implements FollowupResultService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AbstractMergeBean.class);

    @Autowired
    FollowupResultRepository followupResultRepository;

    @Autowired
    FollowupResultMergeBakRepository followupResultMergeBakRepository;

    @Autowired
    private ConfGlobalRepository confGlobalRepository;

    @Autowired
    private VarPatientFollowupRepository varPatientFollowupRepository;

    @Autowired
    RFollowupTaskPatientRepository rFollowupTaskPatientRepository;

    @Autowired
    private FollowupTaskRepository followupTaskRepository;

    @Autowired
    private FollowupResultBufferRepository followupResultBufferRepository;

    @Autowired
    private RFollowupTaskPatientMergeBakRepository followupTaskPatientMergeBakRepository;

    @Autowired
    private FollowupResultBuffMergeBakRepository followupResultBuffMergeBakRepository;

    @Autowired
    private PatientMergeRepository patientMergeRepository;

    @Autowired
    private VarPatientFollowupRepository patientFollowupRepository;

    @Autowired
    private UPatientRepository patientRepository;

    @Autowired
    private UUserRepository userRepository;

    @Autowired
    private FollowupWayRepository followupWayRepository;

    @Autowired
    private FollowupResultValueRepository followupResultValueRepository;

    @Override
    public List<FollowupResult> findFollowupResult() {
        return followupResultRepository.findAll();
    }

    @Override
    public List<FollowupResult> findFollowupResultsOfTargetPatient(Long targetPatientId) {
        List<FollowupResult> followupResultsOfTargetPatient = followupResultRepository.findByPatientId(targetPatientId);
        return followupResultsOfTargetPatient;
    }

    public void updateSingleTaskForTargetPatient(Long targetPatientId, List<Long> otherPatientIds) {

        //为了合并同一任务,先备份目标患者的随访结果
        List<FollowupResult> followupResultsOfTargetPatient = followupResultRepository.findByPatientId(targetPatientId);
        backUpFollowupTargetPatient(followupResultsOfTargetPatient);
        List<FollowupResult> followupResultsOfOtherPatients = followupResultRepository.findByPatientIdIn(otherPatientIds);
        List<FollowupResult> followupResults = new ArrayList<>();
        followupResults.addAll(followupResultsOfOtherPatients);
                //Lists.newArrayList(followupResultsOfOtherPatients);
        followupResults.addAll(followupResultsOfTargetPatient);


        //按照优先级来找到最高的，对目标患者随访结果更新
        //List<FollowupResult> followupResultsOfOtherPatients = followupResultRepository;
        FollowupResult firstLevelOfFollowupResult = voteRetainedFollowupResultState(followupResults);
        long patientId = firstLevelOfFollowupResult.getPatientId();
        String followupTaskId = firstLevelOfFollowupResult.getFollowupTaskId();
        //查找到同一任务中的目标患者随访结果进行更新
        List<FollowupResult> theSpecificedResultOfTargetPatient = followupResultRepository.findByPatientIdAndFollowupTaskId(targetPatientId, followupTaskId);

        FollowupResult theSpecificTaskForTargetFollowupResult = theSpecificedResultOfTargetPatient.get(0);
        theSpecificTaskForTargetFollowupResult.setFollowupResultValue(firstLevelOfFollowupResult.getFollowupResultValue());
        theSpecificTaskForTargetFollowupResult.setFollowupTime(firstLevelOfFollowupResult.getFollowupTime());
        //theSpecificTaskForTargetFollowupResult.setFollowupResultId(firstLevelOfFollowupResult.getFollowupResultId());
        theSpecificTaskForTargetFollowupResult.setMergeFlag(1);
        theSpecificTaskForTargetFollowupResult.setMergeTime(TimeUtils.getCurrentTimestamp());

        followupResultRepository.save(theSpecificTaskForTargetFollowupResult);

        //state
        RFollowupTaskPatient rFollowupTaskPatient = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(followupTaskId, patientId);
        int state = rFollowupTaskPatient.getState();
        RFollowupTaskPatient rFollowupTaskPatientForTarget = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(followupTaskId, targetPatientId);
        rFollowupTaskPatientForTarget.setState(state);

    }

    @Override
    public void merge(Long targetPatientId, List<Long> otherPatientIds) {


        List<FollowupResult> followupResultsOfOtherPatients = followupResultRepository.findByPatientIdIn(otherPatientIds);

        appendOtherFollowupResults2TargetPatient(targetPatientId, followupResultsOfOtherPatients);
        flagOtherFollowupResults(targetPatientId, followupResultsOfOtherPatients);
        List<Long> allPatientIds=new ArrayList<>();

        allPatientIds.addAll(otherPatientIds);
        allPatientIds.add(targetPatientId);
        List<FollowupResult> fr=followupResultRepository.findByPatientIdInAndFollowupTaskIdIsNotNull(allPatientIds);
        boolean result=false;
        for (FollowupResult followupResult1: fr) {
            for (FollowupResult followupResult2: fr) {
                if(followupResult1.getFollowupTaskId().equals(followupResult2.getFollowupTaskId())&&
                        followupResult1.getPatientId()!=followupResult2.getPatientId()){
                    result=true;
                }
            }
        }
        if(result)
            updateSingleTaskForTargetPatient(targetPatientId, otherPatientIds);
    }

    private FollowupResult voteRetainedFollowupResultState(List<FollowupResult> followupResults) {
        // 查询对应的随访结果状态 为了保留{taskId:patientId}
        // FollowupResult
        // 根据voteFollowupResultStateLevel进行比较,选举出再该任务中的最小值
        //需要先设置下全局开关的内容
        Integer otherAsValidResultFlag = confGlobalRepository.findAll().get(0).getOtherAsValidResultFlag();

        //先将暂存与未完成设置好
        /*followupResults.forEach(followupResult -> {
            String followupTaskId = followupResult.getFollowupTaskId();
            long patientId = followupResult.getPatientId();
            RFollowupTaskPatient rfollowupTaskPatient = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(followupTaskId, patientId);
            if (rfollowupTaskPatient != null) {
                int state = rfollowupTaskPatient.getState();
                switch (state) {
                    case 1://暂存
                        followupResult.setVoteFollowupResultStateLevel(31);
                        break;
                    case 0://未完成
                        followupResult.setVoteFollowupResultStateLevel(41);
                        break;
                }
            }
        });*/
        for (FollowupResult followupResult : followupResults) {
            String followupTaskId = followupResult.getFollowupTaskId();
            long patientId = followupResult.getPatientId();
            RFollowupTaskPatient rfollowupTaskPatient = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(followupTaskId, patientId);
            if (rfollowupTaskPatient != null) {
                int state = rfollowupTaskPatient.getState();
                switch (state) {
                    case 1://暂存
                        followupResult.setVoteFollowupResultStateLevel(31);
                        break;
                    case 0://未完成
                        followupResult.setVoteFollowupResultStateLevel(41);
                        break;
                }
            }
        }
        for (FollowupResult followupResult : followupResults) {
        //followupResults.forEach(followupResult -> {
            long patientId = followupResult.getPatientId();
            String taskId = followupResult.getFollowupTaskId();
            LOGGER.info("patientId:{},taskId:{}", patientId, taskId);
            List<FollowupResult> tempFollowupResults = followupResultRepository.findByPatientIdAndFollowupTaskId(patientId, taskId);
            if (tempFollowupResults != null && tempFollowupResults.size() > 0) {
                MetaFollowupResultValue followupResultValue = tempFollowupResults.get(0).getMetaFollowupResultValueByFollowupResultValue();
                tempFollowupResults.get(0).setOtherAsValidResultFlag(otherAsValidResultFlag);
                Integer level = tempFollowupResults.get(0).getVoteFollowupResultStateLevel();
                VarPatientFollowup varPatientFollowup = varPatientFollowupRepository.findByPatientIdAndFollowupTaskId(patientId, taskId);
                followupResult.setLevel(level);
                if (varPatientFollowup != null) {
                    //followupResult.setLatestFollowupTime(varPatientFollowup.getLatestFollowupTime());
                }
                LOGGER.info(followupResultValue.toString());
            } else {
                VarPatientFollowup varPatientFollowup = varPatientFollowupRepository.findByPatientIdAndFollowupTaskId(patientId, taskId);
                followupResult.setLevel(9999);//因为随访结果为空，因此这里对应的肯定没有level喽，就设置的很低
                //rFollowupTaskPatient.setLevel(14);//测试统计的时候，时间的排序 测试通过，即如果level相等，按照时间降序排列
                //rFollowupTaskPatient.setLevel(12); 13vs12 测试也是ok的
                followupResult.setLatestFollowupTime("1970-01-01 00:00:00");//默认设置的时间非常远...
                if (varPatientFollowup != null) {
                    //followupResult.setLatestFollowupTime(varPatientFollowup.getLatestFollowupTime());
                }
            }
        }
        //});

        LOGGER.info("排序前{}", followupResults);
        /*followupResults.sort((o1, o2) -> {
            if (o1.getLevel() == o2.getLevel()) {
                //比较最近的随访时间
                //LOGGER.info("按照最近随访时间的排序->{}", varPatientFollowups);
                if (o1.getLatestFollowupTime() != null && o2.getLatestFollowupTime() != null) {
                    return o2.getLatestFollowupTime().compareTo(o1.getLatestFollowupTime());
                } else {
                    return 1;
                }
                //long patientId = varPatientFollowups.get(0).getPatientId();
            } else {
                return o1.getLevel().compareTo(o2.getLevel());
            }

        });*/
        Collections.sort(followupResults,new Comparator<FollowupResult>(){
            @Override
            public int compare(FollowupResult o1, FollowupResult o2) {
                if (o1.getLevel() == o2.getLevel()) {
                    //比较最近的随访时间
                    //LOGGER.info("按照最近随访时间的排序->{}", varPatientFollowups);
                    if (o1.getLatestFollowupTime() == null) {
                        return 1;
                    } else if (o2.getLatestFollowupTime() == null) {
                        return -1;
                    }else{
                        return o2.getLatestFollowupTime().compareTo(o1.getLatestFollowupTime());
                    }
                } else {
                    return o1.getLevel().compareTo(o2.getLevel());
                }
            }
        });
        LOGGER.info("排序后{}", followupResults);
        FollowupResult retainedResult = followupResults.get(0);
        LOGGER.info("同一任务中优先级高的 随访结果:{},随访时间:{},随访类型:{}"
                , retainedResult.getFollowupResultValue()
                , retainedResult.getFollowupTime()
                , retainedResult.getFollowupResultId());
        return retainedResult;
    }


    private void backUpFollowupTargetPatient(List<FollowupResult> followupResultsOfTargetPatient) {
        /*followupResultsOfTargetPatient.forEach(followupResult -> {
            FollowupResultMergeBak followupResultBak = new FollowupResultMergeBak();
            BeanUtils.copyProperties(followupResult, followupResultBak);
            followupResultBak.setMergeFlag(1);
            followupResultBak.setMergeTime(TimeUtils.getCurrentTimestamp());
            followupResultMergeBakRepository.save(followupResultBak);
        });*/
        for (FollowupResult followupResult : followupResultsOfTargetPatient) {
            FollowupResultMergeBak followupResultBak = new FollowupResultMergeBak();
            BeanUtils.copyProperties(followupResult, followupResultBak);
            followupResultBak.setMergeFlag(1);
            followupResultBak.setMergeTime(TimeUtils.getCurrentTimestamp());
            followupResultMergeBakRepository.save(followupResultBak);
        }
    }

    private void flagOtherFollowupResults(Long targetPatientId, List<FollowupResult> followupResultsOfOtherPatients) {
        /*followupResultsOfOtherPatients.forEach(otherFollowupResultBean -> {
            otherFollowupResultBean.setMergeFlag(2);
            otherFollowupResultBean.setMergeFrom(otherFollowupResultBean.getPatientId());
            otherFollowupResultBean.setMergeTarget(targetPatientId);
            otherFollowupResultBean.setMergeTime(TimeUtils.getCurrentTimestamp());
        });*/
        for (FollowupResult otherFollowupResultBean : followupResultsOfOtherPatients) {
            otherFollowupResultBean.setMergeFlag(2);
            otherFollowupResultBean.setMergeFrom(otherFollowupResultBean.getPatientId());
            otherFollowupResultBean.setMergeTarget(targetPatientId);
            otherFollowupResultBean.setMergeTime(TimeUtils.getCurrentTimestamp());
        }
    }

    private void appendOtherFollowupResults2TargetPatient(Long targetPatientId, List<FollowupResult> followupResultsOfOtherPatients) {

        List<FollowupResult> batchInsertBeans = new ArrayList<>();

        if (!followupResultsOfOtherPatients.isEmpty()) {
            for (FollowupResult source : followupResultsOfOtherPatients) {
                // followupResultsOfOtherPatients.forEach(source -> {
                FollowupResult append2TargetBean = new FollowupResult();
                BeanUtils.copyProperties(source, append2TargetBean, "followupResultId", "patientId");
                append2TargetBean.setPatientId(targetPatientId);
                append2TargetBean.setMergeFlag(1);
                append2TargetBean.setMergeFrom(source.getPatientId());
                append2TargetBean.setMergeTarget(targetPatientId);
                append2TargetBean.setMergeTime(TimeUtils.getCurrentTimestamp());
                List<FollowupResult> isExistedFollowupResult = followupResultRepository.findByPatientIdAndFollowupTaskId(targetPatientId, source.getFollowupTaskId());
                //List<FollowupResult> isExistedFollowupResult = followupResultRepository.findByPatientId(targetPatientId);
                if (isExistedFollowupResult == null) {//如果没有taskId-patientId的
                    batchInsertBeans.add(append2TargetBean);
                }
                if (source.getFollowupTaskId() == null) {//如果从别的库倒出来的,taskId为null，特殊处理
                    batchInsertBeans.add(append2TargetBean);
                }
            }
            //});
            followupResultRepository.save(batchInsertBeans);
        }

    }

    @Override
    public void rollback(Long targetPatientId) {
        //List<FollowupResult> mergedResults = followupResultRepository.findByMergeFlagAndMergeTarget(1, targetPatientId);
        //List<FollowupResult> flaggedResults = followupResultRepository.findByMergeFlagAndMergeTarget(2, targetPatientId);
        //rollbackThatWasAppended2TargetPatient(mergedResults);
        //rollbackThatWasFlaggedMerged(flaggedResults);
       /* List<FollowupResult> followupResults = followupResultRepository.findByMergeTarget(targetPatientId);
        followupResults.forEach(o1 -> {
            FollowupResult followupResult=followupResultRepository.findByMergeTargetAndMergeFromAndMergeFlagAndFollowupTaskId(targetPatientId,targetPatientId,2,o1.getFollowupTaskId());
            if(followupResult!=null&&!followupResult.getFollowupResultId().equals(o1.getFollowupResultId())){
                FollowupResult followupResult1=new FollowupResult();
                BeanUtils.copyProperties(o1,followupResult1);

                BeanUtils.copyProperties(followupResult,o1,"followupResultId","patientId");
                o1.setMergeFlag(0);
                o1.setMergeTime(null);
                o1.setMergeFrom(null);
                o1.setMergeTarget(null);
                followupResultRepository.save(o1);

                followupResult1.setMergeFlag(0);
                followupResult1.setFollowupResultId(followupResult.getFollowupResultId());
                followupResult1.setPatientId(followupResult.getPatientId());
                followupResult1.setMergeFlag(0);
                followupResult1.setMergeTime(null);
                followupResult1.setMergeFrom(null);
                followupResult1.setMergeTarget(null);
                followupResultRepository.save(followupResult1);

            }else{
                o1.setPatientId(o1.getMergeFrom());
                o1.setMergeFlag(0);
                o1.setMergeTarget(null);
                o1.setMergeFrom(null);
                o1.setMergeTime(null);
                followupResultRepository.save(o1);
            }
        });*/
        //List<FollowupResult> mergedResults = followupResultRepository.findByMergeFlagAndMergeTarget(1, targetPatientId);
        //List<FollowupResult> flaggedResults = followupResultRepository.findByMergeFlagAndMergeTarget(2, targetPatientId);
        //rollbackThatWasAppended2TargetPatient(mergedResults);
        //rollbackThatWasFlaggedMerged(flaggedResults);
        /*List<FollowupResult> followupResults = followupResultRepository.findByMergeTarget(targetPatientId);
        followupResults.forEach(o1 -> {
            FollowupResult followupResult=followupResultRepository.findByMergeTargetAndMergeFromAndMergeFlagAndFollowupTaskId(targetPatientId,targetPatientId,2,o1.getFollowupTaskId());
            if(followupResult!=null&&followupResult.getFollowupResultId().equals(o1.getFollowupResultId())){
                    if(followupResult.getMergeTime().after(followupResult.getFollowupTime())) {
                        FollowupResult followupResult1 = new FollowupResult();
                        BeanUtils.copyProperties(o1, followupResult1);

                        List<FollowupResult> followupResults1=followupResultRepository.findByPatientIdAndFollowupTaskId(targetPatientId,o1.getFollowupTaskId());
                        FollowupResult followupResult2=followupResults1.get(0);
                        BeanUtils.copyProperties(followupResult2, o1, "followupResultId", "patientId");
                        o1.setMergeFlag(0);
                        o1.setMergeTime(null);
                        o1.setMergeFrom(null);
                        o1.setMergeTarget(null);
                        followupResultRepository.save(o1);

                        BeanUtils.copyProperties(followupResult1,followupResult2,"followupResultId", "patientId");
                        followupResult2.setMergeFlag(0);
                        //followupResult2.setFollowupResultId(followupResult.getFollowupResultId());
                        //followupResult2.setPatientId(followupResult.getPatientId());
                        followupResult2.setMergeFlag(0);
                        followupResult2.setMergeTime(null);
                        followupResult2.setMergeFrom(null);
                        followupResult2.setMergeTarget(null);
                        followupResultRepository.save(followupResult2);
                    }else{
                        o1.setMergeFlag(0);
                        o1.setMergeTime(null);
                        o1.setMergeFrom(null);
                        o1.setMergeTarget(null);
                        followupResultRepository.save(o1);

                        followupResult.setMergeFlag(0);
                        followupResult.setMergeTime(null);
                        followupResult.setMergeFrom(null);
                        followupResult.setMergeTarget(null);
                        followupResultRepository.save(followupResult);

                    }
            }else{
                if(o1.getMergeFrom()!=null){
                    if(followupResult!=null){
                        if(o1.getPatientId()!=followupResult.getMergeFrom()){
                            o1.setPatientId(o1.getMergeFrom());
                            o1.setMergeFlag(0);
                            o1.setMergeTarget(null);
                            o1.setMergeFrom(null);
                            o1.setMergeTime(null);
                            followupResultRepository.save(o1);
                        }
                    }else{
                        o1.setPatientId(o1.getMergeFrom());
                        o1.setMergeFlag(0);
                        o1.setMergeTarget(null);
                        o1.setMergeFrom(null);
                        o1.setMergeTime(null);
                        followupResultRepository.save(o1);
                    }
                }
            }
        });*/

        List<FollowupResult> followupResults = followupResultRepository.findByMergeTarget(targetPatientId);
        //followupResults.forEach(o1 -> {
        for (FollowupResult o1 : followupResults) {
            FollowupResult followupResult = followupResultRepository.findByMergeTargetAndMergeFromAndFollowupTaskId(targetPatientId, targetPatientId, o1.getFollowupTaskId());
            if (followupResult != null && followupResult.getPatientId() == o1.getPatientId()) {
                FollowupResultMergeBak followupResultMergeBak = followupResultMergeBakRepository.findByFollowupResultId(o1.getFollowupResultId());
                if (followupResult.getMergeTime().after(followupResult.getFollowupTime())) {
                    if (followupResultMergeBak != null) {
                        BeanUtils.copyProperties(followupResultMergeBak, o1);
                        followupResultRepository.save(o1);
                    } else {
                        followupResultRepository.delete(o1);
                    }
                } else {
                    o1.setMergeFlag(0);
                    o1.setMergeTarget(null);
                    o1.setMergeFrom(null);
                    o1.setMergeTime(null);
                    followupResultRepository.save(o1);
                }
                if (followupResultMergeBak != null) {
                    followupResultMergeBakRepository.delete(followupResultMergeBak);
                }
            } else {
                o1.setPatientId(o1.getMergeFrom());
                o1.setMergeFlag(0);
                o1.setMergeTime(null);
                o1.setMergeFrom(null);
                o1.setMergeTarget(null);
                followupResultRepository.save(o1);
            }
        }
        //});
    }

    @Override
    public List<FollowupResult> findDeathRecord(Long targetPatientId) {
        List<FollowupResult> deathRecords = followupResultRepository.findByPatientIdAndFollowupResultValueOrderByDeathDateAsc(targetPatientId, 4);
        return deathRecords;
    }

    @Override
    public void batchUpdateResultValue(List<FollowupResult> followupResultsOfTargetPatient, Integer resultValue) {
        /*followupResultsOfTargetPatient.forEach(targetPatient -> {
            targetPatient.setFollowupResultValue(resultValue);
        });*/
        for (FollowupResult targetPatient : followupResultsOfTargetPatient){
            targetPatient.setFollowupResultValue(resultValue);
        }
    }

    @Override
    public List<FollowupResult> findLostFollowupFlagBean(List<Long> mergeGroupId, Integer flag) {
        return followupResultRepository.findByLostFollowupFlagAndPatientIdIn(flag, mergeGroupId);
    }

    @Override
    public void save(List<FollowupResult> followupResults) {
        if (followupResults != null && (!followupResults.isEmpty())) {
            followupResultRepository.save(followupResults);
        }
    }

    @Override
    public void deleteFollowupResultAfterDeathDate(Long targetPatientId) {
        FollowupResult followupResult = followupResultRepository.findByPatientIdAndDeathDateIsNotNull(targetPatientId);
        if (followupResult == null) {
            LOGGER.info("没有死亡日期之后的随访记录");
            return;
        }
        Date deathDate = followupResult.getDeathDate();
        List<FollowupResult> followupResultsAfterDeathDate = followupResultRepository.findByPatientIdAndDeathDateGreaterThan(targetPatientId, deathDate);
        /*followupResultsAfterDeathDate.forEach(beDeletedFollowupResult -> {
            LOGGER.info("将被删除的死亡日期后的随访结果");
        });*/
        for (FollowupResult beDeletedFollowupResult : followupResultsAfterDeathDate) {
            LOGGER.info("将被删除的死亡日期后的随访结果");
        }
        followupResultRepository.deleteInBatch(followupResultsAfterDeathDate);
    }

    @Override
    public void deleteFollowupResultAfterSpecificDeathDate(Long targetPatientId, Long retainPatientId) {
        //查询出选择保留患者的死亡随访记录
        List<FollowupResult> followupResultsOfRetainPatient = followupResultRepository.
                findByPatientIdAndFollowupResultValueAndDeathDateIsNotNullOrderByDeathDateAsc(retainPatientId, 4);
        if (followupResultsOfRetainPatient != null && followupResultsOfRetainPatient.size() > 0) {
            FollowupResult retainFollowupResult = followupResultsOfRetainPatient.get(0);
            Date deathFollowupTime = retainFollowupResult.getDeathDate();

            List<FollowupResult> followupResultsAfterDeathDate = followupResultRepository.findByPatientIdAndDeathDateGreaterThan(targetPatientId, deathFollowupTime);
            /*followupResultsAfterDeathDate.forEach(beDeletedFollowupResult -> {
                LOGGER.info("将被删除的死亡日期后的随访结果");
            });*/
            for (FollowupResult beDeletedFollowupResult : followupResultsAfterDeathDate) {
                LOGGER.info("将被删除的死亡日期后的随访结果");
            }
            followupResultRepository.deleteInBatch(followupResultsAfterDeathDate);
        }

    }

    private void rollbackThatWasFlaggedMerged(List<FollowupResult> flaggedResults) {
        /*flaggedResults.forEach(followupResult -> {
            followupResult.setMergeFlag(0);
            followupResult.setMergeFrom(null);
            followupResult.setMergeTarget(null);
            followupResult.setMergeTime(null);
        });*/
        for (FollowupResult followupResult : flaggedResults) {
            followupResult.setMergeFlag(0);
            followupResult.setMergeFrom(null);
            followupResult.setMergeTarget(null);
            followupResult.setMergeTime(null);
        }
    }

    private void rollbackThatWasAppended2TargetPatient(List<FollowupResult> mergedResults) {

        followupResultRepository.deleteInBatch(mergedResults);
    }

    @Override
    public void mergeFollowupResult(Long targetPatientId, List<Long> otherPatientIds, Long retainPatientId) {
        String followupResultId=null;
        if(retainPatientId!=null){
            FollowupResult followupResult=followupResultRepository.findByPatientIdAndFollowupResultValue(retainPatientId,4);
            followupResultId=followupResult.getFollowupResultId();
            //死亡随访结果处理
            List<Long> patientIds1=new ArrayList<>();
            patientIds1.add(targetPatientId);
            patientIds1.addAll(otherPatientIds);
            final List<FollowupResult> followupResults1=followupResultRepository.findByPatientIdInAndFollowupResultValue(patientIds1,4);
            //followupResults1.forEach(o -> {
            for (FollowupResult o : followupResults1) {
                if (!retainPatientId.equals(o.getPatientId())) {
                    o.setMergeFlag(2);
                    o.setMergeFrom(o.getPatientId());
                    o.setMergeTarget(targetPatientId);
                    o.setMergeTime(TimeUtils.getCurrentTimestamp());
                    followupResultRepository.save(o);

                    if (o.getFollowupTaskId() != null) {
                        //合并任务患者表
                        RFollowupTaskPatient followupTaskPatient = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(o.getFollowupTaskId(), o.getPatientId());
                        followupTaskPatient.setMergeFlag(2);
                        followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                        followupTaskPatient.setMergeFrom(followupTaskPatient.getPatientId());
                        followupTaskPatient.setMergeTarget(targetPatientId);
                        rFollowupTaskPatientRepository.save(followupTaskPatient);

                        //合并随访Buff表
                        List<FollowupResultBuff> followupResultBuffs = followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o.getPatientId(), o.getFollowupTaskId());
                        for (FollowupResultBuff o1 : followupResultBuffs) {
                            //followupResultBuffs.forEach(o1 -> {
                            o1.setMergeFlag(2);
                            o1.setMergeFrom(o1.getPatientId());
                            o1.setMergeTarget(targetPatientId);
                            o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                            followupResultBufferRepository.save(o1);
                        }
                    }
                }
            }

            //死亡时间后的目标患者的随访结果处理
            if(followupResult.getDeathDate()!=null) {
                final List<FollowupResult> followupResults = followupResultRepository.findAllByPatientIdInAndFollowupResultValueNotAndFollowupTimeGreaterThan(patientIds1, 4, followupResult.getDeathDate());
                //followupResults.forEach(o ->{
                for (FollowupResult o : followupResults) {
                    if (o.getFollowupResultValue() != 15 && o.getFollowupResultValue() != 16) {
                        o.setMergeFlag(2);
                        o.setMergeTime(TimeUtils.getCurrentTimestamp());
                        o.setMergeFrom(o.getPatientId());
                        o.setMergeTarget(targetPatientId);
                        followupResultRepository.save(o);

                        if (o.getFollowupTaskId() != null) {
                            RFollowupTaskPatient followupTaskPatient = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(o.getFollowupTaskId(), o.getPatientId());
                            followupTaskPatient.setMergeFlag(2);
                            followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                            followupTaskPatient.setMergeFrom(followupTaskPatient.getPatientId());
                            followupTaskPatient.setMergeTarget(targetPatientId);
                            rFollowupTaskPatientRepository.save(followupTaskPatient);
                            //合并随访Buff表
                            List<FollowupResultBuff> followupResultBuffs = followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o.getPatientId(), o.getFollowupTaskId());
                            for (FollowupResultBuff o1 : followupResultBuffs) {
                                o1.setMergeFlag(2);
                                o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                o1.setMergeTarget(targetPatientId);
                                o1.setMergeFrom(o1.getPatientId());
                                followupResultBufferRepository.save(o1);
                            }
                        }
                    }
                }
                //followupResultRepository.save(followupResults);
            }
            //死亡时间前被合并患者的随访信息合并到目标患者
            List<FollowupResult> otherFollowupResults=followupResultRepository.findAllByPatientIdInAndMergeTargetIsNull(otherPatientIds);
            this.mergeFollowupList(otherFollowupResults,targetPatientId,otherPatientIds);



        }else{//没有多个死亡日期时
            List<FollowupResult> otherFollowupResults=followupResultRepository.findByPatientIdIn(otherPatientIds);
            this.mergeFollowupList(otherFollowupResults,targetPatientId,otherPatientIds);
        }
        //处理没有随访结果的任务并且患者id在otherPatientIds中
        List<RFollowupTaskPatient> followupTaskPatients=rFollowupTaskPatientRepository.findByPatientIdInAndMergeTargetIsNull(otherPatientIds);
        for (RFollowupTaskPatient o1 : followupTaskPatients) {
            RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(o1.getFollowupTaskId(),targetPatientId);
            if(followupTaskPatient!=null){
                o1.setMergeFlag(2);
                o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                o1.setMergeFrom(o1.getPatientId());
                o1.setMergeTarget(targetPatientId);
                rFollowupTaskPatientRepository.save(o1);

                //合并随访Buff表
                List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());
                for (FollowupResultBuff o2 : followupResultBuffs) {
                    o2.setMergeFlag(2);
                    o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                    o2.setMergeFrom(o2.getPatientId());
                    o2.setMergeTarget(targetPatientId);
                    followupResultBufferRepository.save(o2);
                }
            }else{
                o1.setMergeFlag(1);
                o1.setMergeFrom(o1.getPatientId());
                o1.setMergeTarget(targetPatientId);
                o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                o1.setPatientId(targetPatientId);
                rFollowupTaskPatientRepository.save(o1);

                //合并随访Buff表
                List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());
                for (FollowupResultBuff o2 : followupResultBuffs) {
                    o2.setMergeFlag(1);
                    o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                    o2.setMergeFrom(o2.getPatientId());
                    o2.setMergeTarget(targetPatientId);
                    o2.setPatientId(targetPatientId);
                    followupResultBufferRepository.save(o2);
                }

            }
        }

        //处理随访Buff中没有任务Id的结果
        List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdInAndFollowupTaskIdIsNull(otherPatientIds);
        for (FollowupResultBuff o2 : followupResultBuffs) {
            o2.setMergeFlag(1);
            o2.setMergeTarget(targetPatientId);
            o2.setMergeFrom(o2.getPatientId());
            o2.setMergeTime(TimeUtils.getCurrentTimestamp());
            o2.setPatientId(targetPatientId);
        }
        followupResultBufferRepository.save(followupResultBuffs);

        //随访结果去重
        mergeRepeatFollowup(targetPatientId);

        //随访Buff中对死亡结果去重
        mergeDeathFollowupResult(targetPatientId,retainPatientId,followupResultId);
    }

    private void mergeFollowupList(List<FollowupResult> otherFollowupResults,Long targetPatientId,List<Long> otherPatientIds){
        for (FollowupResult o : otherFollowupResults) {
        //otherFollowupResults.forEach((FollowupResult o) -> {
            FollowupResult ft1=followupResultRepository.findByFollowupResultIdAndMergeTargetIsNull(o.getFollowupResultId());
            //判断是否已经合并
            if(ft1!=null) {
                //判断是否是任务中的随访结果
                if (o.getFollowupTaskId() != null) {
                    List<Long> pids = new ArrayList<>();
                    pids.add(targetPatientId);
                    pids.addAll(otherPatientIds);
                    List<FollowupResult> sameFollowupResults = followupResultRepository.findByPatientIdInAndFollowupTaskIdAndMergeTargetIsNull(pids, o.getFollowupTaskId());
                    //判断是否是同一任务中的
                    if (sameFollowupResults != null && sameFollowupResults.size() > 1) {
                        //其他情况是否作为有效随访结果查询
                        List<ConfGlobal> list = confGlobalRepository.findAll();
                        int result = list.get(0).getOtherAsValidResultFlag();
                        List<Integer> values=getPriorityResult(result);
                        FollowupResult ft = getFirstFollowupResult(sameFollowupResults, values);
                        //判断选出的优先值是否是目标患者的随访结果，若是则其他的直接删除（即将mergeFlag标记为2）
                        if(targetPatientId.equals(ft.getPatientId())){
                            for (FollowupResult o1 : sameFollowupResults) {
                                if (!targetPatientId.equals(o1.getPatientId())) {
                                    o1.setMergeFlag(2);
                                    o1.setMergeTarget(targetPatientId);
                                    o1.setMergeFrom(o1.getPatientId());
                                    o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                    followupResultRepository.save(o1);
                                }
                            }
                            //合并任务患者表
                            List<RFollowupTaskPatient> followupTaskPatients=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdInAndMergeTargetIsNull(o.getFollowupTaskId(),pids);
                            for (RFollowupTaskPatient o1 : followupTaskPatients) {
                                if (!targetPatientId.equals(o1.getPatientId())) {
                                    o1.setMergeFlag(2);
                                    o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                    o1.setMergeFrom(o1.getPatientId());
                                    o1.setMergeTarget(targetPatientId);

                                    //合并随访Buff表
                                    List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());
                                    for (FollowupResultBuff o2 : followupResultBuffs) {
                                        o2.setMergeFlag(2);
                                        o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        o2.setMergeFrom(o2.getPatientId());
                                        o2.setMergeTarget(targetPatientId);
                                        followupResultBufferRepository.save(o2);
                                    }
                                }
                            }
                        }else{
                            //同一任务中选出的优先结果不是目标患者：
                            // 判断任务是否结束  1，如果已经结束并且的则需要备份以便撤销（目前使用替换的方式进行备份）
                            //                 2, 如果正在随访则直接覆盖目标患者（不用考虑撤销）
                            FollowupTask followupTask = followupTaskRepository.findByFollowupTaskId(o.getFollowupTaskId());
                            if(followupTask.getState() == 2){
                                boolean result1=false;
                                for(FollowupResult o1 : sameFollowupResults){
                                    if (targetPatientId.equals(o1.getPatientId())) {
                                        result1=true;

                                        //备份随访结果
                                        FollowupResultMergeBak followupResultMergeBak=new FollowupResultMergeBak();
                                        BeanUtils.copyProperties(o1, followupResultMergeBak);
                                        followupResultMergeBakRepository.save(followupResultMergeBak);

                                        //备份随访任务表
                                        RFollowupTaskPatientMergeBak followupTaskPatientMergeBak=new RFollowupTaskPatientMergeBak();
                                        RFollowupTaskPatient targetfollowupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(o1.getFollowupTaskId(),o1.getPatientId());
                                        BeanUtils.copyProperties(targetfollowupTaskPatient,followupTaskPatientMergeBak);
                                        followupTaskPatientMergeBakRepository.save(followupTaskPatientMergeBak);

                                        //备份随访Buff表
                                        FollowupResultBuffMergeBak followupResultBuffMergeBak=new FollowupResultBuffMergeBak();
                                        FollowupResultBuff followupResultBuff=followupResultBufferRepository.findByFollowupResultId(o1.getFollowupResultId());
                                        BeanUtils.copyProperties(followupResultBuff,followupResultBuffMergeBak);
                                        followupResultBuffMergeBakRepository.save(followupResultBuffMergeBak);

                                        //更新随访Buff
                                        followupResultBuff.setFollowupResultId(null);
                                        followupResultBuff.setMergeFlag(1);
                                        followupResultBuff.setMergeFrom(targetPatientId);
                                        followupResultBuff.setMergeTarget(targetPatientId);
                                        followupResultBuff.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultBufferRepository.save(followupResultBuff);

                                        //将ft结果复制到目标患者
                                        FollowupResult followupResult1 = new FollowupResult();
                                        BeanUtils.copyProperties(ft, o1, "followupResultId", "patientId");
                                        o1.setMergeFlag(1);
                                        o1.setMergeTarget(targetPatientId);
                                        o1.setMergeFrom(targetPatientId);
                                        o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultRepository.save(o1);

                                        //ft结果删除
                                        ft.setMergeFlag(2);
                                        ft.setMergeTarget(targetPatientId);
                                        ft.setMergeFrom(ft.getPatientId());
                                        ft.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultRepository.save(ft);

                                        RFollowupTaskPatient followupTaskPatient1=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(ft.getFollowupTaskId(),ft.getPatientId());
                                        //将任务复制到目标患者
                                        BeanUtils.copyProperties(followupTaskPatient1,targetfollowupTaskPatient,"id","patientId");
                                        targetfollowupTaskPatient.setMergeFlag(1);
                                        targetfollowupTaskPatient.setMergeTarget(targetPatientId);
                                        targetfollowupTaskPatient.setMergeFrom(targetPatientId);
                                        targetfollowupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        rFollowupTaskPatientRepository.save(targetfollowupTaskPatient);

                                        //ft任务结果删除
                                        followupTaskPatient1.setMergeFlag(2);
                                        followupTaskPatient1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupTaskPatient1.setMergeFrom(followupTaskPatient1.getPatientId());
                                        followupTaskPatient1.setMergeTarget(targetPatientId);
                                        rFollowupTaskPatientRepository.save(followupTaskPatient1);

                                        //合并随访Buff表
                                        List<FollowupResultBuff> otherFollowupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(ft.getPatientId(),ft.getFollowupTaskId());

                                        for (FollowupResultBuff o2 : otherFollowupResultBuffs) {
                                        //otherFollowupResultBuffs.forEach(o2 -> {
                                            if(o2.getFollowupResultId()!=null){
                                                FollowupResultBuffMergeBak followupResultBuffMergeBak1=new FollowupResultBuffMergeBak();
                                                BeanUtils.copyProperties(o2,followupResultBuffMergeBak1);
                                                followupResultBuffMergeBakRepository.save(followupResultBuffMergeBak1);
                                                o2.setFollowupResultId(o1.getFollowupResultId());
                                            }
                                            o2.setMergeFlag(1);
                                            o2.setMergeFrom(o2.getPatientId());
                                            o2.setPatientId(targetPatientId);
                                            o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            o2.setMergeTarget(targetPatientId);
                                            followupResultBufferRepository.save(o2);
                                        }

                                    } else {
                                        if(ft.getPatientId()!=o1.getPatientId()){
                                            o1.setMergeFlag(2);
                                            o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            o1.setMergeTarget(targetPatientId);
                                            o1.setMergeFrom(o1.getPatientId());
                                            followupResultRepository.save(o1);

                                            //合并任务患者表
                                            RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(o1.getFollowupTaskId(),o1.getPatientId());
                                            followupTaskPatient.setMergeFlag(2);
                                            followupTaskPatient.setMergeTarget(targetPatientId);
                                            followupTaskPatient.setMergeFrom(o1.getPatientId());
                                            followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            rFollowupTaskPatientRepository.save(followupTaskPatient);

                                            //合并随访Buff表
                                            List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());

                                            for (FollowupResultBuff o2 : followupResultBuffs) {
                                                o2.setMergeFlag(2);
                                                o2.setMergeFrom(o2.getPatientId());
                                                o2.setMergeTarget(targetPatientId);
                                                o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                                followupResultBufferRepository.save(o2);
                                            }
                                        }
                                    }
                                }
                                //如果任务中没有目标患者
                                if(!result1){
                                    ft.setMergeFlag(1);
                                    ft.setMergeTime(TimeUtils.getCurrentTimestamp());
                                    ft.setMergeFrom(ft.getPatientId());
                                    ft.setMergeTarget(targetPatientId);
                                    ft.setPatientId(targetPatientId);
                                    followupResultRepository.save(ft);

                                    //合并任务患者表
                                    RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(ft.getFollowupTaskId(),ft.getPatientId());
                                    followupTaskPatient.setMergeFlag(1);
                                    followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                    followupTaskPatient.setMergeFrom(ft.getPatientId());
                                    followupTaskPatient.setMergeTarget(targetPatientId);
                                    followupTaskPatient.setPatientId(targetPatientId);
                                    rFollowupTaskPatientRepository.save(followupTaskPatient);

                                    //合并随访Buff表
                                    List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(ft.getPatientId(),ft.getFollowupTaskId());

                                    for (FollowupResultBuff o2 : followupResultBuffs) {
                                        o2.setMergeFlag(1);
                                        o2.setMergeFrom(o2.getPatientId());
                                        o2.setPatientId(targetPatientId);
                                        o2.setMergeTarget(targetPatientId);
                                        o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultBufferRepository.save(o2);
                                    }

                                }
                            }else{//需求改后多余的判断，暂时先这样吧
                                boolean result1=false;
                                for(FollowupResult o1 : sameFollowupResults){
                                    if (targetPatientId.equals(o1.getPatientId())) {
                                        result1=true;

                                        //备份随访结果
                                        FollowupResultMergeBak followupResultMergeBak=new FollowupResultMergeBak();
                                        BeanUtils.copyProperties(o1, followupResultMergeBak);
                                        followupResultMergeBakRepository.save(followupResultMergeBak);

                                        //备份随访任务表
                                        RFollowupTaskPatientMergeBak followupTaskPatientMergeBak=new RFollowupTaskPatientMergeBak();
                                        RFollowupTaskPatient targetfollowupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(o1.getFollowupTaskId(),o1.getPatientId());
                                        BeanUtils.copyProperties(targetfollowupTaskPatient,followupTaskPatientMergeBak);
                                        followupTaskPatientMergeBakRepository.save(followupTaskPatientMergeBak);

                                        //将ft结果复制到目标患者
                                        FollowupResult followupResult1 = new FollowupResult();
                                        BeanUtils.copyProperties(ft, o1, "followupResultId", "patientId");
                                        o1.setMergeFlag(1);
                                        o1.setMergeTarget(targetPatientId);
                                        o1.setMergeFrom(targetPatientId);
                                        o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultRepository.save(o1);

                                        //备份随访Buff表
                                        FollowupResultBuffMergeBak followupResultBuffMergeBak=new FollowupResultBuffMergeBak();
                                        FollowupResultBuff followupResultBuff=followupResultBufferRepository.findByFollowupResultId(o1.getFollowupResultId());
                                        BeanUtils.copyProperties(followupResultBuff,followupResultBuffMergeBak);
                                        followupResultBuffMergeBakRepository.save(followupResultBuffMergeBak);

                                        //更新随访Buff
                                        followupResultBuff.setFollowupResultId(null);
                                        followupResultBuff.setMergeFlag(1);
                                        followupResultBuff.setMergeFrom(targetPatientId);
                                        followupResultBuff.setMergeTarget(targetPatientId);
                                        followupResultBuff.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultBufferRepository.save(followupResultBuff);

                                        //ft结果删除
                                        ft.setMergeFlag(2);
                                        ft.setMergeTarget(targetPatientId);
                                        ft.setMergeFrom(ft.getPatientId());
                                        ft.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultRepository.save(ft);

                                        RFollowupTaskPatient followupTaskPatient1=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(ft.getFollowupTaskId(),ft.getPatientId());
                                        //将任务复制到目标患者
                                        BeanUtils.copyProperties(followupTaskPatient1,targetfollowupTaskPatient,"id","patientId");
                                        targetfollowupTaskPatient.setMergeFlag(1);
                                        targetfollowupTaskPatient.setMergeTarget(targetPatientId);
                                        targetfollowupTaskPatient.setMergeFrom(targetPatientId);
                                        targetfollowupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        rFollowupTaskPatientRepository.save(targetfollowupTaskPatient);

                                        //ft任务结果删除
                                        followupTaskPatient1.setMergeFlag(2);
                                        followupTaskPatient1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupTaskPatient1.setMergeFrom(followupTaskPatient1.getPatientId());
                                        followupTaskPatient1.setMergeTarget(targetPatientId);
                                        rFollowupTaskPatientRepository.save(followupTaskPatient1);

                                        //合并随访Buff表
                                        List<FollowupResultBuff> otherFollowupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(ft.getPatientId(),ft.getFollowupTaskId());

                                        for (FollowupResultBuff o2 : otherFollowupResultBuffs) {
                                            if(o2.getFollowupResultId()!=null){
                                                FollowupResultBuffMergeBak followupResultBuffMergeBak1=new FollowupResultBuffMergeBak();
                                                BeanUtils.copyProperties(o2,followupResultBuffMergeBak1);
                                                followupResultBuffMergeBakRepository.save(followupResultBuffMergeBak1);
                                                o2.setFollowupResultId(o1.getFollowupResultId());
                                            }
                                            o2.setMergeFlag(1);
                                            o2.setMergeFrom(o2.getPatientId());
                                            o2.setPatientId(targetPatientId);
                                            o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            o2.setMergeTarget(targetPatientId);
                                            followupResultBufferRepository.save(o2);
                                        }

                                    } else {
                                        if(ft.getPatientId()!=o1.getPatientId()){
                                            o1.setMergeFlag(2);
                                            o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            o1.setMergeTarget(targetPatientId);
                                            o1.setMergeFrom(o1.getPatientId());
                                            followupResultRepository.save(o1);

                                            //合并任务患者表
                                            RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(o1.getFollowupTaskId(),o1.getPatientId());
                                            followupTaskPatient.setMergeFlag(2);
                                            followupTaskPatient.setMergeTarget(targetPatientId);
                                            followupTaskPatient.setMergeFrom(o1.getPatientId());
                                            followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            rFollowupTaskPatientRepository.save(followupTaskPatient);

                                            //合并随访Buff表
                                            List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());

                                            for (FollowupResultBuff o2 : followupResultBuffs) {
                                                o2.setMergeFlag(2);
                                                o2.setMergeFrom(o2.getPatientId());
                                                o2.setMergeTarget(targetPatientId);
                                                o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                                followupResultBufferRepository.save(o2);
                                            }
                                        }
                                    }
                                }
                                //如果任务中没有目标患者
                                if(!result1){
                                    RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(ft.getFollowupTaskId(),targetPatientId);
                                    if(followupTaskPatient!=null){

                                        //备份随访任务表
                                        RFollowupTaskPatientMergeBak followupTaskPatientMergeBak=new RFollowupTaskPatientMergeBak();
                                        BeanUtils.copyProperties(followupTaskPatient,followupTaskPatientMergeBak);
                                        followupTaskPatientMergeBakRepository.save(followupTaskPatientMergeBak);

                                        //将ft结果复制到目标患者
                                        FollowupResult followupResult1 = new FollowupResult();
                                        BeanUtils.copyProperties(ft, followupResult1, "followupResultId", "patientId");
                                        followupResult1.setMergeFlag(1);
                                        followupResult1.setMergeTarget(targetPatientId);
                                        followupResult1.setMergeFrom(targetPatientId);
                                        followupResult1.setFollowupResultId(GeneralUtil.generateUniqueID("RESU"));
                                        followupResult1.setPatientId(targetPatientId);
                                        followupResult1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultRepository.save(followupResult1);

                                        //ft结果删除
                                        ft.setMergeFlag(2);
                                        ft.setMergeTarget(targetPatientId);
                                        ft.setMergeFrom(ft.getPatientId());
                                        ft.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultRepository.save(ft);


                                        RFollowupTaskPatient ftTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(ft.getFollowupTaskId(),ft.getPatientId());

                                        //将任务复制到目标患者
                                        BeanUtils.copyProperties(ftTaskPatient,followupTaskPatient,"id","patientId");
                                        followupTaskPatient.setMergeFlag(1);
                                        followupTaskPatient.setMergeTarget(targetPatientId);
                                        followupTaskPatient.setMergeFrom(targetPatientId);
                                        followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        rFollowupTaskPatientRepository.save(followupTaskPatient);

                                        //ft任务结果删除
                                        ftTaskPatient.setMergeFlag(2);
                                        ftTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        ftTaskPatient.setMergeFrom(ftTaskPatient.getPatientId());
                                        ftTaskPatient.setMergeTarget(targetPatientId);
                                        rFollowupTaskPatientRepository.save(ftTaskPatient);

                                        //合并随访Buff表
                                        List<FollowupResultBuff> otherFollowupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(ft.getPatientId(),ft.getFollowupTaskId());

                                        for (FollowupResultBuff o2 : otherFollowupResultBuffs) {
                                            if(o2.getFollowupResultId()!=null){
                                                FollowupResultBuffMergeBak followupResultBuffMergeBak1=new FollowupResultBuffMergeBak();
                                                BeanUtils.copyProperties(o2,followupResultBuffMergeBak1);
                                                followupResultBuffMergeBakRepository.save(followupResultBuffMergeBak1);
                                                o2.setFollowupResultId(followupResult1.getFollowupResultId());
                                            }
                                            o2.setMergeFlag(1);
                                            o2.setMergeFrom(o2.getPatientId());
                                            o2.setPatientId(targetPatientId);
                                            o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            o2.setMergeTarget(targetPatientId);
                                            followupResultBufferRepository.save(o2);
                                        }

                                    }else{
                                        ft.setMergeFrom(ft.getPatientId());
                                        ft.setMergeTarget(targetPatientId);
                                        ft.setPatientId(targetPatientId);
                                        ft.setMergeFlag(1);
                                        ft.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupResultRepository.save(ft);

                                        //合并任务患者表
                                        RFollowupTaskPatient ftTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(ft.getFollowupTaskId(),ft.getPatientId());
                                        ftTaskPatient.setMergeFlag(1);
                                        ftTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        ftTaskPatient.setMergeTarget(targetPatientId);
                                        ftTaskPatient.setPatientId(targetPatientId);
                                        ftTaskPatient.setMergeFrom(ft.getPatientId());
                                        rFollowupTaskPatientRepository.save(ftTaskPatient);

                                        //合并随访Buff表
                                        List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(ft.getPatientId(),ft.getFollowupTaskId());

                                        for (FollowupResultBuff o2 : followupResultBuffs) {
                                            o2.setMergeFlag(1);
                                            o2.setMergeFrom(o2.getPatientId());
                                            o2.setPatientId(targetPatientId);
                                            o2.setMergeTarget(targetPatientId);
                                            o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            followupResultBufferRepository.save(o2);
                                        }

                                    }
                                    List<Long> allPids=new ArrayList<>();
                                    allPids.add(targetPatientId);
                                    allPids.addAll(otherPatientIds);
                                   //没有随访结果的任务患者表标记：
                                    List<RFollowupTaskPatient> ftTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdInAndMergeTargetIsNull(o.getFollowupTaskId(),allPids);
                                    if(ftTaskPatient!=null&&ftTaskPatient.size()>0){
                                        for (RFollowupTaskPatient o1 : ftTaskPatient) {
                                        //ftTaskPatient.forEach(o1 -> {
                                            o1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            o1.setMergeFrom(o1.getPatientId());
                                            o1.setMergeTarget(targetPatientId);
                                            o1.setMergeFlag(2);
                                            rFollowupTaskPatientRepository.save(o1);

                                            //合并随访Buff表
                                            List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());

                                            for (FollowupResultBuff o2 : followupResultBuffs) {
                                                o2.setMergeFlag(2);
                                                o2.setMergeFrom(o2.getPatientId());
                                                o2.setMergeTarget(targetPatientId);
                                                o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                                followupResultBufferRepository.save(o2);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    } else {//不在同一任务中（任务患者表仍有可能在同一任务中）
                        List<RFollowupTaskPatient> list=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdInAndMergeTargetIsNull(o.getFollowupTaskId(),pids);
                        if(list!=null&&list.size()>1){//同一任务中,此时只有在未完成的任务中才会出现
                            boolean result=false;
                            for (RFollowupTaskPatient followupTaskPatient : list){
                                if(targetPatientId.equals(followupTaskPatient.getPatientId())){
                                    result=true;
                                }
                            }
                            if(result){
                                if(targetPatientId.equals(o.getPatientId())){
                                    for (RFollowupTaskPatient followupTaskPatient : list){
                                        if(!targetPatientId.equals(followupTaskPatient.getPatientId())){
                                            followupTaskPatient.setMergeTarget(targetPatientId);
                                            followupTaskPatient.setMergeFlag(2);
                                            followupTaskPatient.setMergeFrom(followupTaskPatient.getPatientId());
                                            followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            rFollowupTaskPatientRepository.save(followupTaskPatient);

                                            //合并随访Buff表
                                            List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(followupTaskPatient.getPatientId(),followupTaskPatient.getFollowupTaskId());

                                            for (FollowupResultBuff o2 : followupResultBuffs) {
                                                o2.setMergeFlag(2);
                                                o2.setMergeFrom(o2.getPatientId());
                                                o2.setMergeTarget(targetPatientId);
                                                o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                                followupResultBufferRepository.save(o2);
                                            }
                                        }
                                    }
                                }else{
                                    for (RFollowupTaskPatient followupTaskPatient : list){
                                        if(targetPatientId.equals(followupTaskPatient.getPatientId())){

                                            //备份随访任务表
                                            RFollowupTaskPatientMergeBak followupTaskPatientMergeBak=new RFollowupTaskPatientMergeBak();
                                            BeanUtils.copyProperties(followupTaskPatient,followupTaskPatientMergeBak);
                                            followupTaskPatientMergeBakRepository.save(followupTaskPatientMergeBak);

                                            //将ft结果复制到目标患者
                                            FollowupResult followupResult1 = new FollowupResult();
                                            BeanUtils.copyProperties(o, followupResult1, "followupResultId", "patientId");
                                            followupResult1.setMergeFlag(1);
                                            followupResult1.setMergeTarget(targetPatientId);
                                            followupResult1.setMergeFrom(targetPatientId);
                                            followupResult1.setFollowupResultId(GeneralUtil.generateUniqueID("RESU"));
                                            followupResult1.setPatientId(targetPatientId);
                                            followupResult1.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            followupResultRepository.save(followupResult1);

                                            //ft结果删除
                                            o.setMergeFlag(2);
                                            o.setMergeTarget(targetPatientId);
                                            o.setMergeFrom(o.getPatientId());
                                            o.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            followupResultRepository.save(o);

                                            RFollowupTaskPatient ftTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(o.getFollowupTaskId(),o.getMergeFrom());

                                            //将任务复制到目标患者
                                            BeanUtils.copyProperties(ftTaskPatient,followupTaskPatient,"id","patientId");
                                            followupTaskPatient.setMergeFlag(1);
                                            followupTaskPatient.setMergeTarget(targetPatientId);
                                            followupTaskPatient.setMergeFrom(targetPatientId);
                                            followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            rFollowupTaskPatientRepository.save(followupTaskPatient);

                                            //ft任务结果删除
                                            ftTaskPatient.setMergeFlag(2);
                                            ftTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            ftTaskPatient.setMergeFrom(ftTaskPatient.getPatientId());
                                            ftTaskPatient.setMergeTarget(targetPatientId);
                                            rFollowupTaskPatientRepository.save(ftTaskPatient);

                                            //合并随访Buff表
                                            List<FollowupResultBuff> otherFollowupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o.getPatientId(),o.getFollowupTaskId());

                                            for (FollowupResultBuff o2 : otherFollowupResultBuffs) {
                                                if(o2.getFollowupResultId()!=null){
                                                    FollowupResultBuffMergeBak followupResultBuffMergeBak1=new FollowupResultBuffMergeBak();
                                                    BeanUtils.copyProperties(o2,followupResultBuffMergeBak1);
                                                    followupResultBuffMergeBakRepository.save(followupResultBuffMergeBak1);
                                                    o2.setFollowupResultId(followupResult1.getFollowupResultId());
                                                }
                                                o2.setMergeFlag(1);
                                                o2.setMergeFrom(o2.getPatientId());
                                                o2.setPatientId(targetPatientId);
                                                o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                                o2.setMergeTarget(targetPatientId);
                                                followupResultBufferRepository.save(o2);
                                            }


                                        }else if(o.getPatientId()!=followupTaskPatient.getPatientId()){
                                            followupTaskPatient.setMergeTarget(targetPatientId);
                                            followupTaskPatient.setMergeFlag(2);
                                            followupTaskPatient.setMergeFrom(followupTaskPatient.getPatientId());
                                            followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            rFollowupTaskPatientRepository.save(followupTaskPatient);

                                            //合并随访Buff表
                                            List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(followupTaskPatient.getPatientId(),followupTaskPatient.getFollowupTaskId());

                                            for (FollowupResultBuff o2 : followupResultBuffs) {
                                                o2.setMergeFlag(2);
                                                o2.setMergeFrom(o2.getPatientId());
                                                o2.setMergeTarget(targetPatientId);
                                                o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                                followupResultBufferRepository.save(o2);
                                            }
                                        }
                                    }
                                }
                            }else{
                                for (RFollowupTaskPatient followupTaskPatient : list){
                                    if(followupTaskPatient.getPatientId()==o.getPatientId()){
                                        o.setMergeFlag(1);
                                        o.setMergeFrom(o.getPatientId());
                                        o.setMergeTarget(targetPatientId);
                                        o.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        o.setPatientId(targetPatientId);
                                        followupResultRepository.save(o);


                                        followupTaskPatient.setMergeFlag(1);
                                        followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        followupTaskPatient.setMergeFrom(followupTaskPatient.getPatientId());
                                        followupTaskPatient.setMergeTarget(targetPatientId);
                                        followupTaskPatient.setPatientId(targetPatientId);
                                        rFollowupTaskPatientRepository.save(followupTaskPatient);

                                        //合并随访Buff表
                                        List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o.getMergeFrom(),followupTaskPatient.getFollowupTaskId());

                                        for (FollowupResultBuff o2 : followupResultBuffs) {
                                            o2.setMergeFlag(1);
                                            o2.setMergeFrom(o2.getPatientId());
                                            o2.setMergeTarget(targetPatientId);
                                            o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            o2.setPatientId(targetPatientId);
                                            followupResultBufferRepository.save(o2);
                                        }
                                    }else{
                                        followupTaskPatient.setMergeTarget(targetPatientId);
                                        followupTaskPatient.setMergeFlag(2);
                                        followupTaskPatient.setMergeFrom(followupTaskPatient.getPatientId());
                                        followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                                        rFollowupTaskPatientRepository.save(followupTaskPatient);

                                        //合并随访Buff表
                                        List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(followupTaskPatient.getPatientId(),followupTaskPatient.getFollowupTaskId());

                                        for (FollowupResultBuff o2 : followupResultBuffs) {
                                            o2.setMergeFlag(2);
                                            o2.setMergeFrom(o2.getPatientId());
                                            o2.setMergeTarget(targetPatientId);
                                            o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                            followupResultBufferRepository.save(o2);
                                        }
                                    }
                                }
                            }

                        }else{//不同任务中
                            o.setMergeFlag(1);
                            o.setMergeFrom(o.getPatientId());
                            o.setMergeTarget(targetPatientId);
                            o.setMergeTime(TimeUtils.getCurrentTimestamp());
                            o.setPatientId(targetPatientId);
                            followupResultRepository.save(o);

                            //合并任务患者表
                            RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdAndMergeTargetIsNull(o.getFollowupTaskId(),o.getMergeFrom());
                            followupTaskPatient.setMergeFlag(1);
                            followupTaskPatient.setMergeFrom(followupTaskPatient.getPatientId());
                            followupTaskPatient.setMergeTarget(targetPatientId);
                            followupTaskPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
                            followupTaskPatient.setPatientId(targetPatientId);
                            rFollowupTaskPatientRepository.save(followupTaskPatient);

                            //合并随访Buff表
                            List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(followupTaskPatient.getMergeFrom(),followupTaskPatient.getFollowupTaskId());

                            for (FollowupResultBuff o2 : followupResultBuffs) {
                                o2.setMergeFlag(1);
                                o2.setMergeFrom(o2.getPatientId());
                                o2.setMergeTarget(targetPatientId);
                                o2.setMergeTime(TimeUtils.getCurrentTimestamp());
                                o2.setPatientId(targetPatientId);
                                followupResultBufferRepository.save(o2);
                            }
                        }
                    }
                } else {//不在任务中
                    o.setMergeFlag(1);
                    o.setMergeFrom(o.getPatientId());
                    o.setMergeTarget(targetPatientId);
                    o.setPatientId(targetPatientId);
                    o.setMergeTime(TimeUtils.getCurrentTimestamp());
                    followupResultRepository.save(o);
                }
            }
        }
    }

    /**
     * 获取随访结果优先级
     * @param result
     * @return
     */
    private List<Integer> getPriorityResult(int result) {
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(3);
        values.add(2);
        values.add(1);
        values.add(16);
        values.add(15);
        if(result==1)values.add(5);
        values.add(11);
        values.add(7);
        values.add(14);
        values.add(12);
        values.add(13);
        values.add(10);
        values.add(9);
        values.add(8);
        if(result==0)values.add(5);
        return values;
    }

    private FollowupResult getFirstFollowupResult(List<FollowupResult> sameFollowupResults,List<Integer> values){
        List<FollowupResult> followupResults1 = new ArrayList<>();
        int count1=0;
        for (FollowupResult followupResult : sameFollowupResults){
            if(followupResult.getState().equals(2)){
                followupResults1.add(followupResult);
                count1++;
            }
        }
        if(count1==1){
            return followupResults1.get(0);
        }else if(count1>1){
            return this.getOrderFollowupResult(followupResults1,values,0);
        }else{
            return this.getOrderFollowupResult(sameFollowupResults,values,0);
        }
    }

    /**
     * 递归获取优先级最高的随访结果
     * @param sameFollowupResults
     * @param values
     * @param i
     * @return
     */
    private FollowupResult getOrderFollowupResult(List<FollowupResult> sameFollowupResults,List<Integer> values,int i) {
        if (i == 13) {
            //sameFollowupResults.sort((o1, o2) -> o2.getFollowupTime().compareTo(o1.getFollowupTime()));
            Collections.sort(sameFollowupResults, new Comparator<FollowupResult>() {
                @Override
                public int compare(FollowupResult o1, FollowupResult o2) {
                    if(o1.getFollowupTime()==null){
                        return 1;
                    }else if(o2.getFollowupTime()==null){
                        return 2;
                    }else{
                        return o2.getFollowupTime().compareTo(o1.getFollowupTime());
                    }
                }
            });
            return sameFollowupResults.get(0);
        }
        int count = 0;
        List<FollowupResult> followupResults = new ArrayList<>();
        for (FollowupResult followupResult : sameFollowupResults) {
            if (followupResult.getFollowupResultValue() == values.get(i)) {
                followupResults.add(followupResult);
                count++;
            }
        }
        if (count == 1) {
            return followupResults.get(0);
        } else if (count > 1) {
            return getOrderFollowupResult(followupResults, values, i + 1);
        } else {
            return getOrderFollowupResult(sameFollowupResults, values, i + 1);
        }

    }

    /**
     * 随访结果去重
     * @param targetPatientId
     */
    private void mergeRepeatFollowup(Long targetPatientId){
        final List<FollowupResult> followupResults=followupResultRepository.findByPatientIdAndMergeFlagNotAndState(targetPatientId,2,2);
        //followupResults.forEach(o1 ->{
        for (FollowupResult o1 : followupResults) {
            for (FollowupResult o2 : followupResults) {
            //followupResults.forEach(o2 -> {
                FollowupResult followupResult=followupResultRepository.findByFollowupResultId(o2.getFollowupResultId());
                if(followupResult.getMergeFlag()!=null&&!followupResult.getMergeFlag().equals(2)){
                    if(!o1.getFollowupResultId().equals(o2.getFollowupResultId())&&o1.getFollowupResultValue()==o2.getFollowupResultValue()
                            &&o1.getFollowupTime().getTime()==o2.getFollowupTime().getTime()){
                       if(o1.getFollowupTaskId()!=null){
                           //删除Buff
                           List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupTaskId(o1.getPatientId(),o1.getFollowupTaskId());
                           for (FollowupResultBuff o3 : followupResultBuffs) {
                               o3.setMergeFlag(2);
                               followupResultBufferRepository.save(o3);
                           }
                           //删除task_patient
                           RFollowupTaskPatient followupTaskPatient=rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(o1.getFollowupTaskId(),o1.getPatientId());
                           followupTaskPatient.setMergeFlag(2);
                           rFollowupTaskPatientRepository.save(followupTaskPatient);
                       }else{
                           FollowupResultBuff followupResultBuff=followupResultBufferRepository.findByFollowupResultId(o1.getFollowupResultId());
                           if(followupResultBuff!=null){
                               followupResultBuff.setMergeFlag(2);
                               followupResultBufferRepository.save(followupResultBuff);
                           }
                       }
                       //删除随访结果
                       o1.setMergeFlag(2);
                       followupResultRepository.save(o1);
                    }
                }
            }
        }
    }

    /**
     * 合并随访Buff表中的多个死亡结果
     * @param targetPatientId
     * @param retainPatientId
     */
    private void mergeDeathFollowupResult(Long targetPatientId,Long retainPatientId,String followupResultId){
        if(followupResultId!=null){
            List<FollowupResultBuff> followupResultBuffs=followupResultBufferRepository.findByPatientIdAndFollowupResultValueAndMergeFlagNot(targetPatientId, 4, 2);
            for (FollowupResultBuff followupResultBuff : followupResultBuffs){
                if(!followupResultId.equals(followupResultBuff.getFollowupResultId())){
                    followupResultBuff.setMergeFlag(2);
                    followupResultBufferRepository.save(followupResultBuff);
                }
            }
        }
    }

    @Override
    public void updateVarPatientFollowupResult(Long patientId) {
        //LogUtil.log.info("调用 flushVarPatientFollowUp() 刷新最新随访时间！");
        //int result=patientMergeRepository.flushVarPatientFollowUp();
        //LogUtil.log.info("调用 flushVarPatientFollowUp() 结束：{}"+result);
        FollowupResult followupResult=followupResultRepository.findTopByPatientIdAndStateAndMergeFlagNotOrderByFollowupTimeDesc(patientId,2,2);

        if(followupResult==null){//如果没有正式的随访结果则使用暂存的
            followupResult=followupResultRepository.findTopByPatientIdAndStateAndMergeFlagNotOrderByFollowupTimeDesc(patientId,1,2);
            if(followupResult==null){
                removeVarPatientFollowup(patientId);
                return;
            }
        }

        UPatient patient=patientRepository.findByPatientId(patientId);
        VarPatientFollowup patientFollowup=patientFollowupRepository.findByPatientId(patientId);
        if(patientFollowup==null){
            patientFollowup=new VarPatientFollowup();
            patientFollowup.setCreateTime(TimeUtils.getCurrentTimestamp());
        }
        UUser operator=null;
        FollowupTask task=null;
        MetaFollowupWay followupWay=null;
        if(followupResult.getOperator()!=null){
            operator=userRepository.findOne(followupResult.getOperator());
        }
        if(followupResult.getFollowupTaskId()!=null){
            task=followupTaskRepository.findByFollowupTaskId(followupResult.getFollowupTaskId());
        }
        if(followupResult.getFollowupWay()!=null){
            followupWay=followupWayRepository.findOne(followupResult.getFollowupWay());
        }

        patientFollowup.setFollowupResultValue(followupResult.getFollowupResultValue());
        patientFollowup.setFollowupWay(followupResult.getFollowupWay());
        patientFollowup.setFollowupOperator(followupResult.getOperator());
        if(operator!=null)patientFollowup.setFollowupOperatorName(operator.getTrueName());
        if(followupWay!=null)patientFollowup.setFollowupWayName(followupWay.getFollowupWayName());
        if(task!=null)patientFollowup.setFollowupTaskName(task.getFollowupTaskName());
        patientFollowup.setFollowupFlag(followupResult.getSourceFlag());
        patientFollowup.setUpdateTime(TimeUtils.getCurrentTimestamp());
        patientFollowup.setFollowupTaskId(followupResult.getFollowupTaskId());
        patientFollowup.setLatestFollowupTime(followupResult.getFollowupTime());
        patientFollowup.setLatestFollowupTime(followupResult.getFollowupTime());
        patientFollowup.setFollowupRemark(followupResult.getRemark());
        patientFollowup.setPatientId(followupResult.getPatientId());
        patientFollowup.setRelapseDate(followupResult.getRelapseDate());
        patientFollowup.setRelapseParts(followupResult.getRelapseParts());
        patientFollowup.setTransferDate(followupResult.getTransferDate());
        patientFollowup.setTransferParts(followupResult.getTransferParts());

        //检查当前随访结果是否有效，若无效则从新获取有效结果
        if(!checkValidFollowupResult(followupResult.getFollowupResultValue())){
            FollowupResult validfollowupResult=followupResultRepository.findLastValidFollowupResult(patientId);
            if(validfollowupResult!=null){
                followupResult=validfollowupResult;
                if(followupResult.getOperator()!=null){
                    operator=userRepository.findOne(followupResult.getOperator());
                }
                if(followupResult.getFollowupTaskId()!=null){
                    task=followupTaskRepository.findByFollowupTaskId(followupResult.getFollowupTaskId());
                }
                if(followupResult.getFollowupWay()!=null){
                    followupWay=followupWayRepository.findOne(followupResult.getFollowupWay());
                }
            }
        }

        if(followupWay!=null)patientFollowup.setValidFollowupWay(followupResult.getFollowupWay());
        if(task!=null)patientFollowup.setValidFollowupTaskId(followupResult.getFollowupTaskId());
        if(operator!=null)patientFollowup.setValidFollowupOperator(followupResult.getOperator());
        patientFollowup.setFollowupValidResultValue(followupResult.getFollowupResultValue());
        patientFollowup.setLatestValidFollowupTime(followupResult.getFollowupTime());
        if(operator!=null)patientFollowup.setValidFollowupOperatorName(operator.getTrueName());
        if(task!=null)patientFollowup.setValidFollowupTaskName(task.getFollowupTaskName());
        if(followupWay!=null)patientFollowup.setValidFollowupWayName(followupWay.getFollowupWayName());
        patientFollowup.setValidSourceFlag(followupResult.getSourceFlag());
        //生存时间重新计算
        this.liveTimeCompute(patientFollowup,patient,followupResult);

        patientFollowupRepository.save(patientFollowup);

    }

    /**
     * 删除患者的动态表
     * @param patientId
     */
    private void removeVarPatientFollowup(Long patientId){
        VarPatientFollowup patientFollowup = patientFollowupRepository.findByPatientId(patientId);
        if(patientFollowup!=null){
            patientFollowupRepository.delete(patientFollowup);
        }
    }

    /**
     * 检查是否有效随访结果表
     * @param followupResultValue
     * @return
     */
    private boolean checkValidFollowupResult(Integer followupResultValue){
        List<MetaFollowupResultValue> list = followupResultValueRepository.findAllByType(1);
        boolean result=false;
        for (MetaFollowupResultValue value : list){
            if(value.getFollowupResultValueId().equals(followupResultValue)){
                result=true;
            }
        }
        return result;
    }

    private void liveTimeCompute(VarPatientFollowup patientFollowup, UPatient patient,FollowupResult followupResult) {
        try {
            if(patient.getConfirmedDate()!=null){
                Integer liveDay = 0;
                if (patientFollowup.getFollowupValidResultValue() == 4) {
                    java.util.Date deathDate = this.calculateDeathDate(followupResult.getDeathDate(), patientFollowup.getLatestValidFollowupTime());
                    liveDay = DateUtil.daysBetween(patient.getConfirmedDate(), deathDate);
                } else {
                    liveDay = DateUtil.daysBetween(patient.getConfirmedDate(), patientFollowup.getLatestValidFollowupTime());
                }
                // 生存时间公式
                String strMonth = (liveDay / 365.25) * 12 + "";
                strMonth = MathExtend.round(strMonth, 2);
                patientFollowup.setLiveDay(liveDay);
                patientFollowup.setLiveMonth(Float.valueOf(strMonth));
            }else{
                patientFollowup.setLiveDay(0);
                patientFollowup.setLiveMonth(Float.valueOf(0));
            }
        } catch (Exception e){
            LogUtil.log.error("[生存时间计算出错：]" + e.getMessage());
        }
    }


    public java.util.Date calculateDeathDate(java.util.Date deathDate, java.util.Date latestFollowupTime) {
        try {
            java.util.Date now = new java.util.Date();
            if (deathDate!=null) {
                return deathDate;
            }
            int day = DateUtil.daysBetween(latestFollowupTime, now);
            day = day / 2;
            return DateUtil.getOffsetDate(latestFollowupTime, day);

        } catch (ParseException e) {
            LogUtil.log.error("【死亡时间计算错误】" + e.getMessage());
        }
        return null;
    }

}


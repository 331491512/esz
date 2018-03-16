package com.esuizhen.bigdata.service;

import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.merge.Command;
import com.esuizhen.bigdata.merge.Producer;
import com.esuizhen.bigdata.repository.followup.FollowupResultBufferRepository;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.repository.followup.RFollowupTaskPatientRepository;
import com.esuizhen.bigdata.repository.followup.VarPatientMedicalRepository;
import com.esuizhen.bigdata.repository.user.*;
import com.esuizhen.bigdata.service.user.PatientService;
import com.westangel.common.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by fqc on 16/11/23.
 * Merge总调度类
 * 该类将控制整个流程事务，由各个子流程负责具体的合并细节。
 */
//每个子服务执行状态  都有执行结果 执行人 开启时间 结束时间 能够实时查看合并进度
//而他们都是属于该服务的一个模块部分，最好可以进行控制
//命令模式 组合模式将是非常不错的方式
//    业务上只特定的患者进行合并，并发实现并非亟需。异步方式实现的方式更需要考虑业务上的合理性了。
@Service
@Transactional
public class MergeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeService.class);

    @Autowired //这里注入具体的repository,使用父类具体实现方法是无法找到的。
    private UPatientRepository uPatientRepository;
    @Autowired
    private UuidPatientMergeRepository uuidPatientMergeRepository;

    @Autowired
    VarPatientMedicalRepository varPatientMedicalRepository;
    @Autowired
    UPatientFamilyRepository uPatientFamilyRepository;
    @Autowired
    UPatientMergeBakRepository uPatientMergeBakRepository;
    @Autowired
    UUserRepository userRepository;
    @Autowired
    UUserMergeBakRepository uUserMergeBakRepository;
    @Autowired
    UUserRepository uUserRepository;
    @Autowired
    EntityBakService entityBakService;

    @Autowired
    RFollowupTaskPatientRepository rFollowupTaskPatientRepository;
    @Autowired
    FollowupResultRepository followupResultRepository;
    @Autowired
    FollowupResultBufferRepository followupResultBufferRepository;


   /* @Autowired
    FollowupResultService followupResultService;
    @Autowired
    FollowupResultBufferService followupResultBufferService;
    @Autowired
    RFollowupTaskPatientService rFollowupTaskPatientService;*/

    Map<String, JpaRepository> repositoryMap = new HashMap<>();
    @Autowired
    private PatientService patientService;

    public void execute() throws Exception {
        execute(null, null, null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void execute(Long goalPatientId, List<Long> otherPatientIds, MergePatientReq beanInfo, String operatorId) throws Exception {

        repositoryMap.put("uPatientRepository", uPatientRepository);
        repositoryMap.put("uuidPatientMergeRepository", uuidPatientMergeRepository);
        repositoryMap.put("varPatientMedicalRepository", varPatientMedicalRepository);
        repositoryMap.put("uPatientFamilyRepository", uPatientFamilyRepository);
        repositoryMap.put("uPatientMergeBakRepository", uPatientMergeBakRepository);
        repositoryMap.put("userRepository", userRepository);
        repositoryMap.put("uUserMergeBakRepository", uUserMergeBakRepository);

        repositoryMap.put("rFollowupTaskPatientRepository", rFollowupTaskPatientRepository);
        repositoryMap.put("followupResultRepository", followupResultRepository);
        repositoryMap.put("followupResultBufferRepository", followupResultBufferRepository);

        List<Long> patientIds = new ArrayList<>();
        patientIds.add(goalPatientId);
        patientIds.addAll(otherPatientIds);
        patientService.setVisitingTimeByPatientIds(patientIds);

        ConcurrentLinkedQueue queue = Producer.produceRequests3(goalPatientId, otherPatientIds, beanInfo, operatorId, repositoryMap, entityBakService);
        for (Iterator it = queue.iterator(); it.hasNext(); ) {
            ((Command) it.next()).executeMerge();//目前模拟的同步方式，更好的方式是异步更快速，但是同时带来了业务不确定的因素。
        }
    }

    @Transactional
    public void execute(Long goalPatientId, List<Long> otherPatientIds, String operatorId) throws Exception {
        execute(goalPatientId, otherPatientIds, null, operatorId);
    }

    /**
     * 选举目标患者
     * <p>
     * λ	已合并患者优先；已经合并的患者mergeFlag=1   [uuid_patient_merge > resultFlag=1这种老方式废弃]
     * λ	同步云端患者优先；u_patient u_user … syncFlag=1
     * λ	最近就诊时间距当前时间最近的患者优先；（根据患者最近就诊时间倒序排列第一优先、第二优先等）
     * λ    最近就诊时间定义：是指通过患者最近一次门诊时间和最近一次住院时间中，取距当前时间最近的时间为最近就诊时间
     *
     * @param patientIds
     * @return
     */
    public Map<String, Object> vote(List<Long> patientIds) {
        LOGGER.info("用户选择要合并的患者--->{}", patientIds);
        UPatient goalPatient = null;
        //已经合并过的患者列表
        List<UPatient> patientWithMergeFlagList = uPatientRepository.findByPatientIdInAndMergeFlag(patientIds, 1);
        int mergeFlagListSize = patientWithMergeFlagList.size();

        //判断就诊时间的优先级
        List<UPatient> patients = uPatientRepository.findAllByPatientIdIn(patientIds);
        patientService.setVisitingTimeByPatients(patients);

        if (mergeFlagListSize == 0 || mergeFlagListSize > 1) {
            List<UPatient> patientWithSyncList = uPatientRepository.findByPatientIdInAndSyncFlag(patientIds, 1);
            int syncListSize = patientWithSyncList.size();
            if (syncListSize == 0 || syncListSize > 1) {
                /*//判断就诊时间的优先级
                List<UPatient> patients = uPatientRepository.findAllByPatientIdIn(patientIds);
                */
                if (patients.size() == 0) {
                    LOGGER.info("选举失败，所传递患者居然不在疑似重复患者列表中，调用者绝对不是正常用户调用，可能是测试!!");
                    throw new NullPointerException();
                }

               /* patients.forEach(uPatient -> {
                    VarPatientMedical patientMedical = varPatientMedicalRepository.findByPatientId(uPatient.getPatientId());
                    Timestamp visitingTime = patientMedical.getVisitingTime();//为了保持一致,设置给patient
                    if (visitingTime != null) {
                        uPatient.setVisitingTimeByPatients(visitingTime);
                    }
                });*/

                //降序排列后，就诊时间最近的
                //patients.sort((o1, o2) -> {
                //    if(o2.getVisitingTime()==null) {
                //        return -1;
                //    }else if(o1.getVisitingTime()==null){
                //        return 1;
                //    }else {
                //        return o2.getVisitingTime().compareTo(o1.getVisitingTime());
                //    }
                //});
                Collections.sort(patients, new Comparator<UPatient>() {
                    @Override
                    public int compare(UPatient o1, UPatient o2) {
                        if(o1.getVisitingTime() == null) {
                            return 1;
                        }else if(o2.getVisitingTime() == null){
                            return -1;
                        }else{
                            return o2.getVisitingTime().compareTo(o1.getVisitingTime());
                        }
                    }
                });
                if (patients.size() > 0) {
                    goalPatient = patients.get(0);
                }

            } else {
                //sync后 size=1 确认出goalPatientId
                goalPatient = patientWithSyncList.get(0);
            }

        } else {
            //mergeFlag后 size=1 确认出goalPatientId
            goalPatient = patientWithMergeFlagList.get(0);
        }


        Map<String, Object> votedMap = new HashMap<>();
        votedMap.put("goalPatientId", goalPatient.getPatientId());

        //patientIds.removeAll(Lists.newArrayList(goalPatient.getPatientId()));
        patientIds.remove(goalPatient.getPatientId());
        List<Long> otherPatientIds = patientIds;//去除goalPatientIds
        votedMap.put("otherPatientIds", otherPatientIds);
        LOGGER.info("选举出目标患者为--->{}", goalPatient.getPatientId());
        return votedMap;
    }

    /**
     * 根据最近门诊时间排序
     * @param patients
     */
    private void orderByVisitingTime(List<UPatient> patients){

    }


    public static void main(String[] args) throws Exception {
        //List queue = Producer.produceRequests();
//        String goalPatientId = "10000";
//        List<String> otherPatientIds = new ArrayList<>();
//        otherPatientIds.add("10001");
//        otherPatientIds.add("10002");
//        String operatorId = "999";
////        ConcurrentLinkedQueue queue = Producer.produceRequests2();
//        ConcurrentLinkedQueue queue = Producer.produceRequests2(goalPatientId, otherPatientIds, operatorId);
//        for (Iterator it = queue.iterator(); it.hasNext(); ) {
//            ((Command) it.next()).executeMerge();//目前模拟的同步方式，更好的方式是异步更快速，但是同时带来了业务不确定的因素。
//        }
        List<UPatient> patients=new ArrayList<>();
        UPatient patient1=new UPatient();
        UPatient patient2=new UPatient();
        UPatient patient3=new UPatient();
        UPatient patient4=new UPatient();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);

        patient1.setVisitingTime(TimeUtils.getCurrentTimestamp());
        Thread.sleep(2000);
        patient2.setVisitingTime(TimeUtils.getCurrentTimestamp());
        Thread.sleep(2000);
        patient3.setVisitingTime(TimeUtils.getCurrentTimestamp());
        Thread.sleep(2000);
        patient4.setVisitingTime(TimeUtils.getCurrentTimestamp());
        Thread.sleep(2000);

        System.out.println("排序前："+JsonUtil.toJson(patients));
        Collections.sort(patients, new Comparator<UPatient>() {
            @Override
            public int compare(UPatient o1, UPatient o2) {
                if(o2.getVisitingTime() == null) {
                    return -1;
                }else if(o1.getVisitingTime() == null){
                    return 1;
                }else{
                    return o2.getVisitingTime().compareTo(o1.getVisitingTime());
                }
            }
        });

        System.out.println("排序后："+JsonUtil.toJson(patients));

    }


}

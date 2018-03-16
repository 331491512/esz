package com.esuizhen.bigdata.service;

import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;
import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.domain.followup.MetaFollowupResultValue;
import com.esuizhen.bigdata.domain.followup.RFollowupTaskPatient;
import com.esuizhen.bigdata.domain.followup.VarPatientFollowup;
import com.esuizhen.bigdata.domain.mergebak.followup.RFollowupTaskPatientMergeBak;
import com.esuizhen.bigdata.domain.mergebak.user.UPatientMergeBak;
import com.esuizhen.bigdata.domain.mergebak.user.UUserMergeBak;
import com.esuizhen.bigdata.domain.sc.TPatientSyncResultClient;
import com.esuizhen.bigdata.domain.user.RUuidPatientno;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UPatientFamily;
import com.esuizhen.bigdata.domain.user.UUser;
import com.esuizhen.bigdata.repository.followup.*;
import com.esuizhen.bigdata.repository.sc.TPatientSyncResultClientRepository;
import com.esuizhen.bigdata.repository.sc.TUuidPatientnoSyncResultClientRepository;
import com.esuizhen.bigdata.repository.user.*;
import com.esuizhen.bigdata.service.ehr.*;
import com.esuizhen.bigdata.service.followup.*;
import com.esuizhen.bigdata.service.user.DeptPatientService;
import com.esuizhen.bigdata.service.user.MergeLogService;
import com.esuizhen.bigdata.service.user.PatientService;
import com.esuizhen.bigdata.service.user.UuidPatientMergeService;
import com.westangel.common.util.GeneralUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by fqc on 16/12/28.
 */
@Service
public class EntityBakService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityBakService.class);
    @Autowired
    private UPatientMergeBakRepository uPatientMergeBakRepository;
    @Autowired
    private UUserMergeBakRepository uUserMergeBakRepository;
    @Autowired
    private UPatientFamilyRepository uPatientFamilyRepository;
    @Autowired
    private RFollowupTaskPatientMergeBakRepository rFollowupTaskPatientMergeBakRepository;
    @Autowired
    private RFollowupTaskPatientRepository rFollowupTaskPatientRepository;
    @Autowired
    private FollowupResultRepository followupResultRepository;
    @Autowired
    private FollowupResultBufferRepository followupResultBufferRepository;
    @Autowired
    private VarPatientFollowupRepository varPatientFollowupRepository;
    @Autowired
    private ConfGlobalRepository confGlobalRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UuidPatientMergeService uuidPatientMergeService;

    @Autowired
    private FollowupResultService followupResultService;
    @Autowired
    private FollowupResultBufferService followupResultBufferService;

    @Autowired
    private MergeLogService mergeLogService;
    @Autowired
    private PatientService patientService;

    @Autowired
    private InhospitalNoteService inhospitalNoteService;
    @Autowired
    private OuthospitalNoteService outhospitalNoteService;
    @Autowired
    private DiagnosisInfoService diagnosisInfoService;
    @Autowired
    private SurgeryNoteService surgeryNoteService;
    @Autowired
    private TreatmentNoteService treatmentNoteService;
    @Autowired
    private ClinicMedicalNoteService clinicMedicalNoteService;
    @Autowired
    private DetectionReportService detectionReportService;
    @Autowired
    private DetectionDetailService detectionDetailService;
    @Autowired
    private ExamReportService examReportService;
    @Autowired
    private FollowupCallReqService followupCallReqService;
    @Autowired
    private FollowupSmsReqService followupSmsReqService;
    @Autowired
    private FollowupWxReqService followupWxReqService;
    @Autowired
    private PatientMergeRepository patientMergeRepository;
    @Autowired
    private RUuidPatientnoRepository uuidPatientnoRepository;
    @Autowired
    private UPatientRepository patientRepository;
    @Autowired
    private TPatientSyncResultClientRepository patientSyncResultClientRepository;
    @Autowired
    private TUuidPatientnoSyncResultClientRepository patientnoSyncResultClientRepository;
    @Autowired
    private DeptPatientService deptPatientService;
    /**
     * 备份目标患者(插入目标患者到upatient_bak表)
     * '合并标识。1为合并后的目标患者，2为被合并患者；0为普通患者（默认）'
     * patientType -1为标识
     *
     * @param goalPatient
     */
    public void backupGoalPatient(UPatient goalPatient) {
        LOGGER.info("开始备份目标患者-->{}", goalPatient.getPatientId());
        goalPatient.setMergeFlag(1);
        //flagMergedPatients(goalPatient, otherPatients);单独的事情
        UPatientMergeBak uPatientMergeBak = new UPatientMergeBak();
        BeanUtils.copyProperties(goalPatient, uPatientMergeBak);//注意patientId 与 patientid
        uPatientMergeBak.setMergeFlag(1); //希望最终是一致的,因此都在最后来修改mergeFlag
        uPatientMergeBak.setMergeTime(TimeUtils.getCurrentTimestamp());
        uPatientMergeBakRepository.save(uPatientMergeBak);//后面goalPatient的修改并不影响 jpa不会这么混乱
        LOGGER.info("备份目标患者-->{}成功", goalPatient.getPatientId());
    }

    public void flagMergedPatients(UPatient goalPatient, List<UPatient> otherPatients) {
        LOGGER.info("被合并患者做标识-->{}", otherPatients);
        for (UPatient uPatient : otherPatients) {
            uPatient.setPatientType(-1);
            uPatient.setMergeFlag(2);
            uPatient.setMergeFrom(uPatient.getPatientId());
            uPatient.setMergeTarget(goalPatient.getPatientId());
            uPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
        }
    }


    /**
     * 备份目标患者关联的user表
     * '合并标识。1为合并后的目标患者，2为被合并患者；0为普通患者（默认）'
     *
     * @param goalPatient
     */
    public void backupUserOfGoalPatient(UPatient goalPatient, List<UPatient> otherPatients) {
        //flagMergedUsers(goalPatient, otherPatients);

        UUser uUser = goalPatient.getuUserByUserId();
        LOGGER.info("开始备份目标患者对应的用户-->{}", uUser.getUserId());
        UUserMergeBak uUserMergeBak = new UUserMergeBak();
        BeanUtils.copyProperties(uUser, uUserMergeBak);
        uUserMergeBak.setMergeFlag(1);
        uUserMergeBak.setMergeTime(TimeUtils.getCurrentTimestamp());
        uUserMergeBakRepository.save(uUserMergeBak);
        LOGGER.info("备份目标患者对应的用户-->{}成功", uUser.getUserId());
    }

    /**
     * 修改被合并患者对应的user实体的标识
     *
     * @param goalPatient
     * @param otherPatients
     */
    public void flagMergedUsers(UPatient goalPatient, List<UPatient> otherPatients) {
        for (UPatient uPatient : otherPatients) {
            UUser otherUser = uPatient.getuUserByUserId();
            otherUser.setMergeFlag(2);
            otherUser.setMergeFrom(uPatient.getPatientId());
            otherUser.setMergeTarget(goalPatient.getPatientId());
            otherUser.setMergeTime(TimeUtils.getCurrentTimestamp());
        }
    }

    /**
     * 被合并者的联系人复制追加到目标患者上
     * '合并标识。1为合并后的目标患者，2为被合并患者；0为普通患者（默认）'
     *
     * @param goalPatient
     * @param otherPatientIds
     */
    public void cloneFamilies2GoalPatient(UPatient goalPatient, List<Long> otherPatientIds) {
        //public void backupUPatientFamily(UPatient goalPatient, List<Long> otherPatientIds) {

        List<UPatientFamily> uPatientFamilies = uPatientFamilyRepository.findAllByPatientIdIn(otherPatientIds);
        LOGGER.info("开始备份目标患者{}的联系人", goalPatient.getPatientId());
        for (Long patientId : otherPatientIds) {
            LOGGER.info("将要备份的联系人-->{}", patientId);
        }

        if (uPatientFamilies.size() == 0) { //db 416179L 467612L 394765L 为0
            LOGGER.info("注意-->被合并患者{}的联系人数为0，备份略过...", otherPatientIds);
        }

        List<UPatientFamily> addedUPatientFamilies = new ArrayList<>();
        if (uPatientFamilies.size() > 0) {
            for ( UPatientFamily uPatientFamily : uPatientFamilies) {
           // uPatientFamilies.forEach(
                    //uPatientFamily -> {
                        Long mergeFrom = uPatientFamily.getPatientId();
                        Long mergeTarget = goalPatient.getPatientId();
                        Timestamp mergeTime = TimeUtils.getCurrentTimestamp();

                        //过滤重复的联系人信息
                        UPatientFamily patientFamily=uPatientFamilyRepository.findByPatientIdAndFamilyNameAndFamilyPhoneAndAddress(
                                goalPatient.getPatientId(),uPatientFamily.getFamilyName(),uPatientFamily.getFamilyPhone(),uPatientFamily.getAddress());
                        if(patientFamily==null){
                            //原表复制即可
                            UPatientFamily target = new UPatientFamily();
                            BeanUtils.copyProperties(uPatientFamily, target, "id", "patientId","contactId");//否则原值修改

                            target.setMergeFlag(1);
                            target.setPatientId(goalPatient.getPatientId());
                            target.setMergeFrom(mergeFrom);
                            target.setMergeTarget(mergeTarget);
                            target.setMergeTime(mergeTime);
                            target.setContactId(GeneralUtil.generateUniqueID("CONT"));
                            uPatientFamilyRepository.save(target);

                            addedUPatientFamilies.add(target);
                            LOGGER.info("被复制Id{}-->clone后Id-->{}", uPatientFamily.getId(), target.getId());
                        }
                        //标识为被合并,查询时应过滤
                        uPatientFamily.setMergeFlag(2);//标识被合并掉,todo 可能被合并多次...
                        uPatientFamily.setMergeFrom(mergeFrom);
                        uPatientFamily.setMergeTarget(mergeTarget);
                        uPatientFamily.setMergeTime(mergeTime);
                    }
        }

        LOGGER.info("目标患者{}追加了{}个联系人", goalPatient.getPatientId(), addedUPatientFamilies.size());
        LOGGER.info("目标患者{}追加了联系人-->{}", goalPatient.getPatientId(), addedUPatientFamilies);
    }

    /**
     * 去重联系人
     * 姓名 电话 地址 一致的进行去重
     * patientId也要一致
     *
     * @param goalPatient
     */
    // 5 4 3 2 1 1
    public void filterPatientFamilyDistinct(UPatient goalPatient) {
        //List<UPatientFamily> allByPatientIds = uPatientFamilyRepository.findAllByPatientIdIn(mergePatientIds);//这种情况会把复制到目标患者的新数据都当做是重复的给干掉
        List<UPatientFamily> allByPatientIds = uPatientFamilyRepository.findByPatientId(goalPatient.getPatientId());
        LOGGER.info("去重前");
        List<Long> allIds = new ArrayList<>();
        //allByPatientIds.forEach(uPatientFamily -> allIds.add(uPatientFamily.getId()));
        for (UPatientFamily uPatientFamily : allByPatientIds) {
            allIds.add(uPatientFamily.getId());
        }
        LOGGER.info("去重");
        List<Long> filterDistinctIds = new ArrayList<>();
       // allByPatientIds.stream().distinct().forEach(uPatientFamily -> filterDistinctIds.add(uPatientFamily.getId()));
        for (int i = 0; i < allByPatientIds.size(); i++) {
            for (int j = allByPatientIds.size()-1; j >i; j--) {
                if(compareStr(allByPatientIds.get(i).getFamilyName(),allByPatientIds.get(j).getFamilyName())
                    &&compareStr(allByPatientIds.get(i).getFamilyPhone(),allByPatientIds.get(j).getFamilyPhone())
                    &&compareStr(allByPatientIds.get(i).getAddress(),allByPatientIds.get(j).getAddress())){
                    allByPatientIds.remove(j);
                }
            }
            filterDistinctIds.add(allByPatientIds.get(i).getId());
        }
        LOGGER.info("所有id{}", allIds);
        LOGGER.info("去重后id{}", filterDistinctIds);
        allIds.removeAll(filterDistinctIds);
        List<Long> repeatIds = allIds;
        LOGGER.info("重复的id{}", repeatIds);

        if (repeatIds.size() > 0) {
            List<UPatientFamily> repeatUPatientFamilies = uPatientFamilyRepository.findAll(repeatIds);
            uPatientFamilyRepository.deleteInBatch(repeatUPatientFamilies);
        }

    }

    private boolean compareStr(String str1,String str2){
        if(!StringUtils.isBlank(str1)){
            return str1.equals(str2);
        }else if(!StringUtils.isBlank(str2)){
            return false;
        }else{
            return true;
        }
    }

    public void backupTargetTaskPatient(Long targetPatientId, List<RFollowupTaskPatient> taskPatients) {
        LOGGER.info("开始备份目标患者{}对应的taskPatients-->{}", targetPatientId, taskPatients);
        if (!taskPatients.isEmpty()) {
            for (RFollowupTaskPatient rFollowupTaskPatient : taskPatients) {
                        rFollowupTaskPatient.setMergeFlag(1);
                        RFollowupTaskPatientMergeBak rFollowupTaskPatientMergeBak = new RFollowupTaskPatientMergeBak();
                        BeanUtils.copyProperties(rFollowupTaskPatient, rFollowupTaskPatientMergeBak);
                        rFollowupTaskPatientMergeBak.setMergeFlag(1);
                        rFollowupTaskPatientMergeBak.setMergeTime(TimeUtils.getCurrentTimestamp());
                        rFollowupTaskPatientMergeBakRepository.save(rFollowupTaskPatientMergeBak);
                        LOGGER.info("备份目标患者[{}]-->任务Id[{}]成功", targetPatientId, rFollowupTaskPatient.getFollowupTaskId());
            }
        }

    }

    //public void cloneTaskForSinglePatient2TargetPatient(RFollowupTaskPatient targetTaskPatent, List<RFollowupTaskPatient> taskForSinglePatientList) {
    public void cloneTaskForSinglePatient2TargetPatient(Long targetPatentId, List<RFollowupTaskPatient> taskForSinglePatientList) {
        //先排除掉目标患者
        //有些多余，本身 taskForSinglePatientList就是一个的
        //List<RFollowupTaskPatient> targetTaskPatients = rFollowupTaskPatientRepository.findByPatientId(targetTaskPatent.getPatientId());

        List<RFollowupTaskPatient> tempList = new ArrayList<>();
        for (RFollowupTaskPatient rFollowupTaskPatient : taskForSinglePatientList) {
        //taskForSinglePatientList.forEach(rFollowupTaskPatient -> {
            if (rFollowupTaskPatient.getPatientId() == targetPatentId) {
                //taskForSinglePatientList.remove(rFollowupTaskPatient);
                tempList.add(rFollowupTaskPatient);
            }
        }
        taskForSinglePatientList.removeAll(tempList);

        //标记被合并的标志信息
        flagMergedTaskForSinglePatients(targetPatentId, taskForSinglePatientList);

        if (taskForSinglePatientList.size() > 0) {
            for (RFollowupTaskPatient rFollowupTaskPatient : taskForSinglePatientList) {
            //taskForSinglePatientList.forEach(
                //        rFollowupTaskPatient -> {
                        LOGGER.info("开始追加单个任务患者{}:{}到->目标患者{}", rFollowupTaskPatient.getFollowupTaskId(), rFollowupTaskPatient.getuPatientByPatientId(), targetPatentId);

                        //插入到目标患者下
                        RFollowupTaskPatient merge2Target = new RFollowupTaskPatient();

                        Long mergeFrom = rFollowupTaskPatient.getPatientId();
                        Long mergeTarget = targetPatentId;
                        Timestamp mergeTime = TimeUtils.getCurrentTimestamp();

                        BeanUtils.copyProperties(rFollowupTaskPatient, merge2Target, "id", "patientId");//否则原值修改

                        merge2Target.setMergeFlag(1);
                        merge2Target.setPatientId(targetPatentId);
                        merge2Target.setMergeFrom(mergeFrom);
                        merge2Target.setMergeTarget(mergeTarget);
                        merge2Target.setMergeTime(mergeTime);
                        rFollowupTaskPatientRepository.save(merge2Target);
                        LOGGER.info("追加任务{}到目标患者{}成功", rFollowupTaskPatient.getFollowupTaskId(), targetPatentId);
            }
        }
    }

    private void flagMergedTaskForSinglePatients(Long targetPatientId, List<RFollowupTaskPatient> taskForSinglePatientList) {
        Timestamp mergeTime = TimeUtils.getCurrentTimestamp();
        flagAppendToTargetPatient(targetPatientId, mergeTime, taskForSinglePatientList);
        rFollowupTaskPatientRepository.save(taskForSinglePatientList);
        LOGGER.info("标记被合并的taskPatient{}成功", taskForSinglePatientList);
    }


    /**
     * 相同任务的
     * 118 419944 568773  -> 如果存在目标患者， 保留优先级高的，也就是需要更新到目标患者身上ß，其它的标记被合并 [更新目标患者的随访状态 -> 去除该种设计]
     * 250 401021 568773  -> 若不存在目标患者，则追加250任务到目标患者，并按优先级选取保留  （一、患者随访完成状态 二、随访时间最近）
     * 249 401021         -> 追加到目标患者
     * 119 419944 568773
     * 220 419944
     *
     * @param targetPatientId
     * @param taskForMoreThanOnePatientMap
     * @param followupTaskIdsOfTargetPatient
     */
    public void cloneTaskForMoreThanOnePatient2TargetPatient(Long targetPatientId, Map<String, List<RFollowupTaskPatient>> taskForMoreThanOnePatientMap, List<String> followupTaskIdsOfTargetPatient) {
        List<RFollowupTaskPatient> taskPatientTargetPatientIn = new ArrayList<>();
        List<RFollowupTaskPatient> taskPatientTargetPatientNotIn = new ArrayList<>();
        Timestamp currentTimestamp = TimeUtils.getCurrentTimestamp();

        for (String taskId : taskForMoreThanOnePatientMap.keySet()){
            List<RFollowupTaskPatient> taskPatients=taskForMoreThanOnePatientMap.get(taskId);
        //taskForMoreThanOnePatientMap.forEach((taskId, taskPatients) -> {
            RFollowupTaskPatient retainedTaskPatient = voteRetainedTaskPatient(taskPatients);

            List<RFollowupTaskPatientMergeBak> rFollowupTaskPatientMergeBaks = new ArrayList<>();
            //目标患者在该任务当中
            if (followupTaskIdsOfTargetPatient.contains(taskId)) {
                //更新该条记录
                //taskId,targetPatientId -》keyTaskTarget
                RFollowupTaskPatient taskPatientForTargetPatient = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientId(taskId, targetPatientId);

                taskPatientForTargetPatient.setMergeFlag(1);
                taskPatientForTargetPatient.setMergeTime(currentTimestamp);
                BeanUtils.copyProperties(retainedTaskPatient, taskPatientForTargetPatient, "id", "patientId", "followupAssignId", "followupTaskId", "followupTaskByFollowupTaskId", "uPatientByPatientId");
                taskPatients.remove(taskPatientForTargetPatient);
                rFollowupTaskPatientRepository.save(taskPatientForTargetPatient);

                flagAppendToTargetPatient(targetPatientId, currentTimestamp, taskPatients);

            } else {
                RFollowupTaskPatient target = new RFollowupTaskPatient();
                BeanUtils.copyProperties(retainedTaskPatient, target, "id", "patientId");
                target.setPatientId(targetPatientId);
                target.setMergeFlag(2);//追加到了目标患者上,注意目标患者+mergeFlag=2 为追加的患者任务
                target.setMergeFrom(retainedTaskPatient.getPatientId());
                target.setMergeTarget(targetPatientId);
                target.setMergeTime(currentTimestamp);

                rFollowupTaskPatientRepository.save(target);
                flagAppendToTargetPatient(targetPatientId, currentTimestamp, taskPatients);
            }
        }

    }

    /**
     * @param targetPatientId
     * @param mergeTime
     * @param taskPatients
     */
    public void flagAppendToTargetPatient(Long targetPatientId, Timestamp mergeTime, List<RFollowupTaskPatient> taskPatients) {
        LOGGER.info("标记追加到目标患者[{}]的任务{}", targetPatientId, taskPatients);
        for (RFollowupTaskPatient source : taskPatients) {
        //taskPatients.forEach(source -> {
                    source.setMergeFlag(2);
                    source.setMergeFrom(source.getPatientId());
                    source.setMergeTarget(targetPatientId);
                    source.setMergeTime(mergeTime);
        }
        rFollowupTaskPatientRepository.save(taskPatients);
    }

    /**
     * 按照随访状态和随访时间最近的选取保留的随访任务
     * <p>
     * <p>
     * <p>
     * 一、患者随访完成状态
     * 1、已完成（有效结果，死亡>转移>复发>稳定>住院生存>门诊生存）
     * 2、已完成（无效结果）
     * 3、暂存
     * 4、未完成
     * <p>
     * 二、随访时间最近；
     * <p>
     * <p>
     * <p>
     * <p>r_followup_task_patient
     * <p>
     * `state` int(11) NOT NULL DEFAULT '0' COMMENT '随访状态。\r\n0: 未完成；1：暂存；2：已完成\r\n（如果随访结果是已死亡，则自动将state设为已完成）\r\n',
     * <p>
     * <p>
     * /**
     * resultValueId name  type 有效、无效
     * 1	稳定	1
     * 2	复发	1
     * 3	转移	1
     * 4	死亡	1
     * 5	其他情况	1
     * 7	无人接听	2
     * 8	空号	2
     * 9	错号	2
     * 10	拒绝随访	2
     * 11	主动拒接	2
     * 12	关机	2
     * 13	停机	2
     * 14	无法接通	2
     * 15	门诊生存	1
     * 16	住院生存	1
     *
     * @param taskPatients
     * @return
     */

    /**
     * prd描述
     * 一、患者随访完成状态
     * 1、已完成（有效结果，死亡>转移>复发>稳定>住院生存>门诊生存>好转）
     * 2、已完成（无效结果）
     * 3、暂存
     * 4、未完成
     * 二、随访时间最近；
     * 注：
     * 有效结果：指随访中结果为稳定11、复发12、转移13、死亡14、门诊生存15、住院生存16、好转17 ；
     * <p>
     * 无效结果：指随访中结果为主动拒接21、无人接听22、关机23、无法接通24、停机25、拒绝随访26、错号27、空号28； （无效结果：指随访中结果为无人接听、主动拒接、无法接通、关机、停机、错号、空号、拒绝随访；）
     * 随访结果为“其他情况”时，根据全局开关中“随访结果统计全局设置”开关判断是否为有效结果；
     * “其它情况” 19 或 29
     * <p>
     * 随访任务状态 随访结果
     * 随访时间
     * <p>
     * 保留的是{taskId,patientId} ，之后该追加或更新到目标患者
     * 随访结果也是使用改投票就好了
     *
     * @param taskPatients
     * @return
     */
    private RFollowupTaskPatient voteRetainedTaskPatient(List<RFollowupTaskPatient> taskPatients) {
        // 查询对应的随访结果状态 为了保留{taskId:patientId}
        // FollowupResult
        // 根据voteFollowupResultStateLevel进行比较,选举出再该任务中的最小值
        //需要先设置下全局开关的内容
        Integer otherAsValidResultFlag = confGlobalRepository.findAll().get(0).getOtherAsValidResultFlag();
        for (RFollowupTaskPatient rFollowupTaskPatient : taskPatients) {
       // taskPatients.forEach(rFollowupTaskPatient -> {
            long patientId = rFollowupTaskPatient.getPatientId();
            String taskId = rFollowupTaskPatient.getFollowupTaskId();
            LOGGER.info("patientId:{},taskId:{}", patientId, taskId);
            List<FollowupResult> followupResults = followupResultRepository.findByPatientIdAndFollowupTaskId(patientId, taskId);
            if (followupResults != null && followupResults.size() > 0) {
                MetaFollowupResultValue followupResultValue = followupResults.get(0).getMetaFollowupResultValueByFollowupResultValue();
                followupResults.get(0).setOtherAsValidResultFlag(otherAsValidResultFlag);
                Integer level = followupResults.get(0).getVoteFollowupResultStateLevel();
                VarPatientFollowup varPatientFollowup = varPatientFollowupRepository.findByPatientIdAndFollowupTaskId(patientId, taskId);
                rFollowupTaskPatient.setLevel(level);
                if (varPatientFollowup != null) {
                    //此方法暂时先不用，注释一下
                    //rFollowupTaskPatient.setLatestFollowupTime(varPatientFollowup.getLatestFollowupTime());
                }
                LOGGER.info(followupResultValue.toString());
            } else {
                VarPatientFollowup varPatientFollowup = varPatientFollowupRepository.findByPatientIdAndFollowupTaskId(patientId, taskId);
                rFollowupTaskPatient.setLevel(9999);//因为随访结果为空，因此这里对应的肯定没有level喽，就设置的很低
                //rFollowupTaskPatient.setLevel(14);//测试统计的时候，时间的排序 测试通过，即如果level相等，按照时间降序排列
                //rFollowupTaskPatient.setLevel(12); 13vs12 测试也是ok的
                rFollowupTaskPatient.setLatestFollowupTime("1970-01-01 00:00:00");//默认设置的时间非常远...
                if (varPatientFollowup != null) {
                    //此方法暂时先不用，注释一下
                    //rFollowupTaskPatient.setLatestFollowupTime(varPatientFollowup.getLatestFollowupTime());
                }
            }
        }

        LOGGER.info("排序前{}", taskPatients);
        /*taskPatients.sort((o1, o2) -> {
            if (o1.getLevel() == o2.getLevel()) {
                //比较最近的随访时间
                //LOGGER.info("按照最近随访时间的排序->{}", varPatientFollowups);
                return o2.getLatestFollowupTime().compareTo(o1.getLatestFollowupTime());
                //long patientId = varPatientFollowups.get(0).getPatientId();
            } else {
                return o1.getLevel().compareTo(o2.getLevel());
            }

        });*/
        Collections.sort(taskPatients, new Comparator<RFollowupTaskPatient>() {
            @Override
            public int compare(RFollowupTaskPatient o1, RFollowupTaskPatient o2) {
                if (o1.getLevel() == o2.getLevel()) {
                    //比较最近的随访时间
                    //LOGGER.info("按照最近随访时间的排序->{}", varPatientFollowups);
                    if(o1.getLatestFollowupTime()==null){
                        return 1;
                    }else if(o2.getLatestFollowupTime()==null){
                        return -1;
                    }else
                        return o2.getLatestFollowupTime().compareTo(o1.getLatestFollowupTime());
                } else {
                    return o1.getLevel().compareTo(o2.getLevel());
                }
            }
        });
        LOGGER.info("排序后{}", taskPatients);
        return taskPatients.get(0);
    }

    /**
     * 合并住院，诊断，手术，门诊，lis,pacs 随访电话、短信、微信记录
     *
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergePatientOtherInfo(Long goalPatientId, List<Long> otherPatientIds) {

        List<EiInhospitalNote> inhospitalNotes = inhospitalNoteService.mergeInhospitalNote(goalPatientId, otherPatientIds);
        outhospitalNoteService.mergeOuthospitalNote(goalPatientId, otherPatientIds,inhospitalNotes);
        diagnosisInfoService.mergeDiagnosisInfo(goalPatientId, otherPatientIds,inhospitalNotes);
        surgeryNoteService.mergeSurgeryNote(goalPatientId, otherPatientIds,inhospitalNotes);
        treatmentNoteService.mergeTreatNote(goalPatientId, otherPatientIds,inhospitalNotes);

        clinicMedicalNoteService.mergeClinicMedicalNote(goalPatientId, otherPatientIds);

        detectionReportService.mergeDetectionReport(goalPatientId, otherPatientIds);
        // detectionDetailService.mergeDetectionDetail(goalPatientId, otherPatientIds);
        examReportService.mergeExamReport(goalPatientId, otherPatientIds);

        followupCallReqService.mergeFollowupCallReq(goalPatientId, otherPatientIds);
        followupSmsReqService.mergeFollowupSmsReq(goalPatientId, otherPatientIds);
        followupWxReqService.mergeFollowupwxReq(goalPatientId, otherPatientIds);

        //患者科室信息
        deptPatientService.mergeDeptPatient(goalPatientId,otherPatientIds);

    }

    public void mergeFollowupResult(Long targetPatientId, List<Long> otherPatientIds, Long retainPatientId) {
        //followupResultService.merge(targetPatientId, otherPatientIds);
        //followupResultService.deleteFollowupResultAfterDeathDate(targetPatientId);
        //followupResultService.deleteFollowupResultAfterSpecificDeathDate(targetPatientId, retainPatientId);
        followupResultService.mergeFollowupResult(targetPatientId, otherPatientIds, retainPatientId);

        //更新患者的最近随访结果
        followupResultService.updateVarPatientFollowupResult(targetPatientId);
    }

    public void mergeFollowupResultBuff(Long targetPatientId, List<Long> otherPatientIds, Long retainPatientId) {
        followupResultBufferService.merge(targetPatientId, otherPatientIds);
        //followupResultBufferService.deleteFollowupResultAfterSpecificDeathDate(targetPatientId, retainPatientId);
    }

    public void log(MergePatientReq mergePatientReqInfo, Integer mergeResult) {
        mergeLogService.log(mergePatientReqInfo, mergeResult);
    }

    public void mergeLiveStatusInfo(Long targetPatientId, List<Long> otherPatientIds) {
        // patientService.merge(targetPatientId, otherPatientIds);
        patientService.mergeLiveStatus(targetPatientId);

    }

    public void mergeLostFollowupStatus(Long targetPatientId, List<Long> otherPatientIds) {
        // patientService.merge(targetPatientId, otherPatientIds);
        patientService.mergeLostFollowupStatus(targetPatientId, otherPatientIds);
        //patientService.mergeLostFollowupStatusAndCause(targetPatientId, otherPatientIds);

    }

    public void updateMergeStatus(Long targetPatientId, List<Long> mergePatientIds) {
        try {
            uuidPatientMergeService.updateMergeStatus(targetPatientId, mergePatientIds);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateDefaultFamilyPhone(Long targetPatientId) {
        List<UPatientFamily> patientFamilies = uPatientFamilyRepository.findByPatientIdAndIsDefault(targetPatientId, 1);
        if (patientFamilies.size() >= 2) {
            for (UPatientFamily uPatientFamily : patientFamilies) {
                LOGGER.info("患者联系人{}的最近就诊时间{}", uPatientFamily.getPatientId(),
                        uPatientFamily.getuPatientByPatientId().getVisitingTime());
            }

            /*patientFamilies.sort((o1, o2) ->
            {
                if(o2.getuPatientByPatientId().getVisitingTime()==null) {
                    return -1;
                }else if(o1.getuPatientByPatientId().getVisitingTime()==null){
                    return 1;
                }else {
                    return o2.getuPatientByPatientId().getVisitingTime()
                            .compareTo(o1.getuPatientByPatientId().getVisitingTime());
                }
            });*/

            Collections.sort(patientFamilies, new Comparator<UPatientFamily>() {
                @Override
                public int compare(UPatientFamily o1, UPatientFamily o2) {
                    if(o1.getuPatientByPatientId().getVisitingTime()==null) {
                        return 1;
                    }else if(o2.getuPatientByPatientId().getVisitingTime()==null){
                        return -1;
                    }else {
                        return o2.getuPatientByPatientId().getVisitingTime()
                                .compareTo(o1.getuPatientByPatientId().getVisitingTime());
                    }
                }
            });

            UPatientFamily uPatientFamilyLatestVisited = patientFamilies.get(0);
            LOGGER.info("要保留{}的默认联系人电话->{},其就诊时间为->{}",
                    uPatientFamilyLatestVisited.getPatientId(),
                    uPatientFamilyLatestVisited.getFamilyPhone(),
                    uPatientFamilyLatestVisited.getuPatientByPatientId().getVisitingTime());

            patientFamilies.remove(uPatientFamilyLatestVisited);
            for (UPatientFamily patientFamily : patientFamilies) {
                patientFamily.setIsDefault(0);//除去就诊时间最近的为默认，其它都非默认好了。
            }
            uPatientFamilyRepository.save(patientFamilies);
        }

    }

    /**
     * 合并后需要执行刷新的脚本
     * @return
     */
    public boolean flushTaskPatientStateAndNumber(){
        try {
            return patientMergeRepository.flushTaskPatientStateAndNumber();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * 将目标患者的syncFlag 1 -> 2
     * 被合并患者的syncFlag 1 -> 3
     * 如果目标患者的syncFlag -3 -> 0
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void updatePatientSyncFlag(Long goalPatientId, List<Long> otherPatientIds){
        try {
            //UPatient patient=patientRepository.findByPatientId(goalPatientId);
            ////if(patient.getSyncFlag()!=null&&patient.getSyncFlag().equals(-3)){
            ////    patient.setSyncFlag(0);
            ////    uPatientRepository.save(patient);
            ////}
            ////处理目标患者
            //TPatientSyncResultClient patientSyncResult=patientSyncResultClientRepository.findOne(patient.getUuid());
            //if(patientSyncResult==null){
            //    patientSyncResult=this.insertPatientSyncResultClient(patient);
            //}
            //if(patientSyncResult.getSyncFlag()!=null&&patientSyncResult.getSyncFlag().equals(1)){
            //    patientSyncResult.setSyncFlag(2);
            //    patientSyncResultClientRepository.save(patientSyncResult);
            //}else if(patientSyncResult.getSyncFlag()!=null&&patientSyncResult.getSyncFlag().equals(-3)){
            //    patientSyncResult.setSyncFlag(0);
            //    patientSyncResultClientRepository.save(patientSyncResult);
            //}
            ////处理被合并患者
            //List<UPatient> patients=patientRepository.findAllByPatientIdIn(otherPatientIds);
            //TPatientSyncResultClient psc=null;
            //for (UPatient uPatient : patients){
            //    psc=patientSyncResultClientRepository.findOne(uPatient.getUuid());
            //    if(psc==null){
            //        psc=this.insertPatientSyncResultClient(uPatient);
            //    }
            //    if(psc.getSyncFlag()!=null&&psc.getSyncFlag().equals(1)) {
            //        psc.setSyncFlag(3);
            //        patientSyncResultClientRepository.save(psc);
            //    }else{
            //        psc.setSyncFlag(-3);
            //        patientSyncResultClientRepository.save(psc);
            //    }
            //}
            UPatient patient=patientRepository.findByPatientId(goalPatientId);
            patient.setHandleFlag(0);
            patientRepository.save(patient);
            List<UPatient> patients=patientRepository.findAllByPatientIdIn(otherPatientIds);
            for (UPatient patient1 : patients){
                patient1.setHandleFlag(0);
            }
            patientRepository.save(patients);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 若没有Client则创建
     * @param patient
     */
    private TPatientSyncResultClient insertPatientSyncResultClient(UPatient patient){
        TPatientSyncResultClient client=new TPatientSyncResultClient();
        client.setSyncFlag(0);
        if(patient.getSyncFlag()!=null)client.setSyncFlag(patient.getSyncFlag());
        client.setUuid(patient.getUuid());
        client.setCreateTime(TimeUtils.getCurrentTimestamp());
        client.setUpdateTime(TimeUtils.getCurrentTimestamp());
        patientSyncResultClientRepository.save(client);
        return client;
    }

    /**
     * 合并时更新患者的病案号关联
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void updateUuidPatientNo(Long goalPatientId, List<Long> otherPatientIds) {
        try {
            UPatient targetPatient=patientRepository.findByPatientId(goalPatientId);
            for (Long patientId : otherPatientIds){
                UPatient patient=patientRepository.findByPatientId(patientId);
                RUuidPatientno uuidPatientno=uuidPatientnoRepository.findByPatientNo(patient.getPatientNo());
                if(uuidPatientno==null){
                    uuidPatientno=new RUuidPatientno();
                    uuidPatientno.setCreateTime(TimeUtils.getCurrentTimestamp());
                    uuidPatientno.setType(2);
                    uuidPatientno.setPatientNo(patient.getPatientNo());
                }
                uuidPatientno.setUpdateTime(TimeUtils.getCurrentTimestamp());
                uuidPatientno.setNewPatientNo(targetPatient.getPatientNo());
                uuidPatientno.setUuid(targetPatient.getUuid());
                uuidPatientno.setFlag(1);
                uuidPatientno.setPatientId(targetPatient.getPatientId());
                uuidPatientnoRepository.save(uuidPatientno);
                /*TUuidPatientnoSyncResultClient psc=patientnoSyncResultClientRepository.findOne(uuidPatientno.getId());
                if(psc.getSyncFlag()!=null&&psc.getSyncFlag().equals(1)){
                    psc.setSyncFlag(2);
                    patientnoSyncResultClientRepository.save(psc);
                }*/
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 撤销时更新患者的病案号关联
     * @param goalPatientId
     */
    public void cancleUpdateUuidPatientNo(Long goalPatientId) {
        List<UPatient> patients=patientRepository.findByMergeTarget(goalPatientId);
        for (UPatient patient : patients){
            RUuidPatientno uuidPatientno=uuidPatientnoRepository.findByPatientNo(patient.getPatientNo());
            if(uuidPatientno==null){
                uuidPatientno=new RUuidPatientno();
                uuidPatientno.setCreateTime(TimeUtils.getCurrentTimestamp());
                uuidPatientno.setPatientNo(patient.getPatientNo());
                uuidPatientno.setType(2);
            }
            uuidPatientno.setUpdateTime(TimeUtils.getCurrentTimestamp());
            uuidPatientno.setNewPatientNo(patient.getPatientNo());
            uuidPatientno.setUuid(patient.getUuid());
            uuidPatientno.setFlag(0);
            uuidPatientno.setPatientId(patient.getPatientId());
            uuidPatientnoRepository.save(uuidPatientno);
        }
    }

    /**
     * 回滚时更新患者的同步标识
     * @param targetPatientId
     * @param otherPatientIds
     */
    public void rollbackPatientSyncFlag(Long targetPatientId, List<Long> otherPatientIds) {
        try {
            UPatient targetPatient=patientRepository.findByPatientId(targetPatientId);
            TPatientSyncResultClient patientSyncResult=patientSyncResultClientRepository.findOne(targetPatient.getUuid());
            if(patientSyncResult==null){
                patientSyncResult=this.insertPatientSyncResultClient(targetPatient);
            }
            //if(patientSyncResult.getSyncFlag().equals(1)||patientSyncResult.getSyncFlag().equals(2)){
            //    patientSyncResult.setSyncFlag(2);
            //}else{
            //    patientSyncResult.setSyncFlag(0);
            //}
            patientSyncResult.setSyncFlag(0);
            patientSyncResultClientRepository.save(patientSyncResult);
            for (Long patientId : otherPatientIds){
                if(!patientId.equals(targetPatientId)){
                    UPatient patient=patientRepository.findByPatientId(patientId);
                    TPatientSyncResultClient psa=patientSyncResultClientRepository.findOne(patient.getUuid());
                    if(psa==null){
                        psa=this.insertPatientSyncResultClient(patient);
                    }else{
                        psa.setSyncFlag(0);
                        patientSyncResultClientRepository.save(psa);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 更新患者相关信息的handleFlag(用于工蜂自动刷新相关数据)
     * @param patientId
     */
    public void updateHandleFlag(Long patientId) {
        //更新诊断handleFlag
        patientService.flushPatientDisease(patientId);
        diagnosisInfoService.updateHandleFlagByPatientId(patientId);

    }



}

package com.esuizhen.bigdata.merge.impl;

import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.common.ConstantsUtils;
import com.esuizhen.bigdata.domain.ehr.VarPatientMedical;
import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.domain.followup.RFollowupTaskPatient;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UPatientFamily;
import com.esuizhen.bigdata.domain.user.UUser;
import com.esuizhen.bigdata.domain.user.UuidPatientMerge;
import com.esuizhen.bigdata.merge.AbstractMergeBean;
import com.esuizhen.bigdata.repository.followup.FollowupResultBufferRepository;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.repository.followup.RFollowupTaskPatientRepository;
import com.esuizhen.bigdata.repository.followup.VarPatientMedicalRepository;
import com.esuizhen.bigdata.repository.user.*;
import com.esuizhen.bigdata.service.EntityBakService;
import com.esuizhen.bigdata.utils.PrintUtils;
import com.google.common.collect.Maps;
import org.joda.time.DateTimeUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by fqc on 16/12/2.
 * 患者基本信息相关合并
 */
//@Service
@Transactional
public class MergePatientService extends AbstractMergeBean {
    //反射注入
    //@Autowired
    private UPatientRepository uPatientRepository;
    private UuidPatientMergeRepository uuidPatientMergeRepository;
    private VarPatientMedicalRepository varPatientMedicalRepository;
    private UPatientFamilyRepository uPatientFamilyRepository;
    private UPatientMergeBakRepository uPatientMergeBakRepository;
    private UUserRepository uUserRepository;
    private UUserMergeBakRepository uUserMergeBakRepository;

    private RFollowupTaskPatientRepository rFollowupTaskPatientRepository;
    private FollowupResultRepository followupResultRepository;
    private FollowupResultBufferRepository followupResultBufferRepository;

    private EntityBakService entityBakService;


    public MergePatientService(Long goalPatientId, List<Long> otherPatientIds, MergePatientReq beanInfo, String operatorId) {
        super(goalPatientId, otherPatientIds, beanInfo, operatorId);
    }

    public MergePatientService() {
    }

    public MergePatientService(Long goalPatientId, List<Long> otherPatientIds, MergePatientReq beanInfo, String operatorId, Map<String, JpaRepository> repositoryMap, EntityBakService entityBakService) {
        super(goalPatientId, otherPatientIds, beanInfo, operatorId, repositoryMap, entityBakService);
        this.setuPatientRepository((UPatientRepository) this.getRepositoryMap().get("uPatientRepository"));
        this.setUuidPatientMergeRepository((UuidPatientMergeRepository) this.getRepositoryMap().get("uuidPatientMergeRepository"));
        this.setFollowupResultRepository((FollowupResultRepository) this.getRepositoryMap().get("followupResultRepository"));
        this.setVarPatientMedicalRepository((VarPatientMedicalRepository) this.getRepositoryMap().get("varPatientMedicalRepository"));
        this.setuPatientFamilyRepository((UPatientFamilyRepository) this.getRepositoryMap().get("uPatientFamilyRepository"));
        this.setuPatientMergeBakRepository((UPatientMergeBakRepository) this.getRepositoryMap().get("uPatientMergeBakRepository"));
        this.setuUserRepository((UUserRepository) this.getRepositoryMap().get("userRepository"));
        this.setuUserMergeBakRepository((UUserMergeBakRepository) this.getRepositoryMap().get("uUserMergeBakRepository"));
        this.setFollowupResultRepository((FollowupResultRepository) this.getRepositoryMap().get("followupResultRepository"));
        this.setFollowupResultBufferRepository((FollowupResultBufferRepository) this.getRepositoryMap().get("followupResultBufferRepository"));
        this.setrFollowupTaskPatientRepository((RFollowupTaskPatientRepository) this.getRepositoryMap().get("rFollowupTaskPatientRepository"));
        this.entityBakService = entityBakService;
    }


    /**
     * 预定义的按时间优先级 需要补位的空字段
     * 需要按照优先级，补位填充的基本信息字段
     */
    //ArrayList<String> preEmptyFieldList = Lists.newArrayList(
    //        //ConstantsUtils.TRUENAME, ConstantsUtils.SEX,
    //        //ConstantsUtils.BIRTHDATE, ConstantsUtils.IDENTIFICATION,
    //        ConstantsUtils.BIRTHPLACEADDRESS, //ConstantsUtils.PATIENTNO,
    //        ConstantsUtils.NATION, ConstantsUtils.COUNTRY,
    //        ConstantsUtils.CITY, ConstantsUtils.NATIVEPLACE,
    //        //ConstantsUtils.BIRTHPLACEADDRESS
    //        ConstantsUtils.BIRTHPLACECODE
    //);
    ArrayList<String> preEmptyFieldList=new ArrayList<String>() {
        {
            add(ConstantsUtils.BIRTHPLACEADDRESS);
            add(ConstantsUtils.NATION);
            add(ConstantsUtils.COUNTRY);
            add(ConstantsUtils.CITY);
            add(ConstantsUtils.NATIVEPLACE);
            add(ConstantsUtils.BIRTHPLACECODE);
        }
    };


    /**
     * 婚姻状态和职业字段
     */
    ArrayList<String> marrayAndJobList = new ArrayList<String>(){{
        add(ConstantsUtils.MARRIAGESTATUS);
        add(ConstantsUtils.OCCUPATIONID);
    }};

           // Lists.newArrayList(ConstantsUtils.MARRIAGESTATUS, ConstantsUtils.OCCUPATIONID);

    /**
     * 生存状态，死亡时间，死亡原因字段
     */
    ArrayList<String> liveInfoList = new ArrayList<String>(){{
        add(ConstantsUtils.LIVESTATUS);
        add(ConstantsUtils.DEATHDATE);
        add(ConstantsUtils.CAUSEOFDEATH);
    }};

          //  Lists.newArrayList(ConstantsUtils.LIVESTATUS, ConstantsUtils.DEATHDATE, ConstantsUtils.CAUSEOFDEATH);

    //合并组(逆序、升序集合)
    ArrayList<UPatient> mergeGroupOrderByPatientCreateTimeDesc;
    ArrayList<UPatient> mergeGroupOrderByPatientCreateTimeAsc;
    List<UPatient> mergeGroupOrderByPatientVisitingTimeAsc;

    List<String> followupTaskIdsOfTargetPatient;
    Map<String, List<RFollowupTaskPatient>> tasksOfPatient;

    Map<String, List<RFollowupTaskPatient>> taskForSinglePatientMap;
    Map<String, List<RFollowupTaskPatient>> taskForMoreThanOnePatientMap;

    List<RFollowupTaskPatient> taskForSinglePatientList;
    List<RFollowupTaskPatient> taskForMoreThanOnePatientList;
    List<RFollowupTaskPatient> taskPatients;

    /**
     * ******合并原则************************************************************
     * 以下表会有对应的备份表(命名方式原表名_merge_bak)，只是在原有基础表增加mergeFrom、mergeTarget字段，patientType字段 - 1 代表原有对象软删除。
     * 对目标患者更新操作的 进行备份表 +更新目标患者。
     * 对目标患者新增操作的 原表复制+新增被合并患者到目标患者。
     * 对应的mergeFrom, mergeTarget、patientType相应的修改。
     * ******************************************************************
     *
     * @throws InterruptedException
     */
    @Override
    //@Transactional
    public void executeMerge() throws Exception {
        //Exception ex = null;
        Integer mergeResult = 0;
        //try {
            LOGGER.info("==> 患者相关信息开始合并--->");



            initPatientRelatedInfo();
            initFollowupReleatedInfo();
            backupAndFlagMergedEntities();
            entityBakService.mergeFollowupResult(goalPatientId, otherPatientIds, mergePatientReqInfo.getRetainPatientId());
            //entityBakService.mergeFollowupResultBuff(goalPatientId, otherPatientIds, mergePatientReqInfo.getRetainPatientId());
            mergePersonalInfo();
            mergePersonalMarriedAndJob();
            //合并手机号(新版本没有)
            //mergeMobileAndSaveIntoFamilyAsSelf(varPatientMedicalListOrderByOutHospitalTimeAsc());
            //mergeFamilyInfo();
            //合并死亡状态、时间及原因 v2版本
            entityBakService.mergeLiveStatusInfo(goalPatientId, otherPatientIds);
            entityBakService.mergeLostFollowupStatus(goalPatientId, otherPatientIds);

            LOGGER.info("==> 住院诊断等信息合并开始-->");
            entityBakService.mergePatientOtherInfo(goalPatientId, otherPatientIds);
            LOGGER.info("==> 住院诊断等信息合并结束-->");

            LOGGER.info("==> 合并后刷新脚本flushTaskPatientStateAndNumber开始-->");
            boolean result=entityBakService.flushTaskPatientStateAndNumber();
            LOGGER.info("==> 合并后刷新脚本flushTaskPatientStateAndNumber结束-->{}",result);

            //合并所有动作完成后修改 失败后回滚即可。之后的脚本是最终一致性使用
            entityBakService.updateMergeStatus(goalPatientId, mergePatientIds);
            //更新患者的handFlag
            entityBakService.updatePatientSyncFlag(goalPatientId,otherPatientIds);
            //患者UUID-就诊号关联
            entityBakService.updateUuidPatientNo(goalPatientId, otherPatientIds);
            //更新目标患者的处理标识，以作病种刷新等其他数据的刷新
            entityBakService.updateHandleFlag(goalPatientId);
            mergeResult = 1;
            LOGGER.info("-->患者合并执行完成，结果成功");
            LOGGER.info("记录成功日志中....");
            entityBakService.log(mergePatientReqInfo, mergeResult);
            //int a = 1 / 0;
        /*} catch (Exception e) {
            LOGGER.info("出现异常-->message:{},stackMessage:{},之前操作开始回滚", e.getMessage(), e.getStackTrace());
            ex = e;
            //throw new RuntimeException(ex);
        } finally {
            if (null != ex) {
                LOGGER.info("-->合并失败");
                LOGGER.info("记录错误日志中....");
                entityBakService.log(mergePatientReqInfo, mergeResult);
                //uPatientRepository.save(new UPatient(100000000L, "fengqc")); //这里可能也会异常哦~~
                throw new RuntimeException(ex);//the golden line
                //return;
            }
            LOGGER.info("-->患者合并执行完成，结果成功");
            LOGGER.info("记录成功日志中....");
            entityBakService.log(mergePatientReqInfo, mergeResult);

        }*/
    }



    private void initFollowupReleatedInfo() {
        targetPatientFollowupTasks = rFollowupTaskPatientRepository.findByPatientId(goalPatientId);
        otherPatientFollowupTasks = rFollowupTaskPatientRepository.findByPatientIdIn(otherPatientIds);
        taskPatients = rFollowupTaskPatientRepository.findByPatientIdIn(mergePatientIds);
        tasksOfPatient = fetchFollowupTaskOfMergeGroup(mergePatientIds);
        initSingleAndMoreThanOneTasksOfPatient(tasksOfPatient);
    }

    /**
     * λ	在不同任务中的患者，用合并患者替换；随访状态取在本任务中原患者的随访状态；
     * (相当于只把PatientId替换掉,合并患者为准，也就是说看合并患者的任务，不包含在内的)
     * λ	在同一个任务中，有两个或以上原患者时，根据优先级保留患者随访状态；
     * (这里不再考虑目标患者的优先级了，也就是说 A B C的随访状态按照三者优先级高的保存，
     * 结论：根据优先级获取随访状态，更新目标患者。其他的mergeFlag置为2)
     * <p>
     * 总之：
     * 1. 备份目标患者的taskPatient，不同任务(排除目标患者的任务s)累加到目标患者（随访状态不变，不用考虑）
     * 2. 同一任务中，根据优先级取出随访状态更新到目标患者。其它的标记下就行，之后再还原。
     * 3. 目标患者的任务都是要备份的，是不知道哪个再同一任务中的。
     * <p>
     * <p>
     * <p>
     * <p>
     * 同一个任务中多个合并前患者的优先级：
     * 一、患者随访完成状态
     * 1、已完成（有效结果，死亡>转移>复发>稳定>住院生存>门诊生存）
     * 2、已完成（无效结果）
     * 3、暂存
     * 4、未完成
     * 二、随访时间最近；
     *
     * @param tasksOfPatient
     */
    private void initSingleAndMoreThanOneTasksOfPatient(Map<String, List<RFollowupTaskPatient>> tasksOfPatient) {
        taskForSinglePatientList = new ArrayList<>();
        taskForMoreThanOnePatientList = new ArrayList<>();

        taskForSinglePatientMap = Maps.newHashMap();
        taskForMoreThanOnePatientMap = Maps.newHashMap();

        followupTaskIdsOfTargetPatient = new ArrayList<>();
        for (RFollowupTaskPatient rFollowupTaskPatient :targetPatientFollowupTasks) {
            //targetPatientFollowupTasks.forEach(rFollowupTaskPatient -> {
            followupTaskIdsOfTargetPatient.add(rFollowupTaskPatient.getFollowupTaskId());
        }

        for (String taskId : tasksOfPatient.keySet()) {
            List<RFollowupTaskPatient> taskOfPatients=tasksOfPatient.get(taskId);
        //tasksOfPatient.forEach(
                //(taskId, taskOfPatients) -> {
                    if (1 == taskOfPatients.size()) {//不同任务
                        taskForSinglePatientList.addAll(taskOfPatients);
                        taskForSinglePatientMap.put(taskId, taskOfPatients);
                    } else if (1 < taskOfPatients.size()) {//同一任务中
                        taskForMoreThanOnePatientList.addAll(taskOfPatients);
                        taskForMoreThanOnePatientMap.put(taskId, taskOfPatients);
                    }
        }

        LOGGER.info("目标患者{{}}的taskIds->{}", goalPatientId, followupTaskIdsOfTargetPatient);
        LOGGER.info("不同任务的taskPatient组");
        LOGGER.info(taskForSinglePatientList.toString());
        LOGGER.info(taskForSinglePatientMap.toString());
        LOGGER.info("相同任务的taskPatient组");
        LOGGER.info(taskForMoreThanOnePatientList.toString());
        LOGGER.info(taskForMoreThanOnePatientMap.toString());
    }

    /**
     * 合并组任务Id对应的患者 即{followupTaskId:List<rFollowupTaskPatient>}
     * <p>
     * 实际数据情况可能如下：
     * j1-->A
     * j2-->B C
     * j3-->D A
     * j1-->B
     *
     * @param mergePatientIds
     * @return
     */
    private Map<String, List<RFollowupTaskPatient>> fetchFollowupTaskOfMergeGroup(List<Long> mergePatientIds) {
        List<RFollowupTaskPatient> followupTasksOfPatient = rFollowupTaskPatientRepository.findByPatientIdIn(mergePatientIds);
        Map<String, List<RFollowupTaskPatient>> tasksOfPatient = Maps.newHashMap();

        for (RFollowupTaskPatient rFollowupTaskPatient :followupTasksOfPatient){
        //followupTasksOfPatient.forEach(rFollowupTaskPatient -> {
            String key = rFollowupTaskPatient.getFollowupTaskId();
            List<RFollowupTaskPatient> followupTaskPatients = new ArrayList<>();
            followupTaskPatients = rFollowupTaskPatientRepository.findByFollowupTaskIdAndPatientIdIn(key, mergePatientIds);
            tasksOfPatient.put(key, followupTaskPatients);
        }

        LOGGER.info("任务id与患者的对应-->{}", tasksOfPatient.toString());
        return tasksOfPatient;
    }


    /**
     * 备份表相关
     * <p>
     * 将被更新的数据备份,被合并的患者数据做标记
     */
    @Transactional
    private void backupAndFlagMergedEntities() {

        //entityBakService.backupTargetTaskPatient(goalPatientId, targetPatientFollowupTasks);
        //entityBakService.cloneTaskForSinglePatient2TargetPatient(goalPatientId, taskForSinglePatientList);
        //entityBakService.cloneTaskPaitents2TargetPatient(goalPatient, taskForMoreThanOnePatientList);
        //同一任务中的随访状态按照优先级来选择更新到目标患者上，其他的标记被合并状态即可。

        /**
         * 不同任务中
         118 419944 568773  -> 如果存在目标患者， 更新目标患者的随访状态 ，其它的标记被合并
         250 401021 568773  -> 若不存在目标患者，则追加250任务到目标患者，并按优先级选取保留  （一、患者随访完成状态 二、随访时间最近）
         249 401021         ->追加到目标患者
         */
        //entityBakService.cloneTaskForMoreThanOnePatient2TargetPatient(goalPatientId, taskForMoreThanOnePatientMap, followupTaskIdsOfTargetPatient);

        entityBakService.backupGoalPatient(goalPatient);
        entityBakService.flagMergedPatients(goalPatient, otherPatients);

        entityBakService.backupUserOfGoalPatient(goalPatient, otherPatients);
        entityBakService.flagMergedUsers(goalPatient, otherPatients);

        entityBakService.cloneFamilies2GoalPatient(goalPatient, otherPatientIds);
        //entityBakService.filterPatientFamilyDistinct(goalPatient);
        entityBakService.updateDefaultFamilyPhone(goalPatientId);


    }

    @Deprecated
    private void mergeFamilyInfo() {
        //*******************************************************************
        //        联系人信息 V1需求
        //将所有重复患者信息累加后去重 [该需求和唯一性约束是矛盾的，也就是插入的时候重复就不能够插入]
        //*******************************************************************
        //u_patient
        // `patientRelation` int(11) DEFAULT '0' COMMENT '与患者关系。\r\n0: 本人；(默认)\r\n1：家属\r\n',
        //`familyName` varchar(100) DEFAULT NULL COMMENT '家属姓名',
        //`familyPhone` varchar(100) DEFAULT NULL COMMENT '家属电话',
        for (UPatient uPatient : mergeGroupOrderByPatientCreateTimeAsc) {
        //mergeGroupOrderByPatientCreateTimeAsc.forEach(uPatient -> {
            List<UPatientFamily> patientFamilyList = uPatientFamilyRepository.findByPatientId(uPatient.getPatientId());
            for (UPatientFamily uPatientFamily :patientFamilyList) {
                //patientFamilyList.forEach(uPatientFamily ->
                uPatientFamily.setPatientId(goalPatient.getPatientId());
            }
        }

    }


    /**
     * 该功能由于 需求和开发矛盾, 开发是从患者表将联系信息刷出来的内容,标记来回来去的...f...k。。。
     * 至此按新需求开发
     *
     * @param varPatientMedicalList
     */
    @Deprecated
    private void mergeMobileAndSaveIntoFamilyAsSelf(List<VarPatientMedical> varPatientMedicalList) {

        // patient和user是不能够先删除的，最后删除前要先保留,而且一定要在初始化的时候就要保留(因为后面的数据会被修改污染[为了避免唯一性、外键约束...])。
        //*******************************************************************
        //      手机号
        // 若完全相同则保留一个；
        // 若不同，则保留新的手机号（最近病案的出院时间），将原来的手机号存入联系人列表中（标注关系为“本人”）。
        //*******************************************************************
        for (VarPatientMedical varPatientMedical:varPatientMedicalList){
        //varPatientMedicalList.forEach(
                //varPatientMedical -> {
                    UPatient patient = uPatientRepository.findByPatientId(varPatientMedical.getPatientId());
                    String mobile = patient.getMobile();
                    if (!StringUtils.isEmpty(mobile)) {
                        //预判断是否由约束冲突的数据，这里就去除掉
                        UPatientFamily preFindUpatientFamily = uPatientFamilyRepository.findByPatientIdAndFamilyPhoneAndFamilyNameAndAddress(goalPatientId, mobile, goalPatient.getTrueName(), patient.getuUserByUserId().getAddress());
                        if (null == preFindUpatientFamily) {
                            // 将原来的手机号保存到联系人中 goalPatient.getMobile();
                            UPatientFamily uPatientFamily = new UPatientFamily();
                            uPatientFamily.setPatientId(goalPatientId);
                            uPatientFamily.setFamilyPhone(mobile);
                            uPatientFamily.setPatientRelation(0);//本人
                            uPatientFamily.setFamilyName(goalPatient.getTrueName());//保留原先的姓名
                            uPatientFamily.setRawCreateTime(new java.sql.Timestamp(DateTimeUtils.currentTimeMillis()));
                            uPatientFamily.setCreateTime(new java.sql.Timestamp(DateTimeUtils.currentTimeMillis()));
                            uPatientFamily.setAddress(patient.getuUserByUserId().getAddress()); //这里会导致约束问题 null可以避免，但是实际上这样就让数据缺失了，因此需要先判断下这种约束的

                            uPatientFamily.setuPatientByPatientId(goalPatient);
                            uPatientFamily.setIsValid(1);
                            uPatientFamily.setRemark("本人,由patientNo->" + patient.getPatientNo() + "合并到goalPatientNo->" + goalPatient.getPatientNo() + "而来");

                            uPatientFamilyRepository.saveAndFlush(uPatientFamily);
                        }

                    }

        }
        // A B C 比如将c的手机号给了A
        // 此时 A C的手机号是相同的  会违反UNIQUE KEY `UNI_PATIENT_MOBILE_SYNCFLAG` (`syncFlag`,`mobile`) USING BTREE,
        //得先更新掉，如果在与upatientFamily一起更新的话，会出现约束问题和session问题
        VarPatientMedical varPatientMedical3 = varPatientMedicalList.get(varPatientMedicalList.size() - 1);//新的手机号（最近病案的出院时间）
        UPatient patient3 = uPatientRepository.findByPatientId(varPatientMedical3.getPatientId());
        //再更新合并手机号 (即使前面通过了，且也flush了，但如果后面发生异常（比如外键、唯一性约束等冲突），还是一样的回滚)
        String mobile = patient3.getMobile();
        patient3.setMobile(null);//避免唯一性约束问题,这个患者之后肯定会被删的，基本没啥用了..之前会备份且数据是最原始的，后面影响了数据原样，做删除是没问题的。
        patient3.getuUserByUserId().setMobile(null);
        uPatientRepository.saveAndFlush(patient3);
        if (!StringUtils.isEmpty(mobile)) {
            goalPatient.setMobile(mobile);
            goalPatient.getuUserByUserId().setMobile(mobile);
        }
    }

    private List<VarPatientMedical> getVarPatientMedicalList() {
        ArrayList<UPatient> mergeGroup = getMergeGroupOrderByCreateTimeDesc();//顺序不会影响之后的排序
        List<VarPatientMedical> varPatientMedicalList = new ArrayList<>();
        for (UPatient uPatient : mergeGroup) {
        //mergeGroup.forEach(uPatient -> {
            VarPatientMedical varPatientMedical = varPatientMedicalRepository.findByPatientId(uPatient.getPatientId());
            varPatientMedicalList.add(varPatientMedical);
        }
        return varPatientMedicalList;
    }

    private List<VarPatientMedical> varPatientMedicalListOrderByLatestClinicDateDesc() {
        List<VarPatientMedical> varPatientMedicalList = getVarPatientMedicalList();
        //就诊时间降序
        //varPatientMedicalList.sort((o1, o2) -> o2.getLatestOutHospitalDate().compareTo(o1.getLatestOutHospitalDate()));
        Collections.sort(varPatientMedicalList, new Comparator<VarPatientMedical>() {
            @Override
            public int compare(VarPatientMedical o1, VarPatientMedical o2) {
                if(o1.getLatestOutHospitalDate()==null){
                    return 1;
                }else if(o2.getLatestOutHospitalDate()==null){
                    return -1;
                }else{
                    return o2.getLatestOutHospitalDate().compareTo(o1.getLatestOutHospitalDate());
                }
            }
        });
        return varPatientMedicalList;
    }


    private List<VarPatientMedical> varPatientMedicalListOrderByOutHospitalTimeAsc() {
        List<VarPatientMedical> varPatientMedicalList = getVarPatientMedicalList();
        //出院时间升序
        //varPatientMedicalList.sort((o1, o2) -> o1.getLatestOutHospitalDate().compareTo(o2.getLatestOutHospitalDate()));
        Collections.sort(varPatientMedicalList, new Comparator<VarPatientMedical>() {
            @Override
            public int compare(VarPatientMedical o1, VarPatientMedical o2) {
                if(o1.getLatestOutHospitalDate()==null){
                    return 1;
                }else if(o2.getLatestOutHospitalDate()==null){
                    return -1;
                }else{
                    return o1.getLatestOutHospitalDate().compareTo(o2.getLatestOutHospitalDate());
                }
            }
        });
        return varPatientMedicalList;
    }


    private void mergeDeathRelatedInfo_V1(List<UPatient> mergeGroupOrderByPatientCreateTimeAsc) {

        //***********生存状态合并 v1版本***************************************
        //死亡状态、时间及原因  v1
        //重复患者中有死亡状态的，优先取死亡状态，
        //如有两条以上死亡状态的，取死亡随访结果中随访时间较早的死亡相关记录（死亡状态、随访时间、随访结果、死亡时间、死亡原因等数据）
        //先看是否为死亡状态 ，如果有一个，则将状态改为死亡
        //之后看如果 list<is death>.size>2  则按照随访中的相关较早记录中补充。 如果没有随访，则不去填充了。


        //*******************************************************************
        //这里不要用反射，因为字段和字段值都是确定的，就是liveStatus=0的患者。与上面的合并是不同的，不确定哪个字段为空
        //另外，如果三个患者重复ABC ,B的死亡原因为空，C的死亡原因不为空，这种情况不予以补位。谁知道它哪个为准。业务上也不知道哪个更合理。
        //之后跟产品沟通，以随访结果中的为准。

        //按照死亡时间来倒序排列，如果死亡时间为空，则按照创建时间倒序排列
        /*ArrayList<UPatient> uPatientForLiveList = uPatientList;
        uPatientForLiveList.sort((o1, o2) -> {
            if (!o2.getDeathDate().equals(o1.getDeathDate())) {
                return o2.getDeathDate().compareTo(o1.getDeathDate());
            } else {
                return o2.getCreateTime().compareTo(o1.getCreateTime());
            }
        });*/
        LOGGER.info("患者死亡状态、原因、时间相关合并start......");
        //ArrayList<UPatient> uPatientForDeathList = uPatientList;
        //目前的uPatientList已经是按照时间升序排列的
        for (UPatient uPatient : mergeGroupOrderByPatientCreateTimeAsc) {
            LOGGER.info("{}", uPatient);
        }
        //mergeGroupOrderByPatientCreateTimeAsc.forEach(uPatient -> LOGGER.info("{}", uPatient));
        ArrayList<UPatient> uPatientForDeathList = new ArrayList<>();
        //先看合并组中是否有死亡状态的患者，
        for (UPatient uPatient : mergeGroupOrderByPatientCreateTimeAsc) {
        //mergeGroupOrderByPatientCreateTimeAsc.forEach(uPatient -> {
            //if ((0 == uPatient.getLiveStatus()) && (null != uPatient.getDeathDate())) {
            if (0 == uPatient.getLiveStatus()) {
                uPatientForDeathList.add(uPatient);
            }
        }
        //如果有一个为死亡状态的，则liveStatus肯定设置为0.
        if (uPatientForDeathList.size() == 1) { //只有一个为死亡状态的，就优先取该患者的死亡时间，死亡原因.
            goalPatient.setLiveStatus(0);
            goalPatient.setDeathDate(uPatientForDeathList.get(0).getDeathDate());
            goalPatient.setCauseOfDeath(uPatientForDeathList.get(0).getCauseOfDeath());
        }
        //如果死亡状态数>1的死亡原因和日期则看随访结果中死亡时间最早的
        // 需要到随访结果中筛选出每个患者的最早死亡随访结果的时间
        //和龙博确认过 患者表中的死亡状态是和随访结果中的一致。所以只需要考虑合并组中为死亡状态的患者即可
        List<FollowupResult> followupResultOfMinDateList = new ArrayList();
        if (uPatientForDeathList.size() > 1) {
            for (UPatient uPatient:uPatientForDeathList) {
            //uPatientForDeathList.stream().forEach(uPatient -> {
                List<FollowupResult> followupResults = followupResultRepository.findByPatientIdAndFollowupResultValueOrderByDeathDateAsc(uPatient.getPatientId(), 4);
                if (followupResults.size() > 0) {
                    FollowupResult followupResultOfMinDate = followupResults.get(0);
                    followupResultOfMinDateList.add(followupResultOfMinDate);
                }
            }
            if (followupResultOfMinDateList.size() > 1) {
                //followupResultOfMinDateList.sort((o1, o2) -> o1.getDeathDate().compareTo(o2.getDeathDate()));
                Collections.sort(followupResultOfMinDateList, new Comparator<FollowupResult>() {
                    @Override
                    public int compare(FollowupResult o1, FollowupResult o2) {
                        if(o1.getDeathDate()==null){
                            return 1;
                        }else if(o2.getDeathDate()==null){
                            return -1;
                        }else{
                            return o1.getDeathDate().compareTo(o2.getDeathDate());
                        }
                    }
                });
                FollowupResult followupResultOfMinDate = followupResultOfMinDateList.get(0);
                goalPatient.setDeathDate(followupResultOfMinDate.getDeathDate());
                goalPatient.setCauseOfDeath(followupResultOfMinDate.getDeathCause());
                goalPatient.setLiveStatus(0);
            }

        }
        LOGGER.info("患者死亡状态、原因、时间相关合并finished......");
    }

    /**
     * 按就诊时间升序排列合并组
     *
     * @return
     */
    private List<UPatient> mergeGroupOrderByPatientVisitingTimeAsc() {
        ArrayList<UPatient> mergeGroup = new ArrayList<>();
        mergeGroup.add(this.getGoalPatient());
                //Lists.newArrayList(this.getGoalPatient());
        mergeGroup.addAll(otherPatients);

        LOGGER.info("==> 合并组按就诊时间升序排列");
        /*mergeGroup.sort((o1, o2) -> {
            if(o2.getVisitingTime()==null) {
                return 1;
            }else if(o1.getVisitingTime()==null){
                return -1;
            }else {
                return o1.getVisitingTime().compareTo(o2.getVisitingTime());
            }
        });*/
        Collections.sort(mergeGroup, new Comparator<UPatient>() {
            @Override
            public int compare(UPatient o1, UPatient o2) {
                if(o2.getVisitingTime()==null) {
                    return 1;
                }else if(o1.getVisitingTime()==null){
                    return -1;
                }else {
                    return o1.getVisitingTime().compareTo(o2.getVisitingTime());
                }
            }
        });
        for (UPatient patient :mergeGroup) {
        //mergeGroup.forEach(patient -> {
            LOGGER.info("==> 患者{}->病案号{}->最近就诊时间{}->职业{}->婚姻{}",
                    patient.getPatientId(), patient.getPatientNo(),
                    patient.getVisitingTime(),
                    patient.getuUserByUserId().getProfession(),
                    patient.getuUserByUserId().getMarriageStatus());
        }
        return mergeGroup;
    }

    private void mergePersonalMarriedAndJob() {
        //*******************************************************************
        //        职业、婚姻状态
        //        V1 取时间最近的患者信息进行补充
        //        V2 版本按照患者最近就诊时间
        //*******************************************************************
        //不管goalPatient这俩属性为不为空，都取这三者中时间最近的且不为空的。
        /*marrayAndJobList.stream().forEach(field -> {
            mergeGroupOrderByPatientVisitingTimeAsc.stream().forEach(
                    uPatient -> {
                        try {
                            //String fieldValue = String.valueOf(uPatient.getClass().getMethod("get" + field).invoke(uPatient, new Object[]{}));
                            //关联查询goalPatient对应的user表中的属性
                            UUser goalUser = goalPatient.getuUserByUserId();
                            //UUser uUser = uPatient.getuUserByUserId();
                            String fieldValue = String.valueOf(goalUser.getClass().getMethod("get" + field).invoke(goalUser, new Object[]{}));
                            LOGGER.info("患者{}-病案号{}", uPatient.getPatientId(), uPatient.getPatientNo() + "属性->" + field + "->" + fieldValue);
                            if ((!StringUtils.isEmpty(fieldValue)) && (!"null".equals(fieldValue))) {
                                goalUser.getClass().getMethod("set" + field, Integer.class).invoke(goalUser, new Object[]{Integer.valueOf(fieldValue)});
                            }
                            uUserRepository.save(goalUser);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
            );
        });*/

        UPatient patient=mergeGroupOrderByPatientVisitingTimeAsc.get(mergeGroupOrderByPatientVisitingTimeAsc.size()-1);
        UUser goalUser = goalPatient.getuUserByUserId();
        UUser user1=patient.getuUserByUserId();
        goalUser.setProfession(user1.getProfession());
        goalUser.setMarriageStatus(user1.getMarriageStatus());
        uUserRepository.save(goalUser);
        //UUser goalUser = goalPatient.getuUserByUserId();
        LOGGER.info("目标患者病案号->{}合并后的婚姻->{},工作->{}",
                goalUser.getPatientNo(), goalUser.getMarriageStatus(), goalUser.getProfession());
    }

    /**
     * 按照时间降序排列合并组
     *
     * @return
     */
    private ArrayList<UPatient> getMergeGroupOrderByCreateTimeDesc() {

        ArrayList<UPatient> mergeGroup = new ArrayList<>();
        mergeGroup.add(this.getGoalPatient());
                //Lists.newArrayList(this.getGoalPatient());
        mergeGroup.addAll(otherPatients);
        //mergeGroup.forEach(System.out::println);

        LOGGER.debug("合并组按时间倒序排列");
        //mergeGroup.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));
        Collections.sort(mergeGroup, new Comparator<UPatient>() {
            @Override
            public int compare(UPatient o1, UPatient o2) {
                if(o1.getCreateTime()==null){
                    return 1;
                }else if(o2.getCreateTime()==null){
                    return -1;
                }else{
                    return o2.getCreateTime().compareTo(o1.getCreateTime());
                }
            }
        });

        if (LOGGER.isDebugEnabled()) {
           // mergeGroup.forEach(System.out::println);
        }

        return mergeGroup;

    }

    /**
     * 按照时间升序排列合并组
     *
     * @param isReversed
     * @return
     */
    private ArrayList<UPatient> getMergeGroupOrderByCreateTimeAsc(boolean isReversed) {
        ArrayList<UPatient> mergeGroup = getMergeGroupOrderByCreateTimeDesc();
        Collections.reverse(mergeGroup);//升序

        LOGGER.debug("合并组按时间升序排列");
        if (LOGGER.isDebugEnabled()) {
           // mergeGroup.forEach(System.out::println);
        }

        return mergeGroup;
    }


    /**
     * 患者相关集合数据准备
     */
    private void initPatientRelatedInfo() {
        LOGGER.info("------------患者基本信息准备中---------------");
        LOGGER.info("UPatientMergeService param=>goalPatientId->{} otherPatientIds->{},doctorId->{}", goalPatientId, otherPatientIds, operatorId);
        UPatient targetPatient = uPatientRepository.findOne(goalPatientId);
        if (targetPatient == null) {
            throw new RuntimeException("目标患者不存在");
        }
        setGoalPatient(targetPatient);
        setOtherPatients(uPatientRepository.findAll(otherPatientIds));
        LOGGER.info(otherPatients.toString());
        setGoalUuidPatientMerge(uuidPatientMergeRepository.findByPatientidAndRepeatflag(goalPatientId, 1));
        setGoalUuidPatientMergeList(uuidPatientMergeRepository.findAllOrderByGoalpatientidAndRepeatflag(goalPatientId, 1));
        setOtherGoalUuidPatientMergeList(uuidPatientMergeRepository.findAllOrderByPatientidInAndRepeatflag(otherPatientIds, 1));

        LOGGER.debug("目标患者->{}", this.getGoalPatient());
        LOGGER.debug("uuid_patient_merge表目标患者->{}", this.getGoalUuidPatientMerge());
        if (LOGGER.isDebugEnabled()) {
            for (UPatient x : getOtherPatients()) LOGGER.info("待合并患者-****>{}", x);
            //getOtherPatients().forEach(x -> LOGGER.info("待合并患者-****>{}", x));
            for(UuidPatientMerge x : getGoalUuidPatientMergeList()) LOGGER.info("uuid_patient_merge合并组-****>{}", x);
            //getGoalUuidPatientMergeList().forEach(x -> LOGGER.info("uuid_patient_merge合并组-****>{}", x));
            for (UuidPatientMerge x : getOtherGoalUuidPatientMergeList()) LOGGER.info("uuid_patient_merge待合并患者-****>{}", x);
            //getOtherGoalUuidPatientMergeList().forEach(x -> LOGGER.info("uuid_patient_merge待合并患者-****>{}", x));
        }

        //otherPatients.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));
        Collections.sort(otherPatients, new Comparator<UPatient>() {
            @Override
            public int compare(UPatient o1, UPatient o2) {
                if(o1.getCreateTime()==null){
                    return 1;
                }else if(o2.getCreateTime()==null){
                    return -1;
                }else{
                    return o2.getCreateTime().compareTo(o1.getCreateTime());
                }
            }
        });
        LOGGER.info("=====待合并患者按照时间倒序排列=====");
        //otherPatients.forEach(uPatient -> LOGGER.info("=>待合并患者->{}", uPatient));
        for (UPatient uPatient : otherPatients) LOGGER.info("=>待合并患者->{}", uPatient);

        if (goalUuidPatientMerge != null) {
            LOGGER.debug("=====所有合并组重复原因->{}=====", goalUuidPatientMerge.getRemark());
        }
        //uuidPatientMergeRepository.getRemarkInfo().stream().forEach(o -> repeatMarkReason.add(o));
        for (String o : uuidPatientMergeRepository.getRemarkInfo()) repeatMarkReason.add(o);
        if (LOGGER.isDebugEnabled()) {
            //repeatMarkReason.forEach(remarkInfo -> LOGGER.info("=>合并的重复原因->{{}}", remarkInfo));
            for (String remarkInfo : repeatMarkReason) LOGGER.info("=>合并的重复原因->{{}}", remarkInfo);
        }


        mergeGroupOrderByPatientCreateTimeDesc = getMergeGroupOrderByCreateTimeDesc();

      /*  mergeGroupOrderByPatientCreateTimeDesc.forEach(uPatient -> {
            VarPatientMedical patientMedical = varPatientMedicalRepository.findByPatientId(uPatient.getPatientId());
            Timestamp visitingTime = patientMedical.getVisitingTime();//为了保持一致,设置给patient
            if (visitingTime != null) {
                uPatient.setVisitingTimeByPatients(visitingTime);
            }
        });*/


        mergeGroupOrderByPatientCreateTimeAsc = getMergeGroupOrderByCreateTimeAsc(true);

        mergeGroupOrderByPatientVisitingTimeAsc = mergeGroupOrderByPatientVisitingTimeAsc();
    }

    /**
     * 反射获取患者的值为空字段集合
     *
     * @param goalPatient
     * @return
     */
    private List<String> reflectEmptyFieldList(final UPatient goalPatient) {
        LOGGER.debug("=====所有属性名->值");
        List<String> fieldStringList = new ArrayList<>();
        /*Arrays.stream(goalPatient.getClass().getDeclaredMethods())
                .filter(o -> o.getName().startsWith("get"))
                .forEach(m -> {
                    try {
                        String fieldValue = String.valueOf(m.invoke(goalPatient, new Object[]{}));
                        LOGGER.debug(m.getName().replace("get", "").concat("->").concat(fieldValue));
                        if ("null".equals(fieldValue) || "".equals(fieldValue)) {
                            fieldStringList.add(m.getName().replace("get", ""));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });*/

        for (Method m : goalPatient.getClass().getMethods()){
            if(m.getName().startsWith("get")){
                try {
                    String fieldValue = String.valueOf(m.invoke(goalPatient, new Object[]{}));
                    LOGGER.debug(m.getName().replace("get", "").concat("->").concat(fieldValue));
                    if ("null".equals(fieldValue) || "".equals(fieldValue)) {
                        fieldStringList.add(m.getName().replace("get", ""));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        LOGGER.debug("=====输出空字段=====");
        if (LOGGER.isDebugEnabled()) {
            //fieldStringList.forEach(field -> LOGGER.debug(field.replace("get", "")));
            for (String field: fieldStringList) LOGGER.debug(field.replace("get", ""));
        }

        return fieldStringList;
    }

    private List<String> reflectEmptyFieldListOfUser(final UUser goalUser) {
        LOGGER.debug("=====所有属性名->值");
        List<String> fieldStringList = new ArrayList<>();
       /* Arrays.stream(goalUser.getClass().getDeclaredMethods())
                .filter(o -> o.getName().startsWith("get"))
                .forEach(m -> {
                    try {
                        String fieldValue = String.valueOf(m.invoke(goalUser, new Object[]{}));
                        LOGGER.debug(m.getName().replace("get", "").concat("->").concat(fieldValue));
                        if ("null".equals(fieldValue) || "".equals(fieldValue)) {
                            fieldStringList.add(m.getName().replace("get", ""));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });*/

        for (Method m : goalUser.getClass().getMethods()){
            if(m.getName().startsWith("get")) {
                try {
                    String fieldValue = String.valueOf(m.invoke(goalUser, new Object[]{}));
                    LOGGER.debug(m.getName().replace("get", "").concat("->").concat(fieldValue));
                    if ("null".equals(fieldValue) || "".equals(fieldValue)) {
                        fieldStringList.add(m.getName().replace("get", ""));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        LOGGER.debug("=====输出空字段=====");
        if (LOGGER.isDebugEnabled()) {
            //fieldStringList.forEach(field -> LOGGER.debug(field.replace("get", "")));
            for (String field: fieldStringList) LOGGER.debug(field.replace("get", ""));
        }

        return fieldStringList;
    }


    private void mergePersonalInfo() {
        //*******************************************************************
        //v1.  1病案号、2姓名、3性别、4出生日期、5出生地、6民族、7国籍、8地区、9籍贯、10身份证号 *
        //如上信息按合并的优先级关系取值；                                     *
        //即默认患者有信息取默认患者；默认患者信息为空时，取时间最近的补充；      *

        //v2. 版本 对应的姓名、性别、出生日期、身份证号由患者根据几个疑似信息，自己决定编辑保留
        // 其它的信息还是如v1版本所示
        //prd==>合并时患者的姓名、性别、出生日期、身份证号码引用弹窗中修改的信息为准
        //******************************************************************

        //原则
        //对目标患者更新操作的 进行备份表 +更新目标患者。
        //对目标患者新增操作的 原表复制+新增被合并患者到目标患者。
        //对应的mergeFrom, mergeTarget、patientType,mergeFlag相应的修改。

        //以下(A1,B,C)为一组需要合并的患者，A1为目标患者，B，C为被合并患者
        //对目标患者新增操作的 原表复制+新增被合并患者到目标患者。
        //     mergeFrom  mergeTarget  patientType  mergeFlag
        //A1                                            1
        //B                                 -1
        //C                                 -1
        //A2    B             A1                        2
        //A3    C             A1                        2

        //对目标患者更新操作的 新表备份+更新目标患者。
        //      mergeFrom  mergeTarget  mergeFlag     newDB           mergeFrom  mergeTarget patientType mergeFlag
        //A1                                            1              A1_bak                                         1
        //B                   A1           2
        //C                   A1           2

        List<String> emptyFieldList = reflectEmptyFieldList(goalPatient);


        LOGGER.debug("======实际值(实体的所有字段值)为空字段输出======");
        //emptyFieldList.forEach(emptyField -> LOGGER.debug(emptyField));
        for (String emptyField : emptyFieldList) LOGGER.debug(emptyField);

        LOGGER.info("======5个字段为空时，需要补位的字段=====");
        //preEmptyFieldList.forEach(preEmptyField -> LOGGER.info("==> {}", preEmptyField));
        for (String preEmptyField : preEmptyFieldList) LOGGER.info("==> {}", preEmptyField);

        List<String> preEmptyFieldListForTargetUser = new ArrayList<>();
        preEmptyFieldListForTargetUser.addAll(preEmptyFieldList);
        List<String> emptyFieldListOfTargetUser = reflectEmptyFieldListOfUser(goalPatient.getuUserByUserId());
        preEmptyFieldListForTargetUser.retainAll(emptyFieldListOfTargetUser);//user实际上按照指标为空的字段

        //预定义字段中值为空的字段集合
        preEmptyFieldList.retainAll(emptyFieldList);
        if (preEmptyFieldList.size() == 0) {
            LOGGER.info("目标患者没有需要补位的空字段");
        } else {
            LOGGER.info("真正指定合并业务字段值为null or \"\"，需要补位的字段");
            //preEmptyFieldList.forEach(field -> LOGGER.info("==> {}", field));
            for (String field : preEmptyFieldList) LOGGER.info("==> {}", field);
        }

        //将需要补位的字段进行处理 patient
        if (preEmptyFieldList.size() > 0) {
            //你怎么确定谁为空？ 为谁来赋值? 使用反射解决呗~~
            LOGGER.debug("otherPatients 时间倒序排列");
            //otherPatients.forEach(uPatient -> LOGGER.debug(uPatient.toString()));
            for (UPatient uPatient : otherPatients) LOGGER.debug(uPatient.toString());
            //最理想实现依次补位，直到不为空的去补上
            Collections.reverse(otherPatients);//如果不加上的话，将被非空的第二新的更新掉。 加上则保证最后的非空的都能更新上。

            oneByOneFillEmptyFields(preEmptyFieldList, otherPatients, goalPatient);

        }


        if (preEmptyFieldListForTargetUser.size() == 0) {
            LOGGER.info("目标患者对应的用户没有需要补位的空字段");
        } else {
            LOGGER.info("真正指定合并业务字段值为null or \"\"，需要补位的字段");
            //preEmptyFieldListForTargetUser.forEach(field -> LOGGER.info("==> {}", field));
            for (String field : preEmptyFieldListForTargetUser) LOGGER.info("==> {}", field);
        }

        //将需要补位的字段进行处理 user
        if (preEmptyFieldListForTargetUser.size() > 0) {
            //你怎么确定谁为空？ 为谁来赋值? 使用反射解决呗~~
            LOGGER.debug("otherUsers 时间倒序排列");
            //otherPatients.forEach(uPatient -> LOGGER.debug(uPatient.toString()));
            List<UUser> otherUsers = new ArrayList<>();
            for (UPatient uPatient : otherPatients) {
                LOGGER.debug(uPatient.toString());
                otherUsers.add(uPatient.getuUserByUserId());
            }
            /*otherPatients.forEach(patient -> {
                otherUsers.add(patient.getuUserByUserId());
            });*/

                //最理想实现依次补位，直到不为空的去补上
            Collections.reverse(otherUsers);//如果不加上的话，将被非空的第二新的更新掉。 加上则保证最后的非空的都能更新上。

            oneByOneFillEmptyFieldsForUser(preEmptyFieldListForTargetUser, otherUsers, goalPatient.getuUserByUserId());

        }


        //优先保存患者选择编辑留下来的字段值
        goalPatient.setTrueName(mergePatientReqInfo.getTrueName());
        goalPatient.setSex(mergePatientReqInfo.getSex());
        goalPatient.setBirthDate(mergePatientReqInfo.getBirthDate());
        uPatientRepository.save(goalPatient);

        UUser goalUser = goalPatient.getuUserByUserId();
        goalUser.setTrueName(mergePatientReqInfo.getTrueName());
        goalUser.setSex(mergePatientReqInfo.getSex());
        goalUser.setBirthDate(mergePatientReqInfo.getBirthDate());
        goalUser.setIdentification(mergePatientReqInfo.getIdentification());
        uUserRepository.save(goalUser);
    }

    /**
     * 依次取出list集合中对象不为空的对象的相应属性值，直到不为空结束。
     *
     * @param preEmptyFieldList
     * @param otherPatientList
     * @param goalPatient
     */
    private static void oneByOneFillEmptyFields(ArrayList<String> preEmptyFieldList, List<UPatient> otherPatientList, UPatient goalPatient) {
        for (String field : preEmptyFieldList) {
            //preEmptyFieldList.stream().forEach(field ->
            for (UPatient uPatient : otherPatientList) {
                //otherPatientList.forEach(uPatient -> {
                try {
                    String fieldValue = String.valueOf(uPatient.getClass().getMethod("get" + field).invoke(uPatient, new Object[]{}));
                    LOGGER.info("fieldValue{}", fieldValue);
                    //if (!("".equals(fieldValue) && fieldValue != null && "null".equals(fieldValue))) {
                    //if (!("".equals(fieldValue) && fieldValue != null && !("null".equals(fieldValue)))) {
                    if (!("".equals(fieldValue) || "null".equals(fieldValue))) {
                        //if (fieldValue != null || ("".equals(fieldValue))) {//一半，更新的有问题
                        //goalPatient.getClass().getMethod("get" + field).invoke(goalPatient, new Object[]{field});
                        goalPatient.getClass().getMethod("set" + field, String.class).invoke(goalPatient, fieldValue);
                        //关联修改user的trueName,PatientNo
                        UUser uUser = goalPatient.getuUserByUserId();
                        if (("TrueName").equals(field)) {
                            uUser.setTrueName(fieldValue);
                        }
                        if (("PatientNo").equals(field)) {
                            uUser.setPatientNo(fieldValue);
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        //region 按照每个补位字段排序
        //每个补位字段 都需要有按照其排序的方法....那么需要通过反射.... //该需求目前没有...
            /*preEmptyFieldList.forEach(o -> {
                        list.sort((o1, o2) -> {
                            //int i = o2.getCreateTime().compareTo(o1.getCreateTime());
                            int i = 0;
                            try {
                                i = String.valueOf(o2.getClass().getMethod("get" + o, null).invoke(o2, new Object[]{}))
                                        .compareTo(String.valueOf(o1.getClass().getMethod("get" + o, null).invoke(o1, new Object[]{})));
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            return i;
                        });
                    }
            );*/
        //endRegion
        //list.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime());
    }

    /**
     * 依次取出list集合中对象不为空的对象的相应属性值，直到不为空结束。
     *
     * @param preEmptyFieldList
     * @param otherUserList
     * @param goalUser
     */
    private static void oneByOneFillEmptyFieldsForUser(List<String> preEmptyFieldList, List<UUser> otherUserList, UUser goalUser) {
        for (String field : preEmptyFieldList) {
            //preEmptyFieldList.stream().forEach(field ->
            for (UUser uPatient : otherUserList) {
                ///otherUserList.forEach(uPatient -> {
                try {
                    String fieldValue = String.valueOf(uPatient.getClass().getMethod("get" + field).invoke(uPatient, new Object[]{}));
                    LOGGER.info("fieldValue{}", fieldValue);
                    //if (!("".equals(fieldValue) && fieldValue != null && !("null".equals(fieldValue)))) {
                    if (!("".equals(fieldValue) || "null".equals(fieldValue))) {
                        //if (fieldValue != null || ("".equals(fieldValue))) {//一半，更新的有问题
                        //goalPatient.getClass().getMethod("get" + field).invoke(goalPatient, new Object[]{field});
                        goalUser.getClass().getMethod("set" + field, String.class).invoke(goalUser, fieldValue);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void mergePersonalInfo_V1(List<String> emptyFieldList) {
        //*******************************************************************
        //1.  1病案号、2姓名、3性别、4出生日期、5出生地、6民族、7国籍、8地区、9籍贯、10身份证号 *
        //如上信息按合并的优先级关系取值；                                     *
        //即默认患者有信息取默认患者；默认患者信息为空时，取时间最近的补充；      *
        //******************************************************************

        //原则
        //对目标患者更新操作的 进行备份表 +更新目标患者。
        //对目标患者新增操作的 原表复制+新增被合并患者到目标患者。
        //对应的mergeFrom, mergeTarget、patientType,mergeFlag相应的修改。

        //以下(A1,B,C)为一组需要合并的患者，A1为目标患者，B，C为被合并患者
        //对目标患者新增操作的 原表复制+新增被合并患者到目标患者。
        //     mergeFrom  mergeTarget  patientType  mergeFlag
        //A1                                            1
        //B                                 -1
        //C                                 -1
        //A2    B             A1
        //A3    C             A1

        //对目标患者更新操作的 新表备份+更新目标患者。
        //     mergeFrom  mergeTarget patientType  mergeFlag     newDB           mergeFrom  mergeTarget patientType mergeFlag
        //A1                                            1                A1_bak                                         1
        //B                   A1          -1
        //C                   A1          -1


        LOGGER.info("=====实际值为空字段输出=====");
        //emptyFieldList.forEach(emptyField -> LOGGER.info(emptyField));
        for (String emptyField:emptyFieldList) LOGGER.info(emptyField);
        LOGGER.info("======10个字段为空时，需要补位的字段=====");
        //preEmptyFieldList.forEach(preEmptyField -> LOGGER.info(preEmptyField));
        for (String preEmptyField : preEmptyFieldList) LOGGER.info(preEmptyField);

        preEmptyFieldList.retainAll(emptyFieldList);//预定义字段中值为空的字段集合
        PrintUtils.print("真正值为null or \"\"，需要补位的字段");
        //preEmptyFieldList.forEach(field -> LOGGER.info(field));
        for (String field : preEmptyFieldList) LOGGER.info(field);

        //将需要补位的字段进行处理
        if (preEmptyFieldList.size() > 0) {
            //你怎么确定谁为空？ 为谁来赋值?
            PrintUtils.print("otherpatient 时间倒序排列");
           // otherPatients.forEach(System.out::println);
            //最理想实现依次补位，直到不为空的去补上
            Collections.reverse(otherPatients);//如果不加上的话，将被非空的第二新的更新掉。 加上则保证最后的非空的都能更新上。
            //依次取出list集合中对象不为空的对象的相应属性值，直到不为空结束。
            oneByOneFillEmptyFields(preEmptyFieldList, otherPatients, goalPatient);
        }
    }


    @Deprecated
    //不希望每次方法都传递参数，通过反射，生成对象的时候就给注入进来
    private void mergeName(UPatient goalPatient, List<UPatient> otherPatients, UuidPatientMerge
            goalUuidPatientMerge, List<UuidPatientMerge> UuidPatientMergeList) {
        LOGGER.info("合并姓名中..........");
        if (goalUuidPatientMerge != null) {
            //判断疑似重复原因
            String remark = goalUuidPatientMerge.getRemark();
            LOGGER.info("疑似重复原因->: {}", remark);

            LOGGER.info("upatient所有属性......");
            //Arrays.stream(goalPatient.getClass().getDeclaredFields()).forEach(System.out::println);
            LOGGER.info("upatient所有声明方法.......");
            //Arrays.stream(goalPatient.getClass().getDeclaredMethods()).forEach(System.out::println);
            LOGGER.info("upatient所有get方法......");
            //Arrays.stream(goalPatient.getClass().getDeclaredMethods()).filter(o -> o.getName().startsWith("get")).forEach(System.out::println);
        }
    }


    private void mergeLiveStatus() {
        LOGGER.info("合并患者生存状态中.........");
    }

    private void mergeMarriedInfo() {
        LOGGER.info("合并患者婚姻状况.........");
    }

    private void mergeNativePlace() {
        LOGGER.info("合并患者籍贯.........");
    }


//import org.springframework.test.context.junit4.SpringRunner;

    //患者基本信息
//    u_patient
//            u_user
//    姓名、手机号、生存状态。婚姻状态、籍贯、其它字段。 1

    public void setuPatientRepository(UPatientRepository uPatientRepository) {
        this.uPatientRepository = uPatientRepository;
    }

    public void setUuidPatientMergeRepository(UuidPatientMergeRepository uuidPatientMergeRepository) {
        this.uuidPatientMergeRepository = uuidPatientMergeRepository;
    }

    public void setFollowupResultRepository(FollowupResultRepository followupResultRepository) {
        this.followupResultRepository = followupResultRepository;
    }

    public void setVarPatientMedicalRepository(VarPatientMedicalRepository varPatientMedicalRepository) {
        this.varPatientMedicalRepository = varPatientMedicalRepository;
    }

    public void setuPatientFamilyRepository(UPatientFamilyRepository uPatientFamilyRepository) {
        this.uPatientFamilyRepository = uPatientFamilyRepository;
    }

    public void setuPatientMergeBakRepository(UPatientMergeBakRepository uPatientMergeBakRepository) {
        this.uPatientMergeBakRepository = uPatientMergeBakRepository;
    }

    public void setuUserRepository(UUserRepository uUserRepository) {
        this.uUserRepository = uUserRepository;
    }

    public void setuUserMergeBakRepository(UUserMergeBakRepository uUserMergeBakRepository) {
        this.uUserMergeBakRepository = uUserMergeBakRepository;
    }

    @Override
    public void setEntityBakService(EntityBakService entityBakService) {
        this.entityBakService = entityBakService;
    }

    public RFollowupTaskPatientRepository getrFollowupTaskPatientRepository() {
        return rFollowupTaskPatientRepository;
    }

    public void setrFollowupTaskPatientRepository(RFollowupTaskPatientRepository rFollowupTaskPatientRepository) {
        this.rFollowupTaskPatientRepository = rFollowupTaskPatientRepository;
    }

    public FollowupResultRepository getFollowupResultRepository() {
        return followupResultRepository;
    }

    public FollowupResultBufferRepository getFollowupResultBufferRepository() {
        return followupResultBufferRepository;
    }

    public void setFollowupResultBufferRepository(FollowupResultBufferRepository followupResultBufferRepository) {
        this.followupResultBufferRepository = followupResultBufferRepository;
    }
}

package com.esuizhen.bigdata.merge;


import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.domain.followup.FollowupResultBuff;
import com.esuizhen.bigdata.domain.followup.RFollowupTaskPatient;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UuidPatientMerge;
import com.esuizhen.bigdata.service.EntityBakService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/**
 * Created by fqc on 16/11/25.
 * 合并业务抽象类
 */
public abstract class AbstractMergeBean implements Command {

    public static final Logger LOGGER = LoggerFactory.getLogger(AbstractMergeBean.class);


    public AbstractMergeBean() {

    }

    public AbstractMergeBean(Long goalPatientId, List<Long> otherPatientIds, MergePatientReq beanInfo, String operatorId) {
        this(goalPatientId, otherPatientIds, beanInfo, operatorId, null, null);
    }

    public AbstractMergeBean(Long goalPatientId, List<Long> otherPatientIds, MergePatientReq beanInfo, String operatorId, Map<String, JpaRepository> repositoryMap, EntityBakService entityBakService) {
        this.goalPatientId = goalPatientId;
        this.otherPatientIds = otherPatientIds;
        this.mergePatientReqInfo = beanInfo;
        this.operatorId = operatorId;
        this.repositoryMap = repositoryMap;
        this.entityBakService = entityBakService;
        //整合合并ids，goalpatientId在最前
        //List<Long> mergePatientIdList = Lists.newArrayList(otherPatientIds);
        List<Long> mergePatientIdList=new ArrayList<>();
        mergePatientIdList.addAll(otherPatientIds);
        mergePatientIdList.add(0, goalPatientId);
        this.mergePatientIds = mergePatientIdList;
    }

    /**
     * 合并目标患者Id
     */
    protected Long goalPatientId;

    /**
     * 要被合并的患者Id
     */
    protected List<Long> otherPatientIds;

    /**
     * 合并组患者Ids
     */
    protected List<Long> mergePatientIds;

    /**
     * 用户选择编辑保留的合并信息 姓名，性别，出生日期，身份证号
     */
    protected MergePatientReq mergePatientReqInfo;

    /**
     * 合并操作者
     */
    protected String operatorId;

    protected Map<String, JpaRepository> repositoryMap;

    protected EntityBakService entityBakService;

    /**
     * 子模块合并执行入口
     *
     * @throws InterruptedException
     */
    @Override
    public void executeMerge() throws Exception {

    }

    /**
     * 子模块撤销合并执行入口
     */
    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }


    /**
     * 疑似重复患者列表
     */
    protected List<UuidPatientMerge> uuidPatientMergeList;

    /**
     * 目标合并患者
     */
    protected UPatient goalPatient;

    /**
     * 待合并患者
     */
    protected List<UPatient> otherPatients;

    /**
     * 合并组
     */
    protected List<UuidPatientMerge> goalUuidPatientMergeList;

    /**
     * uuid_patient_merge表目标患者
     */
    protected UuidPatientMerge goalUuidPatientMerge;

    /**
     * uuid_patient_merge表待合并患者
     */
    protected List<UuidPatientMerge> otherGoalUuidPatientMergeList;

    /**
     * 重复原因集合
     */
    protected Set<String> repeatMarkReason = new HashSet<>();

    //task
    protected List<RFollowupTaskPatient> otherPatientFollowupTasks;
    protected List<RFollowupTaskPatient> targetPatientFollowupTasks;

    //result
    protected FollowupResult targetFollowupResult;
    protected List<FollowupResult> otherFollowupResults;

    //result_buff
    protected FollowupResultBuff targetFollowupResultBuff;
    protected List<FollowupResultBuff> otherFollowupResultBuffs;


    public Long getGoalPatientId() {
        return goalPatientId;
    }

    public void setGoalPatientId(Long goalPatientId) {
        this.goalPatientId = goalPatientId;
    }

    public List<Long> getOtherPatientIds() {
        return otherPatientIds;
    }

    public void setOtherPatientIds(List<Long> otherPatientIds) {
        this.otherPatientIds = otherPatientIds;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Map<String, JpaRepository> getRepositoryMap() {
        return repositoryMap;
    }

    public void setRepositoryMap(Map<String, JpaRepository> repositoryMap) {
        this.repositoryMap = repositoryMap;
    }


    public List<UuidPatientMerge> getUuidPatientMergeList() {
        return uuidPatientMergeList;
    }

    public void setUuidPatientMergeList(List<UuidPatientMerge> uuidPatientMergeList) {
        this.uuidPatientMergeList = uuidPatientMergeList;
    }

    public UPatient getGoalPatient() {
        return goalPatient;
    }

    public void setGoalPatient(UPatient goalPatient) {
        this.goalPatient = goalPatient;
    }

    public List<UPatient> getOtherPatients() {
        return otherPatients;
    }

    public void setOtherPatients(List<UPatient> otherPatients) {
        this.otherPatients = otherPatients;
    }

    public List<UuidPatientMerge> getGoalUuidPatientMergeList() {
        return goalUuidPatientMergeList;
    }

    public void setGoalUuidPatientMergeList(List<UuidPatientMerge> goalUuidPatientMergeList) {
        this.goalUuidPatientMergeList = goalUuidPatientMergeList;
    }

    public UuidPatientMerge getGoalUuidPatientMerge() {
        return goalUuidPatientMerge;
    }

    public void setGoalUuidPatientMerge(UuidPatientMerge goalUuidPatientMerge) {
        this.goalUuidPatientMerge = goalUuidPatientMerge;
    }

    public List<UuidPatientMerge> getOtherGoalUuidPatientMergeList() {
        return otherGoalUuidPatientMergeList;
    }

    public void setOtherGoalUuidPatientMergeList(List<UuidPatientMerge> otherGoalUuidPatientMergeList) {
        this.otherGoalUuidPatientMergeList = otherGoalUuidPatientMergeList;
    }

    public List<Long> getMergePatientIds() {
        return mergePatientIds;
    }

    public void setMergePatientIds(List<Long> mergePatientIds) {
        this.mergePatientIds = mergePatientIds;
    }

    public MergePatientReq getMergePatientReqInfo() {
        return mergePatientReqInfo;
    }

    public void setMergePatientReqInfo(MergePatientReq mergePatientReqInfo) {
        this.mergePatientReqInfo = mergePatientReqInfo;
    }

    public EntityBakService getEntityBakService() {
        return entityBakService;
    }

    public void setEntityBakService(EntityBakService entityBakService) {
        this.entityBakService = entityBakService;
    }
}

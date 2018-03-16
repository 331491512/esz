package com.esuizhen.bigdata.service.user.impl;

import com.esuizhen.bigdata.bean.PatientInfoReq;
import com.esuizhen.bigdata.domain.ehr.VarPatientMedical;
import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.domain.followup.VarPatientFollowup;
import com.esuizhen.bigdata.domain.ods.TVarSearch;
import com.esuizhen.bigdata.domain.sc.TPatientSyncResultClient;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.repository.followup.VarPatientFollowupRepository;
import com.esuizhen.bigdata.repository.followup.VarPatientMedicalRepository;
import com.esuizhen.bigdata.repository.ods.SearchInfoRepository;
import com.esuizhen.bigdata.repository.sc.TPatientSyncResultClientRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.ehr.impl.AsyncSearchServiceImpl;
import com.esuizhen.bigdata.service.user.PatientService;
import com.westangel.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fqc on 17/1/7.
 */
@Service
@Transactional
public class UPatientServiceImpl implements PatientService {
    @Autowired
    private VarPatientMedicalRepository varPatientMedicalRepository;

    @Autowired
    private UPatientRepository uPatientRepository;

    @Autowired
    private SearchInfoRepository searchInfoRepository;

    @Autowired
    private AsyncSearchServiceImpl asyncSearchService;

    @Autowired
    private FollowupResultRepository followupResultRepository;

    @Autowired
    private VarPatientFollowupRepository patientFollowupRepository;
    @Autowired
    private TPatientSyncResultClientRepository patientSyncResultClientRepository;

    @Override
    public void setVisitingTimeByPatients(List<UPatient> patients) {
        for (UPatient uPatient: patients){
        //patients.forEach(uPatient -> {
            VarPatientMedical patientMedical = varPatientMedicalRepository.findByPatientId(uPatient.getPatientId());
            Timestamp visitingTime = patientMedical.getVisitingTime();//为了保持一致,设置给patient
            if (visitingTime != null) {
                uPatient.setVisitingTime(visitingTime);
            }
        }
    }

    @Override
    public void setVisitingTimeByPatientIds(List<Long> patientIds) {
        List<UPatient> patients = uPatientRepository.findAllByPatientIdIn(patientIds);
        this.setVisitingTimeByPatients(patients);
    }

    @Override
    public void save(List<UPatient> patients) {
        if (patients != null&&(!patients.isEmpty())) {
            uPatientRepository.save(patients);
        }
    }

    @Override
    public void save(UPatient patient) {
        if (patient != null) {
            uPatientRepository.save(patient);
        }
    }
    @Override
    public Integer saveMiddlePatientMerge(PatientInfoReq req, String path, Long userId) throws InterruptedException {
        String jsonParam = JsonUtil.toJson(req);
        TVarSearch search = new TVarSearch();
        search.setInterfaceName(path);
        search.setReq(jsonParam);
        search.setOperator(userId);
        searchInfoRepository.save(search);
        asyncSearchService.setSearch(search);
        asyncSearchService.setSearchInfoRepository(searchInfoRepository);
        new Thread(asyncSearchService).start();
        return search.getSearchId();
    }

    @Override
    public int queryPreMergePatientCount() {
        return uPatientRepository.countByMergeFlag(1);
    }

    @Override
    public int queryAfterMergePatientCount() {
        return uPatientRepository.countByMergeFlag(2);
    }


    /**
     * /*ν 失访状态：
     * //合并患者中有标记失访和未标记失访的患者时，(只要是有标记失访的患者)
     * //针对已标记失访患者有新增电话号码时，
     * //       合并患者应为未失访患者
     * 并取消随访结果中的失访标识；
     * //针对已标记失访患者没有新增电话号码时，
     * //       合并患者应为标记为失访患者，
     * 并取失访时间最早的时间为失访时间；
     *
     * @param targetPatientId
     */
    @Override
    public void mergeLostFollowupStatus(Long targetPatientId, List<Long> otherPatientIds) {
        //始终通过followup_db中取
        List<Long> mergeGroupId = new ArrayList<>();
        mergeGroupId.add(targetPatientId);
        //Lists.newArrayList(targetPatientId);
        mergeGroupId.addAll(otherPatientIds);
       /* List<FollowupResult> lostFollowupResults = followupResultService.findLostFollowupFlagBean(mergeGroupId, 1);
        List<FollowupResult> notLostFollowupResults = followupResultService.findLostFollowupFlagBean(mergeGroupId, 0);
        //if (!(lostFollowupResults.isEmpty() && notLostFollowupResults.isEmpty())) {
        if (!(lostFollowupResults.isEmpty())) {
            lostFollowupResults.forEach(followupResult -> {
                //判断失访时间之后有新增联系人的
                Timestamp lostFollowupTime = followupResult.getFollowupTime();
                List<UPatientFamily> families = patientFamilyService.findPatientFamiliesAfterLostFollowupTime(mergeGroupId, lostFollowupTime);
                UPatient targetPatient = this.findTargetPatient(targetPatientId);
                if (!families.isEmpty()) {//失访，有新增联系人
                    //目标患者应为未失访状态
                    //patient
                    targetPatient.setFollowupFlag(1);//改变随访状态 可随访
                    uPatientRepository.save(targetPatient);
                    //followup_result
                    List<FollowupResult> followupResultsOfTargetPatient = followupResultService.findFollowupResultsOfTargetPatient(targetPatientId);
                    followupResultsOfTargetPatient.forEach(result -> result.setLostFollowupFlag(0)); //未失访
                    followupResultService.save(followupResultsOfTargetPatient);//都更新未失访状态,没必要考虑那么复杂

                } else {
                    // 失访，无新增联系人
                    // `followupFlag` int(2) NOT NULL DEFAULT '1' COMMENT '随访标志。
                    // 0：不能随访；1：能随访。2：失访',
                    targetPatient.setFollowupFlag(2);//改变随访状态 失访
                    uPatientRepository.save(targetPatient);
                    //followup_result
                    List<FollowupResult> lostFollowupFlagBeans = followupResultService.findLostFollowupFlagBean(mergeGroupId, 1);
                    lostFollowupFlagBeans.sort((o1, o2) -> o1.getFollowupTime().compareTo(o2.getFollowupTime()));//sort asc
                    Timestamp earliestLostFollowupTime = lostFollowupFlagBeans.get(0).getFollowupTime();
                    //targetPatient.setLostFollowupTime(lostFollowupTime);
                    targetPatient.setLostFollowupTime(earliestLostFollowupTime);
                    List<FollowupResult> followupResultsOfTargetPatient = followupResultService.findFollowupResultsOfTargetPatient(targetPatientId);
                    followupResultsOfTargetPatient.forEach(result -> result.setLostFollowupFlag(1)); //失访
                    followupResultService.save(followupResultsOfTargetPatient);//
                }
            });

        }*/
        List<UPatient> list=uPatientRepository.findByFollowupFlagAndPatientIdIn(2,mergeGroupId);
        if(list!=null&&list.size()<mergeGroupId.size()&&list.size()>0){
            UPatient targetPatient = this.findTargetPatient(targetPatientId);
            List<Long> lostFollowupPatientIds=new ArrayList<>();
            for (UPatient o : list){
                lostFollowupPatientIds.add(o.getPatientId());
            }
            List<VarPatientFollowup> patientFollowup=patientFollowupRepository.findByNewContactFlagAndPatientIdIn(1,lostFollowupPatientIds);
            if(patientFollowup!=null&&patientFollowup.size()>0){
                if(targetPatient.getFollowupFlag()!=1){
                    targetPatient.setFollowupFlag(1);
                    targetPatient.setLostFollowupCause(null);
                    targetPatient.setLostFollowupCauseResultValue(null);
                    uPatientRepository.save(targetPatient);
                }
            }else{
                UPatient lostPatient=this.getLostFollowupTime(list);
                targetPatient.setLostFollowupTime(lostPatient.getLostFollowupTime());
                targetPatient.setLostFollowupCause(lostPatient.getLostFollowupCause());
                targetPatient.setLostFollowupCauseResultValue(lostPatient.getLostFollowupCauseResultValue());
                targetPatient.setFollowupFlag(2);
                uPatientRepository.save(targetPatient);
            }
        }else if(list!=null&&list.size()==mergeGroupId.size()){
            UPatient targetPatient = this.findTargetPatient(targetPatientId);
            UPatient lostPatient=this.getLostFollowupTime(list);
            targetPatient.setLostFollowupTime(lostPatient.getLostFollowupTime());
            targetPatient.setLostFollowupCause(lostPatient.getLostFollowupCause());
            targetPatient.setLostFollowupCauseResultValue(lostPatient.getLostFollowupCauseResultValue());
            uPatientRepository.save(targetPatient);
        }
    }

    private UPatient getLostFollowupTime(List<UPatient> list){
        //list.sort((o1,o2) -> o1.getLostFollowupTime().compareTo(o2.getLostFollowupTime()));
        Collections.sort(list, new Comparator<UPatient>() {
            @Override
            public int compare(UPatient o1, UPatient o2) {
                if(o1.getLostFollowupTime()==null){
                    return 1;
                }else if(o2.getLostFollowupTime()==null){
                    return -1;
                }else{
                    return o1.getLostFollowupTime().compareTo(o2.getLostFollowupTime());
                }
            }
        });


        return list.get(0);
    }

    @Override
    public UPatient findTargetPatient(Long targetPatientId) {
        return uPatientRepository.findByPatientId(targetPatientId);
    }

    @Override
    public void mergeLostFollowupStatusAndCause(Long targetPatientId, List<Long> otherPatientIds) {
        UPatient targetPatient = uPatientRepository.findByPatientId(targetPatientId);
        List<UPatient> otherPatients = uPatientRepository.findAllByPatientIdIn(otherPatientIds);
        List<UPatient> uPatients = new ArrayList<>();
        uPatients.addAll(otherPatients);
        //Lists.newArrayList(otherPatients);
        uPatients.add(targetPatient);

        if (uPatients.size() > 0) {
            UPatient tempPatient = uPatients.get(0);
            /*uPatients.sort(
                    (o1, o2) -> {
                        if (o1.getLostFollowupTime() != null && o2.getLostFollowupTime() != null) {
                            return o1.getLostFollowupTime().compareTo(o2.getLostFollowupTime());
                        } else {
                            return 1;
                        }
                    }
            );*/
            Collections.sort(uPatients,new Comparator<UPatient>(){
                @Override
                public int compare(UPatient o1, UPatient o2) {
                    if(o1.getLostFollowupTime()==null){
                        return 1;
                    }else if(o2.getLostFollowupTime()==null){
                        return -1;
                    }else{
                        return o1.getLostFollowupTime().compareTo(o2.getLostFollowupTime());
                    }
                }
            });
            targetPatient.setLostFollowupCause(tempPatient.getLostFollowupCause());
            targetPatient.setLostFollowupTime(tempPatient.getLostFollowupTime());
            uPatientRepository.save(targetPatient);
        }

    }

    /**
     * ********生存状态合并 v2版本*****************************************
     * resultValue=4 为死亡状态
     * ν	生存状态：生存状态应根据合并后的随访结果判断， v2 死亡随访结果是刷的
     * //随访结果中有死亡随访时
     * //      刷新生存状态为死亡
     * //      并取其死亡时间及死亡原因等信息；
     * //随访结果中有2条及以上的死亡随访时
     * //      刷新生存状态为死亡
     * //      并取死亡时间最早的随访结果的死亡时间及死亡原因等信息；
     * //*******************************************************************
     *
     * @param targetPatientId
     * @author fqc
     */
    @Override
    public void mergeLiveStatus(Long targetPatientId) {
        //之前的内容其它方式合并，这里只做患者生存状态
        /*List<FollowupResult> followupResultsOfTargetPatient = followupResultService.findFollowupResultsOfTargetPatient(targetPatientId);
        List<FollowupResult> deathRecords = followupResultService.findDeathRecord(targetPatientId);
        if (!deathRecords.isEmpty()) {
            if (deathRecords.size() == 1) {
                followupResultService.batchUpdateResultValue(followupResultsOfTargetPatient, 4);
            } else {
                followupResultService.batchUpdateResultValue(followupResultsOfTargetPatient, 4);
            }
        }*/
        FollowupResult followupResult=followupResultRepository.findByPatientIdAndFollowupResultValueAndMergeFlagNot(targetPatientId,4,2);
        if(followupResult!=null){
            UPatient patient=uPatientRepository.findByPatientId(targetPatientId);
            patient.setLiveStatus(0);
            patient.setDeathDate(followupResult.getDeathDate());
            patient.setCauseOfDeath(followupResult.getDeathCause());
            uPatientRepository.save(patient);
        }

    }

    @Override
    public void updatePatientSyncFlag(Long patientId,Integer fromSyncFlag, Integer toSyncFlag) {
        UPatient patient=uPatientRepository.findByPatientId(patientId);
        //if(patient.getSyncFlag()!=null&&patient.getSyncFlag().equals(-3)){
        //    patient.setSyncFlag(0);
        //    uPatientRepository.save(patient);
        //}
        TPatientSyncResultClient patientSyncResult=patientSyncResultClientRepository.findOne(patient.getUuid());
        if(patientSyncResult.getSyncFlag()!=null&&patientSyncResult.equals(fromSyncFlag))
            patientSyncResult.setSyncFlag(toSyncFlag);
        patientSyncResultClientRepository.save(patientSyncResult);
    }

    public void flushPatientDisease(Long patientId){
        uPatientRepository.updatePatientDisease(patientId);
    }

}

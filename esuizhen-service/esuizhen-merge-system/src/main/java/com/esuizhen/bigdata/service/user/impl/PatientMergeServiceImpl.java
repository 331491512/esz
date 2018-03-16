package com.esuizhen.bigdata.service.user.impl;

import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.bean.OtherPatients;
import com.esuizhen.bigdata.bean.PatientResult;
import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UUser;
import com.esuizhen.bigdata.domain.user.UuidPatientMerge;
import com.esuizhen.bigdata.repository.ehr.PatientMedicalRepository;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.repository.user.PatientMergeRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.MergeService;
import com.esuizhen.bigdata.service.user.PatientMergeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nidan on 2016年12月23 上午 10:56
 */
@Service
@Transactional
public class PatientMergeServiceImpl implements PatientMergeService {
    public static final Logger LOGGER = LoggerFactory.getLogger(PatientMergeServiceImpl.class);
    @Autowired
    private PatientMergeRepository patientMergeRepository;
    @Autowired
    private MergeService mergeService;
    @Autowired
    private FollowupResultRepository followupResultRepository;
    @Autowired
    private PatientMedicalRepository patientMedicalRepository;
    @Autowired
    private UPatientRepository patientRepository;

    @Override
    public int mergePatientInfo(MergePatientReq req) {
        StringBuilder patientIds = new StringBuilder("");
        for (Long patientId : req.getOtherPatientIds()) {
            patientIds.append(patientId);
            patientIds.append(",");
        }
        patientIds = patientIds.delete(patientIds.length() - 1, patientIds.length());
        LOGGER.error("合并参数*********************** |" + patientIds + "| |" + req.getOperatorId() + "| |" + req.getMergeReason() + "|");
        int result = patientMergeRepository.patientMerge(patientIds.toString(), req.getOperatorId(), req.getMergeReason());
        LOGGER.info("合并存储过程result-->>:{}", result);
        return result;
    }

    @Override
    public void updatePatientSimilarState(Long patientId) throws Exception {
        UuidPatientMerge patientMerge = patientMergeRepository.findByPatientid(patientId);
        List<UuidPatientMerge> patientMerges = patientMergeRepository.findAllByGoalpatientid(patientMerge.getGoalpatientid());
        if (patientMerges.size() > 2) {
            patientMerge.setRepeatflag(0);
            patientMerge.setCancelflag(1);
            //patientMerge.setGoalpatientid(null);
            patientMerge.setRemark(null);
            patientMergeRepository.save(patientMerge);
        } else {
            for (UuidPatientMerge uuidPatientMerge : patientMerges) {
                uuidPatientMerge.setRepeatflag(0);
                uuidPatientMerge.setCancelflag(1);
                //uuidPatientMerge.setGoalpatientid(null);
                patientMerge.setRemark(null);
                patientMergeRepository.save(uuidPatientMerge);
            }
        }
    }

    @Override
    public PatientResult electionTargetPatient(List<Long> patientIds) {
        List<Long> patientIdsVote = new ArrayList<>();
        patientIdsVote.addAll(patientIds);
                //Lists.newArrayList(patientIds);
        Map<String, Object> map = mergeService.vote(patientIdsVote);
        //List<Long> otherPatientIds = (List<Long>) map.get("otherPatientIds");
        Long goalPatientId = (Long) map.get("goalPatientId");

        List<FollowupResult> list = followupResultRepository.findAllByFollowupResultValueAndPatientIdIn(4, patientIds);
        PatientResult patientResult = new PatientResult();

        UPatient p = patientRepository.findByPatientId(goalPatientId);
        UUser user = p.getuUserByUserId();
        patientResult.setPatientId(p.getPatientId());
        patientResult.setTrueName(p.getTrueName());
        patientResult.setPatientNo(p.getPatientNo());
        patientResult.setBirthDate(user.getBirthDate());
        patientResult.setIdentification(user.getIdentification());
        patientResult.setSex(p.getSex());

        if (list != null && list.size() > 1) {
            List<OtherPatients> otherPatients = new ArrayList<>();
            OtherPatients patients = null;
            for (FollowupResult followupResult : list) {
                patients = new OtherPatients();
                UPatient patient = followupResult.getuPatientByPatientId();
                patients.setPatientId(patient.getPatientId());
                patients.setPatientNo(patient.getPatientNo());
                patients.setTrueName(patient.getTrueName());
                patients.setDeathDate(followupResult.getDeathDate());
                patients.setDeathReason(followupResult.getDeathCause());
                if(followupResult.getDeathDate()!=null) {
                    List<FollowupResult> list1 = followupResultRepository.findAllByPatientIdInAndFollowupResultValueNotAndFollowupTimeGreaterThan(patientIds, 4, followupResult.getDeathDate());
                    boolean result1 = false;
                    boolean result2 = false;
                    if (list1 != null && list1.size() > 0) {
                        for (FollowupResult fr : list1) {
                            if (fr.getFollowupWay() == 1 || fr.getFollowupWay() == 2
                                    || fr.getFollowupWay() == 3 || fr.getFollowupWay() == 4) {
                                // patients.setIsAfterFollowupResult(1);
                                result1 = true;
                            } else if (fr.getFollowupWay() == 7 || fr.getFollowupWay() == 8) {
                                //patients.setIsAfterFollowupResult(2);
                                result2 = true;
                            }
                        }
                    } else {
                        patients.setIsAfterFollowupResult(0);
                    }
                    if (result1 && result2) {
                        patients.setIsAfterFollowupResult(3);
                    } else if (result1) {
                        patients.setIsAfterFollowupResult(1);
                    } else if (result2) {
                        patients.setIsAfterFollowupResult(2);
                    } else {
                        patients.setIsAfterFollowupResult(0);
                    }
                    /*VarPatientMedical patientMedical1 = patientMedicalRepository.findByPatientIdAndLatestClinicDateGreaterThan(followupResult.getPatientId(), followupResult.getFollowupTime());
                    VarPatientMedical patientMedical2 = patientMedicalRepository.findByPatientIdAndLatestOutHospitalDateGreaterThan(followupResult.getPatientId(), followupResult.getFollowupTime());
                    if (patientMedical1 != null || patientMedical2 != null) {
                        patients.setIsAfterOutpatient(1);
                    } else {
                        patients.setIsAfterOutpatient(0);
                    }*/
                }
                otherPatients.add(patients);
            }
            patientResult.setOtherPatients(otherPatients);
        }
        return patientResult;
    }
}

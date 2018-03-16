package com.esuizhen.bigdata.service.user.impl;

import com.esuizhen.bigdata.domain.mergebak.user.UPatientMergeBak;
import com.esuizhen.bigdata.domain.mergebak.user.UUserMergeBak;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UPatientFamily;
import com.esuizhen.bigdata.domain.user.UUser;
import com.esuizhen.bigdata.domain.user.UuidPatientMerge;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.repository.followup.VarPatientMedicalRepository;
import com.esuizhen.bigdata.repository.user.*;
import com.esuizhen.bigdata.service.EntityBakService;
import com.esuizhen.bigdata.service.MergeService;
import com.esuizhen.bigdata.service.RollBackMergeService;
import com.esuizhen.bigdata.service.ehr.*;
import com.esuizhen.bigdata.service.followup.*;
import com.esuizhen.bigdata.service.user.DeptPatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 17/1/3.
 */
@Service
@Transactional
public class RollBackMergeServiceImpl implements RollBackMergeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeService.class);

    @Autowired
    private UPatientRepository uPatientRepository;
    @Autowired
    private UuidPatientMergeRepository uuidPatientMergeRepository;
    @Autowired
    private FollowupResultRepository followupResultRepository;
    @Autowired
    private VarPatientMedicalRepository varPatientMedicalRepository;
    @Autowired
    private UPatientFamilyRepository uPatientFamilyRepository;
    @Autowired
    private UPatientMergeBakRepository uPatientMergeBakRepository;
    @Autowired
    private UUserRepository userRepository;
    @Autowired
    private UUserMergeBakRepository uUserMergeBakRepository;
    @Autowired
    private EntityBakService entityBakService;
    @Autowired
    private FollowupResultService followupResultService;
    @Autowired
    RFollowupTaskPatientService rFollowupTaskPatientService;

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
    private FollowupResultBufferService followupResultBufferService;
    @Autowired
    private PatientMergeRepository patientMergeRepository;
    @Autowired
    private DeptPatientService deptPatientService;

    List<UPatient> otherPatients;
    UPatient targetPatient;
    UPatientMergeBak targetPatientBak;
    Long targetPatientId;
    UUser targetUser;
    List<Long> otherPatientIds = new ArrayList<>();

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void executeRollBackMerge(Long targetPatientId, Long operatorId) {
        Exception ex = null;
        //try {

            outhospitalNoteService.revokeMergeOuthospitalNote(targetPatientId);
            diagnosisInfoService.revokeMergeDiagnosisInfo(targetPatientId);
            surgeryNoteService.revokeMergeSurgeryNote(targetPatientId);
            treatmentNoteService.revokeMergeTreatmentNote(targetPatientId);

            inhospitalNoteService.revokeMergeInhospitalNote(targetPatientId);

            clinicMedicalNoteService.revokeMergeClinicMedicalNote(targetPatientId);

            detectionDetailService.revokeMergeDetectionDetail(targetPatientId);
            detectionReportService.revokeMergeDetectionReport(targetPatientId);
            examReportService.revokeMergeExamReport(targetPatientId);

            followupCallReqService.revokeMergeFollowupCallReq(targetPatientId);
            followupSmsReqService.revokeMergeFollowupSmsReq(targetPatientId);
            followupWxReqService.revokeMergeFollowupWxReq(targetPatientId);

            followupResultBufferService.rollback(targetPatientId,otherPatientIds);
            rFollowupTaskPatientService.rollback(targetPatientId);
            followupResultService.rollback(targetPatientId);

            entityBakService.cancleUpdateUuidPatientNo(targetPatientId);

            deptPatientService.revokeMergeDeptPatient(targetPatientId);

            initialFrozenPatients(targetPatientId);
            rollbackMergedUsers(otherPatients);
            rollbackTargetUser(targetPatient);
            clearBackupOfTargetUser(targetUser);

            rollBackOtherPatients(otherPatients);
            rollBackTargetPatient(targetPatient);

            rollBackPatientFamily(targetPatientId);
            //int a = 1 / 0;回滚测试通过
            clearBackupOfTargetPatient(targetPatientId);
            //修改回其疑似状态,重新回到疑似患者列表
            //rollbackSimilarState(targetPatientId);暂时使用脚本刷

            LOGGER.info("==> 撤销合并后刷新脚本flushTaskPatientStateAndNumber开始-->");
            boolean result=patientMergeRepository.flushTaskPatientStateAndNumber();
            LOGGER.info("==> 撤销合并后刷新脚本flushTaskPatientStateAndNumber结束-->{}",result);
            LOGGER.info("回退合并成功！");

            //更新患者的最近随访结果
            LOGGER.info("==> 更新患者的最近随访结果开始！-->");
            for (Long patientId:otherPatientIds)
                followupResultService.updateVarPatientFollowupResult(patientId);
            LOGGER.info("==> 更新患者的最近随访结果完成！-->");


            //更新目标患者及被合并患的处理标识，以作病种刷新等其他数据的刷新
            entityBakService.updateHandleFlag(targetPatientId);
            for(Long patientId:otherPatientIds)
                entityBakService.updateHandleFlag(patientId);

            //entityBakService.rollbackPatientSyncFlag(targetPatientId,otherPatientIds);

        /*} catch (Exception e) {
            LOGGER.info("出现异常-->message:{},stackMessage:{},之前操作开始回滚", e.getMessage(), e.getStackTrace());
            ex = e;
        } finally {
            if (ex != null) {
                LOGGER.info("回退合并失败");
                LOGGER.info("记录回退日志中...");//todo
                throw new RuntimeException(ex);
            }
            LOGGER.info("回退合并成功！");
        }*/
    }

    /**
     * 患者的联系人回退
     * @param targetPatientId
     */
    private void rollBackPatientFamily(Long targetPatientId) {
        List<UPatientFamily> patientFamilys=uPatientFamilyRepository.findByMergeTarget(targetPatientId);
        /*patientFamilys.forEach(o1 -> {
            if(o1.getMergeFlag().equals(1)){
                uPatientFamilyRepository.delete(o1);
            }else if(o1.getMergeFlag().equals(2)){
                o1.setMergeFlag(0);
                o1.setMergeFrom(null);
                o1.setMergeTarget(null);
                o1.setMergeTime(null);
                uPatientFamilyRepository.save(o1);
            }
        });*/
        for (UPatientFamily o1 : patientFamilys) {
            if(o1.getMergeFlag().equals(1)){
                uPatientFamilyRepository.delete(o1);
            }else if(o1.getMergeFlag().equals(2)){
                o1.setMergeFlag(0);
                o1.setMergeFrom(null);
                o1.setMergeTarget(null);
                o1.setMergeTime(null);
                uPatientFamilyRepository.save(o1);
            }
        }

    }

    @Override
    public void rollbackSimilarState(Long targetPatientId) {
        List<UuidPatientMerge> similarGroup = uuidPatientMergeRepository.findByGoalpatientidAndRepeatflagAndResultflag(targetPatientId, 0, 1);
        /*similarGroup.forEach(uuidPatientMerge -> {
            uuidPatientMerge.setRepeatflag(1);
            uuidPatientMerge.setResultflag(0);
        });*/
        for (UuidPatientMerge uuidPatientMerge : similarGroup) {
            uuidPatientMerge.setRepeatflag(1);
            uuidPatientMerge.setResultflag(0);
        }
        uuidPatientMergeRepository.save(similarGroup);
    }

    @Override
    public void rollbackTargetUser(UPatient targetPatient) {
        UUserMergeBak userBak = uUserMergeBakRepository.findOne(targetUser.getUserId());
        if (userBak != null) {
            BeanUtils.copyProperties(userBak, targetUser);
            rollbackMergedUserAboutState(targetUser);
        }
    }

    @Override
    public void rollbackMergedUsers(List<UPatient> otherPatients) {
        /*otherPatients.forEach(patient -> {
            UUser user = patient.getuUserByUserId();
            rollbackMergedUserAboutState(user);
        });*/
        for (UPatient patient : otherPatients) {
            UUser user = patient.getuUserByUserId();
            rollbackMergedUserAboutState(user);
        }
    }

    @Override
    public void clearBackupOfTargetUser(UUser targetUser) {
        LOGGER.info("去除目标患者{}对应的User[useId->{}]的备份", targetPatientId, targetUser.getUserId());
        if (targetUser != null) {
            if (!uUserMergeBakRepository.findByUserId(targetUser.getUserId()).isEmpty()) {
                uUserMergeBakRepository.delete(targetUser.getUserId());
            }
        }
    }


    public void rollbackMergedUserAboutState(UUser user) {
        user.setMergeFlag(0);
        user.setMergeFrom(null);
        user.setMergeTarget(null);
        user.setMergeTime(null);
    }

    @Override
    public void clearBackupOfTargetPatient(Long targetPatientId) {
        LOGGER.info("去除目标患者{}的备份", targetPatientId);
        uPatientMergeBakRepository.delete(targetPatientId);
    }

    @Override
    public void rollBackOtherPatients(List<UPatient> otherPatients) {
        LOGGER.info("回退被合并患者{}", otherPatientIds);
        if (0 < otherPatients.size()) {
            /*otherPatients.forEach(
                    patient -> {
                        rollbackMergedPatientAboutState(patient);
                    }
            );*/
            for (UPatient patient : otherPatients) {
                rollbackMergedPatientAboutState(patient);
            }
            return;
        }
        LOGGER.info("回退被合并患者不存在!");

    }

    public void rollbackMergedPatientAboutState(UPatient patient) {
        patient.setMergeFlag(0);
        patient.setMergeFrom(null);
        patient.setMergeTarget(null);
        patient.setMergeTime(null);
        patient.setPatientType(1);
    }

    public void rollbackPatientState(UPatient patient) {
        BeanUtils.copyProperties(targetPatientBak, patient);
        rollbackMergedPatientAboutState(patient);
    }

    @Override
    public void rollBackTargetPatient(UPatient targetPatient) {
        LOGGER.info("回退目标合并患者{}", targetPatientId);
        rollbackPatientState(targetPatient);
    }

    @Override
    public void initialFrozenPatients(Long targetPatientId) {
        LOGGER.info("开始准备回退数据");
        this.targetPatientId = targetPatientId;
        otherPatients = retrieveMergedPatients(targetPatientId);
        //otherPatients.forEach(uPatient -> otherPatientIds.add(uPatient.getPatientId()));
        for (UPatient uPatient : otherPatients) {
            otherPatientIds.add(uPatient.getPatientId());
        }
        targetPatient = uPatientRepository.findByPatientId(targetPatientId);
        targetPatientBak = uPatientMergeBakRepository.findByPatientId(targetPatientId);
        if (targetPatientBak == null) {
            throw new RuntimeException("目标患者的备份竟然不存在...属于脏数据，已无法程序回退，想要恢复次数据，需要还原数据库");
        }
        targetUser = targetPatient.getuUserByUserId();

    }

    @Override
    public List<UPatient> retrieveMergedPatients(Long targetPatientId) {
        LOGGER.info("找到合并组患者");
        List<UPatient> otherPatients = uPatientRepository.findByMergeTarget(targetPatientId);
        LOGGER.info("将要被回退合并的患者");
        //otherPatients.forEach(patient -> LOGGER.info(patient.toString()));
        for (UPatient patient : otherPatients) {
            LOGGER.info(patient.toString());
        }
        return otherPatients;
    }
}

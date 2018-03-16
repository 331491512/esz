package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.ehr.EDiagnosisInfo;
import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;
import com.esuizhen.bigdata.repository.ehr.DiagnosisInfoRepository;
import com.esuizhen.bigdata.repository.ehr.InhospitalNoteRepository;
import com.esuizhen.bigdata.service.ehr.DiagnosisInfoService;
import com.esuizhen.bigdata.service.user.impl.PatientMergeServiceImpl;
import com.westangel.common.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 上午 11:15
 */
@Service
@Transactional
public class DiagnosisInfoServiceImpl implements DiagnosisInfoService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PatientMergeServiceImpl.class);

    @Autowired
    private DiagnosisInfoRepository diagnosisInfoRepository;
    @Autowired
    private InhospitalNoteRepository inhospitalNoteRepository;

    /*@Override
    public void mergeDiagnosisInfo(Long goalPatientId, List<Long> otherPatientIds) {
        LOGGER.info("==> 开始诊断信息");
        List<EDiagnosisInfo> diagnosisInfos = diagnosisInfoRepository.findAllByPatientIdIn(otherPatientIds);
        EDiagnosisInfo diagnosisInfo2 = null;
        if (diagnosisInfos != null && !(diagnosisInfos.isEmpty())) {
            for (EDiagnosisInfo diagnosisInfo : diagnosisInfos) {
                diagnosisInfo.setMergeFlag(2);
                diagnosisInfo.setMergeTime(new Timestamp(System.currentTimeMillis()));
                diagnosisInfoRepository.save(diagnosisInfo);

                diagnosisInfo2 = new EDiagnosisInfo();
                BeanUtils.copyProperties(diagnosisInfo, diagnosisInfo2);

                diagnosisInfo2.setMergeFrom(diagnosisInfo.getPatientId());
                diagnosisInfo2.setMergeTarget(goalPatientId);
                diagnosisInfo2.setOldInhospitalTimes(diagnosisInfo.getInhospitalTimes());
                diagnosisInfo2.setOldPatientNo(diagnosisInfo.getPatientNo());

                //EiInhospitalNote inhospitalNote = inhospitalNoteRepository.findByOldPatientNoAndOldInhospitalTimes(diagnosisInfo.getPatientNo(), diagnosisInfo.getInhospitalTimes());
                EiInhospitalNote inhospitalNote = inhospitalNoteRepository.findByOldPatientNoAndOldInhospitalTimes(diagnosisInfo.getOldPatientNo(), diagnosisInfo.getOldInhospitalTimes());

                diagnosisInfo2.setInhospitalTimes(inhospitalNote.getInhospitalTimes());
                diagnosisInfo2.setInhospitalId(inhospitalNote.getInhospitalId());
                diagnosisInfo2.setPatientNo(inhospitalNote.getPatientNo());
                diagnosisInfo2.setDiagnosisId(GeneralUtil.generateUniqueID("DIAG"));
                diagnosisInfo2.setPatientId(inhospitalNote.getPatientId());
                diagnosisInfoRepository.save(diagnosisInfo);
            }
            LOGGER.info("==> 将{}条诊断记录追加到目标患者{}上", diagnosisInfos.size(), goalPatientId);
        }

    }*/

    /**
     * updated by fqc
     *
     * @param goalPatientId
     * @param otherPatientIds
     */
    @Override
    public void mergeDiagnosisInfo(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes) {
        LOGGER.info("==> 开始诊断信息");
        List<EDiagnosisInfo> diagnosisInfos = diagnosisInfoRepository.findAllByPatientIdIn(otherPatientIds);
        if (diagnosisInfos != null && !(diagnosisInfos.isEmpty())) {
            EDiagnosisInfo appended2Target=null;
            for (EDiagnosisInfo eDiagnosisInfo : diagnosisInfos) {
                EiInhospitalNote inhospitalNote = this.getCurrentInhospitalNote(inhospitalNotes, eDiagnosisInfo);
                if(inhospitalNote==null){
                    continue;
                }
                //diagnosisInfos.forEach(eDiagnosisInfo -> {
                //先追加
                appended2Target = new EDiagnosisInfo();
                BeanUtils.copyProperties(eDiagnosisInfo, appended2Target, "diagnosisId", "patientId");
                appended2Target.setPatientId(goalPatientId);
                appended2Target.setMergeFlag(1);
                appended2Target.setDiagnosisId(GeneralUtil.generateUniqueID("DIAG")+GeneralUtil.generatorUUID());
                appended2Target.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());
                appended2Target.setMergeFrom(eDiagnosisInfo.getPatientId());
                appended2Target.setMergeTarget(goalPatientId);
                appended2Target.setMergeTime(TimeUtils.getCurrentTimestamp());

                appended2Target.setOldInhospitalTimes(eDiagnosisInfo.getInhospitalTimes());
                appended2Target.setOldPatientNo(eDiagnosisInfo.getPatientNo());

                //List<EiInhospitalNote> inhospitalNotes =
                //        inhospitalNoteRepository.findFirstByOldPatientNoAndOldInhospitalTimesAndMergeFromAndMergeFlag(eDiagnosisInfo.getOldPatientNo(), eDiagnosisInfo.getOldInhospitalTimes(), eDiagnosisInfo.getPatientId(),1);

                if (!inhospitalNotes.isEmpty()) {
                    //EiInhospitalNote inhospitalNote = inhospitalNotes.get(0);
                    appended2Target.setInhospitalTimes(inhospitalNote.getInhospitalTimes());
                    appended2Target.setInhospitalId(inhospitalNote.getInhospitalId());
                    appended2Target.setPatientNo(inhospitalNote.getPatientNo());
                    appended2Target.setDiagnosisId(GeneralUtil.generateUniqueID("DIAG")+GeneralUtil.generatorUUID());
                    appended2Target.setPatientId(inhospitalNote.getPatientId());
                    diagnosisInfoRepository.save(appended2Target);
                }


                //再标记
                eDiagnosisInfo.setMergeFlag(2);
                eDiagnosisInfo.setMergeFrom(eDiagnosisInfo.getPatientId());
                eDiagnosisInfo.setMergeTarget(goalPatientId);
                eDiagnosisInfo.setMergeTime(TimeUtils.getCurrentTimestamp());
                diagnosisInfoRepository.save(eDiagnosisInfo);
            }
        }


        LOGGER.info("==> 将{}条诊断记录追加到目标患者{}上", diagnosisInfos.size(), goalPatientId);

    }

    private EiInhospitalNote getCurrentInhospitalNote(List<EiInhospitalNote> inhospitalNotes, EDiagnosisInfo eDiagnosisInfo) {
        EiInhospitalNote inhospitalNote=null;
        for (EiInhospitalNote o : inhospitalNotes){
            if(o.getOldInhospitalId()!=null&&o.getOldInhospitalId().equals(eDiagnosisInfo.getInhospitalId())){
                inhospitalNote=o;
            }
        }
        return inhospitalNote;

    }

    @Override
    public void revokeMergeDiagnosisInfo(Long patientId) {
        diagnosisInfoRepository.deleteByMergeTargetAndMergeFlag(patientId, 1);
        diagnosisInfoRepository.updateMergeFlag(patientId, 2);
    }

    @Override
    public void updateHandleFlagByPatientId(Long patientId) {
        diagnosisInfoRepository.updateHandleFlagByPatientId(patientId);
    }
}

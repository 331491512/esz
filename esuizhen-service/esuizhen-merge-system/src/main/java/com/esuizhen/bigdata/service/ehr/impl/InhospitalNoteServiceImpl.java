package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.repository.ehr.*;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.ehr.InhospitalNoteService;
import com.esuizhen.bigdata.service.user.impl.PatientMergeServiceImpl;
import com.westangel.common.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nidan on 2017年01月03 下午 16:32
 */
@Service
@Transactional
public class InhospitalNoteServiceImpl implements InhospitalNoteService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PatientMergeServiceImpl.class);
    @Autowired
    private InhospitalNoteRepository inhospitalNoteRepository;
    @Autowired
    private UPatientRepository patientRepository;
    @Autowired
    private DiagnosisInfoRepository diagnosisInfoRepository;
    @Autowired
    private SurgeryNoteRepository surgeryNoteRepository;
    @Autowired
    private TreatmentNoteRepository treatmentNoteRepository;
    @Autowired
    private OuthospitalNoteRepository outhospitalNoteRepository;

    @Override
    public List<EiInhospitalNote> mergeInhospitalNote(Long goalPatientId, List<Long> otherPatientIds) {
        List<EiInhospitalNote> inhospitalNotes=new ArrayList<>();
        LOGGER.info("==> 开始合并住院信息");
        List<EiInhospitalNote> list = inhospitalNoteRepository.findAllByPatientIdIn(otherPatientIds);
        UPatient patient = patientRepository.findByPatientId(goalPatientId);
        EiInhospitalNote inhospitalNote2 = null;
        if (list != null && !(list.isEmpty())) {
            for (EiInhospitalNote inhospitalNote : list) {

                inhospitalNote.setMergeTime(new Timestamp(System.currentTimeMillis()));
                inhospitalNote.setMergeTarget(goalPatientId);
                inhospitalNote.setMergeFrom(inhospitalNote.getPatientId());
                inhospitalNote.setMergeFlag(2);
                //标记当前住院信息
                inhospitalNoteRepository.save(inhospitalNote);

                inhospitalNote2 = new EiInhospitalNote();
                BeanUtils.copyProperties(inhospitalNote, inhospitalNote2);
                inhospitalNote2.setMergeFrom(inhospitalNote.getPatientId());
                inhospitalNote2.setMergeTarget(goalPatientId);
                inhospitalNote2.setMergeFlag(1);
                inhospitalNote2.setOldInhospitalId(inhospitalNote.getInhospitalId());
                inhospitalNote2.setOldPatientNo(inhospitalNote.getPatientNo());
                inhospitalNote2.setOldInhospitalTimes(inhospitalNote.getInhospitalTimes());
                inhospitalNote2.setPatientId(goalPatientId);
                inhospitalNote2.setInhospitalId(GeneralUtil.generateUniqueID("EINH")+GeneralUtil.generatorUUID());
                inhospitalNote2.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());
                inhospitalNote2.setPatientNo(patient.getPatientNo());
                inhospitalNote2.setPatientUuid(patient.getUuid());
                //将住院信息复制到目标患者
                inhospitalNoteRepository.save(inhospitalNote2);
                inhospitalNotes.add(inhospitalNote2);
            }
            LOGGER.info("==> 将{}条住院记录追加到目标患者{}上", list.size(), goalPatientId);
            //重新计算患者的住院次数
            this.reCountInhospitalTimes(goalPatientId);
        }
        return inhospitalNotes;
    }

    @Override
    public void reCountInhospitalTimes(Long goalPatientId) {
        List<EiInhospitalNote> inhospitalNotes = inhospitalNoteRepository.findAllByPatientIdOrderByInhospitalDateAsc(goalPatientId);
        int count = 1;
        for (EiInhospitalNote eiInhospitalNote : inhospitalNotes) {
            eiInhospitalNote.setInhospitalTimes(count);
            inhospitalNoteRepository.save(eiInhospitalNote);
            //住院信息下其他信息的住院次数更新
            this.modifyPatientTnhospitalTimes(eiInhospitalNote);
            count++;
        }
        LOGGER.info("==> 重新计算目标患者{}的住院次数为->{}", goalPatientId, count);
    }

    @Override
    public void revokeMergeInhospitalNote(Long patientId) {
        //删除合并过来的住院信息
        inhospitalNoteRepository.deleteByMergeTargetAndMergeFlag(patientId, 1);

        //更新合并的住院标识
        inhospitalNoteRepository.updateMergeFlag(patientId, 2);

        //重新计算患者的住院次数
        this.reCountInhospitalTimes(patientId);

    }

    /**
     * 住院信息下其他信息的住院次数更新
     * @param eiInhospitalNote
     */
    private void modifyPatientTnhospitalTimes(EiInhospitalNote eiInhospitalNote){
        diagnosisInfoRepository.updateInhospitalTImesByInhospitalId(
                eiInhospitalNote.getInhospitalTimes(),eiInhospitalNote.getInhospitalId());
        surgeryNoteRepository.updateInhospitalTImesByInhospitalId(
                eiInhospitalNote.getInhospitalTimes(),eiInhospitalNote.getInhospitalId());
        //治疗信息中无住院次数
        //treatmentNoteRepository.updateInhospitalTImesByInhospitalId(
        //        eiInhospitalNote.getInhospitalTimes(),eiInhospitalNote.getInhospitalId());
        outhospitalNoteRepository.updateInhospitalTImesByInhospitalId(
                eiInhospitalNote.getInhospitalTimes(),eiInhospitalNote.getInhospitalId());

    }
}

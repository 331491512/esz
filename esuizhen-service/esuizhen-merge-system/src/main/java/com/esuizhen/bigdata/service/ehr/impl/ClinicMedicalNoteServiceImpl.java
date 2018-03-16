package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.ehr.EcClinicMedicalNote;
import com.esuizhen.bigdata.repository.ehr.ClinicMedicalNoteRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.ehr.ClinicMedicalNoteService;
import com.westangel.common.util.GeneralUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:42
 */
@Service
@Transactional
public class ClinicMedicalNoteServiceImpl implements ClinicMedicalNoteService {

    @Autowired
    private ClinicMedicalNoteRepository clinicMedicalNoteRepository;
    @Autowired
    private UPatientRepository patientRepository;

    @Override
    public void mergeClinicMedicalNote(Long goalPatientId, List<Long> otherPatientIds) {
        List<EcClinicMedicalNote> list = clinicMedicalNoteRepository.findAllByPatientIdIn(otherPatientIds);

        /*for (EcClinicMedicalNote clinicMedicalNote : list) {
            clinicMedicalNote.setMergeFlag(2);
            clinicMedicalNote.setMergeTime(new Timestamp(System.currentTimeMillis()));
            clinicMedicalNoteRepository.save(clinicMedicalNote);

            clinicMedicalNote2 = new EcClinicMedicalNote();
            clinicMedicalNote2.setClinicMedicalId(GeneralUtil.generateUniqueID("ECLI"));
            clinicMedicalNote2.setMergeTarget(goalPatientId);
            clinicMedicalNote2.setMergeFrom(clinicMedicalNote.getPatientId());
            UPatient patient = patientRepository.findByPatientId(goalPatientId);
            clinicMedicalNote2.setPatientId(goalPatientId);
            clinicMedicalNote2.setPatientNo(patient.getPatientNo());
            clinicMedicalNoteRepository.save(clinicMedicalNote2);
        }*/
        if (list != null && !(list.isEmpty())) {
            for (EcClinicMedicalNote ecClinicMedicalNote: list){
            //list.forEach(ecClinicMedicalNote -> {
                //先追加
                EcClinicMedicalNote clinicMedicalNote2 = new EcClinicMedicalNote();
                BeanUtils.copyProperties(ecClinicMedicalNote, clinicMedicalNote2, "clinicMedicalId", "patientId");
                clinicMedicalNote2.setClinicMedicalId(GeneralUtil.generateUniqueID("ECLI")+GeneralUtil.generatorUUID());
                clinicMedicalNote2.setPatientId(goalPatientId);
                clinicMedicalNote2.setMergeFlag(1);
                clinicMedicalNote2.setMergeFrom(ecClinicMedicalNote.getPatientId());
                clinicMedicalNote2.setMergeTarget(goalPatientId);
                clinicMedicalNote2.setMergeTime(TimeUtils.getCurrentTimestamp());
                clinicMedicalNote2.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());

                clinicMedicalNoteRepository.save(clinicMedicalNote2);
                //再标记
                ecClinicMedicalNote.setMergeFlag(2);
                ecClinicMedicalNote.setMergeFrom(ecClinicMedicalNote.getPatientId());
                ecClinicMedicalNote.setMergeTarget(goalPatientId);
                ecClinicMedicalNote.setMergeTime(TimeUtils.getCurrentTimestamp());
                clinicMedicalNoteRepository.save(ecClinicMedicalNote);
            }
        }
    }

    @Override
    public void revokeMergeClinicMedicalNote(Long patientId) {

        //删除被合并过的门诊
        clinicMedicalNoteRepository.deleteByMergeTargetAndMergeFlag(patientId, 1);

        //更新合并标识
        clinicMedicalNoteRepository.updateMergeFlag(patientId, 2);

    }
}

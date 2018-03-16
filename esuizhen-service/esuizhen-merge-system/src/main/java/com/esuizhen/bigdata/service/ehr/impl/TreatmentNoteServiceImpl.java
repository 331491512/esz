package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.domain.ehr.EciTreatmentNote;
import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;
import com.esuizhen.bigdata.repository.ehr.InhospitalNoteRepository;
import com.esuizhen.bigdata.repository.ehr.TreatmentNoteRepository;
import com.esuizhen.bigdata.service.ehr.TreatmentNoteService;
import com.esuizhen.bigdata.service.user.impl.PatientMergeServiceImpl;
import com.westangel.common.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:08
 */
@Service
@Transactional
public class TreatmentNoteServiceImpl implements TreatmentNoteService {
    public static final Logger LOGGER = LoggerFactory.getLogger(PatientMergeServiceImpl.class);

    @Autowired
    private TreatmentNoteRepository treatmentNoteRepository;
    @Autowired
    private InhospitalNoteRepository inhospitalNoteRepository;

    @Override
    public void mergeTreatNote(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes) {
        LOGGER.info("==> 开始治疗记录合并");
        List<EciTreatmentNote> list = treatmentNoteRepository.findAllByPatientIdIn(otherPatientIds);
        EciTreatmentNote treatmentNote2 = null;
        for (EciTreatmentNote treatmentNote : list) {
            EiInhospitalNote inhospitalNote=this.getCurrentInhospitalNote(inhospitalNotes,treatmentNote);
            if(inhospitalNote==null){
                continue;
            }
            treatmentNote.setMergeFlag(2);
            treatmentNote.setMergeTarget(goalPatientId);
            treatmentNote.setMergeFrom(treatmentNote.getPatientId());
            treatmentNote.setMergeTime(new Timestamp(System.currentTimeMillis()));
            treatmentNoteRepository.save(treatmentNote);

            treatmentNote2 = new EciTreatmentNote();
            BeanUtils.copyProperties(treatmentNote, treatmentNote2, "treatmentId", "patientId");
            treatmentNote2.setMergeFrom(treatmentNote.getPatientId());
            treatmentNote2.setMergeTarget(goalPatientId);
            treatmentNote2.setMergeFlag(1);
           // EiInhospitalNote inhospitalNote = inhospitalNoteRepository.findByOldInhospitalIdAndMergeFlag(treatmentNote.getInHospitalId(),1);
            treatmentNote2.setPatientId(goalPatientId);
            treatmentNote2.setPatientNo(inhospitalNote.getPatientNo());
            treatmentNote2.setPatientUuid(inhospitalNote.getPatientUuid());
            treatmentNote2.setInHospitalId(inhospitalNote.getInhospitalId());
            treatmentNote2.setTreatmentId(GeneralUtil.generateUniqueID("ETRE")+GeneralUtil.generatorUUID());
            treatmentNote2.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());
            treatmentNoteRepository.save(treatmentNote2);
        }
        LOGGER.info("==> 将{}条治疗记录追加到目标患者{}上", list.size(), goalPatientId);

    }

    private EiInhospitalNote getCurrentInhospitalNote(List<EiInhospitalNote> inhospitalNotes, EciTreatmentNote treatmentNote) {
        EiInhospitalNote inhospitalNote=null;
        for (EiInhospitalNote o : inhospitalNotes){
            if(o.getOldInhospitalId()!=null&&o.getOldInhospitalId().equals(treatmentNote.getInHospitalId())){
                inhospitalNote=o;
            }
        }
        return inhospitalNote;
    }

    @Override
    public void revokeMergeTreatmentNote(Long patientId) {
        treatmentNoteRepository.deleteByMergeTargetAndMergeFlag(patientId, 1);
        treatmentNoteRepository.updateMergeFlag(patientId, 2);
    }
}

package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.ehr.EciSurgeryNote;
import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;
import com.esuizhen.bigdata.repository.ehr.InhospitalNoteRepository;
import com.esuizhen.bigdata.repository.ehr.SurgeryNoteRepository;
import com.esuizhen.bigdata.service.EntityBakService;
import com.esuizhen.bigdata.service.ehr.SurgeryNoteService;
import com.westangel.common.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 18:47
 */
@Service
@Transactional
public class SurgeryNoteServiceImpl implements SurgeryNoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityBakService.class);

    @Autowired
    private SurgeryNoteRepository surgeryNoteRepository;
    @Autowired
    private InhospitalNoteRepository inhospitalNoteRepository;

   /* @Override
    public void mergeSurgeryNote(Long goalPatientId, List<Long> otherPatientIds) {

        List<EciSurgeryNote> list=surgeryNoteRepository.findAllByPatientIdIn(otherPatientIds);
        EciSurgeryNote surgeryNote2=null;
        for (EciSurgeryNote surgeryNote : list) {
            surgeryNote.setMergeTime(new Timestamp(System.currentTimeMillis()));
            surgeryNote.setMergeFlag(2);
            surgeryNoteRepository.save(surgeryNote);

            surgeryNote2=new EciSurgeryNote();
            BeanUtils.copyProperties(surgeryNote,surgeryNote2);


            EiInhospitalNote inhospitalNote=inhospitalNoteRepository.findByOldPatientNoAndOldInhospitalTimes(
                    surgeryNote.getPatientNo(),surgeryNote.getInhospitalTimes());

            surgeryNote2.setOldPatientNo(surgeryNote.getPatientNo());
            surgeryNote2.setOldInhospitalTimes(surgeryNote.getInhospitalTimes());
            surgeryNote2.setMergeFrom(surgeryNote.getPatientId());
            surgeryNote2.setMergeTarget(goalPatientId);
            surgeryNote2.setPatientUuid(inhospitalNote.getPatientUuid());
            surgeryNote2.setSurgeryId(GeneralUtil.generateUniqueID("ESUR"));
            surgeryNote2.setPatientNo(inhospitalNote.getPatientNo());
            surgeryNote2.setPatientId(goalPatientId);
            surgeryNote2.setInhospitalId(inhospitalNote.getInhospitalId());
            surgeryNote2.setInhospitalTimes(inhospitalNote.getInhospitalTimes());
            surgeryNoteRepository.save(surgeryNote2);
        }
    }*/

    /**
     * updated by fqc
     *
     * @param goalPatientId
     * @param otherPatientIds
     */
    @Override
    public void mergeSurgeryNote(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes) {
        LOGGER.info("==> 开始手术信息");
        List<EciSurgeryNote> list = surgeryNoteRepository.findAllByPatientIdIn(otherPatientIds);
        EciSurgeryNote surgeryNote2 = null;
        if (list != null && !(list.isEmpty())) {
            EciSurgeryNote appended2Target=null;
            for (EciSurgeryNote eciSurgeryNote : list) {
                EiInhospitalNote inhospitalNote = this.getCurrentInhospitalNote(inhospitalNotes, eciSurgeryNote);
                if(inhospitalNote==null){
                    continue;
                }
            //list.forEach(eciSurgeryNote -> {
                //先追加
                appended2Target = new EciSurgeryNote();
                BeanUtils.copyProperties(eciSurgeryNote, appended2Target, "surgeryId", "patientId");
                appended2Target.setPatientId(goalPatientId);
                appended2Target.setMergeFlag(1);
                appended2Target.setSurgeryId(GeneralUtil.generateUniqueID("ESUR")+GeneralUtil.generatorUUID());
                appended2Target.setMergeTime(TimeUtils.getCurrentTimestamp());
                appended2Target.setMergeFrom(eciSurgeryNote.getPatientId());
                appended2Target.setMergeTarget(goalPatientId);

                appended2Target.setOldInhospitalTimes(eciSurgeryNote.getInhospitalTimes());
                appended2Target.setOldPatientNo(eciSurgeryNote.getPatientNo());

                //List<EiInhospitalNote> inhospitalNotes =
                //        inhospitalNoteRepository.findFirstByOldPatientNoAndOldInhospitalTimesAndMergeFromAndMergeFlag(eciSurgeryNote.getOldPatientNo(), eciSurgeryNote.getOldInhospitalTimes(),eciSurgeryNote.getPatientId(),1);

                if (!inhospitalNotes.isEmpty()) {
                    //EiInhospitalNote inhospitalNote = inhospitalNotes.get(0);
                    appended2Target.setInhospitalTimes(inhospitalNote.getInhospitalTimes());
                    appended2Target.setInhospitalId(inhospitalNote.getInhospitalId());
                    appended2Target.setPatientNo(inhospitalNote.getPatientNo());
                    appended2Target.setSurgeryId(GeneralUtil.generateUniqueID("ESUR")+GeneralUtil.generatorUUID());
                    appended2Target.setPatientId(inhospitalNote.getPatientId());
                    appended2Target.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());
                    surgeryNoteRepository.save(appended2Target);
                }


                //再标记
                eciSurgeryNote.setMergeFlag(2);
                eciSurgeryNote.setMergeFrom(eciSurgeryNote.getPatientId());
                eciSurgeryNote.setMergeTarget(goalPatientId);
                eciSurgeryNote.setMergeTime(TimeUtils.getCurrentTimestamp());
                surgeryNoteRepository.save(eciSurgeryNote);
            }
        }


    }

    private EiInhospitalNote getCurrentInhospitalNote(List<EiInhospitalNote> inhospitalNotes, EciSurgeryNote surgeryNote) {
        EiInhospitalNote inhospitalNote=null;
        for (EiInhospitalNote o : inhospitalNotes){
            if(o.getOldInhospitalId()!=null&&o.getOldInhospitalId().equals(surgeryNote.getInhospitalId())){
                inhospitalNote=o;
            }
        }
        return inhospitalNote;

    }

    @Override
    public void revokeMergeSurgeryNote(Long patientId) {
        surgeryNoteRepository.deleteByMergeTargetAndMergeFlag(patientId, 1);
        surgeryNoteRepository.updateMergeFlag(patientId, 2);
    }
}

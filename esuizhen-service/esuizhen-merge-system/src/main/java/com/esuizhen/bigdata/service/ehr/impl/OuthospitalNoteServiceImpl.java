package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.domain.ehr.EiInhospitalNote;
import com.esuizhen.bigdata.domain.ehr.EiOuthospitalNote;
import com.esuizhen.bigdata.repository.ehr.InhospitalNoteRepository;
import com.esuizhen.bigdata.repository.ehr.OuthospitalNoteRepository;
import com.esuizhen.bigdata.service.ehr.OuthospitalNoteService;
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
 * Created by Nidan on 2017年01月04 下午 20:29
 */
@Service
@Transactional
public class OuthospitalNoteServiceImpl implements OuthospitalNoteService {
    public static final Logger LOGGER = LoggerFactory.getLogger(PatientMergeServiceImpl.class);
    @Autowired
    private OuthospitalNoteRepository outhospitalNoteRepository;
    @Autowired
    private InhospitalNoteRepository inhospitalNoteRepository;

    @Override
    public void mergeOuthospitalNote(Long goalPatientId, List<Long> otherPatientIds,List<EiInhospitalNote> inhospitalNotes) {
        LOGGER.info("==> 开始合并出院信息");
        List<EiOuthospitalNote> list = outhospitalNoteRepository.findAllByPatientIdIn(otherPatientIds);
        EiOuthospitalNote outhospitalNote2 = null;
        if (list != null && !(list.isEmpty())) {
            for (EiOuthospitalNote outhospitalNote : list) {
                EiInhospitalNote inhospitalNote=this.getCurrentInhospitalNote(inhospitalNotes,outhospitalNote);
                if(inhospitalNote==null){
                    continue;
                }
                outhospitalNote.setMergeFlag(2);
                outhospitalNote.setMergeTarget(goalPatientId);
                outhospitalNote.setMergeFrom(outhospitalNote.getPatientId());
                outhospitalNote.setMergeTime(new Timestamp(System.currentTimeMillis()));
                outhospitalNoteRepository.save(outhospitalNote);

                outhospitalNote2 = new EiOuthospitalNote();
                BeanUtils.copyProperties(outhospitalNote, outhospitalNote2);
                outhospitalNote2.setMergeFrom(outhospitalNote.getPatientId());
                outhospitalNote2.setMergeTarget(goalPatientId);
                outhospitalNote2.setMergeFlag(1);

                //EiInhospitalNote inhospitalNote = inhospitalNoteRepository.findByOldInhospitalIdAndMergeFlag(outhospitalNote.getInhospitalId(),1);
                outhospitalNote2.setPatientId(inhospitalNote.getPatientId());
                outhospitalNote2.setOldInhospitalTimes(outhospitalNote.getInhospitalTimes());
                outhospitalNote2.setOldPatientNo(outhospitalNote.getPatientNo());
                outhospitalNote2.setPatientNo(inhospitalNote.getPatientNo());
                outhospitalNote2.setPatientId(goalPatientId);
                outhospitalNote2.setInhospitalTimes(inhospitalNote.getInhospitalTimes());
                outhospitalNote2.setInhospitalId(inhospitalNote.getInhospitalId());
                outhospitalNote2.setOuthospitalId(GeneralUtil.generateUniqueID("EION")+GeneralUtil.generatorUUID());
                outhospitalNote2.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());
                outhospitalNoteRepository.save(outhospitalNote2);
            }
            LOGGER.info("==> 将{}条出院记录追加到目标患者{}上", list.size(), goalPatientId);
        }

    }

    private EiInhospitalNote getCurrentInhospitalNote(List<EiInhospitalNote> inhospitalNotes, EiOuthospitalNote outhospitalNote) {
        EiInhospitalNote inhospitalNote=null;
        for (EiInhospitalNote o : inhospitalNotes){
            if(o.getOldInhospitalId()!=null&&o.getOldInhospitalId().equals(outhospitalNote.getInhospitalId())){
                inhospitalNote=o;
            }
        }
        return inhospitalNote;
    }

    @Override
    public void revokeMergeOuthospitalNote(Long patientId) {
        outhospitalNoteRepository.deleteByMergeTargetAndMergeFlag(patientId, 1);
        outhospitalNoteRepository.updateMergeFlag(patientId, 0);
    }
}

package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.domain.ehr.EciExamReport;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.repository.ehr.ExamReportRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.ehr.ExamReportService;
import com.westangel.common.util.GeneralUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 21:12
 */
@Service
@Transactional
public class ExamReportServiceImpl implements ExamReportService {

    @Autowired
    private ExamReportRepository examReportRepository;
    @Autowired
    private UPatientRepository patientRepository;

    @Override
    public void mergeExamReport(Long goalPatientId, List<Long> otherPatientIds) {
        List<EciExamReport> list=examReportRepository.findAllByPatientIdIn(otherPatientIds);
        EciExamReport examReport2=null;
        for (EciExamReport examReport : list) {
            examReport.setMergeFlag(2);
            examReport.setMergeTarget(goalPatientId);
            examReport.setMergeFrom(examReport.getPatientId());
            examReport.setMergeTime(new Timestamp(System.currentTimeMillis()));
            examReportRepository.save(examReport);

            examReport2=new EciExamReport();
            BeanUtils.copyProperties(examReport,examReport2);
            UPatient patient=patientRepository.findByPatientId(goalPatientId);

            examReport2.setMergeFrom(examReport.getPatientId());
            examReport2.setMergeTarget(goalPatientId);
            examReport2.setMergeFlag(1);
            examReport2.setPatientNo(patient.getPatientNo());
            examReport2.setPatientId(patient.getPatientId());
            examReport2.setPatientUuid(patient.getUuid());
            examReport2.setExamReportId(GeneralUtil.generateUniqueID("EPACS")+GeneralUtil.generatorUUID());
            examReport2.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());
            examReportRepository.save(examReport2);
        }

    }

    @Override
    public void revokeMergeExamReport(Long patientId) {
        examReportRepository.deleteByMergeTargetAndMergeFlag(patientId,1);
        examReportRepository.updateMergeFlag(patientId,2);
    }
}

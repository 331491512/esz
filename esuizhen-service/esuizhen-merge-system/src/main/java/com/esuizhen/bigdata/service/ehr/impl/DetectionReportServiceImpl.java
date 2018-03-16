package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.domain.ehr.EciDetectionReport;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.repository.ehr.DetectionReportRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.ehr.DetectionDetailService;
import com.esuizhen.bigdata.service.ehr.DetectionReportService;
import com.westangel.common.util.GeneralUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 20:53
 */
@Service
@Transactional
public class DetectionReportServiceImpl implements DetectionReportService {

    @Autowired
    private DetectionReportRepository detectionReportRepository;
    @Autowired
    private UPatientRepository patientRepository;
    @Autowired
    private DetectionDetailService detectionDetailService;

    @Override
    public void mergeDetectionReport(Long goalPatientId, List<Long> otherPatientIds) {
        List<EciDetectionReport> list=detectionReportRepository.findAllByPatientIdIn(otherPatientIds);
        EciDetectionReport detectionReport2=null;
        for (EciDetectionReport detectionReport : list) {
            detectionReport.setMergeTime(new Timestamp(System.currentTimeMillis()));
            detectionReport.setMergeFlag(2);
            detectionReport.setMergeTarget(goalPatientId);
            detectionReport.setMergeFrom(detectionReport.getPatientId());
            detectionReportRepository.save(detectionReport);

            detectionReport2=new EciDetectionReport();
            BeanUtils.copyProperties(detectionReport,detectionReport2);

            UPatient patient=patientRepository.findByPatientId(goalPatientId);
            detectionReport2.setMergeFrom(detectionReport.getPatientId());
            detectionReport2.setMergeTarget(goalPatientId);
            detectionReport2.setMergeFlag(1);
            detectionReport2.setPatientId(patient.getPatientId());
            detectionReport2.setPatientUuid(patient.getUuid());
            detectionReport2.setPatientNo(patient.getPatientNo());
            detectionReport2.setDetectionReportId(GeneralUtil.generateUniqueID("ELIS")+GeneralUtil.generatorUUID());
            detectionReport2.setEmrId(GeneralUtil.generatorUUID("EMRI")+GeneralUtil.generatorUUID());
            detectionReportRepository.save(detectionReport2);

            //合并检验详细
            detectionDetailService.mergeDetectionDetailById(detectionReport2,detectionReport.getDetectionReportId());
        }
    }

    @Override
    public void revokeMergeDetectionReport(Long patientId) {
        detectionReportRepository.deleteByMergeTargetAndMergeFlag(patientId,1);
        detectionReportRepository.updateMergeFlag(patientId,2);
    }
}

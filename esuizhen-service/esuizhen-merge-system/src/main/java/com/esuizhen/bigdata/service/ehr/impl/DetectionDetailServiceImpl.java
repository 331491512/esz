package com.esuizhen.bigdata.service.ehr.impl;

import com.esuizhen.bigdata.domain.ehr.EciDetectionDetail;
import com.esuizhen.bigdata.domain.ehr.EciDetectionReport;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.repository.ehr.DetectionDetailRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.ehr.DetectionDetailService;
import com.westangel.common.util.GeneralUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nidan on 2017年01月04 下午 21:04
 */
@Service
@Transactional
public class DetectionDetailServiceImpl implements DetectionDetailService {

    @Autowired
    private DetectionDetailRepository detectionDetailRepository;

    @Autowired
    private UPatientRepository patientRepository;

    @Override
    public void mergeDetectionDetail(Long goalPatientId, List<Long> otherPatientIds) {

        List<EciDetectionDetail> list=detectionDetailRepository.findAllByPatientIdIn(otherPatientIds);
        EciDetectionDetail detectionDetail2=null;
        for (EciDetectionDetail detectionDetail : list) {

            detectionDetail.setMergeFlag(2);
            detectionDetail.setMergeTime(new Timestamp(System.currentTimeMillis()));
            detectionDetailRepository.save(detectionDetail);

            detectionDetail2=new EciDetectionDetail();
            BeanUtils.copyProperties(detectionDetail,detectionDetail2);

            UPatient patient=patientRepository.findByPatientId(goalPatientId);

            detectionDetail2.setMergeFrom(detectionDetail.getPatientId());
            detectionDetail2.setMergeTarget(goalPatientId);
            detectionDetail2.setPatientId(goalPatientId);
            detectionDetail2.setPatientNo(patient.getPatientNo());
            detectionDetail2.setPatientUuid(patient.getUuid());
            detectionDetailRepository.save(detectionDetail2);
        }

    }

    @Override
    public void revokeMergeDetectionDetail(Long patientId) {

        detectionDetailRepository.deleteByMergeTargetAndMergeFlag(patientId,1);

        detectionDetailRepository.updateMergeFlag(patientId,2);

    }

    @Override
    public void mergeDetectionDetailById(EciDetectionReport detectionReport2, String detectionReportId) {
        List<EciDetectionDetail> list=detectionDetailRepository.findAllByDetectionReportId(detectionReportId);
        EciDetectionDetail detectionDetail2=null;
        for (EciDetectionDetail detectionDetail : list) {

            detectionDetail.setMergeFlag(2);
            detectionDetail.setMergeTarget(detectionReport2.getMergeTarget());
            detectionDetail.setMergeFrom(detectionDetail.getPatientId());
            detectionDetail.setMergeTime(new Timestamp(System.currentTimeMillis()));
            detectionDetailRepository.save(detectionDetail);

            detectionDetail2=new EciDetectionDetail();
            BeanUtils.copyProperties(detectionDetail,detectionDetail2);

            detectionDetail2.setDetectionReportId(detectionReport2.getDetectionReportId());
            detectionDetail2.setMergeFrom(detectionDetail.getPatientId());
            detectionDetail2.setMergeTarget(detectionReport2.getMergeTarget());
            detectionDetail2.setMergeFlag(1);
            detectionDetail2.setPatientId(detectionReport2.getPatientId());
            detectionDetail2.setPatientNo(detectionReport2.getPatientNo());
            detectionDetail2.setPatientUuid(detectionReport2.getPatientUuid());
            detectionDetail2.setDetectionDetailId(GeneralUtil.generateUniqueID("EITE")+GeneralUtil.generatorUUID());
            detectionDetailRepository.save(detectionDetail2);
        }

    }
}

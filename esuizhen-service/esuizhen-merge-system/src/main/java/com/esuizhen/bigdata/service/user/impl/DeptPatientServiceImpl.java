package com.esuizhen.bigdata.service.user.impl;

import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.user.RDeptPatient;
import com.esuizhen.bigdata.repository.user.DeptPatientRepository;
import com.esuizhen.bigdata.service.user.DeptPatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nidan on 2017年07月25 上午 10:35
 */
@Service
public class DeptPatientServiceImpl implements DeptPatientService {

    @Autowired
    private DeptPatientRepository deptPatientRepository;

    @Override
    public void mergeDeptPatient(Long goalPatientId, List<Long> otherPatientIds) {
        List<RDeptPatient> targetDept=deptPatientRepository.findByPatientId(goalPatientId);
        List<RDeptPatient> fromDept=deptPatientRepository.findByPatientIdIn(otherPatientIds);
        for (RDeptPatient deptPatient : fromDept){
            if(!checkDeptPatient(deptPatient,targetDept)){
                RDeptPatient newDept= new RDeptPatient();
                BeanUtils.copyProperties(deptPatient,newDept,"id");
                newDept.setMergeFlag(1);
                newDept.setMergeFrom(deptPatient.getPatientId());
                newDept.setMergeTarget(goalPatientId);
                newDept.setMergeTime(TimeUtils.getCurrentTimestamp());
                newDept.setPatientId(goalPatientId);
                newDept.setRecordTime(TimeUtils.getCurrentTimestamp());
                deptPatientRepository.save(newDept);
            }
            deptPatient.setMergeTime(TimeUtils.getCurrentTimestamp());
            deptPatient.setMergeFlag(2);
            deptPatient.setMergeFrom(deptPatient.getPatientId());
            deptPatient.setMergeTarget(goalPatientId);
            deptPatientRepository.save(deptPatient);
        }

    }

    private boolean checkDeptPatient(RDeptPatient deptPatient, List<RDeptPatient> targetDept){
        boolean result=false;
        for (RDeptPatient deptP : targetDept){
            if(deptPatient.getHospitalId().equals(deptP.getHospitalId())&&
                    deptPatient.getDeptId().equals(deptP.getDeptId())){
                result=true;
                break;
            }
        }
        return result;
    }

    @Override
    public void revokeMergeDeptPatient(Long patientId) {
        deptPatientRepository.deleteByMergeTargetAndMergeFlag(patientId,1);
        deptPatientRepository.updateMergeFlag(patientId,2);
    }
}

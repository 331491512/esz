package com.esuizhen.bigdata.service.user.impl;

import com.esuizhen.bigdata.domain.user.UPatientFamily;
import com.esuizhen.bigdata.repository.user.UPatientFamilyRepository;
import com.esuizhen.bigdata.service.user.PatientFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 17/1/8.
 */
@Service
@Transactional
public class PatientFamilyServiceImpl implements PatientFamilyService {
    @Autowired
    private UPatientFamilyRepository uPatientFamilyRepository;

    @Override
    public List<UPatientFamily> findPatientFamiliesAfterLostFollowupTime(List<Long> mergeGroupId, Timestamp lostFollowupTime) {
        List<UPatientFamily> patientFamilies = uPatientFamilyRepository.findByPatientIdInAndCreateTimeGreaterThan(mergeGroupId, lostFollowupTime);
       /* List<UPatientFamily> tempList = patientFamilies;
        patientFamilies.forEach(uPatientFamily -> {
            if (uPatientFamily.getFamilyPhone().isEmpty()) {
                //patientFamilies.remove(uPatientFamily);
                tempList.remove(uPatientFamily);
            }
        });
        patientFamilies = tempList;*/

        List<UPatientFamily> tempList = new ArrayList<>();
        for (UPatientFamily uPatientFamily: patientFamilies){
        //patientFamilies.forEach(uPatientFamily -> {
            if (uPatientFamily.getFamilyPhone().isEmpty()) {
                //patientFamilies.remove(uPatientFamily);
                tempList.add(uPatientFamily);
            }
        }
        patientFamilies.removeAll(tempList);
        return patientFamilies;
    }
}

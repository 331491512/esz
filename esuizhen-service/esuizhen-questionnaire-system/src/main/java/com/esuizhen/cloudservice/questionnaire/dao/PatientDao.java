package com.esuizhen.cloudservice.questionnaire.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.Patient;

public interface PatientDao {
    public Patient findByPatientId(Long patientId);
    
    Map<String,Object> getValidContactMobile(Long patientId);
    
    public Patient findByUuid(String uuid);
    
    LinkedHashMap<String,Object> queryPatientInfoByOpenId(@Param("openId") String openId);
    
    LinkedHashMap<String,Object> queryHospitalInfoByHospitalId(@Param("hospitalId") Integer hospitalId);
}
package com.esuizhen.cloudservice.ehr.dao.patientinfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.PatientWideTable;
import com.westangel.common.bean.user.PatientFamily;

public interface PatientWideTableDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientWideTable record);

    int insertSelective(PatientWideTable record);
    
    void insertByPatientId(@Param("patientId") Long patientId);
    
    PatientWideTable selectPatientWideTableByPatientId(@Param("patientId") Long patientId);
    
    List<PatientFamily> selectFamilyRelationByPatientId(@Param("patientId") Long patientId);
    
    PatientWideTable selectByPatientId(@Param("patientId") Long patientId);

    int updateByPrimaryKeySelective(PatientWideTable record);

    int updateByPrimaryKey(PatientWideTable record);
    
    void increflushSeq(Map<String,Object> paramsMap);
}
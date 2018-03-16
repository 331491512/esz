package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.ehr.DiagnosisInfo;

/**
 * <p>Title:DiagnosisInfoDao</p>
 * <p>Description:患者诊断信息数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年6月7日 下午6:27:55
 */
public interface DiagnosisInfoDao {
	public int update(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
	
	public List<DiagnosisInfo> findByPatientId(@Param("patientId")Long patientId, @Param("isSourceDiagnosis")Integer isSourceDiagnosis);
	
	public DiagnosisInfo findByDiagnosisCode(String diagnosisCode);
}

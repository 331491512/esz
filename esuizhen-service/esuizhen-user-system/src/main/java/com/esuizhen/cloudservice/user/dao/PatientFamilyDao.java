package com.esuizhen.cloudservice.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.AutiCancerLinkManContact;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseReq;
import com.westangel.common.bean.user.PatientFamily;

/**
 * 
 * @author YYCHEN
 *
 */
public interface PatientFamilyDao {

	public long insert(PatientFamily patientFamily);
	
	public int update(PatientFamily patientFamily);
	public int updatePatientFamily(PatientFamily patientFamily);
	public List<PatientFamily> find(@Param("patientId")Long patientId, @Param("mobile")String mobile);

	public int deleteByPatientId(@Param("patientId")Long patientId);

	public int updateToBPatientFamilyToCloudRelation(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
	
	List<PatientFamily> findByPatientId(@Param("patientId")Long patientId);
	
	//*****************************Start By fanpanwei**************************
	public void updateLinkManInfo(AutiCancerLinkManContact linkMan);
	public void insertLinkManInfo(AutiCancerLinkManContact linkMan);
	public void deleteLinkManInfo(@Param("patientId")Long patientId,@Param("specialDiseaseRegisterId")Long specialDiseaseRegisterId);
	public List<AutiCancerLinkManContact> findLinkMan(SpecialDiseaseReq req);
	
	//*****************************End By fanpanwei**************************
	
	public int delByPatientIdAndId(HashMap<String, Object> hm);
	
	// start add by zhuguo
	public PatientFamily findPatientInfoById(PatientFamily pf);
	public int updatePatientFamilyPhoneStatus(PatientFamily pf);
	// end add by zhuguo
	
}
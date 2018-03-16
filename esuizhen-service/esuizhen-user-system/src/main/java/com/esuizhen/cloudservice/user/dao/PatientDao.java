package com.esuizhen.cloudservice.user.dao;

import com.esuizhen.cloudservice.user.bean.*;
import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.model.TPatientNoInfo;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.SourceDiagnosisInfo;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.bean.user.TTobeconfirmedPatient;

import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author YYCHEN
 *
 */
public interface PatientDao {
	
	//将ToB导入的患者信息，包括病历和随访信息合并到云端患者信息里
	void mergeTobPatientInfoToFormalPatientInfo(Map<String, Number> params);
	//将线上患者的随访任务删除
	void cleanCloudPatientFollowupPlan(@Param("cloudPatientId")Long cloudPatientId);
    public long insert(Patient record);

    public int updateByPrimaryKey(Patient record);
	
    public Patient findByUserId(Long userId);
	
    public Patient findById(Long patientId);
    
    public List<PatientSimpleInfo> searchPatientSimpleInfoList(Object obj);
    
    public Patient searchPatientByMobile(@Param("mobile") String mobile);
    
    public List<PatientSimpleInfo> searchPatientBykeyword(PatientKeywordSearchReq patientKeywordSearchReq);
    
    public PatientSimpleInfo selectPatientSimpleInfo(@Param("id") Long id, @Param("tag") String tag, @Param("doctorId") Long doctorId);
    
    public PatientProfile selectPatientProfileByPatientId(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId);
    
    public PatientProfile selectPatientProfileByUserId(@Param("userId") Long userId, @Param("doctorId") Long doctorId);
    
    public int deletePatientByUserId(@Param("userId") Long userId);
    
    public List<SourceDiagnosisInfo> findSourceDiagnosisInfoes(Long patientId);
	
	public Long findIdByUserId(@Param("userId") Long userId);

	public Integer findQuestionnaireAnswerNum(@Param("userId") Long userId);
	
	public int updateHasVisibleMedicalRecord(Patient patient);

	public Long getUserIdByPatientId(Long patientId);

	public String findPatientEmrId(@Param("patientId")Long patientId);
	
	public int findFollowupByPatientId(@Param("patientId")Long patientId);
	
	public int findPatientMedicalRecordCount(@Param("patientId")Long patientId, @Param("doctorId")Long doctorId);
	/**
	 * 
	* @Title: selectToconfirmedPateint 
	* @Description: 获取待确认患者信息 
	* @param @param userId
	* @param @return    设定文件 
	* @return TTobeconfirmedPatient    返回类型 
	* @throws
	 */
	public TTobeconfirmedPatient selectToconfirmedPateint(@Param("userId") Long userId);

	public int existPatient(Long patientId);

	public int findByIdentificationCount(@Param("idType")Integer idType, @Param("identification")String identification, @Param("auditState") Integer auditState);

	public Patient findToBPatientByIdentification(@Param("idType")Integer idType, @Param("identification")String identification);
	
	//获取患者来源信息
	public LinkedHashMap<String, Object> queryPatientSource(Object param);

    //****************Start by fanpanwei************************
    public List<AutiPatientListResp> getAutiPatientList(AutiPatientReq autiPatientReq);
	
    public int getAutiPatientTotal(AutiPatientReq autiPatientReq);

	/**
	 * 查询疑似患者
	 * @param goalpatientid
	 * @return
	 */
	List<PatientProfile> findOtherSimplePatient(Long goalpatientid);

	/**
	 * 查询合并患者
	 * @param patientId
	 * @return
	 */
	List<PatientProfile> findOtherMergePatient(Long patientId);
    
    public AutiCancerPatientInfo getAutiPatientInfo(SpecialDiseaseReq req);
    
    public void updateAutiPatientInfo(AutiCancerPatientInfo autiCancerPatientInfo);
    public long insertAutiPatientInfo(AutiCancerPatientInfo autiCancerPatientInfo);
    public int getSpecialDiseaseTotal(SpecialDiseaseReq specialDiseaseReq);
    public List<SpecialDiseaseResp> getSpecialDiseaseList(SpecialDiseaseReq specialDiseaseReq);
	
    public List<AutiCancerTreatmentsInfo> getTreatmentMethods(AutiCancerTreatmentsInfo treatmentsInfo);
    /**
     * 是否存在身份证号码
     * @return
     */
    Long isExistsIdentification(SpecialDiseaseReq req);
    //*****************end by fanpanwei**************************************

	void updateUserByPatientId(UserInfo user);

	Integer findPatientHospital(@Param("patientId")Long patientId, @Param("hospitalId")Integer hospitalId);

	void insertPatientHospital(@Param("user")UserInfo user,@Param("hospitalId")Integer hospitalId);

	void updatePatientNo(@Param("user")UserInfo user,@Param("hospitalId")Integer hospitalId);
	/**
	 * 
	 * @author lichenghao
	 * @title :queryPatientNoList
	 * @Description:患者病案号查询
	 * @return List<TPatientNoInfo>
	 * @date 2017年1月6日 上午11:48:51
	 */
	List<TPatientNoInfo> queryPatientNoList(Object req);

    Patient findPatientByPatientIdAndhospitalId(@Param("patientId") Long patientId, @Param("hospitalId") Integer hospitalId);
	List<TagInfo> getPatientTags(Long patientId);

    List<String> findPatientFamilyPhone(@Param("patientId") Long patientId, @Param("sourceFlag") Integer sourceFlag);

	List<String> findSyncMatchPatientFamilyPhone(@Param("patientUuid") String patientUuid, @Param("sourceFlag") Integer sourceFlag);
	/**
	 * 
	* @author fanpanwei
	* @date 2017年3月30日
	* @param 
	* @description:根据医生id获取患者基础数据统计信息
	* @return
	 */
	PatientBaseDataStatistics getPatientBaseDataBydoctorId(TPatientSearchInfo req);
	/**
	 * 
	* @author fanpanwei
	* @date 2017年3月30日
	* @param 
	* @description:根据医生id获取患者随访数据统计信息
	* @return
	 */
	PatientBaseDataStatistics getFollowupStatisticsBydoctorId(TPatientSearchInfo req);
	/**
	* @author fanpanwei
	* @date 2017年3月31日
	* @param 
	* @description
	* @return
	 */
	List<Integer> getInvitePatientByMsg(@Param("doctorId") Long doctorId);
	
	List<Integer> getInvitePatientByWechat(@Param("doctorId") Long doctorId);

    Integer getPatientCertificateFlag(Long patientId);
}
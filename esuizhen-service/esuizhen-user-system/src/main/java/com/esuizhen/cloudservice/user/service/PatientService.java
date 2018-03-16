/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:00:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import com.esuizhen.cloudservice.user.bean.*;
import com.esuizhen.cloudservice.user.model.TPatientNoInfo;
import com.westangel.common.bean.*;
import com.westangel.common.excption.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/** 
* @ClassName: PatientService 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月3日 下午6:00:58  
*/
public interface PatientService {
	/**
	 * 
	* @Title: serarchPatient 
	* @Description: 根据用户编号查询患者信息
	* @param 
	* @return Patient
	* @throws
	 */
	public Patient serarchPatient(Long userId);

	/**
	* 
	* @Title: savePatient 
	* @Description: 保存患者信息
	* @param 
	* @return int
	* @throws
	*/
	public boolean savePatient(Patient patient);

	/**
	* @Title: searchPatientById 
	* @Description: 根据患者编号查询患者详细信息
	* @param patientId 患者编号
	* @return Patient
	* @throws
	*/
	public PatientProfileDetailResp searchPatientById(PatientProfileDetailReq req);
    /**
     * @throws EmptyParamExcption 
     * 
    * @Title: searchPatientSimpleInfo 
    * @Description: 分页查询患者信息列表
    * @param 
    * @return List<PatientSimpleInfo>
    * @throws
     */
	public Page<PatientSimpleInfo> searchPatientSimpleInfoList(Long doctorId, String patientName, Integer reqFlag, Integer page, Integer num) throws EmptyParamExcption;

	/**
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParamFormatErrorExcption 
	 * 
	* @Title: createPatientByMobile 
	* @Description: 通过手机号号创建患者
	* @param 
	* @return void
	* @throws
	 */
	public Object createPatientByMobile(PatientCreateByMobileReq patientCreateByMobileReq) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption;
	/**
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParamFormatErrorExcption 
	 * 
	* @Title: createPatientByMedicalRecord 
	* @Description: 通过病历创建患者
	* @param 
	* @return void
	* @throws
	 */
	public boolean createPatientByMedicalRecord(MedicalRecordPatientCreateReq medicalRecordPatientCreateReq) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption;
	
	/**
	 * 模糊查询某个医生的病人
	 * @param patientKeywordSearchReq
	 * @return
	 */
	public List<PatientSimpleInfo> searchPatientBykeyword(PatientKeywordSearchReq patientKeywordSearchReq);

    
    /**
     * 解除医患关系
     * @param locale
     * @param doctorId
     * @param patientId
     * @param source
     * @return
     * @throws ParamFormatErrorExcption 
     * @throws EmptyObjectExcption 
     * @throws EmptyParamExcption 
     * @throws RejectRequestExcption 
     * @throws ParamMismatchExcption 
     */
    public boolean releasePatientOfDoctor(Long doctorId, Long patientId, Integer source) throws EmptyParamExcption, ParamFormatErrorExcption, RejectRequestExcption, ParamMismatchExcption;

    /**
     * 创建医患关系
     * @param locale
     * @param doctorId
     * @param patientId
     * @param sourceFlag
     * @return
     * @throws ParamFormatErrorExcption 
     * @throws EmptyParamExcption 
     * @throws ObjectNotAvailableExcption 
     * @throws ObjectAlreadyExistExcption
     */
	public boolean createPatientOfDoctorRelation(Long doctorId, Long patientId, Integer sourceFlag) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption;

	/**
	 * 
	 * @param id
	 * @param tag
	 * @param doctorId
	 * @return
	 * @throws EmptyParamExcption 
	 */
	public PatientSimpleInfo getPatientSimpleInfoById(Long id, String tag, Long doctorId) throws EmptyParamExcption;
	
	public boolean delHasVisibleMedicalRecord(Integer visibleFlag, Integer sourceFlag, Long doctorId, Long patientId) throws EmptyParamExcption, EmptyObjectExcption;
	
	/**
	 * 建立医院、患者关系
	 * @param hospitalId
	 * @param patientId
	 * @param sourceFlag
	 * @return
	 * @throws EmptyParamExcption
	 * @throws ParamFormatErrorExcption
	 * @throws ObjectNotAvailableExcption
	 */
	public boolean createPatientOfHospitalRelation(Integer hospitalId, Long patientId, Integer sourceFlag) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption;
	
	/**
	 * <p>Title:modifyPatientProfile</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月13日 下午6:04:04
	 * @param userProfileModifyReq
	 * @param user
	 * @param patient
	 * @return
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 * @throws ParamMismatchExcption
	 * @throws RemoteCallExcption
	 * @throws RejectRequestExcption
	 */
	public LoginByThirdPartyResp modifyPatientProfile(UserProfileModifyReq userProfileModifyReq, User user, Patient patient) throws EmptyParamExcption, EmptyObjectExcption, ParamMismatchExcption, RemoteCallExcption, RejectRequestExcption;
	
	/**
	 * <p>Title:certificatePatient</p>
	 * <p>Description:患者实名认证审核</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午4:00:09
	 * @param patientSimpleInfo
	 * @return
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 * @throws RejectRequestExcption
	 */
	public boolean certificatePatient(PatientSimpleInfo patientSimpleInfo) throws EmptyParamExcption, EmptyObjectExcption, RejectRequestExcption;

	/**
	 * 
	 * @param patientSimpleInfo
	 * @return 
	 * @throws EmptyParamExcption, EmptyObjectExcption,VerifyFailureExcption 
	 */
	public Object certificateHospitalPatient(PatientHospitalCertificateReq patientSimpleInfo) throws EmptyParamExcption, EmptyObjectExcption,VerifyFailureExcption;
	
	public void createFollowupPlan(Patient patient, Long doctorId, String doctorName, Integer wxProductId);
	
	public Patient supplementaryFollowupPlan(Patient patient, int productId);
	
	/**
	 * <p>Title:certificateFollowupPlan</p>
	 * <p>Description:患者审核通过调用，为患者开启随访计划</p>
	 * @author YYCHEN
	 * @date 2016年6月15日 下午4:09:04
	 * @param patientId
	 */
	public void certificateFollowupPlan(Long patientId);
	
	/**
	 * <p>Title:registerPatient</p>
	 * <p>Description:通过用户信息新建患者</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 下午4:16:07
	 * @param user
	 * @return
	 */
	public Patient registerPatient(User user);
	
	//******************************Start By fanpanwei**************************
	
	/**
	* @author fanpanwei
	* @date 2016年9月22日
	* @param 
	* @description
	* @return
	 */
	public Page<AutiPatientListResp> searchAutiPatientList(AutiPatientReq autiPatientReq);

	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 获取防癌患者总数
	* @return
	 */
	public int getAutiPatientTotal();

	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 根据患者Id获取患者详细信息
	* @return
	 */
	public AutiCancerPatientInfo getAutiPatientInfoById(SpecialDiseaseReq req);
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description  保存患者基本信息
	* @return
	 */
	public Map<String,Object> saveAntiCancerPatientInfo(AutiCancerPatientInfo autiCancerPatientInfo);
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description 获取审批信息
	* @return
	 */
	public AutiPatientApproveInfo getAutiPatientApproveInfoById(SpecialDiseaseReq req);
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description  保存防癌患者审批信息
	* @return
	 */
	public void saveAntiPatientApproveInfo(AutiPatientApproveInfo autiPatientApproveInfo);
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description 获取特病列表
	* @return
	 */
	public Page<SpecialDiseaseResp> getSpecialDiseaseRecord(SpecialDiseaseReq specialDiseaseReq); 
	public String exportAutiPatientList(AutiPatientReq  autiPatientReq,String outFilePath);
	public String exportSpecialDiseaseRecord(SpecialDiseaseReq specialDiseaseReq,String outFilePath);
	
	public List<AutiCancerTreatmentsInfo> queryTreatmentMethods(AutiCancerTreatmentsInfo treatmentsInfo);

	/**
     * 是否存在身份证号码
     * @return
     */
	int isExistsIdentification(SpecialDiseaseReq req);

	//***********************End By fanpanwei****************************

	/**
	 * upload patient ID Card file 
	 * @author Nidan
	 * @title:uploadPatientIDFileUrl
	 * @Description:
	 * @return void
	 * @date 2016年10月19日上午9:42:56
	 */
	public void uploadPatientIDFileUrl(UserInfo user);
	public int searchPatientByMobile(AutiCancerPatientInfo autiCancerPatientInfo);
	
	public void updatePatientNo(UserInfo user);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryPatientnoList
	 * @Description:查询患者病案号
	 * @return List<TPatientNoInfo>
	 * @date 2017年1月6日 上午11:42:37
	 */
	public List<TPatientNoInfo> getPatientNoList(PatientNoListReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :mergerPatient
	 * @Description:云端患者数据合并
	 * @return void
	 * @date 2017年1月9日 下午6:42:00
	 */
	public void mergerPatient(User cloudUser,User tobUser,Patient cloudPatient,Patient tobPatient);
	
	
	
	public void confirmHospitalPatientCertificated(PatientHospitalCertificateConfirmReq req);

	/**
	 * 认证失败消息
	 * @param state
	 * @return
	 */
	public String getMessgaeByCertificateHospitalResult(Integer state);

	/**
	 * 患者医院手机号获取
	 * @param patientSimpleInfo
	 * @return
	 */
	Map<String,Object> findPatientHospitalPhone(PatientHospitalCertificateReq patientSimpleInfo);
	/**
	 * 
	* @author fanpanwei
	* @date 2017年3月30日
	* @param 
	* @description:获取指定医生下所有患者基本数据统计信息
	* @return
	 */
	PatientBaseDataStatistics getPatientBaseDataBydoctorId(Long doctorId)throws Exception ;

	/**
	 * 获取患者认证标识
	 * @param patientId
	 * @return
	 */
	Map<String,Object> getPatientCertificateFlag(Long patientId);
}


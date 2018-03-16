/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:00:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.service;

import com.westangel.common.bean.Patient;
import com.westangel.common.bean.PatientProfileDetailResp;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParamFormatErrorExcption;

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
	public PatientProfileDetailResp searchPatientById(Long patientId);
	
	/**
	 * 建立医患关系
	 * @param doctorId 医生ID
	 * @param patientId 患者ID
	 * @param sourceFlag 发起方 1:由患者关联；2:由医生关联；3:医院同步
	 * @return
	 */
	public boolean createPatientOfDoctorRelation(Long doctorId, Long patientId, Integer sourceFlag) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption;
	
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
	 * 上传病例更新患者信息
	 * @param visibleFlag 1 只患者可见;2 患者和上传医生可见;3 只上传医生可见;4 患者和所属医院可见;
	 * @param doctorId 医生ID
	 * @param patientId 患者ID
	 * @return 设置结果
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 */
	public boolean hasVisibleMedicalRecord(Integer visibleFlag, Integer sourceFlag, Long doctorId, Long patientId) throws EmptyParamExcption, EmptyObjectExcption;
	
	/**
	 * 删除病例更新患者信息
	 * @param source  1 患者删除； 2 医生删除
	 * @param doctorId
	 * @param patientId
	 * @return
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 */
	public boolean delHasVisibleMedicalRecord(Integer visibleFlag, Integer source, Long doctorId, Long patientId) throws EmptyParamExcption, EmptyObjectExcption;
	
	/**
	 * <p>Title:enableFollowupPlan</p>
	 * <p>Description:给患者开启随访计划</p>
	 * @author YYCHEN
	 * @date 2016年6月7日 下午6:14:46
	 * @param patient
	 * @return
	 */
	public boolean enableFollowupPlan(Patient patient);
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.dao<br/>  
 * <b>文件名：</b>DoctorPatientDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月14日-下午3:20:19<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;

import com.westangel.common.bean.DoctorPatient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 
* @ClassName: DoctorPatientDao 
* @Description: 患者医生关系表
* @author YYCHEN
* @date 2015年12月14日 下午3:20:19  
*/
public interface DoctorPatientDao {
	public long insert(DoctorPatient doctorpatient);

	/**
	 * 
	* @Title: searchDoctorPatient 
	* @Description: 根据患者编号和医生编号查询医患关系
	* @param 
	* @return DoctorPatient
	* @throws
	 */
	public DoctorPatient searchDoctorPatient(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId);
	
	public List<DoctorPatient> findByHospitalIdAndDoctorId(@Param("hospital") Long hospital, @Param("doctorId") Long doctorId);
	
	public int updateToBDoctorPatientToCloudRelation(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId, @Param("doctorPatients")List<DoctorPatient> doctorPatients);
	
	/**
	 * 
	* @Title: deleteDoctorPatient 
	* @Description: 根据患者编号或者医生编号进行删除 
	* @param 
	* @return int
	* @throws
	 */
	public int deleteByPrimaryKey(@Param("id") Long id);
	
	public int deleteByDcotorIdAndPatientId(@Param("doctorId") Long doctorId, @Param("patientId") Long patientId);
	
	/**
	 * 
	* @Title: deleteByPatientId 
	* @Description: 根据患者ID删除医患关系 
	* @param @param patientId
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int deleteByPatientId(@Param("patientId") Long patientId);
	
	/**
	 * <p>Title: deleteMedicalByPatientId</p>
	 * <p>Description: </p>
	 * @date 2016年4月26日 下午2:42:34
	 * @param patientId
	 * @return
	 */
	public int deleteMedicalByPatientId(@Param("patientId")Long patientId);
	/**
	 * 
	 * @param doctorId
	 * @param patientId
	 * @return
	 */
	public int deleteDoctorPatient(Long doctorId, Long patientId);

	public int updateHasMedicalRecord(DoctorPatient doctorPatient);
	
	/**
	 * <p>Title:screeningNotExsit</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午7:55:27
	 * @param cloudPatientId
	 * @param tobPatientId
	 * @return
	 */
	public List<DoctorPatient> screening(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);

	void updateDoctorPatient(DoctorPatient doctorPatient);
}

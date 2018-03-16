/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.dao<br/>  
 * <b>文件名：</b>PatientGroupMembers.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日-下午4:51:44<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.PatientGroupMemberReq;
import com.westangel.common.bean.PatientGroupMembers;
import com.westangel.common.bean.PatientSimpleInfo;

/** 
* @ClassName: PatientGroupMembers 
* @Description: TODO
* @author huangdongxing
* @date 2015年12月15日 下午4:51:44  
*/
public interface PatientGroupMembersDao {
	List<PatientGroupMembers> searchAutoPatientGroupMembers(@Param("doctorId") Long doctorId,@Param("groupId") Long groupId);
	
	List<PatientSimpleInfo> searchSimplePatientInfoList(Object param);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :deletePatientOfGroupMember
	 * @Description:删除患者所在分组
	 * @return int
	 * @date 2016年5月23日 下午12:17:36
	 * @param patientId doctorId
	 */
	int deletePatientOfGroupMember(Object param);
	
	/**
	 * 删除分组内的患者
	 * @author lichenghao
	 * @title :deletePatientGroupMember
	 * @Description:TODO
	 * @param groupNo patients
	 * @return int
	 * @date 2016年5月23日 下午12:18:33
	 */
	int deletePatientGroupMember(Object param);
	
	//创建患者组与患者关系
	void createPatientGroupMembers(@Param("groupNo")String groupNo, @Param("patientId")Long patientId);
}

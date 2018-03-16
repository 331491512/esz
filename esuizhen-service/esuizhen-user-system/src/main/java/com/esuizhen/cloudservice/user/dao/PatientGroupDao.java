/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.dao<br/>  
 * <b>文件名：</b>PatientGroupDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日-下午5:03:21<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.PatientGroup;

/** 
* @ClassName: PatientGroupDao 
* @Description: 患者分组信息表
* @author YYCHEN
* @date 2015年12月15日 下午5:03:21  
*/
public interface PatientGroupDao {
	//获取病种分组
	List<PatientGroup> selectPatientAutoGroup(Object obj);
	
	//获取MDT分组
    PatientGroup selectPatientMdtGroup(@Param("doctorId") Long doctorId,@Param("patientId") Long patientId);
    
    //获取自定义分组
    List<PatientGroup>  selectPatientCustom(@Param("creator") Long doctorId, @Param("groupWay") Integer groupWay,@Param("patientId")Long patientId);
    //分组查询
    String queryPatientGroupByParam(PatientGroup patientGroup);
    //创建自定义分组
	int addPatientGroup(PatientGroup patientGroup);
	//修改自定义分组
	int updatePatientGroup(PatientGroup patientGroup);
	//删除自定义分组
	int delPatientGroup(PatientGroup patientGroup);
	// 获取分组患者数 用于医生信息统计查询
	Integer countGroupPatientTotalNum(Object param);
	
	//统计在院或门诊人数
	LinkedHashMap countInhospitalGroup(Object obj);
	
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>DoctorClinicDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月28日下午2:34:29<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicInfo;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicScheduleInfo;
import com.esuizhen.cloudservice.business.model.business.RegisteringDoctors;

/** 
* @ClassName: DoctorClinicDao
* @Description: 
* @author lichenghao
* @date 2017年8月28日 下午2:34:29  
*/
public interface DoctorClinicDao {
	/**
	 * 医生出诊时间获取
	 * @author lichenghao
	 * @title :queryDoctorClinicScheduleInfo
	 * @Description:TODO
	 * @return List<TDoctorClinicScheduleInfo>
	 * @date 2015年12月14日 下午4:32:52
	 */
	public TDoctorClinicInfo queryDoctorClinicScheduleInfo(Long doctorId);
	/**
	 * 医生出诊简要信息获取
	 * @author lichenghao
	 * @title :queryDoctorClinicScheduleSampleInfo
	 * @Description:TODO
	 * @return TDoctorClinicInfo
	 * @date 2017年8月28日 下午3:56:09
	 */
	public TDoctorClinicInfo queryDoctorClinicScheduleSampleInfo(Long doctorId);
	/**
	 * 新增医生门诊
	 * @author lichenghao
	 * @title :createDoctorClinicSchedule
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月14日 下午4:31:24
	 */
	public void createDoctorClinicSchedule(TDoctorClinicScheduleInfo dcs);
	/**
	 * 获取可预约加号医生门诊
	 * @author lichenghao
	 * @title :getDoctorClinicUsage
	 * @Description:TODO
	 * @return TDoctorClinicInfo
	 * @date 2016年1月18日 下午8:50:06
	 */
	public List getDoctorClinicUsage(Object obj);
	/**
	 * 获取预约加号项
	 * @author lichenghao
	 * @title :queryDoctorClinicScheduleByUsage
	 * @Description:TODO
	 * @return TDoctorClinicScheduleInfo
	 * @date 2016年1月18日 下午9:53:12
	 */
	public TDoctorClinicScheduleInfo queryDoctorClinicScheduleByUsage(DoctorClinicUsageSetReq doctorClinicUsageSetReq);
	/**
	 * 修改门诊说明
	 * @author lichenghao
	 * @title :modifyRegisteringDoctor
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月28日 下午4:31:33
	 */
	public void modifyRegisteringDoctor(Map<String, Object> params);
	
	/**
	 * 创建医生预约加号
	 * @author lichenghao
	 * @title :createDoctorClinicScheduleUsage
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月20日 上午10:07:21
	 */
	public void createDoctorClinicScheduleUsage(DoctorClinicUsageSetReq doctorClinicUsageSetReq);
	
	/**
	 * 创建医生预约加号患者
	 * @author lichenghao
	 * @title :createDoctorClinicPatientUsage
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月31日 下午4:23:05
	 */
	public void createDoctorClinicPatientUsage(DoctorClinicUsageSetReq doctorClinicUsageSetReq);
	/**
	 * 修改医生预约加号
	 * @author lichenghao
	 * @title :modifyDoctorClinicScheduleUsage
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月20日 上午10:07:55
	 */
	public void modifyDoctorClinicScheduleUsage(DoctorClinicUsageSetReq doctorClinicUsageSetReq);
	
	
	/**
	 * 创建医生门诊
	 * @author lichenghao
	 * @title :createRegisterDoctor
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月21日 下午2:41:13
	 */
	public void createRegisterDoctor(RegisteringDoctors rd);
	
	/**
	 * 获取预约加号项编号
	 * @author lichenghao
	 * @title :getDoctorClinicUsageId
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月29日 下午4:47:45
	 */
	public String getDoctorClinicUsageId(DoctorClinicUsageSetReq doctorClinicUsageSetReq);
	
	/**
	 * 修改医生预约加号信息
	 * @author lichenghao
	 * @title :updateDoctorClinicScheduleUsageById
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月31日 下午4:23:38
	 */
	public void updateDoctorClinicScheduleUsageById(Object obj);
	
	/**
	 * 删除医生预约加号患者信息
	 * @author lichenghao
	 * @title :deleteDoctorClinicPatientUsageById
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月31日 下午4:24:16
	 */
	public void deleteDoctorClinicPatientUsageById(Object obj);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryDoctorClinicPatientUsageById
	 * @Description:获取门诊号信息
	 * @return String
	 * @date 2017年8月31日 下午10:49:48
	 */
	public String queryDoctorClinicPatientUsageById(Object obj);
}

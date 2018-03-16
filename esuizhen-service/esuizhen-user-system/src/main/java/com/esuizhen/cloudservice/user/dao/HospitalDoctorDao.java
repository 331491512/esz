/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.dao<br/>  
 * <b>文件名：</b>HospitalDoctorDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日-下午1:58:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.HospitalDoctor;

/**
 * @ClassName: HospitalDoctorDao
 * @Description: 医生科室患者关系DAO接口
 * @author YYCHEN
 * @date 2015年12月15日 下午1:58:10
 */
public interface HospitalDoctorDao {
	public long insert(HospitalDoctor hospitalDoctor);

	public int updateHospitalDoctor(@Param("record")HospitalDoctor hospitalDoctor);

	public int deleteById(Long id);

	public HospitalDoctor selectHospitalDoctor(@Param("doctorId") Long doctorId);
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao;<br/>  
 * <b>文件名：</b>UserDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月19日上午11:04:02<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.user;

import java.util.LinkedHashMap;

import org.apache.ibatis.annotations.Param;

/** 
* @ClassName: UserDao
* @Description: 
* @author lichenghao
* @date 2016年7月19日 上午11:04:02  
*/
public interface UserDao {
	public LinkedHashMap<String,Object> queryPatientInfoByOpenId(@Param("openId")String openId);
	
	public LinkedHashMap<String,Object> queryUserInfoByPatientId(@Param("patientId")Long patientId);
	
	public LinkedHashMap<String,Object> getValidContactMobile(@Param("patientId")Long patientId);
	
	public Long getDoctorId(Long userId);

	public Integer isPatientExist(Long patientId);

}

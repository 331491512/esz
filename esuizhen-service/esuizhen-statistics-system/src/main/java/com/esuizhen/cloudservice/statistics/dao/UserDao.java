/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.dao;<br/>  
 * <b>文件名：</b>StatisticsDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午6:06:38<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.dao;


import org.apache.ibatis.annotations.Param;

/** 
* @ClassName: StatisticsDao
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午6:06:38  
*/
public interface UserDao {
	
	public Long queryDoctorIdByUserId(@Param("userId")Long userId);

}

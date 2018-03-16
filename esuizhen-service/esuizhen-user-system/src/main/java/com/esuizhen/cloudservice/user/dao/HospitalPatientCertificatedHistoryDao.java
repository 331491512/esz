/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.dao;<br/>  
 * <b>文件名：</b>HospitalPatientCertificatedHistory.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月10日上午9:06:20<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.model.HospitalPatientCertificatedHistory;

/** 
* @ClassName: HospitalPatientCertificatedHistoryDao
* @Description: 
* @author lichenghao
* @date 2017年1月10日 上午9:06:20  
*/
public interface HospitalPatientCertificatedHistoryDao {
	//插入
	public int insert(Object obj);
	//修改
	public int modifyState(Object obj);
	//query
	public HospitalPatientCertificatedHistory queryByHistoryId(@Param("historyId") Long historyId);
}

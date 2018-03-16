/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.dao.server;<br/>  
 * <b>文件名：</b>ProcedureDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月6日下午5:36:03<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.dao.server;
/** 
* @ClassName: ProcedureDao
* @Description: 
* @author lichenghao
* @date 2017年4月6日 下午5:36:03  
*/
public interface ProcedureDao {
	//合并患者信息
	public void mergePatientInfo(Object obj);
	//合并医生信息
	public void mergeDoctorInfo(Object obj);
}

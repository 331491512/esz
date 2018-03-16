/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.dao.server;<br/>  
 * <b>文件名：</b>RHospitalPatient.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月23日下午6:59:18<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.model.server.THospitalPatient;

/**
* @ClassName: RHospitalPatient
* @Description: 
* @author lichenghao
* @date 2017年3月23日 下午6:59:18  
*/
public interface RHospitalPatientDao {
	public int insert(Object obj);
	public int update(Object obj);
	public THospitalPatient queryHospitalPatientRelation(Object obj);
}

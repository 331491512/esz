/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.dao.cloud;<br/>  
 * <b>文件名：</b>HospitalSyncLogDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月10日上午10:03:23<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.dao.cloud;

import com.westangel.common.bean.sync.THospitalIncreLog;

/** 
* @ClassName: HospitalSyncLogDao
* @Description: 
* @author lichenghao
* @date 2017年2月10日 上午10:03:23  
*/
public interface HospitalIncreLogDao {
	int insert(THospitalIncreLog hospitalIncreLog);
}

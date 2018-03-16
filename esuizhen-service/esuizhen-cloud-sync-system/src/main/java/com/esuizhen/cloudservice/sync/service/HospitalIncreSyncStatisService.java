/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.service;<br/>  
 * <b>文件名：</b>HospitalIncreSyncStatisService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月10日上午9:56:38<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.service;

import com.westangel.common.bean.sync.THospitalIncreLog;

/** 
* @ClassName: HospitalIncreSyncStatisService
* @Description: 
* @author lichenghao
* @date 2017年2月10日 上午9:56:38  
*/
public interface HospitalIncreSyncStatisService {
	public void syncHospitalIncreLog(THospitalIncreLog hospitalIncreLog);
}

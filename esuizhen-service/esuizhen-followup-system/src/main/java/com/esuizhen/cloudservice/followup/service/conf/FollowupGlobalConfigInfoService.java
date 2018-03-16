/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf<br/>  
 * <b>文件名：</b>FollowupGlobalConfigInfoService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午6:57:54<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.conf;

import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;

/** 
* @ClassName: FollowupGlobalConfigInfoService
* @Description: 系统全局配置信息服务
* @author NiDan
* @date 2016年8月10日下午6:57:54 
*/
public interface FollowupGlobalConfigInfoService {

	/**
	 * 系统全局配置
	 * @author Nidan
	 * @title:saveFollowupGlobalConfigInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月11日上午10:39:01
	 */
	public void saveFollowupGlobalConfigInfo(TFollowupGlobalConfigInfo followupGlobalConfigInfo);
	
	/**
	 * 系统全局配置查询
	 * @author Nidan
	 * @title:selectFollowupGlobalConfigInfo
	 * @Description:
	 * @return TFollowupGlobalConfigInfo
	 * @date 2016年8月11日上午10:49:56
	 */
	public TFollowupGlobalConfigInfo selectFollowupGlobalConfigInfo();

}

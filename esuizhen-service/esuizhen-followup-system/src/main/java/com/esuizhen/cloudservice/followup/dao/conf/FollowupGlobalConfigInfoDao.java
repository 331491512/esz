/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.conf<br/>  
 * <b>文件名：</b>FollowupGlobalConfigInfoDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午3:59:28<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.conf;

import java.util.LinkedHashMap;

import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;

/** 
* @ClassName: FollowupGlobalConfigInfoDao
* @Description: 全局配置接口
* @author NiDan
* @date 2016年8月10日下午3:59:28 
*/
public interface FollowupGlobalConfigInfoDao {
	
	/**
	 * 创建全局配置
	 * @author Nidan
	 * @title:createFollowupGlobalConfigInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午4:02:04
	 */
	public void createFollowupGlobalConfigInfo(TFollowupGlobalConfigInfo followupGlobalConfigInfo);
	
	/**
	 * 更新全局配置
	 * @author Nidan
	 * @title:updateFollowupGlobalConfigInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午4:03:28
	 */
	public void updateFollowupGlobalConfigInfo(TFollowupGlobalConfigInfo followupGlobalConfigInfo);
	
	/**
	 * 查询全局配置
	 * @author Nidan
	 * @title:selectFollowupGlobalConfigInfo
	 * @Description:
	 * @return TFollowupGlobalConfigInfo
	 * @date 2016年8月10日下午4:04:08
	 */
	public TFollowupGlobalConfigInfo selectFollowupGlobalConfigInfo();
	

	//获取系统全局配置
	public LinkedHashMap<String, Object> queryFollowupGlobalConfigInfo();

}

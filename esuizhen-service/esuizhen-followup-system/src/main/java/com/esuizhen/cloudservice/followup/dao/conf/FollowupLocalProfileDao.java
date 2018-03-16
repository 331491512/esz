/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.conf<br/>  
 * <b>文件名：</b>FollowupLocalProfileDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午3:29:13<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.conf;

import com.esuizhen.cloudservice.followup.model.conf.TFollowupLocalProfile;

/** 
* @ClassName: FollowupLocalProfileDao
* @Description: (随访人员)本机配置接口
* @author NiDan
* @date 2016年8月10日下午3:29:13 
*/
public interface FollowupLocalProfileDao {
	
	/**
	 * 添加随访人员本机配置
	 * @author Nidan
	 * @title:insertFollowupLocalProfile
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午3:53:25
	 */
	public void insertFollowupLocalProfile(TFollowupLocalProfile followupLocalProfile);
	
	/**
	 * 本机配置更新
	 * @author Nidan
	 * @title:updateFollowupLocalProfile
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午3:55:09
	 */
	public void updateFollowupLocalProfile(TFollowupLocalProfile followupLocalProfile);
	
	/**
	 * 查询随访人员本机配置
	 * @author Nidan
	 * @title:queryFollowupLocalProfile
	 * @Description:
	 * @return TFollowupLocalProfile
	 * @date 2016年8月10日下午3:55:42
	 */
	public TFollowupLocalProfile queryFollowupLocalProfile(Long userId);

}

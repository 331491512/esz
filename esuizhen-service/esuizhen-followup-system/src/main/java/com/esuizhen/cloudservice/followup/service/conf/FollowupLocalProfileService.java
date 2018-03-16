/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf<br/>  
 * <b>文件名：</b>FollowupLocalProfileService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日上午11:48:21<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.conf;

import com.esuizhen.cloudservice.followup.model.conf.TFollowupLocalProfile;

/** 
* @ClassName: FollowupLocalProfileService
* @Description: 随访人员本机号码配置服务
* @author NiDan
* @date 2016年8月11日上午11:48:21 
*/
public interface FollowupLocalProfileService {
	
	/**
	 * 随访人员本机号码配置
	 * @author Nidan
	 * @title:saveFollowupLocalProfile
	 * @Description:
	 * @return void
	 * @date 2016年8月11日上午11:49:32
	 */
	public void saveFollowupLocalProfile(TFollowupLocalProfile followupLocalProfile);
	
	/**
	 * 查询随访人员本机号码信息
	 * @author Nidan
	 * @title:queryFollowupLocalProfileByUserId
	 * @Description:
	 * @return TFollowupLocalProfile
	 * @date 2016年8月11日上午11:51:02
	 */
	public TFollowupLocalProfile queryFollowupLocalProfileByUserId(Long userId);

}

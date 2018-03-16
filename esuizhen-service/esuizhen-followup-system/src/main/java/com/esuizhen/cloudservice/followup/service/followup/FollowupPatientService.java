/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.followup;<br/>  
 * <b>文件名：</b>FollowupPatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午10:31:48<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.followup;

import com.esuizhen.cloudservice.followup.bean.FollowupTaskPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskScreenPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskSeniorScreenPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupPatientStatisInfo;

/** 
* @ClassName: FollowupPatientService
* @Description: 
* @author lichenghao
* @date 2016年8月8日 上午10:31:48  
*/
public interface FollowupPatientService {
	/**
	 * 
	 * @author lichenghao
	 * @title :getFollowupTaskPatientList
	 * @Description:患者常规筛选
	 * @return TFollowupPatientStatisInfo
	 * @date 2016年8月8日 上午10:42:42
	 */
	TFollowupPatientStatisInfo getFollowupTaskPatientList(FollowupTaskPatientReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getFollowupTaskSeniorScreenPatientList
	 * @Description:患者高级检索
	 * @return TFollowupPatientStatisInfo
	 * @date 2016年8月11日 上午8:10:37
	 */
	TFollowupPatientStatisInfo getFollowupTaskSeniorScreenPatientList(FollowupTaskSeniorScreenPatientReq req);

	/**
	 * 按患者SearchId进行筛选
	 * @param req
	 * @return
	 */
	TFollowupPatientStatisInfo getFollowupTaskPatientList(FollowupTaskScreenPatientReq req);
	
	/**
	 * 多条件筛选任务患者
	 * @param req
	 * @return
	 */
	TFollowupPatientStatisInfo getFollowupTaskPatientListWithOverlap(FollowupTaskPatientReq req);
}

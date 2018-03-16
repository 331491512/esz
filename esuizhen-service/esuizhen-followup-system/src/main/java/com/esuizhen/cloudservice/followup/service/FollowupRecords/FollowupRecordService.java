/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.followup;<br/>  
 * <b>文件名：</b>FollowupPatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午10:31:48<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.FollowupRecords;

import com.esuizhen.cloudservice.followup.bean.FollowupConvQuestionReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskSeniorScreenPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupPatientStatisInfo;

/** 
* @ClassName: FollowupRecordService
* @Description: 
* @author fanpanwei
* @date 2017年01月18日 上午10:31:48  
*/
public interface FollowupRecordService {
	/**
	 * @author fanpanwei
	 * @title :getConventionFollowupRecords
	 * @Description:常规随访记录查询
	 * @return TFollowupPatientStatisInfo
	 * @date 2017年01月18日 上午10:42:42
	 */
	public FollowupConvQuestionReq getConventionFollowupRecords(Integer patientId);
	
	/**
	 * @author fanpanwei
	 * @title :getFollowupTaskSeniorScreenPatientList
	 * @Description:常规随访记录保存
	 * @return TFollowupPatientStatisInfo
	 * @date 2017年01月18日 上午8:10:37
	 */
	public void saveConventionFollowupRecords(FollowupConvQuestionReq followupConvQuestionReq);
}

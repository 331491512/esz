/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.followup;<br/>  
 * <b>文件名：</b>FollowupMetaDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年3月27日下午7:01:30<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.questionnaire.dao;

import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireReqInfo;

/** 
* @ClassName: FollowupMetaDao
* @Description: 
* @author yuanwenming
* @date 2016年3月27日 下午7:01:30  
*/
public interface FollowupQuestionnaireReqDao {
	
	//新增下发请求
	public int createFollowupQuestionnaireReq(TFollowupQuestionnaireReqInfo params);
	
	//随访内容查看
	public TFollowupQuestionnaireReqInfo queryFollowupQuestionnaireReq(Object params);
	
	//修改随访消息状态
	public int updateFollowupQuestionnaireReq(TFollowupQuestionnaireReqInfo params);
}

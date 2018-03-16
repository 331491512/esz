/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.conf<br/>  
 * <b>文件名：</b>FollowupContentTemplateInfoDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午4:56:00<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.model.TFollowupContentTemplateInfo;

/** 
* @ClassName: FollowupContentTemplateInfoDao
* @Description: 随访内容模板接口
* @author NiDan
* @date 2016年8月10日下午4:56:00 
*/
public interface FollowupContentTemplateInfoDao {
	
	/**
	 * 添加随访内容模板
	 * @author Nidan
	 * @title:insertFollowupContentTemplateInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午5:03:14
	 */
	public void insertFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo);
	
	int queryFollowupContentTemplateInfo(String contentTemplateId);
}

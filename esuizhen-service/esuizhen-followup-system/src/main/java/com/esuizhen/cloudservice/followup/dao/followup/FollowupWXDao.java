/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.followup;<br/>  
 * <b>文件名：</b>FollowupMetaDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年3月27日下午7:01:30<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.followup;

import java.util.LinkedHashMap;

import com.esuizhen.cloudservice.followup.bean.TWXFollowupMessageInfo;
import com.esuizhen.cloudservice.followup.bean.WXFollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.WXFollowupSendReq;

/** 
* @ClassName: FollowupMetaDao
* @Description: 
* @author lichenghao
* @date 2016年3月27日 下午7:01:30  
*/
public interface FollowupWXDao {
	
	//更新医院随访消息模版
	public int updateFollowupWXTemplate(Object params);
	//新增下发请求
	public int createFollowupWXReq(Object params);
	//随访内容查看
	public TWXFollowupMessageInfo queryFollowupMessage(Object params);
	
	//获取随访模版内容
	public LinkedHashMap<String, Object> queryFollowupTemplate(WXFollowupSendReq req);
	
	//修改随访消息状态
	public int updateFollowupWXReq(Object params);
}

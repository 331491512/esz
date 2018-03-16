/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.conf<br/>  
 * <b>文件名：</b>FollowupReplyParseRulesInfoDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午4:07:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.conf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.model.conf.TFollowupReplyParseRulesInfo;

/** 
* @ClassName: FollowupReplyParseRulesInfoDao
* @Description: 短信回复自动解析规则接口
* @author NiDan
* @date 2016年8月10日下午4:07:32 
*/
public interface FollowupReplyParseRulesInfoDao {
	
	/**
	 * 新增短信回复解析规则
	 * @author Nidan
	 * @title:insertFollowupReplyParseRulesInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午4:15:09
	 */
	public void insertFollowupReplyParseRulesInfo(List<TFollowupReplyParseRulesInfo> rules);
	
	/**
	 * 删除短信回复解析规则
	 * @author Nidan
	 * @title:deleteAllFollowupReplyParseRulesInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午4:19:15
	 */
	public void deleteAllFollowupReplyParseRulesInfo();
	
	/**
	 * 查询短信回复解析规则
	 * @author Nidan
	 * @title:selectFollowupReplyParseRulesInfo
	 * @Description:
	 * @return List<TFollowupReplyParseRulesInfo> 
	 * @date 2016年8月10日下午4:19:46
	 */
	public List<TFollowupReplyParseRulesInfo> selectFollowupReplyParseRulesInfo();
	/**
	 * 查询短信回复解析规则
	 * @author raox
	 * queryTFollowupReplyByReplyContent
	 * @Description:
	 * @return TFollowupReplyParseRulesInfo
	 * @date 2016年8月15日下午4:19:46
	 */
	public TFollowupReplyParseRulesInfo queryTFollowupReplyByReplyContent(@Param("replyContent")String replyContent);

}

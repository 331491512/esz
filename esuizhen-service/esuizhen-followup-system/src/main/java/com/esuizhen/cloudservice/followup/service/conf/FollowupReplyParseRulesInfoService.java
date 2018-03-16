/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf<br/>  
 * <b>文件名：</b>FollowupReplyParseRulesInfoService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午4:01:13<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.conf;

import java.util.List;

import com.esuizhen.cloudservice.followup.model.conf.TFollowupReplyParseRulesInfo;

/** 
* @ClassName: FollowupReplyParseRulesInfoService
* @Description: 短信回复解析规则服务接口
* @author NiDan
* @date 2016年8月11日下午4:01:13 
*/
public interface FollowupReplyParseRulesInfoService {
	
	/**
	 * 短信回复解析规则保存
	 * @author Nidan
	 * @title:saveFollowupReplyParseRulesInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月11日下午4:05:20
	 */
	public void saveFollowupReplyParseRulesInfo(List<TFollowupReplyParseRulesInfo> rules);
	
	/**
	 * 短信回复解析规则查询
	 * @author Nidan
	 * @title:selectFollowupReplyParseRulesInfos
	 * @Description:
	 * @return List<TFollowupReplyParseRulesInfo>
	 * @date 2016年8月11日下午4:06:29
	 */
	public List<TFollowupReplyParseRulesInfo> selectFollowupReplyParseRulesInfos();

	/**
	 * 短信回复解析规则按内容查询
	 * @author raox
	 * @title:selectFollowupReplyParseRulesInfos
	 * @Description:
	 * @return List<TFollowupReplyParseRulesInfo>
	 * @date 2016年8月15日下午4:06:29
	 */
	public TFollowupReplyParseRulesInfo queryTFollowupReplyByReplyContent(String replyContent);

}

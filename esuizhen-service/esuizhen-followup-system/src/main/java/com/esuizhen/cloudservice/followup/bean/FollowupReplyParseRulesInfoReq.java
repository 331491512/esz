/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean<br/>  
 * <b>文件名：</b>FollowupReplyParseRulesInfoReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月25日下午2:18:26<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.List;

import com.esuizhen.cloudservice.followup.model.conf.TFollowupReplyParseRulesInfo;

/** 
* @ClassName: FollowupReplyParseRulesInfoReq
* @Description: 
* @author NiDan
* @date 2016年8月25日下午2:18:26 
*/
public class FollowupReplyParseRulesInfoReq {
	
	private List<TFollowupReplyParseRulesInfo> rules;

	public List<TFollowupReplyParseRulesInfo> getRules() {
		return rules;
	}

	public void setRules(List<TFollowupReplyParseRulesInfo> rules) {
		this.rules = rules;
	}

}

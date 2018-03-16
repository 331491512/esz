/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.conf<br/>  
 * <b>文件名：</b>TFollowupReplyParseRulesInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午3:17:51<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.conf;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: TFollowupReplyParseRulesInfo
* @Description: 短信回复自动解析规则类
* @author NiDan
* @date 2016年8月10日下午3:17:51 
*/
public class TFollowupReplyParseRulesInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2414205153466554257L;
	
	/**
	 * 解析规则id
	 */
	private Integer ruleId;
	
	/**
	 * 回复内容
	 */
	private String replyContent;
	
	/**
	 * 解析结果Id
	 */
	private Integer followupResultValueId;
	
	/**
	 * 解析结果名称
	 */
	private String followupResultValueName;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public TFollowupReplyParseRulesInfo() {
		
	}

	public TFollowupReplyParseRulesInfo(Integer ruleId, String replyContent, Integer followupResultValueId,
			String followupResultValueName, Date createTime, Date updateTime) {
		super();
		this.ruleId = ruleId;
		this.replyContent = replyContent;
		this.followupResultValueId = followupResultValueId;
		this.followupResultValueName = followupResultValueName;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Integer getFollowupResultValueId() {
		return followupResultValueId;
	}

	public void setFollowupResultValueId(Integer followupResultValueId) {
		this.followupResultValueId = followupResultValueId;
	}

	public String getFollowupResultValueName() {
		return followupResultValueName;
	}

	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}

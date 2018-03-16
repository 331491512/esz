package com.westangel.timertask.model;

import java.util.Date;


public class OpPushRuleConf{
	
	/**
	 * 知识库ID
	 */
	private Long pushRuleId;
	/**
	 * 推送周期如1：每天2：每周3：每两周4：每月5：每三月6：每半年7：每年
	 */
	private Integer pushCycle;
	/**
	 * 推送日期
	 */
	private Date pushTime;
	/**
	 * 是否循环：0：是1：否
	 */
	private Integer isLoop;
	/**
	 * 推送最大文章数
	 */
	private Integer pushArticleMaxNum;
	/**
	 * 是否启用：0：禁止（默认）1：启用
	 */
	private Integer state;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	
	/**
	 * 最后一次执行时间
	 */
	private Date lastTime;
	
	private String title;
	
	private String content;
	
	private String bak;
	
	private Integer isUseTitle;
	
	public void setPushRuleId(Long pushRuleId) {
		this.pushRuleId = pushRuleId;
	}
	
	public Long getPushRuleId() {
		return this.pushRuleId;
	}
	public void setPushCycle(Integer pushCycle) {
		this.pushCycle = pushCycle;
	}
	
	public Integer getPushCycle() {
		return this.pushCycle;
	}
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}
	
	public Date getPushTime() {
		return this.pushTime;
	}
	public void setIsLoop(Integer isLoop) {
		this.isLoop = isLoop;
	}
	
	public Integer getIsLoop() {
		return this.isLoop;
	}
	public void setPushArticleMaxNum(Integer pushArticleMaxNum) {
		this.pushArticleMaxNum = pushArticleMaxNum;
	}
	
	public Integer getPushArticleMaxNum() {
		return this.pushArticleMaxNum;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public Date getLastTime()
	{
		return lastTime;
	}

	public void setLastTime(Date lastTime)
	{
		this.lastTime = lastTime;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getBak()
	{
		return bak;
	}

	public void setBak(String bak)
	{
		this.bak = bak;
	}

	public Integer getIsUseTitle()
	{
		return isUseTitle;
	}

	public void setIsUseTitle(Integer isUseTitle)
	{
		this.isUseTitle = isUseTitle;
	}

	

}


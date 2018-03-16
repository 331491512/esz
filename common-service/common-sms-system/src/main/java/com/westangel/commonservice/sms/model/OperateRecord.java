package com.westangel.commonservice.sms.model;

public class OperateRecord {
	
	private Long id;
	/**
	 * 操作名称，
	 */
	private String operateName;
	/**
	 * 内容
	 */
	private String operateContent;
	/**
	 * 时间
	 */
	private String occurTime;
	/**
	 * 执行结果
	 */
	private Integer exeResult;
	/**
	 * 失败原因
	 */
	private String failedCause="";
	/**
	 * 回执请求
	 */
	private String backUrl;
	/** 
	* @return id 
	*/
	public Long getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Long id) {
		this.id = id;
	}
	/** 
	* @return operateName 
	*/
	public String getOperateName() {
		return operateName;
	}
	/** 
	* @param operateName 要设置的 operateName 
	*/
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	/** 
	* @return operateContent 
	*/
	public String getOperateContent() {
		return operateContent;
	}
	/** 
	* @param operateContent 要设置的 operateContent 
	*/
	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}
	/** 
	* @return occurTime 
	*/
	public String getOccurTime() {
		return occurTime;
	}
	/** 
	* @param occurTime 要设置的 occurTime 
	*/
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	/** 
	* @return exeResult 
	*/
	public Integer getExeResult() {
		return exeResult;
	}
	/** 
	* @param exeResult 要设置的 exeResult 
	*/
	public void setExeResult(Integer exeResult) {
		this.exeResult = exeResult;
	}
	/** 
	* @return failedCause 
	*/
	public String getFailedCause() {
		return failedCause;
	}
	/** 
	* @param failedCause 要设置的 failedCause 
	*/
	public void setFailedCause(String failedCause) {
		this.failedCause = failedCause;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
}

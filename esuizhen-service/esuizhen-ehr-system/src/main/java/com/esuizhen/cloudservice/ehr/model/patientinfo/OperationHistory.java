package com.esuizhen.cloudservice.ehr.model.patientinfo;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: OperationHistory 
* @Description: 用户操作历史记录表bean
* @author YYCHEN
* @date 2015年12月25日 上午10:54:01  
*/
public class OperationHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long operationId;
	private Long operatorId;
	private String operationName;
	private String description;
	private Integer actionType;
	private Date createTime;
	
	public Long getOperationId() {
		return operationId;
	}
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getActionType() {
		return actionType;
	}
	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

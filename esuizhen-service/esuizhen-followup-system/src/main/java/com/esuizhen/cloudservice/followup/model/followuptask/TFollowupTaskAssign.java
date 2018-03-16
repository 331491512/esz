/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.followuptask;

/**
 * @author DaLoong
 * @date  2016-8-10 下午3:56:41
 */
public class TFollowupTaskAssign {

	String followupAssignId;//		任务分配Id。
	String followupTaskId	;//	随访任务ID。
	Long   operator	;//	随访任务执行人（操作员）。
	
	String operatorName	;//	随访人员姓名。
	Integer state;	//任务状态：
	/*0：未开始（默认）；
	1：进行中； 
	2：已完成
	3：已终止*/
	Integer totalPatientNum	;//总患者数
	
	Integer lastFollowupPatientNum;//末次随访患者数
	
	Integer isLastFollowup;
	/**
	 * @return the followupAssignId
	 */
	public String getFollowupAssignId() {
		return followupAssignId;
	}
	/**
	 * @param followupAssignId the followupAssignId to set
	 */
	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}
	/**
	 * @return the followupTaskId
	 */
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	/**
	 * @param followupTaskId the followupTaskId to set
	 */
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	/**
	 * @return the operator
	 */
	public Long getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	/**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * @param operatorName the operatorName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the totalPatientNum
	 */
	public Integer getTotalPatientNum() {
		return totalPatientNum;
	}
	/**
	 * @param totalPatientNum the totalPatientNum to set
	 */
	public void setTotalPatientNum(Integer totalPatientNum) {
		this.totalPatientNum = totalPatientNum;
	}
	public Integer getLastFollowupPatientNum() {
		return lastFollowupPatientNum;
	}
	public void setLastFollowupPatientNum(Integer lastFollowupPatientNum) {
		this.lastFollowupPatientNum = lastFollowupPatientNum;
	}
	public Integer getIsLastFollowup() {
		return isLastFollowup;
	}
	public void setIsLastFollowup(Integer isLastFollowup) {
		this.isLastFollowup = isLastFollowup;
	}
}

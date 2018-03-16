/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.meta;

/**
 * 随访人员信息
 * @author DaLoong
 * @date  2016-8-13 上午11:18:02
 */
public class FollowupOperatorInfo {

	Long operator	;//随访人员ID，随访任务执行人（操作员）。
	  //外键：u_doctor.doctorId。
	
	String operatorName	;//随访人员真实姓名。

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
	 * @param trueName the trueName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	
}

/**
 * @author: Da Loong
 * @date:   2016年4月17日 下午12:26:50
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * @author Da Loong
 * @date   2016年4月17日 下午12:26:50
 */
public class TMetaInfoIcd9Cm3 {

	private int  opId;
	
	private String opCode;
	
	private String opName;
	private String mnemonicCode;
	
	// add by zhuguo 手术操作性质代码
	private String operationNatureCode;
	
	// add by zhuguo 手术级别代码
	private String operationLevelCode;
	
	public String getOperationNatureCode() {
		return operationNatureCode;
	}

	public void setOperationNatureCode(String operationNatureCode) {
		this.operationNatureCode = operationNatureCode;
	}

	public String getOperationLevelCode() {
		return operationLevelCode;
	}

	public void setOperationLevelCode(String operationLevelCode) {
		this.operationLevelCode = operationLevelCode;
	}

	public String getMnemonicCode() {
		return mnemonicCode;
	}

	public void setMnemonicCode(String mnemonicCode) {
		this.mnemonicCode = mnemonicCode;
	}

	/**
	 * @return the opId
	 */
	public int getOpId() {
		return opId;
	}

	/**
	 * @param opId the opId to set
	 */
	public void setOpId(int opId) {
		this.opId = opId;
	}

	/**
	 * @return the opCode
	 */
	public String getOpCode() {
		return opCode;
	}

	/**
	 * @param opCode the opCode to set
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	/**
	 * @return the opName
	 */
	public String getOpName() {
		return opName;
	}

	/**
	 * @param opName the opName to set
	 */
	public void setOpName(String opName) {
		this.opName = opName;
	}
	
	
}

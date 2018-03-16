/**
 * @author: Da Loong
 * @date:   2016年4月9日 上午12:17:33
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-检查明细（如靶病灶）
 * @author Da Loong
 * @date   2016年4月9日 上午12:17:33
 */
public class TMetaInfoExamItem {

	private  int examTypeId;
	
	private  int examItemId;
	
	private  String examItemName;
	
	private  String examItemCode;

	/**
	 * @return the examTypeId
	 */
	public int getExamTypeId() {
		return examTypeId;
	}

	/**
	 * @param examTypeId the examTypeId to set
	 */
	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}

	/**
	 * @return the examItemId
	 */
	public int getExamItemId() {
		return examItemId;
	}

	/**
	 * @param examItemId the examItemId to set
	 */
	public void setExamItemId(int examItemId) {
		this.examItemId = examItemId;
	}

	/**
	 * @return the examItemName
	 */
	public String getExamItemName() {
		return examItemName;
	}

	/**
	 * @param examItemName the examItemName to set
	 */
	public void setExamItemName(String examItemName) {
		this.examItemName = examItemName;
	}

	/**
	 * @return the examItemCode
	 */
	public String getExamItemCode() {
		return examItemCode;
	}

	/**
	 * @param examItemCode the examItemCode to set
	 */
	public void setExamItemCode(String examItemCode) {
		this.examItemCode = examItemCode;
	}
	
	
}

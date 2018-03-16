/**
 * @author: Da Loong
 * @date:   2016年4月14日 上午10:23:04
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-生存质量评价量表-答案选项明细 
 * @author Da Loong
 * @date   2016年4月14日 上午10:23:04
 */
public class TMetaInfoQualityoflifeScaleItemOptions {

	/**
	 * 答案选项ID
	 */
	private int scaleOptionsId;
	
	/**
	 * 序号
	 */
	private int optionIndex;
	
	/**
	 * 答案描述
	 */
	private String content;
	
	/**
	 * 取值
	 */
	private int indicateValue;

	/**
	 * @return the scaleOptionsId
	 */
	public int getScaleOptionsId() {
		return scaleOptionsId;
	}

	/**
	 * @param scaleOptionsId the scaleOptionsId to set
	 */
	public void setScaleOptionsId(int scaleOptionsId) {
		this.scaleOptionsId = scaleOptionsId;
	}

	/**
	 * @return the optionIndex
	 */
	public int getOptionIndex() {
		return optionIndex;
	}

	/**
	 * @param optionIndex the optionIndex to set
	 */
	public void setOptionIndex(int optionIndex) {
		this.optionIndex = optionIndex;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the indicateValue
	 */
	public int getIndicateValue() {
		return indicateValue;
	}

	/**
	 * @param indicateValue the indicateValue to set
	 */
	public void setIndicateValue(int indicateValue) {
		this.indicateValue = indicateValue;
	}

	
	
}

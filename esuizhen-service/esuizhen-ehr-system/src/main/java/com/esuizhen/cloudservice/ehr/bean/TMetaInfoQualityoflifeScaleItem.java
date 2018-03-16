/**
 * @author: Da Loong
 * @date:   2016年4月12日 上午12:25:47
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.List;

/**
 * 元数据-生存质量评价量表
 * @author Da Loong
 * @date   2016年4月12日 上午12:25:47
 */
public class TMetaInfoQualityoflifeScaleItem {

	/**
	 * ID
	 */
	private int   scaleItemId;
	
	/**
	 * 序号
	 */
	private int   seqNo;
	
	/**
	 * 问题描述
	 */
	private String  questionDescription;
	
	/**
	 * 答案选项列表
	 */
	List<TMetaInfoQualityoflifeScaleItemOptions> itemOptionsList;

	/**
	 * @return the scaleIItemd
	 */
	public int getScaleItemId() {
		return scaleItemId;
	}

	/**
	 * @param scaleIItemd the scaleIItemd to set
	 */
	public void setScaleItemId(int scaleItemId) {
		this.scaleItemId = scaleItemId;
	}

	/**
	 * @return the seqNo
	 */
	public int getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return the questionDescription
	 */
	public String getQuestionDescription() {
		return questionDescription;
	}

	/**
	 * @param questionDescription the questionDescription to set
	 */
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	
	

	
}

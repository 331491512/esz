/**
 * @author: Da Loong
 * @date:   2016年4月12日 上午1:20:31
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-不良反应
 * @author Da Loong
 * @date   2016年4月12日 上午1:20:31
 */
public class TMetaInfoAdverseReaction {

	/**
	 * ID
	 */
	private int adverseReactionId;
	
	/**
	 * 不良反应名称
	 */
	private String  adverseReactionName;
	
	/**
	 * 级别一描述
	 */
	private String grade1;
	
	/**
	 * 级别二描述
	 */
	private String grade2;
	
	/**
	 * 级别三描述
	 */
	private String grade3;
	
	/**
	 * 级别四描述
	 */
	private String grade4;
	
	/**
	 * 级别五描述
	 */
	private String grade5;
	
	
	

	/**
	 * @return the grade1
	 */
	public String getGrade1() {
		return grade1;
	}

	/**
	 * @param grade1 the grade1 to set
	 */
	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}

	/**
	 * @return the grade2
	 */
	public String getGrade2() {
		return grade2;
	}

	/**
	 * @param grade2 the grade2 to set
	 */
	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}

	/**
	 * @return the grade3
	 */
	public String getGrade3() {
		return grade3;
	}

	/**
	 * @param grade3 the grade3 to set
	 */
	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}

	/**
	 * @return the grade4
	 */
	public String getGrade4() {
		return grade4;
	}

	/**
	 * @param grade4 the grade4 to set
	 */
	public void setGrade4(String grade4) {
		this.grade4 = grade4;
	}

	/**
	 * @return the grade5
	 */
	public String getGrade5() {
		return grade5;
	}

	/**
	 * @param grade5 the grade5 to set
	 */
	public void setGrade5(String grade5) {
		this.grade5 = grade5;
	}

	/**
	 * @return the adverseReactionId
	 */
	public int getAdverseReactionId() {
		return adverseReactionId;
	}

	/**
	 * @param adverseReactionId the adverseReactionId to set
	 */
	public void setAdverseReactionId(int adverseReactionId) {
		this.adverseReactionId = adverseReactionId;
	}

	/**
	 * @return the adverseReactionName
	 */
	public String getAdverseReactionName() {
		return adverseReactionName;
	}

	/**
	 * @param adverseReactionName the adverseReactionName to set
	 */
	public void setAdverseReactionName(String adverseReactionName) {
		this.adverseReactionName = adverseReactionName;
	}
	
	

	
}

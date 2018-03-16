/**
 * @author: Da Loong
 * @date:   2016年4月7日 下午6:05:53
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * @author Da Loong
 * @date   2016年4月7日 下午6:05:53
 */
public class TMetaInfoKps {

	private int kpsId;
	
	private int score;
	
	private String description;

	/**
	 * @return the kpsId
	 */
	public int getKpsId() {
		return kpsId;
	}

	/**
	 * @param kpsId the kpsId to set
	 */
	public void setKpsId(int kpsId) {
		this.kpsId = kpsId;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param decription the decription to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

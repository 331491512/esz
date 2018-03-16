/**
 * @author: Da Loong
 * @date:   2016年4月7日 下午6:15:24
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * @author Da Loong
 * @date   2016年4月7日 下午6:15:24
 */
public class TMetaInfoEcog {

	private int ecogId;
	
	private int score;
	
	private int kpsId;
	
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

	/**
	 * @return the ecogId
	 */
	public int getEcogId() {
		return ecogId;
	}

	/**
	 * @param ecogId the ecogId to set
	 */
	public void setEcogId(int ecogId) {
		this.ecogId = ecogId;
	}
		
}

/**
 * 
 */
package com.westangel.commonservice.trade.bean;

/**
 * 初始化产品请求
 * @author DaLoong
 * @date  2016年2月16日 下午3:05:55
 */
public class TProductInitReq {

	private  Long userId;
	
	private  int  professionalRankId;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the professionalRankId
	 */
	public int getProfessionalRankId() {
		return professionalRankId;
	}

	/**
	 * @param professionalRankId the professionalRankId to set
	 */
	public void setProfessionalRankId(int professionalRankId) {
		this.professionalRankId = professionalRankId;
	}
	
	
}

/**
 * 
 * @author Da Loong
 * @date  2016年6月1日 下午5:25:14
 */
package com.westangel.common.bean;

import java.io.Serializable;

/**
 * @author Da Loong
 * @date  2016年6月1日 下午5:25:14
 */
public class TWeixinProductIdInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int wxProductId;
	
	private int hospitalId;
	
	private String wxName;

	/**
	 * @return the wxProductId
	 */
	public int getWxProductId() {
		return wxProductId;
	}

	/**
	 * @param wxProductId the wxProductId to set
	 */
	public void setWxProductId(int wxProductId) {
		this.wxProductId = wxProductId;
	}

	/**
	 * @return the hospitalId
	 */
	public int getHospitalId() {
		return hospitalId;
	}

	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}
}

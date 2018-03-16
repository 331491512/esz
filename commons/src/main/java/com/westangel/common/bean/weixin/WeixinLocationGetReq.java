package com.westangel.common.bean.weixin;

public class WeixinLocationGetReq  implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -5763071535135016679L;
	/**
	 * 经度
	 */
	private double lat;	
	/**
	 * 纬度
	 */
	private double lng;
	/** 
	* @return lat 
	*/
	public double getLat() {
		return lat;
	}
	/** 
	* @param lat 要设置的 lat 
	*/
	public void setLat(double lat) {
		this.lat = lat;
	}
	/** 
	* @return lng 
	*/
	public double getLng() {
		return lng;
	}
	/** 
	* @param lng 要设置的 lng 
	*/
	public void setLng(double lng) {
		this.lng = lng;
	}

}

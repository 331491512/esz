package com.westangel.common.bean.weixin;

public class WeixinLocationInfo implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 921940157218442815L;
	/**
	 * 经度
	 */
	private double lat;	
	/**
	 * 纬度
	 */
	private double lng;
	/**
	 * 行政区
	 */
	private String adCode;
	/**
	 * 城市编码
	 */
	private Integer cityCode;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;	
	/**
	 * 县，地区
	 */
	private String district;
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
	* @return cityCode 
	*/
	public Integer getCityCode() {
		return cityCode;
	}
	/** 
	* @param cityCode 要设置的 cityCode 
	*/
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	/** 
	* @return country 
	*/
	public String getCountry() {
		return country;
	}
	/** 
	* @param country 要设置的 country 
	*/
	public void setCountry(String country) {
		this.country = country;
	}
	/** 
	* @return province 
	*/
	public String getProvince() {
		return province;
	}
	/** 
	* @param province 要设置的 province 
	*/
	public void setProvince(String province) {
		this.province = province;
	}
	/** 
	* @return district 
	*/
	public String getDistrict() {
		return district;
	}
	/** 
	* @param district 要设置的 district 
	*/
	public void setDistrict(String district) {
		this.district = district;
	}
	/** 
	* @return city 
	*/
	public String getCity() {
		return city;
	}
	/** 
	* @param city 要设置的 city 
	*/
	public void setCity(String city) {
		this.city = city;
	}
	/** 
	* @return adCode 
	*/
	public String getAdCode() {
		return adCode;
	}
	/** 
	* @param adCode 要设置的 adCode 
	*/
	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}
}

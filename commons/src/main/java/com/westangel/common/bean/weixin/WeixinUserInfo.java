package com.westangel.common.bean.weixin;

import java.util.List;

public class WeixinUserInfo implements java.io.Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 4197069808289850280L;
	
	private Integer errcode;
	private String errmsg;
	private String openid;
	private String nickname;
	private String sex;
	private String province;
	private String city;
	private String country;
	private String headimgurl;
	private List<String> privilege;
	private String unionid;
	/** 
	* @return errcode 
	*/
	public Integer getErrcode() {
		return errcode;
	}
	/** 
	* @param errcode 要设置的 errcode 
	*/
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	/** 
	* @return errmsg 
	*/
	public String getErrmsg() {
		return errmsg;
	}
	/** 
	* @param errmsg 要设置的 errmsg 
	*/
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	/** 
	* @return openid 
	*/
	public String getOpenid() {
		return openid;
	}
	/** 
	* @param openid 要设置的 openid 
	*/
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/** 
	* @return nickname 
	*/
	public String getNickname() {
		return nickname;
	}
	/** 
	* @param nickname 要设置的 nickname 
	*/
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/** 
	* @return sex 
	*/
	public String getSex() {
		return sex;
	}
	/** 
	* @param sex 要设置的 sex 
	*/
	public void setSex(String sex) {
		this.sex = sex;
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
	* @return headimgurl 
	*/
	public String getHeadimgurl() {
		return headimgurl;
	}
	/** 
	* @param headimgurl 要设置的 headimgurl 
	*/
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	/** 
	* @return privilege 
	*/
	public List<String> getPrivilege() {
		return privilege;
	}
	/** 
	* @param privilege 要设置的 privilege 
	*/
	public void setPrivilege(List<String> privilege) {
		this.privilege = privilege;
	}
	/** 
	* @return unionid 
	*/
	public String getUnionid() {
		return unionid;
	}
	/** 
	* @param unionid 要设置的 unionid 
	*/
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}

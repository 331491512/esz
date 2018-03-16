/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean.yiyao;<br/>  
 * <b>文件名：</b>DataYiYao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月14日下午4:22:55<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.thirdparty.bean.yiyao;
/** 
* @ClassName: DataYiYao
* @Description: 
* @author lichenghao
* @date 2016年7月14日 下午4:22:55  
*/
public class LoginReq {
	//目标跳转地址
	private String targetUrl;
	//用户手机号
	private String mobile;
	//用户姓名
	private String name;
	//用户性别
	private String sex;
	//用户生日
	private String birthday;
	//用户身份证
	private String idcard;
	//用户社保卡号
	private String socialSecurityCard;
	//用户头像
	private String logoPath;
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSocialSecurityCard() {
		return socialSecurityCard;
	}
	public void setSocialSecurityCard(String socialSecurityCard) {
		this.socialSecurityCard = socialSecurityCard;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
}

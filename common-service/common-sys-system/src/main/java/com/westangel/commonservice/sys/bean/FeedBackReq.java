/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.model;<br/>  
 * <b>文件名：</b>FeedBack.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日上午10:41:34<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.bean;
/** 用户意见反馈表
* @ClassName: FeedBack
* @Description: 
* @author lichenghao
* @date 2015年12月17日 上午10:41:34  
*/
public class FeedBackReq {
	//用户编号
	private Long userId;
	//用户角色 1.患者 2.医生（默认）
	private Integer userRole=2;
	//业务编号
	private Integer businessId;
	//产品编号
	private Integer productId;
	//app版本
	private String appVersion;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.push;<br/>  
 * <b>文件名：</b>PushUser.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月24日上午10:51:18<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.push;

import java.io.Serializable;

/** 
* @ClassName: PushUser
* @Description: 
* @author lichenghao
* @date 2016年6月24日 上午10:51:18  
*/
public class PushUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Integer productId;
	private String openId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}

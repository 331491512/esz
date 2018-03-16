/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean;<br/>  
 * <b>文件名：</b>ExpressCompany.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月21日上午10:20:15<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: ExpressCompany
* @Description: 
* @author lichenghao
* @date 2016年6月21日 上午10:20:15  
*/
public class ExpressCompany implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 快递公司编号
	 */
	private Integer expressCompanyId;
	/**
	 * 快递公司名称
	 */
	private String expressCompanyName;
	public Integer getExpressCompanyId() {
		return expressCompanyId;
	}
	public void setExpressCompanyId(Integer expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}
	public String getExpressCompanyName() {
		return expressCompanyName;
	}
	public void setExpressCompanyName(String expressCompanyName) {
		this.expressCompanyName = expressCompanyName;
	}
}

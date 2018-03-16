/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>THospitalSpecialtyInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月8日下午6:57:24<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: THospitalSpecialtyInfo
* @Description: 特色专科
* @author lichenghao
* @date 2016年6月8日 下午6:57:24  
*/
public class THospitalSpecialtyInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -44280224920374718L;
	/**
	 * 专科ID
	 */
	private Integer specialtyId;
	/**
	 * 专科名
	 */
	private String specialtyName;
	public Integer getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(Integer specialtyId) {
		this.specialtyId = specialtyId;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
}

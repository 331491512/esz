/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>DoctorTagListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月11日-上午10:33:17<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: DoctorTagListReq 
* @Description: 医生标签bean
* @author huangdongxing
* @date 2015年12月11日 上午10:33:17  
*/
public class DoctorTag implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long tagId;
	private String tagName;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}

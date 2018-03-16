/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.sys;<br/>  
 * <b>文件名：</b>TTageInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月17日上午10:59:54<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.sys;

import java.io.Serializable;

/**
* @ClassName: TTagInfo
* @Description: 
* @author lichenghao
* @date 2017年2月17日 上午10:59:54  
*/
public class TagInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 标签Id
	private Integer tagId;
	// 标签名称
	private String tagName;
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}

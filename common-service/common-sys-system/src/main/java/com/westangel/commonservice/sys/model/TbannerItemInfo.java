/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.model;<br/>  
 * <b>文件名：</b>TbannerItemInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月21日下午3:23:49<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.model;
/** 
* @ClassName: TbannerItemInfo
* @Description: 
* @author lichenghao
* @date 2015年12月21日 下午3:23:49  
*/
public class TbannerItemInfo {
	// 类型1: 标题 	2：正文	3：图片（一个url)	4：分享图标(一个url)	5：内容链接（点击图片或文本进入的链接）
	private Integer itemType;
	// 内容
	private String content;
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

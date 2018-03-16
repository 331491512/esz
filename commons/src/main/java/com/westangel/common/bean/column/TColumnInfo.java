/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.column;<br/>  
 * <b>文件名：</b>TColumnInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月13日下午7:09:10<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.column;

import java.io.Serializable;

/** 
* @ClassName: TColumnInfo
* @Description: 
* @author lichenghao
* @date 2016年7月13日 下午7:09:10  
*/
public class TColumnInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//标题
	private String title;
	//备注
	private String description;
	
	//跳转链接
	private String url;
	
	//图片链接
	private String pictureUrl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}

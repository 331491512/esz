/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>THospitalGuideInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月19日下午7:11:56<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: THospitalGuideInfo
* @Description:就医指南基本信息 
* @author lichenghao
* @date 2016年7月19日 下午7:11:56  
*/
public class THospitalGuideInfo {
	//就医指南标题
	private String title;
	//就医指南内容
	private String content;
	//就医指南编号
	private String guideId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGuideId() {
		return guideId;
	}
	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}
}

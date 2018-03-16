/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>TDoctorAnnouncementInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午5:53:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;
/** 
* @ClassName: TDoctorAnnouncementInfo.java
* @Description: 医生公告信息
* @author lichenghao
* @date 2015年12月12日 下午5:53:01  
*/
public class TDoctorAnnouncementInfo {
	/**
	 * 公告编号
	 */
	private Long announcementId;
	
	/**
	 * 公告内容
	 */
	private String announcementContent;
	
	/**
	 * 录入时间
	 */
	private String createTime;

	public Long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	public String getAnnouncementContent() {
		return announcementContent;
	}

	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}

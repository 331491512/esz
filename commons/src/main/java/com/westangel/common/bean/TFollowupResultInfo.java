/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean;<br/>  
 * <b>文件名：</b>TFollowupResultInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月20日上午11:40:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: TFollowupResultInfo
* @Description: 随访结果信息
* @author lichenghao
* @date 2016年5月20日 上午11:40:58  
*/
public class TFollowupResultInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//随访结果ID
	private Integer followupResultValueId;
	//随访结果
	private String followupResultValueName;
	//最近方式
	private String followupWayName;
	//随访时间。YYYY-MM-DD HH:MM:SS
	private Date followupDate;
	public Integer getFollowupResultValueId() {
		return followupResultValueId;
	}
	public void setFollowupResultValueId(Integer followupResultValueId) {
		this.followupResultValueId = followupResultValueId;
	}
	public String getFollowupResultValueName() {
		return followupResultValueName;
	}
	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}
	public String getFollowupWayName() {
		return followupWayName;
	}
	public void setFollowupWayName(String followupWayName) {
		this.followupWayName = followupWayName;
	}
	public Date getFollowupDate() {
		return followupDate;
	}
	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>TFollowupPatientStatisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午8:41:20<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.List;

/** 
* @ClassName: TFollowupPatientStatisInfo
* @Description: 
* @author lichenghao
* @date 2016年8月8日 上午8:41:20  
*/
public class TFollowupPatientStatisInfo {
	
	//查询结果Id
	private Integer searchId;
	//符合人数
	private String totalNum;
	//不符合人数
	private Integer notInTaskNum;
	//查询结果项
	private List<TFollowupPatientStatisItemInfo> items;
	
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getNotInTaskNum() {
		return notInTaskNum;
	}
	public void setNotInTaskNum(Integer notInTaskNum) {
		this.notInTaskNum = notInTaskNum;
	}
	public List<TFollowupPatientStatisItemInfo> getItems() {
		return items;
	}
	public void setItems(List<TFollowupPatientStatisItemInfo> items) {
		this.items = items;
	}
	
	
}

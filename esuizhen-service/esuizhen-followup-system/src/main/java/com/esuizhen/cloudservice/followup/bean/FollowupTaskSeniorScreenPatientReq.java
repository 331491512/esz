/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>FollowupTaskPatientReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午8:19:59<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.List;

import com.westangel.common.bean.search.RetrievalParamentReq;

/** 
* @ClassName: FollowupTaskPatientReq
* @Description: 
* @author lichenghao
* @date 2016年8月8日 上午8:19:59  
*/
public class FollowupTaskSeniorScreenPatientReq {
	//操作人
	private Long operator;
	//是否展示无联系方式的患者
	private Integer needContactFlag;
	//最近随访人员
	private Long latestOperator;
	//随访周期
	private Integer followupCycle;
	//高级检索
	private List<RetrievalParamentReq> paraments;
	
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public Integer getNeedContactFlag() {
		return needContactFlag;
	}
	public void setNeedContactFlag(Integer needContactFlag) {
		this.needContactFlag = needContactFlag;
	}
	public List<RetrievalParamentReq> getParaments() {
		return paraments;
	}
	public void setParaments(List<RetrievalParamentReq> paraments) {
		this.paraments = paraments;
	}
	public Integer getFollowupCycle() {
		return followupCycle;
	}
	public void setFollowupCycle(Integer followupCycle) {
		this.followupCycle = followupCycle;
	}
	public Long getLatestOperator() {
		return latestOperator;
	}
	public void setLatestOperator(Long latestOperator) {
		this.latestOperator = latestOperator;
	}
}

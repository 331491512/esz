 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>FollowupPatientStatisticsResult.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:23:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: FollowupPatientStatisticsResult
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:23:58 
*/
public class FollowupPatientStatisticsReq {
	private String[] statisticsTypes;
	
	private FollowupPatientStatusStatisticsReq[] statisticsReqs;
	/**
	 * 操作员
	 */
	private Long operator;
	/**
	 * 用户角色
	 */
	private Integer userRole;
	
	/**
	 * 医院id
	 */
	private Integer hospitalId;
	
	public String[] getStatisticsTypes() {
		return statisticsTypes;
	}

	public void setStatisticsTypes(String[] statisticsTypes) {
		this.statisticsTypes = statisticsTypes;
	}

	public FollowupPatientStatusStatisticsReq[] getStatisticsReqs() {
		return statisticsReqs;
	}

	public void setStatisticsReqs(
			FollowupPatientStatusStatisticsReq[] statisticsReqs) {
		this.statisticsReqs = statisticsReqs;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}

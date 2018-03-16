/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>PatientReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月7日上午10:15:18<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: PatientReq
* @Description: 
* @author lichenghao
* @date 2016年4月7日 上午10:15:18  
*/
public class PatientSpreadReq {
	
	//用户ID，0表示全国
	private Long userId;
	
	//用户角色，1医生 userId＝0时，该字段无效
	private Integer userRole;
	
	//患者统计类型 
	private String[] statisticType;
	
	//医生等级
	private Integer doctorLevel;
	
	//医生编号
	private Long doctorId;
	
	public String sql;
	
	/**
	 * 统计结果类型。1：一年随访结果,2：一年末次有效随访结果
	 */
	private Integer statisticResultType;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String[] getStatisticType() {
		return statisticType;
	}

	public void setStatisticType(String[] statisticType) {
		this.statisticType = statisticType;
	}

	public Integer getDoctorLevel() {
		return doctorLevel;
	}

	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getStatisticResultType() {
		return statisticResultType;
	}

	public void setStatisticResultType(Integer statisticResultType) {
		this.statisticResultType = statisticResultType;
	}

	public String getSql() {
		return sql;
	}
	
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>SurvivalRate.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月6日下午6:05:24<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.List;

/** 
* @ClassName: SurvivalRate
* @Description: 
* @author lichenghao
* @date 2016年4月6日 下午6:05:24  
*/
public class SurvivalRateReq {
	
	//用户Id 0表示全国
	private Long userId;
	
	//用户角色,1 医生 userId=0 该字段无效 
	private Integer userRole;
	
	//是否分病重，0：不分病重 1分病重
	private Integer wantDiseaseType;
	
	//病种类型
	private List<Integer> diseaseTypes;
	
	//类型Id
	private Integer typeId;
	
	//病种数量
	private Integer diseaseTypeNum;
	
	//医生编号
	private Long doctorId;
	//医生级别
	private Integer doctorLevel;
	
	public String sql;

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

	public Integer getWantDiseaseType() {
		return wantDiseaseType;
	}

	public void setWantDiseaseType(Integer wantDiseaseType) {
		this.wantDiseaseType = wantDiseaseType;
	}

	public List<Integer> getDiseaseTypes() {
		return diseaseTypes;
	}

	public void setDiseaseTypes(List<Integer> diseaseTypes) {
		this.diseaseTypes = diseaseTypes;
	}

	public Integer getDiseaseTypeNum() {
		return diseaseTypeNum;
	}

	public void setDiseaseTypeNum(Integer diseaseTypeNum) {
		this.diseaseTypeNum = diseaseTypeNum;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getDoctorLevel() {
		return doctorLevel;
	}

	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getSql() {
		return sql;
	}
}

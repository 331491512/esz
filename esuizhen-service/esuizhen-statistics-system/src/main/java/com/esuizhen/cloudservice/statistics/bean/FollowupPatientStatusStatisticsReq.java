package com.esuizhen.cloudservice.statistics.bean;

import java.util.List;

public class FollowupPatientStatusStatisticsReq {
	/**
	 * 统计类型。
	 * 1.	tumorStatus肿瘤性质分布
	 * 2.	tumourPart 肿瘤部位统计
	 * 3.	diseaseType 肿瘤病种统计
	 * 4.	department 科室统计
	 * 5.	area 地区统计
	 * 6.	age 年龄统计
	 * 7.	sex 性别统计
	 */
	private String statisticsType;
	/**
	 * 肿瘤标志
	 */
	private List<Integer> tumorFlag;
	/**
	 * 住院次数。1-首次，2-末次
	 */
	private Integer inhospitalTimes;
	/**
	 * 科别。1-入院科室，2-出院科室
	 */
	private Integer deptTypeId;
	/**
	 * 操作员
	 */
	private Long operator;
	/**
	 * 云端默认查询本医生
	 */
	private Integer deployLocation;
	/**
	 * 数据权限id
	 */
	private Integer dataId;
	/**
	 * 医生职称
	 */
	private Integer doctorLevel;
	
	/**
  	 * 门诊住院标识：1-门诊、2-住院
  	 */
  	private Integer outPatientFlag;
  	
	/**
  	 * 用户角色
  	 */
  	private Integer userRole;
  	
  	/**
	 * 医院id
	 */
	private Integer hospitalId;
	
	/**
	 * add by zhuguo
	 * @return 获取当前人下的所有患者sql
	 */
	private String powerSql;
  	
	public String getPowerSql() {
		return powerSql;
	}
	public void setPowerSql(String powerSql) {
		this.powerSql = powerSql;
	}
	public String getStatisticsType() {
		return statisticsType;
	}
	public void setStatisticsType(String statisticsType) {
		this.statisticsType = statisticsType;
	}
	public List<Integer> getTumorFlag() {
		return tumorFlag;
	}
	public void setTumorFlag(List<Integer> tumorFlag) {
		this.tumorFlag = tumorFlag;
	}
	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}
	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}
	public Integer getDeptTypeId() {
		return deptTypeId;
	}
	public void setDeptTypeId(Integer deptTypeId) {
		this.deptTypeId = deptTypeId;
	}
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public Integer getDeployLocation() {
		return deployLocation;
	}
	public void setDeployLocation(Integer deployLocation) {
		this.deployLocation = deployLocation;
	}
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public Integer getDoctorLevel() {
		return doctorLevel;
	}
	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}
	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}
	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
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
	@Override
	public String toString() {
		return "FollowupPatientStatusStatisticsReq [statisticsType="
				+ statisticsType + ", tumorFlag=" + tumorFlag
				+ ", inhospitalTimes=" + inhospitalTimes + ", deptTypeId="
				+ deptTypeId + ", operator=" + operator + ", deployLocation="
				+ deployLocation + ", dataId=" + dataId + ", doctorLevel="
				+ doctorLevel + ", outPatientFlag=" + outPatientFlag + "]";
	}
}

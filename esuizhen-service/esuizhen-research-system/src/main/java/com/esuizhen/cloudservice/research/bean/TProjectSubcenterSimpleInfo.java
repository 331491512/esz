package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;

/** 
* @ClassName: TProjectSubcenterSimpleInfo 
* @Description: 分中心简要信息
* @author YYCHEN
* @date 2016年04月05日 下午17:14:01  
*/
public class TProjectSubcenterSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long subcenterId;
	//分中心名称
	private String subcenterName;
	//分中心负责人
	private String subcenterDirector;
	//医院名称
	private String hospitalName;
	//科室名称
	private String deptName;
	
	public String getSubcenterName() {
		return subcenterName;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public void setSubcenterName(String subcenterName) {
		this.subcenterName = subcenterName;
	}
	public String getSubcenterDirector() {
		return subcenterDirector;
	}
	public void setSubcenterDirector(String subcenterDirector) {
		this.subcenterDirector = subcenterDirector;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}

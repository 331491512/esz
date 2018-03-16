/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.model<br/>  
 * <b>文件名：</b>HospitalDoctor.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日-上午11:55:06<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: HospitalDoctor 
* @Description: 医生医院科室关系表
* @author huangdongxing
* @date 2015年12月15日 上午11:55:06  
*/
public class HospitalDoctor implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 医生编号
	 */
	private Long doctorId;
	/**
	 * 医院编号
	 */
	private Integer hospitalId;
    /**
     * 科室编号
     */
	private Integer deptId;
	/**
	 * 职务
	 */
	private Integer positionTitle;
	
	/**
	 * 员工号
	 */
	private String staffNo;
	/**
	 * 医院名称
	 */
	private String hospitalName;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getPositionTitle() {
		return positionTitle;
	}
	public void setPositionTitle(Integer positionTitle) {
		this.positionTitle = positionTitle;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** 
	* @return hospitalName 
	*/
	public String getHospitalName() {
		return hospitalName;
	}
	/** 
	* @param hospitalName 要设置的 hospitalName 
	*/
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.model<br/>  
 * <b>文件名：</b>SubdeptDoctor.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日-下午1:26:09<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: SubdeptDoctor 
* @Description: 医生子科室关系表
* @author YYCHEN
* @date 2015年12月15日 下午1:26:09  
*/
public class SubdeptDoctor implements Serializable {
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
	 * 科室编号
	 */
	private Integer deptId;
	/**
	 * 子科室编号
	 */
	private Long subDeptId;
	/**
	 * 职务
	 */
	private Integer positionTitle;
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

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Long getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(Long subDeptId) {
		this.subDeptId = subDeptId;
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

}

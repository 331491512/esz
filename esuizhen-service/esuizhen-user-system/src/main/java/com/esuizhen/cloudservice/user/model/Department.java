/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>DeviceInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-上午11:54:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: DeviceInfo 
* @Description: 科室bean
* @author YYCHEN
* @date 2015年12月14日 下午14:54:01  
*/
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long deptId;
	private Long hospitalId;
	private String deptName;
	private int level;
	private String tel;
	private String introduction;
	private Date createTime;
	private Date updateTime;
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

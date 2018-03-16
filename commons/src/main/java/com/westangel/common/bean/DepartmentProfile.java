package com.westangel.common.bean;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: DepartmentProfile 
* @Description: 科室详细信息bean
* @author YYCHEN
* @date 2015年12月23日 上午11:00:33  
*/
public class DepartmentProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer deptId;
	private Integer hospitalId;
	private String deptName;
	private Integer level;
	private String tel;
	private String introduction;
	private Long creator;
	private String creatorName;
	private Integer parentId;
	private List<SubDeptProfile> subDeptList;
	
	public List<SubDeptProfile> getSubDeptList() {
		return subDeptList;
	}
	public void setSubDeptList(List<SubDeptProfile> subDeptList) {
		this.subDeptList = subDeptList;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
}

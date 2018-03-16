package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: SubDeptProfile 
* @Description: 子科室信息bean
* @author YYCHEN
* @date 2015年12月28日 上午11:22  
*/
public class SubDeptProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer subDeptId;
	private Integer deptId;
	private String subDeptName;
	private Integer level;
	private String tel;
	private String introduction;
	
	public Integer getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(Integer subDeptId) {
		this.subDeptId = subDeptId;
	}
	public String getSubDeptName() {
		return subDeptName;
	}
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
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
	/** 
	* @return deptId 
	*/
	public Integer getDeptId() {
		return deptId;
	}
	/** 
	* @param deptId 要设置的 deptId 
	*/
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
}

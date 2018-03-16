package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 科室详细信息
 * @author YYCHEN
 *
 */
public class TDepartmentProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer deptId;
	private Integer hospitalId;
	private String deptName;
	private Integer level;
	private String tel;
	private String introduction;
	private List<TSubDeptProfile> subDeptList;
	
	/**
	 * @return the deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the hospitalId
	 */
	public Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the subDeptList
	 */
	public List<TSubDeptProfile> getSubDeptList() {
		return subDeptList;
	}

	/**
	 * @param subDeptList the subDeptList to set
	 */
	public void setSubDeptList(List<TSubDeptProfile> subDeptList) {
		this.subDeptList = subDeptList;
	}
}

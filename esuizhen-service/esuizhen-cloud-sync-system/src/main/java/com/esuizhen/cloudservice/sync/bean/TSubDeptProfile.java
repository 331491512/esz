package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;

/**
 * 子科室信息
 * @author YYCHEN
 *
 */
public class TSubDeptProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer subDeptId;
	private String subDeptName;
	private Integer level;
	private String tel;
	private String introduction;
	
	/**
	 * @return the subDeptId
	 */
	public Integer getSubDeptId() {
		return subDeptId;
	}

	/**
	 * @param subDeptId the subDeptId to set
	 */
	public void setSubDeptId(Integer subDeptId) {
		this.subDeptId = subDeptId;
	}

	/**
	 * @return the subDeptName
	 */
	public String getSubDeptName() {
		return subDeptName;
	}

	/**
	 * @param subDeptName the subDeptName to set
	 */
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
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
}

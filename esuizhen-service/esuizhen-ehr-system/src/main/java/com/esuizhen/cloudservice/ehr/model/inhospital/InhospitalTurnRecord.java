package com.esuizhen.cloudservice.ehr.model.inhospital;

import java.util.Date;

/**
 * 住院转科记录
 * 
 * @author zhuguo
 * @date 2017-10-09 17:54:58
 *
 */
public class InhospitalTurnRecord {

	// 主键
	private int turnId;

	// 患者id
	private String patientId;

	// 医院id
	private String inhospitalId;

	// 入科室编码
	private String inDeptCode;

	// 入科室名称
	private String inDeptName;

	// 出科室编码
	private String outDeptCode;

	// 出科室名称
	private String outDeptName;

	// 转科时间
	private Date turnDate;
	
	// 删除标识
	private int actionFlag;

	public int getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(int actionFlag) {
		this.actionFlag = actionFlag;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public int getTurnId() {
		return turnId;
	}

	public void setTurnId(int turnId) {
		this.turnId = turnId;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getInDeptCode() {
		return inDeptCode;
	}

	public void setInDeptCode(String inDeptCode) {
		this.inDeptCode = inDeptCode;
	}

	public String getInDeptName() {
		return inDeptName;
	}

	public void setInDeptName(String inDeptName) {
		this.inDeptName = inDeptName;
	}

	public String getOutDeptCode() {
		return outDeptCode;
	}

	public void setOutDeptCode(String outDeptCode) {
		this.outDeptCode = outDeptCode;
	}

	public String getOutDeptName() {
		return outDeptName;
	}

	public void setOutDeptName(String outDeptName) {
		this.outDeptName = outDeptName;
	}

	public Date getTurnDate() {
		return turnDate;
	}

	public void setTurnDate(Date turnDate) {
		this.turnDate = turnDate;
	}

}

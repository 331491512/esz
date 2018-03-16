package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.Date;

import com.westangel.common.bean.Page;

public class TDailyGainPatient implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Date date;
	//新增患者例数
	private Integer addTotalNum;
	//更新患者例数
	private Integer updateTotalNum;
	//新增住院记录数
	private Integer addInhospitalTotalNum;
	//新增门诊记录数
	private Integer addOutpatientTotalNum;
	//新增手机号患者例数
	private Integer addHasPhoneNoTotalNum;
	//新增诊断患者列数
	private Integer addDiagnosisTotalNum;
	//新增数据患者例数
	private Integer addSurgeryTotalNum;
	//新增出院患者列数
	private Integer addOuthospitalTotalNum;
	//
	private Page<TDailyGainPatient> everyDayPatientList;
	
	public Page<TDailyGainPatient> getEveryDayPatientList() {
		return everyDayPatientList;
	}
	public void setEveryDayPatientList(Page<TDailyGainPatient> everyDayPatientList) {
		this.everyDayPatientList = everyDayPatientList;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getAddTotalNum() {
		return addTotalNum;
	}
	public void setAddTotalNum(Integer addTotalNum) {
		this.addTotalNum = addTotalNum;
	}
	public Integer getUpdateTotalNum() {
		return updateTotalNum;
	}
	public void setUpdateTotalNum(Integer updateTotalNum) {
		this.updateTotalNum = updateTotalNum;
	}
	public Integer getAddInhospitalTotalNum() {
		return addInhospitalTotalNum;
	}
	public void setAddInhospitalTotalNum(Integer addInhospitalTotalNum) {
		this.addInhospitalTotalNum = addInhospitalTotalNum;
	}
	public Integer getAddOutpatientTotalNum() {
		return addOutpatientTotalNum;
	}
	public void setAddOutpatientTotalNum(Integer addOutpatientTotalNum) {
		this.addOutpatientTotalNum = addOutpatientTotalNum;
	}
	public Integer getAddHasPhoneNoTotalNum() {
		return addHasPhoneNoTotalNum;
	}
	public void setAddHasPhoneNoTotalNum(Integer addHasPhoneNoTotalNum) {
		this.addHasPhoneNoTotalNum = addHasPhoneNoTotalNum;
	}
	public Integer getAddDiagnosisTotalNum() {
		return addDiagnosisTotalNum;
	}
	public void setAddDiagnosisTotalNum(Integer addDiagnosisTotalNum) {
		this.addDiagnosisTotalNum = addDiagnosisTotalNum;
	}
	public Integer getAddSurgeryTotalNum() {
		return addSurgeryTotalNum;
	}
	public void setAddSurgeryTotalNum(Integer addSurgeryTotalNum) {
		this.addSurgeryTotalNum = addSurgeryTotalNum;
	}
	public Integer getAddOuthospitalTotalNum() {
		return addOuthospitalTotalNum;
	}
	public void setAddOuthospitalTotalNum(Integer addOuthospitalTotalNum) {
		this.addOuthospitalTotalNum = addOuthospitalTotalNum;
	}
}

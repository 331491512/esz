/**
 * 
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.List;

/**
 * @author bigdragon
 * @date 2016/8/5
 */
public class TFollowupTaskListByLeaderQueryReq {

	Long userId;
	String operatorName; //"随访人员姓名",
	String taskName;    //任务名称",
	
	String patientNo ;  //病案号",
	String patientTrueName; //"患者姓名",
	String patientPhone; //患者电话",
	
	List<Integer> states;      //状态
	Integer reqFlag;    //请求标识.0: 未结束；2：已结束
	Integer page;       //分页索引
	Integer num;        //每页个数
	
	// 权限控制使用 add by zhuguo
	String sql;
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public TFollowupTaskListByLeaderQueryReq(){
		page = 0;
		num = 10;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	

	public List<Integer> getStates() {
		return states;
	}

	public void setStates(List<Integer> states) {
		this.states = states;
	}

	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientTrueName() {
		return patientTrueName;
	}

	public void setPatientTrueName(String patientTrueName) {
		this.patientTrueName = patientTrueName;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
}

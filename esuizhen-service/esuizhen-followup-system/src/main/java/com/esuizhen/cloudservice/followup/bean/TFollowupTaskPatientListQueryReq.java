/**
 * 
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DaLoong
 * @date 2016-8-9 下午7:24:43
 */
public class TFollowupTaskPatientListQueryReq {

	String taskId; // 任务Id
	String assignId; // 分配Id
	String patientNo; // 病案号
	String patientTrueName; // 姓名
	String sourceDiagnosis;
	String phone;
	// Integer followupResultValue;
	// Integer state;
	List<Integer> followupResultValue = new ArrayList<Integer>();
	List<Integer> state = new ArrayList<Integer>();
	Integer page;
	Integer num;
	// 261需求
	/**
	 * 导出模版名称
	 */
	private String exportTemplateId;
	public String outFilePath;
	private String sqlWhere;
	
	private String nationIdStr;
	private String sourceDiseaseTypeIdStr;
	/**
	 * @return the taskId
	 */

	public TFollowupTaskPatientListQueryReq() {

		page = 0;
		num = 10;
	}

	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the assignId
	 */
	public String getAssignId() {
		return assignId;
	}

	/**
	 * @param assignId
	 *            the assignId to set
	 */
	public void setAssignId(String assignId) {
		this.assignId = assignId;
	}

	/**
	 * @return the patientNo
	 */
	public String getPatientNo() {
		return patientNo;
	}

	/**
	 * @param patientNo
	 *            the patientNo to set
	 */
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return the patientTrueName
	 */
	public String getPatientTrueName() {
		return patientTrueName;
	}

	/**
	 * @param patientTrueName
	 *            the patientTrueName to
	 *            set
	 */
	public void setPatientTrueName(String patientTrueName) {
		this.patientTrueName = patientTrueName;
	}

	/**
	 * @return the sourceDiagnosis
	 */
	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	/**
	 * @param sourceDiagnosis
	 *            the sourceDiagnosis to
	 *            set
	 */
	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// /**
	// * @return the followupResultValue
	// */
	// public Integer
	// getFollowupResultValue() {
	// return followupResultValue;
	// }
	//
	// /**
	// * @param followupResultValue
	// * the
	// * followupResultValue to
	// * set
	// */
	// public void
	// setFollowupResultValue(Integer
	// followupResultValue) {
	// this.followupResultValue =
	// followupResultValue;
	// }
	//
	// /**
	// * @return the state
	// */
	// public Integer getState() {
	// return state;
	// }
	//
	// /**
	// * @param state
	// * the state to set
	// */
	// public void setState(Integer
	// state) {
	// this.state = state;
	// }

	public List<Integer> getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(List<Integer> followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public List<Integer> getState() {
		return state;
	}

	public void setState(List<Integer> state) {
		this.state = state;
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	public String getExportTemplateId() {
		return exportTemplateId;
	}

	public void setExportTemplateId(String exportTemplateId) {
		this.exportTemplateId = exportTemplateId;
	}

	public String getSqlWhere() {
		return sqlWhere;
	}

	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}

	public String getNationIdStr() {
		return nationIdStr;
	}

	public void setNationIdStr(String nationIdStr) {
		this.nationIdStr = nationIdStr;
	}

	public String getSourceDiseaseTypeIdStr() {
		return sourceDiseaseTypeIdStr;
	}

	public void setSourceDiseaseTypeIdStr(String sourceDiseaseTypeIdStr) {
		this.sourceDiseaseTypeIdStr = sourceDiseaseTypeIdStr;
	}

}

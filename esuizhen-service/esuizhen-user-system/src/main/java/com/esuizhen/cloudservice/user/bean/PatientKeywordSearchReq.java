/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>PasswdModifyReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月8日-上午11:00:33<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: PatientKeywordSearchReq 
* @Description: 模糊查询某个医生的病人,请求条件bean
* @author YYCHEN
* @date 2015年12月15日 下午15:00:33  
*/
public class PatientKeywordSearchReq implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 医生ID
	 */
	private Long doctorId;
	/**
	 * 关键字
	 */
	private String keyword;
	/**
	 * 请求标识
	 */
	private Integer reqFlag;
	
	/**
	 * 最小年龄
	 */
	private Integer minAge;
	
	/**
	 * 最大年龄
	 */
	private Integer maxAge;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 确诊时间
	 */
	private Integer confirmedDateMonth;
	
	/**
	 * 最小确诊时间
	 */
	private Date minConfirmedDate;
	
	/**
	 * 最大确诊时间
	 */
	private Date maxConfirmedDate;
	
	/**
	 * 病种
	 */
	private Integer diseaseTypeId;
	
	/**
	 * 诊断
	 */
	private String diagnosis;
	
	/**
	 * 治疗方式
	 */
	private List<Integer> treatmentTypeIds;
	
	/**
	 * 诊断分期Id
	 */
	private List<Integer> disagnosisPeriodizationIds;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getReqFlag() {
		return reqFlag;
	}

	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getConfirmedDateMonth() {
		return confirmedDateMonth;
	}

	public void setConfirmedDateMonth(Integer confirmedDateMonth) {
		this.confirmedDateMonth = confirmedDateMonth;
	}

	public Date getMinConfirmedDate() {
		return minConfirmedDate;
	}

	public void setMinConfirmedDate(Date minConfirmedDate) {
		this.minConfirmedDate = minConfirmedDate;
	}

	public Date getMaxConfirmedDate() {
		return maxConfirmedDate;
	}

	public void setMaxConfirmedDate(Date maxConfirmedDate) {
		this.maxConfirmedDate = maxConfirmedDate;
	}

	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public List<Integer> getTreatmentTypeIds() {
		return treatmentTypeIds;
	}

	public void setTreatmentTypeIds(List<Integer> treatmentTypeIds) {
		this.treatmentTypeIds = treatmentTypeIds;
	}

	public List<Integer> getDisagnosisPeriodizationIds() {
		return disagnosisPeriodizationIds;
	}

	public void setDisagnosisPeriodizationIds(List<Integer> disagnosisPeriodizationIds) {
		this.disagnosisPeriodizationIds = disagnosisPeriodizationIds;
	}
}

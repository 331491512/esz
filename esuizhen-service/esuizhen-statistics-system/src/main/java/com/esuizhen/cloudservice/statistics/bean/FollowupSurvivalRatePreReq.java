/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>FollowupSurvivalReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月12日下午3:26:01<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.westangel.common.bean.search.RetrievalParamentReq;

/** 
* @ClassName: FollowupSurvivalReq
* @Description: 
* @author lichenghao
* @date 2016年8月12日 下午3:26:01  
*/
public class FollowupSurvivalRatePreReq {
	//session
	public HttpSession session;
	//操作者
	private Long operator;
	//操作者角色
	private Integer userRole;
	//统计类型 1：分出院科室 2：分病种 3：区分首诊医生 4：高级检索
	private Integer staticType;
	//科室编号
	private Integer deptId;
	private List<Integer> deptIds;
	//出院科室 0：末次 1：首次
	private Integer outHospitalSort;
	//病种编号
	private Integer diseaseTypeId;
	private List<Integer> diseaseTypeIds;
	//医生编号
	private Integer doctorId;
	private List<Integer> doctorIds;
	//随访方式
	private Integer followupWay;
	//起始确诊时间
	private Date confirmedDateStart;
	//截止确诊时间
	private Date confirmedDateEnd;
	//起始出院日期
	private Date outHospitalDateStart;
	//截止出院日期
	private Date outHospitalDateEnd;
	//起始随访日期
	//private Date followupDateStart;
	//截止随访日期
	//private Date followupDateEnd;
	//高级检索
	private List<RetrievalParamentReq> paraments;
	//sql 用于高级检索
	public String sql;
	// 权限sql
	private String privilegeSql;
	//用于缓存
	public Integer searchId;
	//患者中间表名称
	public String searchTableName;
	//患者中间表列
	public String searchColumn;
	//无需处理非肿瘤疾病患者
	public Integer cancerFilterFlag;
	//查询病种类型 
	public String sourceTumorFlags;
	//是否包含死亡患者
	public Integer reqFlag=0;
	//随访范围
	public Integer followupRangeFlag;
	//子条件
	public FollowupSurvivalRatePreSubReq subReq;
	/**
	 * 治疗方式集合
	 */
	private List<Integer> treatmentTypeIds;
	
	/**
	 * 治疗方式统计结果。1-治疗方式单项统计，2-术放化组合统计
	 */
	private Integer treatmentTypeStatisticsResult;
	
	/**
	 * 数据权限
	 */
	private Integer dataId;
	
	/**
	 * 云端默认查询本医生
	 */
	private Integer deployLocation;
	/**
	 * 医生职称
	 */
	private Integer doctorLevel;
	
	/**
  	 * 门诊住院标识：1-门诊、2-住院
  	 */
  	private Integer outPatientFlag;
	
  	
  	
	public String getPrivilegeSql() {
		return privilegeSql;
	}
	public void setPrivilegeSql(String privilegeSql) {
		this.privilegeSql = privilegeSql;
	}
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public Integer getStaticType() {
		return staticType;
	}
	public void setStaticType(Integer staticType) {
		this.staticType = staticType;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getOutHospitalSort() {
		return outHospitalSort;
	}
	public void setOutHospitalSort(Integer outHospitalSort) {
		this.outHospitalSort = outHospitalSort;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getFollowupWay() {
		return followupWay;
	}
	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}
	public Date getConfirmedDateStart() {
		return confirmedDateStart;
	}
	public void setConfirmedDateStart(Date confirmedDateStart) {
		this.confirmedDateStart = confirmedDateStart;
	}
	public Date getConfirmedDateEnd() {
		return confirmedDateEnd;
	}
	public void setConfirmedDateEnd(Date confirmedDateEnd) {
		this.confirmedDateEnd = confirmedDateEnd;
	}
	public Date getOutHospitalDateStart() {
		return outHospitalDateStart;
	}
	public void setOutHospitalDateStart(Date outHospitalDateStart) {
		this.outHospitalDateStart = outHospitalDateStart;
	}
	public Date getOutHospitalDateEnd() {
		return outHospitalDateEnd;
	}
	public void setOutHospitalDateEnd(Date outHospitalDateEnd) {
		this.outHospitalDateEnd = outHospitalDateEnd;
	}
	public List<RetrievalParamentReq> getParaments() {
		return paraments;
	}
	public void setParaments(List<RetrievalParamentReq> paraments) {
		this.paraments = paraments;
	}
	public String getSql() {
		return sql;
	}
	public Integer getSearchId(){
		return searchId;
	}
	public String getSearchTableName() {
		return searchTableName;
	}
	public List<Integer> getDeptIds() {
		return deptIds;
	}
	public void setDeptIds(List<Integer> deptIds) {
		this.deptIds = deptIds;
	}
	public List<Integer> getDiseaseTypeIds() {
		return diseaseTypeIds;
	}
	public void setDiseaseTypeIds(List<Integer> diseaseTypeIds) {
		this.diseaseTypeIds = diseaseTypeIds;
	}
	public List<Integer> getDoctorIds() {
		return doctorIds;
	}
	public void setDoctorIds(List<Integer> doctorIds) {
		this.doctorIds = doctorIds;
	}
	public String getSearchColumn() {
		return searchColumn;
	}
	public Integer getCancerFilterFlag() {
		return cancerFilterFlag;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	public FollowupSurvivalRatePreSubReq getSubReq() {
		return subReq;
	}
	public void setSubReq(FollowupSurvivalRatePreSubReq subReq) {
		this.subReq = subReq;
	}
	public String getSourceTumorFlags() {
		return sourceTumorFlags;
	}
	public Integer getFollowupRangeFlag() {
		return followupRangeFlag;
	}
	public List<Integer> getTreatmentTypeIds() {
		return treatmentTypeIds;
	}
	public void setTreatmentTypeIds(List<Integer> treatmentTypeIds) {
		this.treatmentTypeIds = treatmentTypeIds;
	}
	public Integer getTreatmentTypeStatisticsResult() {
		return treatmentTypeStatisticsResult;
	}
	public void setTreatmentTypeStatisticsResult(
			Integer treatmentTypeStatisticsResult) {
		this.treatmentTypeStatisticsResult = treatmentTypeStatisticsResult;
	}
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public Integer getDeployLocation() {
		return deployLocation;
	}
	public void setDeployLocation(Integer deployLocation) {
		this.deployLocation = deployLocation;
	}
	public Integer getDoctorLevel() {
		return doctorLevel;
	}
	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}
	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}
	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}
	
}

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>FollowupTaskPatientReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午8:19:59<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;
import java.util.List;

/** 
* @ClassName: FollowupTaskPatientReq
* @Description: 
* @author lichenghao
* @date 2016年8月8日 上午8:19:59  
*/
public class FollowupTaskPatientReq {
	public FollowupTaskPatientReq(){
		this.page = 0;
		this.num = 10;
	}
	
	//查询Id
	private Integer searchId;
	//查询中间表
	private String searchTableName;
	//查询列
	private String searchColumn;
	//操作人
	private Long operator;
	//高级检索生成语句
	private String sql;
	//病种
	private Integer diseaseTypeId;
	//多病种
	private List<Integer> diseaseTypeIds;
	//确诊起始时间
	private Date confirmedDateStart;
	//确诊结束时间
	private Date confirmedDateEnd;
	//随访周期
	private Integer followupCycle;
	//是否展示无联系方式的患者
	private Integer needContactFlag;
	//最近随访人员
	private List<Long> latestOperator;
	//导入的病案号
	private List<String> patientNos;
	//导入的源病案号
	private List<String> originalPatientNos;
	//性别
	private List<Integer> sex;
	//地域编码
	private List<String> cityCode;
	
	//治疗方式集合
	private List<Integer> treatmentTypeIds;
	
	//诊断名称集合
	private List<String> diagnosisNames;

	//诊断编码集合
	private List<String> diagnosisCodes;
	
	//病理诊断名称集合
	private List<String> pathologyDiagnosisNames;
	
	//病理诊断编码集合
	private List<String> pathologyDiagnosisCodes;
	
	//确诊起始年龄
	private Integer confirmeAgeStart;
	
	//确诊结束年龄
	private Integer confirmeAgeEnd;
	
	//出院科室
	private List<Integer> outHospitalDept;
	
	//出院科室次数
	private Integer outHospitalDeptTimes;
	
	//入院时间起始时间
	private Date inHospitalDateStart;
	
	//入院时间截止时间
	private Date inHospitalDateEnd;
	
	//入院次数 0或null任意次 1首次 -1 末次
	private Integer inHospitalTimes;
	
	//出院时间起始时间
	private Date outHospitalDateStart;
	
	//出院时间结束时间
	private Date outHospitalDateEnd;
	
	//出院次数 0或null任意次 1首次 -1 末次
	private Integer outHospitalTimes;
	
	//无需处理非肿瘤
	private Integer cancerFilterFlag;
	//病种类型
	private String sourceTumorFlags;
	//随访范围:(1-应随访患者，2-不随访患者,前端传递过来的值)
	private Integer followupRangeFlag;
	
	private String privilegeSql;
	
	public String getPrivilegeSql() {
		return privilegeSql;
	}

	public void setPrivilegeSql(String privilegeSql) {
		this.privilegeSql = privilegeSql;
	}

	//261需求
	/**
	 * 起始出生日期
	 */
	private Date birthDateStart;
	/**
	 * 终止出生日期
	 */
	private Date birthDateEnd;
	/**
	 * 入院科室
	 */
	private List<Integer> inhospitalDeptId;
	/**
	 * 随访结果
	 */
	private List<Integer> followupResultValue;
	/**
	 * 起始随访时间
	 */
	private Date followupTimeStart;
	/**
	 * 终止随访时间
	 */
	private Date followupTimeEnd;
	/**
	 * 随访次数：1-首次，-1-末次
	 */
	private Integer followupTimes;
	/**
	 * 患者姓名
	 */
	private String trueName;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 病案号
	 */
	private String patientNo;
	
	/**
	 * 入院科室次数：1-首次，-1-末次
	 */
	private Integer inhospitalDeptTimes;
	
	//地域编码
	private List<Integer> cityId;
	
	private Integer page;
	private Integer num;

	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
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

	public Integer getFollowupCycle() {
		return followupCycle;
	}

	public void setFollowupCycle(Integer followupCycle) {
		this.followupCycle = followupCycle;
	}

	public Integer getNeedContactFlag() {
		return needContactFlag;
	}

	public void setNeedContactFlag(Integer needContactFlag) {
		this.needContactFlag = needContactFlag;
	}

	public List<Integer> getSex() {
		return sex;
	}

	public void setSex(List<Integer> sex) {
		this.sex = sex;
	}

	public List<String> getCityCode() {
		return cityCode;
	}

	public void setCityCode(List<String> cityCode) {
		this.cityCode = cityCode;
	}

	public List<Integer> getTreatmentTypeIds() {
		return treatmentTypeIds;
	}

	public void setTreatmentTypeIds(List<Integer> treatmentTypeIds) {
		this.treatmentTypeIds = treatmentTypeIds;
	}

	public List<String> getDiagnosisNames() {
		return diagnosisNames;
	}

	public void setDiagnosisNames(List<String> diagnosisNames) {
		this.diagnosisNames = diagnosisNames;
	}

	public List<String> getDiagnosisCodes() {
		return diagnosisCodes;
	}

	public void setDiagnosisCodes(List<String> diagnosisCodes) {
		this.diagnosisCodes = diagnosisCodes;
	}

	public List<String> getPathologyDiagnosisNames() {
		return pathologyDiagnosisNames;
	}

	public void setPathologyDiagnosisNames(List<String> pathologyDiagnosisNames) {
		this.pathologyDiagnosisNames = pathologyDiagnosisNames;
	}

	public List<String> getPathologyDiagnosisCodes() {
		return pathologyDiagnosisCodes;
	}

	public void setPathologyDiagnosisCodes(List<String> pathologyDiagnosisCodes) {
		this.pathologyDiagnosisCodes = pathologyDiagnosisCodes;
	}

	public Integer getConfirmeAgeStart() {
		return confirmeAgeStart;
	}

	public void setConfirmeAgeStart(Integer confirmeAgeStart) {
		this.confirmeAgeStart = confirmeAgeStart;
	}

	public Integer getConfirmeAgeEnd() {
		return confirmeAgeEnd;
	}

	public void setConfirmeAgeEnd(Integer confirmeAgeEnd) {
		this.confirmeAgeEnd = confirmeAgeEnd;
	}

	public List<Integer> getOutHospitalDept() {
		return outHospitalDept;
	}

	public void setOutHospitalDept(List<Integer> outHospitalDept) {
		this.outHospitalDept = outHospitalDept;
	}

	public Date getInHospitalDateStart() {
		return inHospitalDateStart;
	}

	public void setInHospitalDateStart(Date inHospitalDateStart) {
		this.inHospitalDateStart = inHospitalDateStart;
	}

	public Date getInHospitalDateEnd() {
		return inHospitalDateEnd;
	}

	public void setInHospitalDateEnd(Date inHospitalDateEnd) {
		this.inHospitalDateEnd = inHospitalDateEnd;
	}

	public Integer getInHospitalTimes() {
		return inHospitalTimes;
	}

	public void setInHospitalTimes(Integer inHospitalTimes) {
		this.inHospitalTimes = inHospitalTimes;
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

	public Integer getOutHospitalTimes() {
		return outHospitalTimes;
	}

	public void setOutHospitalTimes(Integer outHospitalTimes) {
		this.outHospitalTimes = outHospitalTimes;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public List<String> getPatientNos() {
		return patientNos;
	}

	public void setPatientNos(List<String> patientNos) {
		this.patientNos = patientNos;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getSearchTableName() {
		return searchTableName;
	}

	public void setSearchTableName(String searchTableName) {
		this.searchTableName = searchTableName;
	}

	public String getSearchColumn() {
		return searchColumn;
	}

	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}

	public Integer getCancerFilterFlag() {
		return cancerFilterFlag;
	}

	public void setCancerFilterFlag(Integer cancerFilterFlag) {
		this.cancerFilterFlag = cancerFilterFlag;
	}

	public List<String> getOriginalPatientNos() {
		return originalPatientNos;
	}

	public void setOriginalPatientNos(List<String> originalPatientNos) {
		this.originalPatientNos = originalPatientNos;
	}

	public List<Integer> getDiseaseTypeIds() {
		return diseaseTypeIds;
	}

	public void setDiseaseTypeIds(List<Integer> diseaseTypeIds) {
		this.diseaseTypeIds = diseaseTypeIds;
	}

	public List<Long> getLatestOperator() {
		return latestOperator;
	}

	public void setLatestOperator(List<Long> latestOperator) {
		this.latestOperator = latestOperator;
	}

	public String getSourceTumorFlags() {
		return sourceTumorFlags;
	}

	public void setSourceTumorFlags(String sourceTumorFlags) {
		this.sourceTumorFlags = sourceTumorFlags;
	}

	public Integer getOutHospitalDeptTimes() {
		return outHospitalDeptTimes;
	}

	public void setOutHospitalDeptTimes(Integer outHospitalDeptTimes) {
		this.outHospitalDeptTimes = outHospitalDeptTimes;
	}

	public Integer getFollowupRangeFlag() {
		return followupRangeFlag;
	}

	public void setFollowupRangeFlag(Integer followupRangeFlag) {
		this.followupRangeFlag = followupRangeFlag;
	}

	public Date getBirthDateStart() {
		return birthDateStart;
	}

	public void setBirthDateStart(Date birthDateStart) {
		this.birthDateStart = birthDateStart;
	}

	public Date getBirthDateEnd() {
		return birthDateEnd;
	}

	public void setBirthDateEnd(Date birthDateEnd) {
		this.birthDateEnd = birthDateEnd;
	}

	public List<Integer> getInhospitalDeptId() {
		return inhospitalDeptId;
	}

	public void setInhospitalDeptId(List<Integer> inhospitalDeptId) {
		this.inhospitalDeptId = inhospitalDeptId;
	}

	public List<Integer> getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(List<Integer> followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public Date getFollowupTimeStart() {
		return followupTimeStart;
	}

	public void setFollowupTimeStart(Date followupTimeStart) {
		this.followupTimeStart = followupTimeStart;
	}

	public Date getFollowupTimeEnd() {
		return followupTimeEnd;
	}

	public void setFollowupTimeEnd(Date followupTimeEnd) {
		this.followupTimeEnd = followupTimeEnd;
	}

	public Integer getFollowupTimes() {
		return followupTimes;
	}

	public void setFollowupTimes(Integer followupTimes) {
		this.followupTimes = followupTimes;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public Integer getInhospitalDeptTimes() {
		return inhospitalDeptTimes;
	}

	public void setInhospitalDeptTimes(Integer inhospitalDeptTimes) {
		this.inhospitalDeptTimes = inhospitalDeptTimes;
	}

	public List<Integer> getCityId() {
		return cityId;
	}

	public void setCityId(List<Integer> cityId) {
		this.cityId = cityId;
	}
}

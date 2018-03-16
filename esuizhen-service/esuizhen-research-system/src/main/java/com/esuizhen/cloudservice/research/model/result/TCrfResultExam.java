package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title:CrfResultGenenalPhysicalExamination</p>
 * <p>Description:患者检查结果bean</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:03:05
 */
public class TCrfResultExam implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfExamResultId;
	//结果项Id。外键。
	private String crfResultId;
	//检查父类型ID。
	private String examParentTypeId;
	//检查方式子类型ID。
	private Integer examTypeId;
	//检查项目名。如CT等
	private String examTypeName;
	//检查时间
	private Date excuteDate;
	//报告时间
	private Date reportDate;
	//检查所见
	private String examFinding;
	//检查结论
	private String examConclusion;
	//病理标本
	private Integer pathologicalSampleFlag;
	//部位编码
	private String bodyCode;
	//检查部位，如右叶。对于病理学检查，指送检标本部位。
	private String bodyPart;
	//病灶编码。
	private String nidusCode;
	//病灶
	private String nidus;
	//1:原发；2：继发
	private Integer nidusSourceFlag;
	//最长径。单位：mm   影像学检查有效
	private Float longestDiameter;
	//垂直最短径。单位：mm		影像学检查有效
	private Float shortestDiameter;
	//检查方式. 病理检查有效。
	private Integer examWay;
	//病理标本类型
	private String pathologicalSampleType;
	//标本保存机构
	private String preservationOrganization;
	//病历标本采集时间
	private Date collectionTime;
	//标本采集方式
	private String collectionWay;
	//病历编号
	private String medicalRecordNumber;
	//制片类型
	private String productionType;
	//制片类型其他描述
	private String productionTypeDescription;
	//病理组织来源
	private String pathologicalTissueOrigin;
	//排序索引
	private Integer index;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	//数据源，3：院内检查；1：患者上传
	private Integer dataSourceType;
	//数据源名称
	private String dataSourceTypeName;
	//记录发生时间
	private Date dataSourceTime;
	//病历主表ID
	private String emrId;
	//检查详情信息
	private List<TCrfResultExamDetail> examResultDetailList;
	
	//父级随访周期ID
	private String parentCrfCourseItemId;
	//父级采集项ID
	private String parentCrfObserveId;
	//父级设置项ID
	private String parentSubjectElementId;
	
	public Integer getDataSourceType() {
		return dataSourceType;
	}
	public void setDataSourceType(Integer dataSourceType) {
		this.dataSourceType = dataSourceType;
	}
	public String getDataSourceTypeName() {
		return dataSourceTypeName;
	}
	public void setDataSourceTypeName(String dataSourceTypeName) {
		this.dataSourceTypeName = dataSourceTypeName;
	}
	public Date getDataSourceTime() {
		return dataSourceTime;
	}
	public void setDataSourceTime(Date dataSourceTime) {
		this.dataSourceTime = dataSourceTime;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getParentCrfCourseItemId() {
		return parentCrfCourseItemId;
	}
	public void setParentCrfCourseItemId(String parentCrfCourseItemId) {
		this.parentCrfCourseItemId = parentCrfCourseItemId;
	}
	public String getParentCrfObserveId() {
		return parentCrfObserveId;
	}
	public void setParentCrfObserveId(String parentCrfObserveId) {
		this.parentCrfObserveId = parentCrfObserveId;
	}
	public String getParentSubjectElementId() {
		return parentSubjectElementId;
	}
	public void setParentSubjectElementId(String parentSubjectElementId) {
		this.parentSubjectElementId = parentSubjectElementId;
	}
	public List<TCrfResultExamDetail> getExamResultDetailList() {
		return examResultDetailList;
	}
	public void setExamResultDetailList(List<TCrfResultExamDetail> examResultDetailList) {
		this.examResultDetailList = examResultDetailList;
	}
	public String getCrfExamResultId() {
		return crfExamResultId;
	}
	public void setCrfExamResultId(String crfExamResultId) {
		this.crfExamResultId = crfExamResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public String getExamParentTypeId() {
		return examParentTypeId;
	}
	public void setExamParentTypeId(String examParentTypeId) {
		this.examParentTypeId = examParentTypeId;
	}
	public Integer getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(Integer examTypeId) {
		this.examTypeId = examTypeId;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public Date getExcuteDate() {
		return excuteDate;
	}
	public void setExcuteDate(Date excuteDate) {
		this.excuteDate = excuteDate;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getPreservationOrganization() {
		return preservationOrganization;
	}
	public void setPreservationOrganization(String preservationOrganization) {
		this.preservationOrganization = preservationOrganization;
	}
	public Date getCollectionTime() {
		return collectionTime;
	}
	public void setCollectionTime(Date collectionTime) {
		this.collectionTime = collectionTime;
	}
	public String getCollectionWay() {
		return collectionWay;
	}
	public void setCollectionWay(String collectionWay) {
		this.collectionWay = collectionWay;
	}
	public String getMedicalRecordNumber() {
		return medicalRecordNumber;
	}
	public void setMedicalRecordNumber(String medicalRecordNumber) {
		this.medicalRecordNumber = medicalRecordNumber;
	}
	public void setProductionType(String productionType) {
		this.productionType = productionType;
	}
	public String getExamFinding() {
		return examFinding;
	}
	public void setExamFinding(String examFinding) {
		this.examFinding = examFinding;
	}
	public String getExamConclusion() {
		return examConclusion;
	}
	public void setExamConclusion(String examConclusion) {
		this.examConclusion = examConclusion;
	}
	public Integer getPathologicalSampleFlag() {
		return pathologicalSampleFlag;
	}
	public void setPathologicalSampleFlag(Integer pathologicalSampleFlag) {
		this.pathologicalSampleFlag = pathologicalSampleFlag;
	}
	public String getBodyCode() {
		return bodyCode;
	}
	public void setBodyCode(String bodyCode) {
		this.bodyCode = bodyCode;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	public String getNidusCode() {
		return nidusCode;
	}
	public void setNidusCode(String nidusCode) {
		this.nidusCode = nidusCode;
	}
	public String getNidus() {
		return nidus;
	}
	public void setNidus(String nidus) {
		this.nidus = nidus;
	}
	public Integer getNidusSourceFlag() {
		return nidusSourceFlag;
	}
	public void setNidusSourceFlag(Integer nidusSourceFlag) {
		this.nidusSourceFlag = nidusSourceFlag;
	}
	public Float getLongestDiameter() {
		return longestDiameter;
	}
	public void setLongestDiameter(Float longestDiameter) {
		this.longestDiameter = longestDiameter;
	}
	public Float getShortestDiameter() {
		return shortestDiameter;
	}
	public void setShortestDiameter(Float shortestDiameter) {
		this.shortestDiameter = shortestDiameter;
	}
	public Integer getExamWay() {
		return examWay;
	}
	public void setExamWay(Integer examWay) {
		this.examWay = examWay;
	}
	public String getPathologicalSampleType() {
		return pathologicalSampleType;
	}
	public void setPathologicalSampleType(String pathologicalSampleType) {
		this.pathologicalSampleType = pathologicalSampleType;
	}
	public String getProductionType() {
		return productionType;
	}
	public String getProductionTypeDescription() {
		return productionTypeDescription;
	}
	public void setProductionTypeDescription(String productionTypeDescription) {
		this.productionTypeDescription = productionTypeDescription;
	}
	public String getPathologicalTissueOrigin() {
		return pathologicalTissueOrigin;
	}
	public void setPathologicalTissueOrigin(String pathologicalTissueOrigin) {
		this.pathologicalTissueOrigin = pathologicalTissueOrigin;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

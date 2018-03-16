package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;
import java.util.List;

/**
 * 
* @ClassName: TCrfResultMainInfo 
* @Description: CRF保存结果主表数据保存
* @author wang_hw
* @date 2016年5月30日 下午5:47:02 
* @param <T>
 */
public class TCrfResultMainInfo<T>{
	
	/**
	 * 观察项结果Id。主键。
	 */
	private String crfResultId;
	/**
	 * 观察项ID。
	 */
	private String crfObserveId;
	/**
	 * 观察项。三级标题。外键。meta_crf_subject_element.subjectElementId
	 */
	private String subjectElementId;
	/**
	 * 专题ID。
	 */
	private String projectId;
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 录入人doctorId
	 */
	private Long creatorId;
	/**
	 * 本随访周期起始时间
	 */
	private Date crfCourseItemTime;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	/**
	 * 发生日期
	 */
	private Date happenTime;
	
	//
	private Integer detectionTypeId;
	//
	private String detectionTypeName;
	/**
	 * crf填写结果
	 */
	private T crfResult;
	
	private Object common;
	
	private String groupId;//专题患者组ID

	/**
	 * 治疗结果名称
	 */
	private String crfResultTypeName;
	//医生ID
	private Long doctorId;
	//分中心ID
	private Long subcenterId;
	//检查时间
	private Date checkDate;
	//照片列表
	private List<TCrfResultMainInfo<Void>> photoList;
	//病历ID
	private String emrId;
	
	//病历类型 1：检查数据	2:检验数据
	private Integer medicalRecordType;
	//检查/检验类型ID
	private Integer typeId;
	//检查/检验子类型ID
	private Integer subTypeId;
	//医院ID
	private Integer hospitalId;
	//数据来源
	private Integer sourceFlag;

	//数据源类型ID，3：院内检查；1患者上传
	private Integer dataSourceType;
	//数据源类型名称
	private String dataSourceTypeName;
	//OCR识别状态
	private Integer ocrFlag;
	//图片地址
	private String picFileUrl;
	//详情页面地址
	private String url;
	
	public List<TCrfResultMainInfo<Void>> getPhotoList() {
		return photoList;
	}

	public String getUrl() {
		return url;
	}

	public Integer getDetectionTypeId() {
		return detectionTypeId;
	}

	public void setDetectionTypeId(Integer detectionTypeId) {
		this.detectionTypeId = detectionTypeId;
	}

	public String getDetectionTypeName() {
		return detectionTypeName;
	}

	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPhotoList(List<TCrfResultMainInfo<Void>> photoList) {
		this.photoList = photoList;
	}

	public String getPicFileUrl() {
		return picFileUrl;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setPicFileUrl(String picFileUrl) {
		this.picFileUrl = picFileUrl;
	}

	public Integer getOcrFlag() {
		return ocrFlag;
	}

	public void setOcrFlag(Integer ocrFlag) {
		this.ocrFlag = ocrFlag;
	}

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

	public String getEmrId() {
		return emrId;
	}

	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getMedicalRecordType() {
		return medicalRecordType;
	}

	public void setMedicalRecordType(Integer medicalRecordType) {
		this.medicalRecordType = medicalRecordType;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Object getCommon() {
		return common;
	}

	public void setCommon(Object common) {
		this.common = common;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Long getSubcenterId() {
		return subcenterId;
	}

	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}

	public void setCrfResultId(String value) {
		this.crfResultId = value;
	}
	
	public String getCrfResultId() {
		return this.crfResultId;
	}
	public void setCrfObserveId(String value) {
		this.crfObserveId = value;
	}
	
	public String getCrfObserveId() {
		return this.crfObserveId;
	}
	public void setSubjectElementId(String value) {
		this.subjectElementId = value;
	}
	
	public String getSubjectElementId() {
		return this.subjectElementId;
	}
	public void setProjectId(String value) {
		this.projectId = value;
	}
	
	public String getProjectId() {
		return this.projectId;
	}
	public void setPatientId(Long value) {
		this.patientId = value;
	}
	
	public Long getPatientId() {
		return this.patientId;
	}
	public void setCreatorId(Long value) {
		this.creatorId = value;
		this.doctorId = value;
	}
	
	public Long getCreatorId() {
		if (this.creatorId == null) {
			return this.doctorId;
		}
		return this.creatorId;
	}
	public void setCrfCourseItemTime(Date value) {
		this.crfCourseItemTime = value;
	}
	
	public Date getCrfCourseItemTime() {
		return this.crfCourseItemTime;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public Date getHappenTime()
	{
		return happenTime;
	}

	public void setHappenTime(Date happenTime)
	{
		this.happenTime = happenTime;
	}

	public T getCrfResult() {
		return crfResult;
	}

	public void setCrfResult(T crfResult) {
		this.crfResult = crfResult;
	}

	public Long getDoctorId() {
		if (this.doctorId == null) {
			return this.creatorId;
		}
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
		this.creatorId = doctorId;
	}

	public String getCrfResultTypeName()
	{
		return crfResultTypeName;
	}

	public void setCrfResultTypeName(String crfResultTypeName)
	{
		this.crfResultTypeName = crfResultTypeName;
	}
	
}

